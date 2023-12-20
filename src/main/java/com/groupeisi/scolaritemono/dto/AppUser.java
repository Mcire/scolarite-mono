package com.groupeisi.scolaritemono.dto;


import javax.validation.constraints.NotNull;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AppUser {
    private int id;
    @NotNull(message = "Le nom ne doit pas etre null")
    private String nom;
    @NotNull(message = "Le prenom ne doit pas etre null")
    private String prenom;
    @NotNull(message = "L'email ne doit pas etre null")
    private String email;
    @NotNull(message = "Le password est obligatoire donc ne doit pas etre null")
    private String password;
    @NotNull(message = "L'etat ne doit pas etre null")
    private  int etat;
}