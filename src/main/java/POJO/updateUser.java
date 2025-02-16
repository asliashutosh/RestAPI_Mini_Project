package POJO;

public class updateUser {

    private String login;

    private String email;

    private String password;

    private String pic;

    private Boolean profanity_filter;

    public updateUser(String login, String email, String password, String pic) {
        this.login = login;
        this.email = email;
        this.password = password;
        this.pic = pic;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }


}
