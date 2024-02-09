package starter.koskita;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.Constants;

public class KoskitaKosAPI {

    public static String CREATE_KOS = Constants.BASE_URL+"/kos";
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
}
