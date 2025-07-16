package extentUtility;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;

public class ExtentReportManager {

    private static ExtentReports extent;
    private static ExtentSparkReporter sparkReporter;
    private static final ThreadLocal<ExtentTest> testThread = new ThreadLocal<>();
    private static final ConcurrentHashMap<Long, ExtentTest> testMap = new ConcurrentHashMap<>();
    private static String reportDirectoryPath;

    // 1. Initializează fisierul HTML de raport
    public static void initReport(String baseFolder) {
        reportDirectoryPath = createFolder(baseFolder);
        sparkReporter = new ExtentSparkReporter(reportDirectoryPath + "/ExtentReport.html");
        sparkReporter.config().setReportName("Automation Test Report");
        sparkReporter.config().setDocumentTitle("Extent Report");

        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
    }

    // 2. Creează un folder nou pentru rapoarte (cu timestamp)
    public static String createFolder(String baseFolder) {
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String folderPath = baseFolder + "/Report_" + timestamp;
        File folder = new File(folderPath);
        if (!folder.exists()) {
            folder.mkdirs();
        }
        return folderPath;
    }

    // 3. Creează un ExtentTest per test/thread
    public static void createTest(String testName) {
        ExtentTest test = extent.createTest(testName);
        testThread.set(test);
        testMap.put(Thread.currentThread().getId(), test);
    }

    // 4. Închide testul curent (nu e absolut necesar, ExtentReports finalizează singur)
    public static void endTest() {
        log(Status.INFO,"Test Ended");
        testThread.remove();
    }

    // 5. Loghează informația (INFO/WARNING/FAIL etc.)
    public static void log(Status status, String details) {
        ExtentTest test = testMap.get(Thread.currentThread().getId());
        if (test != null) {
            test.log(status, details);
        }
    }


    // 6. Obține ID-ul threadului curent
    public static long getCurrentThreadId() {
        return Thread.currentThread().getId();
    }

    // 7. Capturează un screenshot și îl atașează în raport
    public static void captureScreenshot(WebDriver driver, String screenshotName) {
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String screenshotPath = reportDirectoryPath + "/" + screenshotName + ".png";
        try {
            FileUtils.copyFile(src, new File(screenshotPath));
            ExtentTest test = testMap.get(Thread.currentThread().getId());
            if (test != null) {
                test.addScreenCaptureFromPath(screenshotPath);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 8. Generează raportul final
    public static void flushReport() {
        if (extent != null) {
            extent.flush();
        }
    }
}
