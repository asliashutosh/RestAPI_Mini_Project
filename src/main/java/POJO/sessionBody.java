package POJO;

public class sessionBody {

    private userSession user;

    public userSession getUser() {
        return user;
    }

    public void setUser(userSession user) {
        this.user = user;
    }

    public sessionBody(userSession user) {
        this.user = user;
    }
}
