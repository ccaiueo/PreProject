package com.example.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entity.BondInfo;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.DBService;

@Controller("/registration")
public class EmployeeController {

	class PAGE_TITLE {
		public static final String BOND_REGISTRATION = "Bond Registration";
		public static final String BOND_REGISTRATION_CONFIRM = "Bond Registration Confirm";
		public static final String BOND_REGISTRATION_COMPLETED = "Bond Registration Completed";
	}

	@Autowired
	EmployeeRepository repository;

	@Autowired
	DBService service;

    @RequestMapping("/show")
    public ModelAndView show(ModelAndView models) {

    	BondInfo formbean = new BondInfo();
        formbean.setIssuerCd("070707");
        models.addObject("bondInfoBean", formbean);
        models.addObject("aiueo", "aiueo");
        models.addObject("pageTitle", PAGE_TITLE.BOND_REGISTRATION);
        models.setViewName("bondregistration");

        // for test

        // Mybatis
        System.out.println("mapper(xml使用): " + service.get());
        System.out.println("mapper(@使用) : " + service.select());

        return models;
    }

    @RequestMapping("/confirm")
    public ModelAndView confirm(@ModelAttribute ("bondInfoBean") @Valid BondInfo formbean, BindingResult result, Model model, ModelAndView models) {

//		models.addObject("errors", result);
        models.addObject("bondInfoBean", formbean);

        if(result.hasErrors()) {
        	models.setViewName("bondregistration");
        } else {

            models.setViewName("bondregistrationConfirm");
        }
    	// ああああ


        // for test

//        // JPA
//        System.out.println("JPA版あ" + repository.findAll().toString());
//        // Mybatis
//        System.out.println("mapper(xml使用): " + service.get());
//        System.out.println("mapper(@使用) : " + service.select());
        return models;
    }
}