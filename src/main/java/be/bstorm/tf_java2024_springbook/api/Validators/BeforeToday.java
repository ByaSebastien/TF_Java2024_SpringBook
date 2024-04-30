package be.bstorm.tf_java2024_springbook.api.Validators;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = BeforeTodayValidator.class)
public @interface BeforeToday {

    String message() default "Date must be before today";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
