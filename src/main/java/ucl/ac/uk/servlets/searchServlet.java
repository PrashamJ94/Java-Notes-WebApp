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

@WebServlet("/search.html")
public class searchServlet extends HttpServlet
{
    @Override
    public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {

        Model model=ModelFactory.getModel();
        String name=request.getParameter("searchFor");

        ArrayList<Note> listOfSameNotes=model.getListOfNotes(name);

        request.setAttribute("Notes",listOfSameNotes);

        ServletContext context=getServletContext();
        RequestDispatcher dispatcher=context.getRequestDispatcher("/noteList.jsp");
        dispatcher.forward(request,response);

    }
}
