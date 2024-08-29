package runner.order;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;

public abstract class BaseTest {
    private WebDriver driver;

    @BeforeMethod
    protected void beforeMethod() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*", "--window-size=1920,1080");

        driver = new ChromeDriver(chromeOptions);

        driver.get("file:///Users/romanmorozov/Desktop/qa-test.html");
    }

    @AfterMethod
    protected void afterMethod(Method method, ITestResult testResult) {
        driver.quit();
    }

    protected WebDriver getDriver() {
        return driver;
    }
}
