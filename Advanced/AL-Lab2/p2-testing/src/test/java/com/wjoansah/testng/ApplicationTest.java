package com.wjoansah.testng;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ApplicationTest {

    @Test
    public void getUserByEmail_Returns_User() {
        Application app = new Application();

        User user = app.getUserByEmail("user1@email.com");

        Assert.assertNotNull(user);
        Assert.assertEquals("user1", user.getName());
    }
}