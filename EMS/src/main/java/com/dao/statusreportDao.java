package com.dao;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.HibernateTemplate;

import com.bean.compliance;
import com.bean.statusreport;
public class statusreportDao {
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	public void addReport(statusreport status) {
		Session session = hibernateTemplate.getSessionFactory().openSession();
		session.beginTransaction();
			session.save(status);
			session.getTransaction().commit();
			session.close();
		}
	public void mergeReport(statusreport status) {
		Session session = hibernateTemplate.getSessionFactory().openSession();
		session.beginTransaction();
			session.save(status);
			session.getTransaction().commit();
			session.close();
		}
	public List<statusreport> getStatus(int empId) {
		Session session = hibernateTemplate.getSessionFactory().openSession();
		session.beginTransaction();
		Query<statusreport> query = session.createQuery("from statusreport where empId=:empId");
		query.setParameter("empId",empId);
		List<statusreport> users = query.getResultList();
		return users;
	}
	public List<statusreport> getReports(int complianceId) {
		Session session = hibernateTemplate.getSessionFactory().openSession();
		session.beginTransaction();
		Query<statusreport> query = session.createQuery("from statusreport where complianceId=:complianceId");
		query.setParameter("complianceId",complianceId);
		List<statusreport> users = query.getResultList();
		return users;
	}
	public void getreport(int complianceId, int userId) {
		Session session = hibernateTemplate.getSessionFactory().openSession();
		session.beginTransaction();
		Query<statusreport> query = session.createQuery(" delete from statusreport where complianceId=:complianceId and empId=:userId and comment=:comment");
		query.setParameter("complianceId",complianceId);
		query.setParameter("userId",userId);
		query.setParameter("comment","*");
		query.executeUpdate();
		session.getTransaction().commit();
		session.close();
	}
	

}
