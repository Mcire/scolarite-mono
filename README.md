# SCOLARITE MONO
scolarite mono is a spring boot demo application that aims to develop a hierarchical architecture. In this project we manage exceptions well while configuring the logs. It's also a docker project
## LOGS
- Ajouter les dependances pour les logs
```xml
<dependency>
    <groupId>io.zipkin.brave</groupId>
    <artifactId>brave-context-log4j2</artifactId>
    <version>5.13.7</version>
</dependency>

<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-log4j2</artifactId>
</dependency>
```
- And in the web dependency, don't forget to exclude the
   default log management
```xml
<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
			<exclusions><!--  exclusion de la gestion des logs par defaut de spring boot   -->
				<exclusion>
					<groupId>org.springframework.boot</groupId>
					<artifactId>spring-boot-starter-logging</artifactId>
				</exclusion>
			</exclusions>
</dependency>
```
- Add log4 files
<img width="274" alt="image" src="https://github.com/Mcire/scolarite-mono/assets/95756307/9386565c-487c-441c-9241-ad079222bfbe">

## DOCKER
- Add on configure docker composer file
In uses a YAML configuration file to define a set of Docker services, primarily for our MySQL database environment and a PHPMyAdmin web client. To do this we will have:
- Docker Compose version: The version of Docker Compose syntax used in this file is version 3.9.
- Services :
 1. mysql-admin-db: This service uses the MySQL version 8.0 Docker image. It creates a container named container_mysql_admin_db. It sets several environment variables like root password, database, username, password, etc. It exposes port 3306 for MySQL and uses a volume named mysql_data to store database data. A health test is also defined to check the availability of MySQL.
 2. phpmyadmin-admin-db: This service uses the PHPMyAdmin Docker image (latest version available). It creates a container named container-phpmyadmin-admindb. It exposes port 8085 on the host. Environment variables specify the root password, MySQL host, username and password for PHPMyAdmin. It depends on the mysql-admin-db service and restarts automatically unless explicitly stopped.
- Volumes:
 1. mysql_data: This volume is used by the mysql-admin-db service to store MySQL database data. It uses the local volume driver.
```xml
version: '3.9'

services:
  mysql-admin-db:
    image: mysql:8.0
    container_name: container_mysql_admin_db
    environment:
      MYSQL_ROOT_PASSWORD: root
      MYSQL_DATABASE: admin-db
      MYSQL_USER: user
      MYSQL_PASSWORD: user
      MYSQL_ROOT_HOST: '%'
      MYSQL_INITDB_SKIP_TZINFO: '1'
      MYSQL_DATABASE_STORAGE_ENGINE: InnoDB
    ports:
      - 3306:3306
    volumes:
      - mysql_data:/var/lib/mysql
    healthcheck:
      test: mysqladmin ping -h 127.0.0.1 -u $$MYSQL_USER --password=$$MYSQL_PASSWORD

  phpmyadmin-admin-db:
    container_name: container-phpmyadmin-admindb
    image: phpmyadmin/phpmyadmin:latest
    ports:
      - 8085:80
    environment:
      MYSQL_ROOT_PASSWORD: root
      PMA_HOST: mysql-admin-db
      PMA_USER: user
      PMA_PASSWORD: user
    depends_on:
      - mysql-admin-db
    restart: unless-stopped

volumes:
  mysql_data:
    driver: local
```

## CONFIGURE FILE APPLICATION.YML
### In this piece of code we configure:
- server: This section configures the Spring Boot embedded server settings. Here the server is configured to listen on port 8080.
### Data source configuration (MySQL database):
- spring.datasource: This section configures the data source (database) used by the Spring Boot application.
- url: The JDBC connection URL to the MySQL database. It specifies the database name (admin-db), and there are several additional settings such as automatically creating the database if it does not exist, using UTF-8 encoding, etc.
- username: The username to connect to the database.
- password: The password to connect to the database.
### Configuring Spring Boot application:
- spring.application.name: It specifies the name of the Spring Boot application. In this example, the application is named spring-admin.
### JPA (Java Persistence API) configuration:
- spring.jpa: This section configures settings specific to JPA, which is a Java API for handling relational data.
- hibernate.ddl-auto: This property tells Hibernate (the JPA implementation used by default in Spring Boot) to automatically perform database schema updates. In this example it is set to update, which means Hibernate will update the schema based on entities detected in the code.
- show-sql: This property enables the display of SQL queries generated by Hibernate in logs.
- database-platform: This property specifies the Hibernate dialect for MySQL.

```xml
server:
  port: 8080

spring:
  datasource:
    url: jdbc:mysql://localhost:3306/admin-db?createDatabaseIfNotExist=true&useUnicode=true&characterEncoding=utf-8&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC
    username: user
    password: user
  application:
    name: spring-admin

  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true
    database-platform: org.hibernate.dialect.MySQL5InnoDBDialect
```

## Run service
This command ` docker compose up -d` is used to start services defined in your Docker Compose file in detached (background) mode
<img width="478" alt="image" src="https://github.com/Mcire/scolarite-mono/assets/95756307/a19155d2-3257-43f4-aeda-2f51b6299213">

## check current services
The `docker ps` command is used to display the list of Docker containers that are currently running on your system.
<img width="955" alt="image" src="https://github.com/Mcire/scolarite-mono/assets/95756307/d255b8ea-7707-4d66-ada8-c7989469f742">

## Run mysql image
The `winpty docker exec -it 9f67 mysql -u user -p` command is used to run an interactive session (-it) inside a Docker container using the MySQL image
<img width="434" alt="image" src="https://github.com/Mcire/scolarite-mono/assets/95756307/f9296ddd-5c04-419c-993d-339d49b18403">

## Result
<img width="560" alt="image" src="https://github.com/Mcire/scolarite-mono/assets/95756307/4248cae8-48f6-4343-a11f-854f998c7754">
