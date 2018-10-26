<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Smart Main Page</title>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
</head>
    <body>
    <c:set var="user" value="${user}"/>
        ${user.username},<h1>Welocme!</h1>
        <br>
        Your credits is ${user.credits}
    </body>
</html>