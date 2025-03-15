package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");

        for (int i = 1; i <= 5; i++) {
            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
            System.out.println("i = " + i);


//            package Test_Runner;
//
//import All_The_Happy_Path_Test_Cases_For_BD.*;
//import Setup_All.Setup;
//import Setup_All.Utils;
//import org.openqa.selenium.WebDriver;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.DataProvider;
//import org.testng.annotations.Test;
//import java.io.IOException;

//            public class All_Test_Cases extends Setup {
//
//                // ✅ DataProvider for running Tests 1-5 with multiple emails
//                @DataProvider(name = "userEmails")
//                public Object[][] getUserEmails() {
//                    String userEmails = getConfigData("userEmail"); // Fetch emails from config
//                    String[] emails = userEmails.split(","); // Split by comma
//                    Object[][] data = new Object[emails.length][1];
//                    for (int i = 0; i < emails.length; i++) {
//                        data[i][0] = emails[i].trim(); // Store emails in test data
//                    }
//                    return data;
//                }
//
//                // ✅ Test 1: Clock-in for BD Employees
//                @Test(priority = 1, enabled = true, dataProvider = "userEmails")
//                public void Bangladeshi_Employees_Attendance(String email) throws IOException, InterruptedException {
//                    Login_Page loginPage = new Login_Page(driver);
//                    loginPage.dologin(email, getConfigData("password"));
//
//                    Bangladeshi_Employee_Clock_IN actions = new Bangladeshi_Employee_Clock_IN(driver);
//                    try {
//                        actions.SingleEmployeeAttendance();
//                        Utils.writeTestResult(email + " >> Clock-in OK for BD Employees");
//                    } catch (Exception e) {
//                        Utils.writeTestResult(email + " >> Clock-in NOT OK for BD Employees");
//                        throw e;
//                    }
//                }
//
//                // ✅ Test 2: Correction Request
//                @Test(priority = 2, enabled = true, dataProvider = "userEmails")
//                public void Correction_Request_Test(String email) throws IOException, InterruptedException {
//                    Login_Page loginPage = new Login_Page(driver);
//                    loginPage.dologin(email, getConfigData("password"));
//
//                    Correction_Request actions2 = new Correction_Request(driver);
//                    try {
//                        actions2.Correction_Request_Test();
//                        Utils.writeTestResult(email + " >> Correction Request OK");
//                    } catch (Exception e) {
//                        Utils.writeTestResult(email + " >> Correction Request NOT OK");
//                        throw e;
//                    }
//                }
//
//                // ✅ Test 3: Leave Request
//                @Test(priority = 3, enabled = true, dataProvider = "userEmails")
//                public void Leave_Request_Test(String email) throws IOException, InterruptedException {
//                    Login_Page loginPage = new Login_Page(driver);
//                    loginPage.dologin(email, getConfigData("password"));
//
//                    Leave_Request actions5 = new Leave_Request(driver);
//                    try {
//                        actions5.applyAndWithdrawLeave();
//                        Utils.writeTestResult(email + " >> All Type Leave Request OK");
//                    } catch (Exception e) {
//                        Utils.writeTestResult(email + " >> Leave Request NOT OK");
//                        throw e;
//                    }
//                }
//
//                // ✅ Test 4: Toil Request
//                @Test(priority = 4, enabled = true, dataProvider = "userEmails")
//                public void Toil_Request_Test(String email) throws IOException, InterruptedException {
//                    Login_Page loginPage = new Login_Page(driver);
//                    loginPage.dologin(email, getConfigData("password"));
//
//                    Toil_Request actions3 = new Toil_Request(driver);
//                    try {
//                        actions3.Toil_Request_Test();
//                        Utils.writeTestResult(email + " >> Toil Request OK");
//                    } catch (Exception e) {
//                        Utils.writeTestResult(email + " >> Toil Request NOT OK");
//                        throw e;
//                    }
//                }
//
//                // ✅ Test 5: Lunch Request
//                @Test(priority = 5, enabled = true, dataProvider = "userEmails")
//                public void Lunch_Request_Test(String email) throws IOException, InterruptedException {
//                    Login_Page loginPage = new Login_Page(driver);
//                    loginPage.dologin(email, getConfigData("password"));
//
//                    Lunch_Request actions4 = new Lunch_Request(driver);
//                    try {
//                        actions4.Lunch_Request_Test();
//                        Utils.writeTestResult(email + " >> Lunch Request OK");
//                    } catch (Exception e) {
//                        Utils.writeTestResult(email + " >> Lunch Request NOT OK");
//                        throw e;
//                    }
//                }
//
//                // ✅ Test 6: Toil Request Remove (Runs Separately, Not Using Multiple Emails)
//                @Test(priority = 6, enabled = true)
//                public void Toil_Request_Remove_Test() throws IOException, InterruptedException {
//                    Login_Page loginPage = new Login_Page(driver);
//                    loginPage.dologin(getConfigData("userEmail"), getConfigData("password")); // Only one login
//
//                    Toil_Request_Remove actions6 = new Toil_Request_Remove(driver);
//                    try {
//                        actions6.Toil_Request_Remove_Test();
//                        Utils.writeTestResult("Toil Request Remove");
//                    } catch (Exception e) {
//                        Utils.writeTestResult("Cant Remove Toil Request");
//                        throw e;
//                    }
//                }
//
//                // ✅ After Method to Close WebDriver
//                @AfterMethod
//                public void tearDown() {
//                    if (driver != null) {
//                        driver.quit();
//                        System.out.println("Closed WebDriver after test execution.");
//                    }
//                }
//            }




        }
    }
}