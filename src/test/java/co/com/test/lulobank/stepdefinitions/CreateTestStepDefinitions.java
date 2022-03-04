package co.com.test.lulobank.stepdefinitions;

import co.com.test.lulobank.questions.BodyCreate;
import co.com.test.lulobank.questions.TheStatus;
import co.com.test.lulobank.task.Create;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en_old.Ac;
import io.restassured.parsing.Parser;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.Actor;
import org.hamcrest.core.Is;


public class CreateTestStepDefinitions {

    @Before
    public void before() {
        SerenityRest.setDefaultParser(Parser.JSON);
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("{actor} gets api")
    public void theUserGetsApi(Actor actor) {
        actor.whoCan(CallAnApi.at("http://dummy.restapiexample.com"));
    }


    @When("the user is created successfully")
    public void theUserIsCreatedSuccessfully() {
        OnStage.theActorInTheSpotlight().attemptsTo(Create.whitInformation());
    }


    @Then("He should respond to a {int} status create")
    public void heShouldRespondToAStatusCreate(Integer status) {
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(TheStatus.is(), Is.is(status)));
    }

    @Then("must validate the body in the create")
    public void mustValidateTheBodyInTheCreate() {
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(BodyCreate.bodyCreateValidation()
        ));
    }








}
