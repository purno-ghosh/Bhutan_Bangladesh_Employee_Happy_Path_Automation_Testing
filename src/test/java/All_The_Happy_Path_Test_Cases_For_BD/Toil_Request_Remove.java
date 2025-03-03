package All_The_Happy_Path_Test_Cases_For_BD;
import Setup_All.Setup;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Toil_Request_Remove {

    private WebDriver driver;
    private Setup setup;

    @FindBy(xpath = "//button[contains(@class, 'user-button') and contains(@class, 'mat-menu-trigger')]")
    public WebElement Click_Profile;
    @FindBy(xpath = "//button[contains(@class, 'mat-menu-item') and span[text()='Logout']]")
    public WebElement Click_Logout;
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
    @FindBy(xpath = "//span[contains(@class, 'employee-name') and normalize-space(text())='Shazneen Tabassum']")
    public WebElement testBdSick;
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


    public Toil_Request_Remove(WebDriver driver) {
        this.driver = driver;
        this.setup = new Setup();
        PageFactory.initElements(driver, this);
    }
    public String Toil_Request_Remove_Test()throws InterruptedException {
        String password = Setup.getConfigData("password");
        String unithead=Setup.getConfigData("unithead");
        Click_Profile.click();
        Click_Logout.click();
        Thread.sleep(3000);
        email_field.sendKeys(unithead);
        password_field.sendKeys(password);
        login_click.click();
        Thread.sleep(5000);
        toilManagement.click();
        toilManager.click();
        testBdSick.click();
        Thread.sleep(3000);
        declineButton.click();
        reasonForDeclineTextArea.sendKeys("Test");
        confirmButton.click();
        Thread.sleep(3000);
        firstMoreVertIcon.click();
        archiveButton.click();
        Thread.sleep(3000);
        archiveConfirm.click();
        return null;
    }

}
