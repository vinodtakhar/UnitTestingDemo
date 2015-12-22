package com.gaadi.dagger.junit.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.filters.SdkSuppress;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObject2;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiSelector;
import android.support.test.uiautomator.Until;
import android.widget.Button;
import android.widget.EditText;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

/**
 * Created by vinodtakhar on 7/12/15.
 */
@RunWith(AndroidJUnit4.class)
@SdkSuppress(minSdkVersion = 18)
public class GeneralUiAutomatorTest {
    private static final String BASIC_SAMPLE_PACKAGE
            = "com.gaadi.dagger.daggerfragmentexample";
    private static final int LAUNCH_TIMEOUT = 5000;
    private static final String STRING_TO_BE_TYPED = "UiAutomator";
    private UiDevice mDevice;

    @Before
    public void startMainActivityFromHomeScreen() {
        // Initialize UiDevice instance
        mDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());

        // Start from the home screen
        mDevice.pressHome();

        // Wait for launcher
        final String launcherPackage = mDevice.getLauncherPackageName();
        assertThat(launcherPackage, notNullValue());
        mDevice.wait(Until.hasObject(By.pkg(launcherPackage).depth(0)),
                LAUNCH_TIMEOUT);

        // Launch the app
        Context context = InstrumentationRegistry.getContext();
        final Intent intent = context.getPackageManager()
                .getLaunchIntentForPackage(BASIC_SAMPLE_PACKAGE);
        // Clear out any previous instances
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        context.startActivity(intent);

        // Wait for the app to appear
        mDevice.wait(Until.hasObject(By.pkg(BASIC_SAMPLE_PACKAGE).depth(0)),
                LAUNCH_TIMEOUT);
    }

    private void inputData(String user,String pwd){
        UiObject username = mDevice.findObject(new UiSelector()
                .text("Enter username").className(EditText.class));

        assertThat(username, notNullValue());

        UiObject password = mDevice.findObject(new UiSelector()
                .resourceId(BASIC_SAMPLE_PACKAGE+":id/etPassword").className(EditText.class));

        assertThat(password, notNullValue());

        UiObject okButton = mDevice.findObject(new UiSelector()
                .text("Login").className(Button.class));

        assertThat(okButton, notNullValue());

        try
        {
            username.setText(user);
            password.setText(pwd);

            okButton.click();
        } catch (UiObjectNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void loginClick1Test(){

        inputData("", "");

        Utility.wait2Seconds();

    }

    @Test
    public void loginClick2Test(){

        inputData("vinod", "xys");

        Utility.wait2Seconds();
    }

    @Test
    public void loginClick3Test(){

        inputData("xys","vinod");

        Utility.wait2Seconds();
    }

    @Test
    public void loginClick4Test(){

        inputData("vinod","vinod");

        mDevice.wait(Until.hasObject(By.res(BASIC_SAMPLE_PACKAGE, "tvUsername").depth(3)),
                LAUNCH_TIMEOUT);

        UiObject2 tvUsername = mDevice.findObject(By.res(BASIC_SAMPLE_PACKAGE, "tvUsername"));
        UiObject2 tvPassword = mDevice.findObject(By.res(BASIC_SAMPLE_PACKAGE, "tvPassword"));

        assertThat(tvUsername, notNullValue());
        assertThat(tvPassword, notNullValue());

        assertEquals("vinod", tvUsername.getText());
        assertEquals("vinod", tvPassword.getText());

        Utility.wait2Seconds();
    }
}
