
public class Book {
    String isbn;
    String title;
    Date publishDate;
    boolean isAvailable;
    Author author;
    public Author getAuthor() {
        return author;
    }
    public Date getPublishDate() {
        return publishDate;
    }

    public Book(String isbn, String title, Date publishDate, Author author, boolean isAvailable) {
        this.isbn = isbn;
        this.title = title;
        this.publishDate = publishDate;
        this.author = author;
        this.isAvailable = isAvailable;
    }
    public void setAvailable(boolean available) {
        isAvailable = available;
    }

}
