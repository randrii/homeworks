package testpackage.pages;

import testpackage.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    private static   WebDriver driver = BasePage.getInstance().getDriver() ;

    @FindBy(xpath = "//input[@id='txtUsername']")
    private WebElement userNameInput;

    @FindBy(xpath = "//input[@id='txtPassword']")
    private WebElement passwordInput;

    @FindBy(xpath = "//input[@id='btnLogin']")
    private WebElement loginButton;

    public LoginPage() {
        PageFactory.initElements(BasePage.getInstance().getDriver(), this);
    }


    public  LoginPage openLoginPage() {
        driver.get("http://test.biz.ua/");
        return  this;
    }

    public MainPage loginToTheSystem(String name,String password) {
        userNameInput.sendKeys(name);
        passwordInput.sendKeys(password);
        loginButton.click();
        return new MainPage();
    }


}