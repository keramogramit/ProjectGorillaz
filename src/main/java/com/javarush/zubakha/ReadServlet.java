package com.javarush.zubakha;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;


@WebServlet(value = "/read")
public class ReadServlet extends HttpServlet {
    public String page;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        int valueStep = (Integer) session.getAttribute("step") + 1;
        session.setAttribute("step", valueStep);
        int value = Integer.parseInt(req.getParameter("choice"));
        session.setAttribute("choice", value);
        if (value == 2 || valueStep == 4) {
            page = "/WEB-INF/result-page.jsp";
            if (value == 2 && valueStep == 2) {
                session.setAttribute("resultText", "def.1");
            } else if (value == 2 && valueStep == 3) {
                session.setAttribute("resultText", "def.2");
            } else if (value == 2 && valueStep == 4) {
                session.setAttribute("resultText", "def.3");
            } else if (value == 1) {
                session.setAttribute("resultText", "win.1");
            }
            }else {
                page = "WEB-INF/quest-page.jsp";
            }
        req.getRequestDispatcher(page).forward(req, resp);

    }
}