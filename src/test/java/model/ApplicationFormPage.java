package model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ApplicationFormPage extends BasePage {
   // @FindBy(id = "dataName")
    //private WebElement inputName;

    public ApplicationFormPage(WebDriver driver) {
        super(driver);
    }

    public Boolean isAddButtonDisplayed() {

        return getDriver().findElement(By.id("dataSend")).isDisplayed();
    }

    public ApplicationFormPage clickEmailInput(String email) {

        getDriver().findElement(By.id("dataEmail")).click();
        getDriver().findElement(By.id("dataEmail")).sendKeys(email);

        return this;
    }

    public ApplicationFormPage putEmail(String email) {

        getDriver().findElement(By.id("dataEmail")).sendKeys(email);

        return this;
    }

    public ApplicationFormPage clickNameInput() {
       // inputName.click(); не работает FinBy - причину найти не успела

        getDriver().findElement(By.id("dataName")).click();

        return this;
    }

    public ApplicationFormPage putName(String name) {

        getDriver().findElement(By.id("dataName")).sendKeys(name);

        return this;
    }

    public ApplicationFormPage clickAddData() {

        getDriver().findElement(By.id("dataSend")).click();

        return this;
    }

    public String getErrorMessage() {

       return getDriver().findElement(By.id("emailFormatError")).getText();
    }

    public String getTextSuccessAddData() {

        return getWait5().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='uk-margin uk-modal-content']"))).getText();
    }

    public ApplicationFormPage clickButtonSuccessOK() {

        getDriver().findElement(By.xpath("//button[@class='uk-button uk-button-primary uk-modal-close']")).click();

        return this;
    }

    public String getTextFromAddedSuccessefullLogin() {

       return getDriver().findElement(By.xpath("//td[contains(text(),'test@test.ru')]")).getText();
    }
}
