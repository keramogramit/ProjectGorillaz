package com.javarush.zubakha;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(value = "/restart")
public class RestartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        session.setAttribute("gameCount", (int) session.getAttribute("gameCount") + 1);
        session.setAttribute("step", 1);
        req.getRequestDispatcher("/WEB-INF/quest-page.jsp").forward(req, resp);
    }
}