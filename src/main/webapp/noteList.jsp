<%@ page import="java.util.ArrayList" %>
<%@ page import="ucl.ac.uk.model.Note" %>
<html>
<head>
    <title>Search Result</title>
</head>
<body>
<h1>Search Results</h1>
<% ArrayList<Note> listOfSameNotes= (ArrayList<Note>) request.getAttribute("Notes");
   for(Note note:listOfSameNotes)
   {
       String href="noteData.html?noteName="+note.getName(); %>
<li><a href="<%=href%>"><%=note.getName()%></a>
</li>
<%}%>
   </body>
</html>