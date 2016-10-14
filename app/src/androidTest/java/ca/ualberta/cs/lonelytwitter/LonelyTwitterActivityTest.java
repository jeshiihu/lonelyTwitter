package ca.ualberta.cs.lonelytwitter;

import android.app.Activity;
import android.test.ActivityInstrumentationTestCase2;
import android.util.Log;
import android.widget.EditText;
import android.widget.ListView;

import com.robotium.solo.Solo;

import junit.framework.TestCase;

/**
 * Created by wz on 14/09/15.
 */
public class LonelyTwitterActivityTest extends ActivityInstrumentationTestCase2<LonelyTwitterActivity> {

    private Solo solo;
    /**
     * Instantiates a new Lonely twitter activity test.
     */
    public LonelyTwitterActivityTest() {
        super(ca.ualberta.cs.lonelytwitter.LonelyTwitterActivity.class);
    }

    /**
     * Test start.
     *
     * @throws Exception the exception
     */
    public void testStart() throws Exception {
        Log.d("TAG1", "setUp()");
        Activity activity = getActivity();
    }

    public void setUp() throws Exception {
        solo = new Solo(getInstrumentation(), getActivity());
    }

//    @BeforeClass: run once before all tests, after is like clean up
    public void testTweet(){
        solo.assertCurrentActivity("Wrong Activity!", LonelyTwitterActivity.class);
        solo.clickOnButton("Clear");

        solo.enterText((EditText)solo.getView(R.id.body), "Test Tweet!");
        solo.clickOnButton("Save");
        solo.clearEditText((EditText)solo.getView(R.id.body));

        assertTrue(solo.waitForText("Test Tweet!"));

        solo.clickOnButton("Clear");
        assertFalse(solo.waitForText("Test Tweet!"));
    }

    public void testClickTweetList(){
        LonelyTwitterActivity activity = (LonelyTwitterActivity) solo.getCurrentActivity();

        solo.assertCurrentActivity("Wrong Activity!", LonelyTwitterActivity.class);
        solo.clickOnButton("Clear");

        solo.enterText((EditText)solo.getView(R.id.body), "Test Tweet!");
        solo.clickOnButton("Save");

        // initially fails since after save, it takes a while to input into the list
        solo.waitForText("Test Tweet!");

        final ListView oldTweetsList = activity.getOldTweetsList();
        Tweet tweet = (Tweet)oldTweetsList.getItemAtPosition(0);
        assertEquals("Test Tweet!", tweet.getMessage());

        solo.clickInList(0);

        solo.assertCurrentActivity("Wrong Activity", EditTweetActivity.class);

        assertTrue(solo.waitForText("New Activity!"));

        //same as hitting back button on device
        solo.goBack();
        solo.assertCurrentActivity("Wrong Activity", LonelyTwitterActivity.class);
    }

    public void testEditActivity(){
        LonelyTwitterActivity activity = (LonelyTwitterActivity) solo.getCurrentActivity();

        solo.assertCurrentActivity("Wrong Activity!", LonelyTwitterActivity.class);
        solo.clickOnButton("Clear");

        solo.enterText((EditText)solo.getView(R.id.body), "Test Tweet!");
        solo.clickOnButton("Save");

        // initially fails since after save, it takes a while to input into the list
        solo.waitForText("Test Tweet!");

        final ListView oldTweetsList = activity.getOldTweetsList();
        Tweet tweet = (Tweet)oldTweetsList.getItemAtPosition(0);
        assertEquals("Test Tweet!", tweet.getMessage());

        solo.clickInList(0);

        solo.assertCurrentActivity("Wrong Activity", EditTweetActivity.class);

        assertTrue(solo.waitForText("New Activity!"));

        // TEST EDIT INFO
        assertTrue(solo.waitForText(tweet.getMessage()));
        assertTrue(solo.waitForText(tweet.getDate().toString()));
    }

    @Override
    public void tearDown() throws Exception {
        solo.finishOpenedActivities();
    }
}