package com.gaadi.dagger.junit.ui.activity;

import android.support.test.rule.ActivityTestRule;

import com.gaadi.dagger.junit.R;

import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.RootMatchers.isPlatformPopup;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.Matchers.hasToString;

/**
 * Created by vinodtakhar on 21/12/15.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AutoListActivityTest {

    @Rule
    public ActivityTestRule<AutoCompleteActivity> mActivityRule =
            new ActivityTestRule<>(AutoCompleteActivity.class);

    @Test
    public void test1ItemVisible(){
        onView(withId(R.id.list)).perform(typeText("10"),closeSoftKeyboard());

        onView(withText("Test 10")).inRoot(isPlatformPopup()).perform(click());

        Utility.wait2Seconds();
    }

    @Test
    public void test2ItemNonVisible(){
        onView(withId(R.id.list)).perform(typeText("11"),closeSoftKeyboard());

        onData(hasToString(containsString("Test 111"))).inRoot(isPlatformPopup()).perform(click());

        Utility.wait2Seconds();
    }
}
