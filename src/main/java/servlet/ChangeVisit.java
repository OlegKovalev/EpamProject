package servlet;

import database.dao.jdbc.VisitDao;
import model.Visit;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/change_visit")
public class ChangeVisit extends HttpServlet {
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        int currentLesson = 0;
        Visit visit = new Visit();
        Cookie[] cookies = request.getCookies();
        int selectedStudent = Integer.parseInt(request.getParameter("selectedStudent"));
        int selectedDay = Integer.parseInt(request.getParameter("selectedDay"));
        String selectedVisit = request.getParameter("selectedVisit");

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("selectedLessonId")) {
                    currentLesson = Integer.parseInt(cookie.getValue());
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
