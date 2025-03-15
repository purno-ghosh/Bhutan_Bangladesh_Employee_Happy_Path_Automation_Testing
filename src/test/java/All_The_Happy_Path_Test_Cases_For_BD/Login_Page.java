package All_The_Happy_Path_Test_Cases_For_BD;

import Setup_All.Setup;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_Page {
    private WebDriver driver;

    @FindBy(xpath = "//input[@name=\"email\"]")
    public WebElement email_field;

    @FindBy(xpath = "//input[@name=\"password\"]")
    public WebElement password_field;

    @FindBy(xpath = "//span[text()=\" Login \"]")
    public WebElement login_click;

    public Login_Page(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void dologin() {
        String email = Setup.getConfigData("userEmail");
        String password = Setup.getConfigData("password");

        email_field.sendKeys(email);
        password_field.sendKeys(password);
        login_click.click();
    }
}
