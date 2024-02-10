package org.pageObject;

import org.AbstractComponents.SearchFlightAvail;
import org.AbstractComponents.StrategyFactor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.pageComponents.NavigationBar;
import org.pageComponents.NavigationFooter;

import java.util.HashMap;

/**
 * Hello world!
 *
 */
public class TravelHomePage
{
    WebDriver driver;
    By barNav = By.id("buttons");
    By footerNav = By.id("traveller-home");
    SearchFlightAvail searchFlightAvail;


    public TravelHomePage(WebDriver driver) {

        this.driver=driver;

    }

    public void goTo()
    {
        driver.manage().window().maximize();

        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
    }


    public NavigationBar gotGetNavigationBar(){
        return new NavigationBar(driver, barNav);
    }

    public NavigationFooter gotGetNavigationFooter(){
        return new NavigationFooter(driver, footerNav);
    }

    public void setBookingStrategy(String typeStrategy){
        StrategyFactor strategyFactor = new StrategyFactor(driver);
        this.searchFlightAvail = strategyFactor.createStrategy(typeStrategy);
    }

    public void checkAvail(HashMap<String, String> reservationDetails){
        searchFlightAvail.checkAvail(reservationDetails);
        System.out.println("TEST");
    }
}
