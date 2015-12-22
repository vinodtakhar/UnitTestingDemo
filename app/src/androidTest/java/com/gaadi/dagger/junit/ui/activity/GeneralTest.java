package com.gaadi.dagger.junit.ui.activity;

import android.test.AndroidTestCase;


import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

/**
 * Created by vinodtakhar on 16/12/15.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class GeneralTest extends AndroidTestCase{
    public GeneralTest() {
        super();
    }

    @Test
    public void test1Login(){
//        assertTrue(CommonUtils.getBooleanSharedPreference(getContext(), Constants.USER_LOGGEDIN, false));
    }

    @Test
    public void testDatabaseState(){
//        assertTrue(ApplicationController.getMakeModelVersionDB().getMakes().size() > 0);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
}
