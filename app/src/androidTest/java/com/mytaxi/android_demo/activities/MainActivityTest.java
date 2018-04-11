package com.mytaxi.android_demo.activities;

import android.support.test.espresso.DataInteraction;
import android.support.test.espresso.Espresso;
import android.support.test.espresso.ViewFinder;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerViewAccessibilityDelegate;
import android.test.suitebuilder.annotation.LargeTest;

import com.mytaxi.android_demo.R;

import org.hamcrest.Matcher;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.removeGlobalAssertion;
import static android.support.test.espresso.action.ViewActions.scrollTo;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.action.ViewActions.typeTextIntoFocusedView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.assertThat;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.supportsInputMethods;
import static android.support.test.espresso.matcher.ViewMatchers.withClassName;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withInputType;
import static android.support.test.espresso.matcher.ViewMatchers.withTagValue;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static com.mytaxi.android_demo.activities.MainActivityTest2.childAtPosition;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsAnything.anything;


@LargeTest
@RunWith(AndroidJUnit4.class)
public class MainActivityTest{


    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    private String uName ="whiteelephant261";
    private String pName ="video";
    private String dName ="sa";

   @Before
   public void setUp() throws Exception {
   }

    @Test
    public void MainActivityTest(){


        Espresso.onView(withId(R.id.edt_username)).perform(typeText(uName));
        Espresso.onView(withId(R.id.edt_password)).perform(typeText(pName));
        Espresso.onView(withId(R.id.btn_login)).perform(click());
        Espresso.onView(withId(R.id.textSearch)).perform(typeText("Sa"));
        //Espresso.onData(withText("Sarah Friedrich")).onChildView(withId(R.id.searchContainer)).perform(click());
       Espresso.onData(anything()).inAdapterView(withId(R.id.searchContainer)).atPosition(2).perform(click());
   //Espresso.onData(anything()).inAdapterView(childAtPosition(withClassName(is("android.widget.PopupWindow$PopupBackgroundView")),position:0)).atPosition(2);
    /*    DataInteraction appCompatTextView = onData(Matchers.anything())
                .inAdapterView(childAtPosition(
                        withClassName(Matchers.is("android.widget.PopupWindow$PopupBackgroundView")),
                        0))
                .atPosition(2);
        appCompatTextView.perform(click());*/

    }

    @After
    public void tearDown() throws Exception {
    }



}