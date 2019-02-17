package com.example.demo.persistence;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.demo.EmployeeBean;
import com.example.demo.entity.TicketInfo;


@Mapper
public interface DBMapper {

    /**
     * SQLをアノテーションへ記述するタイプ.
     *
     * @return DBから取得したデータ
     */
    @Select("SELECT * FROM employee WHERE id = '00001'")
    public EmployeeBean select();


	/**
	 * SQLをXMLファイルへ記述するタイプ.
	 *
	 * @return DBから取得したデータ
	 */
	public EmployeeBean selectInfo();


	@Select("SELECT * FROM TICKET_INFO")
	public List<TicketInfo> selectTicketInfo();

}
