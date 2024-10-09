<%--
  Created by IntelliJ IDEA.
  User: thang
  Date: 9/30/2024
  Time: 9:07 AM
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/commons/taglib.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Update Category</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
    <h2 class="text-center mb-4">Update Category</h2>

    <form action="<c:url value='/admin/category/update'/>" method="post" enctype="multipart/form-data">
        <!-- Hidden Category ID -->
        <input type="hidden" id="categoryid" name="categoryid" value="${cate.categoryid}">

        <!-- Category Name -->
        <div class="mb-3">
            <label for="categoryname" class="form-label">Category Name:</label>
            <input type="text" class="form-control" id="categoryname" name="categoryname" value="${cate.categoryname}" required>
        </div>

        <!-- Link Image -->
        <div class="mb-3">
            <label for="image" class="form-label">Link Image:</label>
            <input type="text" class="form-control" id="image" name="image" value="${cate.images}">
        </div>

        <!-- Upload File -->
        <div class="mb-3">
            <label for="image1" class="form-label">Upload File:</label>
            <input type="file" class="form-control" id="image1" name="image1" onchange="chooseFile(this)">
        </div>

        <!-- Current Image Preview -->
        <c:if test="${cate.images != null}">
            <c:choose>
                <c:when test="${cate.images.substring(0,5) == 'https'}">
                    <c:url value="${cate.images}" var="imgUrl"></c:url>
                </c:when>
                <c:otherwise>
                    <c:url value="/image?frame=${cate.images}" var="imgUrl"></c:url>
                </c:otherwise>
            </c:choose>
            <img id="HinhAnh" class="img-thumbnail mb-3" height="150" width="200" src="${imgUrl}" alt="Current Category Image"/>
        </c:if>

        <!-- Status -->
        <div class="mb-3">
            <label class="form-label">Status:</label><br>
            <div class="form-check form-check-inline">
                <input class="form-check-input" type="radio" id="statuson" name="status" value="1" ${cate.status == 1 ? 'checked' : ''}>
                <label class="form-check-label" for="statuson">Hoạt động</label>
            </div>
            <div class="form-check form-check-inline">
                <input class="form-check-input" type="radio" id="statusoff" name="status" value="0" ${cate.status == 0 ? 'checked' : ''}>
                <label class="form-check-label" for="statusoff">Khóa</label>
            </div>
        </div>

        <!-- Submit Button -->
        <div class="text-center">
            <input type="submit" class="btn btn-primary" value="Update">
        </div>
    </form>
</div>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
