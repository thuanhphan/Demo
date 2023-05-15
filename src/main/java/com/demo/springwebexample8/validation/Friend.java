package com.demo.springwebexample8.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({FIELD})
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = FriendValidator.class)
public @interface Friend {

    String message() default "Email does not exist";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
