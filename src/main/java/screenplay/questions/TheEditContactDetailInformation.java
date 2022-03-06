package screenplay.questions;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import screenplay.ui.ContactDetailScreen;
import screenplay.ui.CreateContactScreen;

public class TheEditContactDetailInformation {
    public static Question<String> FirtName() {
        return actor -> Text.of(CreateContactScreen.FIRST_NAME).viewedBy(actor).asString();
    }

    public static Question<String> LastName() {
        return actor -> Text.of(CreateContactScreen.LAST_NAME).viewedBy(actor).asString();
    }

    public static Question<String> PhoneNumber(){
        return actor->Text.of(CreateContactScreen.PHONE).viewedBy(actor).asString().replaceAll(" ","");
    }

    public static Question<String> Email(){
        return actor->Text.of(CreateContactScreen.EMAIL).viewedBy(actor).asString();
    }

    public static Question<String> Company(){
        return actor->Text.of(CreateContactScreen.COMPANY).viewedBy(actor).asString();
    }

}
