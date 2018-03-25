package pl.polsl.java.project.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import pl.polsl.java.project.exception.WrongDataException;
import pl.polsl.java.project.model.ModelDatabase;

/**
 * @author Kamil Ismail
 * @version 6.0
 */

/**
 * Class that communicates with user. Gets values from fields and controlls calculation.
 */
public class MainActivity extends AppCompatActivity {

    /**
     * Object that has function put by user.
     */
    EditText functionText;
    /**
     * Object that has start point put by user.
     */
    EditText startText;
    /**
     * Object that has end point put by user.
     */
    EditText endText;
    /**
     * Object that has number of points put by user.
     */
    EditText numberText;
    /**
     * Object representing group of radio buttons.
     */
    RadioGroup radio;
    /**
     * Object representing button that starts calculation.
     */
    Button button;

    /**
     * Methode that starts when the view is created. Searches for specific objects in the view
     * and saves them to variables.
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        functionText = (EditText) findViewById(R.id.editText1);
        startText = (EditText) findViewById(R.id.editText2);
        endText = (EditText) findViewById(R.id.editText3);
        numberText = (EditText) findViewById(R.id.editText4);
        radio = (RadioGroup) findViewById(R.id.radioGroup);
        button = (Button) findViewById(R.id.button);
    }

    /**
     * Methode that starts when the button is pressed. Creates ModelDatabase object containing all
     * needed variables for calculation. Controlls whole proces of calculation.
     *
     * @param v
     */
    public void dataInput(View v) {
        int selected = radio.getCheckedRadioButtonId();
        RadioButton b = (RadioButton) findViewById(selected);
        int choice = 0;
        if (b.getText().toString().equals("Rectangular"))
            choice = 2;
        else if (b.getText().toString().equals("Trapezoidal"))
            choice = 1;

        if (checkFields() == true) {
            ModelDatabase database = new ModelDatabase();
            try {
                database.setFunction(functionText.getText().toString());
                database.setPoints(Integer.parseInt(startText.getText().toString()),
                        Integer.parseInt(endText.getText().toString()), Integer.parseInt(numberText.getText().toString()));

                database.startCalculation(choice);
                Intent intent = new Intent(getApplicationContext(), ResultActivity.class);
                intent.putExtra("result", database.getResult());
                startActivity(intent);
            } catch (WrongDataException | StringIndexOutOfBoundsException | NullPointerException | NumberFormatException e) {
                Toast.makeText(this, "Exception detected: " + e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "Fill all fields!", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * Methode that checks if field in the view are empty or not.
     *
     * @return
     */
    private boolean checkFields() {
        if (startText.getText().toString().matches("") || endText.getText().toString().matches("")
                || numberText.getText().toString().matches(""))
            return false;
        else
            return true;
    }
}
