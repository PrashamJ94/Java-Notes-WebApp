package ucl.ac.uk.model;

import java.util.ArrayList;

public class Index
{
    private ArrayList<Note> noteList;

    public Index()
    {
        noteList=new ArrayList<Note>();
    }



    public ArrayList<Note> getNoteList()
    {
        return noteList;
    }

    public void add(Note note)
    {
        noteList.add(note);
    }

    public void delete(Note note)
    {
        noteList.remove(note);
    }



}
