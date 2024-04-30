package be.bstorm.tf_java2024_springbook.api.Validators;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;

public class BeforeTodayValidator implements ConstraintValidator<BeforeToday, ChronoLocalDate> {
    @Override
    public void initialize(BeforeToday constraintAnnotation) {
    }

    @Override
    public boolean isValid(ChronoLocalDate value, ConstraintValidatorContext constraintValidatorContext) {
        if(value == null){
            return true;
        }
        return value.isBefore(LocalDate.now());
    }
}
