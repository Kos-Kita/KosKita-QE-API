package starter.koskita;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.Constants;
import io.restassured.response.Response;

import java.io.File;
import java.util.Map;
public class KoskitaAPI {

    public static String LOGIN_USER = Constants.BASE_URL + "/login";

    @Step("Post Login User")
    public void postLoginUser(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }





}
