package com.spring.hibernate;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App 
{
    public static void main( String[] args ) throws IOException
    {
        System.out.println( "Session Factory");
        Configuration configuration = new Configuration();
        configuration.configure("com/spring/hibernate/hibernate.cfg.xml");
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        
        System.out.println(sessionFactory);
        System.out.println(sessionFactory.isClosed());
        
        Student student = new Student();
        student.setId(1004);
        student.setName("dipu");
        student.setCity("delhi");
        
//        System.out.println(student);
        
        Address address = new Address();
        address.setStreet("mayur marg");
        address.setCity("Patna");
        address.setOpen(true);
        address.setAddedDate(new Date());
        address.setX(1234.45);
        
        //Reading a file
        FileInputStream fileInputStream = new FileInputStream("src/main/java/nature.jpg");
        byte[] data = new byte[fileInputStream.available()];
        fileInputStream.read(data);
        address.setImage(data);
        
        
        
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(student);
        session.save(address);
        
        session.getTransaction().commit();			//transaction.commit();
        session.close();
        
    }
}
