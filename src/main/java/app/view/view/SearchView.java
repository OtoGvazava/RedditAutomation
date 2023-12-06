package app.view.view;

import app.loc.view.SearchViewLoc;
import app.records.Post;
import app.view.View;
import data.SortBy;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class SearchView extends View<SearchView> implements SearchViewLoc {
    public SearchView(AndroidDriver driver) {
        super(driver);
    }

    public SearchView inputSearch(String search) {
        WebElement inputSearchElement = driver.findElement(inputSearch);
        inputSearchElement.sendKeys(search);
        driver.findElement(textSearchPrompt).click();

        return this;
    }

    public SearchView sortBy(SortBy sortBy) {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(buttonSort));
        driver.findElement(buttonSort).click();
        driver.findElement(AppiumBy.xpath(String.format(radioButtonSortBy, sortBy.getText()))).click();

        return this;
    }

    public List<WebElement> getPosts() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.numberOfElementsToBeMoreThan(posts, 1));
        return driver.findElements(posts);
    }

    private Post handlePostElement(WebElement element) {
        String content = element.getAttribute("content-desc");
        String[] splitContent = content.split(",");

        String name = splitContent[0];

        String userPostedAt = splitContent[1];
        String[] splitUserPostedAt = userPostedAt.split(" ");
        String user = splitUserPostedAt[3];
        String postedAt = splitUserPostedAt[4] + " " + splitUserPostedAt[5] + " " + splitUserPostedAt[6];

        String upVoteComment = splitContent[2];
        String[] splitUpVoteComment = upVoteComment.split(" ");
        String upVote = splitUpVoteComment[1];
        String comment;

        int numberOfUpVotes;
        if (upVote.contains(".")) {
            String[] splitUpVote = upVote.split("\\.");
            numberOfUpVotes = (Integer.parseInt(splitUpVote[0]) * 1000) + (Integer.parseInt(splitUpVote[1]) * 100);

            comment = splitUpVoteComment[5];
        } else {
            numberOfUpVotes = Integer.parseInt(upVote);

            comment = splitUpVoteComment[4];
        }

        int numberOfComments;
        if (comment.contains(".")) {
            String[] splitComment = comment.split("\\.");
            numberOfComments = (Integer.parseInt(splitComment[0]) * 1000) + (Integer.parseInt(splitComment[1]) * 100);
        } else numberOfComments = Integer.parseInt(comment);

        return new Post(name, user, postedAt, numberOfUpVotes, numberOfComments);
    }

    private SearchView scrollLastPostToFirst(WebElement firstPostElement, WebElement lastPostElement, int duration) {
        int startX = lastPostElement.getLocation().getX();
        int startY = lastPostElement.getLocation().getY();
        int endX = startX;
        int endY = firstPostElement.getLocation().getY();

        return scrollToElement(startX, startY, endX, endY, duration);
    }

    public List<Post> getFirst20Post() {
        List<Post> first20Post = new ArrayList<>();

        while (first20Post.size() < 20) {
            List<WebElement> elements = getPosts();
            elements.forEach(element -> {
                if (first20Post.size() < 20) {
                    first20Post.add(handlePostElement(element));
                }
            });

            if (first20Post.size() < 20) {
                scrollLastPostToFirst(elements.get(0), elements.get(elements.size() - 1), 1000);
            } else return first20Post;
        }

        return first20Post;
    }
}
