/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ecommerce.utils;

/**
 *
 * @author thunv
 */
import java.util.Properties;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import net.ecommerce.models.Account;
import net.ecommerce.models.Address;
import net.ecommerce.models.Author;
import net.ecommerce.models.Book;
import net.ecommerce.models.BookItem;
import net.ecommerce.models.Cart;
import net.ecommerce.models.Cash;
import net.ecommerce.models.Check;
import net.ecommerce.models.Credit;
import net.ecommerce.models.Customer;
import net.ecommerce.models.CustomerMember;
import net.ecommerce.models.CustomerNew;
import net.ecommerce.models.FileDb;
import net.ecommerce.models.Fullname;
import net.ecommerce.models.Order;
import net.ecommerce.models.Payment;
import net.ecommerce.models.Publisher;
import net.ecommerce.models.Shipment;
/**
 * Java based configuration
 * @author ramesh Fadatare
 *
 */
public class HibernateUtils {
	private static SessionFactory sessionFactory;

	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			try {
				Configuration configuration = new Configuration();

				// Hibernate settings equivalent to hibernate.cfg.xml's properties
				Properties settings = new Properties();
				settings.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
				settings.put(Environment.URL, "jdbc:mysql://localhost:3306/ecommerce?zeroDateTimeBehavior=convertToNull");
				settings.put(Environment.USER, "root");
				settings.put(Environment.PASS, "");
				settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");

				settings.put(Environment.SHOW_SQL, "true");

				settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");

				settings.put(Environment.HBM2DDL_AUTO, "none");

				configuration.setProperties(settings);
				configuration.addAnnotatedClass(Account.class);
                                configuration.addAnnotatedClass(Address.class);
                                configuration.addAnnotatedClass(Author.class);
                                configuration.addAnnotatedClass(Book.class);
                                configuration.addAnnotatedClass(BookItem.class);
                                configuration.addAnnotatedClass(Cart.class);
                                configuration.addAnnotatedClass(Cash.class);
                                configuration.addAnnotatedClass(Check.class);
                                configuration.addAnnotatedClass(Credit.class);
                                configuration.addAnnotatedClass(Customer.class);
                                configuration.addAnnotatedClass(CustomerMember.class);
                                configuration.addAnnotatedClass(CustomerNew.class);
                                configuration.addAnnotatedClass(FileDb.class);
                                configuration.addAnnotatedClass(Fullname.class);
                                configuration.addAnnotatedClass(Order.class);
                                configuration.addAnnotatedClass(Payment.class);
                                configuration.addAnnotatedClass(Publisher.class);
                                configuration.addAnnotatedClass(Shipment.class);

				ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
						.applySettings(configuration.getProperties()).build();
                                
				sessionFactory = configuration.buildSessionFactory(serviceRegistry);
				return sessionFactory;

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return sessionFactory;
	}
}