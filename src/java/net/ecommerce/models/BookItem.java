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
import java.util.HashSet;
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
@Table(name = "book_items")
public class BookItem implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "bar_code")
    private String barCode;

    @Column(name = "price")
    private float price;

    @Column(name = "discount")
    private String discount;

    @Column(name = "created_date")
    private Date createdDate;

    @OneToOne
    @JsonIgnoreProperties
    @JoinColumn(name = "book_id", referencedColumnName = "id")
    private Book book;

    @ManyToMany(fetch = FetchType.LAZY, targetEntity = FileDb.class)
    @JoinTable(name = "book_item_file",
            joinColumns = @JoinColumn(name = "book_item_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "file_id", referencedColumnName = "id"))
    private Set<FileDb> fileDbs = new HashSet<>();

    public BookItem (String  barCode, String discount, float price, Book book, Set<FileDb> fileDbs){
        this.barCode = barCode;
        this.discount = discount;
        this.price = price;
        this.book = book;
        this.fileDbs = fileDbs;
    }

    public Integer getId() {
        return id;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Set<FileDb> getFileDbs() {
        return fileDbs;
    }

    public void setFileDbs(Set<FileDb> fileDbs) {
        this.fileDbs = fileDbs;
    }
    
    
}