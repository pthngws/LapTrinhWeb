<%--
  Created by IntelliJ IDEA.
  User: thang
  Date: 9/30/2024
  Time: 9:07 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/commons/taglib.jsp"%>
<form action="http://localhost:8080/LTWeb/admin/category/update" method="post">
    <input type="text" id="categoryid" name="categoryid" value="${cate.categoryid}" hidden="hidden" >

    <label for="categoryname">Category name</label><br>
    <input type="text" id="categoryname" name="categoryname" value="${cate.categoryname}"><br>

    <label for="image">Images</label><br>
    <input type="text" id="categoryname" name="image" ><br>

    <label for="image">Upload file:</label><br>
    <input type="file" id="image1" name="image1" onchange = "chooseFile(this)"> <br>


    <c:if test="${cate.images.substring(0,5) =='https'}">
        <c:url value="${cate.images}" var="imgUrl"></c:url>
    </c:if>

    <c:if test="${cate.images.substring(0,5) !='https'}">
        <c:url value="/image?frame=${cate.images}" var="imgUrl"></c:url>
    </c:if>

    <img id="HinhAnh" height="150" width="200" src="${imgUrl}"/><br>

    <label for="status">Status:</label><br>
    <input type="radio" id=statuson" name="status" value="1" ${cate.status==1?'checked':''}>
    <label for="status">Hoạt động</label><br>
    <input type="radio" id=statusoff" name="status" value="0" ${cate.status==0?'checked':''}>
    <label for="status">Khóa</label><br>
    <input type="submit" value="Insert">
</form>