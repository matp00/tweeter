<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: mateusz
  Date: 26.07.18
  Time: 23:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<form:form method="post" modelAttribute="user">
    <form:input path="username" placeholder="username"/>
    <form:password path="password" placeholder="password"/>
    <form:input path="email" placeholder="email"/>
    <form:errors path="*"/>
    <c:if test = "${checkEmail}">
        <p>Podany email jest juz zajety</p>
    </c:if>
    <input type="submit" value="Send"/>

</form:form>
</body>
</html>
