package com.wjoansah.ex3integrationtesting.library.books;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class BookIntegrationTest {
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testSearchBooksByTitle() {
        // Stub for BookRepository (simulating database interaction)
        BookRepository bookRepositoryStub = mock(BookRepository.class);

        // Sample book data
        List<Book> books = Arrays.asList(new Book("The Great Gatsby", "F. Scott Fitzgerald", "1234567890"));

        // Stub behavior: return the sample books when searched by title
        when(bookRepositoryStub.findByTitle("The Great Gatsby")).thenReturn(books);

        // Service layer that uses the stubbed repository
        BookService bookService = new BookService(bookRepositoryStub);

        // Perform the search
        List<Book> result = bookService.searchBooksByTitle("The Great Gatsby");

        // Assert that the result contains the expected book
        assertEquals(1, result.size());
        assertEquals("The Great Gatsby", result.getFirst().getTitle());
    }

    @Test
    public void testSearchBookByTitleWithoutStubs() throws Exception {
        bookRepository.save(new Book("The Great Gatsby", "F. Scott Fitzgerald", "1234567890"));

        mockMvc.perform(get("/books/search?title=The Great Gatsby"))
                .andExpect(status().isOk())
                .andExpect(content().string(Matchers.containsString("The Great Gatsby")));
    }
}