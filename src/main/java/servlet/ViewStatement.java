package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

@WebServlet("/statement")
//@ServletSecurity(@HttpConstraint(rolesAllowed = {"admin", "enrollee"}))
public class ViewStatement extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
/*
        if (request.isUserInRole("enrollee")) {
            if (request.getParameter("delete") != null) {
                EnrolleeDAO.delete(UserDAO.getUserByUserName(request.getRemoteUser()).getId());
            } else {
                Enrollee enrollee = EnrolleeDAO.getEnrolleeByUserName(request.getRemoteUser());
                if (request.getParameter("new") != null) {
                    enrollee.setStatus("new");
                } else if (request.getParameter("canceled") != null) {
                    enrollee.setStatus("canceled");
                }
                EnrolleeDAO.updateStatus(enrollee);
            }
        }
*/
        response.sendRedirect(request.getHeader("Referer"));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
/*        if (request.isUserInRole("admin")) {
            request.setAttribute("applications", EnrolleeDAO.getALLEnrolleeWithStatus("new"));
            request.getRequestDispatcher("/WEB-INF/admin.jsp").forward(request, response);

        } else if (request.isUserInRole("enrollee")) {
            Enrollee enrollee = EnrolleeDAO.getEnrolleeByUserName(request.getRemoteUser());
            request.setAttribute("enrollee", enrollee);
            request.setAttribute("dueDate", DueDates.dueDate);
            request.setAttribute("resultsDate", DueDates.resultsDate);
            request.setAttribute("canSubmit", DueDates.dueDate.isAfter(LocalDateTime.now()));
            request.getRequestDispatcher("/WEB-INF/enrollee.jsp").forward(request, response);
        }*/
    }
}
