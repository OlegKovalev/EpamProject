<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/WEB-INF/jspf/bundles.jspf" %>
<fmt:message bundle="${loc}" key="reg.submit" var="submit"/>
<html>
<head>
    <title><fmt:message bundle="${loc}" key="reg.header"/></title>
    <%@include file="/WEB-INF/jspf/head.jspf" %>
</head>
<body>
<div class="container">
    <%@include file="/WEB-INF/jspf/header.jspf" %>
    <form class="form-signin" role="form" method="POST" action="./registration">
        <h2 class="form-signin-heading"><fmt:message bundle="${loc}" key="reg.title"/></h2>
        <div>
            <label for="login">
                <fmt:message bundle="${loc}" key="reg_login.login.label"/>:
            </label>
            <input type="email" class="form-control" required id="login" name="login"
                   placeholder="<fmt:message bundle="${loc}" key="reg_login.login.input"/>"/>
        </div>
        <div>
            <label for="fullname">
                <fmt:message bundle="${loc}" key="reg.fullname.label"/>:
            </label>
            <input type="text" class="form-control" required id="fullname" name="fullname"
                   placeholder="<fmt:message bundle="${loc}" key="reg.fullname.input"/>"/>
        </div>
        <div>
            <label for="password">
                <fmt:message bundle="${loc}" key="reg_login.password.label"/>:
            </label>
            <input type="password" class="form-control" required id="password" name="password"
                   placeholder="<fmt:message bundle="${loc}" key="reg_login.password.input"/>"/>
        </div>
        <div>
            <label for="repeat_password">
                <fmt:message bundle="${loc}" key="reg.repeat_password.label"/>:
            </label>
            <input type="password" class="form-control" required id="repeat_password" name="repeat_password"
                   placeholder="<fmt:message bundle="${loc}" key="reg.repeat_password.input"/>"/>
        </div>

        <div>
            <input class="btn btn-lg btn btn-success btn-block" type="submit"
                   value="<fmt:message bundle="${loc}" key="reg.submit"/>"/>
        </div>

        <c:if test="${not empty error}">
            <p class="alert alert-danger error-signin"><fmt:message bundle="${loc}" key="${error}"/></p>
        </c:if>
    </form>
    <div>
        <%@include file="/WEB-INF/jspf/footer.jspf" %>
    </div>
</div>
</body>
</html>