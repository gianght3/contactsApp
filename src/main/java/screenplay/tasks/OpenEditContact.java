package screenplay.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.conditions.Check;
import net.thucydides.core.annotations.Step;
import screenplay.ui.ContactDetailScreen;
import screenplay.ui.ContactSourceScreen;
import screenplay.ui.ManageContactScreen;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class OpenEditContact implements Task {
    enum ViewType {NAME, INDEX};
    int index;
    String name;
    ViewType type;
    private String source;
    public OpenEditContact(String source,ViewType type, int index, String name) {
        this.source=source;
        this.type = type;
        this.name = name;
        this.index = index;
    }
    public static Performable at(String source,int index) {
        return instrumented(OpenEditContact.class,source,ViewType.INDEX,index,"");
    }
    public static Performable byName(String source,String name) {
        return instrumented(OpenEditContact.class,source,ViewType.NAME,-1,name);
    }

    @Override
    @Step("{0} selects the contact at #{index} or by name #{name} to edit")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(ManageContactScreen.SELECT_CONTACT_SOURCE),
                Click.on(ContactSourceScreen.SOURCE_NAME.of(this.source)),
                Check.whether(this.type ==ViewType.INDEX).andIfSo(
                        Click.on(ManageContactScreen.CONTACT_AT.of(String.valueOf(this.index)))
                ).otherwise(
                        Click.on(ManageContactScreen.CONTACT_NAME.of(this.name))
                ),
                Click.on(ContactDetailScreen.BTN_EDIT)
        );
    }
}
