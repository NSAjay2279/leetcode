public class Twitter {

    // Define a Tweet class to store tweetId and timestamp
    static class Tweet {
        int tweetId;
        int timestamp;

        Tweet(int tweetId, int timestamp) {
            this.tweetId = tweetId;
            this.timestamp = timestamp;
        }
    }

    // Define a User class to store user details, tweets, and following relationships
    static class User {
        int userId;
        int tweetCount; // To track the number of tweets
        List<Tweet> tweets = new ArrayList<>(); // List of tweets (store all tweets)

        boolean[] follows = new boolean[501]; // To track users that this user is following

        User(int userId) {
            this.userId = userId;
            this.tweetCount = 0;
        }
    }

    private User[] users;
    private int timestamp;

    // Constructor to initialize the Twitter system
    public Twitter() {
        users = new User[501]; // Users are indexed from 1 to 500
        this.timestamp = 0;

        for (int i = 1; i <= 500; i++) {
            users[i] = new User(i);
        }
    }

    // Method to post a new tweet by a user
    public void postTweet(int userId, int tweetId) {
        User user = users[userId];
        Tweet tweet = new Tweet(tweetId, timestamp++);
        // Store the tweet in the user's tweet list
        user.tweets.add(tweet);
    }

    // Method to get the 10 most recent tweets in the user's news feed
    public int[] getNewsFeed(int userId) {
        List<Tweet> newsFeed = new ArrayList<>();
        User user = users[userId];

        // Add user's own tweets
        newsFeed.addAll(user.tweets);

        // Add tweets from the users the current user is following
        for (int followeeId = 1; followeeId <= 500; followeeId++) {
            if (user.follows[followeeId]) {
                User followee = users[followeeId];
                newsFeed.addAll(followee.tweets);
            }
        }

        // Sort the tweets by timestamp in descending order
        newsFeed.sort((a, b) -> b.timestamp - a.timestamp);

        // Collect the 10 most recent tweets
        int size = Math.min(newsFeed.size(), 10);
        int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            result[i] = newsFeed.get(i).tweetId;
        }

        return result;
    }

    // Method to make one user follow another user
    public void follow(int followerId, int followeeId) {
        users[followerId].follows[followeeId] = true;
    }

    // Method to make one user unfollow another user
    public void unfollow(int followerId, int followeeId) {
        users[followerId].follows[followeeId] = false;
    }
}
