<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jspf/base.jspf"%>              

<nav class="navbar navbar-default" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <a class="navbar-brand" href="${contextPath}/index/">${app}</a>
        </div>
        <ul class="nav navbar-nav">
            <li><a href="${contextPath}/index/">Home</a></li>
            <li><a href="${contextPath}/user/">Users</a></li>
            <li><a href="${contextPath}/item/">Items</a></li>
        </ul>
    </div>
</nav>