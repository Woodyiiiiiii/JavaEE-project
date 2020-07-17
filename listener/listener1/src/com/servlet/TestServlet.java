package com.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class TestServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("str", "request added");
        HttpSession httpSession = request.getSession();
        httpSession.setAttribute("str", "session added");
        httpSession.invalidate();
        ServletContext servletContext = this.getServletContext();
        servletContext.setAttribute("str", "application added");

        response.getWriter().write("this is listener study.");
    }
}
