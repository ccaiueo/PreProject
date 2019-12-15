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
import com.example.demo.service.DBService;

/**
 * あそびばのページ関係のコントローラ
 * @author eharada
 *
 */
@Controller("/registration")
public class EmployeeController {

	/** 遷移先URL. */
	class PAGE_TITLE {
		/** 債権銘柄登録入力画面URL */
		public static final String BOND_REGISTRATION = "Bond Registration";
		/** 債権銘柄登録確認画面URL */
		public static final String BOND_REGISTRATION_CONFIRM = "Bond Registration Confirm";
		/** 債権銘柄登録完了画面URL */
		public static final String BOND_REGISTRATION_COMPLETED = "Bond Registration Completed";
	}

	@Autowired
	DBService service;

    @RequestMapping("/show")
    public String show(Model models) {


    	BondInfo formbean = new BondInfo();
        formbean.setIssuerCd("070707");
        models.addAttribute("bondInfoBean", formbean);
        models.addAttribute("aiueo", "aiueo");
        models.addAttribute("pageTitle", PAGE_TITLE.BOND_REGISTRATION);

        // for test

        // // Mybatis
        // System.out.println("mapper(xml使用): " + service.get());
        // System.out.println("mapper(@使用) : " + service.select());

        return "bondRegistration";
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