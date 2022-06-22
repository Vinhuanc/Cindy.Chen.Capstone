package com.example.Cindy.Chen.Capstone;

import javax.validation.Payload;
import javax.validation.Constraint;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
//This interface is created for the user registration class. Its main purpose its to make sure
//that when a user registeres, the user's input username and password correctly matches.
@Target({TYPE, ANNOTATION_TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = FieldMatchValidator.class)
@Documented
public @interface FieldMatch
{
   String message() default "{constraints.field-match}";
   Class<?>[] groups() default {};
   Class<? extends Payload>[] payload() default {};
   String first();
   String second();

   @Target({TYPE, ANNOTATION_TYPE})
   @Retention(RUNTIME)
   @Documented
   @interface List
   {
       FieldMatch[] value();
   }
}

