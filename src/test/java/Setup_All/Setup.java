package Setup_All;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.Properties;

public class Setup {

    public WebDriver driver;
    public static Properties configProperties;

    @BeforeSuite
    public void loadConfig() throws IOException {
        clearTestResultFile();

        configProperties = new Properties();
        InputStream fileInput = getClass().getClassLoader().getResourceAsStream("config.properties");
        if (fileInput == null) {
            throw new IOException("config.properties file not found in src/test/resources!");
        }
        configProperties.load(fileInput);
    }

    @BeforeMethod
    public void setup() {
        boolean isHeadless = Boolean.parseBoolean(configProperties.getProperty("headless", "false"));

        ChromeOptions options = new ChromeOptions();
        if (isHeadless) {
            options.addArguments("--headless=new"); // Updated headless flag
            options.addArguments("--window-size=1920,1080"); // Ensures elements are visible
            options.addArguments("--disable-blink-features=AutomationControlled"); // Bypasses bot detection
        } else {
            options.addArguments("--start-maximized");
        }
        options.addArguments("--disable-gpu");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-web-security");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        String baseUrl = configProperties.getProperty("url");
        driver.get(baseUrl);

        // Ensure page has loaded
        JavascriptExecutor js = (JavascriptExecutor) driver;
        if (!js.executeScript("return document.readyState").equals("complete")) {
            System.out.println("Page did not load completely in headless mode.");
        }
    }


    public void clearTestResultFile() {
        try (FileWriter writer = new FileWriter("Test_result.txt", false)) {
            writer.write("");
            System.out.println("Cleared Test_result.txt before test execution.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @AfterMethod
    public void takeScreenshotAndCloseDriver(ITestResult result) throws IOException {
        if (ITestResult.FAILURE == result.getStatus()) {
            Utils utils = new Utils(driver);
            utils.takeScreenShot("failure");
            System.out.println("Test failed, screenshot captured.");
        }

       // Close the browser after each test case
       if (driver != null) {
           driver.quit();
           System.out.println("Browser closed successfully after test: " + result.getName());
       }
 }

   @AfterClass
   public void tearDown() {
       if (driver != null) {
           driver.quit();
           driver = null;
       }
   }


    public static String getConfigData(String propertyName) {
        return configProperties.getProperty(propertyName);
    }
}
