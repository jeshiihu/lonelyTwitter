package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by Jess on 2016-09-15.
 */
public abstract class Mood
{
    private Date m_date;

    public Mood()
    {
        this.m_date = new Date();
    }

    public Mood(Date date)
    {
        this.m_date = date;
    }

    public Date GetDate()
    {
        return this.m_date;
    }

    public void SetDate(Date date)
    {
        this.m_date = date;
    }

    public abstract String GetMoodString();
}
