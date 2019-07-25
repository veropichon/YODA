<%--
  Created by IntelliJ IDEA.
  User: veronnique
  Date: 25/07/2019
  Time: 14:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Liste des maitres Jedi</title>
</head>
<body>
<h1>Liste des maitres jedi</h1>
<ul>
<c:forEach items="${ messages }" var="message" >

<li> ${message} </li>

</c:forEach>
</ul>
</body>
</html>
