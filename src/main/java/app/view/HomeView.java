package app.view;

import app.layout.MainLayout;
import app.loc.view.HomeViewLoc;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomeView extends MainLayout<HomeView> implements HomeViewLoc {
    public HomeView(AndroidDriver driver) {
        super(driver);
        new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.presenceOfElementLocated(navHome));
    }
}
