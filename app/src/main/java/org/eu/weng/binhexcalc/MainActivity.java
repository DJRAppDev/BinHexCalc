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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Sets the TextViews, EditText, and RadioGroups to the objects

    }
}
