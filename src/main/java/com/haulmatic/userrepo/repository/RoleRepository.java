package com.haulmatic.userrepo.repository;

import com.haulmatic.userrepo.dto.RoleDto_Response;
import com.haulmatic.userrepo.model.RoleModel;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface RoleRepository extends MongoRepository<RoleModel, String> {

    void deleteByNIC(long NIC);

    Optional<RoleModel> findByNIC(long NIC);
    List<RoleDto_Response> findAllByRoleAndOrganization(String Organization, RoleModel.ROLE Role);

}