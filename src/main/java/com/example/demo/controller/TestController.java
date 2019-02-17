package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.EmployeeBean;
import com.example.demo.persistence.DBMapper;

@Controller("/test")
public class TestController {

	@Autowired
	 DBMapper mapper;


	@RequestMapping("/test")
	public ModelAndView show(ModelAndView mav) {

		// selectInfo()を呼び出してDBの値格納
		EmployeeBean form = mapper.selectInfo();

		// fromの内容をModelAndViewに追加
		mav.addObject("employeeForm", form);

		// ここでhtmlファイルを指定
		mav.setViewName("test");

		// 出力確認 //////////////////////////////////////////////////////////
		// Mybatis
		System.out.println("直接mapper(xml使用): " + mapper.selectInfo());
	    System.out.println("直接mapper(@使用) : " + mapper.select());

	    // test
	    System.out.println("idの値を持ってきたい : " + form.getId());
	    System.out.println("Nameの値を持ってきたい : " + form.getName());
	    System.out.println("Emailの値を持ってきたい : " + form.getEmail());
		//////////////////////////////////////////////////////////////////////

	    /*  */
	    // まずxmlでSQL発行してる方
	    EmployeeBean bean = mapper.selectInfo();
        System.out.println(bean);

        // 入れ物作成
	     EmployeeBean bean1 = new EmployeeBean();
	     // 入れ物にDBのデータを入れる
	     bean1 = mapper.selectInfo();
	     // 表示
	     System.out.println(bean1.toString());

	     return mav;
	}

}
