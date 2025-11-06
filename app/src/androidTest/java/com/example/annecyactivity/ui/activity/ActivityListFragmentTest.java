package com.example.annecyactivity.ui.activity;

import androidx.fragment.app.testing.FragmentScenario;
import androidx.lifecycle.Lifecycle;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.example.annecyactivity.R;

import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

/*
 * Vérifie que le RecyclerView du fragment ActivityListFragment s'affiche bien.
 */
@RunWith(AndroidJUnit4.class)
public class ActivityListFragmentTest {

    @Test
    public void recyclerView_isDisplayed_whenFragmentIsLaunched() {
        // Lancer le fragment dans un environnement de test
        // Cast the final null to the intended type, or provide an explicit state.
        FragmentScenario.launchInContainer(
                ActivityListFragment.class,
                null, // fragmentArgs
                R.style.Theme_AnnecyActivity,
                Lifecycle.State.RESUMED // Explicitly set the initial state
        );

        // Vérifier que le RecyclerView est bien affiché
        onView(withId(R.id.activity_recycler))
                .check(matches(isDisplayed()));
    }
}
