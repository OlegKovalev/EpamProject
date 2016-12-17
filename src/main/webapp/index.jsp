<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@include file="/WEB-INF/jspf/bundles.jspf" %>

<fmt:message bundle="${loc}" key="all.header" var="title"/>
<html>
<head>
    <title>${title}</title>
    <link rel="stylesheet" href="./css/style.css">
</head>
<%--<li><a href="./main.jsp">page - main</a></li>--%>
<body>

<%@include file="/WEB-INF/jspf/header.jspf" %>


</body>
</html>