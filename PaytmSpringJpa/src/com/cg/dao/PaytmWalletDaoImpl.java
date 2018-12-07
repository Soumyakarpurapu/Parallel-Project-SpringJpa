package com.cg.dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import com.cg.dto.Transactions;
import com.cg.dto.User;

import org.springframework.stereotype.Repository;

@Repository("dao")
public class PaytmWalletDaoImpl implements IPaytmWalletDao
{
	@PersistenceContext
	EntityManager entityManager;
	
	@Override
	public boolean save(User user) {
		if(user!=null)
		{
			entityManager.persist(user);
			entityManager.flush();
			return true;
		}
		return false;		
	}

	@Override
	public User findOne(String mobileNo) {
		Query query1=entityManager.createQuery("From User");
		List<User> list=query1.getResultList();
		for(User user1:list)
		{			
			if(user1.getMobileNo().equals(mobileNo))
			{				
				User user = entityManager.find(User.class, mobileNo);
				return user;
			}				
		}		
		return null;
	}

	@Override
	public List<User> showAllDetails() {
		Query queryOne=entityManager.createQuery("FROM User");
		List<User> myList=queryOne.getResultList();
		return myList;
	}

	@Override
	public List<Transactions> getAllTrasactions(String mobileNo) {
		List<Transactions> li=new ArrayList<Transactions>();		
		Query query = entityManager.createQuery("FROM Transactions where mobNo=:mobile");
		query.setParameter("mobile", mobileNo);
		li=query.getResultList();
		return li;	
	}

	@Override
	public void create(Transactions transaction) {
		entityManager.persist(transaction);
		
	}

	

	
}
