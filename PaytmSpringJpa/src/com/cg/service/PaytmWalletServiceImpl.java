package com.cg.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dao.IPaytmWalletDao;
import com.cg.dao.PaytmWalletDaoImpl;
import com.cg.dto.Transactions;
import com.cg.dto.User;

@Service("walSer")
@Transactional
public class PaytmWalletServiceImpl implements IPaytmWalletService
{
	@Autowired
	IPaytmWalletDao dao;
	@Override
	public User createAccount(User user)
	{		
		if(dao.save(user))
		{
			return user;
		}
		return null;
	}

	@Override
	public User showBalance(String mobileNo) {
		User user=dao.findOne(mobileNo);
					return user;
		
	}

	@Override
	public User fundTransfer(String sourceMobileNo, String targetMobileNo,	int amount) {
		User user = withdrawAmount(sourceMobileNo, amount);
		depositAmount(targetMobileNo, amount);
		return user;
	}

	@Override
	public User depositAmount(String mobileNo, int amount) {
		String tranType="Deposit";
		User user = dao.findOne(mobileNo);
		if(user!=null)
		{
		 user.setBalance(user.getBalance()+(amount));
		dao.save(user);
		 Transactions trans=new Transactions(mobileNo, tranType, amount);
		dao.create(trans);
		 return user;	
		}
		else return null;
	}

	@Override
	public User withdrawAmount(String mobileNo, int amount) {
		String tranType="Withdraw";
		User user = dao.findOne(mobileNo);
		if(user.getBalance()>=amount)
		{
		 user.setBalance(user.getBalance()-(amount));
		 dao.save(user);
		 Transactions trans=new Transactions(mobileNo, tranType, amount);
			dao.create(trans);
		return user;
		}
		else return null;
	}

	@Override
	public List<Transactions> getAllTrasactions(String mobileNo) {
		return dao.getAllTrasactions(mobileNo);
	}

	@Override
	public User findOne(String mobileNo) {
	
		return dao.findOne(mobileNo);
	}

	
}
