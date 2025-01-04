package com.javarush.zubakha;

import static org.mockito.Mockito.*;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.RequestDispatcher;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class ReadServletTest {
    @InjectMocks
    private ReadServlet servlet;

    @Mock
    private HttpServletRequest requestMock;

    @Mock
    private HttpServletResponse response;

    @Mock
    private HttpSession sessionMock;

    @Mock
    private RequestDispatcher requestDispatcher;

    @Before
    public void setUp()  {
        MockitoAnnotations.openMocks(this);
        sessionMock = mock(HttpSession.class);
        when(requestMock.getSession()).thenReturn(sessionMock);
        servlet = new ReadServlet();
        when(requestMock.getRequestDispatcher(anyString())).thenReturn(requestDispatcher);
    }

    @Test
    public void testDoGetWhenStepIsNot4AndChoiceIsNot2() throws Exception {
        when(sessionMock.getAttribute("step")).thenReturn(1);
        when(requestMock.getParameter("choice")).thenReturn("1");

        servlet.doGet(requestMock, response);

        verify(sessionMock).setAttribute("step", 2);
        verify(sessionMock).setAttribute("choice", 1);
        verify(requestDispatcher).forward(requestMock, response);
    }

    @Test
    public void testDoGetWhenChoiceIs2AndStepIs2() throws Exception {
        when(sessionMock.getAttribute("step")).thenReturn(1);
        when(requestMock.getParameter("choice")).thenReturn("2");

        servlet.doGet(requestMock, response);

        verify(sessionMock).setAttribute("step", 2);
        verify(sessionMock).setAttribute("choice", 2);
        verify(sessionMock).setAttribute("resultText", "def.1");
        verify(requestDispatcher).forward(requestMock, response);
        verify(sessionMock).setAttribute("step", 2);
    }

    @Test
    public void testDoGetWhenChoiceIs2AndStepIs3() throws Exception {
        when(sessionMock.getAttribute("step")).thenReturn(2);
        when(requestMock.getParameter("choice")).thenReturn("2");

        servlet.doGet(requestMock, response);

        verify(sessionMock).setAttribute("step", 3);
        verify(sessionMock).setAttribute("choice", 2);
        verify(sessionMock).setAttribute("resultText", "def.2");
        verify(requestDispatcher).forward(requestMock, response);
    }

    @Test
    public void testDoGetWhenChoiceIs1AndStepIs4() throws Exception {
        when(sessionMock.getAttribute("step")).thenReturn(3);
        when(requestMock.getParameter("choice")).thenReturn("1");

        servlet.doGet(requestMock, response);

        verify(sessionMock).setAttribute("step", 4);
        verify(sessionMock).setAttribute("choice", 1);
        verify(sessionMock).setAttribute("resultText", "win.1");
        verify(requestDispatcher).forward(requestMock, response);
    }

    @Test
    public void testDoGetWhenStepIs4AndChoiceIs2() throws Exception {
        when(sessionMock.getAttribute("step")).thenReturn(3);
        when(requestMock.getParameter("choice")).thenReturn("2");

        servlet.doGet(requestMock, response);

        verify(sessionMock).setAttribute("step", 4);
        verify(sessionMock).setAttribute("choice", 2);
        verify(sessionMock).setAttribute("resultText", "def.3");
        verify(requestDispatcher).forward(requestMock, response);
    }


}
