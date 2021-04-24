package com.cybertek.pages;

import com.cybertek.utilities.API_Util;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.cybertek.utilities.DB_Utility.*;
import static io.restassured.RestAssured.given;

public class Dashboard {

    public Dashboard() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//h2[@id='user_count']")
    public WebElement usersCount;

    @FindBy(xpath = "//h2[@id='book_count']")
    public WebElement booksCount;

    @FindBy(xpath = "//h2[@id='borrowed_books']")
    public WebElement borrowedBooksCount;

    public String getCount(String tableName){

        if (tableName.equals("users")|| tableName.equals("books")){
            runQuery("select count(*) from "+tableName);
        }else
            runQuery("SELECT COUNT(*) FROM book_borrow WHERE returned_date IS  NULL");

        return   getFirstRowFirstColumn();

    }

    String librarianToken = API_Util.getToken("student135@library", "bNHbXc6f");

    public String getCountApi(String key){

       return
                given()
                .header("x-library-token",librarianToken)
                .when()
                .get("/dashboard_stats")
                .path(key)

                ;




    }


}
