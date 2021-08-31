package com.dao;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.HibernateTemplate;


import com.bean.department;
import com.bean.employee;

public class departmentDao {

	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	public void addDepartment(department Department) {
		Session session = hibernateTemplate.getSessionFactory().openSession();
		session.beginTransaction();
			session.save(Department);
			session.getTransaction().commit();
			session.close();

	}
	public List<department> getDepartments() {
		Session session = hibernateTemplate.getSessionFactory().openSession();
		session.beginTransaction();
		Query<department> query = session.createQuery("from department");
		List<department> users = query.getResultList();
		return users;
	}
}
