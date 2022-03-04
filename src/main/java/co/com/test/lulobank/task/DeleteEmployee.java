package co.com.test.lulobank.task;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Delete;

public class DeleteEmployee implements Task {



    @Override
    public <T extends Actor> void performAs(T actor) {
        System.out.println(System.getProperty("urlDeleteSuccessful"));
        actor.attemptsTo(Delete.from(System.getProperty("urlDeleteSuccessful").toString()).with(requestSpecification -> requestSpecification));
        SerenityRest.lastResponse().body().prettyPrint();
        System.out.println(SerenityRest.lastResponse().statusCode());


    }
    public static DeleteEmployee whitInformationDelete(){
        return Tasks.instrumented(DeleteEmployee.class);
    }

}
