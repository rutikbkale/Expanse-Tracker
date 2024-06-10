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
                <div class="col-md-4 offset-md-4">
                    <div class="card box-effect">
                        <div class="card-header bg-primary text-light text-center fs-5">
                            &nbsp;&nbsp;<i class="fa-solid fa-plus fa-3x"></i> 
                            <p class="fw-bold">Add Expense</p>
                        </div>
                        <div class="card-body">
                            <form class="row g-3" action="../AddExpenseServlet" method="POST" id="addexpenseForm">
                                <div class="col-md-12">
                                    <label for="title" class="form-label fw-semibold">Title </label>
                                    <input type="text" class="form-control" id="title" name="title">
                                </div>
                                <div class="col-md-12">
                                    <label for="date" class="form-label fw-semibold">Date</label>
                                    <input type="date" class="form-control" id="date" name="date">
                                </div>
                                <div class="col-md-12">
                                    <label for="time" class="form-label fw-semibold">Time</label>
                                    <input type="time" class="form-control" id="time" name="time">
                                </div>
                                <div class="col-md-12">
                                    <label for="reason" class="form-label fw-semibold">Reason</label>
                                    <input type="text" class="form-control" id="reason" name="reason">
                                </div>
                                <div class="col-md-12">
                                    <label for="price" class="form-label fw-semibold">Price</label>
                                    <input type="text" class="form-control" id="price" name="price">
                                </div>
                                <div class="container text-center my-3" style="display: none" id="loader">
                                    <span class="fa fa-refresh fa-spin fa-3x" style="color: red"></span>
                                </div>
                                <%
                                    User user = (User) session.getAttribute("currentUser");
                                    int id = user.getId();
                                %>
                                <input type="hidden" name ="id" value="<%= id%>" >
                                <div class="col-12 text-center">
                                    <button type="submit" class="btn btn-primary btn-lg fw-semibold " id="add-btn"> Add </button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <script src="../js/addExpense.js"></script>
    </body>
</html>
