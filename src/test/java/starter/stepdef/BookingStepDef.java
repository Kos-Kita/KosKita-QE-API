package starter.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.koskita.*;
import starter.utils.Constants;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class BookingStepDef {
    @Steps
    KoskitaAPI koskitaAPI;
    @Steps
    KoskitaKosAPI koskitaKosAPI;
    Response response;
    @Steps
    KoskitaUserAPI koskitaUserAPI;
    @Steps
    KoskitaBookingUserAPI koskitaBookingUserAPI;
    @Given("Post Create booking user with valid json {string} and send request")
    public void postCreateBookingUserWithValidJson(String json)
    {
        File jsonCreateBookingUser = new File(Constants.REQ_BODY+ json);
        koskitaBookingUserAPI.postCreateBookingUser(jsonCreateBookingUser);

    }

}


