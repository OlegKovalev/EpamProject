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
import java.util.List;

@WebServlet("/load_drop_list")
public class LoadDropListServlet extends HttpServlet {
    //сюда залетаем через get

//    private static final String DROP_LIST_CLASS_ATTRIBUTE = "drop_list_class";
//    private static final String DROP_LIST_SUBJECT_ATTRIBUTE = "drop_list_lesson";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<SchoolClass> classList = ClassDao.getAllClasses();
        List<Lesson> lessonList = LessonDao.getAllLessons();
        
//TO DO: sorting fo arrays
        
//        request.getSession().setAttribute(DROP_LIST_CLASS_ATTRIBUTE, classList);
//        request.getSession().setAttribute(DROP_LIST_SUBJECT_ATTRIBUTE, lessonList);
        request.setAttribute("drop_list_class", classList);
        request.setAttribute("drop_list_lesson", lessonList);

        request.getRequestDispatcher("./main.jsp").forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
    //загружаем выпадашки
    //переходим на main.jsp
}
