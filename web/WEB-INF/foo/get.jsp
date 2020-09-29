<%@ page import="com.company.foo.Foo" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Hello from foo</h1>
<b>Name: </b><%= ((Foo) request.getAttribute("model")).getName()%>
</body>
</html>
