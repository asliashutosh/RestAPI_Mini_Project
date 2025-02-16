package payLoad;


import POJO.bodyPOJO;
import POJO.user;

public class POSTcreateUser {
    
    public static bodyPOJO bodyPayLoad(){

        user user = new user("gdgfdgd4454", "dfgdgdf4464@gmail.com", "TEST123TEST");

        bodyPOJO bodyPayLoad = new bodyPOJO(user);
        return bodyPayLoad;
    }
}
