package runner;

import model.ApplicationFormPage;
import model.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import runner.order.BaseTest;

public class E2ETest extends BaseTest {

    public ApplicationFormPage logIN() {
        ApplicationFormPage putEmail = new LoginPage(getDriver())
                .inputLogin()
                .inputPassword()
                .clickEntry();

        return new ApplicationFormPage(getDriver());
    }

    @Test
    public void e2eTest() {
        logIN();
        String login = "test@test.ru";

        String eTwoE = new ApplicationFormPage(getDriver())
                .clickEmailInput(login)
                .clickNameInput()
                .putName("All")
                .clickAddData()
                .clickButtonSuccessOK()
                .getTextFromAddedSuccessefullLogin();

        Assert.assertEquals(eTwoE, login);
    }
}
