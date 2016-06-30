package sample.gdgk.testing_sample.ex1.demo1;

import android.support.test.espresso.Espresso;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import sample.gdgk.testing_sample.R;
import sample.gdgk.testing_sample.demo1.LoginActivity;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class LoginActivityTest {
    @Rule
    public ActivityTestRule<LoginActivity> activityTestRule
            = new ActivityTestRule<>(LoginActivity.class);

    @Test
    public void testLoginSuccess() {
        onView(withId(R.id.emailEdit)).perform(typeText("test@abc.com"));
        onView(withId(R.id.passwordEdit)).perform(typeText("1q2w3e4r"));
        onView(withId(R.id.loginButton)).perform(click());

        onView(withText(R.string.login_success))
                .check(matches(isDisplayed()));
    }
}
