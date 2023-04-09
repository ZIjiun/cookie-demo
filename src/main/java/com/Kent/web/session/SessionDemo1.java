package com.Kent.web.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/demo1")
public class SessionDemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 儲存資料到 Session 中
        // 1. 取得 Session 物件
        HttpSession session = req.getSession();
        System.out.println(session); //org.apache.catalina.session.StandardSessionFacade@792ae777

        // 銷毀 session
//        session.invalidate();

        // 2. 儲存資料
        session.setAttribute("username", "zs");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
