package org.eu.weng.binhexcalc;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView decOut, hexOut, binOut;
    private EditText numIn;
    private RadioGroup choice;

    private String decToBin(String dec) {
        return "";
    }
    private String decToHex(String dec) {
        return "";
    }
    private String binToDec(String bin) {
        return "";
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Sets the TextViews, EditText, and RadioGroups to the objects
        decOut = (TextView)findViewById(R.id.decOut);
        binOut = (TextView)findViewById(R.id.binOut);
        hexOut = (TextView)findViewById(R.id.hexOut);
        numIn = (EditText)findViewById(R.id.numIn);
        choice = (RadioGroup)findViewById(R.id.choice);
    }
}
