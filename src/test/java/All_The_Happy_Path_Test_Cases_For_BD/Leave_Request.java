package All_The_Happy_Path_Test_Cases_For_BD;

import Setup_All.Setup;
import Setup_All.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.interactions.Actions;
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
        Actions actions = new Actions(driver);

        // Wait and click on Leave Management
        Utils.waitForElementToBeClickable(driver, leaveManagement);
        actions.moveToElement(leaveManagement).click().perform();

        // Wait and click on My Leave
        Utils.waitForElementToBeClickable(driver, myLeave);
        actions.moveToElement(myLeave).click().perform();

        // Determine the next working day
        LocalDate today = LocalDate.now();
        int leaveDate;

        if (today.getDayOfWeek() == DayOfWeek.FRIDAY || today.getDayOfWeek() == DayOfWeek.SATURDAY) {
            leaveDate = today.with(DayOfWeek.MONDAY).plusWeeks(1).getDayOfMonth();
        } else {
            leaveDate = today.getDayOfMonth();
        }

        if (today.getDayOfMonth() == 30 && leaveDate < today.getDayOfMonth()) {
            // Wait and click next month button
            Utils.waitForElementToBeClickable(driver, nextButton);
            actions.moveToElement(nextButton).click().perform();
            System.out.println("Clicked next button to go to the next month");
        }

        System.out.println("Working date leave date: " + leaveDate);

        // Apply and withdraw different types of leave
        applyLeave(annualLeave, leaveDate, false, false, actions);
        applyLeave(sickLeave, leaveDate, false, true, actions);
        applyLeave(annualLeave, leaveDate, true, false, actions);
        applyLeave(sickLeave, leaveDate, true, true, actions);
    }

    private void applyLeave(WebElement leaveType, int leaveDate, boolean isHalfDay, boolean isSickLeave, Actions actions) throws InterruptedException {
        // Wait and click on Leave Request
        Utils.waitForElementToBeClickable(driver, leaveRequest);
        actions.moveToElement(leaveRequest).click().perform();

        if (isHalfDay) {
            // Wait and click Half Day option
            Utils.waitForElementToBeClickable(driver, halfDay);
            actions.moveToElement(halfDay).click().perform();
        }

        // Wait and click Select Type
        Utils.waitForElementToBeClickable(driver, selectType);
        actions.moveToElement(selectType).click().perform();

        // Wait and click the specific leave type
        Utils.waitForElementToBeClickable(driver, leaveType);
        actions.moveToElement(leaveType).click().perform();

        // Select start date
        Utils.waitForElementToBeClickable(driver, startDate);
        actions.moveToElement(startDate).click().perform();
        WebElement startDateElement = driver.findElement(By.xpath("//div[normalize-space(text())='" + leaveDate + "']"));
        Utils.waitForElementToBeClickable(driver, startDateElement);
        actions.moveToElement(startDateElement).click().perform();

        // Select end date (if not a half-day leave)
        if (!isHalfDay) {
            Utils.waitForElementToBeClickable(driver, endDate);
            actions.moveToElement(endDate).click().perform();
            WebElement endDateElement = driver.findElement(By.xpath("//div[normalize-space(text())='" + leaveDate + "']"));
            Utils.waitForElementToBeClickable(driver, endDateElement);
            actions.moveToElement(endDateElement).click().perform();
        } else {
            // Select leave time for half-day leave
            Utils.waitForElementToBeClickable(driver, leaveTime);
            actions.moveToElement(leaveTime).click().perform();
            Utils.waitForElementToBeClickable(driver, firstHalf);
            actions.moveToElement(firstHalf).click().perform();
        }

        // Enter reason
        Utils.waitForElementToBeVisible(driver, reasonTextArea);
        reasonTextArea.sendKeys("Test Automation Leave");

        // Submit leave request
        Utils.waitForElementToBeClickable(driver, requestNowButton);
        actions.moveToElement(requestNowButton).click().perform();

        // Withdraw Leave
        Utils.waitForElementToBeClickable(driver, firstRow);
        actions.moveToElement(firstRow).click().perform();
        Utils.waitForElementToBeClickable(driver, withdrawButton);
        actions.moveToElement(withdrawButton).click().perform();
        Utils.waitForElementToBeClickable(driver, confirmWithdraw);
        actions.moveToElement(confirmWithdraw).click().perform();

        System.out.println((isSickLeave ? "Sick" : "Annual") + (isHalfDay ? " Half-Day" : "") + " Leave successfully applied and withdrawn!");
    }
}
