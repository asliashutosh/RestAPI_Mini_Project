package API;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.response.Response;
import utils.RestUtils;

import java.util.List;

public class commonURI {

    public static Response postCreateUser(Object payload, String extendedUrl, List<Header> headers) throws InterruptedException {
        RestAssured.baseURI= "https://favqs.com/api";
        return RestUtils.POSTrequest(payload,extendedUrl,headers);
    }

    public static Response getQuoe(String extendedUrl, List<Header> headers) throws InterruptedException {
        RestAssured.baseURI= "https://favqs.com/api/";
        return RestUtils.GETrequest(extendedUrl,headers);
    }

    public static Response getUserDetails(String extendedUrl,List<Header> headers){
        RestAssured.baseURI= "https://favqs.com/api";
        return RestUtils.GETrequest(extendedUrl,headers);
    }

    public static Response putUpdateUser(Object payload, String extendedUrl, List<Header> headers) throws InterruptedException {
        RestAssured.baseURI= "https://favqs.com/api";
        return RestUtils.PUTrequest(payload,extendedUrl,headers);
    }


}
