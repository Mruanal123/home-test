package base;

import java.io.File;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.HomePageObjects;
import utils.Constants;

public class BaseTest {
    public static WebDriver driver;
    public ExtentSparkReporter sparkReporter;
    public static ExtentReports extent;  // Changed to static to share across multiple classes
    public ExtentTest logger;

    // This method is executed before the suite starts, it sets up the ExtentReports for generating test execution reports.
    @BeforeSuite
    public void beforeSuite() {
        // Ensuring the ExtentReports is initialized only once for the entire suite
        if (extent == null) {
            System.out.println("Initializing ExtentReports...");
            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + File.separator + "reports"
                    + File.separator + "AutomationTestRunReport_" + timestamp + ".html");
            extent = new ExtentReports();
            extent.attachReporter(sparkReporter);
            sparkReporter.config().setTheme(Theme.DARK);
            extent.setSystemInfo("HostName", "Mrunal");
            extent.setSystemInfo("Username", "root");
            sparkReporter.config().setDocumentTitle("Automation Test Report");
            sparkReporter.config().setReportName("Automation Test Report");
        }
    }

    // This method is executed before each test method, it initializes the WebDriver and the ExtentTest for each test.
    @BeforeMethod
    @Parameters("browser")
    public void beforeMethod(@Optional("chrome") String browser, Method method) {
        // Ensuring that ExtentReports is initialized before use
        if (extent == null) {
            throw new IllegalStateException("ExtentReports is not initialized!");
        }

        logger = extent.createTest(method.getName());  // Initialize the test logger for ExtentReports
        setupDriver(browser);  // Initialize the WebDriver (browser) based on the parameter
        driver.manage().window().maximize();
        driver.get(Constants.url);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(HomePageObjects.loginPageLink)));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));  // Add implicit wait
    }

    // This method is executed after each test method, it logs the result in the Extent report based on the test status.
    @AfterMethod
    public void afterMethod(ITestResult result) {
        if (logger == null) {
            throw new IllegalStateException("ExtentTest is not initialized!");
        }

        switch (result.getStatus()) {
        case ITestResult.FAILURE:
            logger.log(Status.FAIL,
                    MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));
            logger.log(Status.FAIL,
                    MarkupHelper.createLabel(result.getThrowable() + " - Test Case Failed", ExtentColor.RED));
            break;
        case ITestResult.SKIP:
            logger.log(Status.SKIP,
                    MarkupHelper.createLabel(result.getName() + " - Test Case Skipped", ExtentColor.ORANGE));
            break;
        case ITestResult.SUCCESS:
            logger.log(Status.PASS,
                    MarkupHelper.createLabel(result.getName() + " - Test Case Passed", ExtentColor.GREEN));
            break;
        default:
            logger.log(Status.WARNING,
                    MarkupHelper.createLabel(result.getName() + " - Test Case Status Unknown", ExtentColor.YELLOW));
            break;
        }
        driver.quit();  // Quit the browser after each method.
    }

    // This method is executed after the suite completes, it flushes the ExtentReports to save all test results into the report.
    @AfterClass
    public void afterClass() {
        // Ensure extent is not null before flushing the report
        if (extent != null) {
            System.out.println("Flushing ExtentReports...");
            extent.flush();  // Write the results to the report
        } else {
            System.out.println("ExtentReports was not initialized!");
        }
    }

    // This method sets up the WebDriver based on the browser type passed as a parameter.
    public void setupDriver(String browser) {
        switch (browser.toLowerCase()) {
        case "chrome":
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            break;
        case "firefox":
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            break;
        case "edge":
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
            break;
        default:
            throw new IllegalArgumentException("Unsupported browser: " + browser);
        }
    }
}
