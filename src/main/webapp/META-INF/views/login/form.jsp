<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: mateusz
  Date: 26.07.18
  Time: 23:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Title</title>
    <link href="<c:url value="/css/style.css" />" rel="stylesheet">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <style>
        body {width: 100%; margin: 0px;}
        #tweets {width: 50%; height: 100%;background-color: white;float: left; }
        #form {width: 50%;height: 100%; background-color: dodgerblue;float: left; }
        .tweet{position: relative;width:50%; height: 100px; margin-left: auto; margin-right: auto; margin-top:10px;
            box-shadow: 0px 0px 3px 0.6px grey;}
        span {font-size: 12px; position: absolute; bottom: 0; right: 70;}
    </style>
</head>
<body>

<div id="tweets">
    <c:forEach items="${tweets}" var="tweet">
        <div class="tweet">
                ${tweet.user.username}
            <br>
                ${tweet.text}
            <br>
            <span>${tweet.created} ${tweet.comments.size()}  </span>

            <br>
        </div>
    </c:forEach>
</div>
<div id="form">
    <form:form method="post" modelAttribute="user">
        <div class="form-group">
            <label class="control-label col-sm-2" for="email">Email:</label>
            <div class="col-sm-10">
                <form:input path="email"  class="form-control" placeholder="Enter email"/>
            </div>
        </div>
        <br>
        <div class="form-group">
            <label class="control-label col-sm-2" for="pwd">Password:</label>
            <div class="col-sm-10">
                <form:password path="password"  class="form-control" id="pwd" placeholder="Enter password"/>
            </div>
        </div>
        <form:errors path="*"/>
        <br>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-default">Submit</button>
            </div>
        </div>

    </form:form>
</div>


</body>
</html>
