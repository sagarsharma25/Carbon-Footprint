package Models;

/**
 * Created by this pc on 11-04-17.
 */

public class UserModel {

    int id;
    String username;
    String password;
    String emailid;

    public UserModel() {
    }

    public UserModel(String username, String password, String emailid) {
        this.username = username;
        this.password = password;
        this.emailid = emailid;
    }

    public UserModel(int id, String username, String password, String emailid) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.emailid = emailid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmailid() {
        return emailid;
    }

    public void setEmailid(String emailid) {
        this.emailid = emailid;
    }
}
