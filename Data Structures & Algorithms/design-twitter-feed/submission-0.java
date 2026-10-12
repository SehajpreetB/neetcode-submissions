class Twitter {
    int seq;
    PriorityQueue<Tweet> tweets;
    Map<Integer,Set<Integer>> usersFollowed;

    class Tweet{
        int id;
        int userId;
        int order;
        Tweet(int id,int userId,int order){
            this.id=id;
            this.userId=userId;
            this.order=order;
        }
    }

    public Twitter() {
        this.seq=0;
        this.tweets=new PriorityQueue<>((a,b)->(b.order-a.order));
        this.usersFollowed=new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        this.seq++;
        Tweet tweet=new Tweet(tweetId,userId,seq);
        tweets.offer(tweet);
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> feed=new ArrayList<>();
        Stack<Tweet> temp=new Stack<>();
        Set<Integer> ids=usersFollowed.getOrDefault(userId,new HashSet<>());
        ids.add(userId);
        while(!tweets.isEmpty()){
            Tweet tweet= tweets.poll();
            temp.push(tweet);
            if(ids.contains(tweet.userId)){
                feed.add(tweet.id);
            }
            if(feed.size()==10) break;
        }
        while(!temp.isEmpty()){
            tweets.offer(temp.pop());
        }
        return feed;
    }
    
    public void follow(int followerId, int followeeId) {
        Set<Integer> set = usersFollowed.getOrDefault(followerId, new HashSet<>());
        set.add(followeeId);
        usersFollowed.put(followerId, set);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (followerId == followeeId) {
            return;
        }
        if (usersFollowed.containsKey(followerId)) {
            Set<Integer> set = usersFollowed.get(followerId);
            set.remove(followeeId);
        }
    }
}
