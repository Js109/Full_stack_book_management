package julian.practice.book_management_backend.rest;

import julian.practice.book_management_backend.entity.Book;
import julian.practice.book_management_backend.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PersistentBookController {

    private BookService bookService;

    @Autowired
    public PersistentBookController(BookService theBookService) {
        bookService = theBookService;
    }

    @GetMapping("/books")
    public List<Book> findAll() {
        return bookService.findAll();
    }

    @GetMapping("/books/{bookId}")
    public Book getBook(@PathVariable int bookId) {

        Book theBook = bookService.findById(bookId);

        if (theBook == null) {
            throw new RuntimeException("book id not found - " + bookId);
        }

        return theBook;
    }

    // add mapping for POST /books - add new book

    @PostMapping("/books")
    public Book addBook(@RequestBody Book theBook) {

        // also just in case they pass an id in JSON ... set id to 0
        // this is to force a save of new item ... instead of update

        theBook.setBookID(0);

        Book dbBook = bookService.save(theBook);

        return dbBook;
    }

    // add mapping for PUT /books - update existing book

    @PutMapping("/books")
    public Book updateBook(@RequestBody Book theBook) {

        Book dbBook = bookService.save(theBook);

        return dbBook;
    }

    // add mapping for DELETE /books/{bookId} - delete book

    @DeleteMapping("/books/{bookId}")
    public String deleteBook(@PathVariable int bookId) {

        Book tempBook = bookService.findById(bookId);

        // throw exception if null

        if (tempBook == null) {
            throw new RuntimeException("Book id not found - " + bookId);
        }

        bookService.deleteById(bookId);

        return "Deleted book id - " + bookId;
    }
}
