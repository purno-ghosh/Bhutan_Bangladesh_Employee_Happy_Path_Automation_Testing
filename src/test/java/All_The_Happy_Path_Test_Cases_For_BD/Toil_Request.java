package All_The_Happy_Path_Test_Cases_For_BD;
import java.time.Duration;
import java.time.LocalDate;
import java.time.DayOfWeek;
import java.time.format.DateTimeFormatter;
import java.util.List;
import org.openqa.selenium.support.ui.ExpectedConditions;
import Setup_All.Setup;
import Setup_All.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Toil_Request {
    private WebDriver driver;
    private Setup setup;
    @FindBy(xpath = "//span[normalize-space(text())='Toil Management']")
    public WebElement toilManagement;
    @FindBy(xpath = "//span[text()='My Toil']")
    public WebElement myToil;
    @FindBy(xpath = "//mat-icon[text()='add']/following-sibling::span[text()='Toil Request']")
    public WebElement toilRequest;
    @FindBy(xpath = "//button[@aria-label='Open calendar']")
    public WebElement openCalendarButton;
    @FindBy(xpath = "//button[@aria-label='Next month']")
    public WebElement nextMonthButton;
    @FindBy(xpath = "//textarea[@formcontrolname='Reason']")
    public WebElement reasonTextArea;

    @FindBy(xpath = "//div/mat-error[contains(normalize-space(text()),'A Toil Request Already Exists')]")
    public WebElement Already_toil_text;
    @FindBy(xpath = "//span[normalize-space(text())='Request Now']")
    public WebElement requestNowButton;
    @FindBy(xpath = "//p[text()='Toil request made successfully']")
    public WebElement toilRequestSuccessMessage;

    public Toil_Request(WebDriver driver) {
        this.driver = driver;
        this.setup = new Setup();
        PageFactory.initElements(driver, this);
    }

    public String Toil_Request_Test() throws InterruptedException{

        toilManagement.click();
        Thread.sleep(1000);
        myToil.click();
        Thread.sleep(1000);
        toilRequest.click();
        Thread.sleep(1000);
        openCalendarButton.click();
        LocalDate today = LocalDate.now();
        LocalDate targetDate;

        if (today.getDayOfWeek() == DayOfWeek.FRIDAY || today.getDayOfWeek() == DayOfWeek.SATURDAY) {
            targetDate = today;
        } else {
            targetDate = today.with(DayOfWeek.FRIDAY);
            if (targetDate.isBefore(today)) {
                targetDate = targetDate.plusWeeks(1);
            }
        }

        String targetDateStr = String.valueOf(targetDate.getDayOfMonth());
        System.out.println("Target Date: " + targetDateStr);

        boolean isNextMonth = targetDate.getMonthValue() != today.getMonthValue();
        if (isNextMonth) {

            nextMonthButton.click();
            System.out.println("Click on the next month button");
            Thread.sleep(1000);
        }


        String dateButtonXpath = "//button//div[normalize-space(text())='" + targetDateStr + "']";
        WebElement dateButton = driver.findElement(By.xpath(dateButtonXpath));
        dateButton.click();
        System.out.println("Click on the date");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        try {
            // Wait until the element is visible
            System.out.println("Wait until the element is visible");
            wait.until(ExpectedConditions.visibilityOf(Already_toil_text));

            if (Already_toil_text.isDisplayed()) {
                System.out.println("Already have toil");
            }
        } catch (Exception e) {
            // If the element is not found or not displayed, execute the else block
            System.out.println("No toil");
            reasonTextArea.sendKeys("Test Toil Automation");
            requestNowButton.click();
        }




        return null;
    }

}

