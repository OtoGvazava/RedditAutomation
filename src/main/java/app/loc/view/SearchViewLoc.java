package app.loc.view;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public interface SearchViewLoc {
    By inputSearch = AppiumBy.xpath("//android.widget.EditText[@resource-id=\"com.reddit.frontpage:id/search\"]");
}
