package inner_classes;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private final String name;
    private final List<Book> books;

    public Library(String name) {
        this.name = name;
        this.books = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addBook(String title, String author) {
        var book = new Book(title, author);
        books.add(book);
    }

    public void listBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in the library.");
        } else {
            System.out.println("Books in " + name + " library:");
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }


    public static class Book {
        private String title;
        private String author;

        public Book(String title, String author) {
            this.title = title;
            this.author = author;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String toString() {
            return "Title: " + title + ", Author: " + author;
        }
    }

    public static void main(String[] args) {
        Library library = new Library("City Library");
        library.addBook("The Great Gatsby", "F. Scott Fitzgerald");
        library.addBook("1984", "George Orwell");

        library.listBooks();
    }
}
