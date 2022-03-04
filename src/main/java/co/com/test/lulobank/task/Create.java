package co.com.test.lulobank.task;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Post;


public class Create implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Post.to("/api/v1/create").with(requestSpecification -> requestSpecification));
        SerenityRest.lastResponse().body().prettyPrint();
        System.out.println(SerenityRest.lastResponse().statusCode());

    }

    public static Create whitInformation(){
         return Tasks.instrumented(Create.class);
    }
}
