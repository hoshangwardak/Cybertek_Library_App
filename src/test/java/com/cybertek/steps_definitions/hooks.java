package com.cybertek.steps_definitions;


import com.cybertek.utilities.API_Util;
import com.cybertek.utilities.ConfigurationReader;
import static com.cybertek.utilities.DB_Utility.*;

import com.cybertek.utilities.DB_Utility;
import com.cybertek.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;

public class hooks {

    @Before

    public void setUpConnection(){
        String url      = ConfigurationReader.getProperty("library1.database.url") ;
        String username = ConfigurationReader.getProperty("library1.database.username") ;
        String password = ConfigurationReader.getProperty("library1.database.password") ;
        createConnection(url, username, password);
        baseURI  = "http://library1.cybertekschool.com" ;
        basePath = "/rest/v1" ;

    }


    @After
    public void tearDown(){
        destroy();
        Driver.getDriver().close();
    }




}
