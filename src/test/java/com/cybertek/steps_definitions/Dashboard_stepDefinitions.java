package com.cybertek.steps_definitions;

import com.cybertek.pages.Dashboard;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.cybertek.utilities.DB_Utility.*;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.is;

public class Dashboard_stepDefinitions {
    static Dashboard dash = new Dashboard();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 5);
    static String user_count = dash.getCount("users");
    static String book_count = dash.getCount("books");
    static String borrowed_books = dash.getCount("book_borrow");
    static String userCountUI;
    static String bookCountUI;
    static String borrowedBookCountUI;


    @When("user count should be macthes with DataBase")
    public void user_count_should_be_equals_to() {
        wait.until(ExpectedConditions.visibilityOf(dash.usersCount));
        System.out.println("user_count = " + user_count);
        userCountUI = dash.usersCount.getText();
        assertThat(user_count, is(userCountUI));
        //Assert.assertTrue(user_count.equals(userCountUI));

    }


    @When("books count should be matches with DataBase")
    public void books_count_should_be_equal_to() {
        wait.until(ExpectedConditions.visibilityOf(dash.usersCount));
        bookCountUI = dash.booksCount.getText();
        assertThat(book_count, is(bookCountUI));


    }

    @When("borrowed books number should matches with the DataBase")
    public void borrowed_books_number_should_be_equals_to() {
        wait.until(ExpectedConditions.visibilityOf(dash.usersCount));
        borrowedBookCountUI = dash.borrowedBooksCount.getText();
        assertThat(borrowed_books, is(borrowedBookCountUI));


    }


    @Then("all resulats must macthes with the API result")
    public void allResulatsMustMacthesWithTheAPIResult() {
        String users = dash.getCountApi("users");
        String bookCount = dash.getCountApi("book_count");
        String booksBorrowed = dash.getCountApi("borrowed_books");

        assertThat(users, is(user_count));
        assertThat(users, is(userCountUI));

        assertThat(bookCount, is(book_count));
        assertThat(bookCount, is(bookCountUI));

        assertThat(booksBorrowed, is(borrowed_books));
        assertThat(booksBorrowed, is(borrowedBookCountUI));

        Assert.assertEquals(users,user_count, userCountUI);





    }
}
