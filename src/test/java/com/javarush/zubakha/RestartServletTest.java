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

public class RestartServletTest {

    private RestartServlet servlet;

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
        servlet = new RestartServlet();
    }

    @Test
    public void testRestartSecondGameOverOn2Step() throws Exception {
        when(sessionMock.getAttribute("gameCount")).thenReturn(0);
        when(sessionMock.getAttribute("step")).thenReturn(2);
        when(request.getRequestDispatcher("/WEB-INF/quest-page.jsp")).thenReturn(requestDispatcher);

        servlet.doGet(request, response);

        verify(sessionMock).setAttribute("gameCount", 1);
        verify(sessionMock).setAttribute("step", 1);
        verify(requestDispatcher).forward(request, response);
    }

    @Test
    public void testRestartGameOverOn3StepAndGameCount2() throws Exception {
        when(sessionMock.getAttribute("gameCount")).thenReturn(2);
        when(sessionMock.getAttribute("step")).thenReturn(3);
        when(request.getRequestDispatcher("/WEB-INF/quest-page.jsp")).thenReturn(requestDispatcher);

        servlet.doGet(request, response);

        verify(sessionMock).setAttribute("gameCount", 3);
        verify(sessionMock).setAttribute("step", 1);
        verify(requestDispatcher).forward(request, response);
    }
}
