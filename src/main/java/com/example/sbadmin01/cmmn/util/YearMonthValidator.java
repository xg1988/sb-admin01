package com.example.sbadmin01.cmmn.util;
import com.example.sbadmin01.cmmn.util.YearMonth;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class YearMonthValidator implements ConstraintValidator<YearMonth, String> {

    private String pattern;

    @Override
    public void initialize(YearMonth constraintAnnotation) {
        //ConstraintValidator.super.initialize(constraintAnnotation);

        this.pattern = constraintAnnotation.pattern();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return false;
    }
}
