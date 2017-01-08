package servlet;

import database.dao.jdbc.MarkDao;
import model.Mark;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/change_mark")
public class ChangeMark extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int currentLesson = 0;
        Mark mark = new Mark();
        Cookie[] cookies = request.getCookies();
        int selectedStudent = Integer.parseInt(request.getParameter("selectedStudent"));
        int selectedDay = Integer.parseInt(request.getParameter("selectedDay"));
        int selectedMark = Integer.parseInt(request.getParameter("selectedMark"));

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("selectedLessonId")) {
                    currentLesson = Integer.parseInt(cookie.getValue());
                }
            }
        }

        mark.setId(1);
        mark.setLesson_id(currentLesson);
        mark.setStudent_id(selectedStudent);
        mark.setDay(selectedDay);
        mark.setMark(selectedMark);

        if (MarkDao.getMarkByLessonIdAndStudentIdAndDay(currentLesson, selectedStudent, selectedDay) != null) {
            MarkDao.updateMark(mark);
        } else {
            MarkDao.insertMark(mark);
        }
        request.getRequestDispatcher("/load_table").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
