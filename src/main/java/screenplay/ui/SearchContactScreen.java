package screenplay.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class SearchContactScreen {
    public static final Target SEARCH_INPUT = Target.the("Search input")
            .located(By.id("com.google.android.contacts:id/open_search_view_edit_text"));
    public static final Target SEARCH_BAR = Target.the("Search bar")
            .located(By.id("com.google.android.contacts:id/open_search_bar_text_view"));
    public static final Target SELECT_CONTACT_SOURCE = Target.the("Select account button")
            .located(By.id("com.google.android.contacts:id/selected_account_disc"));
    public static final Target SOURCE_ALLACCOUNT = Target.the("All Account")
            .locatedBy("//*[@text=\"Contacts from all accounts\"]");
    public static final Target NO_RESULTS = Target.the("No Results")
            .located(By.id("android:id/text1"));
}
