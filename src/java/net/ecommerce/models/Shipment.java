/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ecommerce.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.persistence.Table;
/**
 *
 * @author thunv
 */
@Entity
@Table(name = "shipments")
public class Shipment implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "type")
    private String type;

    @Column(name = "code_ship")
    private String codeShip;

    @Column(name = "address")
    private String address;

    @Column(name = "created_date")
    private Date createdDate;

    @Column(name = "updated_date")
    private Date updatedDate;

    @OneToOne
    @JsonIgnoreProperties
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    private Order order;

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCodeShip() {
        return codeShip;
    }

    public void setCodeShip(String codeShip) {
        this.codeShip = codeShip;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Shipment() {
    }

    public Shipment(int id, String type, String codeShip, String address, Date createdDate, Date updatedDate, Order order) {
        this.id = id;
        this.type = type;
        this.codeShip = codeShip;
        this.address = address;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
        this.order = order;
    }
    
}
