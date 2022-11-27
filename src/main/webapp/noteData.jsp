<%@ page import="ucl.ac.uk.model.Note" %>
<%@ page import="ucl.ac.uk.model.Model" %>
<%@ page import="java.io.File" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>
        NoteData
    </title>
</head>
<body>
<% Note note=(Note)request.getAttribute("note");
String name=note.getName();
String data=new Model().readFileOfName(name);
%>
<h1><%=name%></h1>
<p><%=data%></p><br>
<form action="deleteNote.html" method="post" >
    <input type="hidden" name="del" value="<%=name%>">
    <input type="submit" value="Delete">
</form>
<form action="renamePanel.jsp" method="get" >
    <input type="hidden" name="og" value="<%=name%>">
    <input type="submit" value="Rename">
</form>

<form action="edit.jsp" method="post" >
    <input type="hidden" name="og" value="<%=name%>">
    <input type="submit" value="Edit">
</form>
</body>

</html>
