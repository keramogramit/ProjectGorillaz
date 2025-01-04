<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ page import="com.javarush.zubakha.PropertiesLoader" %>


<%

    PropertiesLoader loader = new PropertiesLoader("/config.properties");



%>

<html lang="ru" xml:lang="ru">
<head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/main.css" type="text/css">
    <title>Quest</title>
</head>
<body>
<p><%=loader.getProperty("q." + session.getAttribute("step"))%></p>

<form action="${pageContext.request.contextPath}/read" method="get">
    <p>Make your choice:</p>
    <label><input type="radio" name= "choice" value="1" checked="checked"> <%= loader.getProperty("a." + session.getAttribute("step") + ".1")%> </label>
    <label><input type="radio" name= "choice" value="2"> <%= loader.getProperty("a." + session.getAttribute("step") + ".2")%> </label> <br>
    <button class= "button" type="submit">Confirm</button>

</form>

<div class="footer">
    <%= "Statistics:"%> <br>
    <%= "Your name: " + session.getAttribute("user") %><br>
    <%= "Number of games played: " + session.getAttribute("gameCount")%>
</div>
</body>
</html>