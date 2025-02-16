package payLoad;

import POJO.updateBody;
import POJO.updateUser;

public class PUTupdateUser {

    public static updateBody updatePayload(){
        updateUser user = new updateUser("29941", "ashutosh.nagarro06@gmail.com", "3a144068ae2acb578e","twitter");
        updateBody updatePayload = new updateBody(user);
        return updatePayload;
    }
}
