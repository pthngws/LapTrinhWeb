<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@ taglib prefix="fn" uri="jakarta.tags.functions" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Forgot Password</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css">
</head>
<body>
<section class="vh-100">
    <div class="container py-5 h-100">
        <div class="row d-flex justify-content-center align-items-center h-100">
            <div class="col-12 col-md-8 col-lg-6 col-xl-5">
                <div class="card shadow-2-strong" style="border-radius: 1rem;">
                    <div class="card-body p-5">

                        <h3 class="mb-4 text-center">Forgot Password</h3>

                        <form action="http://localhost:8080/LTWeb/forgotpassword" method="post">

                            <!-- Alert if needed -->
                            <c:if test="${alert != null}">
                                <div class="alert alert-danger" role="alert">
                                        ${alert}
                                </div>
                            </c:if>
                            <!-- Username input -->
                            <div class="form-outline mb-4">
                                <label class="form-label" for="username">Username</label>
                                <input type="text" id="username" name="username" class="form-control form-control-lg" placeholder="Enter your username" required />
                            </div>
                            <!-- Email input -->
                            <div class="form-outline mb-4">
                                <label class="form-label" for="email">Email</label>
                                <input type="email" id="email" name="email" class="form-control form-control-lg" placeholder="Enter your registered email" required />
                            </div>

                            <!-- New Password input -->
                            <div class="form-outline mb-4">
                                <label class="form-label" for="new_psw">New Password</label>
                                <input type="password" id="new_psw" name="new_psw" class="form-control form-control-lg" placeholder="Enter new password" required />
                            </div>

                            <!-- Confirm New Password input -->
                            <div class="form-outline mb-4">
                                <label class="form-label" for="confirm_new_psw">Confirm New Password</label>
                                <input type="password" id="confirm_new_psw" name="confirm_new_psw" class="form-control form-control-lg" placeholder="Confirm new password" required />
                            </div>

                            <!-- Submit button -->
                            <button class="btn btn-primary btn-lg btn-block" type="submit">Reset Password</button>

                            <hr class="my-4">

                            <!-- Back to login link -->
                            <div class="text-center">
                                <p class="small fw-bold">Back to <a href="./login.jsp" class="link-danger">Login</a></p>
                            </div>

                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
