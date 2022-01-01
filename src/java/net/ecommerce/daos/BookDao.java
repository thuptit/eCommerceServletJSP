/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ecommerce.daos;

import dto.BookDto;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import net.ecommerce.models.Author;
import net.ecommerce.models.Book;
import net.ecommerce.models.BookItem;
import net.ecommerce.models.FileDb;
import net.ecommerce.models.Publisher;
import net.ecommerce.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.transform.Transformers;

/**
 *
 * @author thunv
 */
public class BookDao {

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

    public List<Author> getListPublisher(String name) {
        Transaction transaction = null;
        List< Author> listAuthor = null;
        try {
            Session session = HibernateUtils.getSessionFactory().openSession();
            // start a transaction
            transaction = session.beginTransaction();
            // get an user object
            String query = "from Publisher au where :name is null or au.name like :names";
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

    public boolean insertBook(Book book, BookItem bookItem, String url) {
        Transaction transaction = null;
        boolean isSuccess = false;
        try {
            Session session = HibernateUtils.getSessionFactory().openSession();
            // start a transaction
            transaction = session.beginTransaction();
            // get an user object
            Author author = (Author) session.get(Author.class, book.getAuthor().getId());
            book.setAuthor(author);
            Publisher publisher = (Publisher) session.get(Publisher.class, book.getPublisher().getId());
            book.setPublisher(publisher);
            session.save(book);
            bookItem.setBook(book);
            FileDb fileDb = new FileDb(url, "cloudinary");
            session.save(fileDb);
            Set<FileDb> fileDbs = new HashSet<>();
            fileDbs.add(fileDb);
            bookItem.setFileDbs(fileDbs);
            session.save(bookItem);
            // commit transaction
            transaction.commit();
            isSuccess = true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return isSuccess;
    }

    public boolean updateBook(Book book, BookItem bookItem) {
        Transaction transaction = null;
        boolean isSuccess = false;
        try {
            Session session = HibernateUtils.getSessionFactory().openSession();
            // start a transaction
            transaction = session.beginTransaction();
            // get an user object
            session.update(book);
            bookItem.setBook(book);
            session.update(bookItem);
            // commit transaction
            transaction.commit();
            isSuccess = true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return isSuccess;
    }

    public List getListBook() {
        Transaction transaction = null;
        List<BookDto> books = null;
        try {
            Session session = HibernateUtils.getSessionFactory().openSession();
            // start a transaction
            transaction = session.beginTransaction();
            // get an user object
            String query = "SELECT bi.id as id, bi.bar_code as bar_code, bi.discount as discount, bi.price as price, bi.book_id as book_id, b.isbn as isbn, b.language as language, b.number_of_page as number_of_page, b.summary as summary, b.title as title, b.author_id as author_id, au.name as author_name, b.publisher_id as publisher_id, pb.name as publisher_name, f.path as path\n"
                    + "FROM book_items bi\n"
                    + "JOIN books b ON b.id = bi.book_id\n"
                    + "JOIN authors au ON b.author_id = au.id\n"
                    + "JOIN publishers pb ON b.publisher_id = pb.id\n"
                    + "JOIN book_item_file bif ON bif.book_item_id = bi.id\n"
                    + "JOIN files f on f.id = bif.file_id";
            books = session.createSQLQuery(query).setResultTransformer(Transformers.aliasToBean(BookDto.class)).list();
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return books;
    }
}
