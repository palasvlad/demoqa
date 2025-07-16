package helperMethods;

import com.aventstack.extentreports.Status;
import extentUtility.ExtentReportManager;
import logger.LoggerUtility;
import org.openqa.selenium.bidi.log.Log;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class Hooks extends SetupCommon {
    public String testName;

    @BeforeSuite
    public void setupReport(){
        ExtentReportManager.initReport("testReport");
    }

    @BeforeMethod
    public void prepareEnvirnoment() {
        testName = this.getClass().getSimpleName();
        LoggerUtility.startTestCase(testName);
        setUp();
        ExtentReportManager.createTest(testName);
    }

    @AfterMethod
    public void clearEnvirnoment(ITestResult result) {
        if (result.getStatus() ==ITestResult.FAILURE){
            LoggerUtility.errorLog(result.getThrowable().getMessage());
            ExtentReportManager.log(Status.FAIL, result.getThrowable().getMessage());
        }
        clearBrowser();
        LoggerUtility.endTestCase(testName);
        ExtentReportManager.endTest();
    }

    @AfterSuite
    public void teardown(){
        ExtentReportManager.flushReport();
    }

}
