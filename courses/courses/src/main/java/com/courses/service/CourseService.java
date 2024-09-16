package com.courses.service;

import com.courses.data.model.Person;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import java.util.List;

public class CourseService {

    private static final PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("unit");

    public List<Person> findAllPersons() {
        PersistenceManager pm = pmf.getPersistenceManager();
        Query query = pm.newQuery(Person.class);
        return (List<Person>) query.execute();
    }
}
