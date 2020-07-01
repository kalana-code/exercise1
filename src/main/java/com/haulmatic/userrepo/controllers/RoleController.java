package com.haulmatic.userrepo.controllers;

import com.haulmatic.userrepo.dto.RoleDto_Response;
import com.haulmatic.userrepo.model.RoleModel;
import com.haulmatic.userrepo.service.RoleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.management.relation.Role;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/")
public class RoleController {

    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    // create role api
    @PostMapping("/role")
    ResponseEntity<RoleModel> createRole(@RequestBody RoleModel newRoleModel) {
        return  roleService.createRole(newRoleModel);
    }

    // retrieving roles api
    @GetMapping("/role")
    public ResponseEntity<List<RoleModel>> getAllRoles() {
        return roleService.retrieveRoles();
    }

    //update role api
    @PutMapping("/role")
    ResponseEntity<RoleModel> updateRole(@RequestBody RoleModel newRoleModel) {
       return roleService.updateRole(newRoleModel);
    }

    //delete role api
    @DeleteMapping("/role/{NIC}")
    public ResponseEntity<String> removeRoleByNIC(@PathVariable Long NIC) {
        return roleService.deleteRole(NIC);
    }

    // retrieving role by NIC
    @GetMapping("/role/{NIC}")
    public ResponseEntity<Optional<RoleModel>> getRoleByNIC(@PathVariable Long NIC) {
        return roleService.retrieveRoleByNIC(NIC);
    }

    @GetMapping("/role/{Organization}/{Role}")
    public List<RoleDto_Response> getRoleByOrgAndRole(@PathVariable String Organization,@PathVariable RoleModel.ROLE Role) {
        return roleService.getRolesByOrgAndRole(Organization,Role);
    }






//

}

