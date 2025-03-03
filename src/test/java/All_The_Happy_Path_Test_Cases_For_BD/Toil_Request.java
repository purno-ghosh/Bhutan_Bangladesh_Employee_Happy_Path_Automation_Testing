package All_The_Happy_Path_Test_Cases_For_BD;
import java.time.LocalDate;
import java.time.DayOfWeek;
import Setup_All.Setup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
        openCalendarButton.click();

        LocalDate today = LocalDate.now();
        LocalDate nextSaturday = today.with(DayOfWeek.SATURDAY);
        String saturdayDate;

        if (today.getDayOfWeek() == DayOfWeek.SATURDAY) {
            saturdayDate = String.valueOf(today.getDayOfMonth());
        } else {
            nextSaturday = nextSaturday.plusWeeks(1);
            saturdayDate = String.valueOf(nextSaturday.getDayOfMonth());
            if (nextSaturday.getMonth() != today.getMonth()) {
                saturdayDate = String.valueOf(nextSaturday.getDayOfMonth());
                nextMonthButton.click();
            }
        }

        System.out.println("Upcoming Saturday Date: " + saturdayDate);
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button//div[normalize-space(text())='" + saturdayDate + "']")).click();
        reasonTextArea.sendKeys("Test Toil Automation");
        Thread.sleep(3000);
        requestNowButton.click();

        return null;
    }

}
