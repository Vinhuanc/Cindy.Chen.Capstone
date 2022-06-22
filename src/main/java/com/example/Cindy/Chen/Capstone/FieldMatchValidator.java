package com.example.Cindy.Chen.Capstone;
//This class is created to validate user registration class, the main purpose is to make sure that
//the username and password both correctly matches. If it matches, the computer creates an account
//for the user, if it doesn't match, it gives an error on where it doesn't match.
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.apache.commons.beanutils.BeanUtils;

public class FieldMatchValidator implements ConstraintValidator<FieldMatch, Object> {
   private String firstFieldName;
   private String secondFieldName;

   @Override
   public void initialize(final FieldMatch constraintAnnotation) {
       firstFieldName = constraintAnnotation.first();
       secondFieldName = constraintAnnotation.second();
   }

   @Override
   public boolean isValid(final Object value, final ConstraintValidatorContext context) {
       try {
           final Object firstObj = BeanUtils.getProperty(value, firstFieldName);
           final Object secondObj = BeanUtils.getProperty(value, secondFieldName);
           return firstObj == null && secondObj == null || firstObj != null && firstObj.equals(secondObj);
       } catch (final Exception ignore) {}
       return true;
   }
}

