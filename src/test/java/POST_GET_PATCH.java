import API.commonURI;
import API_Helper.EndPoints;
import API_Helper.Headers;
import Base.testBase;
import POJO.sessionBody;
import POJO.updateBody;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import data.dataFactory;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import payLoad.POSTcreateSession;
import payLoad.POSTcreateUser;
import POJO.bodyPOJO;
import payLoad.PUTupdateUser;

import javax.sound.midi.Soundbank;

public class POST_GET_PATCH extends testBase {

    commonURI POSTRequest;
    commonURI GETRequest;

    commonURI PUTRequest;
    Headers header = new Headers();
    dataFactory data = new dataFactory();

    String extentedEndPoint;

    bodyPOJO requestPayload;
    sessionBody requestSessionPayload;
    updateBody requestUpdatePayload;
    POSTcreateUser payload;
    POSTcreateSession sessionPayload;
    PUTupdateUser updatePayload;


    Response respose;

    @Test
    public void createUser() throws InterruptedException, JsonProcessingException {
        // To make a POST request we need End point Header and Body

        // Headers
        data.headers = header.postHeaderCreateUser();
        // EndPoint
        extentedEndPoint = EndPoints.endCreateUser();
        // Body
        requestPayload = payload.bodyPayLoad();

//        ObjectMapper map = new ObjectMapper();
//        String pp = map.writerWithDefaultPrettyPrinter().writeValueAsString(requestPayload);

        respose = POSTRequest.postCreateUser(requestPayload, extentedEndPoint,data.headers);

        String userToken = respose.path("User-Token");

        String login = respose.path("login");

        // Storing the values for further use
        data.setToken(userToken);
        data.setLogin(login);


    }

    @Test
    public void createUserSession() throws JsonProcessingException, InterruptedException {

        data.headers = header.postHeaderCreateUser();

        extentedEndPoint = EndPoints.endCreateSession();

        requestSessionPayload = sessionPayload.sessionPayload();

        respose = POSTRequest.postCreateUser(requestSessionPayload, extentedEndPoint, data.headers);

        String userToken = respose.path("User-Token");

        String login = respose.path("login");

        data.setToken(userToken);
        data.setLogin(login);

    }

    @Test(dependsOnMethods = "createUserSession")
    public void getUser(){
        // Using the stored values
        String token = data.getToken();
        String login = data.getLogin();

        data.headers = header.getUser(token);
        extentedEndPoint = EndPoints.getUser(login);

        respose = GETRequest.getUserDetails(extentedEndPoint,data.headers);

    }

    @Test(dependsOnMethods = "createUserSession")
    public void updateUser() throws JsonProcessingException, InterruptedException {
        String token = data.getToken();
        String login = data.getLogin();

        data.headers = header.getUser(token);
        extentedEndPoint = EndPoints.getUser(login);

        requestUpdatePayload = updatePayload.updatePayload();

        respose = PUTRequest.putUpdateUser(requestUpdatePayload,extentedEndPoint,data.headers);

    }


}
