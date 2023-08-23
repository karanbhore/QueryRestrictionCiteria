package com.prowings.testcom.prowings.query;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.prowings.onetomany.bidirectional.Employee;
import com.prowings.util.HibernateUtil;

public class TestCriteria {

	public static void main(String[] args) {

		Session session = HibernateUtil.getSession();

		Criteria crit = session.createCriteria(Employee.class);

		crit.add(Restrictions.eq("name", "Amar M"));

		Employee emp = (Employee) crit.uniqueResult();

		System.out.println(emp);

		Criteria crit2 = session.createCriteria(Employee.class);

		crit2.add(Restrictions.gt("salary", 9000L));
		crit2.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		List<Employee> el = crit2.list();

		for (Employee e : el) {
			System.out.println(e);
		}

	}

}