package com.groupeisi.scolaritemono.dao;

import com.groupeisi.scolaritemono.entities.AppRolesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAppRolesRepository extends JpaRepository<AppRolesEntity, Integer> {
    AppRolesEntity findByNom(String nom);
}
