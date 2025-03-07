package All_The_Happy_Path_Test_Cases_For_BD;
import java.time.Duration;
import java.time.LocalDate;
import java.time.DayOfWeek;
import Setup_All.Setup;
import Setup_All.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
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
    @FindBy(xpath = "//span[normalize-space(text())='Request Now']")
    public WebElement requestNowButton;
    @FindBy(xpath = "//p[text()='Toil request made successfully']")
    public WebElement toilRequestSuccessMessage;

    public Toil_Request(WebDriver driver) {
        this.driver = driver;
        this.setup = new Setup();
        PageFactory.initElements(driver, this);
    }

    public String Toil_Request_Test() throws InterruptedException {

        toilManagement.click();
        Thread.sleep(2000);
        myToil.click();
        Thread.sleep(2000);
        myToil.click();
        Thread.sleep(2000);
        toilRequest.click();
        Thread.sleep(2000);
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

        try {
            // Wait and click the target date button using Actions
            String dateButtonXpath = "//button//div[normalize-space(text())='" + targetDateStr + "']";
            WebElement dateButton = driver.findElement(By.xpath(dateButtonXpath));
            Actions actions = new Actions(driver);
            actions.moveToElement(dateButton).click().perform(); // Move and click

            // Enter reason
            reasonTextArea.sendKeys("Test Toil Automation");

            // Wait and click request button using Actions
            String requestButtonXpath = "//button[normalize-space(text())='Request Now']";  // Update with correct button text or XPath
            WebElement requestNowButton = driver.findElement(By.xpath(requestButtonXpath));
            actions.moveToElement(requestNowButton).click().perform(); // Move and click

            // Ensure the button is still clickable before clicking again
            Utils.waitForElementToBeClickable(driver, requestNowButton);
            try {
                actions.moveToElement(requestNowButton).click().perform(); // Attempt normal click
            } catch (Exception e) {
                // If normal click fails, use JavaScript click
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("arguments[0].click();", requestNowButton);
            }

        } catch (Exception e) {
            System.out.println("Already have toil");
        }



        return null;
    }

}
