package com.cybertek.pages;

import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {

    public Login() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "inputEmail")
    public WebElement emailAddressInputBox;

    @FindBy(id = "inputPassword")
    public WebElement passwordInputBox;

    @FindBy(xpath = "//button[.='Sign in']")
    public WebElement signInButton;

    public void getEnvironment() {
        Driver.getDriver().get(ConfigurationReader.getProperty("qa2_url"));
    }

    public void loginAsLibrarian() {
        emailAddressInputBox.sendKeys(ConfigurationReader.getProperty("librarianEmail"));
        passwordInputBox.sendKeys(ConfigurationReader.getProperty("librarianPassword"));
        signInButton.click();
    }

    public void dashboardIsDisplayed() {
        String expectedWord = "dashboard";

        BrowserUtils.sleep(3);
        String actualUrl = Driver.getDriver().getCurrentUrl();

        Assert.assertTrue(actualUrl.contains(expectedWord));
        System.out.println(actualUrl);
        BrowserUtils.sleep(2);
        Driver.closeDriver();
    }

    public void loginAsStudent() {
        emailAddressInputBox.sendKeys(ConfigurationReader.getProperty("studentEmail"));
        passwordInputBox.sendKeys(ConfigurationReader.getProperty("studentPassword"));
        signInButton.click();
    }

    public void booksIsDisplayed() {
        String expectedWord = "books";

        BrowserUtils.sleep(3);
        String actualUrl = Driver.getDriver().getCurrentUrl();

        Assert.assertTrue(actualUrl.contains(expectedWord));
        System.out.println(actualUrl);
        BrowserUtils.sleep(2);
        Driver.closeDriver();
    }


}
