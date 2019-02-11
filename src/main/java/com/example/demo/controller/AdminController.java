package com.example.demo.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.controller.EmployeeController.PAGE_TITLE;
import com.example.demo.entity.BondInfo;
import com.example.demo.service.DBService;

@Controller
@SessionAttributes({"bondInfoBean"})
public class AdminController {

	@Autowired
	DBService service;
	
	ModelAndView model = new ModelAndView();
	
	
	private static final String DIR = "admin";

	
    @RequestMapping(value= DIR + "/show", method=RequestMethod.GET)
    public ModelAndView show() {

    	BondInfo formbean = new BondInfo();
        formbean.setIssuerCd("070707");
        model.addObject("bondInfoBean", formbean);
    	model.addObject("pageTitle", PAGE_TITLE.BOND_REGISTRATION);
    	model.setViewName("index");
        return model;
    }
    
    @RequestMapping(value="admin/sec", method=RequestMethod.POST)
    public ModelAndView sec(@ModelAttribute ("bondInfoBean") BondInfo formbean) {

        formbean.setIssuerCd("070707");
        model.addObject("bondInfoBean", formbean);
        model.addObject("pageTitle", PAGE_TITLE.BOND_REGISTRATION);
        model.setViewName("index");

        return model;
    }
    
    @RequestMapping(value="admin/close", method=RequestMethod.POST)
    public ModelAndView sessionClose(SessionStatus sessionStatus) {

        model.addObject("pageTitle", PAGE_TITLE.BOND_REGISTRATION);
        model.setViewName("index");
        
        sessionStatus.setComplete();

        // Mybatis
        System.out.println("mapper(xml): " + service.get());
        System.out.println("mapper(@) : " + service.select());

        return model;
        
        // 次ああああああアクションを起こした際はセッションが消える
        // あああああああああ
        // ああああああああああああああああaaaああああ
        
    }
}
