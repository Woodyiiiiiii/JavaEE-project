package com.servlet.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.logging.LogRecord;

public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("filter inited.");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,  FilterChain filterChain)
        throws IOException , ServletException {
        // 设置编码格式
        servletRequest.setCharacterEncoding("utf-8");
        servletResponse.setContentType("text/html;charset=utf-8");
        // session管理
        HttpSession httpSession = ((HttpServletRequest)servletRequest).getSession();
        if (httpSession.getAttribute("user") == null) {
            ((HttpServletResponse)servletResponse).sendRedirect("a/login.jsp");
        }
        else
            // 放行
            filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("filter executed2 .");
    }

    @Override
    public void destroy() {
        System.out.println("filter destroyed.");
    }
}
