package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.EmployeeBean;
import com.example.demo.entity.TicketInfo;
import com.example.demo.persistence.DBMapper;

/**
 * DB関連Serviceクラス
 * @author eharada
 *
 */
@Service
public class DBService {

	@Autowired
	private DBMapper mapper;

    /**
     * <b>EMPLOYEEテーブルからデータを取得する.</b><br>
     * ※ SQLをアノテーションへ記述するタイプ
     * @return EmployeeBean DBから取得したデータ
     */
    public EmployeeBean select() {
    	return mapper.select();
    }

	/**
	 * <b>EMPLOYEEテーブルからデータを取得する.</b><br>
	 * ※ SQLをXMLファイルへ記述するタイプ
	 * @return EmployeeBean DBから取得したデータ
	 */
	public EmployeeBean get() {
		return mapper.selectInfo();
	}

	// ****************************** 以下SBAdminで利用 ******************************

	/**
	 * <b>TICKET_INFOテーブルからデータを取得する.</b>
	 * @return List<TicketInfo> 取得したDB情報リスト
	 */
    public List<TicketInfo> getTicketInfo() {
    	return mapper.selectTicketInfo();
    }
}
