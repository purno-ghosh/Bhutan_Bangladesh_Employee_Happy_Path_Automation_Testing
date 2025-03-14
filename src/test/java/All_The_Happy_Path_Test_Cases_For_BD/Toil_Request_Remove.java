package All_The_Happy_Path_Test_Cases_For_BD;
import Setup_All.Setup;
import Setup_All.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Toil_Request_Remove {

    private WebDriver driver;
    private Setup setup;

    @FindBy(xpath = "//input[@name=\"email\"]")
    public WebElement email_field;
    @FindBy(xpath = "//input[@name=\"password\"]")
    public WebElement password_field;
    @FindBy(xpath = "//span[text()=\" Login \"]")
    public WebElement login_click;
    @FindBy(xpath = "//span[normalize-space(text())='Toil Management']")
    public WebElement toilManagement;
    @FindBy(xpath = "//span[text()='Toil Manager']")
    public WebElement toilManager;
    @FindBy(xpath = "(//tbody//tr)[1]")
    public WebElement toilleaveRequest;
    @FindBy(xpath = "//span[normalize-space()='Decline']")
    public WebElement declineButton;
    @FindBy(xpath = "//textarea[normalize-space(@placeholder)='Reason for decline']")
    public WebElement reasonForDeclineTextArea;
    @FindBy(xpath = "//span[normalize-space()='Confirm']")
    public WebElement confirmButton;
    @FindBy(xpath = "(//mat-icon[normalize-space()='more_vert'])[1]")
    public WebElement firstMoreVertIcon;
    @FindBy(xpath = "//span[normalize-space()='Archive']")
    public WebElement archiveButton;
    @FindBy(xpath = "//span[normalize-space()='Archive']")
    public WebElement archiveConfirm;
    @FindBy(xpath = "//div/h1[normalize-space(text()='My Attendance')] ")
    public WebElement My_Attendanc_Text;


    public Toil_Request_Remove(WebDriver driver) {
        this.driver = driver;
        this.setup = new Setup();
        PageFactory.initElements(driver, this);
    }



    public String Toil_Request_Remove_Test()throws InterruptedException {
        String password = Setup.getConfigData("password");
        String unithead=Setup.getConfigData("unithead");
        Utils.waitForElementToBeClickable(driver,email_field);
        email_field.sendKeys(unithead);
        password_field.sendKeys(password);
        login_click.click();
        Utils.waitForElementToBeClickable(driver, My_Attendanc_Text);
        toilManagement.click();
        toilManager.click();
        Thread.sleep(2000);
        toilleaveRequest.click();
        Thread.sleep(1000);
        declineButton.click();
        Thread.sleep(1000);
        reasonForDeclineTextArea.click();
        reasonForDeclineTextArea.sendKeys("Test");
        confirmButton.click();
        Thread.sleep(1000);
        firstMoreVertIcon.click();
        Thread.sleep(2000);
        archiveButton.click();
        Thread.sleep(3000);
        archiveConfirm.click();
        Thread.sleep(5000);
        return null;
    }

}
