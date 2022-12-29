package com.table.per.subclass;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		SessionFactory factory = configuration.buildSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		Employee employee = new Employee();
		employee.setId(10);
		employee.setName("izhar");
		Regular_Employee regular_Employee = new Regular_Employee();
		regular_Employee.setBonus(34343);
		regular_Employee.setName("dilshad");
		regular_Employee.setSalary(78788778);

		Contract_Employee contract_Employee = new Contract_Employee();
		contract_Employee.setName("rukshar");
		contract_Employee.setContract_duration("3 month");
		contract_Employee.setPay_per_hour(23);

		Serializable save = session.save(employee);
		System.out.println(save);

		Serializable save2 = session.save(regular_Employee);
		System.out.println(save2);

		Serializable save3 = session.save(contract_Employee);
		System.out.println(save3);

		transaction.commit();

		System.out.println("Hello World!");
		session.close();
		factory.close();
	}
}
