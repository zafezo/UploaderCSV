/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import data.Statistic;
import data.User;
import java.util.ArrayList;
import java.util.List;

import data.UserASM;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author nazar
 */
public class HibernateUtil {

     private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            // loads configuration and mappings
            Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
//            configuration.addClass(data.User.class);
            ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
//            ServiceRegistry serviceRegistry
//                = new StandardServiceRegistryBuilder()
//                    .applySettings(configuration.getProperties()).build();
//
//            // builds a session factory from the service registry
//            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        }

        return sessionFactory;
    }
    public static void addUsers( ArrayList<User> users ) throws Exception{
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tr = null;
        try{
            tr = session.beginTransaction();
            users.stream().forEach(session::save);
            tr.commit();
        }catch (HibernateException e) {
            if (tr!=null) tr.rollback();
            e.printStackTrace(); 
         }finally {
            session.close(); 
         }
    }

    public static List<User> findAllUsers(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<User> users = null;
        Transaction tr = null;
        try{
            tr = session.beginTransaction();
            Query query = session.createQuery("from User");
            users =  query.list();
            tr.commit();
        }catch (HibernateException e) {
            if (tr!=null) tr.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return users;
    }


    public static void deleteUserById(int id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tr = null;
        try{
            tr = session.beginTransaction();
            Query query = session.createQuery("delete from User where id = :userid");
            query.setParameter("userid", id);
            query.executeUpdate();

            System.out.println("deleted"+id);

            tr.commit();
        }catch (HibernateException e) {
            if (tr!=null) tr.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }


    public static void updateUserById(User user){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tr = null;
        try{
            tr = session.beginTransaction();
            session.update(user);
            tr.commit();
        }catch (HibernateException e) {
            if (tr!=null) tr.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }

    public static void addStatistic(Statistic statistic){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tr = null;
        try{
            tr = session.beginTransaction();
            session.save(statistic);
            tr.commit();
        }catch (HibernateException e) {
            if (tr!=null) tr.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }


    public static List<Statistic> getStatistics()
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Statistic> statistics=null;
        Transaction tr = null;
        try{
            tr = session.beginTransaction();
            Query query = session.createQuery("from Statistic ");
            statistics =  query.list();
            tr.commit();
        }catch (HibernateException e) {
            if (tr!=null) tr.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return statistics;
    }

    public static void addUser(User user){
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Statistic> statistics=null;
        Transaction tr = null;
        try{
            tr = session.beginTransaction();
            session.save(user);
            tr.commit();
        }catch (HibernateException e) {
            if (tr!=null) tr.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }

    };

}
