package com.demo.springwebexample8.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class FriendValidator implements ConstraintValidator<Friend, String> {
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        String query = "SELECT count(1)\n" +
                       "FROM public.user pu\n" +
                       "WHERE pu.email = :email";
        return false;
    }
}
