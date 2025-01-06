package Pages;

import Utilities.SeleniumActions;
import Utilities.SeleniumWaits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage {

    SeleniumActions seleniumActions;
    SeleniumWaits seleniumWaits;

    public ProductsPage(WebDriver driver){
        PageFactory.initElements(driver,this);
        seleniumActions = new SeleniumActions(driver);
        seleniumWaits = new SeleniumWaits(driver);

    }

    @FindBy(css = ".title")
    WebElement productsPageHeading;

    public String getProductsHeading(){
        seleniumWaits.waitForElementVisible(productsPageHeading);
        return seleniumActions.getTextMessage(productsPageHeading);

    }
}
