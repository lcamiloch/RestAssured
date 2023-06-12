package cl.cenco.qa.stepDefinitions;

import cl.cenco.qa.questions.ResponseCodeQuestion;
import cl.cenco.qa.task.CreateUserTask;
import cl.cenco.qa.task.GetUserTask;
import cl.cenco.qa.utils.CommonProperties;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.equalTo;

/**
 * @autor: Camilo Chaparro
 * @version: 1.0.0
 * @since: 1.0.0
 */
public class ConsumeServicesStepDefinition {

    @Given("^the (.*) wants to test the functionalities of the JSONPlaceholder services$")
    public void prerequisiteStepGet(String name) {
        theActorCalled(name)
                .whoCan(CallAnApi.at(CommonProperties.getParameter("baseUrl")));
    }

    @When("he queries for the user with id {int}")
    public void executionStepGet(int id){
        theActorInTheSpotlight().attemptsTo(
                new GetUserTask(
                        CommonProperties.getParameter("complementPath"), id));
    }

    @When("^he creates an user with the data (.*) (.*) (.*)$")
    public void executionStepPost(String tittle, String body, int userId) {
        theActorInTheSpotlight().attemptsTo(CreateUserTask.withInfo(
                tittle, body, userId, CommonProperties.getParameter("complementPath")));
    }

    @Then("he should see the queried user")
    public void validationStep(){
        theActorInTheSpotlight().should(seeThat(
                "Response code", ResponseCodeQuestion.was(), equalTo(
                        Integer.valueOf(CommonProperties.getParameter("expectedStatusGet")))));
    }

    @Then("he should see the user created")
    public void validationStepPost() {
        theActorInTheSpotlight().should(seeThat(
                "Response code", ResponseCodeQuestion.was(), equalTo(
                        Integer.valueOf(CommonProperties.getParameter("expectedStatusPost")))));
    }
}