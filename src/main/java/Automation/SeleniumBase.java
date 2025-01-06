package Automation;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class SeleniumBase {
    public WebDriver driver;

    public void launchBrowser(String browser){
        switch(browser){
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
        }
    }

    @Parameters({"browserName"})
    @BeforeSuite
    public void setUp(String browser){
        launchBrowser(browser);
    }

    @Parameters("url")
    @BeforeTest
    public void launchApplication(String Url){
        driver.get(Url);
    }
    @AfterSuite
    public void closeSession(){
        driver.quit();
    }
}
