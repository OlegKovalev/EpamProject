<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@include file="/WEB-INF/jspf/bundles.jspf" %>
<fmt:message bundle="${loc}" key="all.header" var="title"/>
<html>
<head>
    <title><fmt:message bundle="${loc}" key="all.header"/></title>
    <%@include file="/WEB-INF/jspf/head.jspf" %>
</head>
<body>
<div class="container">
    <%@include file="/WEB-INF/jspf/header.jspf" %>
    <p class="welcome"><img src="media/welcome.jpg" alt="Welcome!"></p>
    <div>
        <%@include file="/WEB-INF/jspf/footer.jspf" %>
    </div>
</div>
</body>
</html>