package com.codegym.repository;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;

public class ConnectionUtil {
    public static SessionFactory sessionFactory;
    static {
        try {
            sessionFactory = new Configuration().configure("hibernate.conf.xml").buildSessionFactory();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

}
