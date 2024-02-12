package starter.utils;

public class Constants {
    public static String DIR = System.getProperty("user.dir");
    public static String BASE_URL = "https://l3n.my.id";
    public static String JSON_DIR = DIR+"/src/test/resources/JSON";
    public static String REQ_BODY = JSON_DIR + "/ReqBody/";
    public static String JSON_SCHEMA = JSON_DIR + "/JsonSchema/";
    public static String PHOTO_DIR = DIR + "/src/test/resources/Photo";

    public static String authToken;
    public static void setAuthToken(String token) {
        authToken = token;
    }
    public static String getAuthToken() {
        return authToken;
    }


}
