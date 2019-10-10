package com.medi.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.medi.dao.MedicineDAO;
import com.medi.entity.Donor;
import com.medi.entity.Medicine;

@Controller
@RequestMapping("/medicine")
public class MedicineController {
     @Autowired
	 MedicineDAO medicineDAO;
	
	@GetMapping("/list")
	public String listMedicine(Model theModel) {
		
		List<Medicine> medicines = medicineDAO.getMedicines();
		
		theModel.addAttribute("medicines", medicines);
		
		return "list-medicine";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		Medicine medicine = new Medicine();
		theModel.addAttribute("medicine", medicine);
		return "medicine-form";
	}
	
	@PostMapping("/saveMedicine")
	public String saveMedicine(@Valid @ModelAttribute("medicine") Medicine medicine ,BindingResult bindingResult) {
		
		
		if(bindingResult.hasErrors()) {
			return "medicine-form";
			
		}else {
			medicineDAO.saveMedicine(medicine);
			return "redirect:/medicine/list";
		}
		
	}
	
	@GetMapping("/delete")
	public String deleteMedicine(@RequestParam("medicineId") int mediId) {
		
		medicineDAO.deleteMedicine(mediId);
		
		return "redirect:/medicine/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("medicineId") int mediId,Model theModel) {
		
		Medicine medicine = medicineDAO.getMedicine(mediId);
		
		theModel.addAttribute("medicine",medicine);
		
		return "medicine-form";
	}

	@GetMapping("/forCustomer")
	public String forCustomer(Model model) {
		List<Medicine> medicine = medicineDAO.getMedicines();
		model.addAttribute("medicines", medicine);
		return "order-medicine";
	}
	@GetMapping("/addToCart")
	public String addToCart(@RequestParam("medicineId") int mediId,Model theModel) {
		Medicine medicine = medicineDAO.getMedicine(mediId);
		theModel.addAttribute("medicine",medicine);
		return "order-confirmation";
	}
}
