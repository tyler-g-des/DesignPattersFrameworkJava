package org.pageComponents;

import com.sun.org.apache.xpath.internal.operations.Mult;
import org.AbstractComponents.AbstractComponent;
import org.AbstractComponents.SearchFlightAvail;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.function.Consumer;

public class MultiTrip extends AbstractComponent implements SearchFlightAvail {

    private By rdo =By.id("ctl00_mainContent_rbtnl_Trip_2");
    private By btnOk = By.id("MultiCityModelAlert");
    private By from = By.id("ctl00_mainContent_ddl_originStation1_CTXT");
    private By to =By.id("ctl00_mainContent_ddl_destinationStation1_CTXT");
    private By cb =By.id("ctl00_mainContent_chk_IndArm");
    private By search =By.id("ctl00_mainContent_btn_FindFlights");

    public MultiTrip(WebDriver driver, By element) {
        super(driver, element);
    }

    @Override
    public void checkAvail(HashMap<String, String> reservationDetails) {

        makeStateReady(s -> selectOriginCity(reservationDetails.get("origin")));
        selectDestinationCity(reservationDetails.get("destination"));
        findElement(cb).click();
        findElement(search).click();
    }

    public void selectOriginCity(String origin)
    {
        findElement(from).click();
        findElement(By.xpath("//a[@value='"+origin+"']")).click();
    }

    public void selectDestinationCity(String destination)
    {
        findElement(to).click();
        findElement(By.xpath("(//a[@value='"+destination+"'])[2]")).click();
    }

    public void makeStateReady(Consumer<MultiTrip> consumer){
        System.out.println("I am inside multi trip ");
        findElement(rdo).click();
        findElement(btnOk).click();
        consumer.accept(this);
        System.out.println("am done");
    }
}
