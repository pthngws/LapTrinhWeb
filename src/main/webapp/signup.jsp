<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@ taglib prefix="fn" uri="jakarta.tags.functions" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register Page</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css">
</head>
<body>
<section class="vh-100">
    <div class="container py-5 h-100">
        <div class="row d-flex justify-content-center align-items-center h-100">
            <div class="col-12 col-md-8 col-lg-6 col-xl-5">
                <div class="card shadow-2-strong" style="border-radius: 1rem;">
                    <div class="card-body p-5">

                        <h3 class="mb-4 text-center">Register</h3>

                        <form action="./register" method="post">

                            <!-- Alert if needed -->
                            <c:if test="${alert != null}">
                                <div class="alert alert-danger" role="alert">
                                        ${alert}
                                </div>
                            </c:if>

                            <!-- Full Name input -->
                            <div class="form-outline mb-4">
                                <label class="form-label" for="fullname">Full Name</label>
                                <input type="text" id="fullname" name="fullname" class="form-control form-control-lg" placeholder="Enter your full name" required />
                            </div>

                            <!-- Email input -->
                            <div class="form-outline mb-4">
                                <label class="form-label" for="email">Email</label>
                                <input type="email" id="email" name="email" class="form-control form-control-lg" placeholder="Enter your email" required />
                            </div>

                            <!-- Username input -->
                            <div class="form-outline mb-4">
                                <label class="form-label" for="uname">Username</label>
                                <input type="text" id="uname" name="uname" class="form-control form-control-lg" placeholder="Enter your username" required />
                            </div>

                            <!-- Password input -->
                            <div class="form-outline mb-4">
                                <label class="form-label" for="psw">Password</label>
                                <input type="password" id="psw" name="psw" class="form-control form-control-lg" placeholder="Enter your password" required />
                            </div>

                            <!-- Confirm Password input -->
                            <div class="form-outline mb-4">
                                <label class="form-label" for="psw_confirm">Confirm Password</label>
                                <input type="password" id="psw_confirm" name="psw_confirm" class="form-control form-control-lg" placeholder="Confirm your password" required />
                            </div>

                            <!-- Submit button -->
                            <button class="btn btn-primary btn-lg btn-block" type="submit">Register</button>

                            <hr class="my-4">

                            <!-- Login link -->
                            <div class="text-center">
                                <p class="small fw-bold">Already have an account? <a href="index.jsp" class="link-danger">Login</a></p>
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
