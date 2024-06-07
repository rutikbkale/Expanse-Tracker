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
                <div class="col-md-6 offset-md-3">
                    <div class="card box-effect">
                        <div class="card-header bg-primary text-light text-center fs-5">
                            &nbsp;&nbsp;<i class="fa-solid fa-user-plus fa-3x"></i> 
                            <p class="fw-bold">Sign Up</p>
                        </div>
                        <div class="card-body">

                            <form class="row g-3" action="signUp" method="post" id="donarForm">
                                <div class="col-md-6">
                                    <label for="fName" class="form-label fw-semibold">First Name</label>
                                    <input type="text" class="form-control" id="fName" name="fName">
                                </div>
                                <div class="col-md-6">
                                    <label for="lName" class="form-label fw-semibold">Last Name</label>
                                    <input type="text" class="form-control" id="lName" name="lName">
                                </div>
                                <div class="col-12">
                                    <label for="inputAddress" class="form-label fw-semibold">Address</label>
                                    <input type="text" class="form-control" id="inputAddress" name="address">
                                </div>
                                <div class="col-md-6">
                                    <label for="mobno" class="form-label fw-semibold">Mobile No. </label>
                                    <input type="tel" class="form-control" id="mobno" name="mobno">
                                </div>
                                <div class="col-md-6">
                                    <label for="dob" class="form-label fw-semibold">Date of Birth</label>
                                    <input type="date" class="form-control" id="dob" name="dob">
                                </div>
                                <div class="col-md-6">
                                    <label for="password" class="form-label fw-semibold">Password</label>
                                    <input type="password" class="form-control" id="password" name="password">
                                </div>
                                <div class="col-md-6">
                                    <label for="checkpass" class="form-label fw-semibold">Re-Enter Password </label>
                                    <input type="password" class="form-control" id="checkpass" name="checkpass">
                                </div>
                                <div class="col-12 text-center my-3">
                                    <button type="submit" class="btn btn-primary btn-lg fw-semibold " id="sign-btn"> Register </button>
                                </div>
                            </form>
                            <div class="text-center mb-0" id="login-btn">
                                <div>
                                    <p class="fw-semibold">Already have an account ?</p>
                                    <a href="signin.jsp" class="text-primary text-decoration-none">Click here to Login</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
