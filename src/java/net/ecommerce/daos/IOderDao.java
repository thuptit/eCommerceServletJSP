/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ecommerce.daos;

import dto.RequestOrderDto;
import java.util.List;

/**
 *
 * @author thunv
 */
public interface IOderDao {
    void order(RequestOrderDto rqOrder); 
    List getListOrder(int customerId);
}
