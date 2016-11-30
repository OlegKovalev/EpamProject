package servlet;

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
            response.sendRedirect("./main.jsp");
            return;
        }
        request.getRequestDispatcher("./login.jsp").forward(request, response);
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

        //Check user's input
        ErrorEnum validationResult = CheckInputValue.validateLogin(email, password);
        if (validationResult != SUCCESS) {
            printError(validationResult, request, response);
            return;
        }

        //Authorize the user
        User user = UserDao.getUserByLogin(email);
        if (user != null && checkPassword(password, user.getPass())) {
            session.setAttribute("user", user);
            LOG.info("User logged in! " + user.getLogin() + "@" + user.getFullName());

            response.sendRedirect("./main.jsp");
        } else {
            printError(EMAIL_OR_PASSWORD_ERROR, request, response);
        }
    }

    private void printError(ErrorEnum error, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("error", error.getErrorPath());
        LOG.error("Error in invalid! " + error);

        request.getRequestDispatcher("./login.jsp").forward(request, response);
    }
}
