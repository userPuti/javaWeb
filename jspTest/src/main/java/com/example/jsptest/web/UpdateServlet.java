package com.example.jsptest.web;

import com.example.jsptest.pojo.User;
import com.example.jsptest.service.UserService;
import com.example.jsptest.service.impl.ImplUserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;

/**
 * @author Puti
 * @date 2022/3/25 10:38
 */
@WebServlet(name = "UpdateServlet", value = "/updateServlet")
public class UpdateServlet extends HttpServlet {
    private final UserService userService = new ImplUserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html,charset=utf-8");

        User user = new User();
        user.setYhbm(URLDecoder.decode(req.getParameter("iYhbm"), "UTF-8"));
        user.setYhxb(URLDecoder.decode(req.getParameter("iYhxb"), "UTF-8"));
        user.setSfjy(URLDecoder.decode(req.getParameter("iSfjy"), "UTF-8"));
        user.setCsrq(URLDecoder.decode(req.getParameter("iCsrq"), "UTF-8"));
        user.setYhid(URLDecoder.decode(req.getParameter("iYhzh"), "UTF-8"));
        user.setYhxm(URLDecoder.decode(req.getParameter("iYhxm"), "UTF-8"));
        user.setYhkl(URLDecoder.decode(req.getParameter("iYhkl"), "UTF-8"));
        user.setDjrq(URLDecoder.decode(req.getParameter("iDjrq"), "UTF-8"));
        user.setPxh(Integer.parseInt(URLDecoder.decode(req.getParameter("iPxh"), "UTF-8")));

        System.out.println(user);

        boolean isSucc = userService.updateUserInfo(user);
        if(isSucc){
            resp.getWriter().print("1");
        }else{
            resp.getWriter().print("0");
        }
    }
}
