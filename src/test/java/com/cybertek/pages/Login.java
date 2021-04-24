package com.cybertek.pages;

import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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

    public void getLibrarianUsername(String username) {
        emailAddressInputBox.sendKeys(username);
    }

    public void getLibrarianPassword(String password) {
        passwordInputBox.sendKeys(password);
    }

    public void signIn() {
        signInButton.click();
    }

    public void dashboardIsDisplayed(String expectedWord) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);
        wait.until(ExpectedConditions.urlContains(expectedWord));
        String actualDashboardUrl = Driver.getDriver().getCurrentUrl();
        System.out.println("actualDashboardUrl = " + actualDashboardUrl);
        Assert.assertTrue(actualDashboardUrl.contains(expectedWord));
        Driver.closeDriver();
    }

    public void getStudentUsername(String username) {
        emailAddressInputBox.sendKeys(username);
    }

    public void getStudentPassword(String password) {
        passwordInputBox.sendKeys(password);
    }

    public void booksIsDisplayed(String expectedWord) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);
        wait.until(ExpectedConditions.urlContains(expectedWord));
        String actualBooksUrl = Driver.getDriver().getCurrentUrl();
        System.out.println("actualBooksUrl = " + actualBooksUrl);
        Assert.assertTrue(actualBooksUrl.contains(expectedWord));
        Driver.closeDriver();
    }


}
