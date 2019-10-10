package com.medi.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.medi.dao.DonorDAO;
import com.medi.entity.Donor;

@Controller
@RequestMapping("/donor")
public class DonorController {

	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}
	//need to inject the donor DAO
	@Autowired
	private DonorDAO donorDAO;
	
	
	@GetMapping("/list")
	public String listDonor(Model theModel) {
		
		// get donors from the DAO
		List<Donor> theDonors = donorDAO.getDonors();
		
		// add the donors to the model
		theModel.addAttribute("donors", theDonors);
		
		return "list-donors";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel ) {
		
	    Donor theDonor = new Donor();
		
		theModel.addAttribute("donor",theDonor);
		
		return "donor-form";
		
	}
	
	@PostMapping("/saveDonor")
	public String saveDonor(@Valid @ModelAttribute("donor") Donor theDonor ,BindingResult bindingResult) {
		
		
		if(bindingResult.hasErrors()) {
			return "donor-form";
			
		}else {
			donorDAO.saveDonor(theDonor);
			return "redirect:/donor/list";
		}
		
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("donorId") int theId,Model theModel) {
		
		Donor theDonor = donorDAO.getDonor(theId);
		
		theModel.addAttribute("donor",theDonor);
		
		return "donor-form";
	}
	
	@GetMapping("/delete")
	public String deleteDonor(@RequestParam("donorId") int theId) {
		
		donorDAO.deleteDonor(theId);
		return "redirect:/donor/list";
	}

}
