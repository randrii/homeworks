package testpackage.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import testpackage.base.BasePage;

public class MyInfoPage {

    @FindBy(xpath = "//input[@id='btnSave']")
    private WebElement EditSaveBtn;

    @FindBy(xpath = "//input[@id='personal_txtEmpFirstName']")
    private WebElement firstNameInput;

    @FindBy(xpath = "//input[@id='personal_txtEmpMiddleName']")
    private WebElement middleNameInput;

    @FindBy(xpath = "//input[@id='personal_txtEmpLastName']")
    private WebElement lastNameInput;

    @FindBy(xpath = " //input[@id='personal_txtEmployeeId']")
    private WebElement employeeIdInput;

    @FindBy(xpath = "//input[@id='personal_optGender_1']")
    private WebElement genderMale;

    @FindBy(xpath = "//option[contains(text(),'Ukrainian')]")
    private WebElement nationalityUkrainian;

    @FindBy(xpath = "//option[contains(text(),'Other')]")
    private WebElement maritalStatus;

    @FindBy(xpath = "//input[@id='personal_DOB']")
    private WebElement dateOfBirth;

    @FindBy(xpath = "//a[@id='menu_pim_viewPimModule']")
    private WebElement pIMBtnHeader;

    @FindBy(xpath = "//a[@id='menu_pim_viewEmployeeList']")
    private WebElement employeeListBtnHeader;

    public MyInfoPage(){
        PageFactory.initElements(BasePage.getInstance().getDriver(), this);
    }

    public MyInfoPage clickEditSave(){
        EditSaveBtn.click();
        return new MyInfoPage();
    }

    public MyInfoPage inputFirstName(String firstName){
        firstNameInput.clear();
        firstNameInput.sendKeys(firstName);
        return new MyInfoPage();
    }

    public MyInfoPage inputMiddleName(String middleName){
        middleNameInput.clear();
        middleNameInput.sendKeys(middleName);
        return new MyInfoPage();
    }

    public MyInfoPage inputLastName(String lastName){
        lastNameInput.clear();
        lastNameInput.sendKeys(lastName);
        return new MyInfoPage();
    }

    public MyInfoPage inputId(String id){
        employeeIdInput.clear();
        employeeIdInput.sendKeys(id);
        return new MyInfoPage();
    }

    public MyInfoPage clickGenderMale(){
        genderMale.click();
        return new MyInfoPage();
    }

    public MyInfoPage clickNationalityUkrainian(){
        nationalityUkrainian.click();
        return new MyInfoPage();
    }

    public MyInfoPage clickMaritalStatus(){
        maritalStatus.click();
        return new MyInfoPage();
    }

    public MyInfoPage inputDateOfBirth(String dateOfBirths){
        dateOfBirth.clear();
        dateOfBirth.sendKeys(dateOfBirths);
        return new MyInfoPage();
    }

    public MyInfoPage moveToPIM(){
        pIMBtnHeader.click();
        return new MyInfoPage();
    }

    public EmployeeListPage moveToEmployeeList(){
        employeeListBtnHeader.click();
        return new EmployeeListPage();
    }
}
