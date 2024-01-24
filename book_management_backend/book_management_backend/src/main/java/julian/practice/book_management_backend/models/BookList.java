package julian.practice.book_management_backend.models;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

@Component
public class BookList {

    private static final Logger logger = LoggerFactory.getLogger(BookList.class);
    private List<Book> bookList = new ArrayList<>();

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    @Autowired
    public BookList() {
    }

    public void addBook(String title, String author, int isbn) {
        if (bookList.isEmpty()) {
            bookList.add(new Book(0, title, author, isbn));
            logger.info("first book with bookID 0 has been added");
        } else {
            int newBookID = bookList.getLast().getBookID() + 1;
            Book newBook = new Book(newBookID, title, author, isbn);
            bookList.add(newBook);
            logger.info("book has been added: " + newBook);
        }
    }

    public void removeBook(String bookID) {
        if (bookList.isEmpty()) {
            logger.error("Book " + bookID + " was not found and thus could not be removed.");
            throw new IllegalArgumentException("Book with ID " + bookID + " was not found and thus could not be removed");
        } else {
            Iterator<Book> iterator = bookList.iterator();
            boolean bookFound = false;

            while (iterator.hasNext()) {
                Book book = iterator.next();
                if (book.getBookID() == (Integer.parseInt(bookID))) {
                    iterator.remove();
                    logger.info("BookID " + bookID + " has been deleted successfully.");
                    bookFound = true;
                    break;
                }
            }

            if(!bookFound) {
                logger.error("BookID " + bookID + " was not found and thus could not be removed");
                throw new IllegalArgumentException("BookID " + bookID + " was not found and thus could not be removed");
            }
        }
    }

    public void updateBook(int IDtoUpdate, String title, String author, int isbn) {
        List<Book> resultList = predicateBookFilter(bookList, book -> book.getBookID() == IDtoUpdate);

        if (resultList.isEmpty()) {
            String errorMessage = "There is no book with this id " + IDtoUpdate + " to update.";
            logger.error(errorMessage);
            throw new IllegalArgumentException(errorMessage);
        }

        Book bookToUpdate = resultList.get(0);

        if (bookToUpdate == null) {
            String errorMessage = "Unexpected null book for id " + IDtoUpdate + ".";
            logger.error(errorMessage);
            throw new IllegalStateException(errorMessage);
        }

        Book updatedBook = new Book(IDtoUpdate, title, author, isbn);
        bookList.set(IDtoUpdate, updatedBook);

        logger.info("Book with id " + updatedBook.getBookID() + " was updated successfully.");
    }

    private List<Book> predicateBookFilter(List<Book> books, Predicate<Book> p) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (p.test(book)) {                       // Condition overwrites test from Predicate --> returns boolean from Predicate
                result.add(book);
            }
        }
        return result;
    }
}
