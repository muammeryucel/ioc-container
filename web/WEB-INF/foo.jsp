<%@ page import="com.company.foo.Foo" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>Hello from foo <%= ((Foo) request.getAttribute("model")).getName()%></h1>
</body>
</html>
