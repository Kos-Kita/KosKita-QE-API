package starter.koskita;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.Constants;

import java.io.File;

public class KoskitaKosAPI {

    public static String GET_KOS = Constants.BASE_URL+"/kos/search?address={address}&category={category}&minPrice={minPrice}&maxPrice={maxPrice}";
    public static String GET_REC_KOS = Constants.BASE_URL+"/kos";
    public static String GET_SINGLE_KOS = Constants.BASE_URL+"/kos/{kos_id}";
    public static String GET_MY_KOS = Constants.BASE_URL+"/users/kos";

    public static String POST_KOST = Constants.BASE_URL+"/kos";
    @Step("Get my kos")
    public void setGetMyKos(){
        SerenityRest.given();
    }

    @Step("Get single kos")
    public void setGetSingleKos(String kos_id){
        SerenityRest.given().pathParam("kos_id", kos_id);
    }

    @Step("Get kos")
    public void setGetKos(String address, String category, String minPrice, String maxPrice){

        SerenityRest.given()
                .pathParam("address", address)
                .pathParam("category", category)
                .pathParam("minPrice", minPrice)
                .pathParam("maxPrice", maxPrice);
    }
    @Step("Post create new kos")
    public Response postCreateKos(File json) {
        String token = "Bearer " + Constants.getAuthToken();
        return SerenityRest.given()
                .contentType(ContentType.JSON)
                .header("Authorization", token)
                .body(json)
                .post(POST_KOST); // Ganti dengan endpoint yang sesuai
    }

    @Step("update kos")
    public void updateKos(String kos_id, File json) {
        String token = "Bearer " + Constants.getAuthToken();
        SerenityRest.given()
                .pathParam("kos_id", kos_id)
                .contentType(ContentType.JSON)
                .header("Authorization", token)
                .body(json)
                .put(GET_SINGLE_KOS);
    }
    @Step("Delete product")
    public void setDeleteKos(String kos_id) {
        String token = "Bearer " + Constants.getAuthToken();
        SerenityRest.given().header("Authorization", token)
                .pathParam("kos_id", kos_id);
    }



}
