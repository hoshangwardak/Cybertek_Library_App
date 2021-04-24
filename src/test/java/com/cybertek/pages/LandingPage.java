package com.cybertek.pages;

import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class LandingPage {

    Login login = new Login();

    public LandingPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//h2[@id='user_count']")
    public WebElement usersCount;

    @FindBy(xpath = "(//a[@class='nav-link'])[2]")
    public WebElement usersLink;

    @FindBy(xpath = "(//select)[3]")
    public WebElement showRecords;

    @FindBy(xpath = "//th")
    public List<WebElement> tablesColumns;

    public void numberOfUsers(int expectedUsers) {
        int numberOfUsers = expectedUsers;
        String expectedCount = String.valueOf(numberOfUsers);
        BrowserUtils.sleep(1);
        String actualCount = usersCount.getText();
        System.out.println("expectedCount = " + expectedCount);
        System.out.println("actualCount = " + actualCount);
        Assert.assertTrue(actualCount.contains(expectedCount));

    }

    public void numberOfUsers(int numberOfUsers, String theUsers) {
        int usersNumber = numberOfUsers;
        String expectedCount = String.valueOf(usersNumber);
        BrowserUtils.sleep(1);
        String actualCount = usersCount.getText();
        System.out.println("expectedCount = " + expectedCount);
        System.out.println("actualCount = " + actualCount);
        Assert.assertTrue(actualCount.contains(expectedCount));

    }

    public void getEnvironment() {
        Driver.getDriver().get(ConfigurationReader.getProperty("qa1url"));
        login.getLibrarianUsername(ConfigurationReader.getProperty("librarianEmail1"));
        login.getLibrarianPassword(ConfigurationReader.getProperty("librarianPassword1"));
        login.signIn();
    }

    public void getUsersLink() {
        usersLink.click();
    }

    public void getDefaultValue(int defaultValue) {
        Select select = new Select(showRecords);
        Assert.assertTrue("Failed, parsing not successful",Integer.parseInt(select.getFirstSelectedOption().getText()) == defaultValue);
    }


}

