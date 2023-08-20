package java7onlineHWs.hw10.dao.jsonManeger;

import java7onlineHWs.hw10.entiti.Author;
import java7onlineHWs.hw10.entiti.Book;

import java.util.HashMap;
import java.util.Map;

public class DaoData {

    private Map<Integer, Book> books = new HashMap<>();
    private Map<Integer, Author> authors = new HashMap<>();

    public DaoData(Map<Integer, Book> books, Map<Integer, Author> authors) {
        this.books = books;
        this.authors = authors;
    }

    public Map<Integer, Book> getBooks() {
        return books;
    }

    public Map<Integer, Author> getAuthors() {
        return authors;
    }

}



