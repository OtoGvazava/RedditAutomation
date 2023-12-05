package base;

import data.ProjectProperties;
import app.view.LoginView;
import app.view.OnboardingView;
import org.testng.annotations.BeforeTest;

public class TestLogIn extends TestSetup {
    @BeforeTest
    public void logIn() {
        boolean alreadyLoggedIn = new OnboardingView(driver)
                .login(ProjectProperties.USERNAME)
                .isAlreadyLoggedIn();
        if (!alreadyLoggedIn) {
            new LoginView(driver)
                    .inputUsername(ProjectProperties.USERNAME)
                    .inputPassword(ProjectProperties.PASSWORD)
                    .clickContinue();
        }
    }
}