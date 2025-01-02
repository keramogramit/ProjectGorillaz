package com.javarush.zubakha;

import static org.mockito.Mockito.*;


import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


public class InitServletTest {

    private InitServlet servlet;

    @Mock
    private HttpServletRequest request;

    @Mock
    private HttpServletResponse response;

    @Mock
    private HttpSession sessionMock;

    @Mock
    private RequestDispatcher requestDispatcher;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        sessionMock = mock(HttpSession.class);
        when(request.getSession()).thenReturn(sessionMock);
        servlet = new InitServlet();

    }

    @Test
    public void testDoGetWithValidUser() throws Exception {

        String user = "testUser";
        when(request.getParameter("user")).thenReturn(user);
        when(request.getRequestDispatcher("/WEB-INF/quest-page.jsp")).thenReturn(requestDispatcher);

        servlet.doGet(request, response);

        verify(sessionMock).setAttribute("user", "testUser");
        verify(sessionMock).setAttribute("step", 1);
        verify(sessionMock).setAttribute("count", 1);
        verify(sessionMock).setAttribute("gameCount", 0);
        verify(requestDispatcher).forward(request, response);
    }

    @Test
    public void testDoGetWithNullUser() throws Exception {
        when(request.getParameter("user")).thenReturn(null);

        servlet.doGet(request, response);

        verify(response).sendRedirect(request.getContextPath() + "enter username");
    }

    @Test
    public void testDoGetWithEmptyUser() throws Exception {
        when(request.getParameter("user")).thenReturn("");

        servlet.doGet(request, response);

        verify(response).sendRedirect(request.getContextPath() + "enter username");
    }
}
