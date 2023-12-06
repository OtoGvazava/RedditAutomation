package app.view.layout;

import app.loc.layout.MainLayoutLoc;
import app.view.View;
import io.appium.java_client.android.AndroidDriver;

public class MainLayout<T> extends View<T> implements MainLayoutLoc {
    protected MainLayout(AndroidDriver driver) {
        super(driver);
    }

    public T navigateOnHome() {
        driver.findElement(navHome).click();

        return childObject;
    }

    public T clickSearch() {
        driver.findElement(buttonSearch).click();

        return childObject;
    }
}
