package com.prowings.testcom.prowings.query;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.prowings.onetomany.bidirectional.Employee;
import com.prowings.util.HibernateUtil;

public class TestHibernateQuery {

	public static void main(String[] args) {

		Session session = HibernateUtil.getSession();

//		Query query = session.createQuery("from Employee e where e.id = 2");
		Query query = session.createQuery("from Employee e where e.salary > 9000 ORDER BY e.name ASC");

		List<Employee> empLst = query.list();

		for (Employee e : empLst) {
			System.out.println(e);
		}

		System.out.println(">>>>>>>>>>>update <<<<<<<<<<<<");

		Transaction txn = session.beginTransaction();

		Query updateQuery = session.createQuery("update Employee set DEPARTMENT = :dept" + " where EMP_ID = :eId");
		updateQuery.setParameter("dept", "HR");
		updateQuery.setParameter("eId", 2);

		updateQuery.executeUpdate();
		txn.commit();
	}

}