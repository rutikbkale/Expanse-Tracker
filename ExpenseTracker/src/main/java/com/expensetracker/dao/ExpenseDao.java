package com.expensetracker.dao;

import com.expensetracker.entity.Expense;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

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

}
