package com.groupeisi.scolaritemono.entities;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AppUserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false , length = 150)
    private String nom;
    @Column(nullable = false , length = 200)
    private String prenom;
    @Column(unique = true, nullable = false , length = 200)
    private String email;
    @Column(nullable = false , length = 250)
    private String password;
    private  int etat;
    @ManyToMany
    private List<AppRolesEntity> appRoles;
    @OneToMany(mappedBy = "appUser")
    private List<ProduitEntity> produitEntities;
}
