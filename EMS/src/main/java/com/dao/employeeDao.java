package com.dao;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.HibernateTemplate;

import com.bean.compliance;
import com.bean.employee;
public class employeeDao {
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	public String addEmployee(employee Employee) {
		Session session = hibernateTemplate.getSessionFactory().openSession();
		session.beginTransaction();
		Query<employee> query = session.createQuery("from employee where empId=:empId");
		query.setParameter("empId", Employee.getEmpId());
		List<employee> users = query.getResultList();
		String str;
		if(users.size()>0) {
			str="Employee already exists!";
			session.close();
		}
		else {
			str="sucess";
			session.save(Employee);
			session.getTransaction().commit();
			session.close();
		}
		return str;
	}
	public List<employee> getEmployees() {
		Session session = hibernateTemplate.getSessionFactory().openSession();
		session.beginTransaction();
		Query<employee> query = session.createQuery("from employee");
		List<employee> users = query.getResultList();
		return users;
	}
	public List<employee> getEmployee(int deptId) {
		Session session = hibernateTemplate.getSessionFactory().openSession();
		session.beginTransaction();
		Query<employee> query = session.createQuery("from employee where deptId=:deptId");
		query.setParameter("deptId",deptId);
		List<employee> users = query.getResultList();
		return users;
	}
	public employee getName(int empId) {
		Session session = hibernateTemplate.getSessionFactory().openSession();
		session.beginTransaction();
		Query<employee> query = session.createQuery("from employee where empId=:empId");
		query.setParameter("empId",empId);
		query.setMaxResults(1);
		employee users = query.uniqueResult();
		return users;
	}

}
