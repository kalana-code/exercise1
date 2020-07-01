package com.haulmatic.userrepo.dto;

import com.mongodb.lang.NonNull;
import lombok.Getter;
import lombok.Setter;

import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@EnableMongoAuditing
@Document(collection = "role")
public class RoleDto_Response {

    @NonNull
    private String FirstName;

    @NonNull
    private String LastName;

    @Indexed(unique=true)
    private int NIC;

    public RoleDto_Response( String FirstName, String LastName, int NIC ){
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.NIC = NIC;
    }
}
