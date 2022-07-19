package in.stackroute;

import in.stackroute.config.DatabaseConfig;
import in.stackroute.dao.BookDao;
import in.stackroute.domain.Book;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {

        

    }

    static void insertBooks(){
        Book javaBook = new Book(1, "Java", "12345", "John", "ABC");
        Book pythonBook = new Book(2, "Python", "12346", "John", "ABC");
        Book cBook = new Book(3, "C", "12347", "John", "ABC");

        DatabaseConfig databaseConfig = new DatabaseConfig();
        BookDao bookDao = new BookDao(databaseConfig);

        bookDao.save(javaBook);
        bookDao.save(pythonBook);
        bookDao.save(cBook);
    }
}
