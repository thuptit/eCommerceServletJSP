/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ecommerce.daos;

import java.util.List;
import net.ecommerce.models.Author;

/**
 *
 * @author thunv
 */
public interface IAuthorDao {
    Author getAuthorById(int id);
    boolean saveAuthor(Author author);
    List getByIdAuthor(int id);
    List<Author> getListAuthors(String name);
    boolean deleteAuthor(Author author);
    List getDropdownAuthor();
}
