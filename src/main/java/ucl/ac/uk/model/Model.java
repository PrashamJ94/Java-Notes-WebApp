package ucl.ac.uk.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

public class Model
{   public Index index=new Index();

    public void createFile(String name,String data)
    {

        try {
            File file=new File("src/main/resources/"+name);
            if(file.createNewFile())
            {
                FileWriter fw=new FileWriter(file);
                fw.write(data);
                fw.close();
                readFile(file);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void readFile(File file)
    {
        try {
            Scanner sc=new Scanner(file);
            String name=file.getName();
            String data="";
            while(sc.hasNextLine())
            {
                data+=sc.nextLine();
            }
            sc.close();

            createNote(name,data);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    public String readFileOfName(String name)
    {
        File file=new File("src/main/resources/"+name);
        String data=readData(file);

        return data;
    }

    public String readData(File file)
    {   String data="";
        Scanner sc= null;
        try {
            sc = new Scanner(file);
            while (sc.hasNextLine())
            {
                data+=sc.nextLine();
            }
            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return data;

    }

    public ArrayList<Note> getListOfNotes(String name)
    {
        ArrayList<Note> ourList=new ArrayList<>();
        ArrayList<Note> noteList=index.getNoteList();

        for(Note note: noteList)
        {
            if((note.getName()).equalsIgnoreCase(name))
            {
                ourList.add(note);
            }
        }

        return ourList;


    }

    public Note getNote(String name)
    {   ArrayList<Note> noteList=index.getNoteList();
        for(Note note:noteList)
        {
            if ((note.getName()).equalsIgnoreCase(name))
                return note;
        }
        return null;
    }

    public void createNote(String name, String data)
    {
        Note note=new Note(name,data);
        index.add(note);
    }

    public void delNote(String name)
    {
        Note note=getNote(name);
        if(note!=null)
        {
            index.delete(note);
            File f=new File("src/main/resources/"+name);
            f.delete();
        }
    }

    public void renameNote(String name, String new_name)
    {
        Note note=getNote(name);
        if(note!=null)
        {
            note.setName(new_name);
            File file=new File("src/main/resources/"+name);
            file.renameTo(new File("src/main/resources/" + new_name));
        }
    }

    private ArrayList<String> getNamesOfNotes(ArrayList<Note> noteList)
    {
        ArrayList<String> noteNames=new ArrayList<String>();

        for(Note note : noteList)
        {
            String noteName=note.getName();
            noteNames.add(noteName);
        }

        Collections.sort(noteNames);
        return noteNames;
    }

    public ArrayList<Note> getSortedIndex(ArrayList<Note> noteList)
    {
        ArrayList<String> sortedNoteNames=getNamesOfNotes(noteList);
        ArrayList<Note> sortedIndex=new ArrayList<Note>();

        for(String name:sortedNoteNames)
        {
            Note note=getNote(name);
            sortedIndex.add(note);
        }

        return sortedIndex;

    }

    public void reverseIndex(ArrayList<Note> noteList)
    {
        Collections.reverse(noteList);
    }

    public void editNote(String name,String data)
    {
        Note note=getNote(name);
        if(note!=null)
        {
            FileWriter fw= null;
            note.setData(data);

            try {
                File file=new File("src/main/resources/"+name);
                fw=new FileWriter(file,false);
                fw.write(data);
                fw.close();

            } catch (IOException e) {
                e.printStackTrace();
            }


        }

    }


}
