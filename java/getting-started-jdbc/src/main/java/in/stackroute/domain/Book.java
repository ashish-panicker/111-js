package in.stackroute.domain;

public class Book {

    private int id;

    private String title;

    private String isbn;

    private String author;

    private String publisher;

    public Book() {}


    public Book(int id, String title, String isbn, String author, String publisher) {
        this.id = id;
        this.title = title;
        this.isbn = isbn;
        this.author = author;
        this.publisher = publisher;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }


    @Override
    public String toString() {
        return String.format("Book [author=%s, id=%s, isbn=%s, publisher=%s, title=%s]", author, id,
                isbn, publisher, title);
    }


}
