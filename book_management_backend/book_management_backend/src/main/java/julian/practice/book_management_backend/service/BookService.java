package julian.practice.book_management_backend.service;

import julian.practice.book_management_backend.entity.Book;

import java.util.List;

public interface BookService {

    List<Book> findAll();

    Book findById(int theId);

    Book save(Book theBook);

    void deleteById(int theId);
}
