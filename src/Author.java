
import java.util.ArrayList;

public class Author {
    Profile profile;

    public Profile getProfile() {
        return profile;
    }

    public Author(Profile profile) {
        this.profile = profile;
    }

    public void setAuthor(Book author) {
        this.Author.add(author);
    }

    public ArrayList<Book> getAuthor() {
        return Author;
    }

    public ArrayList<Book> Author = new ArrayList<>();
}
