package com.example.demo;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.util.AdminPropertyUtil;

@SpringBootApplication
public class ProjectApplication {

	public static Map propertiesMap = new HashMap();

	public static void main(String[] args) {
		SpringApplication.run(ProjectApplication.class, args);

		// ValidationMessags.propertiesを読み込んでMapへ格納
		AdminPropertyUtil adminPropUtil = new AdminPropertyUtil();
		adminPropUtil.getProperty(propertiesMap);
	}
}

