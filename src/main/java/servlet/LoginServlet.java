package servlet;

import database.dao.jdbc.TeacherDao;
import database.dao.jdbc.UserDao;
import model.User;
import org.apache.log4j.Logger;
import service.CheckInputValue;
import service.DeleteCookies;
import service.ErrorEnum;
import service.ShowError;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static encrypt.Encryption.checkPassword;
import static service.ErrorEnum.EMAIL_OR_PASSWORD_ERROR;
import static service.ErrorEnum.SUCCESS;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private static final Logger LOG = Logger.getLogger(LoginServlet.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("user") != null) {
            response.sendRedirect("./");
            return;
        }
        request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        HttpSession session = request.getSession(true);

        if (session != null && session.getAttribute("user") != null) {
            response.sendRedirect("./");
            return;
        }

        String email = request.getParameter("login");
        String password = request.getParameter("password");

//        check user's input
        ErrorEnum validationResult = CheckInputValue.validateLogin(email, password);
        if (validationResult != SUCCESS) {
            ShowError.printError(validationResult, "/WEB-INF/login.jsp", request, response);
            return;
        }

//        authorize the user
        User user = UserDao.getUserByLogin(email);
        if (user != null && checkPassword(password, user.getPass()) && session != null) {
            session.setAttribute("user", user);

            //set role to be able to change statement
            //if 'user' contains in table 'teacher' in DB -> 'user' is a teacher
            if (TeacherDao.getTeacherByUserId(user.getId()).size() != 0) {
                session.setAttribute("role", "teacher");
            } else {
                session.setAttribute("role", "parent");
            }
            
            LOG.info("User logged in! " + user.getLogin() + "&" + session.getAttribute("role"));

            DeleteCookies.eraseCookie(request, response);

            response.sendRedirect("./load_drop_list");
        } else {
            ShowError.printError(EMAIL_OR_PASSWORD_ERROR, "/WEB-INF/login.jsp", request, response);
        }
    }
}
