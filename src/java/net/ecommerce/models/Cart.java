/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ecommerce.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.*;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 *
 * @author thunv
 */
@Entity
@Table(name = "carts")
public class Cart implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "total_price")
    private float totalPrice;

    @Column(name = "amount")
    private int amount;

    @Column(name = "status")
    private int status;

    @Column(name = "created_date")
    private Date createdDate;

    @Column(name = "updated_date")
    private Date updatedDate;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Customer.class)
    @JsonIgnoreProperties(allowGetters = true)
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customer customer;

    @ManyToMany(fetch = FetchType.LAZY, targetEntity = BookItem.class)
    @JoinTable(name = "cart_book_item",
            joinColumns = @JoinColumn(name = "cart_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "book_item_id", referencedColumnName = "id"))
    private Set<BookItem> bookItems;

    public Integer getId() {
        return id;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
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

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Set<BookItem> getBookItems() {
        return bookItems;
    }

    public void setBookItems(Set<BookItem> bookItems) {
        this.bookItems = bookItems;
    }

    
}