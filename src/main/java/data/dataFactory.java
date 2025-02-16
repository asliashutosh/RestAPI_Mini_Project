package data;

import io.restassured.http.Header;

import java.util.List;

public class dataFactory {

    public List<Header> headers;

    public String token;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String login;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
