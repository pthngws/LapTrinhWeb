<%--
  Created by IntelliJ IDEA.
  User: thang
  Date: 9/30/2024
  Time: 9:07 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/commons/taglib.jsp"%>
<form action="http://localhost:8080/LTWeb/admin/category/insert" method="post">
    <label for="fname">Category name:</label><br>
    <input type="text" id="fname" name="categoryname"><br>
    <label for="image">Link Image:</label><br>
    <input type="text" id="image" name="image"><br>

    <label for="image1">Upload Image:</label><br>
    <input type="file" id="image1" name="image1"><br>

    <label>Status:</label><br>

    <input type="radio" id="statuson" name="status" value="1">
    <label for="fname">Hoạt động</label><br>
    <input type="radio" id="statusoff" name="status" value="0">
    <label for="fname">Không Hoạt động</label>
    <hr>

    <input type="submit" value="Insert">
</form>