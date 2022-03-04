package co.com.test.lulobank.questions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class BodyDelete  implements Question<Boolean> {
    @Override
    public Boolean answeredBy(Actor actor) {
        String data = SerenityRest.lastResponse().getBody().jsonPath().getString("data");
        String status = SerenityRest.lastResponse().getBody().jsonPath().getString("status");

        if (data.equals("1") && status.equals("success")){
            return true;
        }else
            return false;
    }

    public static  BodyDelete bodyDeleteValidation(){
        return new BodyDelete();
    }
}
