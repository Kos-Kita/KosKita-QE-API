package starter.koskita;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.Constants;

public class KoskitaKosAPI {

    public static String GET_KOS = Constants.BASE_URL+"/kos/search?address={address}&category={category}&minPrice={minPrice}&maxPrice={maxPrice}";
    public static String GET_SINGLE_KOS = Constants.BASE_URL+"/kos/{kos_id}";
    public static String GET_MY_KOS = Constants.BASE_URL+"/users/kos";

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

}
