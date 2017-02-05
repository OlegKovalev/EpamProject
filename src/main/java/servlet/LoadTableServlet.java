package servlet;

import database.dao.jdbc.*;
import model.*;
import model.table.MarkTable;
import model.table.VisitTable;
import service.CheckInputValue;
import service.ErrorEnum;
import service.ShowError;
import service.TableStatistics;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static service.ErrorEnum.DAY_NOT_EXIST;
import static service.ErrorEnum.SUCCESS;

@WebServlet("/load_table")
public class LoadTableServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int daysCount, selectedClassId, selectedLessonId;
        
        Cookie[] cookies = request.getCookies();
        String selectedClassInJsp = request.getParameter("selectedClassId");
        String selectedLessonInJsp = request.getParameter("selectedLessonId");
        String selectedStatementTypeInJsp = request.getParameter("selectedStatementType");

//        save the table, when language is changed 
        if (cookies != null && selectedClassInJsp == null && selectedLessonInJsp == null && selectedStatementTypeInJsp == null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("selectedClassId") && !cookie.getValue().equals("")) {
                    selectedClassInJsp = cookie.getValue();
                }
                if (cookie.getName().equals("selectedLessonId") && !cookie.getValue().equals("")) {
                    selectedLessonInJsp = cookie.getValue();
                }
                if (cookie.getName().equals("selectedStatementType") && !cookie.getValue().equals("")) {
                    selectedStatementTypeInJsp = cookie.getValue();
                }
            }
        } else {
            ErrorEnum validationResult = CheckInputValue.validateDropList(selectedClassInJsp, selectedLessonInJsp, selectedStatementTypeInJsp);
            if (validationResult != SUCCESS) {
                ShowError.printError(validationResult, "/load_drop_list", request, response);
                return;
            }
            Cookie cookieClassId = new Cookie("selectedClassId", selectedClassInJsp);
            Cookie cookieLessonId = new Cookie("selectedLessonId", selectedLessonInJsp);
            Cookie cookieStatementType = new Cookie("selectedStatementType", selectedStatementTypeInJsp);
            response.addCookie(cookieClassId);
            response.addCookie(cookieLessonId);
            response.addCookie(cookieStatementType);
        }

        ErrorEnum validationResult = CheckInputValue.validateDropList(selectedClassInJsp, selectedLessonInJsp, selectedStatementTypeInJsp);
        if (validationResult != SUCCESS) {
            ShowError.printError(validationResult, "/load_drop_list", request, response);
            return;
        }

//        default value for drop list
        request.setAttribute("selectedClassInDropList", ClassDao.getClassById(Integer.parseInt(selectedClassInJsp)));
        request.setAttribute("selectedLessonInDropList", LessonDao.getLessonById(Integer.parseInt(selectedLessonInJsp)));
        request.setAttribute("selectedStatementTypeInDropList", selectedStatementTypeInJsp);

        selectedClassId = Integer.parseInt(selectedClassInJsp);
        selectedLessonId = Integer.parseInt(selectedLessonInJsp);

//       get the number of days by selected Class and Lesson for build columns in table
        Days day = DaysDao.getDaysByLessonIdAndClassId(selectedLessonId, selectedClassId);
        if (day == null) {
            ShowError.printError(DAY_NOT_EXIST, "/load_drop_list", request, response);
            return;
        }
        daysCount = day.getCount();
        request.setAttribute("daysCount", daysCount);

        Set<Student> studentSet = StudentDao.getAllStudentsByClassId(selectedClassId);
        Lesson lesson = LessonDao.getLessonById(selectedLessonId);

        if (selectedStatementTypeInJsp.equals("Marks") || selectedStatementTypeInJsp.equals("Оценки")) {
//           values for mark table
            Set<Mark> studentMarks;
            double averageMark;
            List<MarkTable> markTableList = new ArrayList<>();

            for (Student student : studentSet) {
                studentMarks = MarkDao.getMarksByLessonAndStudent(lesson, student);
                averageMark = TableStatistics.getAverageMark(studentMarks);

                markTableList.add(new MarkTable(student, studentMarks, averageMark));
            }
            request.setAttribute("markTable", markTableList);
        } else {
//            values for visit table
            Set<Visit> studentVisits;
            int averageVisit;
            List<VisitTable> visitTableList = new ArrayList<>();


            for (Student student : studentSet) {
                studentVisits = VisitDao.getVisitsByLessonAndStudent(lesson, student);
                averageVisit = TableStatistics.getAverageVisit(studentVisits);

                visitTableList.add(new VisitTable(student, studentVisits, averageVisit));
            }
            request.setAttribute("visitTable", visitTableList);
        }
        request.getRequestDispatcher("/load_drop_list").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
