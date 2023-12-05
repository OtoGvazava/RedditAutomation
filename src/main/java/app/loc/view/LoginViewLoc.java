package app.loc.view;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public interface LoginViewLoc {
    By authPager = AppiumBy.xpath("//androidx.viewpager.widget.ViewPager[@resource-id=\"com.reddit.frontpage:id/auth_pager\"]");
    By inputUsername = AppiumBy.xpath("//android.widget.EditText[@resource-id=\"username_field\"]");
    By inputPassword = AppiumBy.xpath("//android.widget.EditText[@resource-id=\"password_field\"]");
    By buttonContinue = AppiumBy.xpath("//android.view.View[@resource-id=\"continue_button\"]//android.widget.Button");
}
