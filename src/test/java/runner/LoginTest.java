package runner;

import model.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import runner.order.BaseTest;

public class LoginTest extends BaseTest {

    @Test
    public void enterPositiveTest() {
        Boolean formPage = new LoginPage(getDriver())
                .inputLogin()
                .inputPassword()
                .clickEntry()
                .isAddButtonDisplayed();

        Assert.assertTrue(formPage);
    }

    @Test
    public void enterNegativeEmailTest(){
        String errorText = new LoginPage(getDriver())
                .inputIncorrectLogin()
                .clickEntryInvalid()
                .getError();

        Assert.assertEquals(errorText, "Неверный формат E-Mail");
    }

    @Test
    public void enterNegativeEmptyPasswordTest(){
        String errorText = new LoginPage(getDriver())
                .inputLogin()
                .inputIncorrectPassword()
                .clickEntryInvalid()
                .getErrorEmailAndPassword();

        Assert.assertEquals(errorText, "Неверный E-Mail или пароль");
    }
}
