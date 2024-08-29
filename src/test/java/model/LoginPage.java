package model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {
    @FindBy(id = "loginEmail")
    private WebElement email;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage inputLogin() {
        getDriver().findElement(By.id("loginEmail")).sendKeys("test@protei.ru");

        return this;
    }

    public LoginPage inputIncorrectLogin() {
        getDriver().findElement(By.id("loginEmail")).sendKeys("test");

        return this;
    }

    public LoginPage inputPassword() {
        getDriver().findElement(By.id("loginPassword")).sendKeys("test");

        return this;
    }

    public LoginPage inputIncorrectPassword() {
        getDriver().findElement(By.id("loginPassword")).sendKeys("");

        return this;
    }

    public ApplicationFormPage clickEntry() {
        getDriver().findElement(By.id("authButton")).click();

        return new ApplicationFormPage(getDriver());
    }

    public LoginPage clickEntryInvalid() {
        getDriver().findElement(By.id("authButton")).click();

        return this;
    }

    public String getError() {

        return getWait5().until(ExpectedConditions.visibilityOfElementLocated(By.id("emailFormatError"))).getText();
    }

    public String getErrorEmailAndPassword() {

        return getWait5().until(ExpectedConditions.visibilityOfElementLocated(By.id("invalidEmailPassword"))).getText();
    }
}
