<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@ taglib prefix="fn" uri="jakarta.tags.functions" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Dashboard - Laptop Store</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css"/> <!-- Animate.css -->
</head>
<body>

<!-- Navigation Bar -->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <a class="navbar-brand" href="#">LaptopStore</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav ml-auto">
            <li class="nav-item">
                <a class="nav-link" href="#">Welcome, ${sessionScope.username}!</a>
            </li>
            <li class="nav-item">
                <form action="${pageContext.request.contextPath}/logout" method="get">
                    <button type="submit" class="btn btn-outline-light">Logout</button>
                </form>
            </li>
        </ul>
    </div>
</nav>

<!-- Welcome Section -->
<div class="container mt-5 animate__animated animate__fadeInDown">
    <div class="jumbotron text-center">
        <h1 class="display-4">Welcome, ${sessionScope.username}!</h1>
        <p class="lead">Explore the latest laptops and offers exclusively for you.</p>
        <a class="btn btn-primary btn-lg" href="#products" role="button">View Products</a>
    </div>
</div>

<%--<!-- Product Section -->--%>
<%--<section id="products" class="mt-5">--%>
<%--    <div class="container">--%>
<%--        <h2 class="text-center animate__animated animate__fadeInLeft">Featured Laptops</h2>--%>
<%--        <div class="row">--%>
<%--            <!-- Laptop 1 -->--%>
<%--            <div class="col-md-4 animate__animated animate__fadeInUp">--%>
<%--                <div class="card mb-4 shadow-sm">--%>
<%--                    <img class="card-img-top" src="laptop1.jpg" alt="Laptop 1">--%>
<%--                    <div class="card-body">--%>
<%--                        <h5 class="card-title">Laptop Model A</h5>--%>
<%--                        <p class="card-text">A powerful laptop with amazing features for productivity.</p>--%>
<%--                        <a href="#" class="btn btn-primary">View Details</a>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--            <!-- Laptop 2 -->--%>
<%--            <div class="col-md-4 animate__animated animate__fadeInUp">--%>
<%--                <div class="card mb-4 shadow-sm">--%>
<%--                    <img class="card-img-top" src="laptop2.jpg" alt="Laptop 2">--%>
<%--                    <div class="card-body">--%>
<%--                        <h5 class="card-title">Laptop Model B</h5>--%>
<%--                        <p class="card-text">Designed for gaming with top-notch performance.</p>--%>
<%--                        <a href="#" class="btn btn-primary">View Details</a>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--            <!-- Laptop 3 -->--%>
<%--            <div class="col-md-4 animate__animated animate__fadeInUp">--%>
<%--                <div class="card mb-4 shadow-sm">--%>
<%--                    <img class="card-img-top" src="laptop3.jpg" alt="Laptop 3">--%>
<%--                    <div class="card-body">--%>
<%--                        <h5 class="card-title">Laptop Model C</h5>--%>
<%--                        <p class="card-text">A lightweight and portable laptop for on-the-go use.</p>--%>
<%--                        <a href="#" class="btn btn-primary">View Details</a>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</section>--%>

<%--<!-- Account Settings Section -->--%>
<%--<section id="account-settings" class="mt-5">--%>
<%--    <div class="container animate__animated animate__fadeInRight">--%>
<%--        <h2 class="text-center">Account Settings</h2>--%>
<%--        <div class="row">--%>
<%--            <div class="col-md-6">--%>
<%--                <h4>Personal Information</h4>--%>
<%--                <p><strong>Username:</strong> ${sessionScope.username}</p>--%>
<%--                <p><strong>Email:</strong> ${sessionScope.email}</p>--%>
<%--                <a href="#" class="btn btn-secondary">Edit Profile</a>--%>
<%--            </div>--%>
<%--            <div class="col-md-6">--%>
<%--                <h4>Order History</h4>--%>
<%--                <ul class="list-group">--%>
<%--                    <li class="list-group-item">Order #12345 - Laptop Model A - Delivered</li>--%>
<%--                    <li class="list-group-item">Order #12346 - Laptop Model B - Shipped</li>--%>
<%--                    <li class="list-group-item">Order #12347 - Laptop Model C - Processing</li>--%>
<%--                </ul>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</section>--%>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.2/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>
