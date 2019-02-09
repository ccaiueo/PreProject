package com.example.demo.persistence;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.demo.EmployeeBean;


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

}
