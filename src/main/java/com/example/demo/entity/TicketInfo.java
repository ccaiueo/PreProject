package com.example.demo.entity;

/**
 * TICKET_INFOテーブルのデータ格納Entity.
 * @author eharada
 *
 */
public class TicketInfo {

	/** チケットNO. */
	private int ticketNo;

	/** タイトル. */
	private String title;

	/** コンテンツ内容. */
	private String content;

	/** 共有設定フラグ. */
	private String sharedFlg;

	/** 使用済みフラグ. */
	private String usedFlg;

	public int getTicketNo() {
		return ticketNo;
	}

	public void setTicketNo(int ticketNo) {
		this.ticketNo = ticketNo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getSharedFlg() {
		return sharedFlg;
	}

	public void setSharedFlg(String sharedFlg) {
		this.sharedFlg = sharedFlg;
	}

	public String getUsedFlg() {
		return usedFlg;
	}

	public void setUsedFlg(String usedFlg) {
		this.usedFlg = usedFlg;
	}




}
