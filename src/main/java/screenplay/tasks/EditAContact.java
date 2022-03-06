package screenplay.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.conditions.Check;
import screenplay.abilities.EditContact;
import screenplay.actions.Tap;
import screenplay.models.Contact;
import screenplay.ui.CreateContactScreen;

import static net.serenitybdd.screenplay.Tasks.instrumented;


public class EditAContact implements Task {
    private boolean isSave;
    public EditAContact(boolean isSave)
    {
        this.isSave = isSave;
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        Contact contactData = actor.abilityTo(EditContact.class).takeAContact();
                actor.attemptsTo(
                Enter.theValue(contactData.FirstName).into(CreateContactScreen.FIRST_NAME),
                Enter.theValue(contactData.LastName).into(CreateContactScreen.LAST_NAME),
                Enter.theValue(contactData.Company).into(CreateContactScreen.COMPANY),
                Enter.theValue(contactData.Phone).into(CreateContactScreen.PHONE),
//                Tap.on(CreateContactScreen.CONTAINER).inSecond(2).thenSwipeUp().release(),
//                Enter.theValue(contactData.Email).into(CreateContactScreen.EMAIL),

                Check.whether(this.isSave).andIfSo(Click.on(CreateContactScreen.SAVE_CONTACT))
                        .otherwise(Click.on(CreateContactScreen.CANCEL))
        );
    }

    public static Performable thenSave()
    {
        return instrumented(EditAContact.class, true);
    }

    public static Performable thenCancel()
    {
        return instrumented(EditAContact.class, false);
    }
}
