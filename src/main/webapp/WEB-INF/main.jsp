<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/WEB-INF/jspf/bundles.jspf" %>
<fmt:message bundle="${loc}" key="main.droplist.submit" var="submit"/>
<fmt:message bundle="${loc}" key="main.droplist.statement_type.marks" var="marks"/>
<fmt:message bundle="${loc}" key="main.droplist.statement_type.visits" var="visits"/>

<html>
<head>
    <title><fmt:message bundle="${loc}" key="main.header"/></title>
    <%@include file="/WEB-INF/jspf/head.jspf" %>
</head>
<body>

<div class="container">
    <%@include file="/WEB-INF/jspf/header.jspf" %>

    <%--drop lists--%>
    <form class="form-droplist" method="POST" action="./load_table">
        <h2 class="form-droplist-heading"><fmt:message bundle="${loc}" key="main.title"/></h2>
        <div>
            <select class="form-control" name="selectedClassId" required>
                <c:choose>
                    <c:when test="${not empty selectedClassInDropList}">
                        <option selected hidden
                                value="${selectedClassInDropList.id}">${selectedClassInDropList.number}${selectedClassInDropList.prefix}</option>
                    </c:when>
                    <c:otherwise>
                        <option selected hidden disabled><fmt:message bundle="${loc}"
                                                                      key="main.droplist.class"/></option>
                    </c:otherwise>
                </c:choose>
                <c:forEach var="schoolclass" items="${drop_list_class}">
                    <option value="${schoolclass.id}">${schoolclass.number}${schoolclass.prefix}</option>
                </c:forEach>
            </select>
        </div>

        <div>
            <select class="form-control" name="selectedLessonId" required>
                <c:choose>
                    <c:when test="${not empty selectedLessonInDropList}">
                        <option selected hidden
                                value="${selectedLessonInDropList.id}">${selectedLessonInDropList.name}</option>
                    </c:when>
                    <c:otherwise>
                        <option selected hidden disabled><fmt:message bundle="${loc}"
                                                                      key="main.droplist.subject"/></option>
                    </c:otherwise>
                </c:choose>
                <c:forEach var="subject" items="${drop_list_lesson}">
                    <option value="${subject.id}">${subject.name}</option>
                </c:forEach>
            </select>
        </div>

        <%--type of statement--%>
        <div>
            <select class="form-control" name="selectedStatementType" required>
                <c:choose>
                    <c:when test="${not empty selectedStatementTypeInDropList}">
                        <option selected hidden
                                value="${selectedStatementTypeInDropList}">${selectedStatementTypeInDropList}</option>
                    </c:when>
                    <c:otherwise>
                        <option selected hidden disabled><fmt:message bundle="${loc}"
                                                                      key="main.droplist.statement_type"/></option>
                    </c:otherwise>
                </c:choose>
                <option value="${marks}">${marks}</option>
                <option value="${visits}">${visits}</option>
            </select>
        </div>

        <div style="vertical-align: top;">
            <p><input class="btn btn-md btn-success" style="line-height: 1.43;" type="submit" value="${submit}"></p>
        </div>

        <%--error message, if the user hasn't selected items from the drop list--%>
        <c:if test="${not empty error}">
            <p class="alert alert-danger error"><fmt:message bundle="${loc}" key="${error}"/></p>
        </c:if>
    </form>

    <%--mark table--%>
    <c:if test="${not empty markTable}">
        <table class="table table-bordered table-hover table-condensed">
            <thead>
            <tr>
                <th class="col-date"><fmt:message bundle="${loc}" key="main.table.column.id"/></th>
                <th class="col-fullname"><fmt:message bundle="${loc}" key="main.table.column.fullname"/></th>
                <c:forEach var="i" begin="1" end="${daysCount}">
                    <th class="col-date">${i}</th>
                </c:forEach>
                <th class="col-statistics"><fmt:message bundle="${loc}" key="main.table.column.mark_statistics"/></th>
            </tr>
            </thead>
            <c:forEach var="studentMarks" items="${markTable}" varStatus="loopCount">
                <tr>
                    <td>${loopCount.count}</td>
                    <td style="text-align: left">${studentMarks.student.fullName}</td>
                    <c:forEach var="i" begin="1" end="${daysCount}">
                        <td>
                            <c:if test="${not empty studentMarks.marks}">
                                <c:forEach var="markSet" items="${studentMarks.marks}">
                                    <c:if test="${markSet.day eq i}">
                                        ${markSet.mark}
                                    </c:if>
                                </c:forEach>
                            </c:if>
                        </td>
                    </c:forEach>
                    <td>${studentMarks.averageMark}</td>
                </tr>
            </c:forEach>
        </table>
        <%--<br/> Заменить этот бр на нормальные отступы--%>

        <%--change marks--%>
        <form class="form-droplist" method="POST" action="./change_mark">
            <c:if test="${sessionScope.role eq 'teacher'}">
                <div>
                    <select class="form-control" name="selectedStudent" required>
                        <option selected hidden disabled><fmt:message bundle="${loc}"
                                                                      key="main.table.change_table.student"/></option>
                        <c:forEach var="studentMarks" items="${markTable}">
                            <option value="${studentMarks.student.id}">${studentMarks.student.fullName}</option>
                        </c:forEach>
                    </select>
                </div>
                <div>
                    <select class="form-control" name="selectedDay" required>
                        <option selected hidden disabled><fmt:message bundle="${loc}"
                                                                      key="main.table.change_table.day"/></option>
                        <c:forEach var="i" begin="1" end="${daysCount}">
                            <option value="${i}">${i}</option>
                        </c:forEach>
                    </select>
                </div>
                <div>
                    <select class="form-control" name="selectedMark" required>
                        <option selected hidden disabled><fmt:message bundle="${loc}"
                                                                      key="main.table.change_table.mark"/></option>
                        <c:forEach var="i" begin="2" end="5">
                            <option value="${i}">${i}</option>
                        </c:forEach>
                    </select>
                </div>
                <div style="vertical-align: top;">
                    <p><input class="btn btn-md btn-success" style="line-height: 1.43;" type="submit"
                              value="${submit}"></p>
                </div>
            </c:if>
        </form>
    </c:if>

    <%--visit table--%>
    <c:if test="${not empty visitTable}">
        <table class="table table-bordered table-hover table-condensed">
            <thead>
            <tr>
                <th class="col-date"><fmt:message bundle="${loc}" key="main.table.column.id"/></th>
                <th class="col-fullname"><fmt:message bundle="${loc}" key="main.table.column.fullname"/></th>
                <c:forEach var="i" begin="1" end="${daysCount}">
                    <th class="col-date">${i}</th>
                </c:forEach>
                <th class="col-statistics"><fmt:message bundle="${loc}" key="main.table.column.visit_statistics"/></th>
            </tr>
            </thead>
            <c:forEach var="studentVisits" items="${visitTable}" varStatus="loopCount">
                <tr>
                    <td>${loopCount.count}</td>
                    <td style="text-align: left">${studentVisits.student.fullName}</td>
                    <c:forEach var="i" begin="1" end="${daysCount}">
                        <td>
                            <c:if test="${not empty studentVisits.visits}">
                                <c:forEach var="visitSet" items="${studentVisits.visits}">
                                    <c:if test="${visitSet.day eq i}">
                                        ${visitSet.visit}
                                    </c:if>
                                </c:forEach>
                            </c:if>
                        </td>
                    </c:forEach>
                    <td>${studentVisits.averageVisit}%</td>
                </tr>
            </c:forEach>
        </table>
        <%--<br/>заменить--%>

        <%--change visits--%>
        <form class="form-droplist" method="POST" action="./change_visit">
            <c:if test="${sessionScope.role eq 'teacher'}">
                <div>
                    <select class="form-control" name="selectedStudent" required>
                        <option selected hidden disabled><fmt:message bundle="${loc}"
                                                                      key="main.table.change_table.student"/></option>
                        <c:forEach var="studentVisits" items="${visitTable}">
                            <option value="${studentVisits.student.id}">${studentVisits.student.fullName}</option>
                        </c:forEach>
                    </select>
                </div>
                <div>
                    <select class="form-control" name="selectedDay" required>
                        <option selected hidden disabled><fmt:message bundle="${loc}"
                                                                      key="main.table.change_table.day"/></option>
                        <c:forEach var="i" begin="1" end="${daysCount}">
                            <option value="${i}">${i}</option>
                        </c:forEach>
                    </select>
                </div>
                <div>
                    <select class="form-control" name="selectedVisit" required>
                        <option value="1" selected><fmt:message bundle="${loc}"
                                                                key="main.table.change_table.visit"/></option>
                        <option value="2"><fmt:message bundle="${loc}" key="main.table.change_table.absence"/></option>
                    </select>
                </div>
                <div style="vertical-align: top;">
                    <p><input class="btn btn-md btn-success" style="line-height: 1.43;" type="submit"
                              value="${submit}"></p>
                </div>
            </c:if>
        </form>
    </c:if>
    <div>
        <%@include file="/WEB-INF/jspf/footer.jspf" %>
    </div>
</div>
</body>
</html>