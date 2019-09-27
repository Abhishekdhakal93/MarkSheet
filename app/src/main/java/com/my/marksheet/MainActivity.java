package com.my.marksheet;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button butcon;
    EditText etname, etan, etiot, etweb;
    TextView tvresult;
    String status = "";
    int i = 1;

    DecimalFormat decimalFormat = new DecimalFormat("0.00");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        butcon = findViewById(R.id.butcon);
        etname = findViewById(R.id.txtName);
        etan = findViewById(R.id.amarks);
        etiot = findViewById(R.id.iot);
        etweb = findViewById(R.id.web);
        tvresult = findViewById(R.id.result);
        butcon.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.butcon) {
            double android, iot, web;


            if ((TextUtils.isEmpty(etname.getText().toString()))) {
                etname.setError("Please enter name");
                return;
            } else if (TextUtils.isEmpty(etan.getText().toString())) {
                etan.setError("Please enter marks of Android");
                return;
            } else if (TextUtils.isEmpty(etiot.getText().toString())) {
                etiot.setError("Please enter marks of IOT");
                return;
            } else if (TextUtils.isEmpty(etweb.getText().toString())) {
                etweb.setError("Please enter marks of WEB");
                return;
            } else {
                android = Double.parseDouble(etan.getText().toString());
                iot = Double.parseDouble(etiot.getText().toString());
                web = Double.parseDouble(etweb.getText().toString());
            }
            if ((android <= 100) && (android >= 0)) {
                if ((iot <= 100) && (iot >= 0)) {
                    if ((web <= 100) && (web >= 0)) {
                        Percentage calPer = new Percentage(android, iot, web);
                        tvresult.append((i + ") " + " Name: " + etname.getText().toString()) +
                                " | Android: " + (decimalFormat.format(Double.parseDouble(etan.getText().toString()))) +
                                " | IOT: " + (decimalFormat.format(Double.parseDouble(etiot.getText().toString()))) +
                                " | web: " + (decimalFormat.format(Double.parseDouble(etweb.getText().toString()))) +
                                " | percentage " + calPer.percentage() + " | " + calPer.getStatus() + "\n");
                        Clear();
                        i++;
                    } else {
                        etweb.setError("Please enter marks of WEB 0 to 100");
                    }

                } else {
                    etiot.setError("Please enter marks of IOT 0 to 100");

                }
            } else {
                etan.setError("Please enter marks of Android 0 to 100");

            }

        }
    }

    public void Clear() {
        etname.setText("");
        etan.setText("");
        etiot.setText("");
        etweb.setText("");
    }
}
