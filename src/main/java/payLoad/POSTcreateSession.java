package payLoad;

import POJO.sessionBody;
import POJO.userSession;

public class POSTcreateSession {

    public static sessionBody sessionPayload(){
        userSession user = new userSession("ashutosh.nagarro06@gmail.com", "3a144068ae2acb578e");

        sessionBody sessionPayload = new sessionBody(user);
        return sessionPayload;

    }
}
