import com.codeborne.selenide.Configuration;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Configuration.browser;

/**
 * Created by dmalivanov on 11/26/18.
 */
public class SingUpTest {

    private SingUpPage page;

    @BeforeClass
    public void setUp(){
       baseUrl = "https://test.kyclient.net/credentials/sign-up";
    }

    @Test
    public void testLoginEmptyError(){
        page = new SingUpPage();
        page.clickLoginField()
                .clickCompanyNameField();

        Assert.assertTrue(page.isErrorVisible("Fill in login"));
    }

    @Test
    public void testSubmitButtonNonClicable(){
        page = new SingUpPage();

        Assert.assertFalse("Button clicable!!!", page.isSubmitButtonEnable());
    }

/*    @Test
    public void testSubmitButtonClicable(){
        page = new SingUpPage(driver);
        page.setAgreeCheckBox();

        Assert.assertTrue("Button non clicable =)", page.isSubmitButtonEnable());
    }*/


    //test nothing
    @Test
    public void testChooseActivityType(){
        page = new SingUpPage();
        page.setActivityType("BANK");
    }
}
