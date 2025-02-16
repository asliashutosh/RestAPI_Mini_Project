package utils;


import com.relevantcodes.extentreports.LogStatus;
import io.restassured.response.Response;
import org.testng.Assert;

import java.util.Map;

import static Base.testBase.test;

public class RestValidation {

    public static void validateField(Response response, String jsonPath, Object expectedValue) {
        String actualValue = RestUtils.getValueFromResponseBody(response, jsonPath);
        if (expectedValue instanceof String) {
            Assert.assertEquals(actualValue, expectedValue);
            test.log(LogStatus.INFO,jsonPath + ": "+ actualValue);
        } else if (expectedValue instanceof Boolean) {
            Assert.assertEquals(Boolean.parseBoolean(actualValue), expectedValue);
            test.log(LogStatus.INFO,jsonPath + ": "+ actualValue);
        } else if (expectedValue instanceof Integer) {
            Assert.assertEquals(Integer.parseInt(actualValue), expectedValue);
            test.log(LogStatus.INFO,jsonPath + ": "+ actualValue);
        } else if (expectedValue instanceof Object) {
            Assert.assertEquals(actualValue, expectedValue);
            test.log(LogStatus.INFO,jsonPath + ": "+ actualValue);
        } else {
            Assert.assertEquals(actualValue, expectedValue);
            test.log(LogStatus.INFO,jsonPath + ": "+ actualValue);
        }
    }

    public static void validateStatusCode(Response response, int statusCode) {
        int statusCodeResponse = response.getStatusCode();
        Assert.assertEquals(statusCodeResponse, statusCode);
        test.log(LogStatus.INFO,"STATUS CODE : " + statusCodeResponse);
    }


    public static void validateResponseBody(Response response, Map<String, Object> expectedBookingDetails)
    {
        RestValidation.validateField(response,"booking.firstname",expectedBookingDetails.get("firstName"));
        RestValidation.validateField(response,"booking.lastname",expectedBookingDetails.get("lastName"));
        RestValidation.validateField(response,"booking.totalprice",expectedBookingDetails.get("totalPrice"));
        RestValidation.validateField(response,"booking.additionalneeds",expectedBookingDetails.get("additionalNeeds"));
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

