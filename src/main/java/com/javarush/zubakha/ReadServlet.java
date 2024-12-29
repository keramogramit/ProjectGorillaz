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

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        session.setAttribute("step", (int) session.getAttribute("step") + 1);
        int value = Integer.parseInt(req.getParameter("choice"));
        session.setAttribute("choice", value);
        String page = "";
        if (value == 2 || (int) session.getAttribute("step") == 4) {
            page = "/WEB-INF/result-page.jsp";
            if ((int) session.getAttribute("choice") == 2 && (int) session.getAttribute("step") == 2) {
                session.setAttribute("resultText", "def.1");
            } else if ((int) session.getAttribute("choice") == 2 && (int) session.getAttribute("step") == 3) {
                session.setAttribute("resultText", "def.2");
            } else if ((int) session.getAttribute("choice") == 2 && (int) session.getAttribute("step") == 4) {
                session.setAttribute("resultText", "def.3");
            } else if ((int) session.getAttribute("choice") == 1 && (int) session.getAttribute("step") == 4) {
                session.setAttribute("resultText", "win.1");
            }
            }else {
                page = "WEB-INF/quest-page.jsp";
            }
        req.getRequestDispatcher(page).forward(req, resp);

    }
}