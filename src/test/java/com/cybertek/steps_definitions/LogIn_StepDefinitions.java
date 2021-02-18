package com.cybertek.steps_definitions;

import com.cybertek.pages.LogIn2;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LogIn_StepDefinitions {

    LogIn2 loggingIn = new LogIn2();

    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
        loggingIn.logInPage();

    }


    @When("I login as a librarian")
    public void i_login_as_a_librarian() {
        loggingIn.librarianLogIn();

    }


    @Then("dashboard should be displayed")
    public void dashboardShouldBeDisplayed() {
        loggingIn.dashboardDisplayed();
    }



    @When("I login as a student")
    public void iLoginAsAStudent() {
        loggingIn.studentLogIn();

    }

    @Then("books should be displayed")
    public void booksShouldBeDisplayed() {
        loggingIn.booksDisplayed();
    }
}
