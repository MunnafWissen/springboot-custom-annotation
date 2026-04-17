package com.example.customannotationproject;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ValidUser.class)
public @interface NameValidator {

    public String message() default "either middlename or lastName is required";

    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
