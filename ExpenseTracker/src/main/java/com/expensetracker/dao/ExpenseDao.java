package com.expensetracker.dao;

import com.expensetracker.entity.Expense;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class ExpenseDao {

    private SessionFactory factory;
    private Session session = null;
    private Transaction trans = null;

    public ExpenseDao(SessionFactory factory) {
        this.factory = factory;
    }

    public boolean addExpense(Expense expense) {
        boolean flag = false;
        try {
            session = factory.openSession();
            trans = session.beginTransaction();
            session.save(expense);
            flag = true;
            trans.commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    public List<Expense> getAllExpense(int id) {
        List<Expense> list = new ArrayList<>();
        try {
            session = factory.openSession();
            trans = session.beginTransaction();
            Query q = session.createQuery("from Expense where user_id = :id", Expense.class);
            q.setParameter("id", id);
            list = q.list();
            trans.commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public Expense getExpense(int expenseId) {
        Expense ex = new Expense();
        try {
            session = factory.openSession();
            trans = session.beginTransaction();
            ex = session.get(Expense.class, expenseId);
            trans.commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ex;
    }

    public boolean editExpense(Expense ex) {
        boolean flag = false;
        try {
            session = factory.openSession();
            trans = session.beginTransaction();
            session.update(ex);
            trans.commit();
            session.close();
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    public boolean deleteExpense(int expenseId) {
        boolean flag = false;
        try {
            session = factory.openSession();
            trans = session.beginTransaction();
            Expense ex = null;
            ex = session.get(Expense.class, expenseId);
            session.delete(ex);
            trans.commit();
            session.close();
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

}
