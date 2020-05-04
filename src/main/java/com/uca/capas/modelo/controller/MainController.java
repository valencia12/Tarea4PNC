package com.uca.capas.modelo.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.modelo.domain.Producto;

@Controller
public class MainController {
	
	@GetMapping("/producto")
	public ModelAndView newProduct() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("producto", new Producto());
		mav.setViewName("form");
		return mav;
	}
	
	@PostMapping("/validar")
	public ModelAndView validating(@Valid @ModelAttribute Producto producto, BindingResult result) {
		ModelAndView mav = new ModelAndView();
		if(result.hasErrors()) {
			mav.setViewName("form");
		}
		else { 
			mav.addObject("nombre", producto.getNombre());
			mav.setViewName("validar");
		}
		return mav;
	}

}