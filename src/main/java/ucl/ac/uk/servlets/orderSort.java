package ucl.ac.uk.servlets;
import ucl.ac.uk.model.Model;
import ucl.ac.uk.model.ModelFactory;
import ucl.ac.uk.model.Note;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/orderAdded.html")
public class orderSort extends HttpServlet
{
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Model model=ModelFactory.getModel();
        ArrayList<Note> noteList=model.index.getNoteList();
        model.reverseIndex(noteList);

        request.setAttribute("NoteIndex",noteList);

        ServletContext context=getServletContext();
        RequestDispatcher dispatch= context.getRequestDispatcher("/index.jsp");
        dispatch.forward(request,response);

    }
}
