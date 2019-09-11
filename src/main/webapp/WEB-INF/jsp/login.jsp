<%--
  Created by IntelliJ IDEA.
  User: imperiali
  Date: 11/09/19
  Time: 18:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<head>
    <title>Login</title>
</head>
<body>

<h1>Cadastro de usuario</h1>

<form:form method="post" action="save">
    <table>
        <tr>
            <td>Name :</td>
            <td><form:input path="name"/></td>
        </tr>
        <tr>
            <td>Email :</td>
            <td><form:input path="email"/></td>
        </tr>
        <tr>
            <td>Password :</td>
            <td><form:input path="password"/></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="Save"/></td>
        </tr>
    </table>
</form:form>

</body>
