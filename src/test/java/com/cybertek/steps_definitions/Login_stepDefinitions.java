package com.cybertek.steps_definitions;

import com.cybertek.pages.LandingPage;
import com.cybertek.pages.Login;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Login_stepDefinitions {

    Login login = new Login();
    LandingPage landingPage = new LandingPage();

    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("qa2url"));
    }

    @When("I login as a librarian")
    public void i_login_as_a_librarian() {
        login.getLibrarianUsername(ConfigurationReader.getProperty("librarianEmail"));
        login.getLibrarianPassword(ConfigurationReader.getProperty("librarianPassword"));
        login.signIn();
    }

    @Then("dashboard should be displayed")
    public void dashboard_should_be_displayed() {
        login.dashboardIsDisplayed("dashboard");
    }

    @When("I login as a student")
    public void iLoginAsAStudent() {
        login.getStudentUsername(ConfigurationReader.getProperty("studentEmail"));
        login.getStudentPassword(ConfigurationReader.getProperty("studentPassword"));
        login.signIn();
    }

    @Then("books should be displayed")
    public void booksShouldBeDisplayed() {
        login.booksIsDisplayed("books");
    }

    @When("I enter username {string}")
    public void i_enter_username(String username) {
        login.getLibrarianUsername(username);
    }

    @When("I enter password {string}")
    public void i_enter_password(String password) {
        login.getLibrarianPassword(password);
    }

    @When("click the sign in button")
    public void click_the_sign_in_button() {
        login.signIn();
    }

    @Then("there should be {int} users")
    public void there_should_be_users(Integer numberOfUsers) {
        landingPage.numberOfUsers(numberOfUsers);
    }

    @When("I login using {string} and {string}")
    public void i_login_using_and(String username, String password) {
       login.getLibrarianUsername(username);
       login.getLibrarianPassword(password);
       login.signIn();
    }

    @When("there should be {int} {string}")
    public void there_should_be(Integer numberOfUsers, String theUsers) {
        landingPage.numberOfUsers(numberOfUsers,theUsers);
    }

    @When("I click on {string} link")
    public void i_click_on_link(String users) {
        landingPage.getEnvironment();
        landingPage.getUsersLink();
    }

    @Then("show records default value should be {int}")
    public void show_records_default_value_should_be(Integer defaultValue) {
        landingPage.getDefaultValue(defaultValue);
    }

    @Then("show records should have following options:")
    public void show_records_should_have_following_options(List<String> options) {

        Select select = new Select(landingPage.showRecords);
        List<WebElement> webElements = select.getOptions();
        List<String> actualTexts = BrowserUtils.getElementsText(webElements);
        Assert.assertEquals("Failed, Assertion failed on options",options,actualTexts);
        System.out.println(actualTexts);
        System.out.println(options);
    }





    @Then("table should have following column names:")
    public void table_should_have_following_column_names(List<String> expectedColumns) {

        List<String> actualColumns = BrowserUtils.getElementsText(landingPage.tablesColumns);
        Assert.assertEquals(actualColumns,expectedColumns);

    }



}
