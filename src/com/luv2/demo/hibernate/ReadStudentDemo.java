package com.luv2.demo.hibernate;

import com.luv2.hibernate.demo.entity.student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class ReadStudentDemo {
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
            //save the student object
            session.save(tempStudent);
            //commit a transaction
            session.getTransaction().commit();

            //new code
            session = factory.getCurrentSession();
            session.beginTransaction();
            //retrieve
            student myStudent = session.get(student.class,tempStudent.getId());
            System.out.println(myStudent);
            //commit
            session.getTransaction().commit();
        }
        finally{
            factory.close();
        }
    }
}
