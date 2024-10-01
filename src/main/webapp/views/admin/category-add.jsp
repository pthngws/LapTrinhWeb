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
    <label for="categoryname">Category Name</label><br>
    <input type="text" id="categoryname" name="categoryname"><br>
    <label for="image">Last name:</label><br>
    <input type="text" id="image" name="image">
    <label for="status">Last name:</label><br>
    <input type="text" id="status" name="status">
    <input type="submit" value="Insert">
</form>