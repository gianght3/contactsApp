package screenplay.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import screenplay.ui.ContactSourceScreen;
import screenplay.ui.ManageContactScreen;
import screenplay.ui.SearchContactScreen;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ChangeSource implements Task {

    public static Performable AllAccount() {
        return instrumented(ChangeSource.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(SearchContactScreen.SELECT_CONTACT_SOURCE),
                Click.on(SearchContactScreen.SOURCE_ALLACCOUNT)
        );
    }

}
