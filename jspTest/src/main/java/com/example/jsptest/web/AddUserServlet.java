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
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author puti
 * @date 2022/3/22
 */
@WebServlet(name = "AddUserServlet", value = "/addUserServlet")
public class AddUserServlet extends HttpServlet {
    private final UserService userService = new ImplUserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");

        User user = new User();
//        user.setYhid(req.getParameter("iYhzh"));
//        user.setYhxm(req.getParameter("iYhxm"));
//        user.setYhkl(req.getParameter("iYhkl"));
//        user.setYhbm(req.getParameter("iYhbm"));

        user.setYhbm(URLDecoder.decode(req.getParameter("iYhbm"), "UTF-8"));
        user.setYhid(URLDecoder.decode(req.getParameter("iYhzh"), "UTF-8"));
        user.setYhxm(URLDecoder.decode(req.getParameter("iYhxm"), "UTF-8"));
        user.setYhkl(URLDecoder.decode(req.getParameter("iYhkl"), "UTF-8"));

        String iPxh = req.getParameter("iPxh");

        if (iPxh != null && !iPxh.equals("")) {
            user.setPxh(Integer.parseInt(URLDecoder.decode(req.getParameter("iPxh"), "UTF-8")));
        } else {
            user.setPxh(null);
        }

//        user.setSfjy(req.getParameter("iSfjy"));
        user.setSfjy(URLDecoder.decode(req.getParameter("iSfjy"), "UTF-8"));
//        user.setYhxb(req.getParameter("iYhxb"));
        user.setYhxb(URLDecoder.decode(req.getParameter("iYhxb"), "UTF-8"));
//        user.setCsrq(req.getParameter("iCsrq"));
        user.setCsrq(URLDecoder.decode(req.getParameter("iCsrq"), "UTF-8"));
        SimpleDateFormat rq = new SimpleDateFormat("yyyy-MM-dd");
        user.setDjrq(rq.format(new Date()));
//        user.setDjrq(URLDecoder.decode(req.getParameter("iDjrq"), "UTF-8"));
        String isSuccess = userService.insertUser(user);
//        req.setAttribute("isSuccess", isSuccess);
//        req.getRequestDispatcher("/addUser.jsp").forward(req, resp);
        resp.getWriter().print(isSuccess);
    }
}
