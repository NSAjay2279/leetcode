class Twitter {

    // Define constants for maximum number of feeds and users
    private static final int MAX_FEEDS = 1000;
    private static final int MAX_USERS = 1000;
    private static final int MAX_FOLLOWEES = 1000;

    // Data storage
    private int[][] feeds; // stores userId and tweetId pairs
    private int feedCount; // keeps track of the number of tweets
    private int[][] followee; // stores the list of users being followed
    private int[] followeeCount; // tracks how many users each user follows

    // Constructor to initialize the Twitter object
    public Twitter() {
        this.feeds = new int[MAX_FEEDS][2];
        this.feedCount = 0;
        this.followee = new int[MAX_USERS][MAX_FOLLOWEES];
        this.followeeCount = new int[MAX_USERS];
    }
    
    // Post a tweet for a user
    public void postTweet(int userId, int tweetId) {
        if (feedCount < MAX_FEEDS) {
            feeds[feedCount][0] = userId;
            feeds[feedCount][1] = tweetId;
            feedCount++;
        }
    }

    // Get the news feed for a user
    public int[] getNewsFeed(int userId) {
        // Create a static array to store the latest 10 tweet IDs
        int[] ans = new int[10];
        int[] followees = new int[MAX_USERS]; // stores the followees of the user
        int followeeCountForUser = 0;

        // Get the list of followees for the user
        for (int i = 0; i < followeeCount[userId]; i++) {
            followees[followeeCountForUser++] = followee[userId][i];
        }
        followees[followeeCountForUser++] = userId; // Add the user itself to their own feed

        // To check if a user is being followed or not
        boolean[] check = new boolean[MAX_USERS];
        for (int i = 0; i < followeeCountForUser; i++) {
            check[followees[i]] = true;
        }

        int c = 0;
        int i = feedCount - 1;
        int retSize = 0;

        // Iterate over the feeds in reverse order (most recent first)
        while (c < 10 && i >= 0) {
            if (check[feeds[i][0]]) {
                ans[retSize] = feeds[i][1]; // Add the tweetId to the answer
                retSize++;
                c++;
            }
            i--;
        }

        // Trim the result array to the size of valid results
        int[] result = new int[retSize];
        for (int j = 0; j < retSize; j++) {  // Changed variable from i to j
            result[j] = ans[j];
        }

        return result;
    }

    // Follow another user
    public void follow(int followerId, int followeeId) {
        followee[followerId][followeeCount[followerId]++] = followeeId;
    }

    // Unfollow a user
    public void unfollow(int followerId, int followeeId) {
        for (int i = 0; i < followeeCount[followerId]; i++) {
            if (followee[followerId][i] == followeeId) {
                for (int j = i; j < followeeCount[followerId] - 1; j++) {
                    followee[followerId][j] = followee[followerId][j + 1];
                }
                followeeCount[followerId]--;
                break;
            }
        }
    }
}
