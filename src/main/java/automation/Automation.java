package automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class Automation {

    private WebDriver driver;
    private static final String URL = "http://test.biz.ua";
    private static final String USER_NAME = "TestUser01";
    private static final String PASSWORD = "Vfylhfujhf!1";
    private static Random random;
    private String message;

    public Automation() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        random = new Random();
    }

    public void generateMessage() {
        message = "Andrii" + random.nextInt();
    }

    public void login() {
        driver.get(URL);

        WebElement userNameElement = driver.findElement(By.cssSelector("#txtUsername"));
        userNameElement.sendKeys(USER_NAME);
        WebElement passwordElement = driver.findElement(By.cssSelector("#txtPassword"));
        passwordElement.sendKeys(PASSWORD);

        WebElement submitButton = driver.findElement(By.cssSelector("#btnLogin"));
        submitButton.submit();

        System.out.println("Logged in successfully");
    }

    public void navigate() {
        WebElement itemFromNavigationBar = driver.findElement(By.xpath("//b[contains(text(),'Time')]"));
        itemFromNavigationBar.click();

        WebElement itemFromNavigationMenu = driver.findElement(By.cssSelector("#menu_attendance_Attendance"));
        itemFromNavigationMenu.click();

        WebElement itemFromNavigationSubMenu = driver.findElement(By.cssSelector("#menu_attendance_punchIn"));
        itemFromNavigationSubMenu.click();
    }

    public void writeNote() {
        WebElement noteField = driver.findElement(By.cssSelector("#note"));
        noteField.sendKeys(message);

        WebElement buttonPunch = driver.findElement(By.cssSelector("#btnPunch"));
        buttonPunch.click();

        System.out.println("Punch was written successfully!");
    }

    public void checkRecord() {
        WebElement itemFromNavigationMenu = driver.findElement(By.cssSelector("#menu_attendance_Attendance"));
        itemFromNavigationMenu.click();

        WebElement itemFromNavigationSubMenu = driver.findElement(By.cssSelector("#menu_attendance_viewMyAttendanceRecord"));
        itemFromNavigationSubMenu.click();

        WebElement calendarIcon = driver.findElement(By.cssSelector("#attendance_date"));
        calendarIcon.clear();

        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String labelDate = dateTime.format(formatter);

        calendarIcon.sendKeys(LocalDate.now().toString());
        calendarIcon.submit();

        WebElement punchInDate = driver.findElement(By.xpath("//*[text()[contains(.,'" + labelDate + "')]]"));
        WebElement punchInNote = punchInDate.findElement(By.xpath("following-sibling::*"));

        System.out.printf("Punch '%s' from '%s' exists: %b", message, labelDate, (punchInNote.getText().equals(message)));
    }
}
