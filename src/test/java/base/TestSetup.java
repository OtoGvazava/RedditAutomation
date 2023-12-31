package base;

import data.ProjectProperties;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import lombok.SneakyThrows;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.net.URL;

public class TestSetup {
    protected static AndroidDriver driver;

    @SneakyThrows
    @BeforeSuite
    public void setUp() {
        UiAutomator2Options options = new UiAutomator2Options()
                .setUdid(ProjectProperties.EMULATOR_ID)
                .setApp(ProjectProperties.APK_PATH)
                .setAppPackage(ProjectProperties.APP_PACKAGE)
                .setAppActivity(ProjectProperties.APP_ACTIVITY);

        driver = new AndroidDriver(new URL(ProjectProperties.APPIUM_URL), options);
    }

    @AfterSuite
    public void tearDown() {
        driver.quit();
    }
}