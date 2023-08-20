package java7onlineHWs.hw10.controller;

import java7onlineHWs.hw10.entiti.Author;
import java7onlineHWs.hw10.entiti.Book;
import java7onlineHWs.hw10.dao.Dao;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Controller {

    private Dao dao = new Dao();
    private Scanner scanner = new Scanner(System.in);

    public void crud(){

        while (true){
            System.out.println();
            System.out.println("1. Add book");
            System.out.println("2. Add author");
            System.out.println("3. Give the author's book");
            System.out.println("4. Show list books and authors");
            System.out.println("5. Show the book and its authors");
            System.out.println("6. Remove book");
            System.out.println("7. Remove author");
            System.out.println("8. Remove author from book authors");
            System.out.println("9. Update Book");
            System.out.println("10. Update Author");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            try {
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {

                    case 1 -> {
                        System.out.print("Enter Book ID: ");
                        int id = scanner.nextInt();
                        scanner.nextLine(); // Consume the newline character
                        System.out.print("Enter Book Name: ");
                        String name = scanner.nextLine();
                        dao.addBook(new Book(id, name));
                    }
                    case 2 -> {
                        System.out.print("Enter Author ID: ");
                        int id = scanner.nextInt();
                        scanner.nextLine(); // Consume the newline character
                        System.out.print("Enter Author Name: ");
                        String name = scanner.nextLine();
                        dao.addAuthor(new Author(id, name));
                    }
                    case 3 -> {
                        System.out.print("Enter Book ID: ");
                        int idBook = scanner.nextInt();
                        scanner.nextLine(); // Consume the newline character
                        System.out.print("Enter Author ID: ");
                        int idAuthor = scanner.nextInt();
                        dao.addAuthorToBook(idBook, idAuthor);
                    }
                    case 4 -> {
                        System.out.println("List Book and Author");
                        dao.showBooksAndAuthors();
                    }
                    case 5 -> {
                        System.out.print("Enter Book ID: ");
                        int idBook = scanner.nextInt();
                        dao.showAuthotsOfBooks(idBook);
                    }
                    case 6 -> {
                        System.out.print("Enter Book ID: ");
                        int idBook = scanner.nextInt();
                        dao.removeBook(idBook);
                    }
                    case 7 -> {
                        System.out.print("Enter Author ID: ");
                        int idAuthor = scanner.nextInt();
                        dao.removeAuthor(idAuthor);
                    }
                    case 8 -> {
                        System.out.print("Enter Book ID: ");
                        int idBook = scanner.nextInt();
                        scanner.nextLine(); // Consume the newline character
                        System.out.print("Enter Author ID: ");
                        int idAuthor = scanner.nextInt();
                        dao.removeAuthorFromBook(idBook, idAuthor);
                    }
                    case 9 -> {
                        System.out.print("Enter Book ID: ");
                        int idBook = scanner.nextInt();
                        scanner.nextLine(); // Consume the newline character
                        System.out.print("Enter Author ID: ");
                        String nameBook = scanner.nextLine();
                        dao.changeBookName(idBook, nameBook);
                    }
                    case 10 -> {
                        System.out.print("Enter Book ID: ");
                        int idBook = scanner.nextInt();
                        scanner.nextLine(); // Consume the newline character
                        System.out.print("Enter Author ID: ");
                        String nameBook = scanner.nextLine();
                        dao.changeAuthorName(idBook, nameBook);
                    }
                    case 0 -> {
                        System.out.println("Exiting...");
                        scanner.close();
                        System.exit(0);
                    }

                }

            }catch (InputMismatchException e){
                System.out.println("You entered incorrect data");
                break;
            }

        }

    }

}



