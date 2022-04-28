/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ecommerce.daos;

import java.util.List;
import net.ecommerce.models.Publisher;
import net.ecommerce.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author thunv
 */
public class PublisherDao implements IPublisherDao {

    @Override
    public Publisher getPublisherById(int id) {
        Transaction transaction = null;
        Publisher publisher = null;
        try {
            Session session = HibernateUtils.getSessionFactory().openSession();
            // start a transaction
            transaction = session.beginTransaction();
            // get an user object
            publisher = (Publisher) session.get(Publisher.class, id);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return publisher;
    }

    @Override
    public boolean savePublisher(Publisher publisher) {
        Transaction transaction = null;
        boolean isCheck = false;
        try {
            Session session = HibernateUtils.getSessionFactory().openSession();
            // start a transaction
            transaction = session.beginTransaction();
            // save the student object
            if (publisher.getId() > 0) {
                session.update(publisher);
            } else {
                session.save(publisher);
            }
            // commit transaction
            transaction.commit();
            isCheck = true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return isCheck;
    }

    @Override
    public List getByIdPublisher(int id) {
        Transaction transaction = null;
        List< Publisher> list = null;
        try {
            Session session = HibernateUtils.getSessionFactory().openSession();
            // start a transaction
            transaction = session.beginTransaction();
            // get an user object
            String query = "from Publisher au where au.id = :id";
            list = session.createQuery(query).setParameter("id", id).list();

            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public boolean deletePublisher(Publisher publisher) {
        Transaction transaction = null;
        boolean isCheck = false;
        try {
            Session session = HibernateUtils.getSessionFactory().openSession();
            // start a transaction
            transaction = session.beginTransaction();
            // get an user object
            session.delete(publisher);
            // commit transaction
            transaction.commit();
            isCheck = true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return isCheck;
    }

    @Override
    public List<Publisher> getListPublishers(String name) {
        Transaction transaction = null;
        List< Publisher> listPublisher = null;
        try {
            Session session = HibernateUtils.getSessionFactory().openSession();
            // start a transaction
            transaction = session.beginTransaction();
            // get an user object
            String query = "from Publisher au where :name is null or au.name like :names";
            listPublisher = session.createQuery(query).setParameter("name", name).setParameter("names", "%" + name + "%").list();

            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return listPublisher;

    }

    @Override
    public List getDropdownPublisher() {
        Transaction transaction = null;
        List listPublisher = null;
        try {
            Session session = HibernateUtils.getSessionFactory().openSession();
            // start a transaction
            transaction = session.beginTransaction();
            // get an user object
            listPublisher = session.createQuery("from Publisher").list();
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return listPublisher;
    }
}
