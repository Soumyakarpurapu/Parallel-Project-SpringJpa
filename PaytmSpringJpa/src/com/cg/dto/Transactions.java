package com.cg.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="transactions")
public class Transactions
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="tran_Id",length=10)
	private int tranId;
	@Column(name="MobileNo",length=10)
	private String mobNo;
	@Column(name="tran_type",length=20)
	private String tranType;
	@Column(name="amount",length=10)
	private int amount;
	
	public int getTranId() {
		return tranId;
	}
	public void setTranId(int tranId) {
		this.tranId = tranId;
	}
	public String getMobNo() {
		return mobNo;
	}
	public void setMobNo(String mobNo) {
		this.mobNo = mobNo;
	}
	public String getTranType() {
		return tranType;
	}
	public void setTranType(String tranType) {
		this.tranType = tranType;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	public Transactions(String mobNo, String tranType, int amount) {
		super();
		this.mobNo = mobNo;
		this.tranType = tranType;
		this.amount = amount;
	}
	public Transactions() {
		super();
		
	}
	
	
	
}
