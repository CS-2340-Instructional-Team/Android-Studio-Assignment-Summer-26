package com.example.android_studio_assignment_summer_26;

import org.junit.Test;

/**
 * Local unit tests (runs on the JVM).
 */
public class ExampleUnitTest
{
    @Test
    public void recordWin_updatesStandings()
    {
        BracketManagerSingleton mgr = BracketManagerSingleton.getInstance();
        mgr.reset();

        // The first matchup is Pizza vs. Sushi.
        // Vote for Food A (slot 0).
        mgr.recordWin(0);

        // TODO 8:
        // Verify the standings reflect the vote you just cast.
        // Then call recordWin for slot 1 on the same matchup. Verify the standings reflect this vote you casted.
    }
}