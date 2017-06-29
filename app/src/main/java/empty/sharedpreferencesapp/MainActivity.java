package empty.sharedpreferencesapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v4.content.SharedPreferencesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;


//APP to create an edit text that saves its value even if we completely close the app

public class MainActivity extends AppCompatActivity {

    //Declare String constants for our preferences , and KEY
    private static final String PREFS_FILE = "empty.sharedpreferencesapp.preferences";    //to have access to our shared preferences -
    private static final String KEY_EDITETEXT = "KEY_EDITETEXT";

    private SharedPreferences mSharedPreferences; // Sharedpreferences Objects are used to store key - value pairs
    private SharedPreferences.Editor mEditor;  // all shared preference objects have an editor - used to add any values
    private EditText mEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initialize member variables
        mEditText = (EditText) findViewById(R.id.editText);
        mSharedPreferences = getSharedPreferences(PREFS_FILE, Context.MODE_PRIVATE); // alt+enter to generate variable PREFS_FILE if not made yet
        mEditor = mSharedPreferences.edit();

        //retrieive our previously saved data -/ string -- provide a KEY to the value and a Default value""(incase key not found)
        String editTextString = mSharedPreferences.getString(KEY_EDITETEXT, "");
        mEditText.setText(editTextString);

    }


    //use the onPause method to save any data in the app running. (CTRL-o)shortcut to override onPause method
    @Override
    protected void onPause() {
        super.onPause();
        //store  our string using the putString method of our Editor
        mEditor.putString(KEY_EDITETEXT, mEditText.getText().toString());   // create static final KEY name  ///.getText() returns an EDITABLE, .toString converts it to a STRING
        mEditor.apply(); //save changes to our sharedPreferences object. ***always remmeber to APPLY to save

    }

}

/*removing shared preferences values
-useful for testing or users wanting to reset its app to default values

ON SHARED PREFERENCE EDITOR object.- mEditor
.clear method
.remove(KEY) method - to remove just one value of the key.
*/