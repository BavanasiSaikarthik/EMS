package com.dao;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.HibernateTemplate;

import com.bean.compliance;
import com.bean.employee;

public class complianceDao {
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	public void addCompliance(compliance Regulation) {
		Session session = hibernateTemplate.getSessionFactory().openSession();
		session.beginTransaction();
			session.save(Regulation);
			session.getTransaction().commit();
			session.close();
		}
	public List<compliance> getCompliances() {
		Session session = hibernateTemplate.getSessionFactory().openSession();
		session.beginTransaction();
		Query<compliance> query = session.createQuery("from compliance");
		List<compliance> users = query.getResultList();
		return users;
	}
	public compliance getlastCompliance() {
		Session session = hibernateTemplate.getSessionFactory().openSession();
		session.beginTransaction();
		Query<compliance> query = session.createQuery("from compliance order by complianceId DESC");
		query.setMaxResults(1);
		compliance users = query.uniqueResult();
		return users;
	}
	public compliance getCompliance(int complianceId) {
		Session session = hibernateTemplate.getSessionFactory().openSession();
		session.beginTransaction();
		Query<compliance> query = session.createQuery("from compliance where complianceId=:complianceId");
		query.setParameter("complianceId",complianceId);
		query.setMaxResults(1);
		compliance users = query.uniqueResult();
		return users;
	}
}
