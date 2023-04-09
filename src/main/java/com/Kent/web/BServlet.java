package com.Kent.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;

@WebServlet("/bServlet")
public class BServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 取得 cookie

        // 1. 取得 cookie 陣列
        Cookie[] cookies = req.getCookies();

        // 2. 取得對應到的 cookie
        for (Cookie cookie: cookies) {
            String name = cookie.getName();
            if("username".equals(name)) {
                String value = cookie.getValue();
                // URL 解碼
                value = URLDecoder.decode(value, "UTF-8");
                System.out.println(name+":"+value);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
