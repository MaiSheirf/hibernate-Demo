package com.luv2.demo.hibernate;

import com.luv2.hibernate.demo.entity.student;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;


public class CreateDtudentDemo {
    public static void main(String[] args){
        //create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(com.luv2.hibernate.demo.entity.student.class)
                .buildSessionFactory();

        //create session
        Session session = factory.getCurrentSession();
        
        try {
            //create student object
            com.luv2.hibernate.demo.entity.student tempStudent =
                    new student("mai","sherif","mai122001");
            //start a transaction
            session.beginTransaction();
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
