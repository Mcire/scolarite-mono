package com.groupeisi.scolaritemono.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AppRolesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column (unique = true , nullable = false , length = 100)
    private String nom;
    @ManyToMany(mappedBy = "appRoles")
    private List<AppUserEntity> appUser;
}

