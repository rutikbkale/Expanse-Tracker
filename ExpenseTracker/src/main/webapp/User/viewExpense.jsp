<%@page import="com.expensetracker.entity.Expense"%>
<%@page import="java.util.List"%>
<%@page import="com.expensetracker.helper.SessionFactoryProvider"%>
<%@page import="com.expensetracker.dao.ExpenseDao"%>
<%@page import="com.expensetracker.entity.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="userNav.jsp" %>
    </head>
    <body>
        <div class="mt-4 container">
            <div class="row">
                <div class="col-md-12">
                    <h2 class="text-center">Expense Details</h2><br>
                    <table class="table table-hover table-bordered table-striped">
                        <thead class="bg-info t-white">
                            <tr>
                                <th scope="col" class="text-center">Expense Id</th>
                                <!--<th scope="col" class="text-center">User Id</th>-->
                                <th scope="col" class="text-center">Expense Title</th>
                                <th scope="col" class="text-center">Issued Date</th>
                                <th scope="col" class="text-center">Issued Time</th>
                                <th scope="col" class="text-center">Reason</th>
                                <th scope="col" class="text-center">Price</th>
                                <th scope="col" class="text-center">Action</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%
                                User user = (User) session.getAttribute("currentUser");
                                int id = user.getId();
                                ExpenseDao dao = new ExpenseDao(SessionFactoryProvider.getFactory());
                                List<Expense> list = dao.getAllExpense(id);

                                for (Expense e : list) {
                            %>
                            <tr>
                                <td><%= e.getId()%></td>
                                <!--<td><%= e.getUser().getId()%></td>-->
                                <td><%= e.getTitle()%></td>
                                <td><%= e.getDate()%></td>
                                <td><%= e.getTime()%></td>
                                <td><%= e.getReason()%></td>
                                <td><%= e.getPrice()%></td>
                                <td class='d-flex justify-content-evenly'>
                                    <a href="editExpense.jsp?expenseId=<%=e.getId()%>" class="btn btn-primary badge-pill">Edit</a>
                                    <a href="../DeleteExpenseServlet?expenseId=<%=e.getId()%>" class="btn btn-danger badge-pill">Delete</a>
                                </td>
                            </tr>
                            <%
                                }
                            %>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </body>
</html>
