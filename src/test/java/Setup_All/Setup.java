package Setup_All;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.ITestResult;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.Properties;

public class Setup {

    public static WebDriver driver;
    public static Properties configProperties;

    @BeforeClass
    public void setup() throws IOException {
        // Clear result file
        try (FileWriter writer = new FileWriter("Test_result.txt", false)) { // Overwrites existing content
            writer.write("");
            System.out.println("Cleared Test_result.txt before test execution.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Load properties
        configProperties = new Properties();
        InputStream fileInput = getClass().getClassLoader().getResourceAsStream("config.properties");
        if (fileInput == null) {
            throw new IOException("config.properties file not found in src/test/resources!");
        }
        configProperties.load(fileInput);



        ChromeOptions options = new ChromeOptions();
        options.addArguments("--window-size=1920,1080"); // Set window size
        options.addArguments("--disable-gpu"); // Optional: Disable GPU acceleration
        options.addArguments("--no-sandbox"); // Optional: Bypass OS security model
        options.addArguments("--disable-dev-shm-usage"); // Optional: Overcome limited resource problems
        driver = new ChromeDriver(options);

        String baseUrl = configProperties.getProperty("url");
        driver.get(baseUrl);
    }
    @AfterMethod
    public void takeScreenshot(ITestResult result) throws IOException {
        Utils utils = new Utils(driver);  // Initialize your custom Utils class for taking screenshots
        if (ITestResult.FAILURE == result.getStatus()) {
            utils.takeScreenShot("failure");
        } else if (ITestResult.SUCCESS == result.getStatus()) {
            utils.takeScreenShot("success");
        }
    }

    public static String getConfigData(String propertyName) {
        return configProperties.getProperty(propertyName);
    }
}
