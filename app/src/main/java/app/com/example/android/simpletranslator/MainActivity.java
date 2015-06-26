package app.com.example.android.simpletranslator;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity implements AdapterView.OnItemSelectedListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Spinner s1 = (Spinner) findViewById(R.id.spinner1);
        s1.setOnItemSelectedListener(this);

    }

    /** On translate button click, display results. */
    public void Translate(View view) {

        Spinner toLang = (Spinner) findViewById(R.id.spinner2);
        String toLangStr = toLang.getSelectedItem().toString();

        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        int btnID = radioGroup.getCheckedRadioButtonId();

        //display the String based on the Radio Button ID
        switch (btnID) {
            case R.id.radio_hi:
                if (toLangStr.equals("English")) {
                    display("Hi");
                } if(toLangStr.equals("Farsi")) {
                    display("Salam");
                } if(toLangStr.equals("Spanish")) {
                    display("Hola");
                } else {
                    display("ERROR");
                }
                break;
            case R.id.radio_taxi:
                if (toLangStr.equals("English")) {
                    display("Where can I find a taxi?");
                } if(toLangStr.equals("Farsi")) {
                    display("Taxi koojah ya?");
                } if(toLangStr.equals("Spanish")) {
                    display("Donde puedo encontrar un taxi?");
                } else {
                    display("ERROR");
                }
                break;
            case R.id.radio_bathroom:
                if (toLangStr.equals("English")) {
                    display("Where is the bathroom?");
                } if(toLangStr.equals("Farsi")) {
                    display("Tashnab kooja ya?");
                } if(toLangStr.equals("Spanish")) {
                    display("Donde esta el bano?");
                } else {
                    display("ERROR");
                }
                break;
            case R.id.radio_beer:
                if (toLangStr.equals("English")) {
                    display("Lets drink beer!");
                } if(toLangStr.equals("Farsi")) {
                    display("Beya nashah shim!");
                } if(toLangStr.equals("Spanish")) {
                    display("Vamos a beber cerveza!");
                } else {
                    display("ERROR");
                }
                break;
            case R.id.radio_cost:
                if (toLangStr.equals("English")) {
                    display("How much does this cost?");
                } if(toLangStr.equals("Farsi")) {
                    display("Kimmat yu chikzarah?");
                } if(toLangStr.equals("Spanish")) {
                    display("Cuanto cuesta eso?");
                } else {
                    display("ERROR");
                }
                break;
            default:
                display("Please select a phrase");
        }
    }

    /** Translation results to the textview */
    private void display(String str) {
        TextView translateTextView = (TextView) findViewById(R.id.display);
        translateTextView.setText(str);
    }

    /** From spinner (spinner1), changes radio buttons
     * once pick new language. */
    public void onItemSelected(AdapterView<?> parent, View view,
                               int pos, long id) {
        // An item was selected. You can retrieve the selected item using
        // parent.getItemAtPosition(pos)
        String lang = (String) parent.getItemAtPosition(pos);
        RadioButton rbHi = (RadioButton) findViewById(R.id.radio_hi);
        RadioButton rbTaxi = (RadioButton) findViewById(R.id.radio_taxi);
        RadioButton rbBathroom = (RadioButton) findViewById(R.id.radio_bathroom);
        RadioButton rbBeer = (RadioButton) findViewById(R.id.radio_beer);
        RadioButton rbCost = (RadioButton) findViewById(R.id.radio_cost);

        switch (lang) {
            case "English":
                rbHi.setText("Hi");
                rbTaxi.setText("Where can I find a taxi?");
                rbBathroom.setText("Where is the bathroom?");
                rbBeer.setText("Lets drink beer!");
                rbCost.setText("How much does this cost?");
                break;
            case "Farsi":
                rbHi.setText("Salam");
                rbTaxi.setText("Taxi koojah ya?");
                rbBathroom.setText("Tashnab kooja ya?");
                rbBeer.setText("Beya nashah shim!");
                rbCost.setText("Kimmat yu chikzarah?");
                break;
            case "Spanish":
                rbHi.setText("Hola");
                rbTaxi.setText("Donde puedo encontrar un taxi?");
                rbBathroom.setText("Donde esta el bano?");
                rbBeer.setText("Vamos a beber cerveza!");
                rbCost.setText("Cuanto cuesta eso?");
                break;
            default:
                display("Pick a language");
        }

    }

    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
        throw new RuntimeException("Select a From Language");
    }

}

