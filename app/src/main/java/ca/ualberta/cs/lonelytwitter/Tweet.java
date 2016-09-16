package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Jess on 2016-09-15.
 */
public abstract class Tweet implements Tweetable
{
    // constructors
    public Tweet(String sMessage)
    {
        this.m_sMessage = sMessage;
        this.m_Date     = new Date();
        this.m_rgMoods  = new ArrayList<Mood>();
    }

    public Tweet(String sMessage, Date date)
    {
        this.m_sMessage = sMessage;
        this.m_Date     = date;
        this.m_rgMoods  = new ArrayList<Mood>();
    }

    public Tweet(String sMessage, Date date, ArrayList<Mood> rgMoods)
    {
        this.m_sMessage = sMessage;
        this.m_Date     = date;
        this.m_rgMoods  = rgMoods;
    }

    // members
    private String m_sMessage;
    private Date   m_Date;
    private ArrayList<Mood> m_rgMoods;

    // public getters and setters
    public String GetMessage()
    {
        return m_sMessage;
    }

    public void SetMessage(String sMessage) throws TweetTooLongException {
        if(sMessage.length() > 140)
        {
            throw new TweetTooLongException();
        }

        this.m_sMessage = sMessage;
    }

    public Date GetDate()
    {
        return m_Date;
    }

    public void SetDate(Date date)
    {
        this.m_Date = date;
    }

    public abstract Boolean IsImportant();

    public void SetMoods(ArrayList<Mood> rgMoods)
    {
        this.m_rgMoods = rgMoods;
    }

    public ArrayList<Mood> GetMoods()
    {
        return this.m_rgMoods;
    }
}
