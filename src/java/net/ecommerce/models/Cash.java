/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ecommerce.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
/**
 *
 * @author thunv
 */
@Entity
@Table(name = "cashs")
@PrimaryKeyJoinColumn(name = "payment_id")
public class Cash extends Payment implements Serializable {
    @Column(name = "cash_tendered")
    private float cashTendered;

    public float getCashTendered() {
        return cashTendered;
    }

    public void setCashTendered(float cashTendered) {
        this.cashTendered = cashTendered;
    }

    public Cash() {
    }

    public Cash(float cashTendered) {
        this.cashTendered = cashTendered;
    }

    public Cash(float cashTendered, int id, float amount, Date createdDate, Date updatedDate, Order order, Shipment shipment) {
        super(id, amount, createdDate, updatedDate, order, shipment);
        this.cashTendered = cashTendered;
    }
    
}
