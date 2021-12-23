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
import lombok.NoArgsConstructor;
import org.hibernate.annotations.LazyToOne;
import org.hibernate.annotations.LazyToOneOption;
/**
 *
 * @author thunv
 */
@Entity
@Table(name = "customers")
@Inheritance(strategy = InheritanceType.JOINED)
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "DOB")
    private Date dob;

    @Column(name = "created_date")
    private Date createdDate;

    @Column(name = "updated_date")
    private Date updatedDate;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "customer", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    @LazyToOne(LazyToOneOption.NO_PROXY)
    private Account account;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "customer", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    @LazyToOne(LazyToOneOption.NO_PROXY)
    private Address address;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "customer", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    @LazyToOne(LazyToOneOption.NO_PROXY)
    private Fullname fullname;

    public Integer getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
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

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Fullname getFullname() {
        return fullname;
    }

    public void setFullname(Fullname fullname) {
        this.fullname = fullname;
    }

}
