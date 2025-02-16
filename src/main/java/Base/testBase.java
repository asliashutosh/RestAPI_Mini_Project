package Base;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.restassured.RestAssured;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import utils.ExtentManager;

import java.lang.reflect.Method;

public class testBase {

    public static ExtentReports extent;
    public static ExtentTest test;

    public static Logger log = LogManager.getLogger(testBase.class);


    @BeforeClass
    public void RestassuredSetup()
    {
        RestAssured.useRelaxedHTTPSValidation();
    }


    @BeforeMethod
    public void setup() throws Exception
    {
        extent = ExtentManager.getInstance("reports/Extent_demo.html");

        BasicConfigurator.configure();

    }

    @BeforeMethod
    public void startTest(Method method)
    {

        test = extent.startTest(method.getName());
    }


    @AfterMethod
    public void tearDown(ITestResult result)
    {
        if(result.getStatus()==ITestResult.SUCCESS)
            test.log(LogStatus.PASS, "Test case got passed");
        else if(result.getStatus()==ITestResult.FAILURE)
        {
//			ScreenShots.takeScreenShot(driver, result.getName());
            test.log(LogStatus.FAIL, "Test case got failed");
        }

        else{
            test.log(LogStatus.PASS, "Test Passed");
        }
        extent.flush();
        log.info("Testcase "+ result.getName() + " ended");

    }
}
