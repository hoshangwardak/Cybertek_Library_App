package com.cybertek.steps_definitions;

import com.cybertek.pages.Login;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class librarian_stepsDefinitions {

    Login login = new Login();

    // Logging in as a librarian
    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
        login.getEnvironment();
    }

    @When("user login as a librarian")
    public void user_login_as_a_librarian() {
        login.loginAsLibrarian();
    }

    @Then("user should see the dashboard in the url")
    public void userShouldSeeTheDashboardInTheUrl() {
        login.dashboardIsDisplayed("dashboard");
    }

    @Then("user should see the word {string} in the url")
    public void userShouldSeeTheWordInTheUrl(String arg0) {
        login.dashboardIsDisplayed(arg0);
    }

    // Logging in as a librarian
    @When("user login as a student")
    public void user_login_as_a_student() {
        login.loginAsStudent();
    }

    @Then("user should see the books in the url")
    public void userShouldSeeTheBooksInTheUrl() {
        login.booksIsDisplayed("books");
    }

    @Then("user should see the {string} in the url")
    public void userShouldSeeTheInTheUrl(String arg0) {
        login.booksIsDisplayed(arg0);
    }
}
