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
import java.util.HashMap;
import java.util.Map;

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

    @Step("Update photo")
    public void setUpdatePhoto(String kos_id, File main_kos_photo, File front_kos_photo, File back_kos_photo, File front_room_photo, File inside_room_photo) throws IOException {
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
                .put(postPhotoUrl);
    }

    @Step("Update photo with empty")
    public void setUpdatePhotoEmpty(String kos_id) {
        String token = "Bearer " + Constants.getAuthToken();
        Response response = SerenityRest.given()
                .pathParam("kos_id", kos_id)
                .header("Authorization", token)
                .put(POST_PHOTO);
    }

    @Step("Update photo with only 1")
    public void setPutPhotoOnly1(String kos_id, File main_kos_photo) throws IOException {
        String token = "Bearer " + Constants.getAuthToken();
        String updatePhotoUrl = POST_PHOTO.replace("{kos_id}", kos_id);

        Response response = SerenityRest.given()
                .contentType("multipart/form-data")
                .header("Authorization", token)
                .multiPart("main_kos_photo", main_kos_photo.getName(), new FileInputStream(main_kos_photo))
                .put(updatePhotoUrl);
    }

    @Step("Post photo 2")
    public void postPhotoMetode2(String kos_id, String main_kos_photo, String front_kos_photo, String back_kos_photo,
                                 String front_room_photo, String inside_room_photo) {
        Map<String, Object> formData = validData(main_kos_photo, front_kos_photo, back_kos_photo, front_room_photo,
                inside_room_photo);
        postPhoto2(kos_id, formData);
    }

    private Map<String, Object> validData(String main_kos_photo, String front_kos_photo, String back_kos_photo,
                                          String front_room_photo, String inside_room_photo) {
        Map<String, Object> formData = new HashMap<>();
        File fileMainKosPhoto = new File(Constants.PHOTO_DIR, main_kos_photo);
        File fileFrontKosPhoto = new File(Constants.PHOTO_DIR, front_kos_photo);
        File fileBackKosPhoto = new File(Constants.PHOTO_DIR, back_kos_photo);
        File fileFrontRoomPhoto = new File(Constants.PHOTO_DIR, front_room_photo);
        File fileInsideRoomPhoto = new File(Constants.PHOTO_DIR, inside_room_photo);

        formData.put("main_kos_photo", fileMainKosPhoto);
        formData.put("front_kos_photo", fileFrontKosPhoto);
        formData.put("back_kos_photo", fileBackKosPhoto);
        formData.put("front_room_photo", fileFrontRoomPhoto);
        formData.put("inside_room_photo", fileInsideRoomPhoto);

        return formData;
    }

    private void postPhoto2(String kos_id, Map<String, ?> formData) {
        String token = "Bearer " + Constants.getAuthToken();
        String postPhotoUrl = POST_PHOTO.replace("{kos_id}", kos_id);

        Response response = SerenityRest.given().header("Authorization", token).contentType("multipart/form-data")
                .multiPart("main_kos_photo", (File) formData.get("main_kos_photo"))
                .multiPart("front_kos_photo", (File) formData.get("front_kos_photo"))
                .multiPart("back_kos_photo", (File) formData.get("back_kos_photo"))
                .multiPart("front_room_photo", (File) formData.get("front_room_photo"))
                .multiPart("inside_room_photo", (File) formData.get("inside_room_photo"))
                .post(postPhotoUrl);

        // Add logging or other handling here as needed.
    }


}