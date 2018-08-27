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
    <title>Title</title>
    <link href="<c:url value="/css/style.css" />" rel="stylesheet">
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
        <form:form method="post" modelAttribute="tweet">
            <form:input path="text" placeholder="text" />
            <input type="submit" value="Send"/>

        </form:form>
    </div>


</body>
</html>
