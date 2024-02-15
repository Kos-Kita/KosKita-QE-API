package starter.utils;

public class Constants {
    public static String DIR = System.getProperty("user.dir");
    public static String BASE_URL = "http://57.181.35.232";
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

    public static String CONSTANT_TOKEN_GET_USER_PROFILE = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdXRob3JpemVkIjp0cnVlLCJleHAiOjE3MDc3NTQzNDMsInVzZXJJZCI6MTN9.aiICOFJWTDveEbG5lDADVs3UyoJr6Dw0Tnk3Z11VIJg";
    public static String CONSTANT_TOKEN = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdXRob3JpemVkIjp0cnVlLCJleHAiOjE3MDc5MTI4NjEsInVzZXJJZCI6MjV9.6ZITebXLnD0P39Xe_KK_GtdKFAo9AObE7QrwmEtRwpM";


}
