<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/WEB-INF/jspf/bundles.jspf" %>
<fmt:message bundle="${loc}" key="reg.title" var="title"/>
<fmt:message bundle="${loc}" key="reg.submit" var="submit"/>
<html>
<head>
    <title>${title}</title>
    <link rel="stylesheet" href="./css/style.css">
    <link rel="stylesheet" href="./css/form.css"/>
</head>
<body>
<%@include file="/WEB-INF/jspf/header.jspf" %>
<h2>${title}</h2>

<form method="POST" action="./registration">
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
        <label for="repeat_password">
            <fmt:message bundle="${loc}" key="reg.repeat.password.label"/>:
        </label>
        <input required id="repeat_password" type="password" name="repeat_password"
               placeholder="<fmt:message bundle="${loc}" key="reg.repeat.password.label"/>"/>
    </div>
    <div>
        <label for="fullname">
            <fmt:message bundle="${loc}" key="form.fullname"/>:
        </label>
        <input required id="fullname" type="text" name="fullname"
               placeholder="<fmt:message bundle="${loc}" key="reg.fullname.label"/>"/>
    </div>

    <div>
        <input type="submit" value="${submit}"/>
    </div>
</form>
</body>
</html>