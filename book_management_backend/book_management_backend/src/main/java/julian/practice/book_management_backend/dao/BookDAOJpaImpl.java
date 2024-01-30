package julian.practice.book_management_backend.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import julian.practice.book_management_backend.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookDAOJpaImpl implements BookDAO {

    private EntityManager entityManager;

    @Autowired
    public BookDAOJpaImpl(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }

    @Override
    public List<Book> findAll() {

        TypedQuery<Book> theQuery = entityManager.createQuery("from Book", Book.class);

        List<Book> books = theQuery.getResultList();

        return books;
    }

    @Override
    public Book findById(int theBookID) {
        Book theBook = entityManager.find(Book.class, theBookID);

        return theBook;
    }

    @Override
    public Book save(Book theBook) {
        Book dbBook = entityManager.merge(theBook);
        return dbBook;
    }

    @Override
    public void deleteById(int theId) {
        Book theBook = entityManager.find(Book.class, theId);

        entityManager.remove(theBook);
    }
}
