package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Entity(name="bondInfo") // Entityクラスであることを明記。name属性はテーブル名で。
@Data
public class BondInfo {

	private static final long serialVersionUID = 1L;

	@Id

	@NotEmpty(message = "{message}")
	private String bondNm;

	private String issuerCd;

	private String ccy;

	private String issuePrc;

	private String issueAmt;

	private String denomination;

	private String minTradeAmt;

	private String couponRate;

	private String dayCountConvention;

	private String issueDt;

	private String maturityDt;

	public String getBondNm() {
		return bondNm;
	}

	public void setBondNm(String bondNm) {
		this.bondNm = bondNm;
	}

	public String getIssuerCd() {
		return issuerCd;
	}

	public void setIssuerCd(String issuerCd) {
		this.issuerCd = issuerCd;
	}

	public String getCcy() {
		return ccy;
	}

	public void setCcy(String ccy) {
		this.ccy = ccy;
	}

	public String getIssuePrc() {
		return issuePrc;
	}

	public void setIssuePrc(String issuePrc) {
		this.issuePrc = issuePrc;
	}

	public String getIssueAmt() {
		return issueAmt;
	}

	public void setIssueAmt(String issueAmt) {
		this.issueAmt = issueAmt;
	}

	public String getDenomination() {
		return denomination;
	}

	public void setDenomination(String denomination) {
		this.denomination = denomination;
	}

	public String getMinTradeAmt() {
		return minTradeAmt;
	}

	public void setMinTradeAmt(String minTradeAmt) {
		this.minTradeAmt = minTradeAmt;
	}

	public String getCouponRate() {
		return couponRate;
	}

	public void setCouponRate(String couponRate) {
		this.couponRate = couponRate;
	}

	public String getDayCountConvention() {
		return dayCountConvention;
	}

	public void setDayCountConvention(String dayCountConvention) {
		this.dayCountConvention = dayCountConvention;
	}

	public String getIssueDt() {
		return issueDt;
	}

	public void setIssueDt(String issueDt) {
		this.issueDt = issueDt;
	}

	public String getMaturityDt() {
		return maturityDt;
	}

	public void setMaturityDt(String maturityDt) {
		this.maturityDt = maturityDt;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "BondInfo [bondNm=" + bondNm + ", issuerCd=" + issuerCd + ", ccy=" + ccy + ", issuePrc=" + issuePrc
				+ ", issueAmt=" + issueAmt + ", denomination=" + denomination + ", minTradeAmt=" + minTradeAmt
				+ ", couponRate=" + couponRate + ", dayCountConvention=" + dayCountConvention + ", issueDt=" + issueDt
				+ ", maturityDt=" + maturityDt + "]";
	}

}
