package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() {
        app.goTo().gotoHomePage();
        app.getContactHelper().createContact(new ContactData("test_name", "test_surname", "test1"), true);
    }
}
