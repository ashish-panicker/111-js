package in.stackroute;

import java.util.List;
import in.stackroute.config.DatabaseConfig;
import in.stackroute.dao.BookDao;
import in.stackroute.domain.Book;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {

        readAllBooks();
        updateBook();
        readAllBooks();
    }

    static void updateBook(){
        BookDao bookDao = new BookDao(new DatabaseConfig());
        Book book = bookDao.getBook(2);
        if (book != null) {
            book.setTitle("Java Programming");
            book.setIsbn("123456789");
            book.setAuthor("John Doe");
            book.setPublisher("Stackroute");
            bookDao.update(book);
        }else{
            System.out.println("Book not found");
        }
    }
    
    static void deleteBook(){
        BookDao bookDao = new BookDao(new DatabaseConfig());
        Book book = bookDao.getBook(1);
        if (book != null) {
            bookDao.delete(book.getId());
        }
    }

    static void getBook(){
        DatabaseConfig databaseConfig = new DatabaseConfig();
        BookDao bookDao = new BookDao(databaseConfig);
        Book book = bookDao.getBook(4);
        if(book == null){
            System.out.println("Book not found. " );
            return;
        }
        System.out.println(book);
    }

    static void readAllBooks() {
        BookDao bookDao = new BookDao(new DatabaseConfig());
        List<Book> books = bookDao.getAllBooks();
        if (books.isEmpty()) {
            System.out.println("No books are present");
            return;
        }
        books.forEach(System.out::println);
    }
    
    static void insertBooks() {
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
