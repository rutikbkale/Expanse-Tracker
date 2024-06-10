<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Expense Tracker</title>
        <%@include file="cdns.jsp" %>
        <%@include file="navbar.jsp" %>
    </head>
    <body>
        <div id="carouselExampleControls" class="carousel slide" data-bs-ride="carousel">
            <div class="carousel-inner">
                <div class="carousel-item active">
                    <img src="images/expenseimg1.webp" class="w-100 img-fluid" style="height: 702px" alt="...">
                </div>
                <div class="carousel-item">
                    <img src="images/expenseimg2.jpg" class="w-100 img-fluid" style="height: 702px" alt="...">
                </div>
                <div class="carousel-item">
                    <img src="images/expenseimg3.jpeg" class="w-100 img-fluid" style="height: 702px" alt="...">
                </div>
            </div>
            <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleControls" data-bs-slide="prev">
                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                <span class="visually-hidden">Previous</span>
            </button>
            <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleControls" data-bs-slide="next">
                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                <span class="visually-hidden">Next</span>
            </button>
        </div>
    </body>
</html>
