<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@ taglib prefix="fn" uri="jakarta.tags.functions" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Forgot Password</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css"/> <!-- Animate.css -->
</head>
<body>
<section class="vh-100">
    <div class="container py-5 h-100">
        <div class="row d-flex justify-content-center align-items-center h-100">
            <div class="col-12 col-md-8 col-lg-6 col-xl-5">
                <div class="card shadow-2-strong animate__animated animate__fadeIn" style="border-radius: 1rem;"> <!-- Added animation -->
                    <div class="card-body p-5">

                        <h3 class="mb-4 text-center animate__animated  animate__fadeInDown">Forgot Password</h3> <!-- Added animation -->

                        <form id="passwordForm" action="http://localhost:8080/LTWeb/forgotpassword" method="post">

                            <!-- Alert if needed -->
                            <c:if test="${alert != null}">
                                <div class="alert alert-danger animate__animated animate__shakeX" role="alert"> <!-- Added animation -->
                                        ${alert}
                                </div>
                            </c:if>

                            <!-- Username input -->
                            <div class="form-outline mb-4 animate__animated animate__fadeInTopLeft"> <!-- Added animation -->
                                <label class="form-label" for="username">Username</label>
                                <input type="text" id="username" name="username" class="form-control form-control-lg" placeholder="Enter your username" required />
                            </div>

                            <!-- Email input -->
                            <div class="form-outline mb-4 animate__animated animate__fadeInTopRight"> <!-- Added animation -->
                                <label class="form-label" for="email">Email</label>
                                <input type="email" id="email" name="email" class="form-control form-control-lg" placeholder="Enter your registered email" required />
                            </div>

                            <!-- New Password input -->
                            <div class="form-outline mb-4 animate__animated animate__fadeInTopLeft"> <!-- Added animation -->
                                <label class="form-label" for="new_psw">New Password</label>
                                <input type="password" id="new_psw" name="new_psw" class="form-control form-control-lg" placeholder="Enter new password" required />
                            </div>

                            <!-- Confirm New Password input -->
                            <div class="form-outline mb-4 animate__animated animate__fadeInTopRight"> <!-- Added animation -->
                                <label class="form-label" for="confirm_new_psw">Confirm New Password</label>
                                <input type="password" id="confirm_new_psw" name="confirm_new_psw" class="form-control form-control-lg" placeholder="Confirm new password" required />
                            </div>

                            <p id="error-message" style="color:red; display:none;" class="animate__animated animate__zoominup">Passwords do not match!</p> <!-- Added animation -->

                            <!-- Submit button -->
                            <button class="btn btn-primary btn-lg btn-block animate__animated animate__zoominup" type="submit">Reset Password</button> <!-- Added animation -->

                            <hr class="my-4">

                            <!-- Back to login link -->
                            <div class="text-center animate__animated animate__fadeInUp"> <!-- Added animation -->
                                <p class="small fw-bold">Back to <a href="./login" class="link-danger">Login</a></p>
                            </div>

                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

<script>
    document.getElementById('passwordForm').addEventListener('submit', function(event) {
        var newPassword = document.getElementById('new_psw').value;
        var confirmPassword = document.getElementById('confirm_new_psw').value;
        var errorMessage = document.getElementById('error-message');

        if (newPassword !== confirmPassword) {
            event.preventDefault(); // Prevent form submission
            errorMessage.style.display = 'block'; // Show error message
        } else {
            errorMessage.style.display = 'none'; // Hide error message if passwords match
        }
    });
</script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
