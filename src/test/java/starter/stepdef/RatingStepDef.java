package starter.stepdef;

import io.cucumber.java.en.Given;
import net.thucydides.core.annotations.Steps;
import starter.koskita.KosKitaRatingAPI;
import starter.utils.Constants;

import java.io.File;

public class RatingStepDef {
    @Steps
    KosKitaRatingAPI kosKitaRatingAPI;

    @Given("Post rating kos with id {string} with {string} and send request")
    public void setPostRating(String kos_id, String json) {
        File jsonRating = new File(Constants.REQ_BODY + json);
        kosKitaRatingAPI.postRating(kos_id,jsonRating);
    }
}
