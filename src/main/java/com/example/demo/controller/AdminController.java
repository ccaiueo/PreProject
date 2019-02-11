package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.controller.EmployeeController.PAGE_TITLE;
import com.example.demo.entity.BondInfo;
import com.example.demo.service.DBService;

@Controller
public class AdminController {

	@Autowired
	DBService service;
	
	private static final String DIR = "admin";

	
    @RequestMapping(value= DIR + "/show", method=RequestMethod.GET)
    public ModelAndView show(ModelAndView models) {

    	BondInfo formbean = new BondInfo();
        formbean.setIssuerCd("070707");
        models.addObject("bondInfoBean", formbean);
        // ページタイトル
        models.addObject("pageTitle", PAGE_TITLE.BOND_REGISTRATION);
        // 遷移先URL
        models.setViewName("index");
        return models;
    }
    
    @RequestMapping(value="admin/sec", method=RequestMethod.POST)
    public ModelAndView sec(ModelAndView models) {

    	BondInfo formbean = new BondInfo();
        formbean.setIssuerCd("070707");
        models.addObject("bondInfoBean", formbean);
        // ページタイトル
        models.addObject("pageTitle", PAGE_TITLE.BOND_REGISTRATION);
        // 遷移先URL
        models.setViewName("index");

        // for test

        // Mybatis
        System.out.println("mapper(xml使用): " + service.get());
        System.out.println("mapper(@使用) : " + service.select());

        return models;
    }
}
