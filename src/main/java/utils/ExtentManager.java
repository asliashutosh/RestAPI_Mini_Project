package utils;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;

import java.io.File;

public class ExtentManager {
    private static ExtentReports extent;

    public static ExtentReports getInstance(String fileName) {
        if (extent == null)
        {
            extent = new ExtentReports(fileName,true,DisplayOrder.NEWEST_FIRST);

            //Loading the configuration file for the report
            extent.loadConfig(new File(System.getProperty("user.dir") + "//reportConfig.xml"));

            //Adding the system information in the reports
            extent.addSystemInfo("selenium version","4.4.0").addSystemInfo("AutomationTesting","running");
        }

        return extent;
    }
}