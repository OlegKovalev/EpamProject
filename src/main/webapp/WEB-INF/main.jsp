<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/WEB-INF/jspf/bundles.jspf" %>
<fmt:message bundle="${loc}" key="main.title" var="title"/>
<fmt:message bundle="${loc}" key="main.droplist.submit" var="submit"/>
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

<form method="POST" action="./load_table">

    </p>
    <select name="selectedClassId" required>
        <c:choose>
            <c:when test="${not empty selectedClassInDropList}">
                <option selected hidden
                        disabled>${selectedClassInDropList.number}${selectedClassInDropList.prefix}</option>
            </c:when>
            <c:otherwise>
                <option selected hidden disabled>${drop_list_class_name}</option>
            </c:otherwise>
        </c:choose>
        <c:forEach var="schoolclass" items="${drop_list_class}">
            <option value="${schoolclass.id}">${schoolclass.number}${schoolclass.prefix}</option>
        </c:forEach>
    </select>
    </br>
    </p>
    <select name="selectedLessonId" required>
        <c:choose>
            <c:when test="${not empty selectedLessonInDropList}">
                <option selected hidden
                        disabled>${selectedLessonInDropList.name}</option>
            </c:when>
            <c:otherwise>
                <option selected hidden disabled>${drop_list_subject_name}</option>
            </c:otherwise>
        </c:choose>
        <c:forEach var="subject" items="${drop_list_lesson}">
            <option value="${subject.id}">${subject.name}</option>
        </c:forEach>
    </select>
    <%--</br>--%>
    <p><input type="submit" value="${submit}"></p>
   
    <%--error message, if the user hasn't selected items from the drop list--%>
    <c:if test="${not empty error}">
        </br>
        <span style="color: #ff0000;"><fmt:message bundle="${loc}" key = "${error}" /></span>
    </c:if>
</form>

<c:if test="${not empty markTable}">
    <table>
        <thead>
        <tr>
            <th><fmt:message bundle="${loc}" key="main.mark_table.column.id"/></th>
            <th><fmt:message bundle="${loc}" key="main.mark_table.column.fullname"/></th>
            <c:forEach var="i" begin="1" end="${daysCount}">
                <th>${i}</th>
            </c:forEach>
            <th><fmt:message bundle="${loc}" key="main.mark_table.column.statistics"/></th>
        </tr>
        </thead>
        <c:forEach var="studentMarks" items="${markTable}" varStatus="loopCount">
            <tr>
                <td>${loopCount.count}</td>
                <td>${studentMarks.student.fullName}</td>
                <c:forEach var="i" begin="1" end="${daysCount}">
                    <c:choose>
                        <c:when test="${empty studentMarks.marks}">
                            <td></td>
                        </c:when>
                        <c:otherwise>
                            <c:forEach var="markSet" items="${studentMarks.marks}">
                                <c:choose>
                                    <c:when test="${markSet.day eq i}">
                                        <td>${markSet.mark}</td>
                                    </c:when>
                                    <c:otherwise>
                                        <td></td>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
                <td>${studentMarks.averageMark}</td>
            </tr>
        </c:forEach>
    </table>
</c:if>
<c:if test="${empty drop_list_class}">
    <c:out value="empty"/>
</c:if>
</body>
</html>