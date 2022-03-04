package co.com.test.lulobank.questions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import org.junit.Test;

public class TheStatus implements Question <Integer>{

    @Override
    public Integer answeredBy(Actor actor) {
        return SerenityRest.lastResponse().statusCode();
    }
    public static TheStatus is(){
        return new TheStatus();
    }
}
