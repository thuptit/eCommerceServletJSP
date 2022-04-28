/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ecommerce.daos;

import net.ecommerce.models.Shipment;

/**
 *
 * @author thunv
 */
public interface IShipmentDao {
    Shipment addShipment(Shipment shipment);
}
