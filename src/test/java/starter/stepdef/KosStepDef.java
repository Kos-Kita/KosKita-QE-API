package starter.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.koskita.KoskitaAPI;
import starter.koskita.KoskitaKosAPI;
import starter.koskita.KoskitaPhotoAPI;
import starter.koskita.KoskitaResponses;
import starter.utils.Constants;
import java.io.IOException;


import java.io.File;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.Matchers.equalTo;
import static starter.koskita.KoskitaPhotoAPI.POST_PHOTO;


public class KosStepDef {


    @Steps
    KoskitaAPI koskitaAPI;
    @Steps
    KoskitaKosAPI koskitaKosAPI;

    @Steps
    KoskitaPhotoAPI koskitaPhotoAPI;

    @Given("Login users with valid {string}")
    public void loginUsersWithValid(String json) {
        File jsonLoginUser = new File(Constants.REQ_BODY + json);
        koskitaAPI.postLoginUser(jsonLoginUser);
    }


    @When("Send request login user")
    public void sendRequestLoginUser() {
        SerenityRest.when().post(KoskitaAPI.LOGIN_USER);

        // Mendapatkan respons dari permintaan login
        Response response = SerenityRest.lastResponse();

        // Menggunakan JsonPath untuk mengambil token dari respons JSON
        JsonPath jsonPath = response.jsonPath();
        String token = jsonPath.getString("data.token");

        // Menyimpan token menggunakan TokenManager
        Constants.setAuthToken(token);
//        Constants.authToken = "Bearer " + token;
        System.out.println("Token disimpan: " + Constants.getAuthToken());
    }




        @And("Response body message was {string} and role was {string}")
    public void responseBodyMessageWas(String message, String role) {
        SerenityRest.and()
                .body(KoskitaResponses.MESSAGE, equalTo(message))
                .body(KoskitaResponses.ROLE, equalTo(role));
    }

    @And("Validate login user json schema {string}")
    public void validateLoginUserJsonSchema(String json) {
        File jsonSchema = new File(Constants.JSON_SCHEMA+json);
        SerenityRest.and()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }



// case 1

    @Given("Get kos with valid {string}")
    public void getKosWithValidKos_id(String kos_id) {
        koskitaKosAPI.setGetSingleKos(kos_id);

    }

    @When("Send request get single kos")
    public void sendRequestGetKos() {
        SerenityRest.when().get(koskitaKosAPI.GET_SINGLE_KOS);
    }



    @And("Validate get kos_id json schema {string}")
    public void validateGetKos_idJsonSchema(String json) {
        File jsonSchema = new File(Constants.JSON_SCHEMA+json);
        SerenityRest.and()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    @Given("Get my kos")
    public void getMyKos() {
        koskitaKosAPI.setGetMyKos();
    }

    @When("Send request get my kos")
    public void sendRequestGetMyKos() {
        String Tokek = "Bearer " + Constants.getAuthToken();
        // Mengirim permintaan dengan menggunakan token yang telah disimpan sebelumnya
        SerenityRest.given()
                .header("Authorization", Tokek)
                .get(koskitaKosAPI.GET_MY_KOS);

    }

    @When("Get search kos with param {string} {string} {string} {string}")
    public void getSearchKosWithParam(String address, String category, String minPrice, String maxPrice) {
    koskitaKosAPI.setGetKos(address, category, minPrice, maxPrice);
    }

    @And("Send request get kos")
    public void sendRequestGetRecKos() {
        SerenityRest.when().get(koskitaKosAPI.GET_KOS);
    }


    @When("Get kos")
    public void getKos() {
        koskitaKosAPI.setGetMyKos();
    }

    @And("Send request get kos recommendation")
    public void sendRequestGetKosRecommendation() {;
        SerenityRest.when().get(koskitaKosAPI.GET_REC_KOS);
    }


    @And("Create kos using {string} and send request")
    public void createKosUsingAndSendRequest(String json) {
        File jsonCreateUser = new File(Constants.REQ_BODY + json);
        koskitaKosAPI.postCreateKos(jsonCreateUser);
    }

    @And("Update kos with {string} using {string} and send request")
    public void updateKosWithUsingAndSendRequest(String kos_id, String json) {
        File jsonUpdateKos = new File(Constants.REQ_BODY+json);
        koskitaKosAPI.updateKos(kos_id, jsonUpdateKos);
    }

    @And("Delete kos with {string} and request")
    public void deleteKosWith(String kos_id) {
        koskitaKosAPI.setDeleteKos(kos_id);
        SerenityRest.when().delete(koskitaKosAPI.GET_SINGLE_KOS);
    }

    Response response;

    @And("Post photo using {string} with empty and send request" )
    public void postPhotoUsingWithEmpty(String kos_id) {
        koskitaPhotoAPI.setPostPhotoEmpty(kos_id);
    }


    @And("Update photo using {string} with empty and send request")
    public void updatePhotoUsingWithEmptyAndSendRequest(String kos_id) {
        koskitaPhotoAPI.setUpdatePhotoEmpty(kos_id);
    }


    @And("Post photo using {string} with {string} {string} {string} {string} {string} and send request")
    public void postPhotoMetode2(String kos_id, String main_kos_photo, String front_kos_photo, String back_kos_photo,
                                 String front_room_photo, String inside_room_photo)throws IOException {
        koskitaPhotoAPI.postPhotoMetode2(kos_id, main_kos_photo, front_kos_photo, back_kos_photo, front_room_photo,
                inside_room_photo);
    }

    @And("Post photo using {string} with {string} and send request")
    public void postPhotoUsingWithAndSendRequest2(String kos_id, String main_kos_photo) throws IOException {
        koskitaPhotoAPI.setPostPhotoOnly1part2(kos_id, main_kos_photo);
    }

    @And("Update photo using {string} with {string} {string} {string} {string} {string} and send request")
    public void putPhotoMetode2(String kos_id, String main_kos_photo, String front_kos_photo, String back_kos_photo,
                                 String front_room_photo, String inside_room_photo)throws IOException {
        koskitaPhotoAPI.putPhotoMetode2(kos_id, main_kos_photo, front_kos_photo, back_kos_photo, front_room_photo,
                inside_room_photo);
    }

    @And("Update photo using {string} with {string} and send request")
    public void putPhotoUsingWithOnlyOne(String kos_id, String main_kos_photo) throws IOException {
        koskitaPhotoAPI.setPutPhotoOnly1part2(kos_id, main_kos_photo);
    }





}
