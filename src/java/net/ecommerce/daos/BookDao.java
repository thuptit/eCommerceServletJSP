/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ecommerce.daos;

import java.util.ArrayList;
import java.util.List;
import net.ecommerce.models.Author;
import net.ecommerce.models.Publisher;
import net.ecommerce.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author thunv
 */
public class BookDao {

    public boolean saveAuthor(Author author) {
        Transaction transaction = null;
        boolean isCheck = false;
        try {
            Session session = HibernateUtils.getSessionFactory().openSession();
            // start a transaction
            transaction = session.beginTransaction();
            // save the student object
            if(author.getId() > 0){
                session.update(author);
            }
            else{
                session.save(author);
            }
            // commit transaction
            transaction.commit();
            isCheck = true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return isCheck;
    }
    
    public List getByIdAuthor(int id){
        Transaction transaction = null;
        List < Author > listAuthor = null;
        try{
            Session session = HibernateUtils.getSessionFactory().openSession();
            // start a transaction
            transaction = session.beginTransaction();
            // get an user object
            String query = "from Author au where au.id = :id";
            listAuthor = session.createQuery(query).setParameter("id", id).list();
            
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return listAuthor;
    }

    public List<Author> getListAuthors(String name){
        Transaction transaction = null;
        List < Author > listAuthor = null;
        try{
            Session session = HibernateUtils.getSessionFactory().openSession();
            // start a transaction
            transaction = session.beginTransaction();
            // get an user object
            String query = "from Author au where :name is null or au.name like :names";
            listAuthor = session.createQuery(query).setParameter("name", name).setParameter("names", "%" + name + "%").list();
            
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return listAuthor;
       
    }
    
    public boolean deleteAuthor (Author author){
        Transaction transaction = null;
        boolean isCheck = false;
        try{
            Session session = HibernateUtils.getSessionFactory().openSession();
            // start a transaction
            transaction = session.beginTransaction();
            // get an user object
           session.delete(author);
            // commit transaction
            transaction.commit();
            isCheck = true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return isCheck;
    }
    
    public boolean savePublisher(Publisher publisher) {
        Transaction transaction = null;
        boolean isCheck = false;
        try {
            Session session = HibernateUtils.getSessionFactory().openSession();
            // start a transaction
            transaction = session.beginTransaction();
            // save the student object
            if(publisher.getId() > 0){
                session.update(publisher);
            }
            else{
                session.save(publisher);
            }
            // commit transaction
            transaction.commit();
            isCheck = true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return isCheck;
    }
    
    public List getByIdPublisher(int id){
        Transaction transaction = null;
        List < Publisher > list = null;
        try{
            Session session = HibernateUtils.getSessionFactory().openSession();
            // start a transaction
            transaction = session.beginTransaction();
            // get an user object
            String query = "from Publisher au where au.id = :id";
            list = session.createQuery(query).setParameter("id", id).list();
            
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return list;
    }

    public List<Author> getListPublisher(String name){
        Transaction transaction = null;
        List < Author > listAuthor = null;
        try{
            Session session = HibernateUtils.getSessionFactory().openSession();
            // start a transaction
            transaction = session.beginTransaction();
            // get an user object
            String query = "from Publisher au where :name is null or au.name like :names";
            listAuthor = session.createQuery(query).setParameter("name", name).setParameter("names", "%" + name + "%").list();
            
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return listAuthor;
       
    }
    
    public boolean deletePublisher (Publisher publisher){
        Transaction transaction = null;
        boolean isCheck = false;
        try{
            Session session = HibernateUtils.getSessionFactory().openSession();
            // start a transaction
            transaction = session.beginTransaction();
            // get an user object
           session.delete(publisher);
            // commit transaction
            transaction.commit();
            isCheck = true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return isCheck;
    }
}
