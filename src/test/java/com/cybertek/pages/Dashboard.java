package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Dashboard {

    public Dashboard() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//h2[@id='user_count']")
    public WebElement usersCount;

    @FindBy(id = "book_count")
    public WebElement booksCount;

    @FindBy(xpath = "//h2[@id='borrowed_books']")
    public WebElement borrowedBooksCount;




}
