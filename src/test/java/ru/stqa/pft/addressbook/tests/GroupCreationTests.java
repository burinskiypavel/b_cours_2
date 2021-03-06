package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.HashSet;
import java.util.List;

public class GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreation() {
        app.goTo().groupPage();
        List<GroupData> before = app.group().list();
        GroupData group = new GroupData().withName("test1");
        app.group().create(group);
        List<GroupData> after = app.group().list();
        Assert.assertEquals(after.size(),before.size() + 1);

        before.add(group);
        int max = 0;
        for(GroupData g : after){
            if(g.getId() > max){
                max = g.getId();
            }
        }
        group.withId(max);
        Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));

    }
}
