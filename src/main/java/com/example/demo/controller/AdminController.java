package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

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

	// メモ 返り値をStringにする時はModelAndViewではなくModelを使う。（既存のものは良いが増やせない）

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




    /**
     * 初期表示.
     * @return URL
     */
    @RequestMapping(value= DIR + "/dashboard", method=RequestMethod.GET)
    public String dashboard(Model model) {

    	// メニュー用
    	model.addAttribute("dashboard", "active");
        return "index";
    }

    /**
     * Tweetボタン押下.
     * @param tweet
     * @param userInfo
     * @return
     */
    @RequestMapping(value="admin/sec", method=RequestMethod.POST)
    public String sec(@ModelAttribute ("tweet2") String tweet2, @ModelAttribute ("tweet") String tweet, @ModelAttribute("userInfo") UserInfo userInfo, Model model) {

        model.addAttribute("tweet", tweet);
        // sessionに設定
        model.addAttribute("userInfo", userInfo);

        System.out.println("SEC");
        return "index";
    }

    /**
     * Register押下
     *
     * @param name
     * @param userInfo
     * @param model
     * @return
     */
    @RequestMapping(value="admin/session", method=RequestMethod.POST)
    public String session(@ModelAttribute ("name") String name, @ModelAttribute("userInfo") UserInfo userInfo, Model model) {

    	System.out.println("SESSION");

    	// 	sessionに格納
    	setUserInfo(userInfo);

    	model.addAttribute("name", name);
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


    @RequestMapping(value="admin/cards", method=RequestMethod.POST)
    public String cards(Model model) {
    	// メニュー用
    	model.addAttribute("components", "active");
    	model.addAttribute("pages", "active");
    	model.addAttribute("customComponents", "show");
        return "cards";

    }

    @RequestMapping(value="admin/create/ticket", method=RequestMethod.POST)
    public String create(Model model) {
    	// メニュー用


    	model.addAttribute("showCategory", "show");
    	model.addAttribute("activeCreate", "active");
    	model.addAttribute("activeTiclet", "active");
        return "createTicket";

    }

//    // Mybatis
//    System.out.println("mapper(xml): " + service.get());
//    System.out.println("mapper(@) : " + service.select());

}
