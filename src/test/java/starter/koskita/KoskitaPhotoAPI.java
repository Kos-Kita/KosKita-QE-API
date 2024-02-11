package starter.koskita;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import okhttp3.RequestBody;
import starter.utils.Constants;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import static io.restassured.RestAssured.post;

public class KoskitaPhotoAPI {


    public static String POST_PHOTO = Constants.BASE_URL + "/upload-image/{kos_id}";

    @Step("Post photo")
    public void setPostPhoto(String kos_id, File main_kos_photo, File front_kos_photo, File back_kos_photo, File front_room_photo, File inside_room_photo) throws IOException {
        String token = "Bearer " + Constants.getAuthToken();
        String postPhotoUrl = POST_PHOTO.replace("{kos_id}", kos_id);

        Response response = SerenityRest.given()
                .contentType("multipart/form-data")
                .header("Authorization", token)
                .multiPart("main_kos_photo", main_kos_photo.getName(), new FileInputStream(main_kos_photo))
                .multiPart("front_kos_photo", front_kos_photo.getName(), new FileInputStream(front_kos_photo))
                .multiPart("back_kos_photo", back_kos_photo.getName(), new FileInputStream(back_kos_photo))
                .multiPart("front_room_photo", front_room_photo.getName(), new FileInputStream(front_room_photo))
                .multiPart("inside_room_photo", inside_room_photo.getName(), new FileInputStream(inside_room_photo))
                .post(postPhotoUrl);

    }
    @Step("Post photo with empty")
    public void setPostPhotoEmpty(String kos_id) {
        String token = "Bearer " + Constants.getAuthToken();
        Response response = SerenityRest.given()
                .pathParam("kos_id", kos_id)
                .header("Authorization", token)
                .post(POST_PHOTO);
    }
    @Step("Post photo with only 1")
    public void setPostPhotoOnly1(String kos_id, File main_kos_photo) throws IOException {
        String token = "Bearer " + Constants.getAuthToken();
        String postPhotoUrl = POST_PHOTO.replace("{kos_id}", kos_id);

        Response response = SerenityRest.given()
                .contentType("multipart/form-data")
                .header("Authorization", token)
                .multiPart("main_kos_photo", main_kos_photo.getName(), new FileInputStream(main_kos_photo))
                .post(postPhotoUrl);
    }



}