package com.cybertek.steps_definitions;

import com.cybertek.pages.Dashboard;
import io.cucumber.java.en.When;

public class Dashboard_StepDefinitions {

    Dashboard dashboard = new Dashboard();

    @When("user count should be equal to {string}")
    public void user_count_should_be_equal_to(String string) {



    }

    @When("books count should be equal to {string}")
    public void books_count_should_be_equal_to(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("borrowed Books count should be equal to {string}")
    public void borrowed_books_count_should_be_equal_to(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

}
