package app.records;

public record Post(String name, String user, String postedAt, int numberOfUpVotes, int numberOfComments) {
}
