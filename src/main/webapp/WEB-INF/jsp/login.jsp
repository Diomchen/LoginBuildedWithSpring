<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
    <head>
        <title>Smart Blog</title>
    </head>
    <body>
    <c:if test="${!empty error}">
        <font color="red"><c:out value="${error}"/></font>
    </c:if>
    <form action="<c:url value="/loginCheck.html"/>" method = "post" >
        Username:
        <input type="text" name="username">
        <br>
        Password
        <input type="password" name="password">
        <br>
        <input type="submit" value="Submit">
        <input type="reset" value="Reset">
    </form>
    </body>
</html>