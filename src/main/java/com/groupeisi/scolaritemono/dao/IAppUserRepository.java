package com.groupeisi.scolaritemono.dao;

import com.groupeisi.scolaritemono.entities.AppUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
public interface IAppUserRepository extends JpaRepository<AppUserEntity, Integer> {
    AppUserEntity findByEmail(String email);
}

