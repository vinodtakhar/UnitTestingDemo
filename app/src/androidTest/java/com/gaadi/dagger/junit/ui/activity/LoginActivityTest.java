package com.gaadi.dagger.junit.ui.activity;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;

import com.gaadi.dagger.junit.R;

import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static com.gaadi.dagger.junit.ui.activity.Utility.hasErrorText;

/**
 * Created by vinodtakhar on 3/12/15.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LoginActivityTest {

    @Rule
    public ActivityTestRule<LoginActivity> mActivityRule =
            new ActivityTestRule<>(LoginActivity.class);

    @Test
    public void test1LoginClickEmptyUsername() {
        Context targetContext = InstrumentationRegistry.getTargetContext();

        onView(withId(R.id.etUserame)).perform(typeText(""), closeSoftKeyboard());

        onView(withId(R.id.etPassword)).perform(typeText("vinod"), closeSoftKeyboard());

        onView(withId(R.id.btnLogin)).perform(click());

        onView(withId(R.id.etUserame)).check(matches(hasErrorText("Username is not valid")));

        Utility.wait2Seconds();
    }

    @Test
    public void test2LoginClickEmptyPassword() {

        onView(withId(R.id.etUserame)).perform(typeText("hello"), closeSoftKeyboard());

        onView(withId(R.id.etPassword)).perform(typeText(""), closeSoftKeyboard());

        onView(withId(R.id.btnLogin)).perform(click());

        onView(withId(R.id.etPassword)).check(matches(hasErrorText("Password is not valid")));

        Utility.wait2Seconds();
    }

    @Test
    public void test3LoginClickFailure() {

        onView(withId(R.id.etUserame)).perform(typeText("hello"), closeSoftKeyboard());

        onView(withId(R.id.etPassword)).perform(typeText("vinod"), closeSoftKeyboard());

        onView(withId(R.id.btnLogin)).perform(click());

        Utility.wait2Seconds();
    }

    @Test
    public void test4LoginClickSuccess() {

        onView(withId(R.id.etUserame)).perform(typeText("vinod"), closeSoftKeyboard());

        onView(withId(R.id.etPassword)).perform(typeText("vinod"), closeSoftKeyboard());

        onView(withId(R.id.btnLogin)).perform(click());

        Utility.wait2Seconds();
    }

}
