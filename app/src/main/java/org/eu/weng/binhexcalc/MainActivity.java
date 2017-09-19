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
        String result = "";
        int decimal = Integer.parseInt(dec);
        int power = (int)(Math.log(decimal)/Math.log(2));
        while (decimal > 0) {
            if (Math.pow(2,power) <= decimal) {
                result += "1";
                decimal-=Math.pow(2,power);
            }
            else {
                result += "0";
            }
            power--;
        }
        while (power >= 0) {
            result+="0";
            power--;
        }
        return result;
    }
    private String decToHex(String dec) {
        int intermediary;
        intermediary = Integer.parseInt(decToBin(dec));

    }
    private String binToDec(String bin) {
        return "";
    }

    private String binToHex(String bin) {
        return "";
    }

    private String hexToDec(String hex) {
        return "";
    }

    private String hexToBin(String hex) {
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
