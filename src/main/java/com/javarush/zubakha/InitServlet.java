package com.javarush.zubakha;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(value = "/start")
public class InitServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(true);
        String user = req.getParameter("user");

        if (user != null && !user.isEmpty()) {
            req.setAttribute("user", user);
            req.setAttribute("step", 1);
            req.setAttribute("count", 1);
            req.setAttribute("gameCount", 0);
            req.getRequestDispatcher("/WEB-INF/quest-page.jsp").forward(req, resp);
        } else {
            // Логирование ошибки или перенаправление на страницу с ошибкой
            resp.sendRedirect(req.getContextPath() + "/error-page.jsp");
        }
    }
}