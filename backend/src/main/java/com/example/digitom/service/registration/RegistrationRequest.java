package com.example.digitom.service.registration;

import lombok.Data;

@Data
public class RegistrationRequest {

    private String firstName;
    private String middleName;
    private String lastName;
    private String companyName;
    private String companyNumber;
    private String phoneNumber;
    private String email;
    private String password;
    private String roleName;

}
