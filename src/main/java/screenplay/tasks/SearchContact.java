package screenplay.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.conditions.Check;
import org.openqa.selenium.Keys;
import screenplay.ui.CreateContactScreen;
import screenplay.ui.ManageContactScreen;
import screenplay.ui.SearchContactScreen;

import javax.xml.crypto.KeySelector;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SearchContact implements Task {
    private String key;
    private Boolean isEnter;
    public SearchContact (String keySearch,Boolean isEnter)
    {
        this.key=keySearch;
        this.isEnter= isEnter;
    }

    public static Performable Search_Suggest(String keySearch) {
        return instrumented(SearchContact.class,keySearch,false);
    }
    public static Performable Search_Result(String keySearch) {
        return instrumented(SearchContact.class,keySearch,true);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(SearchContactScreen.SEARCH_BAR),
                Check.whether(this.isEnter)
                        .andIfSo(Enter.theValue(this.key).into(SearchContactScreen.SEARCH_INPUT)
                                .thenHit(Keys.ENTER))
                        .otherwise(Enter.theValue(this.key).into(SearchContactScreen.SEARCH_INPUT))
        );

    }
}
