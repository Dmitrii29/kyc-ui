import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

/**
 * Created by dmalivanov on 11/24/18.
 */
public class SingUpPage {

    //WebDriver driver;

    private By loginField = By.xpath("//*[@name='login']");
    private By companyNameField = By.xpath("//*[@name='web' and @formcontrolname='name']");
    private By emailCompanyField = By.xpath("//*[@id='email' and @name='email']");
    private By idnCompanyField = By.xpath("//*[@id='idn2' and @name]");
    private By legalAddressField = By.xpath("//*[@id='legal' and @name]");
    private By activityTypeDropDown = By.xpath("//*[@id='activity' and @name]");
    private String activityTypeDropDownOption = "//select[@id=\"activity\"]/option[normalize-space()='%s']";
    private By phoneNumberField = By.xpath("//*[@id='phone' and @name]");
    private By firstNameField = By.xpath("//*[@id='firstName' and @name]");
    private By lastNameField = By.xpath("//*[@id='name1' and @name]");
    private By middleNameField = By.xpath("//*[@id='name2' and @name]");
    private By agreeCheckBox = By.xpath("//label[@class='custom-control-label']");//By.xpath("//label[@class='custom-control-label' and @for]");
    private By submitButton = By.xpath("//*[@type='submit']");
    private By errorLabel = By.id("smallError");
    private String errorByText = "//*[@id='smallError' and text()='%s']";

    public SingUpPage open(String path) {
        Selenide.open(path);
        return this;
    }

    public SingUpPage typeLoginField(String login){
        $(loginField).sendKeys(login);
        return this;
    }

    public SingUpPage clickLoginField(){
        $(loginField).click();
        return this;
    }

    public SingUpPage typeCompanyNameField(String companyName){
        $(companyNameField).sendKeys(companyName);
        return this;
    }

    public SingUpPage clickCompanyNameField(){
        $(companyNameField).click();
        return this;
    }

    public SingUpPage typeEmailCompanyField(String emailCompany){
        $(emailCompanyField).sendKeys(emailCompany);
        return this;
    }

    public SingUpPage typeIdnCompanyField(String idnCompany){
        $(idnCompanyField).sendKeys(idnCompany);
        return this;
    }

    public SingUpPage typeLegalAddressField(String legalAddress){
        $(legalAddressField).sendKeys(legalAddress);
        return this;
    }

    public SingUpPage setActivityType(String activityType){

        //dropdown select for selenide
        $(activityTypeDropDown).selectOption(activityType);

        //dropdown click for selenium
        /*new WebDriverWait(driver, 5)
                .until(visibilityOfElementLocated(By.xpath(String.format(activityTypeDropDownOption, activityType))))
                .click();*/
        return this;
    }

    public SingUpPage typePhoneNumberField(String phoneNumber){
        $(phoneNumberField).sendKeys(phoneNumber);
        return this;
    }

    public SingUpPage typeFirstNameField(String firstName){
        $(firstNameField).sendKeys(firstName);
        return this;
    }

    public SingUpPage typeLastNameField(String lastName){
        $(lastNameField).sendKeys(lastName);
        return this;
    }

    public SingUpPage typeMiddleNameField(String middleName){
        $(middleNameField).sendKeys(middleName);
        return this;
    }

    public SingUpPage setAgreeCheckBox(boolean value){
        //checkbox click for selenide
        $(agreeCheckBox).setSelected(value);


        //checkbox click for selenium
        /*WebElement checkbox = driver.findElement(agreeCheckBox);
        if(!checkbox.isSelected() == value){
            checkbox.click();
        }*/
        return this;
    }

    public void submitRegistration(){
        $(submitButton).click();
    }

    public boolean isSubmitButtonEnable(){
        return $(submitButton).isEnabled();
    }

    public ElementsCollection getErrors(){
        return $$(errorLabel);
    }

    public String getErrorByNumber(int errorNumber){
        return getErrors().get(errorNumber - 1).getText();
    }

    public boolean isErrorVisible(String message){

        //for selenide
        return $(By.xpath(String.format(errorByText, message))).isDisplayed();

        //for selenium
        /*return WebDriverRunner.getWebDriver().findElement(By.xpath(String.format(errorByText, message))).size() > 0
                && WebDriverRunner.getWebDriver().findElement(By.xpath(String.format(errorByText, message))).get(0).isDisplayed();*/
    }
}
