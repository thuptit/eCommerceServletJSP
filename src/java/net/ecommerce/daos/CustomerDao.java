/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ecommerce.daos;

import java.util.List;
import net.ecommerce.models.Account;
import net.ecommerce.models.Customer;
import net.ecommerce.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author thunv
 */
public class CustomerDao implements ICustomerDao{
    @Override
    public List<Account> checkLogin(String username, String password){
        Transaction transaction = null;
        List result = null;
        try{
            Session session = HibernateUtils.getSessionFactory().openSession();
            // start a transaction
            transaction = session.beginTransaction();
            // get an account object
            String sql = "from Account a where a.username = :username and a.password = :password";
            List data = session.createQuery(sql).setParameter("username", username)
                                                .setParameter("password", password)
                                                .list();
            if(!data.isEmpty()) result = data;
            // commit transaction
            transaction.commit();
        }
        catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return result;
    }
    
    @Override
    public Customer getCustomerById(int Id){
        Transaction transaction = null;
        Customer cus = new Customer();
        try{
            Session session = HibernateUtils.getSessionFactory().openSession();
            // start a transaction
            transaction = session.beginTransaction();
            // get an account object
            String sql = "from Customer cus where cus.id = :Id";
            cus = (Customer) session.createQuery(sql).setParameter("Id", Id)
                                                .uniqueResult();
            // commit transaction
            transaction.commit();
        }
        catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return cus;
    }
}
