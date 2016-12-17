package servlet;

import database.dao.jdbc.*;
import model.Days;
import model.Lesson;
import model.Mark;
import model.Student;
import model.table.MarkTable;
import service.CheckInputValue;
import service.ErrorEnum;
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

        double averageMark;
        int daysCount, selectedClassId, selectedLessonId;
        Set<Mark> studentMarks;

        Cookie[] cookies = request.getCookies();
        List<MarkTable> markTableList = new ArrayList<>();
        String selectedClassInJsp = request.getParameter("selectedClassId");
        String selectedLessonInJsp = request.getParameter("selectedLessonId");
//        System.out.println(selectedClassInJsp + " " + selectedLessonInJsp);


        if (selectedClassInJsp == null && selectedLessonInJsp == null) {
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals("selectedClassId")) {
                        selectedClassInJsp = cookie.getValue();
                    }
                    if (cookie.getName().equals("selectedLessonId")) {
                        selectedLessonInJsp = cookie.getValue();
                    }
                }
            }
        } else {
            Cookie cookieClassId = new Cookie("selectedClassId", selectedClassInJsp);
            Cookie cookieLessonId = new Cookie("selectedLessonId", selectedLessonInJsp);
            response.addCookie(cookieClassId);
            response.addCookie(cookieLessonId);
        }

        ErrorEnum validationResult = CheckInputValue.validateDropList(selectedClassInJsp, selectedLessonInJsp);
        if (validationResult != SUCCESS) {
            printError(validationResult, request, response);
            return;
        }

//        default value for drop list
        request.setAttribute("selectedClassInDropList", ClassDao.getClassById(Integer.parseInt(selectedClassInJsp)));
        request.setAttribute("selectedLessonInDropList", LessonDao.getLessonById(Integer.parseInt(selectedLessonInJsp)));

        selectedClassId = Integer.parseInt(selectedClassInJsp);
        selectedLessonId = Integer.parseInt(selectedLessonInJsp);

//       get the number of days by selected Class and Lesson for build columns in table
        Days day = DaysDao.getDaysByLessonIdAndClassId(selectedLessonId, selectedClassId);
        if (day == null) {
            printError(DAY_NOT_EXIST, request, response);
        }
        daysCount = day.getCount();

        Set<Student> studentSet = StudentDao.getAllStudentsByClassId(selectedClassId);
        Lesson lesson = LessonDao.getLessonById(selectedLessonId);

        for (Student student : studentSet) {

            studentMarks = MarkDao.getMarkByLessonAndStudent(lesson, student);
            averageMark = TableStatistics.getAverageMark(studentMarks);

            markTableList.add(new MarkTable(student, studentMarks, averageMark));
        }
        request.setAttribute("markTable", markTableList);
        request.setAttribute("daysCount", daysCount);

        request.getRequestDispatcher("/load_drop_list").forward(request, response);
//        request.getRequestDispatcher("/WEB-INF/main.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    private void printError(ErrorEnum error, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("error", error.getErrorPath());
        request.getRequestDispatcher("/load_drop_list").forward(request, response);
    }
}
