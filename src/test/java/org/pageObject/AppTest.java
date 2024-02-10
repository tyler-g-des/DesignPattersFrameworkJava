package org.pageObject;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.pageComponents.MultiTrip;
import org.pageComponents.RoundTrip;
import org.pageObject.DataReader.DataReader;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    TravelHomePage travelHomePage;
    WebDriver driver;

    @BeforeTest
    public void setup(){
        //System.setProperty("webdriver.chrome.driver","//Users//tdiaz//Desktop//chromedriver");
        driver = new SafariDriver();
        travelHomePage = new TravelHomePage(driver);
    }

    //@Test(dataProvider = "getData")
    public void demo(HashMap<String, String> reservationDetails){

        travelHomePage.goTo();
        /*
        System.out.println(travelHomePage.gotGetNavigationBar().getFlightAttribute());
        System.out.println(travelHomePage.gotGetNavigationFooter().getFlightAttribute());
         */
        travelHomePage.setBookingStrategy("MultiTrip");
        travelHomePage.checkAvail(reservationDetails);
    }

    @AfterTest
    public void close(){
        driver.quit();
    }

    @DataProvider
    public Object [][] getData() throws IOException {
        ArrayList<HashMap<String,String>> l = DataReader.getData(System.getProperty("user.dir")+"//src//test//java//org//pageObject//DataReader//addPlace.json");

        return  new Object[][]
                {
                        {l.get(0)}, {l.get(1)}
                };
    }

/*
    @DataProvider
    public Object [][] getData(){
        HashMap<String, String> reservationDetails = new HashMap<String,String>();
        reservationDetails.put("origin","MAA");
        reservationDetails.put("destination","HYD");
        reservationDetails.put("destination","DEL");

        HashMap<String, String> reservationDetails1 = new HashMap<String,String>();
        reservationDetails1.put("origin","MAA");
        reservationDetails1.put("destination","HYD");
        reservationDetails1.put("destination","DEL");

        List<HashMap<String,String>> l = new ArrayList();

        return  new Object[][]
                {
                        {l.get(0)}, {l.get(1)}
                };
    } */

}
