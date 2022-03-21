package com.example.servlettest;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

/**
 * @author puti
 */
@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    @Override
    public void init() {
        message = "Hello World!";
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        response.setContentType("text/html");
//
//        // Hello
//        PrintWriter out = response.getWriter();
//        out.println("<html><body>");
//        out.println("<h1>" + message + "</h1>");
//        out.println("</body></html>");
        System.out.println("request.getRequestURI() = " + request.getRequestURI());
        System.out.println("request.getRequestURL() = " + request.getRequestURL());
        System.out.println("request.getRemoteHost() = " + request.getRemoteHost());
        System.out.println("request.getHeader() = " + request.getHeader("Accept"));
        System.out.println("request.getContextPath() = " + request.getContextPath());

    }

    @Override
    public void destroy() {
    }
}