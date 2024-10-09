<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/commons/taglib.jsp"%>
<a href="<c:url value="/admin/category/add"/>">add</a>
<table>
    <tr>
        <th>STT</th>
        <th>Image</th>
        <th>Category Name</th>
        <th>Status</th>
        <th>Action</th>
    </tr>
    <c:forEach items= "${listCategory}" var="cate" varStatus="STT" >
        <tr>
            <td>${STT.index+1 }</td>

            <c:if test = "${cate.images.substring(0,5) == 'https'}">
                <c:url value="${cate.images}" var="imgUrl"></c:url>
            </c:if>

            <c:if test = "${cate.images.substring(0,5) != 'https'}">
                <c:url value="/image?frame=${cate.images}" var="imgUrl"></c:url>
            </c:if>

            <td><img height="150" width="200" src= "${imgUrl}" /></td>
            <td>${cate.categoryname }</td>
            <td>${cate.status }</td>
            <td><a href="<c:url value='/admin/category/edit?id=${cate.categoryid }'/>">Sửa</a>
                | <a href="<c:url value='/admin/category/delete?id=${cate.categoryid }'/>">Xóa</a></td>
        </tr>
    </c:forEach>
</table>