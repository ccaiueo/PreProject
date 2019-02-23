package com.example.demo.persistence;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.demo.EmployeeBean;
import com.example.demo.entity.TicketInfo;


/**
 * <b>DB操作Mapperインターフェースクラス.</b>
 * @author eharada
 *
 */
@Mapper
public interface DBMapper {

    /**
     * <b>EMPLOYEEテーブルからデータを取得する.</b><br>
     * ※ SQLをアノテーションへ記述するタイプ
     * @return EmployeeBean DBから取得したデータ
     */
    @Select("SELECT * FROM employee WHERE id = '00001'")
    public EmployeeBean select();

	/**
	 * <b>EMPLOYEEテーブルからデータを取得する.</b><br>
	 * ※ SQLをXMLファイルへ記述するタイプ
	 * @return EmployeeBean DBから取得したデータ
	 */
	public EmployeeBean selectInfo();

	// ****************************** 以下SBAdminで利用 ******************************

	/**
	 * <b>TICKET_INFOテーブルからデータを取得する.</b>
	 * @return List<TicketInfo> 取得したDB情報リスト
	 */
	@Select("SELECT * FROM TICKET_INFO")
	public List<TicketInfo> selectTicketInfo();

}
