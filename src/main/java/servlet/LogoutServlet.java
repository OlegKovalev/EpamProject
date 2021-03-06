package servlet;

import org.apache.log4j.Logger;
import service.DeleteCookies;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
   
    private static final Logger LOG = Logger.getLogger(LogoutServlet.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        DeleteCookies.eraseCookie(request, response);
        if (session != null) {
            LOG.info("User logged out! " +  session.getAttribute("user").toString());
            session.invalidate();
        }
        response.sendRedirect("./index.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
