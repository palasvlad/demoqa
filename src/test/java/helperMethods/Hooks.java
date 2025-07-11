package helperMethods;

import logger.LoggerUtility;
import org.openqa.selenium.bidi.log.Log;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Hooks extends SetupCommon {
    public String testName;

    @BeforeMethod
    public void prepareEnvirnoment() {
        testName = this.getClass().getSimpleName();
        LoggerUtility.startTestCase(testName);
        setUp();
    }

    @AfterMethod
    public void clearEnvirnoment(ITestResult result) {
        if (result.getStatus() ==ITestResult.FAILURE){
            LoggerUtility.errorLog(result.getThrowable().getMessage());
        }
        clearBrowser();
        LoggerUtility.endTestCase(testName);
    }

}
