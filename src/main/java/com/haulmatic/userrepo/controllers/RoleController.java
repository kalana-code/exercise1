package com.haulmatic.userrepo.controllers;

import com.haulmatic.userrepo.dto.RoleDto_Response;
import com.haulmatic.userrepo.model.RoleModel;
import com.haulmatic.userrepo.service.RoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.management.relation.Role;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/")
@Api(value="RoleRepository", description="This controller responsible for manage  roles information.")
public class RoleController {

    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }



    // create role api
    @PostMapping("/role")
    @ApiOperation(value = "Add a Role")
    ResponseEntity<RoleModel> createRole(@RequestBody RoleModel newRoleModel) {
        return  roleService.createRole(newRoleModel);
    }

    // retrieving roles api
    @ApiOperation(value = "View a list of available roles",response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
            @ApiResponse(code = 500, message = "Internal Server Error")

    })
    @GetMapping("/role")
    public ResponseEntity<List<RoleModel>> getAllRoles() {
        return roleService.retrieveRoles();
    }

    //update role api
    @ApiOperation(value = "Update a existing role's data" , response = ResponseEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully updated"),
            @ApiResponse(code = 404, message = "NOT Found a role for updating process."),
    })
    @PutMapping("/role")
    ResponseEntity<RoleModel> updateRole(@RequestBody RoleModel newRoleModel) {
       return roleService.updateRole(newRoleModel);
    }

    //delete role api
    @ApiOperation(value = "Delete a role by NIC" , response = ResponseEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully deleted a role "),
            @ApiResponse(code = 404, message = "NOT Found a role for updating process."),
            @ApiResponse(code = 500, message = "Delete Process was failed due to Internal Server Error "),
    })
    @DeleteMapping("/role/{NIC}")
    public ResponseEntity<String> removeRoleByNIC(@PathVariable Long NIC) {
        return roleService.deleteRole(NIC);
    }

    // retrieving role by NIC
    @ApiOperation(value = "Retrieving role information by NIC" , response = ResponseEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved a role information."),
            @ApiResponse(code = 404, message = "NOT Found a role for given NIC."),
            @ApiResponse(code = 500, message = "Failed due to Internal Server Error."),
    })
    @GetMapping("/role/{NIC}")
    public ResponseEntity<Optional<RoleModel>> getRoleByNIC(@PathVariable Long NIC) {
        return roleService.retrieveRoleByNIC(NIC);
    }

    // retrieving role by Role and Organization
    @ApiOperation(value = "Retrieving role information by Organization and Role" , response = ResponseEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved a role information."),
            @ApiResponse(code = 404, message = "NOT Found a role for given Organization and Role."),
            @ApiResponse(code = 500, message = "Failed due to Internal Server Error."),
    })
    @GetMapping("/role/{Organization}/{Role}")
    public ResponseEntity<List<RoleDto_Response>> getRoleByOrgAndRole(@PathVariable String Organization,@PathVariable RoleModel.ROLE Role) {
        return roleService.getRolesByOrgAndRole(Organization,Role);
    }






//

}

