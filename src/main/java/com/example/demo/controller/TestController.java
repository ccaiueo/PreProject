package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.EmployeeBean;
import com.example.demo.formbean.UserInfo;
import com.example.demo.persistence.DBMapper;

@Controller("/test")
@SessionAttributes("userInfo")
public class TestController {

	@Autowired
	 DBMapper mapper;

    /**
     *  <b>セッション処理用のメソッド.</b><br>
     * @param userInfo ユーザー情報
     * @return ユーザー情報
     */
    @ModelAttribute("userInfo")
    public UserInfo setUserInfo(UserInfo userInfo){
        return userInfo;
    }

	@RequestMapping("/test")
	public ModelAndView show(ModelAndView mav) {

		// selectInfo()を呼び出してDBの値格納
		EmployeeBean form = mapper.selectInfo();

		// fromの内容をModelAndViewに追加
		mav.addObject("employeeForm", form);

		// ここでhtmlファイルを指定
		mav.setViewName("test");

		return mav;
	}

}
