package com.expensetracker.servlet;

import com.expensetracker.dao.ExpenseDao;
import com.expensetracker.dao.UserDao;
import com.expensetracker.entity.Expense;
import com.expensetracker.entity.User;
import com.expensetracker.helper.SessionFactoryProvider;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@MultipartConfig
public class EditExpenseServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String title = request.getParameter("title");
            String date = request.getParameter("date");
            String time = request.getParameter("time");
            String reason = request.getParameter("reason");
            String price = request.getParameter("price");
            int id = Integer.parseInt(request.getParameter("id"));
            int expenseId = Integer.parseInt(request.getParameter("expenseId"));

            UserDao udao = new UserDao(SessionFactoryProvider.getFactory());
            User user = udao.getUser(id);
            ExpenseDao dao = new ExpenseDao(SessionFactoryProvider.getFactory());

            Expense expense = dao.getExpense(expenseId);
            expense.setTitle(title);
            expense.setDate(date);
            expense.setTime(time);
            expense.setReason(reason);
            expense.setPrice(price);
            expense.setUser(user);

            boolean flag = dao.editExpense(expense);
            if (flag) {
                out.println("done");
            } else {
                out.println("error");
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
