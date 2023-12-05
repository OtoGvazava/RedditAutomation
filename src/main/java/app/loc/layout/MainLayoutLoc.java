package app.loc.layout;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public interface MainLayoutLoc {
    By navHome = AppiumBy.xpath("(//android.widget.ImageView[@resource-id=\"com.reddit.frontpage:id/bottom_nav_item_icon\"])[1]");
    By buttonSearch = AppiumBy.xpath("//android.widget.ImageButton[@content-desc=\"Search\"]");
}
