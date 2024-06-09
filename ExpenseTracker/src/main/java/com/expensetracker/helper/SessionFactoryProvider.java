package com.expensetracker.helper;

import java.util.Properties;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

public class SessionFactoryProvider {

    private static SessionFactory factory;

    public static SessionFactory getFactory() {
        if (factory == null) {
            synchronized (SessionFactoryProvider.class) {
                if (factory == null) {
                    try {
                        Configuration config = new Configuration();
                        Properties p = new Properties();

                        p.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
                        p.put(Environment.URL, "jdbc:mysql://localhost:3306/expensetracker");
                        p.put(Environment.USER, "root");
                        p.put(Environment.PASS, "1234");
                        p.put(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");
                        p.put(Environment.HBM2DDL_AUTO, "update");
                        p.put(Environment.SHOW_SQL, true);
                        p.put(Environment.FORMAT_SQL, true);

                        config.setProperties(p);
                        config.addAnnotatedClass(com.expensetracker.entity.User.class);
                        config.addAnnotatedClass(com.expensetracker.entity.Expense.class);

                        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                                .applySettings(config.getProperties()).build();

                        factory = config.buildSessionFactory(serviceRegistry);
                    } catch (Exception e) {
                        e.printStackTrace();
                        throw new ExceptionInInitializerError("SessionFactory creation failed");
                    }
                }
            }
        }
        return factory;
    }
}
