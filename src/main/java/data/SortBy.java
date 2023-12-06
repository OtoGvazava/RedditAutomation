package data;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SortBy {
    MOST_RELEVANT("Most relevant"),
    HOT("Hot"),
    NEW("New"),
    TOP("Top"),
    COMMENT_COUNT("Comment count");

    private final String text;
}
