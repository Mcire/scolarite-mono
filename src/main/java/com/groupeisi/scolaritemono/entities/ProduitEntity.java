package com.groupeisi.scolaritemono.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProduitEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique = true,nullable = false , length = 200)
    private String nom;
    private  double qtStock;
    @ManyToOne
    private AppUserEntity appUser;
}
