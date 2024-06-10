<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="../cdns.jsp" %>
        <title>Expense Tracker</title>
        <!--icon link-->
        <link rel="icon" href="../images/online-expensive-report-7042561-5727732.webp"/>
        <!--css including-->
        <link rel="stylesheet" href="../css/style.css"/>
    </head>
    <body>
        <nav class="navbar navbar-expand-lg bg-primary">
            <div class="container-fluid">
                <img src="../images/online-expensive-report-7042561-5727732.webp" width="55" height="55" alt="alt"/>
                <a class="navbar-brand text-white fs-3" href="dashboard.jsp"> Expense Tracker</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
                        <li class="nav-item mx-2">
                            <a class="nav-link active text-white fs-5" aria-current="page" href="addExpense.jsp"><i class="fa-solid fa-plus"></i> &nbsp;Add Expense</a>
                        </li>
                        <li class="nav-item mx-4">
                            <a class="nav-link active text-white fs-5" href="viewExpense.jsp"><i class="fa-solid fa-eye"></i> &nbsp;View Expense</a>
                        </li>
                        <li class="nav-item mx-4">
                            <a class="nav-link active text-white fs-5" onclick="signout()" href="#"><i class="fa-solid fa-right-from-bracket"></i> &nbsp;Sign out</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
        <script src="../js/logout.js"></script>
    </body>
</html>
