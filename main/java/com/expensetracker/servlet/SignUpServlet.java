package com.expensetracker.servlet;

import com.expensetracker.dao.UserDao;
import com.expensetracker.entity.User;
import com.expensetracker.helper.SessionFactoryProvider;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@MultipartConfig
public class SignUpServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String fName = request.getParameter("fName");
            String lName = request.getParameter("lName");
            String address = request.getParameter("address");
            String mobno = request.getParameter("mobno");
            Date dob = null;
            try {
                String dobStr = request.getParameter("dob");
                DateFormat dateformate = new SimpleDateFormat("yyyy-mm-dd");
                dob = dateformate.parse(dobStr);
            } catch (ParseException ex) {
                Logger.getLogger(SignUpServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            String password = request.getParameter("password");

            User user = new User(fName, lName, address, mobno, dob, password);

            UserDao dao = new UserDao(SessionFactoryProvider.getFactory());
            
//            out.print(fName+lName+address+mobno+dob+password);

            boolean res = dao.saveUser(user);
//            HttpSession session = request.getSession();
            if (res) {
//                session.setAttribute("msg", "success");
//                response.sendRedirect("signup.jsp");
                out.println("done");
            } else {
                out.println("error");
//                session.setAttribute("msg", "danger");
//                response.sendRedirect("signup.jsp");
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
