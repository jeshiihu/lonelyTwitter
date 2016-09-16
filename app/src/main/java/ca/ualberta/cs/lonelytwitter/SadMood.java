package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by Jess on 2016-09-15.
 */
public class SadMood extends Mood
{
    public SadMood()
    {
        super();
    }

    public SadMood(Date date)
    {
        super(date);
    }

    public String GetMoodString()
    {
        return "I am sad :(";
    }
}
