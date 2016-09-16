package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Jess on 2016-09-15.
 */
public class NormalTweet extends Tweet implements Tweetable
{
    public NormalTweet(String sMessage)
    {
        super(sMessage);
    }

    public NormalTweet(String sMessage, Date date)
    {
        super(sMessage, date);
    }

    public NormalTweet(String sMessage, Date date, ArrayList<Mood> rgMoods)
    {
        super(sMessage, date, rgMoods);
    }

    @Override
    public Boolean IsImportant()
    {
        return Boolean.FALSE;
    }
}
