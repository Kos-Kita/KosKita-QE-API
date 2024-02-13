package starter.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.specification.RequestSpecification;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import org.assertj.core.api.Assertions;
import starter.koskita.KoskitaAPI;
import starter.koskita.KoskitaKosAPI;
import starter.koskita.KoskitaResponses;
import starter.koskita.KoskitaUserAPI;
import starter.utils.Constants;
import io.restassured.response.Response;
import java.io.File;
import java.io.IOException;

import io.restassured.response.Response;
import static org.hamcrest.Matchers.equalTo;
import static starter.utils.Constants.authToken;

public class UserStepDef {
    @Steps
    KoskitaAPI koskitaAPI;
    @Steps
    KoskitaKosAPI koskitaKosAPI;
    Response response;
    @Steps
    KoskitaUserAPI koskitaUserAPI;
    @Given("Post Create user with valid {string}")
    public void postCreateUserWithValidJson(String json)
    {
        File jsonCreateUser = new File(Constants.REQ_BODY+ json);
        koskitaUserAPI.postCreateUser(jsonCreateUser);
    }

    @When("Send request post create user")
    public void sendRequestPostCreateUser()
    {
        SerenityRest.when().post(KoskitaUserAPI.POST_CREATE_USER);
    }

    @And("Response body message contains {string}")
    public void responseBodyMessageContains(String type) {
        Response createUserResponse = SerenityRest.then().extract().response();
        String responseBody = createUserResponse.getBody().asString();
        Assertions.assertThat(responseBody).contains(type);
    }

    @Given("Post Create user with invalid {string}")
    public void postCreateUserWithInvalid(String json)
    {
        File jsonCreateUser = new File(Constants.REQ_BODY+ json);
        koskitaUserAPI.postCreateUser(jsonCreateUser);
    }

    @Given("Login users with invalid {string}")
    public void loginUsersWithInvalid(String json)
    {
        File jsonLoginUser = new File(Constants.REQ_BODY + json);
        koskitaAPI.postLoginUser(jsonLoginUser);
    }


    @Given("Get user profile with valid id")
    public void getUserProfileWithValidId() {
        koskitaUserAPI.getUserProfile();
    }

    @When("Send request get user profile")
    public void sendRequestGetUserProfile()
    {
        String Tokek = "Bearer " + Constants.getAuthToken();
        SerenityRest.given()
                .header("Authorization", Tokek)
                .get(KoskitaUserAPI.POST_CREATE_USER);

    }

    @When("Send request get user profile without token")
    public void sendRequestGetUserProfileWithoutToken()
    {
        SerenityRest.when()
                .get(KoskitaUserAPI.POST_CREATE_USER);
    }

    @And("Send request modify user")
    public void sendRequestModifyUser()
    {
        SerenityRest.when()
                .get(KoskitaUserAPI.POST_CREATE_USER);
    }

    @And("Validate modify user json schema {string}")
    public void validateModifyUserJsonSchema(String json)
    {
        File jsonSchema = new File(Constants.JSON_SCHEMA+json);
        SerenityRest.and()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    @And("Update user body name was {string} user_name was {string} email was {string} password was {string} photo_profile was {string} and gender was {string} and send request")
    public void createProductRequestNoName(String name, String user_name, String email, String password, String photo_profile_path, String gender)throws IOException
    {
        File photo_profile = new File(photo_profile_path);
        koskitaUserAPI.updateUserProfile(name, user_name, email, password, photo_profile, gender);
    }

    @And("Update user body name was gender was {string} and send request")
    public void updateUserBodyNameWasGenderWasAndSendRequest(String gender) throws IOException {
        koskitaUserAPI.updateUserProfileGender(gender);
    }


    @And("Update user body name was email was {string} and send request")
    public void updateUserBodyNameWasEmailWasAndSendRequest(String email)  throws IOException
    {
        koskitaUserAPI.updateUserProfileEmail(email);
    }

    @And("Update user body name was password was {string} and send request")
    public void updateUserBodyNameWasPasswordWasAndSendRequest(String password) throws IOException
    {
        koskitaUserAPI.updateUserProfilePassword(password);
    }

    @And("User delete with valid id")
    public void userDeleteWithValidId()
    {
        koskitaUserAPI.deleteValidUser();
    }

    @When("Send request delete user")
    public void sendRequestDeleteUser()
    {
        SerenityRest.when().delete(KoskitaUserAPI.DELETE_USER);
    }

}

