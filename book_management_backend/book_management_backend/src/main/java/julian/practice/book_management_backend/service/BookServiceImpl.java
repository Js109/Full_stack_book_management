package julian.practice.book_management_backend.service;

import jakarta.transaction.Transactional;
import julian.practice.book_management_backend.dao.BookDAO;
import julian.practice.book_management_backend.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private BookDAO bookDAO;

    @Autowired
    public BookServiceImpl(BookDAO theBookDAO) {
        bookDAO = theBookDAO;
    }

    @Override
    public List<Book> findAll() {
        return bookDAO.findAll();
    }

    @Override
    public Book findById(int theId) {
        return bookDAO.findById(theId);
    }

    @Transactional
    @Override
    public Book save(Book theBook) {
        return bookDAO.save(theBook);
    }

    @Transactional
    @Override
    public void deleteById(int theId) {
        bookDAO.deleteById(theId);
    }

}
