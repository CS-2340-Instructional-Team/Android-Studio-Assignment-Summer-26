package com.example.android_studio_assignment_summer_26;

import java.util.ArrayList;
import java.util.List;

/**
 * BracketManagerSingleton holds the food bracket tournament state.
 * It holds the list of 10 head-to-head matchups (every pair of 5 foods),
 * tracks the current matchup index, and records win counts per food.
 */
public class BracketManagerSingleton
{
    private static BracketManagerSingleton instance;

    private static final String[] FOODS = {
            "Pizza", "Sushi", "Tacos", "Burger", "Ramen"
    };

    private int[] winCounts;

    private List<Matchup> matchups;
    private int           currentIndex;

    private BracketManagerSingleton()
    {
        winCounts    = new int[FOODS.length];
        matchups     = new ArrayList<>();
        currentIndex = 0;
        seedMatchups();
    }

    public static BracketManagerSingleton getInstance()
    {
        if (instance == null)
        {
            instance = new BracketManagerSingleton();
        }
        return instance;
    }

    /**
     * Builds all 10 unique head-to-head matchups from the 5 foods.
     * Each pair of foods appears exactly once.
     */
    private void seedMatchups()
    {
        for (int i = 0; i < FOODS.length; i++)
        {
            for (int j = i + 1; j < FOODS.length; j++)
            {
                matchups.add(new Matchup(FOODS[i], FOODS[j], i, j));
            }
        }
    }

    public void reset()
    {
        currentIndex = 0;
        winCounts    = new int[FOODS.length];
    }

    public Matchup getCurrentMatchup()
    {
        return matchups.get(currentIndex);
    }

    public void moveToNextMatchup()
    {
        if (currentIndex < matchups.size() - 1)
        {
            currentIndex++;
        }
        else
        {
            currentIndex = 0;
        }
    }

    /**
     * Records a win for the food chosen by the user.
     *
     * @param selectedIndex 0 for Food A, 1 for Food B
     */
    public void recordWin(int selectedIndex)
    {
        // TODO 2:
        // Find which food the user picked and give it a win.
        // You should think about what selectedIndex represents and what data
        // you have in this class and in Matchup class.
    }

    /**
     * Returns a formatted standings summary, e.g.:
     *   "Pizza: 3 | Sushi: 1 | Tacos: 2 | Burger: 0 | Ramen: 4"
     */
    public String getStandingsSummary()
    {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < FOODS.length; i++)
        {
            if (i > 0) { sb.append(" | "); }
            sb.append(FOODS[i]).append(": ").append(winCounts[i]);
        }
        return sb.toString();
    }

    public int getMatchupCount()
    {
        return matchups.size();
    }
}