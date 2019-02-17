package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.EmployeeBean;
import com.example.demo.entity.TicketInfo;
import com.example.demo.persistence.DBMapper;

@Service
public class DBService {


	@Autowired
	private DBMapper mapper;

	public EmployeeBean get() {
		return mapper.selectInfo();
	}

    public EmployeeBean select() {
    	return mapper.select();
    }


    /**
     * DBからTicket情報の取得.
     *
     * @return 取得したチケットデータ
     */
    public List<TicketInfo> getTicketInfo() {
    	return mapper.selectTicketInfo();
    }
}
