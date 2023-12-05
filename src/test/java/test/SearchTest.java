package test;

import app.view.HomeView;
import app.view.SearchView;
import base.TestLogIn;
import org.testng.annotations.Test;

public class SearchTest extends TestLogIn {
    @Test(description = "Search and get post with most UpVotes")
    public void searchPost() {
        new HomeView(driver)
                .navigateOnHome()
                .clickSearch();
        new SearchView(driver)
                .inputSearch("Banking");
    }
}
