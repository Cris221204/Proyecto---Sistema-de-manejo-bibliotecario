import java.util.ArrayList;

public class Administrator extends User {
    public ArrayList<Permissions> permissions = new ArrayList<Permissions>();

    boolean isSuperAdmin;
    public ArrayList<Permissions> getPermissions() {
        return this.permissions;
    }
    public void addPermissions(){
        permissions.add(Permissions.DELETE);
        permissions.add(Permissions.READ);
        permissions.add(Permissions.WRITE);
    }
    public void addRead(){
        permissions.add(Permissions.READ);
    }
    public void addWrite(){
        permissions.add(Permissions.WRITE);
    }
    public void addDelete(){
        permissions.add(Permissions.DELETE);
    }

    public Administrator(Profile profile, String username, String password, boolean isSuperAdmin) {
        super(profile, username, password);
        this.isSuperAdmin = isSuperAdmin;
    }
}