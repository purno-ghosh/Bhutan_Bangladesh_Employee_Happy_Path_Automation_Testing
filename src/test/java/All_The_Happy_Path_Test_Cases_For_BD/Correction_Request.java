package All_The_Happy_Path_Test_Cases_For_BD;

import Setup_All.Setup;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Correction_Request {
    private WebDriver driver;
    private Setup setup;
    @FindBy(xpath = "(//mat-icon[contains(text(),'edit')])[1]")
    public WebElement edit_icon;
    @FindBy(xpath = "//input[@formcontrolname=\"clockStartTime\"]")
    public WebElement correction_start_time;
    @FindBy(xpath = "//input[@formcontrolname=\"clockEndTime\"]")
    public WebElement correction_end_time;
    @FindBy(xpath = "//span[normalize-space(text())=\"Request Now\"]")
    public WebElement correction_Request_now_button;
    @FindBy(xpath = "//p[text()=\"Attendance corretion request send successfully.\"]")
    public WebElement correction_Request_successfully_message;

    public Correction_Request(WebDriver driver) {
        this.driver = driver;
        this.setup = new Setup();
        PageFactory.initElements(driver, this);
    }

   public String  Correction_Request_Test()throws InterruptedException {

       Thread.sleep(2000);
       Actions actions = new Actions(driver);
       actions.moveToElement(edit_icon).click().perform();
       Thread.sleep(2000);
       correction_start_time.clear();
       Thread.sleep(2000);
       correction_start_time.sendKeys("10:00:00");
       correction_end_time.sendKeys("20:00:00");
       correction_Request_now_button.click();
       Thread.sleep(5000);
       return null;
   }


}
