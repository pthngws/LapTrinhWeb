<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@ taglib prefix="fn" uri="jakarta.tags.functions" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login Page</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css"/> <!-- Animate.css -->
</head>
<body>
<div class="col-md-9 col-sm-9">
    <h1>Login</h1>
    <div class="content-form-page">
        <div class="row">
            <div class="col-md-7 col-sm-7">
                <form class="form-horizontal form-without-legend" role="form" method="post" action="http://localhost:8080/LTWeb/login">
                    <div class="form-group">
                        <label for="username" class="col-lg-4 control-label">Username <span class="require">*</span></label>
                        <div class="col-lg-8">
                            <input type="text" class="form-control" id="username" name="uname">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="password" class="col-lg-4 control-label">Password <span class="require">*</span></label>
                        <div class="col-lg-8">
                            <input type="text" class="form-control" id="password" name="psw">
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-lg-8 col-md-offset-4 padding-left-0">
                            <a href="page-forgotton-password.html">Forget Password?</a>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-lg-8 col-md-offset-4 padding-left-0 padding-top-20">
                            <button type="submit" class="btn btn-primary">Login</button>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-lg-8 col-md-offset-4 padding-left-0 padding-top-10 padding-right-30">
                            <hr>
                            <div class="login-socio">
                                <p class="text-muted">or login using:</p>
                                <ul class="social-icons">
                                    <li><a href="#" data-original-title="facebook" class="facebook" title="facebook"></a></li>
                                    <li><a href="#" data-original-title="Twitter" class="twitter" title="Twitter"></a></li>
                                    <li><a href="#" data-original-title="Google Plus" class="googleplus" title="Google Plus"></a></li>
                                    <li><a href="#" data-original-title="Linkedin" class="linkedin" title="LinkedIn"></a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
            <div class="col-md-4 col-sm-4 pull-right">
                <div class="form-info">
                    <h2><em>Important</em> Information</h2>
                    <p>Duis autem vel eum iriure at dolor vulputate velit esse vel molestie at dolore.</p>

                    <button type="button" class="btn btn-default">More details</button>
                </div>
            </div>
        </div>
    </div>
</div>
<%--<section class="vh-100">--%>
<%--    <div class="container d-flex align-items-center justify-content-center h-100">--%>
<%--        <div class="row">--%>
<%--            <div class="col-md-6 d-none d-md-block">--%>
<%--                <img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-login-form/draw2.webp"--%>
<%--                     class="img-fluid animate__animated animate__flipInX" alt="Sample image">--%>
<%--            </div>--%>
<%--            <div class="col-md-6">--%>
<%--                <div class="card shadow-sm" style="border-radius: 1rem;">--%>
<%--                    <div class="card-body">--%>
<%--                        <h5 class="card-title text-center">Login</h5>--%>
<%--                        <form action="http://localhost:8080/LTWeb/login" method="post">--%>
<%--                            <!-- Alert if needed -->--%>
<%--                            <c:if test="${alert != null}">--%>
<%--                                <div class="alert alert-danger animate__animated animate__shakeX" role="alert">--%>
<%--                                        ${alert}--%>
<%--                                </div>--%>
<%--                            </c:if>--%>

<%--                            <script>--%>
<%--                                window.onload = function() {--%>
<%--                                    var alertMessage = "${alert}";--%>
<%--                                    if (alertMessage) {--%>
<%--                                        alert(alertMessage); // Hiển thị thông báo dưới dạng popup--%>
<%--                                    }--%>
<%--                                }--%>
<%--                            </script>--%>

<%--                            <!-- Username input -->--%>
<%--                            <div class="form-group mb-4 animate__animated animate__fadeInBottomLeft">--%>
<%--                                <input type="text" id="form3Example3" name="uname" class="form-control form-control-lg" placeholder="Enter a valid username" required/>--%>
<%--                                <label class="form-label" for="form3Example3">Username</label>--%>
<%--                            </div>--%>

<%--                            <!-- Password input -->--%>
<%--                            <div class="form-group mb-3 animate__animated animate__fadeInBottomRight">--%>
<%--                                <input type="password" id="form3Example4" name="psw" class="form-control form-control-lg" placeholder="Enter password" required/>--%>
<%--                                <label class="form-label" for="form3Example4">Password</label>--%>
<%--                            </div>--%>

<%--                            <div class="d-flex justify-content-between align-items-center mb-4">--%>
<%--                                <div class="form-check">--%>
<%--                                    <input class="form-check-input animate__animated animate__fadeInLeft" type="checkbox" name="remember" id="form2Example3" />--%>
<%--                                    <label class="form-check-label animate__animated animate__fadeInLeft" for="form2Example3">Remember me</label>--%>
<%--                                </div>--%>
<%--                                <a href="./forgotpassword" class="text-body animate__animated animate__fadeInRight">Forgot password?</a>--%>
<%--                            </div>--%>

<%--                            <div class="text-center">--%>
<%--                                <button type="submit" class="btn btn-primary btn-lg animate__animated animate__zoomInUp">Login</button>--%>
<%--                                <p class="small fw-bold mt-2 animate__animated animate__bounceIn">Don't have an account? <a href="./register" class="link-danger animate__animated animate__bounceIn">Register</a></p>--%>
<%--                            </div>--%>
<%--                        </form>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--    </div>--%>

<%--    <footer class="text-center text-lg-start text-white bg-primary py-4">--%>
<%--        <div class="container">--%>
<%--            <div class="text-center mb-3">Copyright © 2020. All rights reserved.</div>--%>
<%--            <div>--%>
<%--                <a href="#" class="text-white me-4"><i class="fab fa-facebook-f"></i></a>--%>
<%--                <a href="#" class="text-white me-4"><i class="fab fa-twitter"></i></a>--%>
<%--                <a href="#" class="text-white me-4"><i class="fab fa-google"></i></a>--%>
<%--                <a href="#" class="text-white"><i class="fab fa-linkedin-in"></i></a>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--    </footer>--%>
<%--</section>--%>

<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/4.5.2/js/bootstrap.bundle.min.js"></script>
</body>
</html>