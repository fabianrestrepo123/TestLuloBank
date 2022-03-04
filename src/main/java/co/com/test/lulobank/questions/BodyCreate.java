package co.com.test.lulobank.questions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class BodyCreate implements Question<Boolean> {
    @Override
    public Boolean answeredBy(Actor actor) {
        String status = SerenityRest.lastResponse().getBody().jsonPath().getString("status");
        String id = SerenityRest.lastResponse().getBody().jsonPath().getString("data.id");
        if (status.equals("success")){
            return true;
        }else
            return false;
    }

    public static BodyCreate bodyCreateValidation(){
        return new BodyCreate();
    }
}
