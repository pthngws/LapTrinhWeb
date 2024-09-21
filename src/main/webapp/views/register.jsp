<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@ taglib prefix="fn" uri="jakarta.tags.functions" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register Page</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css"/> <!-- Animate.css -->
</head>
<body>
<section class="vh-100">
    <div class="container py-5 h-100">
        <div class="row d-flex justify-content-center align-items-center h-100">
            <div class="col-12 col-md-8 col-lg-6 col-xl-5">
                <div class="card shadow-2-strong animate__animated animate__heartBeat" style="border-radius: 1rem;"> <!-- Added animation -->
                    <div class="card-body p-5">

                        <h3 class="mb-4 text-center animate__animated  animate__wobble">Register</h3> <!-- Added animation -->

                        <form action="http://localhost:8080/LTWeb/register" method="post">

                            <!-- Alert if needed -->
                            
                            <!-- Full Name input -->
                            <div class="form-outline mb-4 animate__animated animate__fadeInLeft "> <!-- Added animation -->
                                <label class="form-label" for="fullname">Full Name</label>
                                <input type="text" id="fullname" name="fullname" class="form-control form-control-lg" placeholder="Enter your full name" required />
                            </div>

                            <!-- Email input -->
                            <div class="form-outline mb-4 animate__animated animate__fadeInRight"> <!-- Added animation -->
                                <label class="form-label" for="email">Email</label>
                                <input type="email" id="email" name="email" class="form-control form-control-lg" placeholder="Enter your email" required />
                            </div>

                            <!-- Username input -->
                            <div class="form-outline mb-4 animate__animated animate__fadeInLeft"> <!-- Added animation -->
                                <label class="form-label" for="username">Username</label>
                                <input type="text" id="username" name="username" class="form-control form-control-lg" placeholder="Enter your username" required />
                            </div>

                            <!-- Password input -->
                            <div class="form-outline mb-4 animate__animated animate__fadeInRight"> <!-- Added animation -->
                                <label class="form-label" for="password">Password</label>
                                <input type="password" id="password" name="password" class="form-control form-control-lg" placeholder="Enter your password" required />
                            </div>

                            <!-- Confirm Password input -->
                            <div class="form-outline mb-4 animate__animated animate__fadeInLeft"> <!-- Added animation -->
                                <label class="form-label" for="psw_confirm">Confirm Password</label>
                                <input type="password" id="psw_confirm" name="psw_confirm" class="form-control form-control-lg" placeholder="Confirm your password" required />
                            </div>

                            <!-- Submit button -->
                            <button class="btn btn-primary btn-lg btn-block animate__animated animate__zoomInUp" type="submit">Register</button> <!-- Added animation -->

                            <hr class="my-4">

                            <!-- Login link -->
                            <div class="text-center animate__animated animate__fadeInUp"> <!-- Added animation -->
                                <p class="small fw-bold">Already have an account? <a href="./login" class="link-danger">Login</a></p>
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
