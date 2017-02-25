package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import java.io.IOException;

//When a server crashes, it displays the error, rather than the current servlet
@WebServlet("/error")
public class ErrorServlet extends HttpServlet {

    private static final Logger LOG = Logger.getLogger(ErrorServlet.class);

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LOG.error("Error: " + request.getAttribute("javax.servlet.error.status_code") +
                "URI: " + request.getRequestURI());
        request.getRequestDispatcher("/WEB-INF/error.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
