package contacts.steps;

import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;
import screenplay.abilities.CreateContact;
import screenplay.abilities.EditContact;
import screenplay.models.Contact;
import screenplay.questions.*;
import screenplay.tasks.AddNewContact;
import screenplay.tasks.EditAContact;
import screenplay.tasks.OpenCreateContact;
import screenplay.tasks.OpenEditContact;
import screenplay.ui.ContactDetailScreen;
import screenplay.ui.CreateContactScreen;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;
import static org.hamcrest.CoreMatchers.equalTo;

public class EditContactSteps {
    public Actor anna = Actor.named("Anna");

    @Managed(driver = "Appium")
    public WebDriver herBrowser;

    @Before
    public void annaCanBrowseTheWeb() throws Exception {
        anna.can(BrowseTheWeb.with(herBrowser));
        anna.can(EditContact.withData());
    }

    @Given("^The edit contact screen is displayed$")
    public void the_edit_contact_screen_is_displayed() {
        anna.attemptsTo(
                OpenEditContact.at("Device",1)
        );
    }

    @When("^The user attempt to select a contact to edit from the list$")
    public void the_user_attempt_to_select_a_contact_to_edit_from_the_list() {
        anna.attemptsTo(
                OpenEditContact.byName("Device","Tester No 1")
        );
    }

    @When("^The user attempt to edit information of contact then save$")
    public void the_user_attempt_to_edit_information_of_contact_then_save()  {
        anna.attemptsTo(
                EditAContact.thenSave()
        );
    }

    @When("^The user attempt to edit information of contact then cancel$")
    public void the_user_attempt_to_edit_information_of_contact_then_cancel() {
        anna.attemptsTo(
                EditAContact.thenCancel()
        );
    }

    @Then("^The edit contact screen will be showed$")
    public void the_edit_contact_screen_will_be_showed() {
        anna.should(
                seeThat(TheCurrentActivity.Name(),equalTo("com.google.android.apps.contacts.editor.ContactEditorActivity"))
        );
    }

    @Then("^The user should see these updated information on contact detail$")
    public void the_user_should_see_these_updated_information_on_contact_detail(){
        Contact data = anna.abilityTo(EditContact.class).takeAContact();
        anna.should(
                seeThat(TheContactDetailInformation.FullName(), equalTo(data.FirstName + " "+ data.LastName)),
                seeThat(TheContactDetailInformation.PhoneNumber(), equalTo(data.Phone))
//                seeThat(TheContactDetailInformation.Email(), equalTo(data.Email))
        );
    }

    @And("^The action will be displayed for according contact's updated information$")
    public void the_action_will_be_displayed_for_according_contacts_information() {
        Contact data = anna.abilityTo(EditContact.class).takeAContact();
        anna.should(
                seeThat(the(ContactDetailScreen.CALL_ACTION), isVisible()),
                seeThat(the(ContactDetailScreen.TEXT_MESSAGE_ACTION), isVisible()),
                seeThat(the(ContactDetailScreen.VIDEO_ACTION), isVisible())
        );
    }

    @And("^The user should see the information in the edit screen the same the information of the contact$")
    public void the_user_should_see_the_information_in_the_edit_screen_the_same_the_information_of_the_contact(){
        anna.should(
                seeThat(TheContactDetailInformation.PhoneNumber(),equalTo(CreateContactScreen.PHONE.resolveFor(anna).getText()))
        );
    }

}
