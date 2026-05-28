package Module_6.ComposerApp;


// Create the Composer class with two constructors
public class Composer {

    private int id;
    private String name;
    private String genre;

    public Composer() {
        this.id = 0;
        this.name = "";
        this.genre = "";
    }

    public Composer(int id, String name, String genre) {
        this.id = id;
        this.name = name;
        this.genre = genre;
    }

    // Methods that return specific data such as id, name, and genre
    
    public int getId()       { return id; }
    public String getName()  { return name; }
    public String getGenre() { return genre; }

    @Override
    public String toString() {
        return "Id: " + id + "\n" +
               "Name: " + name + "\n" +
               "Genre: " + genre;
    }
}