package com.medi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FrontPageController {

	@RequestMapping("/")
	public String showDonorPage() {
		return "front-page";
	}
}
