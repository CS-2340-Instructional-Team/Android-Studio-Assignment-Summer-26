package com.example.android_studio_assignment_summer_26;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

/**
 * BracketActivity is the only screen in this assignment.
 * Students complete several TODOs to make the app fully functional.
 *
 * The app runs a food bracket tournament: 5 foods compete in 10 head-to-head
 * matchups (every pair once). The user votes for a winner each round.
 * The app also stores how many times each food has won.
 */
public class BracketActivity extends AppCompatActivity
{
    private TextView    tvStandings;
    private TextView    tvMatchup;
    private TextView    tvFeedback;
    private RadioGroup  rgChoices;
    private RadioButton rbFoodA;
    private RadioButton rbFoodB;

    private MaterialButton btnVote;
    private MaterialButton btnNext;
    private MaterialButton btnReset;

    private BracketManagerSingleton bracketManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bracket);

        tvStandings = findViewById(R.id.tvStandings);
        tvMatchup   = findViewById(R.id.tvMatchup);
        tvFeedback  = findViewById(R.id.tvFeedback);
        rgChoices   = findViewById(R.id.rgChoices);

        rbFoodA = findViewById(R.id.rbFoodA);
        rbFoodB = findViewById(R.id.rbFoodB);

        btnVote = findViewById(R.id.btnVote);
        btnNext = findViewById(R.id.btnNext);

        // TODO 1:
        // Initialize bracketManager using the singleton.
        // bracketManager should point to the shared BracketManagerSingleton instance.
        // HINT: You should NOT use 'new' here.
        bracketManager = null;

        // TODO 3:
        // Find btnReset from the layout using its id.
        // Note: activity_bracket.xml has TODO 7 that creates this button.
        btnReset = null;

        bindButtonHandlers();
        renderMatchup();
        updateStandingsUI();
    }

    private void bindButtonHandlers()
    {
        btnVote.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                handleVote();
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                bracketManager.moveToNextMatchup();
                clearSelectionAndFeedback();
                renderMatchup();
                updateStandingsUI();
                btnVote.setEnabled(true);
            }
        });

        // TODO 4:
        // Wire up btnReset similarly to btnNext above.
        // It should return the app to its original state.
    }

    private void handleVote()
    {
        int checkedId = rgChoices.getCheckedRadioButtonId();
        if (checkedId == -1)
        {
            tvFeedback.setText("Please pick a food before voting!");
            return;
        }

        // Determine which food (A = 0, B = 1) the user selected
        int selectedIndex = (checkedId == R.id.rbFoodA) ? 0 : 1;

        // TODO 6:
        // Record the user's vote using bracketManager, then update tvFeedback
        // to tell the user which food they picked.
        // Also make sure the user can't vote more than once per matchup.

        updateStandingsUI();
    }

    private void renderMatchup()
    {
        Matchup m = bracketManager.getCurrentMatchup();
        tvMatchup.setText(m.getFoodName(0) + " vs. " + m.getFoodName(1)
                + " — which do you prefer?");
        rbFoodA.setText(m.getFoodName(0));
        rbFoodB.setText(m.getFoodName(1));
    }

    private void updateStandingsUI()
    {
        tvStandings.setText(bracketManager.getStandingsSummary());
    }

    private void clearSelectionAndFeedback()
    {
        rgChoices.clearCheck();
        tvFeedback.setText(getString(R.string.feedback_default));
    }
}