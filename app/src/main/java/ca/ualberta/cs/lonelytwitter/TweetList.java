package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Jess on 2016-09-29.
 */

public class TweetList {

    private ArrayList<Tweet> tweets = new ArrayList<Tweet>();

    public TweetList()
    {

    }

    public Tweet getTweet(int index){
        return tweets.get(index);
    }

    public Boolean hasTweet(Tweet tweet){
        return tweets.contains(tweet);
    }

    // gross way should overwrite array
    public void add(Tweet tweet) throws Exception {
        if(tweets.contains(tweet))
            throw new IllegalArgumentException();

        if(!tweets.isEmpty())
        {
            Date dateLast = tweets.get(tweets.size()-1).getDate();
            Date dateWantToAdd = tweet.getDate();
            if(dateLast.after(dateWantToAdd))
            {
                Tweet tweetTemp = tweets.get(tweets.size()-1);
                tweets.remove(tweets.size()-1);
                tweets.add(tweet);
                tweets.add(tweetTemp);
            }
            else
                tweets.add(tweet);
        }
        else
            tweets.add(tweet);
    }

    public void delete(Tweet tweet) {
        tweets.remove(tweet);
    }

    public int getCount() {
        return tweets.size();
    }
}
