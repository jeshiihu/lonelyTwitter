package ca.ualberta.cs.lonelytwitter;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.widget.TextView;

public class EditTweetActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_tweet);

        Bundle extras = getIntent().getExtras();
        Tweet tweet = (Tweet)extras.getSerializable("tweet");

        TextView textBody = (TextView)findViewById(R.id.TweetBody);
        textBody.setText(tweet.getMessage());

        TextView textDate = (TextView)findViewById(R.id.TweetDate);
        textDate.setText(tweet.getDate().toString());
    }
}
