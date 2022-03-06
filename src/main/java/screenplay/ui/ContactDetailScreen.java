package screenplay.ui;


import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ContactDetailScreen {
    public static final Target BTN_EDIT = Target.the("Edit Button")
            .located(By.id("com.google.android.contacts:id/floating_action_button"));

    public static final Target VIDEO_ACTION = Target.the("Call video button")
            .located(By.id("com.google.android.contacts:id/verb_video"));

    public static Target FullName = Target.the("Fullname")
            .located(By.id("com.google.android.contacts:id/large_title"));

    public static Target PhoneNumber = Target.the("Phone number")
            .locatedBy("//*[contains(@content-desc,\"Call Mobile\")]//*[@resource-id=\"com.google.android.contacts:id/header\"]");

    public static Target Email = Target.the("Email address")
            .locatedBy("//*[contains(@content-desc,\"Email\")]//*[@resource-id=\"com.google.android.contacts:id/header\"]");

    public static Target CALL_ACTION = Target.the("Call button")
            .located(By.id("com.google.android.contacts:id/verb_call"));

    public static Target TEXT_MESSAGE_ACTION = Target.the("Send text message button")
            .located(By.id("com.google.android.contacts:id/verb_text"));

    public static Target SEND_EMAIL_ACTION = Target.the("Send Email button")
            .located(By.id("com.google.android.contacts:id/verb_email"));

}
