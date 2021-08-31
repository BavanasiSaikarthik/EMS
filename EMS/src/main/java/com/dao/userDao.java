package com.dao;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.HibernateTemplate;

import com.bean.user;

public class userDao {
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	public String addUser(user User) {
		Session session = hibernateTemplate.getSessionFactory().openSession();
		session.beginTransaction();
		Query<user> query = session.createQuery("from user where userId=:userId");
		query.setParameter("userId", User.getUserId());
		List<user> users = query.getResultList();
		String str;
		if(users.size()>0) {
			str="User Id already exists!";
			session.close();
		}
		else {
			str="sucess";
			session.save(User);
			session.getTransaction().commit();
			session.close();
		}
		return str;
	}
	
	public int validateUser(user User) {
		Session session = hibernateTemplate.getSessionFactory().openSession();
		session.beginTransaction();
		Query<user> query = session.createQuery("from user where userId=:userId");
		query.setParameter("userId", User.getUserId());
		List<user> users = query.getResultList();
		session.close();
		if(users.size()>0) {
			user dbUser = users.get(0);
			if(dbUser.getPassword().equals(User.getPassword())) {
				return dbUser.getUserId();
			}
			else {
				return -1;
			}
		}
		else {
			return -1;
		}
	}
	
	public String getRole(user User) {
		Session session = hibernateTemplate.getSessionFactory().openSession();
		session.beginTransaction();
		Query<user> query = session.createQuery("from user where userId=:userId");
		query.setParameter("userId", User.getUserId());
		List<user> users = query.getResultList();
		session.close();
		return users.get(0).getRole();
	}
}
