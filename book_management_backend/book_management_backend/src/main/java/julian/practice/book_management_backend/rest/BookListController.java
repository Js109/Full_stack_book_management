package julian.practice.book_management_backend.rest;

import julian.practice.book_management_backend.models.Book;
import julian.practice.book_management_backend.models.BookList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class BookListController {

    private static final Logger logger = LoggerFactory.getLogger(BookListController.class);

    @Autowired
    BookList bookList;

    @GetMapping("/book")
    public ResponseEntity<BookList> getBookList() {
        logger.info("getBookList called");
        return new ResponseEntity<>(bookList, HttpStatus.OK);
    }

    @PostMapping(value = "/book", consumes = "application/json")
    public ResponseEntity<Map<String, Object>> addBook(@RequestBody Book book) {
        logger.info("addBook called");
        bookList.addBook(book.getTitle(), book.getAuthor(), book.getISBN());

        // Create Object for json response
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Book " + book.getTitle() + " was added successfully.");

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/book/{bookID}", consumes = "application/json")
    public ResponseEntity<Map<String, Object>> deleteBook(@PathVariable String bookID) {
        try {
            bookList.removeBook(bookID);
            Map<String, Object> response = new HashMap<>();
            response.put("message", "Book " + bookID + " has been deleted successfully.");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Book to delete not found", e);
        }
    }

    @PutMapping(value ="/book", consumes = "application/json")
    public ResponseEntity<Map<String, Object>> updateBook(@RequestBody Book updateBook) {
        try {
            bookList.updateBook(updateBook.getBookID(), updateBook.getTitle(), updateBook.getAuthor(), updateBook.getISBN());
            Map<String, Object> response = new HashMap<>();
            response.put("message", "Book " + updateBook.getTitle() + " has been updated successfully.");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Book to update not found", e);
        }
    }
}
