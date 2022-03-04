package co.com.test.lulobank.stepdefinitions;

import co.com.test.lulobank.questions.BodyDelete;
import co.com.test.lulobank.questions.TheStatus;
import co.com.test.lulobank.task.DeleteEmployee;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.parsing.Parser;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.hamcrest.core.Is;

public class DeleteTestStepDefinitions {

    @Before
    public void before() {
        SerenityRest.setDefaultParser(Parser.JSON);
        OnStage.setTheStage(new OnlineCast());
    }

    @When("the user is delete successfully")
    public void theUserIsDeleteSuccessfully() {
        OnStage.theActorInTheSpotlight().attemptsTo(DeleteEmployee.whitInformationDelete());
    }

    @When("the user is delete failed")
    public void theUserIsDeleteFailed() {
        OnStage.theActorInTheSpotlight().attemptsTo(DeleteEmployee.whitInformationDelete());
    }

    @Then("He should respond to a {int} status in the delete")
    public void heShouldRespondToAStatusInTheDelete(Integer status) {
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(TheStatus.is(), Is.is(status)));
    }

    @Then("must validate the body in the delete")
    public void mustValidateTheBodyInTheDelete() {
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(BodyDelete.bodyDeleteValidation()));
    }


}
