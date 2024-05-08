
import java.security.*;
abstract public class User {
    Profile profile;
    String username;
    String password;
    public User(Profile profile, String username, String password) {
        this.profile = profile;
        this.username = username;
        if (password != null) {
            setPassword(password);
        } else {
            System.out.println("Error");
        }
    }
    public void setPassword(String password) {
        this.password = hashPassword(password);
    }
    public boolean checkPassword(String inputPassword) {
        return hashPassword(inputPassword).equals(this.password);
    }
    private String hashPassword(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(password.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
    public String getPassword() {
        return password;
    }
}
