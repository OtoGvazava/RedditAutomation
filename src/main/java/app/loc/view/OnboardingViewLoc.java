package app.loc.view;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public interface OnboardingViewLoc {
    By onboardingScreen = AppiumBy.xpath("//android.view.View[@resource-id=\"onboarding_screen\"]");
    By buttonLogin = AppiumBy.xpath("//android.widget.TextView[@resource-id=\"onboarding_log_in\"]");
    By frameAccounts = AppiumBy.xpath("//android.widget.LinearLayout[@resource-id=\"com.reddit.frontpage:id/bottomsheet_frame\"]");
    String frameAccountsAccount = "//android.widget.TextView[@resource-id=\"com.reddit.frontpage:id/account_name\" and @text=\"u/%s\"]";
    By frameAccountsButtonAddAccounts = AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.reddit.frontpage:id/account_name\" and @text=\"Add account\"]");
}
