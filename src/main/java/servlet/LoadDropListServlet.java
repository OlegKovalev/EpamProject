package servlet;

import database.dao.jdbc.ClassDao;
import database.dao.jdbc.LessonDao;
import model.Lesson;
import model.SchoolClass;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

@WebServlet("/load_drop_list")
public class LoadDropListServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Set<SchoolClass> classList = ClassDao.getAllClasses();
        Set<Lesson> lessonList = LessonDao.getAllLessons();
        
        request.setAttribute("drop_list_class", classList);
        request.setAttribute("drop_list_lesson", lessonList);

        request.getRequestDispatcher("/WEB-INF/main.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
