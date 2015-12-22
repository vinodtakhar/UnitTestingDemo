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
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static com.gaadi.dagger.junit.ui.activity.Utility.withRecyclerView;

/**
 * Created by vinodtakhar on 3/12/15.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RecyclerActivityTest{

    @Rule
    public ActivityTestRule<RecyclerActivity> mActivityRule =
            new ActivityTestRule<>(RecyclerActivity.class);

    @Test
    public void test2NonVisibleView() {
        Context targetContext = InstrumentationRegistry.getTargetContext();

        onView(withRecyclerView(R.id.my_recycler_view)
                .atPositionOnView(5, R.id.textView2))
                .check(matches(withText("Secondary 5")));

        Utility.wait2Seconds();
    }
}
