package com.wjoansah.ex3integrationtesting.library.books;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> searchBooksByTitle(String title) {
        return bookRepository.findByTitle(title);
    }

    public Book createBook(String title, String author, String isbn) {
        var newBook = new Book(title, author, isbn);
        return bookRepository.save(newBook);
    }
}
