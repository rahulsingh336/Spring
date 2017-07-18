package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.beans.SampleBean;

@Controller
public class SampleController {
	
	@Autowired
	private SampleBean sb;

	@RequestMapping("/home")
	public String loadHomePage(Model m) {
		
		sb.testSampleBean();
		
		m.addAttribute("name", "Example Session");
		m.addAttribute("oldNum", sb.getRndNumber());
		sb.generateRndNumber();
		m.addAttribute("newNum", sb.getRndNumber());
		m.addAttribute("hashCodeRef", sb);
		return "home";
	}
}
