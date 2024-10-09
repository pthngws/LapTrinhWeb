<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<title>Add Video</title>

<!-- Add Bootstrap CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" />

<div class="container mt-5">
    <h2 class="text-center mb-4">Add Video</h2>

    <form action="${pageContext.request.contextPath}/admin/video/insert" method="post" enctype="multipart/form-data" class="row g-3">
        <!-- Category ID (readonly) -->
        <div class="col-md-6">
            <label for="cateID" class="form-label">Category ID:</label>
            <input type="text" name="categoryid" id="cateID" class="form-control text-center" value="${category.categoryid}">
        </div>

        <!-- Video ID -->
        <div class="col-md-6">
            <label for="videoid" class="form-label">Video ID:</label>
            <input type="text" name="video" id="videoid" class="form-control">
        </div>

        <!-- Title -->
        <div class="col-md-6">
            <label for="title" class="form-label">Title:</label>
            <input type="text" id="title" name="title" class="form-control">
        </div>

        <!-- Description -->
        <div class="col-md-12">
            <label for="description" class="form-label">Description:</label>
            <textarea class="form-control" id="description" name="description" rows="3"></textarea>
        </div>

        <!-- Poster image -->
        <div class="col-md-6">
            <label for="poster" class="form-label">Poster:</label>
            <input type="file" id="poster" name="poster" class="form-control">
            <img height="150" width="200" src="" class="mt-2" alt="Preview Poster" />
        </div>

        <!-- Views -->
        <div class="col-md-6">
            <label for="views" class="form-label">Views:</label>
            <input type="number" id="views" name="views" class="form-control">
        </div>

        <!-- Active status (readonly) -->
        <div class="col-md-6">
            <label for="status" class="form-label">Active:</label>
            <input type="text" id="status" name="status" class="form-control text-center" value="${category.status}">
        </div>

        <!-- Submit Button -->
        <div class="col-12 text-center">
            <input type="submit" class="btn btn-primary" value="Add">
            <a href="${pageContext.request.contextPath}/admin/videos?id=${category.categoryid}" class="btn btn-secondary ms-2">Cancel</a>
        </div>
    </form>
</div>

<!-- Add Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
