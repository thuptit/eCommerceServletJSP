/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ecommerce.daos;

import dto.RequestOrderDto;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import net.ecommerce.models.BookItem;
import net.ecommerce.models.Cart;
import net.ecommerce.models.Cash;
import net.ecommerce.models.Check;
import net.ecommerce.models.Credit;
import net.ecommerce.models.Customer;
import net.ecommerce.models.Order;
import net.ecommerce.models.Payment;
import net.ecommerce.models.Shipment;
import net.ecommerce.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author thunv
 */
public class OrderDao {
    public void order(RequestOrderDto rqOrder){
        Transaction transaction = null;
        boolean isCheck = false;
        try {
            Session session = HibernateUtils.getSessionFactory().openSession();
            // start a transaction
            transaction = session.beginTransaction();
            // save the student object
            Customer cus = (Customer) session.get(Customer.class, rqOrder.customerId);
            String[] idsBookItem = rqOrder.ids.split(",");
            Set<BookItem> setBookItem = new HashSet<>();
            for(int i = 0 ; i < idsBookItem.length - 1; i++){
                BookItem bookItem = (BookItem) session.get(BookItem.class, Integer.parseInt(idsBookItem[i]));
                setBookItem.add(bookItem);
            }
            Cart cart = new Cart(0, rqOrder.totalPrice, rqOrder.amount, 0, new Date(), new Date(), cus, setBookItem);
            session.save(cart);
            Order order = new Order(0, new Date(), new Date(), "Success", cus, cart);
            session.save(order);
            Shipment shipment = new Shipment(0, rqOrder.typeShip, "COD", rqOrder.address, new Date(), new Date(), order);
            session.save(shipment);
            if(rqOrder.typePayment == 1){
                Payment payment = new Cash(0, rqOrder.amount, rqOrder.totalPrice, new Date(), new Date(), order, shipment);
                session.save(payment);
            }
            else if(rqOrder.typePayment == 2){
                Payment payment = new Check(rqOrder.bankName, rqOrder.bankid, 0, rqOrder.totalPrice, new Date(), new Date(), order, shipment);
                session.save(payment);
            }
            else{
                Date expDate=new SimpleDateFormat("dd/MM/yyyy").parse(rqOrder.expDate);  
                Payment payment = new Credit(rqOrder.number, rqOrder.typeCard, expDate, 0, rqOrder.amount, new Date(), new Date(), order, shipment);
                session.save(payment);
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
    }
}
