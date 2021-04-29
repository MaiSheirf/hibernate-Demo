package com.luv2.demo.hibernate;

import com.luv2.hibernate.demo.entity.student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PrimaryKeyDemo {
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
            com.luv2.hibernate.demo.entity.student tempStudent2 =
                    new student("mai2","sherif2","mai2122001");
            com.luv2.hibernate.demo.entity.student tempStudent3 =
                    new student("mai3","sherif3","mai3122001");

            //start a transaction
            session.beginTransaction();
            //save the student object
            session.save(tempStudent);
            session.save(tempStudent2);
            session.save(tempStudent3);
            //commit a transaction
            session.getTransaction().commit();
        }
        finally{
            factory.close();
        }
    }
    }

