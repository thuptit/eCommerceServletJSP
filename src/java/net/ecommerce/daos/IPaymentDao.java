/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ecommerce.daos;

import net.ecommerce.models.Payment;

/**
 *
 * @author thunv
 */
public interface IPaymentDao {
    void addCashs(Payment payment);
    void addChecks(Payment payment);
    void addCredit(Payment payment);
}
