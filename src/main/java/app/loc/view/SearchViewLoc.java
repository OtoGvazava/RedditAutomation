package app.loc.view;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public interface SearchViewLoc {
    By inputSearch = AppiumBy.xpath("//android.widget.EditText[@resource-id=\"com.reddit.frontpage:id/search\"]");
    By textSearchPrompt = AppiumBy.xpath("//android.widget.TextView[@resource-id=\"query_prompt_text\"]");
    By buttonSort = AppiumBy.xpath("(//android.view.View[@resource-id=\"search_filter_button\"])[1]/android.widget.Button");
    String radioButtonSortBy = "//android.widget.Button[@content-desc=\"Sort by %s\"]";
    By posts = AppiumBy.xpath("//android.view.View[@resource-id=\"feed_lazy_column\"]/android.view.View");
}
