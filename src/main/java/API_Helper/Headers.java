package API_Helper;

import io.restassured.http.Header;
import utils.ReadingPropertiesFile;

import java.util.ArrayList;
import java.util.List;

public class Headers {

    public List<Header> postHeaderCreateUser(){
        List<Header> headerList = new ArrayList<Header>();
        headerList.add(new Header("Content-Type", "application/json"));
        headerList.add(new Header("Authorization", "Token token=\"f08c521ab72914ef2267dbba132f51d3\""));
        return headerList;
    }

    public List<Header> getHeaderQuote(){
        List<Header> headerList = new ArrayList<Header>();
        headerList.add(new Header("Content-Type", "application/json"));
        return headerList;
    }

    public List<Header> getUser(String userToken){
        List<Header> headerList = new ArrayList<Header>();
        headerList.add(new Header("Content-Type", "application/json"));
        headerList.add(new Header("Authorization", "Token token=\"f08c521ab72914ef2267dbba132f51d3\""));
        headerList.add(new Header("User-Token", userToken));
        return headerList;
    }


}
