package service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteCookies {
    
    public static void eraseCookie(HttpServletRequest req, HttpServletResponse resp) {
        Cookie[] cookies = req.getCookies();
        if (cookies != null)
            for (int i = 0; i < cookies.length; i++) {
                cookies[i].setValue(null);
                cookies[i].setPath("/");
                cookies[i].setMaxAge(0);
                resp.addCookie(cookies[i]);
            }
    }
}
