<%@ page import="ucl.ac.uk.model.Model" %>
<html>
<head>
    <title>Edit the Contents</title>
</head>
<body>
<% String name=request.getParameter("og");
   String data=new Model().readFileOfName(name);%>
<h1>Edit Contents of Note</h1>
<form action="editContent.html" method="post">
    <textarea name="content" id="content" rows="5" cols="50"><%=data%></textarea>
    <input type="hidden" name="og" value="<%=name%>">
    <input type="submit" value="Done">
</form>
</body>
</html>