package testpackage.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import testpackage.base.BasePage;

import java.time.LocalDate;

public class PunchInOutPage extends BasePage {

    private String input = "Test start";
    private String output = "Test finish";
    static String date = LocalDate.now().toString();

    @FindBy(id = "btnPunch")
    private WebElement inOutBtn;

    @FindBy(id = "note")
    private WebElement commentInputPunchInOut;

    @FindBy(id = "currentDate")
    private WebElement currentDate;

    @FindBy(id = "currentTime")
    private WebElement currentTime;

    public PunchInOutPage punchIn(){
        commentInputPunchInOut.sendKeys(input);
        inOutBtn.click();
        return this;
    }

    public MainPage punchOut(){
        commentInputPunchInOut.sendKeys(output);
        inOutBtn.click();
        return new MainPage();
    }
}
