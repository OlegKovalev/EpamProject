<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/WEB-INF/jspf/bundles.jspf" %>
<fmt:message bundle="${loc}" key="login.title" var="title"/>
<html>
<head>
    <title>${title}</title>
    <link rel="stylesheet" href="./css/form.css">
    <link rel="stylesheet" href="./css/style.css">
</head>
<body>
<%@include file="/WEB-INF/jspf/header.jspf" %>
<h2>${title}</h2>

<form method="POST" action="./login">
    <div>
        <label for="login">
            <fmt:message bundle="${loc}" key="form.login"/>:
        </label>
        <input required id="login" type="text" name="login"
               placeholder="<fmt:message bundle="${loc}" key="reg.login.label"/>"/>
    </div>
    <div>
        <label for="password">
            <fmt:message bundle="${loc}" key="form.password"/>:
        </label>
        <input required id="password" type="password" name="password"
               placeholder="<fmt:message bundle="${loc}" key="reg.password.label"/>"/>
    </div>
    <div>
        <input type="submit" value="<fmt:message bundle="${loc}" key="login.submit" />"/>
    </div>
    <c:if test="${not empty error}">
        </br>
        <span style="color: #ff0000;"><fmt:message bundle="${loc}" key = "${error}" /></span>
    </c:if>
    
</form>
</body>
</html>