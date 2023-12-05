package app.view;

import app.loc.view.OnboardingViewLoc;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import lombok.Getter;
import org.openqa.selenium.NoSuchElementException;

public class OnboardingView extends View<OnboardingView> implements OnboardingViewLoc {
    @Getter
    private boolean alreadyLoggedIn = false;

    public OnboardingView(AndroidDriver driver) {
        super(driver);
    }

    public OnboardingView login(String username) {
        driver.findElement(buttonLogin).click();

        try {
            driver.findElement(frameAccounts);
            try {
                driver.findElement(AppiumBy.xpath(String.format(frameAccountsAccount, username))).click();
                alreadyLoggedIn = true;
            } catch (NoSuchElementException ignore) {
                driver.findElement(frameAccountsButtonAddAccounts).click();
            }
        } catch (NoSuchElementException ignore) {
        }

        return this;
    }
}