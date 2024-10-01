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
    <label for="categoryid">Category ID</label><br>
    <input type="text" id="categoryid" name="categoryname" hidden="hidden" value="${cate.categoryid}"><br>
    <label for="categoryname">Category Name</label><br>
    <input type="text" id="categoryname" name="categoryname" value="${cate.categoryname}"><br>
    <label for="image">Last name:</label><br>
    <input type="text" id="image" name="image">
        <c:if test= "${cate.image.substring(0,5)=='https'}">
            <c:url value="${cate.image}" var="imgUrl"></c:url></c:if>
        <c:if test= "${cate.image.substring(0,5)!='https'}">
            <c:url value="/image?fname=${cate.image}" var="imgUrl"></c:url></c:if>
        <td><img height="150" width="200" src="${imgUrl}" />
<%--    <label for="status">Last name:</label><br>--%>
<%--    <input type="text" id="status" name="status" value="1" ${case.status==1?'check':''}>--%>
<%--&lt;%&ndash;            <input type="text" id="status" name="status" value="0" ${case.status==0?'check':''}>&ndash;%&gt;--%>
    <input type="submit" value="Update">
</form>