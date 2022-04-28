/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ecommerce.daos;

import java.util.List;
import net.ecommerce.models.Account;
import net.ecommerce.models.Customer;

/**
 *
 * @author thunv
 */
public interface ICustomerDao {
    List<Account> checkLogin(String username, String password);
    Customer getCustomerById(int Id);
}
