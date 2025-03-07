package Test_Runner;
import All_The_Happy_Path_Test_Cases_For_BD.*;
import Setup_All.Setup;
import Setup_All.Utils;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import java.io.IOException;

public class All_Test_Cases extends Setup {
//    @BeforeSuite
//    public void clearTestResultFile() {
//        Utils.clearTestResultFile();
//    }

    @Test(priority = 1, enabled = true)
    public void Bangladeshi_Employees_Attendance() throws IOException, InterruptedException {
        Bangladeshi_Employee_Clock_IN actions = new Bangladeshi_Employee_Clock_IN(driver);
        try {
            String Actual_value = actions.SingleEmployeeAttendance();
            Utils.writeTestResult("Test One >> Clock-in OK for BD Employees");
        } catch (Exception e) {
            Utils.writeTestResult("Test One >> Clock-in NOT OK for BD Employees");
            throw e;
        }
    }

    @Test(priority = 2, enabled = true)
    public void Correction_Request_Test() throws IOException, InterruptedException {
        Correction_Request actions2 = new Correction_Request(driver);
        try {
            String Actual_value2 = actions2.Correction_Request_Test();
            Utils.writeTestResult("Test Two >> Correction Request OK");
        } catch (Exception e) {
            Utils.writeTestResult("Test Two >> Correction Request NOT OK");
            throw e;
        }
    }

    @Test(priority = 3, enabled = true)
    public void Leave_Request_Test() throws IOException, InterruptedException {
        Leave_Request actions5 = new Leave_Request(driver);
        try {
            actions5.applyAndWithdrawLeave();
            Utils.writeTestResult("Test Five >> All Type Leave Request OK");
        } catch (Exception e) {
            Utils.writeTestResult("Test Five >> Leave Request NOT OK");
            throw e;
        }
    }

    @Test(priority = 4, enabled = true)
    public void Toil_Request_Test() throws IOException, InterruptedException {
        Toil_Request actions3 = new Toil_Request(driver);
        try {
            String Actual_value3 = actions3.Toil_Request_Test();
            Utils.writeTestResult("Test Three >> Toil Request OK");
        } catch (Exception e) {
            Utils.writeTestResult("Test Three >> Toil Request NOT OK");
            throw e;
        }
    }

    @Test(priority = 5, enabled = true)
    public void Lunch_Request_Test() throws IOException, InterruptedException {
        Lunch_Request actions4 = new Lunch_Request(driver);
        try {
            String Actual_value4 = actions4.Lunch_Request_Test();
            Utils.writeTestResult("Test Four >> Lunch Request OK");
        } catch (Exception e) {
            Utils.writeTestResult("Test Four >> Lunch Request NOT OK");
            throw e;
        }
    }


    @Test(priority = 6, enabled = true)
    public void Toil_Request_Remove_Test() throws IOException, InterruptedException {
        Toil_Request_Remove actions6 = new Toil_Request_Remove(driver);
        try {
            String Actual_value6 = actions6.Toil_Request_Remove_Test();
            Utils.writeTestResult("Toil Request Remove");
        } catch (Exception e) {
            Utils.writeTestResult("Cant Remove Toil Request");
            throw e;
        }
    }

//    @AfterSuite
//    public void closeBrowser() {
//        if (driver != null) {
//            driver.quit();
//        }
//    }

}
