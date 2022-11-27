<html>
<head>
    <title>Rename Note</title>
</head>
<body>
<% String original_name=request.getParameter("og");
%>
<h1>
    Enter new name for Note
</h1>
<form action="/rename.html" method="post">
    <input type="hidden" name="original_name" value='<%=original_name%>'>
    <input type="text" name="new_name" >
    <input type="submit" value="Done">
</form>
</body>

</html>