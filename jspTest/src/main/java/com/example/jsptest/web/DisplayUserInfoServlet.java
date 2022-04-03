package com.example.jsptest.web;

import com.example.jsptest.dto.YhxxDto;
import com.example.jsptest.service.UserService;
import com.example.jsptest.service.impl.ImplUserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author puti
 * @date 2022/3/22
 */
@WebServlet(name = "DisplayUserInfoServlet", value = "/displayUserInfoServlet")
public class DisplayUserInfoServlet extends HttpServlet {
    private final UserService userService = new ImplUserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/xml;charset=UTF-8");
        String start = req.getParameter("start");
        if("".equals(start)){
            start = "0";
        }
        int sta = Integer.parseInt(start);
        int lim = Integer.parseInt(req.getParameter("limit"));
        String yhid = req.getParameter("yhid");
        String yhbm = req.getParameter("yhid");
        YhxxDto yhxxDto = new YhxxDto();
        yhxxDto.setStart(sta);
        String xml = userService.userInfoDisplay(yhxxDto);
        System.out.println(xml);
        resp.getWriter().write(xml);
    }
}
