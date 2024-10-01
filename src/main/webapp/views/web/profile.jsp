<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/commons/taglib.jsp"%>
<div class="col-md-9 col-sm-7">
    <h1>Standart forms</h1>
    <div class="content-form-page">
        <form role="form" class="form-horizontal form-without-legend" method="post" action="/LTWeb/profile" enctype="multipart/form-data">
            <div class="form-group">
                <label class="col-lg-2 control-label" for="first-name">Username <span class="require">*</span></label>
                <div class="col-lg-8">
                    <input type="text" id="username" class="form-control" name = "username" value="${sessionScope.account.username}" readonly>
                </div>
            </div>
            <div class="form-group">
                <label class="col-lg-2 control-label" for="first-name">Full Name <span class="require">*</span></label>
                <div class="col-lg-8">
                    <input type="text" id="first-name" class="form-control" name = "fullname" value="${sessionScope.account.fullname}">
                </div>
            </div>
            <div class="form-group">
                <label class="col-lg-2 control-label" for="email">E-Mail <span class="require">*</span></label>
                <div class="col-lg-8">
                    <input type="text" id="email" name="email" class="form-control" value="${sessionScope.account.email}">
                </div>
            </div>
            <div class="form-group">
                <label class="col-lg-2 control-label" for="telephone">Telephone <span class="require">*</span></label>
                <div class="col-lg-8">
                    <input type="text" id="telephone" name="phone" class="form-control" value="${sessionScope.account.phone}">
                </div>
            </div>
            <div class="form-group">
                <label class="col-lg-2 control-label" for="telephone">Role <span class="require">*</span></label>
                <div class="col-lg-8">
                    <c:if test="${sessionScope.account.roleid == 1}">
                        <input type="text" id="role" class="form-control" value="Admin" readonly></c:if>
                    <c:if test="${sessionScope.account.roleid == 2}">
                        <input type="text" id="role" class="form-control" value="Manager" readonly></c:if>
                    <c:if test="${sessionScope.account.roleid == 3}">
                        <input type="text" id="role" class="form-control" value="Seller" readonly></c:if>
                    <c:if test="${sessionScope.account.roleid == 4}">
                        <input type="text" id="role" class="form-control" value="Shipper" readonly></c:if>
                    <c:if test="${sessionScope.account.roleid == 5}">
                        <input type="text" id="role" class="form-control" value="User" readonly></c:if>

                </div>
            </div>
            <div class="form-group">
                <label class="col-lg-2 control-label">File input</label>
                <div class="col-lg-8">
                    <input type="file" name="image">
                    <c:if test="${message !=null}">${message}</c:if>
                    <p class="help-block">some help text here.</p>
                </div>
            </div>
            <div class="form-group">
                <label class="col-lg-2 control-label" for="message">Message</label>
                <div class="col-lg-8">
                    <textarea class="form-control" rows="6"></textarea>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-8 col-md-offset-2 padding-left-0 padding-top-20">
                    <button class="btn btn-primary" type="submit">Submit</button>
                </div>
            </div>
        </form>
    </div>
</div>