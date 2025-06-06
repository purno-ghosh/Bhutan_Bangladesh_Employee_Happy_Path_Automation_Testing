package Setup_All;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

public class Utils {

    private WebDriver driver;

    public Utils(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    private static final int DEFAULT_WAIT_TIME = 10;

    public static void waitForElementToBeVisible(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_WAIT_TIME));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void takeScreenShot(String status) throws IOException {
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String time = new SimpleDateFormat("dd-MM-yyyy-hh-mm-aa").format(new Date());
        String fileWithPath = "src/test/resources/screenshots/" + status + "-" + time + ".png";
        File destFile = new File(fileWithPath);
        if (destFile.exists()) {
            destFile.delete();
        }
        FileUtils.copyFile(screenshotFile, destFile);
    }


    public static String getPcDate() {
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, MMMM d, yyyy", Locale.ENGLISH);
        return today.format(formatter);
    }

    // Method to get formatted time (24-hour format)
    public static String getPcTime() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
        return now.format(timeFormatter);
    }


    public static void writeTestResult(String result) {
        String filePath = "test_result.txt"; // Path to the result file
        try (FileWriter writer = new FileWriter(filePath, true)) { // Append mode
            writer.write(result + "\n"); // Write the result and add a new line
            System.out.println("Test result written to file: " + result);
        } catch (IOException e) {
            System.err.println("An error occurred while writing to the file: " + e.getMessage());
        }
    }


    private static final int DEFAULT_WAIT_TIMEs = 10;

    public static void waitForElementToBeClickable(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_WAIT_TIMEs));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void waitForElementToBeClickable(WebDriver driver, WebElement element, int timeInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeInSeconds));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }


}







//    // Method to clear the file content before running tests
//    public static void clearTestResultFile() {
//        String filePath = "test_result.txt";
//        try (FileWriter writer = new FileWriter(filePath, false)) { // Overwrite mode
//            writer.write(""); // Clear the file content
//            System.out.println("Test result file cleared.");
//        } catch (IOException e) {
//            System.err.println("An error occurred while clearing the file: " + e.getMessage());
//        }
//    }