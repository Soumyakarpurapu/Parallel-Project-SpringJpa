package com.cg.dao;

import java.util.List;

import com.cg.dto.Transactions;
import com.cg.dto.User;



public interface IPaytmWalletDao 
{
	public boolean save(User user) ;

	public User findOne(String mobileNo) ;

	public List<User> showAllDetails();
	
	public List<Transactions> getAllTrasactions(String mobileNo);
	
	public void create(Transactions transaction);
}
