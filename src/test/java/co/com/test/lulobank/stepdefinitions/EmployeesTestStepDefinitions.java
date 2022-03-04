package co.com.test.lulobank.stepdefinitions;

import co.com.test.lulobank.questions.Bodyemployee;
import co.com.test.lulobank.questions.TheStatus;
import co.com.test.lulobank.task.GetEmployees;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.parsing.Parser;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.hamcrest.core.Is;

public class EmployeesTestStepDefinitions {

    @Before
    public void before() {
        SerenityRest.setDefaultParser(Parser.JSON);
        OnStage.setTheStage(new OnlineCast());
    }

    @When("Get employees information")
    public void getEmployeesInformation() {
        OnStage.theActorInTheSpotlight().attemptsTo(GetEmployees.withInformationEmployees());
    }

    @Then("He should respond to status {int} in the employees")
    public void heShouldRespondToStatusInTheEmployees(Integer status) {
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(TheStatus.is(), Is.is(status)));
    }

}




