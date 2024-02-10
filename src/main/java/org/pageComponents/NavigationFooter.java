package org.pageComponents;

import org.AbstractComponents.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationFooter extends AbstractComponent {

    By flights = By.cssSelector("[title='Flights']");

    public NavigationFooter(WebDriver driver,  By sectionElement) {
        super(driver,sectionElement);
    }

    public String getFlightAttribute(){
        return findElement(flights).getAttribute("class");
    }
}
