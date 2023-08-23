package com.prowings.test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.prowings.onetomany.bidirectional.Employee;
import com.prowings.util.HibernateUtil;

public class TestOneToManyBiDirectional {

	public static List<Employee> getEmployeeList() {

		Session session = null;
		List<Employee> empList = null;
		try {
			session = HibernateUtil.getSession();
			String queryStr = "select emp from Employee emp";
			Query query = session.createQuery(queryStr);
			empList = query.list();
		} catch (Exception ex) {
			ex.printStackTrace();
			// handle exception here
		} finally {
			try {
				if (session != null)
					session.close();
			} catch (Exception ex) {
			}
		}
		return empList;
	}

	public static void main(String[] args) {

		List<Employee> empList = getEmployeeList();

		System.out.println("emp size: " + empList.size());
		System.out.println("---------------------------");

		for (Employee e : empList) {
			System.out.println(e);
		}

		System.out.println("---------------------------");

	}

}