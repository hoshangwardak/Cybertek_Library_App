package com.cybertek.pages;

import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {

    public Login() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//label[.='Email address']")
    public WebElement emailAddressInputBox;

    @FindBy(xpath = "//label[.='Password']")
    public WebElement passwordInputBox;

    @FindBy(xpath = "//button[.='Sign in']")
    public WebElement signInButton;

    public void signingInAsLibrarian(String environment,String username, String password) {
        Driver.getDriver().get(ConfigurationReader.getProperty(environment));
        emailAddressInputBox.sendKeys(ConfigurationReader.getProperty(username));
        passwordInputBox.sendKeys(ConfigurationReader.getProperty(password));
        signInButton.click();

    }


}
