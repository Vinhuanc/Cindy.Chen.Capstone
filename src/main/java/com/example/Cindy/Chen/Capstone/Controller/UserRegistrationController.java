package com.example.Cindy.Chen.Capstone.Controller;
//This class is created for user registration controlling.
import javax.validation.Valid;   
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.Cindy.Chen.Capstone.UserRegistrationDto;
import com.example.Cindy.Chen.Capstone.Entity.User;
import com.example.Cindy.Chen.Capstone.Service.UserService;


@Controller
@RequestMapping("/registration")
public class UserRegistrationController {

   @Autowired
   private UserService userService;

   @ModelAttribute("user")
   public UserRegistrationDto userRegistrationDto() {
       return new UserRegistrationDto();
   }
//This method creates and uses an model to input user information from the registration page.
   @GetMapping
   public String showRegistrationForm(Model model) {
       return "registration";
   }

//This method handles the inputted emails gained from the User's input, it the User's username and email doesn't match, it will stays at the login page and asks the user to
//reinput information. If an user is created an account successfully, then it saves the user information, and grants access to the user.   
   @PostMapping
   public String registerUserAccount(@ModelAttribute("user") @Valid UserRegistrationDto userDto, BindingResult result){

       User existing = userService.findByEmail(userDto.getEmail());
       if (existing != null){
           result.rejectValue("email", null, "There is already an account registered with that email");
       }

       if (result.hasErrors()){
           return "registration";
       }

       userService.save(userDto);
       return "redirect:/registration?success";
   }
}

