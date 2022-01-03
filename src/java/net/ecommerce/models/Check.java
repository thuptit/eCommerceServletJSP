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
@Table(name = "checks")
@PrimaryKeyJoinColumn(name = "payment_id")
public class Check extends Payment implements Serializable {
    @Column(name = "name")
    private String name;

    @Column(name = "bank_id")
    private String bankId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBankId() {
        return bankId;
    }

    public void setBankId(String bankId) {
        this.bankId = bankId;
    }

    public Check() {
    }

    public Check(String name, String bankId) {
        this.name = name;
        this.bankId = bankId;
    }

    public Check(String name, String bankId, int id, float amount, Date createdDate, Date updatedDate, Order order, Shipment shipment) {
        super(id, amount, createdDate, updatedDate, order, shipment);
        this.name = name;
        this.bankId = bankId;
    }

}
