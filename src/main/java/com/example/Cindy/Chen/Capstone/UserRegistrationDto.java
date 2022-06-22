package com.example.Cindy.Chen.Capstone;
//This class is created to gain information from the user wanted to create an account. This class
//askes the user questions of first name, last name, password, confirmed password, email, confirmed
//email, and whether they agree with the terms. If the user's input of the information matches and 
//agrees to the terms and agreement, an account will be created for that user. If the user's information
//doesn't match, an error message will pop up where the error/not-matching is. When an account is 
//created, the user's inputted information will be automatically inputted into SQL, under the "User"
//table. The @NotEmpty annotations requires the user to input the related information, and the @Email
//annotations requires the user to input a valid email, and the @AssertTrue annotation requires the 
//user to agree to the terms and agreement before creating an account. Line 44-98 are codes for getters
//and setters.
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@FieldMatch.List({
    @FieldMatch(first = "password", second = "confirmPassword", message = "The password fields must match"),
    @FieldMatch(first = "email", second = "confirmEmail", message = "The email fields must match")
})
public class UserRegistrationDto {

    @NotEmpty
    private String firstName;

    @NotEmpty
    private String lastName;

    @NotEmpty
    private String password;

    @NotEmpty
    private String confirmPassword;

    @Email
    @NotEmpty
    private String email;

    @Email
    @NotEmpty
    private String confirmEmail;

    @AssertTrue
    private Boolean terms;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getConfirmEmail() {
        return confirmEmail;
    }

    public void setConfirmEmail(String confirmEmail) {
        this.confirmEmail = confirmEmail;
    }

    public Boolean getTerms() {
        return terms;
    }

    public void setTerms(Boolean terms) {
        this.terms = terms;
    }
}
