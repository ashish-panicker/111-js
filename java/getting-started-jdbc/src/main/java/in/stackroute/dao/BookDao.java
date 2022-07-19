package in.stackroute.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import in.stackroute.config.DatabaseConfig;
import in.stackroute.domain.Book;

public class BookDao {

    private static final String INSERT_SQL =
            "INSERT INTO BOOKS (id, title, isbn, author, publisher) VALUES (?, ?, ?, ?, ?)";
    private static final String UPDATE_SQL =
            "UPDATE BOOKS SET title=?, isbn=?, author=?, publisher=? WHERE id=?";
    private static final String DELETE_SQL = "DELETE FROM BOOKS WHERE id=?";
    private static final String SELECT_SQL = "SELECT * FROM BOOKS WHERE id=?";
    private static final String SELECT_ALL_SQL = "SELECT * FROM BOOKS";

    private DatabaseConfig databaseConfig;

    public BookDao(DatabaseConfig databaseConfig) {
        this.databaseConfig = databaseConfig;
    }

    public void save(Book book) {
        try(PreparedStatement ps = databaseConfig.getConnection().prepareStatement(INSERT_SQL)) {
            ps.setInt(1, book.getId());
            ps.setString(2, book.getTitle());
            ps.setString(3, book.getIsbn());
            ps.setString(4, book.getAuthor());
            ps.setString(5, book.getPublisher());
            int updated = ps.executeUpdate();
            if (updated > 0) {
                System.out.println("Book saved successfully");
            } else {
                System.out.println("Book not saved");
            }
        } catch (SQLException e) {
            System.err.println("Exception: Cannot save new book details. \n" + e.getMessage());
        }
    }

    public Book getBook(String id) {
        // get the book
        return null;
    }

    public void delete(String id) {
        // delete the book
    }

    public void update(Book book) {
        // update the book
    }

    public List<Book> getAllBooks() {
        List<Book> books = new ArrayList<>();
        try (Statement statement = databaseConfig.getConnection().createStatement()) {
            ResultSet resultSet = statement.executeQuery(SELECT_ALL_SQL);
            while (resultSet.next()) {
                Book book = new Book();
                book.setId(resultSet.getInt("id"));
                book.setTitle(resultSet.getString("title"));
                book.setIsbn(resultSet.getString("isbn"));
                book.setAuthor(resultSet.getString("author"));
                book.setPublisher(resultSet.getString("publisher"));
                books.add(book);
            }
        } catch (SQLException e) {
            System.err.println("Exception: Cannot fetch all book details. \n" + e.getMessage());
        }
        return books;
    }


}
