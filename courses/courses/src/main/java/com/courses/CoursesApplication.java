package com.courses;

import com.courses.data.model.Person;

import javax.jdo.*;
import java.io.File;
import java.util.List;

public class CoursesApplication {

	public static void main(String[] args) {

		File propsFile = new File("C:/Users/carlo/Desktop/trabalho/application.txt");
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory(propsFile);

		PersistenceManager pm = pmf.getPersistenceManager();

		// Buscando registros do banco
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();

			Query<Person> query = pm.newQuery(Person.class);
			List<Person> results = query.executeList(); // Retorna a lista de PersonEntity

			for (Person person : results) {
				System.out.println("ID: " + person.getId() + ", Nome: " + person.getName());
			}

			tx.commit();
		} catch (Exception e) {
			if (tx.isActive()) {
				tx.rollback();
			}
			System.out.println("Erro: " + e.getMessage());
			e.printStackTrace();
		} finally {
			pm.close();
		}
	}
}