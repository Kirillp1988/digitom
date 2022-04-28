package com.example.digitom.service.registration;

import com.example.digitom.domain.company.CompanyService;
import com.example.digitom.domain.contact.ContactService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AccountService {
    @Resource
    private ContactService contactService;
    @Resource
    private CompanyService companyService;

    public void addNewAccount(RegistrationRequest registrationRequest) {

        contactService.addNewContact(registrationRequest.getContactDto());

        companyService.addNewCompany(registrationRequest.getCompanyDto());

        userService.addNewUser(registrationRequest.getUserDto());




//        private UserDto userDto;
//        private UserRoleDto userRoleDto;


    }
}