package co.com.test.lulobank.task;


import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Get;


public class GetEmployees implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Get.resource("/api/v1/employees").with(requestSpecification -> requestSpecification));
        SerenityRest.lastResponse().body().prettyPrint();
        System.out.println(SerenityRest.lastResponse().getStatusCode()
        );


    }

    public static GetEmployees withInformationEmployees(){
        return Tasks.instrumented(GetEmployees.class);
    }
}
