package com.expensetracker.dao;

import com.expensetracker.entity.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class UserDao {

    private SessionFactory factory = null;
    private Session session = null;
    private Transaction trans = null;

    public UserDao(SessionFactory factory) {
        this.factory = factory;
    }

    public UserDao() {
    }

    public boolean saveUser(User user) {
        boolean flag = false;
        try {
            session = factory.openSession();
            trans = session.beginTransaction();
            session.save(user);
            flag = true;
            trans.commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    public User validUser(String mobno, String password) {
        User user = null;
        try {
            session = factory.openSession();
            trans = session.beginTransaction();
            String hql = "FROM User WHERE mobno = :mb AND password = :ps";
            Query<User> query = session.createQuery(hql, User.class);
            query.setParameter("mb", mobno);
            query.setParameter("ps", password);

            user = (User) query.uniqueResult();
            trans.commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    public User getUser(int userId) {
        User user = null;
        try {
            session = factory.openSession();
            trans = session.beginTransaction();
            user = session.get(User.class, userId);
            trans.commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }
}
