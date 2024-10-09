<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!-- Add Bootstrap 5 CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" />

<div class="container mt-5">
    <!-- Add video and category list buttons -->
    <div class="d-flex justify-content-between mb-4">
        <a href="${pageContext.request.contextPath}/admin/video/add" class="btn btn-primary">Add Video</a>
        <a href="${pageContext.request.contextPath}/admin/categories" class="btn btn-secondary">Category List</a>
    </div>

    <!-- Video Table -->
    <table class="table table-bordered table-hover text-center align-middle">
        <thead class="table-dark">
        <tr>
            <th>Video ID</th>
            <th>Title</th>
            <th>Description</th>
            <th>Poster</th>
            <th>Views</th>
            <th>Status</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="video" items="${videoList}">
            <tr>
                <td>${video.videoId}</td>
                <td>${video.title}</td>
                <td>${video.description}</td>
                <td class="text-center" style="width: 300px; height: 200px;">
                    <img src="${pageContext.request.contextPath}/gif?fname=${video.poster}"
                         alt="${video.title}"
                         class="img-fluid rounded shadow"
                         style="width: 100%; height: 100%; object-fit: cover;" />
                </td>
                <td>${video.views}</td>
                <td>
                        <span class="badge ${video.active == 1 ? 'bg-success' : 'bg-danger'}">
                                ${video.active == 1 ? 'Active' : 'Inactive'}
                        </span>
                </td>
                <td>
                    <a href="<c:url value='/admin/video/edit?id=${video.videoId}'/>" class="btn btn-warning btn-sm">Edit</a>
                    <a href="<c:url value='/admin/video/delete?id=${video.videoId}'/>" class="btn btn-danger btn-sm">Delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<!-- Add Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
