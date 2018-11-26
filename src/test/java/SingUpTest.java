import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by dmalivanov on 11/26/18.
 */
public class SingUpTest {

    WebDriver driver;
    SingUpPage page;

    @Before
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://test.kyclient.net/credentials/sign-up");
    }

    @Test
    public void testLoginEmptyError(){
        page = new SingUpPage(driver);
        page.clickLoginField()
                .clickCompanyNameField();

        Assert.assertTrue(page.isErrorVisible("Fill in login"));
    }

    @Test
    public void testSubmitButtonNonClicable(){
        page = new SingUpPage(driver);

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
        page = new SingUpPage(driver);
        page.setActivityType("BANK");
    }


    @After
    public void tearDown(){
        driver.quit();
    }
}
