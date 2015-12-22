package com.gaadi.dagger.junit.ui.activity;

import android.support.test.runner.AndroidJUnit4;

import junit.framework.TestCase;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Iterator;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by vinodtakhar on 21/12/15.
 */
//@RunWith(MockitoJUnitRunner.class)
@RunWith(AndroidJUnit4.class)
public class MockitoExample  {

    @Test
    public void test1()  {
        MyClass test = mock(MyClass.class);

        when(test.doSomethingAndReturn()).thenReturn("inprogress");

        assertEquals(test.doSomethingAndReturn(), "inprogress");
    }


    @Test
    public void test2()  {
        MyClass test = mock(MyClass.class);

        when(test.doSomethingAndReturn()).thenReturn("inprogress").thenReturn("done");

        assertEquals(test.doSomethingAndReturn(), "inprogress");

        assertEquals(test.doSomethingAndReturn(), "done");
    }
}

