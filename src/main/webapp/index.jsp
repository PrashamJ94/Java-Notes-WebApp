<%@ page import="java.util.ArrayList" %>
<%@ page import="ucl.ac.uk.model.Note" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<head>
    <title>NoteIndex</title>
</head>
<body>
<div>
<h1>Index</h1>
<% ArrayList<Note> noteList=(ArrayList<Note>)request.getAttribute("NoteIndex");
    for(Note note:noteList)
    {
        String href="noteData.html?noteName="+note.getName(); %>
<li><a href="<%=href%>"><%=note.getName()%></a>
</li>
<%}%>
</div>
<form action="sort.html" method="get">
    <input type="submit" value="Sort Alphabetically">
</form>

<form action="orderAdded.html" method="get">
    <input type="submit" value="Order Added">
</form>
<form action="search.html" method="post">
    <input type="text" name="searchFor" placeholder="Enter name of note you want to search for" >
    <input type="submit" value="Search">
</form>
<jsp:include page="/addbutton.html"/>
</body>
</html>