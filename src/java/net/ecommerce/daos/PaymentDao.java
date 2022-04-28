/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ecommerce.daos;

import net.ecommerce.models.Payment;
import net.ecommerce.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author thunv
 */
public class PaymentDao implements IPaymentDao{

    @Override
    public void addCashs(Payment payment) {
        try{
            Session session = HibernateUtils.getSessionFactory().openSession();
            // start a transaction
            // get an account object
            session.save(payment);
        }
        catch (Exception e) {
          
            e.printStackTrace();
        }
    }

    @Override
    public void addChecks(Payment payment) {
        try{
            Session session = HibernateUtils.getSessionFactory().openSession();
            // start a transaction
            // get an account object
            session.save(payment);
        }
        catch (Exception e) {
            
            e.printStackTrace();
        }
    }

    @Override
    public void addCredit(Payment payment) {
        try{
            Session session = HibernateUtils.getSessionFactory().openSession();
         
            session.save(payment);
        }
        catch (Exception e) {
            
            e.printStackTrace();
        }
    }
    
}
