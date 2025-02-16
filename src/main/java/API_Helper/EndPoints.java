package API_Helper;

public class EndPoints {

    public static String endCreateUser(){

        return String.format("/users");
    }

    public static String endQuote(){

        return String.format("qotd");
    }

    public static String getUser(String login){

        return String.format("/users/"+ login);
    }

    public static String endCreateSession(){

        return String.format("/session");
    }


}
