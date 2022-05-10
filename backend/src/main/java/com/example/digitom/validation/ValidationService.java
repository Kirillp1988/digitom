package com.example.digitom.validation;


import com.example.digitom.domain.user.User;
import com.example.digitom.infrastructure.exception.BusinessException;
import com.example.digitom.infrastructure.exception.DataNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ValidationService {


    public static final String EMAIL_ALREADY_TAKEN = "Email on kasutusel";
    public static final String USER_DOES_NOT_EXISTS = "Kasutajanimi või parool on vale";
    public static final String NO_COMPANY_RESPONSIBLE = "Vastutav ettevõte puudub";
    public static final String NO_DESCRIPTION = "Kirjeldus puudub";
    public static final String DEADLINE_NOT_EXISTS = "Tähtaeg puudub";
    public static final String TASKS_NOT_FOUND = "Korrastamisülesandeid ei leitud";
    public static final String FORM_NOT_FILLED = "Väli jäi täitmata";


    public void emailAlreadyExists(String email, Boolean exists) {
        if (exists) {
            throw new BusinessException(EMAIL_ALREADY_TAKEN, "Email " + email + " on juba kasutusel");
        }
    }

    public void userExist(Optional<User> user) {
        if (user.isEmpty()) {
            throw new BusinessException("Viga sisenemisel", "Sisesta õiged andmed või registreeri konto");
        }
    }

    public void companyConstructionSiteExist(String companyName, Boolean exist) {
        if (exist) {
            throw new BusinessException("Alltöövõtja " + companyName + " on juba objektile lisatud!", "Proovi uuesti!");
        }
    }

    public void taskCompanyExists(Integer companyId) {
        if (companyId == null) {
            throw new DataNotFoundException(NO_COMPANY_RESPONSIBLE, "Sisesta vastutav ettevõte!");
        }
    }

    public void checkFormCompletion(String description) {
        if (description.isEmpty()) {
            throw new DataNotFoundException(NO_DESCRIPTION, "Lisa leitud puuduse kirjeldus!");
        }
    }

    public void taskDeadlineExists(Integer deadline) {
        if (deadline == null) {
            throw new DataNotFoundException(DEADLINE_NOT_EXISTS, "Sisesta korrastamisülesande tähtaeg!");
        }
    }

    public void checkRegistrationFormCompletion(String details) {
        if (details.isEmpty()) {
            throw new DataNotFoundException(FORM_NOT_FILLED, "Palun täida kõik väljad!");
        }
    }

}
