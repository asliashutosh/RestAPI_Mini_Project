package utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

import java.util.List;

import static io.restassured.RestAssured.given;

public class RestUtils {

    public static Response POSTrequest(Object payload, String extendedURL, List<Header> headers){

        Headers requestHeader = new Headers(headers);
        String request = RestUtils.ConvertToJSON(payload);

        Response response = given().relaxedHTTPSValidation()
                .headers(requestHeader)
                .body(payload)
                .post(extendedURL);

        response.then().log().all().extract().response();

        return response;
    }

    public static Response GETrequest(String extendedURL, List<Header> headers){

        Headers requestHeader = new Headers(headers);

        Response response = given().relaxedHTTPSValidation()
                .headers(requestHeader)
                .get(extendedURL);

        response.then().log().all();

        return response;

    }

    public static Response PUTrequest(Object payload, String extendedURL, List<Header> headers){

        Headers requestHeader = new Headers(headers);
        String request = RestUtils.ConvertToJSON(payload);

        Response response = given().relaxedHTTPSValidation()
                .headers(requestHeader)
                .body(payload)
                .put(extendedURL);

        response.then().log().all().extract().response();

        return response;
    }

    public static Response DELETErequest(String extendedURL, List<Header> headers){

        Headers requestHeader = new Headers(headers);

        Response response = given().relaxedHTTPSValidation()
                .headers(requestHeader)
                .delete(extendedURL);

        response.then().log().all().extract().response();

        return response;
    }

    private static String ConvertToJSON(Object payload) {

        ObjectMapper objectMapper = new ObjectMapper();
        String finalPayload = null;
        try{
            finalPayload = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(payload);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return finalPayload;
    }

    public static String getValueFromResponseBody(Response response, String jsonPath) {
        Object value = response.then().assertThat().extract().path(jsonPath);
        if (value instanceof String) {
            return value.toString();
        } else if (value instanceof Boolean) {
            return value.toString();
        } else if (value instanceof Integer) {
            return value.toString();
        } else {
            String nullValue = (String) value;
            return nullValue;
        }
    }

}
