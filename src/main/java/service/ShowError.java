package service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ShowError {
    
    public static void printError(ErrorEnum error, String objectPath, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("error", error.getErrorPath());
        request.getRequestDispatcher(objectPath).forward(request, response);
    }
}
