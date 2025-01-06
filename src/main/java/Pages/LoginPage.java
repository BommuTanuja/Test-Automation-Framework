package Pages;

import Utilities.SeleniumActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    private SeleniumActions seleniumActions;

    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver,this);
        seleniumActions = new SeleniumActions(driver);
    }

    @FindBy(css = "#user-name")
    WebElement userNameInputField;
    @FindBy(css = "[data-test='password']")
    WebElement passwordInputField;
    @FindBy(css = "[value='Login']")
    WebElement submitButton;

    public void login(String username,String password){
        seleniumActions.enterValue(userNameInputField,username);
        seleniumActions.enterValue(passwordInputField,password);
        seleniumActions.clickOnElement(submitButton);
    }
}
