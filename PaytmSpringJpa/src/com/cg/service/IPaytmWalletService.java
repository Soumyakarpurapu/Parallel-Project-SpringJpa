package com.cg.service;

import java.util.List;

import com.cg.dto.Transactions;
import com.cg.dto.User;


public interface IPaytmWalletService 
{
	public User createAccount(User user);
	public User showBalance (String mobileNo);
	public User fundTransfer (String sourceMobileNo,String targetMobileNo, int amount);
	public User depositAmount (String mobileNo,int amount );
	public User withdrawAmount(String mobileNo, int amount);
	public List<Transactions> getAllTrasactions(String mobileNo);	
	public User findOne(String mobileNo); 
	
	

}
