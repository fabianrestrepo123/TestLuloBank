package co.com.test.lulobank.task;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Get;

//Cambiar la variable de parametrizacion para los dos escenarios.
public class GetEmployee implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Get.resource(System.getProperty("urlGetEmployeeSuccessful").toString()).with(requestSpecification -> requestSpecification));
        SerenityRest.lastResponse().body().prettyPrint();
        System.out.println(SerenityRest.lastResponse().getStatusCode());


    }

    public static GetEmployee whitInformationGetEmployee(){
        return Tasks.instrumented(GetEmployee.class);
    }
}
