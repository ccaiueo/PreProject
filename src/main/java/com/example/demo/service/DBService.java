package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.EmployeeBean;
import com.example.demo.persistence.DBMapper;

@Service
public class DBService {
















	// 読み込めないので未使用
	@Autowired
	private DBMapper mapper;

	public EmployeeBean get() {
		return mapper.selectInfo();
	}

    public EmployeeBean select() {
    	return mapper.select();
    }
}
