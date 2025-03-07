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

        //HeadLess

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--disable-gpu");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

//        ChromeOptions options = new ChromeOptions();
//        driver = new ChromeDriver(options);
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));


        // Open URL
        String baseUrl = configProperties.getProperty("url");
        driver.get(baseUrl);
    }

    public static String getConfigData(String propertyName) {
        return configProperties.getProperty(propertyName);
    }
}
