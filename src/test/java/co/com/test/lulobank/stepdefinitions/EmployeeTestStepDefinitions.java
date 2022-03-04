package co.com.test.lulobank.stepdefinitions;

import co.com.test.lulobank.questions.Bodyemployee;
import co.com.test.lulobank.questions.TheStatus;

import co.com.test.lulobank.task.GetEmployee;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.parsing.Parser;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.hamcrest.core.Is;

public class EmployeeTestStepDefinitions {

    @Before
    public void before() {
        SerenityRest.setDefaultParser(Parser.JSON);
        OnStage.setTheStage(new OnlineCast());
    }

    @When("Get employee information")
    public void getEmployeeInformation() {
        OnStage.theActorInTheSpotlight().attemptsTo(GetEmployee.whitInformationGetEmployee());
    }

    @When("Get employee information successfull")
    public void getEmployeeInformationSuccessfull() {
        OnStage.theActorInTheSpotlight().attemptsTo(GetEmployee.whitInformationGetEmployee());

    }

    @Then("He should respond to a status {int}")
    public void heShouldRespondToAStatus(Integer status) {
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(TheStatus.is(), Is.is(status)));
    }

    @Then("he should body validation")
    public void heShouldBodyValidation() {
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(Bodyemployee.bodyValidation()));
    }

}
