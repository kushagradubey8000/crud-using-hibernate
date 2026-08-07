package com.kushagra;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
    @SuppressWarnings("removal")
    public static void main(String[] args) {
        student s1 = new student();
        // s1.setName("princy");
        // s1.setRollno(3);
        // s1.setAge(21);//it was used for saving the data in database.

        //  s1.setName("princy");
        // s1.setRollno(3);
        // s1.setAge(20);//we are using this object to update the data in database.
                         //we dont need these for deletion.
        
        // student s2;
        // Configuration cfg = new Configuration();
        // cfg.addAnnotatedClass(com.kushagra.student.class);
        // cfg.configure();

        try (SessionFactory sf = new Configuration()
                                .addAnnotatedClass(com.kushagra.student.class)
                                .configure()
                                .buildSessionFactory(); 
                                Session session = sf.openSession()) {
            s1=session.get(student.class, 2);//fetching the data from database to delete it.
            Transaction tx = session.beginTransaction();//you need transaction to save or update or delete the data in database, or when you are changing something.
            
            // session.persist(s1);//save() is removed in latest hibernate version, so we use persist() instead of save() to save the data.
            //tx.commit(); //commit the transaction to save or updatethe data in database.

            // s2 = session.get(student.class, 1); // get() method is used to fetch the data from database, it takes two parameters, first is the class name and second is the primary key value of the record you want to fetch.
            // System.out.println(s2); //we are updating so we dont need get() method.

            //session.merge(s1);// merge() method is used to update the data in database instead of update() method, 
                              // because update() method will throw an exception if the object is not in the session,
                              //  but merge() method will not and update is depricated now.
                              //merge() method can also be used to save the data in database if the object is not in the session, but it will return a new object which is in the session, so we need to assign it to a new object.
            
            session.remove(s1);//to delete the data, you just have to pass thee object containing the data. now you can delete without first fetching the data from database, but you then need to give data to object just like what we doing while saving the data.
            tx.commit();
        }

    }
}
