package com.gaadi.dagger.junit.ui.activity;

import android.support.test.rule.ActivityTestRule;

import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.Matchers.hasToString;

/**
 * Created by vinodtakhar on 21/12/15.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SimpleListActivityTest {

    @Rule
    public ActivityTestRule<SimpleListActivity> mActivityRule =
            new ActivityTestRule<>(SimpleListActivity.class);


    @Test
    public void test1ItemVisible(){
        onView(withText("Item 1")).check(matches(isDisplayed()));

        Utility.wait2Seconds();
    }

    @Test
    public void test2ItemNonVisible(){
        onData(hasToString(containsString("Item 130"))).inAdapterView(allOf(withId(android.R.id.list), isDisplayed())).perform(click());

        Utility.wait2Seconds();
    }

    @Test
    public void test3ItemNonVisible(){
        onData(hasToString(containsString("Item 190"))).inAdapterView(allOf(withId(android.R.id.list), isDisplayed())).check(matches(isDisplayed()));

        Utility.wait2Seconds();
    }
}
