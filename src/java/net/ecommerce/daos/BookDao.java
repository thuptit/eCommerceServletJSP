/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ecommerce.daos;

import java.util.ArrayList;
import java.util.List;
import net.ecommerce.models.Author;
import net.ecommerce.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author thunv
 */
public class BookDao {

    public void saveAuthor(Author author) {
        Transaction transaction = null;
        try {
            Session session = HibernateUtils.getSessionFactory().openSession();
            // start a transaction
            transaction = session.beginTransaction();
            // save the student object
            session.save(author);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
    
    @SuppressWarnings("unchecked")
    public List<Author> getAuthor(){
        Transaction transaction = null;
        List < Author > listOfUser = null;
        try{
            Session session = HibernateUtils.getSessionFactory().openSession();
            // start a transaction
            transaction = session.beginTransaction();
            // get an user object

            listOfUser = session.createQuery("from Author").list();

            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return listOfUser;
       
    }
}
