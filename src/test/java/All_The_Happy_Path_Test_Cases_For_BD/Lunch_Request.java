package All_The_Happy_Path_Test_Cases_For_BD;

import Setup_All.Setup;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;

public class Lunch_Request {
    private WebDriver driver;
    private Setup setup;
    @FindBy(xpath = "//span[normalize-space(text())='Lunch System']")
    public WebElement lunchManagement;
    @FindBy(xpath = "//span[text()='Request Lunch']")
    public WebElement Request_Lunch;
    @FindBy(xpath = "(//span[@class='mat-radio-outer-circle'])[1]")
    public WebElement select_Lunch;
    @FindBy(xpath = "//span[normalize-space(text())='Submit Request']")
    public WebElement submit_Lunch;
    @FindBy(xpath = "//p[normalize-space(text())='Food request made successfully']")
    public WebElement submit_Lunch_successfully_message;


    public Lunch_Request(WebDriver driver) {
        this.driver = driver;
        this.setup = new Setup();
        PageFactory.initElements(driver, this);
    }
    public String Lunch_Request_Test()throws InterruptedException {
        Thread.sleep(2000);
        lunchManagement.click();
        Thread.sleep(2000);
        Request_Lunch.click();
        Thread.sleep(3000);
        select_Lunch.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement submitButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[contains(@class, 'submit-button')]")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'});", submitButton);
        Thread.sleep(2000);
        submit_Lunch.click();
        return null;
    }

}
