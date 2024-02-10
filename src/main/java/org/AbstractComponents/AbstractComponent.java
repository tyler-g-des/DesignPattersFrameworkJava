package org.AbstractComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AbstractComponent {

    WebElement sectionElement;
    WebDriver driver;

    public AbstractComponent(WebDriver driver, By element){
        this.driver = driver;
        this.sectionElement = driver.findElement(element);
    }

    protected WebElement findElement(By element){
        return sectionElement.findElement(element);
    }
}
