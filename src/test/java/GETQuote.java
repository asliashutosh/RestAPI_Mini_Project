import API.commonURI;
import API_Helper.EndPoints;
import API_Helper.Headers;
import Base.testBase;
import data.dataFactory;
import io.restassured.response.Response;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

public class GETQuote extends testBase {

    public static Logger log = LogManager.getLogger(GETQuote.class);

    String extentedEndpoint_quote;
    Response response;
    dataFactory data = new dataFactory();
    Headers header = new Headers();
    commonURI GETRequest;

    @Test
    public void getQuote() throws InterruptedException {
        extentedEndpoint_quote = EndPoints.endQuote();

        data.headers = header.getHeaderQuote();

        log.info("Getting a Quote");

        response = GETRequest.getQuoe(extentedEndpoint_quote, data.headers);

    }

}
