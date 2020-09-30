<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<nav class="navbar navbar-inverse">
<div class="container-fluid">
    <div class="navbar-header">
        <a class="navbar-brand" href="/">Home</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
        <sec:authorize access="isAuthenticated()">
        <jsp:include page="/WEB-INF/jsp/menu.jsp"/>
        </sec:authorize>
        <ul class="nav navbar-nav navbar-right">
            <sec:authorize access="!isAuthenticated()">
                <li><a href="/login"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
            </sec:authorize>
            <sec:authorize access="isAuthenticated()">
                <li><a href="/logout"><span class="glyphicon glyphicon-log-in"></span> Logout</a></li>
            </sec:authorize>

        </ul>
    </div>
</div>
</nav>