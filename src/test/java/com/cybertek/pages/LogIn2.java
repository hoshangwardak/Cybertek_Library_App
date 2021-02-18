package com.cybertek.pages;

import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LogIn2 {
    public LogIn2() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//input[@id='inputEmail']")
    public WebElement emailAddressInputBox;

    @FindBy(xpath = "//input[@id='inputPassword']")
    public WebElement passwordInputBox;

    @FindBy(xpath = "//button[.='Sign in']")
    public WebElement signInButton;

    public void logInPage (){
        Driver.getDriver().get(ConfigurationReader.getProperty("qa2_url"));

    }

    public void librarianLogIn() {
        emailAddressInputBox.sendKeys(ConfigurationReader.getProperty("librarianEmail"));
        passwordInputBox.sendKeys(ConfigurationReader.getProperty("librarianPassword"));
        signInButton.click();

    }

    public void dashboardDisplayed(){
        String expected = "dashboard";

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);
        wait.until(ExpectedConditions.urlContains(expected));

        String actual = Driver.getDriver().getCurrentUrl();

        Assert.assertTrue(actual.contains(expected));

        BrowserUtils.sleep(3);
        Driver.closeDriver();

    }

public void studentLogIn(){
    emailAddressInputBox.sendKeys(ConfigurationReader.getProperty("studentEmail"));
    passwordInputBox.sendKeys(ConfigurationReader.getProperty("studentPassword"));
    signInButton.click();

}


public void booksDisplayed(){
    String expected = "books";

    WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);
    wait.until(ExpectedConditions.urlContains(expected));

    String actual = Driver.getDriver().getCurrentUrl();

    Assert.assertTrue(actual.contains(expected));

}







}
