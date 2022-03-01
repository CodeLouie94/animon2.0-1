package com.erik.animon2.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.erik.animon2.models.Pet;
import com.erik.animon2.models.User;
import com.erik.animon2.services.PetService;
import com.erik.animon2.services.UserService;

@Controller
public class PetController {

	@Autowired
	private UserService userServ;
	@Autowired
	private PetService petServ;
	
	
	//CREATE PET FORM ##############################################
	@GetMapping("/new/pet")
	public String newPet(HttpSession session, Model model) {
		Long userId = (Long) session.getAttribute("user_id");
		if (userId == null) {
			return "redirect:/";
		}else {
			User thisUser = userServ.findOne(userId);
			model.addAttribute("thisUser", thisUser);
			model.addAttribute("newPet", new Pet());
			return "createpet.jsp";
		}
	}
	//CREATE HANDLER -----------------------------
	@PostMapping("/create/pet")
	public String processCreatePet(@Valid @ModelAttribute("newPet") Pet pet,
									BindingResult result, HttpSession session, Model model) {
		Long userId = (Long) session.getAttribute("user_id");
		if (result.hasErrors()) {
			User thisUser = userServ.findOne(userId);
			model.addAttribute("thisUser", thisUser);
			return "createpet.jsp";
		}else {
			petServ.createPet(pet);
			return "redirect:/home";
		}
	}
	
	
	//HOME PAGE ###########################################################
	@GetMapping("/home")
	public String home(HttpSession session, Model model) {
		Long userId = (Long) session.getAttribute("user_id");
		if(userId==null) {
			return "redirect:/";
		}else {
			User thisUser = userServ.findOne(userId);
			List<Pet> allPets = petServ.allPets();
			model.addAttribute("thisUser", thisUser);
			model.addAttribute("allPets", allPets); //EVERYONES PETS IN DB????
			return "home.jsp";
		}
	}
	
	   //Play ###################################################
    @GetMapping("/play/{id}")
    public String play(@PathVariable("id") Long id) {
        Pet pet = petServ.findPet(id);
        pet.play();
        petServ.updatePet(pet);
        return "redirect:/play";
    }
    
    // PLay Render JSP ##########################
    @GetMapping("/play")
    public String playWithMe(HttpSession session, Model model) {
    	Long userId = (Long) session.getAttribute("user_id");
    	if(userId ==null) {
    		return "redirect:/";
    	} else {
    		User thisUser = userServ.findOne(userId);
//    		List<Pet> allPets = petServ.allPets();
    		model.addAttribute("thisUser", thisUser);
//    		model.addAttribute("allPets", allPets);
    		return "play.jsp";
    	}
    	
    }
    
    @GetMapping("/contest/{id}")
    public String contestRedirect(@PathVariable("id") Long id, HttpSession session, Model model) {
		Pet pet = petServ.findPet(id);
		petServ.contest(pet);
		return "redirect:/contest";
    }
    
    
    
    // Contest Render JSP ########################
    @GetMapping("/contest")
    public String contestRender(@PathVariable("id") Long id, HttpSession session, Model model) {
    	Long userId = (Long) session.getAttribute("user_id");
    	if (userId == null) {
    		return "redirect:/";
    	} else {

    		User thisUser = userServ.findOne(userId);
    		userServ.updateUser(thisUser);
    		model.addAttribute("thisUser", thisUser);
    		return "contest.jsp";
    	}
    }
	
	
	

}
