<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/WEB-INF/jspf/bundles.jspf" %>
<fmt:message bundle="${loc}" key="main.title" var="title"/>
<fmt:message bundle="${loc}" key="reg.submit" var="submit"/>
<fmt:message bundle="${loc}" key="main.droplist.class" var="drop_list_class_name"/>
<fmt:message bundle="${loc}" key="main.droplist.subject" var="drop_list_subject_name"/>
<html>
<head>
    <link rel="stylesheet" href="./css/style.css">
    <link rel="stylesheet" href="./css/form.css"/>
</head>
<body>
<%@include file="/WEB-INF/jspf/header.jspf" %>
<h2>${title}</h2>

<form method="GET" action="./load_table">

    </p><select name="drop_list_class" required>
    <option selected hidden disabled>${drop_list_class_name}</option>
    <c:forEach var="schoolclass" items="${drop_list_class}">
        <option value="${schoolclass.id}">${schoolclass.number}${schoolclass.prefix}</option>
    </c:forEach>
</select>
    </br>
    </p><select name="drop_list_lesson" required>
    <option selected hidden disabled>${drop_list_subject_name}</option>
    <c:forEach var="subject" items="${drop_list_lesson}">
        <option value="${subject.id}">${subject.name}</option>
    </c:forEach>
</select>
    <%--subject drop list--%>
    </br>
    <p><input type="submit" value="${submit}"></p>

</form>
</form>
</body>
</html>