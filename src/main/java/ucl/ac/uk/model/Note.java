package ucl.ac.uk.model;

public class Note
{
    private String name;
    private String data;

    public Note(String name, String data)
    {
     this.name=name;
     this.data=data;
    }

    public String getName()
    {
        return name;
    }

    public String getData()
    {
        return data;
    }

    public void setName(String name)
    {
        this.name=name;
    }

    public void setData(String data)
    {
        this.data=data;
    }





}
