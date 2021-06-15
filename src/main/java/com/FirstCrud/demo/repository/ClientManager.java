package com.FirstCrud.demo.repository;

import com.FirstCrud.demo.Client;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class ClientManager {
    public static void main(String[] args){
        SessionFactory sessionFactory = buildSessionFactory();
        Session session = sessionFactory.openSession();

        session.getTransaction().begin();

        Client cl1 = new Client();
        cl1.setName("Petr");
        cl1.setPhone("123");
        cl1.setEmail("petr@g.com");
        Long id = (Long) session.save(cl1);
        System.out.println(id);
        session.getTransaction().commit();
        session.close();
    }

    private static SessionFactory buildSessionFactory() {
        try {
            StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .configure("hibernate.cfg.xml").build();

            Metadata metadata = new MetadataSources(serviceRegistry).getMetadataBuilder().build();

            return metadata.getSessionFactoryBuilder().build();
        } catch (Throwable ex) {

            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
}
