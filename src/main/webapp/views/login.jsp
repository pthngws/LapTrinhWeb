<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@ taglib prefix="fn" uri="jakarta.tags.functions" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Page</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
</head>
<body>
<section class="vh-100">
    <div class="container-fluid h-custom">
        <div class="row d-flex justify-content-center align-items-center h-100">
            <div class="col-md-9 col-lg-6 col-xl-5">
                <img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-login-form/draw2.webp"
                     class="img-fluid" alt="Sample image">
            </div>
            <div class="col-md-8 col-lg-6 col-xl-4 offset-xl-1">
                <form action="http://localhost:8080/LTWeb/login" method="post">
                    <!-- Alert if needed -->

                    <script>
                        window.onload = function() {
                            var alertMessage = "${alert}";
                            if (alertMessage) {
                                alert(alertMessage); // Hiển thị thông báo dưới dạng popup
                            }
                        }
                    </script>

                    <%--                    <div class="d-flex flex-row align-items-center justify-content-center justify-content-lg-start">--%>
                    <%--                        <p class="lead fw-normal mb-0 me-3">Sign in with</p>--%>
                    <%--                        <button type="button" class="btn btn-primary btn-floating mx-1">--%>
                    <%--                            <i class="fab fa-facebook-f"></i>--%>
                    <%--                        </button>--%>
                    <%--                        <button type="button" class="btn btn-primary btn-floating mx-1">--%>
                    <%--                            <i class="fab fa-twitter"></i>--%>
                    <%--                        </button>--%>
                    <%--                        <button type="button" class="btn btn-primary btn-floating mx-1">--%>
                    <%--                            <i class="fab fa-linkedin-in"></i>--%>
                    <%--                        </button>--%>
                    <%--                    </div>--%>

                    <!-- Username input -->
                    <div class="form-outline mb-4">
                        <input type="text" id="form3Example3" name="uname" class="form-control form-control-lg" placeholder="Enter a valid username" required/>
                        <label class="form-label" for="form3Example3">Username</label>
                    </div>

                    <!-- Password input -->
                    <div class="form-outline mb-3">
                        <input type="password" id="form3Example4" name="psw" class="form-control form-control-lg" placeholder="Enter password" required/>
                        <label class="form-label" for="form3Example4">Password</label>
                    </div>

                    <div class="d-flex justify-content-between align-items-center">
                        <!-- Checkbox -->
                        <div class="form-check mb-0">
                            <input class="form-check-input me-2" type="checkbox" name="remember" id="form2Example3" />
                            <label class="form-check-label" for="form2Example3">
                                Remember me
                            </label>
                        </div>
                        <a href="./forgotpass.jsp" class="text-body">Forgot password?</a>
                    </div>

                    <div class="text-center text-lg-start mt-4 pt-2">
                        <button type="submit" class="btn btn-primary btn-lg"
                                style="padding-left: 2.5rem; padding-right: 2.5rem;">Login</button>
                        <p class="small fw-bold mt-2 pt-1 mb-0">Don't have an account? <a href="./register.jsp" class="link-danger">Register</a></p>
                    </div>
                </form>
            </div>
        </div>
    </div>

    <div class="d-flex flex-column flex-md-row text-center text-md-start justify-content-between py-4 px-4 px-xl-5 bg-primary">
        <!-- Copyright -->
        <div class="text-white mb-3 mb-md-0">
            Copyright © 2020. All rights reserved.
        </div>

        <!-- Social Media Links -->
        <div>
            <a href="#" class="text-white me-4"><i class="fab fa-facebook-f"></i></a>
            <a href="#" class="text-white me-4"><i class="fab fa-twitter"></i></a>
            <a href="#" class="text-white me-4"><i class="fab fa-google"></i></a>
            <a href="#" class="text-white"><i class="fab fa-linkedin-in"></i></a>
        </div>
    </div>
</section>
</body>
</html>
