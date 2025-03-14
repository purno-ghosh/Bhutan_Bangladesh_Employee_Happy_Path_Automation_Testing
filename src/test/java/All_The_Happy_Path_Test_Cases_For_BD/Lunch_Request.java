package All_The_Happy_Path_Test_Cases_For_BD;
import Setup_All.Setup;
import Setup_All.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class Lunch_Request {
    private WebDriver driver;
    private Setup setup;
    @FindBy(xpath = "//span[normalize-space(text())='Lunch System']")
    public WebElement lunchManagement;
    @FindBy(xpath = "//span[text()='Request Lunch']")
    public WebElement Request_Lunch;



    public Lunch_Request(WebDriver driver) {
        this.driver = driver;
        this.setup = new Setup();
        PageFactory.initElements(driver, this);
    }

    public String Lunch_Request_Test() throws InterruptedException {

        Utils.waitForElementToBeClickable(driver, lunchManagement,15);
        lunchManagement.click();
        Thread.sleep(2000);
        Utils.waitForElementToBeClickable(driver, Request_Lunch);
        Request_Lunch.click();
        Thread.sleep(2000);
        String xpath = "//mat-card[contains(@class, 'lunch-card')]";
        WebElement lunchCard = driver.findElement(By.xpath(xpath));
        Actions actions = new Actions(driver);
        actions.moveToElement(lunchCard).click().perform();
        Thread.sleep(3000);

        String submitBut = "//button[contains(@class, 'submit-button')]";
        WebElement submitButton = driver.findElement(By.xpath(submitBut));
        Actions actions1 = new Actions(driver);
        actions1.moveToElement(submitButton).click().perform();
        Thread.sleep(5000);
        return null;
    }

}
