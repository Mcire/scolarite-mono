package com.groupeisi.scolaritemono.mapping;

import com.groupeisi.scolaritemono.dto.AppRoles;
import com.groupeisi.scolaritemono.entities.AppRolesEntity;
import org.mapstruct.Mapper;

@Mapper
public interface AppRolesMapper {
    AppRoles toAppRoles(AppRolesEntity appRolesEntity);
    AppRolesEntity fromAppRoles(AppRoles appRoles);
}

