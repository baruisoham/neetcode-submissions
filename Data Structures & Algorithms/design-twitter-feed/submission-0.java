class Twitter {

    final HashMap<Integer, Set<Integer>> followingList;
    final List<int[]> posts;

    public Twitter() {
        followingList = new HashMap<>();
        posts = new ArrayList<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        posts.add(new int[]{userId, tweetId});
    }
    
    public List<Integer> getNewsFeed(int userId) {
        final Set<Integer> followers = followingList.getOrDefault(userId, new HashSet<>());
        final List<Integer> feed = new ArrayList<>();
        for(int i=posts.size()-1; i>=0; i--){
            final int[] post = posts.get(i);
            if(post[0]==userId || followers.contains(post[0])){
                feed.add(post[1]);
            }
            if (feed.size()==10) break;
        }
        return feed;
    }
    
    public void follow(int followerId, int followeeId) {
        followingList.computeIfAbsent(followerId, k-> new HashSet<>()).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        followingList.get(followerId).remove(followeeId);
    }
}
