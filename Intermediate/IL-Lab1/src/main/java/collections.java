import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class collections {
    public static class Book {
        private String author;
        private String title;

        public Book(String author, String title) {
            this.author = author;
            this.title = title;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        @Override
        public String toString() {
            return "Book [author=" + author + ", title=" + title + "]";
        }
    }

    public static class BookAuthorComparator implements Comparator<Book> {

        @Override
        public int compare(Book o1, Book o2) {
            return o1.getAuthor().compareTo(o2.getAuthor());
        }
    }

    public static class BookTitleComparator implements Comparator<Book> {

        @Override
        public int compare(Book o1, Book o2) {
            return o1.getTitle().compareTo(o2.getTitle());
        }
    }

    public static void main(String[] args) {
        var books = new ArrayList<Book>();
        var bookAuthorComparator = new BookAuthorComparator();

        books.add(new Book("Nancy", "Once upon a time"));
        books.add(new Book("Jimmy", "There was a man"));
        books.add(new Book("Speed", "Sitting on the sun"));

        System.out.println("before sorting by author: " + books);
        Collections.sort(books, bookAuthorComparator);
        System.out.println("after author sorting: " + books);
        Collections.sort(books, new BookTitleComparator());
        System.out.println("after title sorting: " + books);
    }
}
