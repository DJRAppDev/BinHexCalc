package com.example.lsxxp.binaryhexcalc;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private String textString;
    private TextView binary;
    private TextView decimal;
    private TextView hexadecimal;
    private EditText input;
    private RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        binary = (TextView) findViewById(R.id.binaryText);
        decimal = (TextView) findViewById(R.id.decimalText);
        hexadecimal = (TextView) findViewById(R.id.hexadecimalText);
        input = (EditText) findViewById(R.id.input);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId){
                textString = input.getText().toString();
                RadioButton rb = (RadioButton) findViewById(checkedId);
                switch (rb.getId()) {
                    case R.id.radioButton1:
                        binary.setText("Binary: " + textString);
                        decimal.setText("Decimal: " + binToDec(textString));
                        hexadecimal.setText("Hexadecimal: " + binToHex(textString));
                        rb.setChecked(false);
                        break;
                    case R.id.radioButton2:
                        binary.setText("Binary: " + decToBin(textString));
                        decimal.setText("Decimal: " + textString);
                        hexadecimal.setText("Hexadecimal: " + decToHex(textString));
                        rb.setChecked(false);
                        break;
                    case R.id.radioButton3:
                        binary.setText("Binary: " + hexToBin(textString));
                        decimal.setText("Decimal: " + hexToDec(textString));
                        hexadecimal.setText("Hexadecimal: " + textString);
                        rb.setChecked(false);
                        break;
                    default:
                        binary.setText("Something went wrong...again...");
                        break;
                }
            }
        });
    }

    private static int find(String a, String[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(a)) {
                return i;
            }
        }
        return -1;
    }
    private static String decToBin(String dec) {
        String result = "";
        int decimal = Integer.parseInt(dec);
        int power = (int) (Math.log(decimal) / Math.log(2));
        while (decimal > 0) {
            if (Math.pow(2, power) <= decimal) {
                result += "1";
                decimal -= Math.pow(2, power);
            } else {
                result += "0";
            }
            power--;
        }
        while (power >= 0) {
            result += "0";
            power--;
        }
        return result;
    }
    private static String decToHex(String dec) {
        return binToHex(decToBin(dec));
    }
    private static String binToDec(String bin) {
        int power = 0;
        int intermediary = 0;
        for (int i = bin.length(); i > 0; i--) {
            intermediary += Integer.parseInt(bin.substring(i - 1, i)) * Math.pow(2, power);
            power++;
        }
        return "" + intermediary;
    }
    private static String binToHex(String bin) {
        String intermediary = "";
        String[] convArr = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F"};
        for (int i = bin.length(); i > 0; i -= 4) {
            if (i - 4 >= 0) {
                intermediary += convArr[Integer.parseInt(binToDec(bin.substring(i - 4, i)))];
            } else {
                intermediary += convArr[Integer.parseInt(binToDec(bin.substring(0, i)))];
            }
        }
        String result = "";
        for (int i = intermediary.length(); i > 0; i--) {
            result += intermediary.substring(i - 1, i);
        }
        return result;
    }
    private static String hexToDec(String hex) {
        String hex2 = hex.toUpperCase();
        String[] convArr = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F"};
        int power = 0;
        int result = 0;
        for (int i = hex2.length(); i > 0; i--) {
            result += find(hex2.substring(i - 1, i), convArr) * Math.pow(16, power);
            power++;
        }
        return "" + result;
    }
    private static String hexToBin(String hex) {
        return decToBin(hexToDec(hex));
    }
}
