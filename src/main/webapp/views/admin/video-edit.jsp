<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<title>Edit Video</title>

<!-- Add Bootstrap CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" />

<div class="container mt-5">
    <h2 class="text-center mb-4">Edit Video</h2>

    <form action="${pageContext.request.contextPath}/admin/video/update" method="post" enctype="multipart/form-data" class="row g-3">

        <!-- Video ID (readonly) -->
        <div class="col-md-6">
            <label for="videoid" class="form-label">Video ID:</label>
            <input type="text" class="form-control text-center" id="videoid" name="videoid" readonly value="${video.videoId}">
        </div>

        <!-- Poster image -->
        <div class="col-md-6">
            <label for="images" class="form-label">Poster:</label><br>
            <c:if test="${video.poster.substring(0,5) !='https'}">
                <c:url value="/gif?fname=${video.poster}" var="imgUrl"></c:url>
            </c:if>
            <c:if test="${video.poster.substring(0,5) == 'https'}">
                <c:url value="${video.poster}" var="imgUrl"></c:url>
            </c:if>
            <img src="${imgUrl}" class="img-thumbnail mb-2" style="width: 200px; height: 150px;" alt="Video Poster">
            <input type="file" class="form-control" id="images" name="images" value="${video.poster}">
        </div>

        <!-- Title -->
        <div class="col-md-6">
            <label for="title" class="form-label">Title:</label>
            <input type="text" class="form-control" id="title" name="title" value="${video.title}">
        </div>

        <!-- Description -->
        <div class="col-md-12">
            <label for="description" class="form-label">Description:</label>
            <textarea class="form-control" id="description" name="description" rows="3">${video.description}</textarea>
        </div>

        <!-- Views -->
        <div class="col-md-6">
            <label for="views" class="form-label">Views:</label>
            <input type="number" class="form-control" id="views" name="views" value="${video.views}">
        </div>

        <!-- Active status (readonly) -->
        <div class="col-md-6">
            <label for="active" class="form-label">Active:</label>
            <input type="text" class="form-control text-center" id="active" name="active" value="${category.status}" >
        </div>

        <!-- Submit Button -->
        <div class="col-12 text-center">
            <input type="submit" class="btn btn-primary" value="Update">
        </div>
    </form>
</div>

<!-- Add Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
