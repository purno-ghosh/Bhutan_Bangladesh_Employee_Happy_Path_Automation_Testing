package Test_Runner;

import All_The_Happy_Path_Test_Cases_For_BD.*;
import Setup_All.Setup;
import Setup_All.Utils;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class All_Test_Cases extends Setup {

    private String getCurrentTimeStamp() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return "[" + LocalDateTime.now().format(formatter) + "] ";
    }


    @Test(priority = 1, enabled = true)
    public void Bangladeshi_Employees_Attendance() throws IOException, InterruptedException {
        Login_Page loginPage = new Login_Page(driver);
        loginPage.dologin();

        Bangladeshi_Employee_Clock_IN actions = new Bangladeshi_Employee_Clock_IN(driver);
        try {
            actions.SingleEmployeeAttendance();
            Utils.writeTestResult(getCurrentTimeStamp() +"Test One >> Clock-in OK for BD Employees");
        } catch (Exception e) {
            Utils.writeTestResult(getCurrentTimeStamp() +"Test One >> Clock-in NOT OK for BD Employees");
            throw e;
        }
    }

    @Test(priority = 2, enabled = false)
    public void Correction_Request_Test() throws IOException, InterruptedException {
        Login_Page loginPage = new Login_Page(driver);
        loginPage.dologin();

        Correction_Request actions2 = new Correction_Request(driver);
        try {
            actions2.Correction_Request_Test();
            Utils.writeTestResult(getCurrentTimeStamp() +"Test Two >> Correction Request OK");
        } catch (Exception e) {
            Utils.writeTestResult(getCurrentTimeStamp() +"Test Two >> Correction Request NOT OK");
            throw e;
        }
    }

    @Test(priority = 3, enabled = true)
    public void Leave_Request_Test() throws IOException, InterruptedException {
        Login_Page loginPage = new Login_Page(driver);
        loginPage.dologin();

        Leave_Request actions5 = new Leave_Request(driver);
        try {
            actions5.applyAndWithdrawLeave();
            Utils.writeTestResult(getCurrentTimeStamp() +"Test Five >> All Type Leave Request OK");
        } catch (Exception e) {
            Utils.writeTestResult(getCurrentTimeStamp() +"Test Five >> Leave Request NOT OK");
            throw e;
        }
    }

    @Test(priority = 4, enabled = false)
    public void Toil_Request_Test() throws IOException, InterruptedException {
        Login_Page loginPage = new Login_Page(driver);
        loginPage.dologin();

        Toil_Request actions3 = new Toil_Request(driver);
        try {
            actions3.Toil_Request_Test();
            Utils.writeTestResult(getCurrentTimeStamp() +"Test Three >> Toil Request OK");
        } catch (Exception e) {
            Utils.writeTestResult(getCurrentTimeStamp() +"Test Three >> Toil Request NOT OK");
            throw e;
        }
    }

    @Test(priority = 5, enabled = false)
    public void Lunch_Request_Test() throws IOException, InterruptedException {
        Login_Page loginPage = new Login_Page(driver);
        loginPage.dologin();

        Lunch_Request actions4 = new Lunch_Request(driver);
        try {
            actions4.Lunch_Request_Test();
            Utils.writeTestResult(getCurrentTimeStamp() +"Test Four >> Lunch Request OK");
        } catch (Exception e) {
            Utils.writeTestResult(getCurrentTimeStamp() +"Test Four >> Lunch Request NOT OK");
            throw e;
        }
    }

    @Test(priority = 6, enabled = false)
    public void Toil_Request_Remove_Test() throws IOException, InterruptedException {

        Toil_Request_Remove actions6 = new Toil_Request_Remove(driver);
        try {
            actions6.Toil_Request_Remove_Test();
            Utils.writeTestResult(getCurrentTimeStamp() +"Toil Request Remove");
        } catch (Exception e) {
            Utils.writeTestResult(getCurrentTimeStamp() +"Cant Remove Toil Request");
            throw e;
        }
    }



}
