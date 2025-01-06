package Automation;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;

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
        driver.manage().window().maximize();

    }

    @Parameters("url")
    @BeforeTest
    public void launchApplication(String Url){
        driver.get(Url);
    }

    @BeforeMethod
    public void takingScreenshot() throws IOException {
        TakesScreenshot takesScreenshot=(TakesScreenshot) driver;
        File sourceFile=takesScreenshot.getScreenshotAs(OutputType.FILE);
        File targetFile=new File(System.getProperty("user.dir")+"\\screenShots\\loginFailed.png");

        FileUtils.copyFile(sourceFile,targetFile);
    }
    @AfterSuite
    public void closeSession(){
        driver.quit();
    }
}
