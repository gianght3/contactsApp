package screenplay.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import screenplay.ui.SearchContactScreen;


public class TheMessage implements Question<String> {
        public static Question<String> Noresult() {
            return new TheMessage();
    }
    @Override
    public String answeredBy(Actor actor) {
        return Text.of(SearchContactScreen.NO_RESULTS).viewedBy(actor).asString();
    }
}
