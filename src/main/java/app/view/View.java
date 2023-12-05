package app.view;

import io.appium.java_client.android.AndroidDriver;

public class View<T> {
    protected AndroidDriver driver;
    protected T childObject;

    protected View(AndroidDriver driver) {
        this.driver = driver;
        childObject = (T) this;
    }
}
