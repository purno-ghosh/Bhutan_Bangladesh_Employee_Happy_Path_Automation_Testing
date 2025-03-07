package Setup_All;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.ITestResult;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.Properties;

public class Setup {

    public static WebDriver driver;
    public static Properties configProperties;

    @BeforeSuite
    public void setup() throws IOException {
        clearTestResultFile(); // Call method to clear test results

        // Load properties
        configProperties = new Properties();
        InputStream fileInput = getClass().getClassLoader().getResourceAsStream("config.properties");
        if (fileInput == null) {
            throw new IOException("config.properties file not found in src/test/resources!");
        }
        configProperties.load(fileInput);

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--window-size=1920,1080");
        options.addArguments("--disable-gpu");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        String baseUrl = configProperties.getProperty("url");
        driver.get(baseUrl);
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
    public void takeScreenshot(ITestResult result) throws IOException {
        Utils utils = new Utils(driver);
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
