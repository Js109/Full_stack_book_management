package julian.practice.book_management_backend.dao;

import julian.practice.book_management_backend.entity.Book;
import java.util.List;

public interface BookDAO {

    List<Book> findAll();

    Book findById(int theBookID);

    Book save(Book theBook);

    void deleteById(int theId);
}
