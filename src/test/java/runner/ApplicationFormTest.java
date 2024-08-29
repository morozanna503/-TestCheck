package runner;

import model.ApplicationFormPage;
import model.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import runner.order.BaseTest;

public class ApplicationFormTest extends BaseTest {

    public ApplicationFormPage logIN() {
        ApplicationFormPage putEmail = new LoginPage(getDriver())
                .inputLogin()
                .inputPassword()
                .clickEntry();

        return new ApplicationFormPage(getDriver());
    }

    @Test
    public void addEmailAndName() {
        logIN();

        String putAndAddData = new ApplicationFormPage(getDriver())
                .clickEmailInput("test@test.ru")
                .clickNameInput()
                .putName("All")
                .clickAddData()
                .getTextSuccessAddData();

          Assert.assertEquals(putAndAddData, "Данные добавлены.");
    }

    @Test
    public void getErrorMessage() {
        logIN();

        String errorText = new ApplicationFormPage(getDriver())
                .clickAddData()
                .getErrorMessage();

        Assert.assertEquals(errorText, "Неверный формат E-Mail");
    }
}
