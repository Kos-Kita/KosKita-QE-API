package starter.koskita;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import net.serenitybdd.rest.SerenityRest;

import java.io.IOException;

import static org.hamcrest.Matchers.equalTo;

public class KoskitaResponses {
    public static String EMAIL = "data.email";
    public static String USERNAME = "data.user_name";
    public static String GENDER = "data.gender";
    public static String NAME = "data.name";
    public static String MESSAGE = "message";
    public static String KOS_ID = "kos_id";
    public static String BOOKING_CODE = "data.booking_code";
    public static String PASSWORD = "password";
    public static String PHOTOPROFILE = "photo_profile";

    public static String ROLE = "data.role";

    @Then("Status code should be {int}")
    public void statusCodeShouldBe(int statusCode) {
        SerenityRest.then().statusCode(statusCode);
    }

    @And("Response body message was {string}")
    public void responseBodyMessageWas(String message) throws IOException  {
        SerenityRest.and()
                .body(KoskitaResponses.MESSAGE, equalTo(message));
    }


}
