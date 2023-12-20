package com.groupeisi.scolaritemono.dto;

import javax.validation.constraints.NotNull;

import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Produit {

    private int id;
    @NotNull(message = "Le nom ne doit pas etre null")
    private String nom;
    @NotNull(message = "La quantite ne doit pas etre null")
    private  double qtStock;

}
