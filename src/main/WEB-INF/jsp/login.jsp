<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Login</title>
</head>
<body>
    <div class="containerr">
        <div class="pp">
        <sec:authorize access="isAuthenticated()">
        <% response.sendRedirect("/"); %>
        </sec:authorize>
        <div>
        <form method="POST" action="/login">
        <h2>Welcome</h2>
        <div>
        <input name="username" type="text" placeholder="Username"
        autofocus="true"/>
        <input name="password" type="password" placeholder="Password"/>
        <button type="submit">Log In</button>
        </div>
        </form>
        </div>
        <p>New user. <a href="register.html">Sign-up</a></div>
<br> <br>
        <footer>
            <p>Yergesheva Saida</p>
        </footer>
    </div>
</body>
</html>