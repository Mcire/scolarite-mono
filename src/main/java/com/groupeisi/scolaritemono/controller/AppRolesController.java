package com.groupeisi.scolaritemono.controller;

import com.groupeisi.scolaritemono.dto.AppRoles;
import com.groupeisi.scolaritemono.service.AppRolesService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/roles")
@AllArgsConstructor
public class AppRolesController {
    private AppRolesService appRolesService;

    @GetMapping
    public List<AppRoles> getAppRoles(){
        return appRolesService.getAppRoles();
    }

    @GetMapping("/{id}")
    public AppRoles getAppRoles(@PathVariable("id") int id)
    {
        return appRolesService.getAppRole(id);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public AppRoles createAppRoles(@Valid @RequestBody AppRoles appRoles){
        return appRolesService.createAppRoles(appRoles);
    }

    @PutMapping("/{id}")
    public AppRoles updateAppRoles(@PathVariable("id") int id, @Valid @RequestBody AppRoles appRoles){
        return appRolesService.updateAppRoles(id, appRoles);
    }

    @DeleteMapping("/{id}")
    public Object deleteAppRoles(@PathVariable("id") int id){
        try {
            appRolesService.deleteAppRoles(id);
            return "Donnee supprimees";
        }catch (Exception e)
        {
            return "Donnee non supprimees";
        }

    }
}

