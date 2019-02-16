package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.formbean.UserInfo;
import com.example.demo.service.DBService;

/**
 * トップController.
 * 
 * @author erika
 *
 */
@Controller
@SessionAttributes("userInfo")
public class AdminController {

    
    /**
     * セッションのオブジェクト代入格納.
     * 
     * @param userInfo
     * @return
     */
    @ModelAttribute("userInfo")
    public UserInfo setUserInfo(UserInfo userInfo){
        return userInfo;
    }

	@Autowired
	private DBService service;
	/** admin共通URL */
	private static final String DIR = "admin";
	ModelAndView model = new ModelAndView();

	
    /**
     * 初期表示.
     * @return URL
     */
    @RequestMapping(value= DIR + "/show", method=RequestMethod.GET)
    public String show() {

        return "index";
    }
    
    /**
     * ツイートボタン押下.
     * @param tweet
     * @param userInfo
     * @return
     */
    @RequestMapping(value="admin/sec", method=RequestMethod.POST)
    public String sec(@ModelAttribute ("tweet") String tweet, @ModelAttribute("userInfo") UserInfo userInfo) {

        model.addObject("tweet", tweet);
        model.addObject("userInfo", userInfo);

        System.out.println("SEC");
        return "index";
    }
    
    @RequestMapping(value="admin/session", method=RequestMethod.POST)
    public String session(@ModelAttribute ("name") String name, @ModelAttribute("userInfo") UserInfo userInfo) {
    	
    	System.out.println("SESSION");
    	
    	// 	sessionに格納
    	setUserInfo(userInfo);
    	
    	model.addObject("name", name);
        return "blank";
    }
    

    /**
     * セッションクローズ.
     * @param sessionStatus
     * @return
     */
    @RequestMapping(value="admin/close", method=RequestMethod.POST)
    public String sessionClose(SessionStatus sessionStatus) {
    	
        sessionStatus.setComplete();
        return "index";
        
    }
    
//    // Mybatis
//    System.out.println("mapper(xml): " + service.get());
//    System.out.println("mapper(@) : " + service.select());
    
}
