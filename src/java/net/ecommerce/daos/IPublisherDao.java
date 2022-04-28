/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ecommerce.daos;

import java.util.List;
import net.ecommerce.models.Author;
import net.ecommerce.models.Publisher;

/**
 *
 * @author thunv
 */
public interface IPublisherDao {
    Publisher getPublisherById(int id);
    boolean savePublisher(Publisher publisher);
    List getByIdPublisher(int id);
    boolean deletePublisher(Publisher publisher);
    List<Publisher> getListPublishers(String name);
    List getDropdownPublisher();
}
