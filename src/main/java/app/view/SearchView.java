package app.view;

import app.loc.view.SearchViewLoc;
import io.appium.java_client.android.AndroidDriver;

public class SearchView extends View<SearchView> implements SearchViewLoc {
    public SearchView(AndroidDriver driver) {
        super(driver);
    }

    public SearchView inputSearch(String search) {
        driver.findElement(inputSearch).sendKeys(search);

        return this;
    }
}
