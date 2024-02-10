package org.AbstractComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.pageComponents.MultiTrip;
import org.pageComponents.RoundTrip;

public class StrategyFactor {

    WebDriver driver;
    By sectionElement = By.id("flightSearchContainer");

    public StrategyFactor(WebDriver driver){
        this.driver = driver;
    }

    public SearchFlightAvail createStrategy(String strategyType){

        if(strategyType.equalsIgnoreCase("MultiTrip")){
            return new MultiTrip(driver,sectionElement);
        }
        if(strategyType.equalsIgnoreCase("MultiTrip")){
            return new RoundTrip(driver,sectionElement);
        }

        return null;
    }
}
