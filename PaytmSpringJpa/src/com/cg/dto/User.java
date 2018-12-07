package com.cg.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;


@Entity
@Table(name="customer_wallet")
public class User
{
	@Id
	@NotEmpty(message="MobileNo cannot be empty")
	@Column(name="MobileNo",length=10)
	@Pattern(regexp = "[6-9][0-9]{9}")
	private String mobileNo;
	@NotEmpty(message="Name cannot be empty")
	@Column(name="CustomerName",length=15)
	@Size(min=3,max=15,message="name should have min length")
	@Pattern(regexp = "[A-Z]{1}[a-z]+")
	private String name;
	@NotNull(message="You cannot initialize account with zero balance")
	@Column(name="Balance",length=10)
	private int balance;
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "User [mobNo=" + mobileNo + ", name=" + name + ", balance="
				+ balance + "]";
	}
	public User(String mobNo, String name, int balance) {
		super();
		this.mobileNo = mobNo;
		this.name = name;
		this.balance = balance;
	}
	public User() {
		super();		
	}	
	
}
