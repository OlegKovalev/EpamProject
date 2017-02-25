package servlet;

import database.dao.jdbc.VisitDao;
import model.Visit;
import service.CheckInputValue;
import service.ErrorEnum;
import service.ShowError;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static service.ErrorEnum.SUCCESS;

@WebServlet("/change_visit")
public class ChangeVisitServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int selectedStudent;
        int selectedDay;
        int currentLesson = 0;
        Visit visit = new Visit();
        Cookie[] cookies = request.getCookies();
        String selectedVisit = request.getParameter("selectedVisit");

        ErrorEnum validationResult = CheckInputValue.validateDropList(request.getParameter("selectedStudent"), request.getParameter("selectedDay"), selectedVisit);
        if (validationResult != SUCCESS) {
            ShowError.printError(validationResult, "/load_table", request, response);
            return;
        }

        selectedStudent = Integer.parseInt(request.getParameter("selectedStudent"));
        selectedDay = Integer.parseInt(request.getParameter("selectedDay"));

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("selectedLessonId") && !cookie.getValue().equals("")) {
                    currentLesson = Integer.parseInt(cookie.getValue());
                    break;
                }
            }
        }

        visit.setId(1);
        visit.setLesson_id(currentLesson);
        visit.setStudent_id(selectedStudent);
        visit.setDay(selectedDay);
        visit.setVisit(selectedVisit);

        if (VisitDao.getVisitByLessonIdAndStudentIdAndDay(currentLesson, selectedStudent, selectedDay) != null) {
            VisitDao.updateVisit(visit);
        } else {
            VisitDao.insertVisit(visit);
        }
        request.getRequestDispatcher("/load_table").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
