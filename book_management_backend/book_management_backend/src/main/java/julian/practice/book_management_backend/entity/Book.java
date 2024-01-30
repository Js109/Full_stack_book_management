package julian.practice.book_management_backend.entity;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(name="book")
public class Book implements Comparable<Book> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="bookID")
    private int bookID;

    @Column(name="title")
    private String title;

    @Column(name = "author")
    private String author;

    @Column(name = "isbn")
    private long isbn;

    public Book() {
    }

    public Book(String title, String author, long isbn) {
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