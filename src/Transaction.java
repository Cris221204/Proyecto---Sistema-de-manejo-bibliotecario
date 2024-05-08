public class Transaction {
    String id;
    String type;
    Client client;
    Book book;
    Date date;
    public Client getClient() {
        return client;
    }
    public Book getBook() {
        return book;
    }
    public Date getDate() {
        return date;
    }
    public Transaction(String id, String type, Client client, Book book, Date date) {
        this.id = id;
        this.type = type;
        this.client = client;
        this.book = book;
        this.date = date;
    }
}
