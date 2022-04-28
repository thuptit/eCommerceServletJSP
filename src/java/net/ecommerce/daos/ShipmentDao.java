/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ecommerce.daos;

import dto.OrderDto;
import java.util.List;
import net.ecommerce.models.Shipment;
import net.ecommerce.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.transform.Transformers;

/**
 *
 * @author thunv
 */
public class ShipmentDao implements IShipmentDao{

    @Override
    public Shipment addShipment(Shipment shipment) {
        Transaction transaction = null;
        try{
            Session session = HibernateUtils.getSessionFactory().openSession();
            // start a transaction
            transaction = session.beginTransaction();
            // get an account object
           session.save(shipment);
            // commit transaction
            transaction.commit();
        }
        catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return shipment;
    }
    
}
