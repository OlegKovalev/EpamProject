package servlet;

import database.dao.jdbc.DataAccess;
import database.dao.jdbc.UserDao;
import model.User;
import org.apache.log4j.Logger;
import service.CheckInputValue;
import service.ErrorEnum;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static encrypt.Encryption.encryptPassword;
import static service.ErrorEnum.*;

@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {
    
    private static final Logger LOG = Logger.getLogger(DataAccess.class);

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession(true);
        if (session != null && session.getAttribute("user") != null) {
            response.sendRedirect("./index.jsp");
            return;
        }

        String login = request.getParameter("login");
        if (UserDao.getUserByLogin(login) != null) {
            printError(EMAIL_EXIST_ERROR, request, response);
            return;
        }

        String fullName = request.getParameter("fullname");
        String password = request.getParameter("password");
        String repeatPassword = request.getParameter("repeat_password");

        ErrorEnum validationResult = CheckInputValue.validateRegistration(login, fullName, password, repeatPassword);
        if (validationResult != SUCCESS) {
            printError(validationResult, request, response);
            return;
        }

        User user = new User();
        user.setLogin(request.getParameter("login"));
        user.setPass(encryptPassword(request.getParameter("password")));
        user.setFullName(request.getParameter("fullname"));
        UserDao.insertUser(user);
        LOG.info("New user created! " + user.getLogin() + "&" + user.getFullName());

        session.setAttribute("user", user);
        LOG.info("User logged in! " + user.getLogin() + "&" + user.getFullName());

        //set role
        session.setAttribute("role", "parent");
        response.sendRedirect("./load_drop_list");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("user") != null) {
            response.sendRedirect("./index.jsp");
            return;
        }
        request.getRequestDispatcher("/WEB-INF/registration.jsp").forward(request, response);
    }

    private void printError(ErrorEnum error, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("error", error.getErrorPath());
        LOG.error("Error in invalid! " + error);

        request.getRequestDispatcher("/WEB-INF/registration.jsp").forward(request, response);
    }
}