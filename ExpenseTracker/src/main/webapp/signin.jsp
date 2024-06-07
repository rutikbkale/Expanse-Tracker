<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Expense Tracker</title>
        <%@include file="cdns.jsp" %>
    </head>
    <body>
        <%@include file="navbar.jsp" %>
        <div class="mt-4 container">
            <div class="row">
                <div class="col-md-4 offset-md-4">
                    <div class="card box-effect">
                        <div class="card-header bg-primary text-light text-center fs-5">
                            &nbsp;&nbsp;<i class="fas fa-user-shield fa-3x"></i> 
                            <p class="fw-bold">Sign In</p>
                        </div>
                        <div class="card-body">

                            <form class="row g-3" action="signUp" method="post" id="donarForm">
                                <div class="col-md-12">
                                    <label for="mobno" class="form-label fw-semibold">Mobile No. </label>
                                    <input type="tel" class="form-control" id="mobno" name="mobno">
                                </div>
                                <div class="col-md-12">
                                    <label for="password" class="form-label fw-semibold">Password</label>
                                    <input type="password" class="form-control" id="password" name="password">
                                </div>
                                <div class="col-12 text-center">
                                    <button type="submit" class="btn btn-primary btn-lg fw-semibold " id="sign-btn"> Login </button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
