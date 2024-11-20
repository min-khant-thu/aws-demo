package com.demo.springlocalstack.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class AgeValidator implements ConstraintValidator<ValidAge, Integer>{
    @Override
    public void initialize(ValidAge age) {
    }

    @Override
    public boolean isValid(Integer age, ConstraintValidatorContext context) {
       return (age != null) && (age >= 20 && age <=65);
    }
}
