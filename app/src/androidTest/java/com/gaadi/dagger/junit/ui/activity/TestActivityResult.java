package com.gaadi.dagger.junit.ui.activity;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.intent.Intents;
import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.rule.ActivityTestRule;
import android.util.Log;

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
import static android.support.test.espresso.intent.Intents.intending;
import static android.support.test.espresso.intent.matcher.IntentMatchers.toPackage;
import static android.support.test.espresso.matcher.RootMatchers.isPlatformPopup;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.not;

/**
 * Created by vinodtakhar on 23/12/15.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestActivityResult {
    @Rule
    public ActivityTestRule<DependsOnAnotherActivity> mActivityRule =
            new ActivityTestRule<>(DependsOnAnotherActivity.class);

    public IntentsTestRule<DependsOnAnotherActivity> mIntentRule =
            new IntentsTestRule<>(DependsOnAnotherActivity.class);


    @Test
    public void test1ItemVisible(){
        mActivityRule.getActivity();

        int num=10;

        setResult(num);

        onView(withId(R.id.etNumber)).perform(typeText(""+num),closeSoftKeyboard());

        onView(withId(R.id.btnSquare)).perform(click());

        onView(withText(containsString("Result"))).check(matches(isDisplayed()));

        onView(withId(R.id.btnSquare)).check(matches(not(isDisplayed())));

        Utility.wait2Seconds();
    }

    public void setResult(int num){

        Intents.init();

        Intent resultData = new Intent();

        resultData.putExtra("result", num*num*num);

        Instrumentation.ActivityResult result = new Instrumentation.ActivityResult(Activity.RESULT_OK, resultData);

        Log.e("PackageName:", InstrumentationRegistry.getTargetContext().getPackageName());

        intending(toPackage(InstrumentationRegistry.getTargetContext().getPackageName())).respondWith(result);
    }
}
