package com.mytaxi.android_demo;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.Espresso;
import android.support.test.espresso.IdlingPolicies;
import android.support.test.espresso.PerformException;
import android.support.test.espresso.UiController;
import android.support.test.espresso.ViewAction;
import android.support.test.espresso.matcher.RootMatchers;
import android.support.test.espresso.util.HumanReadables;
import android.support.test.espresso.util.TreeIterables;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;

import com.mytaxi.android_demo.activities.AuthenticationActivity;
import com.mytaxi.android_demo.activities.MainActivity;

import org.hamcrest.Matcher;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.RootMatchers.isDialog;
import static android.support.test.espresso.matcher.RootMatchers.withDecorView;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.isRoot;
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertEquals;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {


    @Rule
    public ActivityTestRule<MainActivity> mActivityRule =
            new ActivityTestRule<>(MainActivity.class);

    private MainActivity mActivity = null;

    @Before
    public void setActivity() {
        mActivity = mActivityRule.getActivity();
    }

    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.mytaxi.android_demo", appContext.getPackageName());
    }

    @Test
    public void testLogin() throws InterruptedException {
        onView(withId(R.id.edt_username))
                .perform(typeText("crazydog335"), closeSoftKeyboard());
        onView(withId(R.id.edt_password))
                .perform(typeText("venture"), closeSoftKeyboard());
        onView(withId(R.id.btn_login))
                .perform(click());

        Thread.sleep(2000);
        onView(allOf(withId(R.id.textSearch), isDisplayed()))
                .perform(typeText("sa"),closeSoftKeyboard());
        onView(withText("Sarah Scott"))
                .inRoot(withDecorView(not(is(mActivity.getWindow().getDecorView()))))
                .perform(click());
        onView(withId(R.id.fab))
                .perform(click());
    }
}