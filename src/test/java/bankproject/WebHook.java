package bankproject;

import bankproject.helper.ConfigurationHelper;
import bankproject.helper.webdriver.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

import java.io.ByteArrayInputStream;

public class WebHook {

    protected WebDriver driver;
    ConfigurationHelper config = ConfigurationHelper.instance();

    public WebDriver getDriver() {
        return driver;
    }

    @Before
    @Step("Open browser")
    public void BaseSetup() {
        Boolean isGrid = config.IsSeleniumGrid;
        String browser = config.Browser;

        driver = DriverFactory.generateDriver(browser, isGrid);
    }

    @After
    @Step("Close browser")
    public void BaseTearDown(ITestResult testResult) {
        if (!testResult.isSuccess()) {
            Allure.addAttachment("On fail screenshot", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        }

        driver.quit();
    }

    @Attachment(value = "Screenshot", type = "image/png")
    public byte[] screenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}
