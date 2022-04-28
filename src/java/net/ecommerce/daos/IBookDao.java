/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ecommerce.daos;

import dto.RequestOrderDto;
import java.util.List;
import net.ecommerce.models.Author;
import net.ecommerce.models.Book;
import net.ecommerce.models.BookItem;
import net.ecommerce.models.Publisher;

/**
 *
 * @author thunv
 */
public interface IBookDao {
    boolean insertBook(Book book, BookItem bookItem, String url);
    boolean updateBook(Book book, BookItem bookItem);
    List getListBook(String name);
}
