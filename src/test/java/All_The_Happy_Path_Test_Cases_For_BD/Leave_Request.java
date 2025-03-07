package All_The_Happy_Path_Test_Cases_For_BD;
import Setup_All.Setup;
import Setup_All.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.time.DayOfWeek;
import java.time.LocalDate;


public class Leave_Request {
    private WebDriver driver;
    private Setup setup;

    @FindBy(xpath = "//span[normalize-space(text())='Leave Management']")
    public WebElement leaveManagement;
    @FindBy(xpath = "//span[text()='My Leave']")
    public WebElement myLeave;
    @FindBy(xpath = "//span[normalize-space(text())='Leave Request']")
    public WebElement leaveRequest;
    @FindBy(xpath = "//span[contains(text(), 'Select Type')]")
    public WebElement selectType;
    @FindBy(xpath = "//span[contains(text(), 'Annual Leave')]")
    public WebElement annualLeave;
    @FindBy(xpath = "//span[text()='Sick Leave']")
    public WebElement sickLeave;
    @FindBy(xpath = "//span[text()='Company Trip Leave']")
    public WebElement companyTripLeave;
    @FindBy(xpath = "//span[text()='Paternity Leave']")
    public WebElement paternityLeave;
    @FindBy(xpath = "(//button[@aria-label='Open calendar'])[3]")
    public WebElement startDate;
    @FindBy(xpath = "(//button[@aria-label='Open calendar'])[4]")
    public WebElement endDate;
    @FindBy(xpath = "//textarea[@formcontrolname='Reason']")
    public WebElement reasonTextArea;
    @FindBy(xpath = "//span[normalize-space(text())='Request Now']")
    public WebElement requestNowButton;
    @FindBy(xpath = "(//tbody//tr)[1]")
    public WebElement firstRow;
    @FindBy(xpath = "//span[normalize-space(text())='Withdraw']")
    public WebElement withdrawButton;
    @FindBy(xpath = "//div[@class='button-container']//button//span[text()='Withdraw']")
    public WebElement confirmWithdraw;
    @FindBy(xpath = "//button[contains(@class, 'mat-calendar-next-button')]")
    public WebElement nextButton;
    @FindBy(xpath = "//span[text()='Half Day']")
    public WebElement halfDay;
    @FindBy(xpath = "//span[text()='Leave Time']")
    public WebElement leaveTime;
    @FindBy(xpath = "//span[normalize-space(text())='First Half']")
    public WebElement firstHalf;


    public Leave_Request(WebDriver driver) {
        this.driver = driver;
        this.setup = new Setup();
        PageFactory.initElements(driver, this);
    }

    public void applyAndWithdrawLeave() throws InterruptedException {
        Utils.waitForElementToBeClickable(driver, leaveManagement);
        leaveManagement.click();
        Utils.waitForElementToBeClickable(driver, myLeave);
        myLeave.click();

        // Determine the next working day
        LocalDate today = LocalDate.now();
        int leaveDate;

        if (today.getDayOfWeek() == DayOfWeek.FRIDAY || today.getDayOfWeek() == DayOfWeek.SATURDAY) {
            leaveDate = today.with(DayOfWeek.MONDAY).plusWeeks(1).getDayOfMonth();
        } else {
            leaveDate = today.getDayOfMonth();
        }

        if (today.getDayOfMonth() == 30 && leaveDate < today.getDayOfMonth()) {
            Utils.waitForElementToBeClickable(driver, nextButton);
            nextButton.click();
            System.out.println("Clicked next button to go to the next month");
        }

        System.out.println("Working date leave date: " + leaveDate);

        // Apply and withdraw different types of leave
        applyLeave(annualLeave, leaveDate, false, false);
        applyLeave(sickLeave, leaveDate, false, true);
        applyLeave(annualLeave, leaveDate, true, false);
        applyLeave(sickLeave, leaveDate, true, true);
    }

    private void applyLeave(WebElement leaveType, int leaveDate, boolean isHalfDay, boolean isSickLeave) throws InterruptedException {
        Utils.waitForElementToBeClickable(driver, leaveRequest);
        leaveRequest.click();

        if (isHalfDay) {
            Utils.waitForElementToBeClickable(driver, halfDay);
            halfDay.click();
        }

        Utils.waitForElementToBeClickable(driver, selectType);
        selectType.click();
        Utils.waitForElementToBeClickable(driver, leaveType);
        leaveType.click();

        // Select start date
        Utils.waitForElementToBeClickable(driver, startDate);
        startDate.click();
        WebElement startDateElement = driver.findElement(By.xpath("//div[normalize-space(text())='" + leaveDate + "']"));
        Utils.waitForElementToBeClickable(driver, startDateElement);
        startDateElement.click();

        // Select end date (if not a half-day leave)
        if (!isHalfDay) {
            Utils.waitForElementToBeClickable(driver, endDate);
            endDate.click();
            WebElement endDateElement = driver.findElement(By.xpath("//div[normalize-space(text())='" + leaveDate + "']"));
            Utils.waitForElementToBeClickable(driver, endDateElement);
            endDateElement.click();
        } else {
            // Select leave time for half-day leave
            Utils.waitForElementToBeClickable(driver, leaveTime);
            leaveTime.click();
            Utils.waitForElementToBeClickable(driver, firstHalf);
            firstHalf.click();
        }

        // Enter reason
        Utils.waitForElementToBeVisible(driver, reasonTextArea);
        reasonTextArea.sendKeys("Test Automation Leave");

        // Submit leave request
        Utils.waitForElementToBeClickable(driver, requestNowButton);
        requestNowButton.click();

        // Withdraw Leave
        Utils.waitForElementToBeClickable(driver, firstRow);
        firstRow.click();
        Utils.waitForElementToBeClickable(driver, withdrawButton);
        withdrawButton.click();
        Utils.waitForElementToBeClickable(driver, confirmWithdraw);
        confirmWithdraw.click();

        System.out.println((isSickLeave ? "Sick" : "Annual") + (isHalfDay ? " Half-Day" : "") + " Leave successfully applied and withdrawn!");
    }

}
