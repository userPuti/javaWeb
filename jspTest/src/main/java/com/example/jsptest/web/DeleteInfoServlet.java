package com.example.jsptest.web;

import com.example.jsptest.service.UserService;
import com.example.jsptest.service.impl.ImplUserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Puti
 * @date 2022/3/24 17:19
 */
@WebServlet(name = "DeleteInfoServlet", value = "/deleteInfoServlet")
public class DeleteInfoServlet extends HttpServlet {
    private final UserService userService = new ImplUserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String yhid = req.getParameter("yhid");
        int i = userService.deleteUserInfo(yhid);

        if (1 == i) {
            System.out.println("删除成功");
        } else {
            System.out.println("删除失败");
        }
    }
}
