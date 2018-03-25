package pl.polsl.java.project.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * @author Kamil Ismail
 * @version 6.0
 */

/**
 * Class that communicates with user. Shows him result of calculation.
 */
public class ResultActivity extends AppCompatActivity {
    /**
     * Object that is needed to show value to the user.
     */
    TextView resultText;

    /**
     * Methode that starts when the view is created. Gets value passed from the previous view by
     * Bundle object and puts it to the TextView.
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        resultText = (TextView) findViewById(R.id.resultView);

        savedInstanceState = getIntent().getExtras();
        if (savedInstanceState != null) {
            float value = savedInstanceState.getFloat("result");
            showResult(value);
        }
    }

    /**
     * Methode that shows result to user.
     *
     * @param result
     */
    private void showResult(float result) {
        resultText.setText(Float.toString(result));
    }

}
