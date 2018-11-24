import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfAllElementsLocatedBy;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

/**
 * Created by dmalivanov on 11/24/18.
 */
public class SingUpPage {

    private WebDriver driver;

    public SingUpPage(WebDriver driver){
        this.driver = driver;
    }

    private By loginField = By.xpath("//*[@name='login' and @formcontrolname='login']");
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
    private By agreeCheckBox = By.xpath("//label[@class='custom-control-label' and @for]");
    private By submitButton = By.xpath("//*[@type='submit']");

    public SingUpPage typeloginField(String login){
        driver.findElement(loginField).sendKeys(login);
        return this;
    }

    public SingUpPage typeCompanyNameField(String companyName){
        driver.findElement(companyNameField).sendKeys(companyName);
        return this;
    }

    public SingUpPage typeEmailCompanyField(String emailCompany){
        driver.findElement(emailCompanyField).sendKeys(emailCompany);
        return this;
    }

    public SingUpPage typeIdnCompanyField(String idnCompany){
        driver.findElement(idnCompanyField).sendKeys(idnCompany);
        return this;
    }

    public SingUpPage typeLegalAddressField(String legalAddress){
        driver.findElement(legalAddressField).sendKeys(legalAddress);
        return this;
    }

    public SingUpPage setActivityType(String activityType){
        driver.findElement(activityTypeDropDown).click();
        new WebDriverWait(driver, 5)
                .until(visibilityOfElementLocated(By.xpath(String.format(activityTypeDropDownOption, activityType))))
                .click();
        return this;
    }

    public SingUpPage typePhoneNumberField(String phoneNumber){
        driver.findElement(phoneNumberField).sendKeys(phoneNumber);
        return this;
    }

    public SingUpPage typeFirstNameField(String firstName){
        driver.findElement(firstNameField).sendKeys(firstName);
        return this;
    }

    public SingUpPage typeLastNameField(String lastName){
        driver.findElement(lastNameField).sendKeys(lastName);
        return this;
    }

    public SingUpPage typeMiddleNameField(String middleName){
        driver.findElement(middleNameField).sendKeys(middleName);
        return this;
    }

    public SingUpPage setAgreeCheckBox(boolean value){
        WebElement checkbox = driver.findElement(agreeCheckBox);
        if(!checkbox.isSelected() == value){
            checkbox.click();
        }
        return this;
    }

    public void submitRegistration(){
        driver.findElement(submitButton).click();
    }

    public boolean isSubmitButtonEnable(){
        return driver.findElement(submitButton).isEnabled();
    }
}
