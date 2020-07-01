package com.haulmatic.userrepo.service;


import com.haulmatic.userrepo.dto.RoleDto_Response;
import com.haulmatic.userrepo.model.RoleModel;
import com.haulmatic.userrepo.repository.RoleRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;


@Service
public class RoleService {

    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    // Basic CRUD Operations
    public ResponseEntity<RoleModel> createRole(RoleModel newRoleModel){
        newRoleModel.setCreatedDate(new Date());
        newRoleModel.setLastModified(new Date());
        try {
            RoleModel _role = roleRepository.save(newRoleModel);
            return new ResponseEntity<>(_role, HttpStatus.CREATED);
        } catch (Exception e) {
            System.out.println(e.toString());
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }

    public ResponseEntity<List<RoleModel>> retrieveRoles() {
        try {
            List<RoleModel> Roles = new ArrayList<RoleModel>();
            roleRepository.findAll().forEach(Roles::add);

            if (Roles.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

            return new ResponseEntity<>(Roles, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<RoleModel> updateRole(RoleModel newRoleModel){

        Optional<RoleModel> _retrievedRole = roleRepository.findByNIC(newRoleModel.getNIC());

        if (_retrievedRole.isPresent()) {
            RoleModel _role = _retrievedRole.get();
            // set new updated values with updated values
            _role.setNIC(newRoleModel.getNIC());
            _role.setLastName(newRoleModel.getLastName());
            _role.setFirstName(newRoleModel.getFirstName());
            _role.setRole(newRoleModel.getRole());
            _role.setOrganization(newRoleModel.getOrganization());

            //update modified date
            _role.setLastModified(new Date());

            return new ResponseEntity<>(roleRepository.save(_role), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<String> deleteRole(long NIC){

        try {
            roleRepository.deleteByNIC(NIC);
            return new ResponseEntity<>("Successfully Removed",HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Optional<RoleModel>> retrieveRoleByNIC(long NIC) {
        Optional<RoleModel> _role = roleRepository.findByNIC(NIC);
        if(_role.isPresent()){
            return new ResponseEntity<>(_role, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    public  ResponseEntity<List<RoleDto_Response>> getRolesByOrgAndRole(String Organization, RoleModel.ROLE Role) {
        List<RoleDto_Response> _roles = roleRepository.findAllByRoleAndOrganization(Role,Organization);
        if(_roles.isEmpty()){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }else {
            return new ResponseEntity<>(_roles, HttpStatus.OK);
        }
    }
}
