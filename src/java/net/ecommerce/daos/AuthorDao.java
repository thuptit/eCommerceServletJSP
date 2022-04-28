/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ecommerce.daos;

import java.util.List;
import net.ecommerce.models.Author;
import net.ecommerce.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author thunv
 */
public class AuthorDao implements IAuthorDao {

    @Override
    public Author getAuthorById(int id) {
        Transaction transaction = null;
        Author author = null;
        try {
            Session session = HibernateUtils.getSessionFactory().openSession();
            // start a transaction
            transaction = session.beginTransaction();
            // get an user object
            author = (Author) session.get(Author.class, id);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return author;
    }

    @Override
    public boolean saveAuthor(Author author) {
        Transaction transaction = null;
        boolean isCheck = false;
        try {
            Session session = HibernateUtils.getSessionFactory().openSession();
            // start a transaction
            transaction = session.beginTransaction();
            // save the student object
            if (author.getId() > 0) {
                session.update(author);
            } else {
                session.save(author);
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
    public List getByIdAuthor(int id) {
        Transaction transaction = null;
        List< Author> listAuthor = null;
        try {
            Session session = HibernateUtils.getSessionFactory().openSession();
            // start a transaction
            transaction = session.beginTransaction();
            // get an user object
            String query = "from Author au where au.id = :id";
            listAuthor = session.createQuery(query).setParameter("id", id).list();

            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return listAuthor;
    }

    @Override
    public List<Author> getListAuthors(String name) {
        Transaction transaction = null;
        List< Author> listAuthor = null;
        try {
            Session session = HibernateUtils.getSessionFactory().openSession();
            // start a transaction
            transaction = session.beginTransaction();
            // get an user object
            String query = "from Author au where :name is null or au.name like :names";
            listAuthor = session.createQuery(query).setParameter("name", name).setParameter("names", "%" + name + "%").list();

            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return listAuthor;

    }

    @Override
    public boolean deleteAuthor(Author author) {
        Transaction transaction = null;
        boolean isCheck = false;
        try {
            Session session = HibernateUtils.getSessionFactory().openSession();
            // start a transaction
            transaction = session.beginTransaction();
            // get an user object
            session.delete(author);
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
    public List getDropdownAuthor() {
        Transaction transaction = null;
        List listAuthor = null;
        try {
            Session session = HibernateUtils.getSessionFactory().openSession();
            // start a transaction
            transaction = session.beginTransaction();
            // get an user object
            listAuthor = session.createQuery("from Author").list();
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return listAuthor;
    }
}
