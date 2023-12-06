package app.view;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.time.Duration;
import java.util.Arrays;

public class View<T> {
    protected AndroidDriver driver;
    protected T childObject;

    protected View(AndroidDriver driver) {
        this.driver = driver;
        childObject = (T) this;
    }

    public T scrollToElement(int startX, int startY, int endX, int endY, int actionDuration) {
        PointerInput input = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence scrollSequence = new Sequence(input, 1);

        scrollSequence.addAction(input.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), startX, startY));
        scrollSequence.addAction(input.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        scrollSequence.addAction(input.createPointerMove(Duration.ofMillis(actionDuration), PointerInput.Origin.viewport(), endX, endY));
        scrollSequence.addAction(input.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Arrays.asList(scrollSequence));

        return childObject;
    }
}
