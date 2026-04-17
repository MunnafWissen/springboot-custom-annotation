package com.example.customannotationproject;

import com.example.customannotationproject.model.Employee;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;


public class ValidUser implements ConstraintValidator<NameValidator, Employee> {


    @Override
    public boolean isValid(Employee user, ConstraintValidatorContext context){
        if(user == null) return true;

        boolean firstNameValid = user.getFirstName()!=null && !user.getFirstName().isBlank();
        boolean middleNameValid =user.getMiddleName()!=null && !user.getMiddleName().isBlank();
        boolean lastNameValid =user.getLastName()!=null && !user.getLastName().isBlank();

        return firstNameValid && (middleNameValid || lastNameValid);

    }
}
