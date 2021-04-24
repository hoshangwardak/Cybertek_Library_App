package com.cybertek.utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BrowserUtils {

    public static void sleep(int second) {
        second *= 1000;
        try {
            Thread.sleep(second);
        } catch (InterruptedException e) {
            System.out.println("something happened in sleep method");

        }
    }

    public static String timestamp() {
        return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
    }

    public static void screenShot()  {

        File scr=((TakesScreenshot)Driver.getDriver()).getScreenshotAs(OutputType.FILE);

        File screenShotDestination = new File("C:\\Users\\hosha\\Downloads\\Assignments"+timestamp()+".jpg");
        try {
            FileUtils.copyFile(scr, screenShotDestination);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<String> getElementsText(List<WebElement> list) {
        List<String> elementsText = new ArrayList<>();
        for (WebElement eachElement : list) {
            elementsText.add(eachElement.getText());
        }
        return elementsText;
    }

    public static List<String> getElementsText(By locator) {

        List<WebElement> elements = Driver.getDriver().findElements(locator);
        List<String> elementsText = new ArrayList<>();

        for (WebElement eachElement : elements) {
            elementsText.add(eachElement.getText());
        }
        return elementsText;

    }

}
