import java.util.ArrayList;
 public class Client extends User {
    public Profile getProfile() {
        return profile;
    }
    public String getusername(){
        return this.username;
    }
    Profile profile;
    public void setProfile(Profile profile) {
        this.profile = profile;
    }
    public ArrayList<Book> getBorrowedBoooks() {
        return borrowedBoooks;
    }
    public void setBorrowedBoooks(Book borrowedBoooks) {
        this.borrowedBoooks.add(borrowedBoooks);
    }
    public ArrayList<Book> borrowedBoooks = new ArrayList<>();
    public Client(Profile profile, String username, String password) {
        super(profile, username, password);
        this.profile = profile;
    }
}
