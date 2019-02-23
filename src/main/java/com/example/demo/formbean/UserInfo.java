package com.example.demo.formbean;

/**
 * セッション情報格納entity.
 * @author eharada
 *
 */
public class UserInfo {

	private static final long serialVersionUID = 1L;

	private String userId;
	private String userNm;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserNm() {
		return userNm;
	}

	public void setUserNm(String userNm) {
		this.userNm = userNm;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


}
