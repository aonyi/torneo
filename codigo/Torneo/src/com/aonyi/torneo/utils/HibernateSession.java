package com.aonyi.torneo.utils;
import org.hibernate.*;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/*
 * Clase que contiene la lógica de creación de una Session Hibernate
 * Es accesible desde todo el sistema y asegura mantener una única session
 */
public class HibernateSession {
    
    private static SessionFactory sessionFactory;
    private static Session session;    
    
     /**
     * Devuelve la sesión actual. Si no existe o está cerrada,
     * crea o abre respectivamente.
     * @return
     */
    public static Session getSession() {

        if (sessionFactory == null){
            Configuration configuration = new Configuration();
            configuration.configure("resources/hibernate.cfg.xml");
            StandardServiceRegistryBuilder ssrb = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
            sessionFactory = configuration.buildSessionFactory(ssrb.build());  
            session = sessionFactory.openSession();
        }
        if (session == null || !session.isOpen())
            session = sessionFactory.openSession();             
        
        return session;
    }  
    
}

