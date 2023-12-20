package com.groupeisi.scolaritemono.mapping;

import com.groupeisi.scolaritemono.dto.Produit;
import com.groupeisi.scolaritemono.entities.ProduitEntity;
import org.mapstruct.Mapper;

@Mapper
public interface ProduitMapper {
    Produit toProduit(ProduitEntity produitEntity);
    ProduitEntity fromProduit(Produit produit);
}
