package com.example.Cindy.Chen.Capstone.Controller;
//This class is created as a controller to match endpoints to specific method handlers.
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.Cindy.Chen.Capstone.Entity.Medication;
import com.example.Cindy.Chen.Capstone.Service.MedicationService;

@Controller
public class MedicationController {
	@Autowired
	private MedicationService medicationService;
//This methods returns the index page as the default, the index page lists all the medications that are founded in the medicationService file.If the user addes a new medication, it will automatically addeds it to the model attribute and the table list.	
	@RequestMapping("/")
	public String viewIndexPage(Model model) {
	    Iterable<Medication> listMedications = medicationService.listAll();
	    model.addAttribute("listMedications", listMedications);
	     
	    return "index";
	}

//This method returns the new_medication page, allowing the user to add a new medication. If the user addes a new medication, it will automatically addes it to the model attribute and the database.
	@RequestMapping("/new")
	public String showNewMedicationPage(Model model) {
	    Medication medication = new Medication();
	    model.addAttribute("medication", medication);
	     
	    return "new_medication";
	}
	
//This methods holds the save value of the new_medication and edit_medication. If the user wanted to update or create a new medication, after clicking save on the website, it will input or update the information	on the database and the model attributes. Then redirects the user to the index page.
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveMedication(@ModelAttribute("medication") Medication medication) {
	    medicationService.save(medication);
	     
	    return "redirect:/";
	}
	
//This method returns the edit_medication page. If the user updates the medication, it will automatically update with the corresponding repository, database, model attribute, and the modelAndView	
	@RequestMapping("/edit/{medicationID}")
	public ModelAndView showEditMedicationPage(@PathVariable(name = "medicationID") int medicationID) {
	    ModelAndView mav = new ModelAndView("edit_medication");
	    Medication medication = medicationService.get(medicationID);
	    mav.addObject("medication", medication);
	     
	    return mav;
	}
	
//This method deletes a certain medication by request. If the user decides to delete a medication, it will delete from the model attribute, database, service/repositories, and redirects the user to the index page.	
	@RequestMapping("/delete/{medicationID}")
	public String deleteMedication(@PathVariable(name = "medicationID") int medicationID) {
		medicationService.delete(medicationID);
	    return "redirect:/";       
	}
	
//Line 65-176 is the mappings for individual pages to specific endpoints.	
	@RequestMapping("/HomePage")
	public String HomePage() {
		return "HomePage";
	}

	@RequestMapping("/Medications")
	public String FirstPage() {
		return "Medications";
	}

	@GetMapping("/login")
    public String login(Model model) {
        return "login";
    }

    @GetMapping("/user")
    public String userIndex() {
        return "user/index";
    }
    
	@RequestMapping("/AtorvastatinPage")
	public String AtorvastatinPage() {
		return "AtorvastatinPage";
	}

	@RequestMapping("/AmoxicillinPage")
	public String AmoxicillinPage() {
		return "AmoxicillinPage";
	}

	@RequestMapping("/LisinoprilPage")
	public String LisinoprilPage() {
		return "LisinoprilPage";
	}

	@RequestMapping("/LevothyroxinePage")
	public String LevothyroxinePage() {
		return "LevothyroxinePage";
	}

	@RequestMapping("/AlbuterolPage")
	public String AlbuterolPage() {
		return "AlbuterolPage";
	}

	@RequestMapping("/MetforminPage")
	public String MetforminPage() {
		return "MetforminPage";
	}

	@RequestMapping("/AmlodipinePage")
	public String AmlodipinePage() {
		return "AmlodipinePage";
	}

	@RequestMapping("/MetoprololPage")
	public String MetoprololPage() {
		return "MetoprololPage";
	}

	@RequestMapping("/OmeprazolePage")
	public String OmeprazolePage() {
		return "OmeprazolePage";
	}

	@RequestMapping("/LosartanPage")
	public String LosartanPage() {
		return "LosartanPage";
	}

	@RequestMapping("/AzithromycinPage")
	public String AzithromycinPage() {
		return "AzithromycinPage";
	}

	@RequestMapping("/PrednisonePage")
	public String PrednisonePage() {
		return "PrednisonePage";
	}

	@RequestMapping("/IbuprofenPage")
	public String IbuprofenPage() {
		return "IbuprofenPage";
	}

	@RequestMapping("/HydrocodoneAndAcetaminophenPage")
	public String HydrocodoneAndAcetaminophenPage() {
		return "HydrocodoneAndAcetaminophenPage";
	}

	@RequestMapping("/GabapentinPage")
	public String GabapentinPage() {
		return "GabapentinPage";
	}

	@RequestMapping("/InnerPage")
	public String InnerPage() {
		return "InnerPage";
	}

	@RequestMapping("/AboutPage")
	public String AboutPage() {
		return "AboutPage";
	}

	@RequestMapping("/AddMedicationFormPage")
	public String AddMedicationFormPage() {
		return "AddMedicationForm";
	}
	@RequestMapping("/index")
	public String showIndexPage() {
		return "redirect:/";
	}
}


