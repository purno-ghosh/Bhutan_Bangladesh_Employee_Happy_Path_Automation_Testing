package All_The_Happy_Path_Test_Cases_For_BD;
import Setup_All.Setup;
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
        Thread.sleep(2000);
        LocalDate today = LocalDate.now();
        int leaveDate = (today.getDayOfWeek() == DayOfWeek.FRIDAY || today.getDayOfWeek() == DayOfWeek.SATURDAY)
                ? today.with(DayOfWeek.SUNDAY).plusWeeks(1).getDayOfMonth()
                : today.getDayOfMonth();

        if (today.getDayOfMonth() == 30 && leaveDate < today.getDayOfMonth()) {
            nextButton.click();
            System.out.println("Clicked next button to go to the next month");
        }

        System.out.println("Working date leave date" + leaveDate);
        leaveManagement.click();
        myLeave.click();

        //  ----  Annual Leave ----- //
        leaveRequest.click();
        Thread.sleep(2000);
        selectType.click();
        Thread.sleep(2000);
        annualLeave.click();
        startDate.click();
        driver.findElement(By.xpath("//div[normalize-space(text())='" + leaveDate + "']")).click();
        endDate.click();
        driver.findElement(By.xpath("//div[normalize-space(text())='" + leaveDate + "']")).click();
        reasonTextArea.sendKeys("Test Autoamtion Leave");
        requestNowButton.click();
        Thread.sleep(3000);
        firstRow.click();
        withdrawButton.click();
        Thread.sleep(2000);
        confirmWithdraw.click();
        Thread.sleep(2000);
        System.out.println("Annual Leave successfully!");

        //  ----  Sick Leave ----- //

        leaveRequest.click();
        Thread.sleep(2000);
        selectType.click();
        Thread.sleep(2000);
        sickLeave.click();
        startDate.click();
        driver.findElement(By.xpath("//div[normalize-space(text())='" + leaveDate + "']")).click();
        endDate.click();
        driver.findElement(By.xpath("//div[normalize-space(text())='" + leaveDate + "']")).click();
        reasonTextArea.sendKeys("Test Autoamtion Leave");
        requestNowButton.click();
        Thread.sleep(3000);
        firstRow.click();
        withdrawButton.click();
        Thread.sleep(2000);
        confirmWithdraw.click();
        Thread.sleep(2000);
        System.out.println("Sick Leave successfully!");

        //  ----  Annual Half Day Leave ----- //

        leaveRequest.click();
        Thread.sleep(2000);
        halfDay.click();
        Thread.sleep(1000);
        selectType.click();
        Thread.sleep(2000);
        annualLeave.click();
        startDate.click();
        driver.findElement(By.xpath("//div[normalize-space(text())='" + leaveDate + "']")).click();
        leaveTime.click();
        firstHalf.click();
        reasonTextArea.sendKeys("Test Autoamtion Leave");
        requestNowButton.click();
        Thread.sleep(3000);
        firstRow.click();
        withdrawButton.click();
        Thread.sleep(2000);
        confirmWithdraw.click();
        Thread.sleep(2000);
        System.out.println("Annual Half Day Leave successfully!");

        //  ----  Sick Half Day Leave ----- //
        leaveRequest.click();
        Thread.sleep(2000);
        halfDay.click();
        Thread.sleep(1000);
        selectType.click();
        Thread.sleep(2000);
        sickLeave.click();
        startDate.click();
        driver.findElement(By.xpath("//div[normalize-space(text())='" + leaveDate + "']")).click();
        leaveTime.click();
        firstHalf.click();
        reasonTextArea.sendKeys("Test Autoamtion Leave");
        requestNowButton.click();
        Thread.sleep(3000);
        firstRow.click();
        withdrawButton.click();
        Thread.sleep(2000);
        confirmWithdraw.click();
        Thread.sleep(2000);
        System.out.println("Annual Half Day Leave successfully!");

    }
}
