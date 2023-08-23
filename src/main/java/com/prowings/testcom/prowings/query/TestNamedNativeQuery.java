package com.prowings.testcom.prowings.query;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.prowings.onetomany.bidirectional.Employee;
import com.prowings.util.HibernateUtil;

public class TestNamedNativeQuery {

	public static void main(String[] args) {

		Session session = HibernateUtil.getSession();

//		Query namedQuery = session.getNamedQuery("QUERY_GET_ALL_EMP");
		Query namedQuery = session.getNamedQuery("QUERY_GET_ALL_EMP_FIL_SALARY");

		List<Employee> lst = namedQuery.list();

		for (Employee e : lst) {
			System.out.println(e);
		}

	}

}