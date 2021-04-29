package com.luv2.demo.hibernate;

import com.luv2.hibernate.demo.entity.student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;


public class QueryStudentDemo {
    public static void main(String[] args){
        //create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(student.class)
                .buildSessionFactory();

        //create session
        Session session = factory.getCurrentSession();
        
        try {
            //create student object
            student tempStudent =
                    new student("mai","sherif","mai122001");
            //start a transaction
            session.beginTransaction();

            //query student
            List<student> theSudents = session.createQuery("from student").getResultList();

            //display student
            for(student tempStudent2 : theSudents){
                System.out.println(tempStudent2);
            }
            //save the student object
            session.save(tempStudent);
            //commit a transaction
            session.getTransaction().commit();
        }
        finally{
            factory.close();
        }
    }
}
