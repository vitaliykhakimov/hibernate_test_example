package vitalik.hibernate.dao.Service;

import vitalik.hibernate.dao.Dao.BookDao;
import vitalik.hibernate.dao.Model.Book;

import java.util.List;

public class BookService {

    private static BookDao bookDao;

    public BookService() {
        bookDao = new BookDao();
    }

    public void persist(Book entity) {
        bookDao.openCurrentSessionWithTransaction();
        bookDao.persist(entity);
        bookDao.closeCurrentSessionWithTransaction();
    }

    public void update(Book entity) {
        bookDao.openCurrentSessionWithTransaction();
        bookDao.update(entity);
        bookDao.closeCurrentSessionWithTransaction();
    }

    public Book findById(String id) {
        bookDao.closeCurrentSession();
        Book book = bookDao.findById(id);
        bookDao.closeCurrentSession();
        return book;
    }

    public void delete(Book entity) {
        bookDao.openCurrentSessionWithTransaction();
        bookDao.delete(entity);
        bookDao.closeCurrentSessionWithTransaction();
    }

    public List<Book> findAll() {
        bookDao.openCurrentSessionWithTransaction();
        List<Book> books = bookDao.findAll();
        bookDao.closeCurrentSessionWithTransaction();
        return books;
    }

    public void deleteAll() {
        bookDao.openCurrentSessionWithTransaction();
        bookDao.deleteAll();
        bookDao.closeCurrentSessionWithTransaction();
    }

    public List<Book> findAllBooksWithExpiredDate() {
        bookDao.openCurrentSessionWithTransaction();
        List<Book> books = bookDao.findAllBooksWithExpiredDate();
        bookDao.closeCurrentSessionWithTransaction();
        return books;
    }
}
