package ca.ualberta.cs.lonelytwitter;

import android.test.ActivityInstrumentationTestCase2;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Jess on 2016-09-29.
 */

public class TweetListTest extends ActivityInstrumentationTestCase2 {

    public TweetListTest() {
        super(ca.ualberta.cs.lonelytwitter.LonelyTwitterActivity.class);
    }

    public void testAddTweet() throws Exception{
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("adding tweet");
        tweets.add(tweet);

        assertTrue(tweets.hasTweet(tweet));
    }

    public void testAddTweetIllegalDuplicate() throws Exception{
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("adding tweet duplicate");
        Boolean caught = Boolean.FALSE;

        try{
            tweets.add(tweet);
            tweets.add(tweet);
        } catch(IllegalArgumentException e) {
            caught = Boolean.TRUE;
        }

        assertTrue(caught);
    }

    public void testDeleteTweet() throws Exception{
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("remove me");
        tweets.add(tweet);
        tweets.delete(tweet);

        assertFalse(tweets.hasTweet(tweet));
    }

    public void testGetTweet() throws Exception{
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("Get me");
        tweets.add(tweet);
        Tweet returnedTweet = tweets.getTweet(0);

        assertEquals(returnedTweet.getMessage(), tweet.getMessage());
    }

    public void testGetTweetChronilogicalSort() throws Exception{
        TweetList tweets = new TweetList();

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        Tweet tweetOld = new NormalTweet("Need to be 1st");
        Date dateOld = format.parse("2001-12-0");
        tweetOld.setDate(dateOld);

        Tweet tweetNew = new NormalTweet("need to be 3nd");
        Date dateNew = format.parse("2016-12-13");
        tweetNew.setDate(dateNew);

        Tweet tweetMiddle = new NormalTweet("need to be 2nd");
        Date dateMiddle = format.parse("2010-09-01");
        tweetNew.setDate(dateNew);

        tweets.add(tweetNew);
        tweets.add(tweetOld);
        tweets.add(tweetMiddle);

        assertEquals(tweets.getTweet(0).getMessage(), tweetOld.getMessage());
        assertEquals(tweets.getTweet(1).getMessage(), tweetMiddle.getMessage());
        assertEquals(tweets.getTweet(2).getMessage(), tweetNew.getMessage());
    }

    public void testHasTweet() throws Exception{
        TweetList list = new TweetList();
        Tweet tweet = new NormalTweet("test");
        list.add(tweet);

        assertTrue(list.hasTweet(tweet));
    }

    public void testCount() throws Exception {
        TweetList tweets = new TweetList();
        Tweet tweet0 = new NormalTweet("test");
        Tweet tweet1 = new NormalTweet("test");
        Tweet tweet2 = new NormalTweet("test");
        Tweet tweet3 = new NormalTweet("test");

        tweets.add(tweet0);
        tweets.add(tweet1);
        tweets.add(tweet2);
        tweets.add(tweet3);

        assertEquals(tweets.getCount(), 4);

    }
}
