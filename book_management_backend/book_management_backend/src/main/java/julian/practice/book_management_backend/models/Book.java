package julian.practice.book_management_backend.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Objects;

@Component
public class Book implements Comparable<Book> {

    private int bookID;
    private String title;
    private String author;
    private long isbn;

    @Autowired
    public Book() {
    }

    public Book(int bookID, String title, String author, long isbn) {
        this.bookID = bookID;
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    public int getBookID() {
        return bookID;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
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

    public long getISBN() {
        return isbn;
    }

    public void setISBN(int isbn) {
        this.isbn = isbn;
    }

    @Override
    public String toString() {
        return "BookID " + bookID + ", " + title + ", " + author + ", " + isbn;
    }

    // equals() und hashCode() have be overriden for HashSet, HashMap and LinkedHashSet, LinkedHashMap
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return isbn == book.isbn && Objects.equals(title, book.title) && Objects.equals(author, book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookID, title, author, isbn);
    }

    // compareTo does a lexicographic comparison of Strings
    @Override
    public int compareTo(Book o) {
        // this - that
        //      >       >0 positiv
        //      <       <0 negativ
        //      =       =0
        return Long.compare(this.isbn, o.isbn) + this.title.compareTo(o.title) + this.author.compareTo(o.author);
    }
}
