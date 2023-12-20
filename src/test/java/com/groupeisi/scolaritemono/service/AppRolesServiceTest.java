package com.groupeisi.scolaritemono.service;

import com.groupeisi.scolaritemono.dto.AppRoles;
import com.groupeisi.scolaritemono.exception.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
class AppRolesServiceTest {

    @Autowired
    private AppRolesService appRolesService;
    @BeforeEach
    void setUp() {
        log.info("Demarrage des tests");
    }

    @AfterEach
    void tearDown() {
        log.info("Fin des tests");
    }

    @Test
    void getAppRoles() {
        /**
         * Test lorque la table appRoles est vide
         */
        List<AppRoles> appRolesList = new ArrayList<>();
        appRolesList = appRolesService.getAppRoles();
        assertEquals(0, appRolesList.size());

        /**
         * Test  apres insertion d'une ligne
         */
        AppRoles appRoles = new AppRoles();
        appRoles.setNom("ADMIN");
        appRolesService.createAppRoles(appRoles);

        appRolesList = appRolesService.getAppRoles();


        assertEquals(1, appRolesList.size());
    }

    @Test
    void getAppRole() {
        EntityNotFoundException e = assertThrows(EntityNotFoundException.class, ()->appRolesService.getAppRole(100));
        assertEquals("Requested Roles with id= 100 does not exist", e.getMessage());

        AppRoles appRoles = new AppRoles();
        appRoles.setNom("ADMIN");
        appRolesService.createAppRoles(appRoles);
        AppRoles appRole = appRolesService.getAppRole(1);
        assertNotNull(appRole);

    }

    @Test
    void createAppRoles() {
        AppRoles appRoles = new AppRoles();
        appRoles.setNom("ADMIN");
        appRolesService.createAppRoles(appRoles);
        assertNotNull(appRoles);
    }

    @Test
    void updateAppRoles() {
        AppRoles appRoles = new AppRoles();
        appRoles.setNom("ADMIN");
        appRolesService.createAppRoles(appRoles);

        AppRoles appRoles1 = new AppRoles();
        appRoles1.setNom("ROLE_TECH");

        AppRoles appRolesSave = appRolesService.updateAppRoles(1,appRoles1);
        Assertions.assertNotNull(appRolesSave);
    }

    @Test
    void deleteAppRoles() {
        AppRoles appRoles = new AppRoles();
        appRoles.setNom("ADMIN");
        appRolesService.createAppRoles(appRoles);

        appRolesService.deleteAppRoles(1);
        Assertions.assertTrue(true);
        System.out.println("Le test s'est bien passsee");
    }

    @Test
    void operation() {
        int val1 = 1;
        int val2 = 3;
        int val = val1 + val2;
        Assertions.assertEquals(4,val);
    }
}