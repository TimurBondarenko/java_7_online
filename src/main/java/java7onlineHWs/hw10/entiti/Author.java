package java7onlineHWs.hw10.entiti;

import java.io.Serializable;

public class Author implements Serializable {

    private int id;
    private String name;

    public Author(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setName(String newName) {
        name = newName;
    }

    @Override
    public String toString() {
        return "Author:" +
                " id - " + id + "," +
                " name - " + name + ".";
    }

}


