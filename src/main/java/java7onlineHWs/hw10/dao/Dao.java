package java7onlineHWs.hw10.dao;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java7onlineHWs.hw10.entiti.Author;
import java7onlineHWs.hw10.entiti.Book;
import java7onlineHWs.hw10.dao.jsonManeger.DaoData;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Dao {

    private Map<Integer, Book> books = new HashMap<>();
    private Map<Integer, Author> authors = new HashMap<>();
    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    private void saveDataToFile() {
        DaoData data = new DaoData(books, authors);
        try (FileWriter writer = new FileWriter("book.json")) {
            gson.toJson(data, writer);
        } catch (IOException e) {
            System.err.println("Error saving data to file: " + e.getMessage());
        }
    }

    // add
    public void addBook(Book book) {
        if (!books.containsKey(book.getId())) {
            books.put(book.getId(), book);
        } else {
            System.out.println("Book with the same ID already exists.");
        }
    }

    public void addAuthor(Author author) {

        if (!authors.containsKey(author.getId())) {
            authors.put(author.getId(), author);
        } else {
            System.out.println("Author with the same ID already exists.");
        }

    }

    public void addAuthorToBook(int idBook, int idAuthor) {

        if (books.containsKey(idBook) && authors.containsKey(idAuthor)) {
            Book book = books.get(idBook);
            saveDataToFile();
            Author author = authors.get(idAuthor);
            book.addAuthor(author);
            saveDataToFile();
            System.out.println("Book or Author not found.");
        }

    }

    // remove

    public void removeBook(int id) {
        if (books.containsKey(id)) {
            books.remove(id);
            System.out.println("Book with ID " + id + " has been removed.");
        } else {
            System.out.println("Book with ID " + id + " not found.");
        }
    }

    public void removeAuthor(int id) {
        if (authors.containsKey(id)) {
            authors.remove(id);
            System.out.println("Author with ID " + id + " has been removed.");
        } else {
            System.out.println("Author with ID " + id + " not found.");
        }
    }

    public void removeAuthorFromBook(int idBook, int idAuthor) {
        if (books.containsKey(idBook) && authors.containsKey(idAuthor)) {
            Book book = books.get(idBook);
            Author author = authors.get(idAuthor);
            book.removeAuthor(author);
            saveDataToFile();
        } else {
            System.out.println("Book or Author not found.");
        }
    }

    // show

    public void showBooksAndAuthors() {
        for (Integer key : books.keySet()) {
            System.out.println(books.get(key));
        }

        for (Integer key : authors.keySet()) {
            System.out.println(" " + authors.get(key));
        }
    }

    public void showAuthotsOfBooks(int idBook) {
        try {
            Book book = books.get(idBook);
            System.out.println(books.get(idBook));
            book.getAuthorsOfBooks();
        } catch (NullPointerException e) {
            System.out.println("Most likely, the Book object with id " + idBook + " no exists... ");
            e.printStackTrace(); // Most likely, the Book object with id no longer exists...
        }
    }

    // upDate

    public void changeBookName(int idBook, String newName) {
        if (books.containsKey(idBook)) {
            Book book = books.get(idBook);
            book.setName(newName);
            saveDataToFile();
        } else {
            System.out.println("Book not found.");
        }
    }

    public void changeAuthorName(int idAuthor, String newName) {
        if (authors.containsKey(idAuthor)) {
            Author author = authors.get(idAuthor);
            author.setName(newName);
            saveDataToFile();
        }else {
            System.out.println("Author not found");
        }
    }
}




