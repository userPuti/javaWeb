package com.example.jsptest.web;

import com.example.jsptest.service.UserService;
import com.example.jsptest.service.impl.ImplUserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "BulkDeletionServlet", value = "/bulkDeletionServlet")
public class BulkDeletionServlet extends HttpServlet {
    private final UserService userService = new ImplUserService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html,charset=utf-8");

        String del = request.getParameter("del");
        System.out.println(del);

        boolean isSucc = userService.bulkDeletion(del);
        System.out.println(isSucc);
        if (isSucc) {
            response.getWriter().print("1");
        } else {
            response.getWriter().print("0");
        }
    }
}
