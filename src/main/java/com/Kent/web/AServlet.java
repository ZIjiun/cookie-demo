package com.Kent.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;

@WebServlet("/aServlet")
public class AServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 發送 cookie

        // 1. 創建 cookie 物件
//        Cookie cookie = new Cookie("username", "zs");

        // cookie 不能直接儲存中文，需要先經過編碼
        String value = "小明";
        value = URLEncoder.encode(value, "UTF-8");
        System.out.println("儲存資料" + value);
        Cookie cookie = new Cookie("username", value);

        // 設置存活時間 1周7天
        cookie.setMaxAge(60*60*24*7);

        // 2. 發送 cookie. response
        resp.addCookie(cookie);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
