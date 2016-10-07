package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

/**
 * Created by Jess on 2016-09-29.
 */
public class TweetList {

    private ArrayList<Tweet> tweets = new ArrayList<Tweet>();

    /**
     * Instantiates a new Tweet list.
     */
    public TweetList()
    {

    }

    /**
     * Get tweet tweet.
     *
     * @param index the index
     * @return the tweet
     */
    public Tweet getTweet(int index){
        return tweets.get(index);
    }

    /**
     * Has tweet boolean.
     *
     * @param tweet the tweet
     * @return the boolean
     */
    public Boolean hasTweet(Tweet tweet){
        return tweets.contains(tweet);
    }

    /**
     * Add.
     *
     * @param tweet the tweet
     * @throws Exception the exception
     */
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

    /**
     * Delete.
     *
     * @param tweet the tweet
     */
    public void delete(Tweet tweet) {
        tweets.remove(tweet);
    }

    /**
     * Gets count.
     *
     * @return the count
     */
    public int getCount() {
        return tweets.size();
    }
}
