package com.groupeisi.scolaritemono.mapping;

import com.groupeisi.scolaritemono.dto.AppUser;
import com.groupeisi.scolaritemono.entities.AppUserEntity;
import org.mapstruct.Mapper;

@Mapper
public interface AppUserMapper {
    AppUser toAppUser(AppUserEntity appUserEntity);
    AppUserEntity fromAppUser( AppUser appUser);
}

