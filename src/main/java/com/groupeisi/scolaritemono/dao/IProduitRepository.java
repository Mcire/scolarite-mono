package com.groupeisi.scolaritemono.dao;

import com.groupeisi.scolaritemono.entities.ProduitEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProduitRepository extends JpaRepository<ProduitEntity, Integer> {

}
