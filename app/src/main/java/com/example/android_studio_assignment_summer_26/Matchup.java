package com.example.android_studio_assignment_summer_26;

/**
 * Simple model object representing one head-to-head food matchup.
 */
public class Matchup
{
    private final String[] foodNames;    
    private final int[]    foodIndices;  

    public Matchup(String foodNameA, String foodNameB,
                   int foodIndexA, int foodIndexB)
    {
        this.foodNames   = new String[]{foodNameA, foodNameB};
        this.foodIndices = new int[]{foodIndexA, foodIndexB};
    }

    /**
     * Returns the display name of the food at slot 0 (Food A) or slot 1 (Food B).
     */
    public String getFoodName(int slot)
    {
        return foodNames[slot];
    }

    // TODO 5:
    // Return the master-array index of the food at the given slot.
    // Make sure slot is valid before accessing the array.
    public int getFoodIndex(int slot)
    {
        return 0;
    }
}