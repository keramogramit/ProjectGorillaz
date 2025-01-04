
<%@ page import="com.javarush.zubakha.PropertiesLoader" %>

<%PropertiesLoader loader = new PropertiesLoader("/config.properties");%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/main.css" type="text/css">
    <title>Result</title>
</head>
<body>
<p>
    <%=loader.getProperty((String) session.getAttribute("resultText"))%>
</p>
<form action="${pageContext.request.contextPath}/restart">
    <button class= "button" type="submit">Restart Game</button>
</form>
</body>
</html>
