package screenplay.abilities;

import com.google.gson.Gson;
import net.serenitybdd.screenplay.Ability;
import screenplay.models.Contact;

import java.io.IOException;
import java.io.Reader;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class EditContact extends Contact implements Ability{
    private List<Contact> Contacts;
    private Contact ContactInUsed;

    public static EditContact withData() throws Exception {
        return new EditContact();
    }

    public EditContact() throws Exception {
        Gson gson = new Gson();

        try {
            ClassLoader classLoader = getClass().getClassLoader();

//          String dataPath  = Objects.requireNonNull(classLoader.getResource("data//createcontact.json")).getPath();
            URI uri = Objects.requireNonNull(classLoader.getResource("data//createcontact.json")).toURI();
            String dataPath = Paths.get(uri).toString();
            Reader reader = Files.newBufferedReader(Paths.get(dataPath));
            this.Contacts = Arrays.asList(gson.fromJson(reader, Contact[].class));

            if(this.Contacts.size()==0)
            {
                throw new Exception("Don't have any contact information used to edit");
            }
            else
            {
                this.ContactInUsed = this.Contacts.get(1);
            }

        } catch (IOException e) {
            throw new Exception(e);
        }
    }

    public Contact takeAContact()
    {
        if(this.Contacts.size()>0)
        {
            this.ContactInUsed = this.Contacts.get(1);
            return this.ContactInUsed;
        }
        else
        {
            return null;
        }
    }
}
