package test;

import app.records.Post;
import app.view.view.HomeView;
import app.view.view.SearchView;
import base.TestLogIn;
import data.SortBy;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;

public class SearchTest extends TestLogIn {
    @Test(description = "Search and get post with most UpVotes")
    public void searchPost() {
        new HomeView(driver)
                .navigateOnHome()
                .clickSearch();
        SearchView searchView = new SearchView(driver)
                .inputSearch("Banking")
                .sortBy(SortBy.HOT);
        List<Post> first20Post = searchView.getFirst20Post();
        first20Post.sort(Comparator.comparingInt(Post::numberOfUpVotes).reversed());
        Post mostUpVoted = first20Post.get(0);
        System.out.printf("""
                Post name: %s
                Post by: %s
                Posted %s
                Number of comments: %d
                """, mostUpVoted.name(), mostUpVoted.user(), mostUpVoted.postedAt(), mostUpVoted.numberOfComments());
    }
}
