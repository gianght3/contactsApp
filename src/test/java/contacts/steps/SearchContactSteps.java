package contacts.steps;

import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;
import org.hamcrest.CoreMatchers;
import org.openqa.selenium.WebDriver;
import screenplay.questions.TheCurrentActivity;
import screenplay.questions.TheListOfContacts;
import screenplay.questions.TheMessage;
import screenplay.tasks.ChangeContactSource;
import screenplay.tasks.ChangeSource;
import screenplay.tasks.SearchContact;
import screenplay.tasks.ViewContactDetail;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;


public class SearchContactSteps {
    public Actor anna = Actor.named("Anna");

    @Managed(driver = "Appium")
    public WebDriver herBrowser;

    @Before
    public void annaCanBrowseTheWeb() {
        anna.can(BrowseTheWeb.with(herBrowser));
    }

    @Then("^The user should see this contact from contact list$")
    public void the_user_should_see_this_contact_from_contact_list() {
        anna.should(
                seeThat(TheListOfContacts.Display(),hasSize(equalTo(3))),
                seeThat(TheListOfContacts.Display(), hasItem("Giang Htg"))
        );

    }

    @And("^The user attempt to search a existed contact$")
    public void the_user_attempt_to_search_a_existed_contact() {
        anna.attemptsTo(SearchContact.Search_Suggest("Giang ht"));
    }

    @Then("^The user should see this message \"([^\"]*)\"$")
    public void the_user_should_see_this_message(String message) {
        anna.should(
                seeThat(TheMessage.Noresult(),equalTo(message))
        );
    }

    @And("^The user attempt to search a existed contact then enter$")
    public void the_user_attempt_to_search_a_existed_contact_then_enter() {
        anna.attemptsTo(SearchContact.Search_Result("Giang ht"));
    }

    @And("^The user attempt to search an inexistent contact then enter$")
    public void the_user_attempt_to_search_an_inexistent_contact_then_enter(){
        anna.attemptsTo(SearchContact.Search_Result("fdfd"));
    }

    @And("^The user attempt to view a contact detail from list of contact searched$")
    public void the_user_attempt_to_view_a_contact_detail_from_list_of_contact_searched() {
        anna.attemptsTo(
                ViewContactDetail.at(1)
        );
    }

}
