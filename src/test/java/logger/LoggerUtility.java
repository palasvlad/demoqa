package logger;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;

public class LoggerUtility {

    private static final Logger logger = LogManager.getLogger();

    private static final String suiteLogsPath = "target/logs/suite/";
    private static final String regressionLogsPath = "target/logs/";

    public static synchronized void startTestCase(String testName) {
        ThreadContext.put("testName", testName);
        logger.info("=============== Execution Started: " + testName + " ===============");
        ThreadContext.put("threadName", testName);
    }

    public static synchronized void endTestCase(String testName) {
        logger.info("=============== Execution Finished: " + testName + " ===============");
    }

    public static synchronized void infoLog(String message) {
        logger.info(Thread.currentThread().getName() + ":" + getCallInfo() + message);
    }

    public static synchronized void errorLog(String message) {
        logger.error(Thread.currentThread().getName() + ":" + getCallInfo() + message);

    }

    private static synchronized String getCallInfo() {
        String className = Thread.currentThread().getStackTrace()[2].getClassName();
        String methodName = Thread.currentThread().getStackTrace()[2].getMethodName();
        return className + ":" + methodName + " ===> ";
    }

}