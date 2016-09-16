package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by Jess on 2016-09-15.
 */
public class HappyMood extends Mood
{
    public HappyMood()
    {
        super();
    }

    public HappyMood(Date date)
    {
        super(date);
    }

    public String GetMoodString()
    {
        return "I am happy :)";
    }
}
