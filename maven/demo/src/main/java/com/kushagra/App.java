package com.kushagra;


import java.util.Arrays;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
    
    public static void main(String[] args) {
        alien a1 =new alien();
        a1.setName("princy");
        a1.setId(3);
        a1.setTech("Java");//it was used for saving the data in database.
        
        

        Laptop l1 = new Laptop();
        l1.setBrand("Lenovo");
        l1.setLid(1);
        l1.setModel("A6000");

        Laptop l2 = new Laptop();
        l2.setBrand("Dell");
        l2.setLid(2);
        l2.setModel("Inspiron");

        // student s1 = new student();
       //  s1.setName("princy");
        // s1.setRollno(3);
        // s1.setAge(20);//we are using this object to update the data in database.
                         //we dont need these for deletion.
        a1.setLaptops(Arrays.asList(l1, l2));//we are using this object to save the data in database.we use Arrays.asList() method to convert the array of objects into a list of objects, because we are using List in alien class. we can also use Set or Map instead of List.
       
        l1.setAlien(a1);
        l2.setAlien(a1);
        // student s2;
        // Configuration cfg = new Configuration();
        // cfg.addAnnotatedClass(com.kushagra.student.class);
        // cfg.configure();

        try (SessionFactory sf = new Configuration()
                                .addAnnotatedClass(com.kushagra.alien.class)
                                .addAnnotatedClass(com.kushagra.Laptop.class)
                                .configure()
                                .buildSessionFactory(); 
                                Session session = sf.openSession()) {
            // s1=session.get(student.class, 2);//fetching the data from database to delete it.
            Transaction tx = session.beginTransaction();//you need transaction to save or update or delete the data in database, or when you are changing something.
            
            // session.persist(s1);//save() is removed in latest hibernate version, so we use persist() instead of save() to save the data.
            //tx.commit(); //commit the transaction to save or updatethe data in database.

            // s2 = session.get(student.class, 1); // get() method is used to fetch the data from database, it takes two parameters, first is the class name and second is the primary key value of the record you want to fetch.
            // System.out.println(s2); //we are updating so we dont need get() method.

            //session.merge(s1);// merge() method is used to update the data in database instead of update() method, 
                              // because update() method will throw an exception if the object is not in the session,
                              //  but merge() method will not and update is depricated now.
                              //merge() method can also be used to save the data in database if the object is not in the session, but it will return a new object which is in the session, so we need to assign it to a new object.
            
            // session.remove(s1);//to delete the data, you just have to pass thee object containing the data. now you can delete without first fetching the data from database, but you then need to give data to object just like what we doing while saving the data.
            session.persist(a1);
            session.persist(l1);
            session.persist(l2);
            
            
            tx.commit();
        }

    }
}
