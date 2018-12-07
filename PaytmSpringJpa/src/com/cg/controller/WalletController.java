package com.cg.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cg.dto.Transactions;
import com.cg.dto.User;
import com.cg.service.IPaytmWalletService;

@Controller
public class WalletController
{
	@Autowired
	IPaytmWalletService walSer;
	@RequestMapping(value="run",method=RequestMethod.GET)
	public String sayHello()
	{
		return "Welcome";
	}
	@RequestMapping(value="createAccount",method=RequestMethod.GET)
	public String addAccount(@ModelAttribute("customer") User user,BindingResult result)
	{
		return "AcctResult";		
	}
	@RequestMapping(value="save",method=RequestMethod.POST)
	public String addDetails(@Valid@ModelAttribute("customer") User user, BindingResult result)
	{		
		if(result.hasErrors()){
			return "AcctResult";
		}
		else
		{			
		User u=walSer.findOne(user.getMobileNo());		
		if(u==null)
		{				
			user=walSer.createAccount(user);
			return "Success";
		}		
		else {
			return "Failed";	
		}
		}		
	}
	@RequestMapping(value="showBalance",method=RequestMethod.GET)
	public String getBalance(@ModelAttribute("balance")User user, BindingResult result)
	{
		return "showBalance";
	}
	@RequestMapping(value="saveNo",method=RequestMethod.POST)
	public ModelAndView showBalance(@ModelAttribute("showbalance") User user, BindingResult result,Model model)
	{
		User u=walSer.findOne(user.getMobileNo());
		if(u!=null)
		{
		User i=walSer.showBalance(user.getMobileNo());		
		return new ModelAndView("balance","bal",i);
		}
		else return new ModelAndView("Failure");
	}
	@RequestMapping(value="depositAmount",method=RequestMethod.GET)
	public String depositAmt(@ModelAttribute("customerbal")User user,BindingResult result)
	{
		return "depositAmt";
	}
	@RequestMapping(value="insertNo",method=RequestMethod.POST)
	public ModelAndView depositAmount(@ModelAttribute("depositbal") User user,  BindingResult result,Model model)
	{
		User u=walSer.findOne(user.getMobileNo());		
		User u1=walSer.depositAmount(user.getMobileNo(), user.getBalance());		
		if(u1!=null)
		{
		return new ModelAndView("deposited");
		}
		else return new ModelAndView("Failure");
	}
	@RequestMapping(value="withdrawAmount",method=RequestMethod.GET)
	public String withdrawAmt(@ModelAttribute("customerbal")User user,BindingResult result)
	{
		return "withdrawAmt";
	}
	@RequestMapping(value="insertAmt",method=RequestMethod.POST)
	public ModelAndView withdrawAmount(@ModelAttribute("withdrawbal") User user,  BindingResult result,Model model)
	{
		User u=walSer.findOne(user.getMobileNo());
		if(u!=null)
		{
		User u1=walSer.withdrawAmount(user.getMobileNo(), user.getBalance());
		if(u1!=null)
		{	
			return new ModelAndView("withdrawn");
		}
		else return new ModelAndView("insufficientBal");
		}
		else return new ModelAndView("Failure");
	}
	@RequestMapping(value="transferAmount",method=RequestMethod.GET)
	public String fundTransfer(@ModelAttribute("customerbal")User user,BindingResult result)
	{
		return "fundTransfer";
	}
	@RequestMapping(value="fundtr",method=RequestMethod.POST)
	public ModelAndView transferAmount(@ModelAttribute("fundtransfer") User user,
			@RequestParam("SNumber")String SMobNo,
			@RequestParam("RNumber")String RMobNo)
	{		
		User u=walSer.fundTransfer(SMobNo,RMobNo, user.getBalance());	
		return new ModelAndView("transferred");
	}
	@RequestMapping(value="printTransactions",method=RequestMethod.GET)
	public String printTransactions(@ModelAttribute("customerwallet")Transactions t,BindingResult result)
	{
		return "printTransactions";
	}
	@RequestMapping(value="printTr",method=RequestMethod.POST)
	public ModelAndView printTransactions1(@ModelAttribute("customerwallet")Transactions t)
	{
		
		List<Transactions> list=walSer.getAllTrasactions(t.getMobNo());		
		return new ModelAndView("transactions","list",list);
	}
	
}
