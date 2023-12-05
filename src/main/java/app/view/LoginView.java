package app.view;

import app.loc.view.LoginViewLoc;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginView extends View<LoginView> implements LoginViewLoc {
    public LoginView(AndroidDriver driver) {
        super(driver);
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.presenceOfElementLocated(authPager));
    }

    public LoginView inputUsername(String username) {
        driver.findElement(inputUsername).sendKeys(username);

        return this;
    }

    public LoginView inputPassword(String password) {
        driver.findElement(inputPassword).sendKeys(password);

        return this;
    }

    public LoginView clickContinue() {
        driver.findElement(buttonContinue).click();

        return this;
    }
}
