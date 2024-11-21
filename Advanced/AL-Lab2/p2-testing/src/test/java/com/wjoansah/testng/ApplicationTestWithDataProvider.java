package com.wjoansah.testng;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ApplicationTestWithDataProvider {

    @DataProvider(name = "getEmailToTest")
    public Object[][] getEmailToTest() {
        return new Object[][]{{"user1@email.com"}, {"user2@email.com"}};
    }

    @Test(dataProvider = "getEmailToTest")
    public void getUserByEmail_Returns_User(String email) {
        Application app = new Application();

        User user = app.getUserByEmail(email);

        Assert.assertNotNull(user);
        Assert.assertEquals(email, user.getEmail());
    }
}
