<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.io.FileInputStream" %>
<%@ page import="java.util.Properties" %>
<%@ page import="java.io.IOException" %>
<%@ page import="java.net.InetAddress" %>
<%@ page import="java.io.File" %>

<%
  FileInputStream fis;
  Properties property = new Properties();
  File propFile = new File("C:\\IdeaProjects\\ProjectGorillaz\\src\\main\\resources\\config.properties");
  try {
    fis = new FileInputStream(propFile);
    property.load(fis);

  } catch (IOException e) {
    System.err.println("ОШИБКА: Файл свойств отсутствует!");
  }
%>

<head>
  <link rel="stylesheet" href="/main.css" type="text/css">
  <title>Quest</title>
</head>
<body>
<p><%=property.getProperty("q." + request.getAttribute("step"))%></p>

<form action="/read" method="post">
  <p>Make your choice:</p>
  <label><input type="radio" name= "choice" value="1" checked="checked"> <%= property.getProperty("a." + request.getAttribute("step") + ".1")%> </label>
  <label><input type="radio" name= "choice" value="2"> <%= property.getProperty("a." + request.getAttribute("step") + ".2")%> </label> <br>
  <button class= "button" type="submit">Confirm</button>

</form>

<div class="footer">
  <%= "Statistics:"%> <br>
  <%= "Your name: " + request.getAttribute("user") %><br>
  <%= "Your IP: " + InetAddress.getLocalHost().getHostAddress() %><br>
  <%= "Number of games played: " + request.getAttribute("gameCount")%>
</div>
</body>
</html>