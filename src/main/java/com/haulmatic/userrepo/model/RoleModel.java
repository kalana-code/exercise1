package com.haulmatic.userrepo.model;

import com.mongodb.lang.NonNull;
import lombok.Getter;
import lombok.Setter;


import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Date;


@Getter
@Setter
@EnableMongoAuditing
@Document(collection = "role")
public class RoleModel {
    public static enum ROLE {Driver,Assistant};

    @Id
    private  String Id;

    @NonNull
    private String Organization;

    @NonNull
    private String FirstName;

    @NonNull
    private String LastName;

    @Indexed(unique=true)
    private int NIC;

    private ROLE  Role;

    @LastModifiedDate
    private  Date LastModified;

    @CreatedDate
    private   Date CreatedDate;

    public RoleModel(String Organization, String FirstName, String LastName, int NIC , ROLE Role){

        this.Organization = Organization;
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.NIC = NIC;
        this.Role= Role;
    }
}
