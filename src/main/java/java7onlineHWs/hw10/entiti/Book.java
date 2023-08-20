package java7onlineHWs.hw10.entiti;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Book implements Serializable {

    private Set<Author> authors = new HashSet<>();
    private int id;
    private String name;

    public Book(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void getAuthorsOfBooks() {
        for (Author a : authors) {
            System.out.println("    " + a.toString());
        }
    }

    public int getId() {
        return id;
    }

    public void addAuthor(Author author) {
        authors.add(author);
    }

    public void removeAuthor(Author author) {
        authors.remove(author);
    }

    public void setName(String newName) {
        name = newName;
    }

    @Override
    public String toString() {
        return "Book:" +
                " id - " + id + "," +
                " name - " + name + ".";
    }

}
