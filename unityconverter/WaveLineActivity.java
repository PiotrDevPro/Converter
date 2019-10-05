package com.piotrdevelop.unityconverter;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.math.BigDecimal;

public class WaveLineActivity extends AppCompatActivity implements TextWatcher{

    String[] data = {"Герц (Hz)", "Килогерц (KHz)", "Мегагерц (MHz)", "Гигагерц (Ghz)", "Сантиметр", "Метр", "Километр"};
    int a,b;
    Spinner spMassa;
    EditText edNum, edWaveHz, edWaveKhz, edWaveMhz, edWaveGhz, WaveSm, WaveMetr, WaveKm;
    TextView tvPosName;

    public BigDecimal roundUp(double value, int digits) {
        return new BigDecimal("" + value).setScale(digits, BigDecimal.ROUND_HALF_UP);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.waveline);

        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, data);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spMassa = (Spinner) findViewById(R.id.spMassa);
        spMassa.setAdapter(adapter);

        tvPosName = (TextView) findViewById(R.id.tvPosName);


        edNum = (EditText) findViewById(R.id.edNum);
        edWaveHz = (EditText) findViewById(R.id.edWaveHz);
        edWaveKhz = (EditText) findViewById(R.id.edWaveKhz);
        edWaveMhz = (EditText) findViewById(R.id.edWaveMhz);
        edWaveGhz = (EditText) findViewById(R.id.edWaveGhz);
        WaveSm = (EditText) findViewById(R.id.WaveSm);
        WaveMetr = (EditText) findViewById(R.id.WaveMetr);
        WaveKm = (EditText) findViewById(R.id.WaveKm);

        edNum.addTextChangedListener(this);
        edNum.requestFocus();

        spMassa.setSelection(0);
        spMassa.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                String strName = spMassa.getSelectedItem().toString();
                tvPosName.setText(strName);
                a = position;

                double result = 0;
                double num = 0;
                double num2 = 0;

                if (TextUtils.isEmpty(edNum.getText().toString())
                        || (edNum.getText().toString().equals("."))) {

                    edWaveHz.setText("");
                    edWaveKhz.setText("");
                    edWaveMhz.setText("");
                    edWaveGhz.setText("");

                    WaveSm.setText("");
                    WaveMetr.setText("");
                    WaveKm.setText("");


                    return;
                }

                num = Double.parseDouble(edNum.getText().toString());
               // num2 = Double.parseDouble(edNum.getText().toString());

                switch (position) {
                    case 0:
                        result = num * 1;
                        edWaveHz.setText(String.valueOf(roundUp(result, 2)));
                        result = num * 0.001;
                        edWaveKhz.setText(String.valueOf(roundUp(result, 2)));
                        result = num * 1e-6;
                        edWaveMhz.setText(String.valueOf(roundUp(result, 2)));
                        result = num * 1e-9;
                        edWaveGhz.setText(String.valueOf(roundUp(result, 2)));
                        result = num * 3e+9;
                        WaveSm.setText(String.valueOf(roundUp(result, 2)));
                        result = num * 3e+7;
                        WaveMetr.setText(String.valueOf(roundUp(result, 2)));
                        result = num * 3e+4;
                        WaveKm.setText(String.valueOf(roundUp(result, 2)));
                        Toast.makeText(getApplicationContext(), " " + strName, Toast.LENGTH_SHORT).show();
                        break;
                    case 1:
                        result = num * 1000;
                        edWaveHz.setText(String.valueOf(roundUp(result, 2)));
                        result = num * 1;
                        edWaveKhz.setText(String.valueOf(roundUp(result, 2)));
                        result = num * 0.001;
                        edWaveMhz.setText(String.valueOf(roundUp(result, 2)));
                        result = num * 1e-6;
                        edWaveGhz.setText(String.valueOf(roundUp(result, 2)));
                        result = (num * 3e+7)/10;
                        WaveSm.setText(String.valueOf(roundUp(result, 2)));
                        result = (num * 3e+5)/100;
                        WaveMetr.setText(String.valueOf(roundUp(result, 2)));
                        result = (num * 300)/1000;
                        WaveKm.setText(String.valueOf(roundUp(result, 2)));
                        Toast.makeText(getApplicationContext(), " " + strName, Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        result = num * 1e+6;
                        edWaveHz.setText(String.valueOf(roundUp(result, 2)));
                        result = num * 1000;
                        edWaveKhz.setText(String.valueOf(roundUp(result, 2)));
                        result = num * 1;
                        edWaveMhz.setText(String.valueOf(roundUp(result, 2)));
                        result = num * 0.001;
                        edWaveGhz.setText(String.valueOf(roundUp(result, 2)));
                        result = num * 3e+4;
                        WaveSm.setText(String.valueOf(roundUp(result, 2)));
                        result = num * 3e+2;
                        WaveMetr.setText(String.valueOf(roundUp(result, 2)));
                        result = num * 0.3;
                        WaveKm.setText(String.valueOf(roundUp(result, 2)));
                        Toast.makeText(getApplicationContext(), " " + strName, Toast.LENGTH_SHORT).show();
                        break;
                    case 3:
                        result = num * 1e+9;
                        edWaveHz.setText(String.valueOf(roundUp(result, 2)));
                        result = num * 1e+6;
                        edWaveKhz.setText(String.valueOf(roundUp(result, 2)));
                        result = num * 1000;
                        edWaveMhz.setText(String.valueOf(roundUp(result, 2)));
                        result = num * 1;
                        edWaveGhz.setText(String.valueOf(roundUp(result, 2)));
                        result = num * 30;
                        WaveSm.setText(String.valueOf(roundUp(result, 2)));
                        result = num * 0.3;
                        WaveMetr.setText(String.valueOf(roundUp(result, 2)));
                        result = num * 0.0003;
                        WaveKm.setText(String.valueOf(roundUp(result, 2)));
                        Toast.makeText(getApplicationContext(), " " + strName, Toast.LENGTH_SHORT).show();
                        break;
                    case 4:
                        result = num * 3e+10;
                        edWaveHz.setText(String.valueOf(roundUp(result, 2)));
                        result = num * 3e+7;
                        edWaveKhz.setText(String.valueOf(roundUp(result, 2)));
                        result = num * 30000;
                        edWaveMhz.setText(String.valueOf(roundUp(result, 2)));
                        result = num * 30;
                        edWaveGhz.setText(String.valueOf(roundUp(result, 2)));
                        result = num * 1;
                        WaveSm.setText(String.valueOf(roundUp(result, 2)));
                        result = num * 0.01;
                        WaveMetr.setText(String.valueOf(roundUp(result, 2)));
                        result = num * 0.0001;
                        WaveKm.setText(String.valueOf(roundUp(result, 2)));
                        Toast.makeText(getApplicationContext(), " " + strName, Toast.LENGTH_SHORT).show();
                        break;
                    case 5:
                        result = num * 3e+8;
                        edWaveHz.setText(String.valueOf(roundUp(result, 2)));
                        result = num * 3e+5;
                        edWaveKhz.setText(String.valueOf(roundUp(result, 2)));
                        result = num * 300;
                        edWaveMhz.setText(String.valueOf(roundUp(result, 2)));
                        result = num * 0.3;
                        edWaveGhz.setText(String.valueOf(roundUp(result, 2)));
                        result = num * 100;
                        WaveSm.setText(String.valueOf(roundUp(result, 2)));
                        result = num * 1;
                        WaveMetr.setText(String.valueOf(roundUp(result, 2)));
                        result = num * 0.001;
                        WaveKm.setText(String.valueOf(roundUp(result, 2)));
                        Toast.makeText(getApplicationContext(), " " + strName, Toast.LENGTH_SHORT).show();
                        break;
                    case 6:
                        result = num * 3e+5;
                        edWaveHz.setText(String.valueOf(roundUp(result, 2)));
                        result = num * 300;
                        edWaveKhz.setText(String.valueOf(roundUp(result, 2)));
                        result = num * 0.3;
                        edWaveMhz.setText(String.valueOf(roundUp(result, 2)));
                        result = num * 0.0003;
                        edWaveGhz.setText(String.valueOf(roundUp(result, 2)));
                        result = num * 100000;
                        WaveSm.setText(String.valueOf(roundUp(result, 2)));
                        result = num * 1000;
                        WaveMetr.setText(String.valueOf(roundUp(result, 2)));
                        result = num * 1;
                        WaveKm.setText(String.valueOf(roundUp(result, 2)));
                        Toast.makeText(getApplicationContext(), " " + strName, Toast.LENGTH_SHORT).show();
                        break;


                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }


    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {


        double result = 0;
        double num = 0;
      //  double num2 = 0;

        if (TextUtils.isEmpty(edNum.getText().toString())
                || (edNum.getText().toString().equals("."))) {

            edWaveHz.setText("");
            edWaveKhz.setText("");
            edWaveMhz.setText("");
            edWaveGhz.setText("");

            WaveSm.setText("");
            WaveMetr.setText("");
            WaveKm.setText("");

            return;
        }
        num = Double.parseDouble(edNum.getText().toString());
     //   num2 = Double.parseDouble(edNum.getText().toString());
        {
            switch (a) {
                case 0:
                    result = num * 1;
                    edWaveHz.setText(String.valueOf(roundUp(result, 2)));
                    result = num * 0.001;
                    edWaveKhz.setText(String.valueOf(roundUp(result, 2)));
                    result = num * 1e-6;
                    edWaveMhz.setText(String.valueOf(roundUp(result, 2)));
                    result = num * 1e-9;
                    edWaveGhz.setText(String.valueOf(roundUp(result, 2)));
                    result = num * 3e+9;
                    WaveSm.setText(String.valueOf(roundUp(result, 2)));
                    result = num * 3e+7;
                    WaveMetr.setText(String.valueOf(roundUp(result, 2)));
                    result = num * 3e+4;
                    WaveKm.setText(String.valueOf(roundUp(result, 2)));
                    break;
                case 1:
                    result = num * 1000;
                    edWaveHz.setText(String.valueOf(roundUp(result, 2)));
                    result = num * 1;
                    edWaveKhz.setText(String.valueOf(roundUp(result, 2)));
                    result = num * 0.001;
                    edWaveMhz.setText(String.valueOf(roundUp(result, 2)));
                    result = num * 1e-6;
                    edWaveGhz.setText(String.valueOf(roundUp(result, 2)));
                    result = num * 3e+7;
                    WaveSm.setText(String.valueOf(roundUp(result, 2)));
                    result = num * 3e+5;
                    WaveMetr.setText(String.valueOf(roundUp(result, 2)));
                    result = num * 300;
                    WaveKm.setText(String.valueOf(roundUp(result, 2)));
                    break;
                case 2:
                    result = num * 1e+6;
                    edWaveHz.setText(String.valueOf(roundUp(result, 2)));
                    result = num * 1000;
                    edWaveKhz.setText(String.valueOf(roundUp(result, 2)));
                    result = num * 1;
                    edWaveMhz.setText(String.valueOf(roundUp(result, 2)));
                    result = num * 0.001;
                    edWaveGhz.setText(String.valueOf(roundUp(result, 2)));
                    result = num * 3e+4;
                    WaveSm.setText(String.valueOf(roundUp(result, 2)));
                    result = num * 3e+2;
                    WaveMetr.setText(String.valueOf(roundUp(result, 2)));
                    result = num * 0.3;
                    WaveKm.setText(String.valueOf(roundUp(result, 2)));
                    break;
                case 3:
                    result = num * 1e+9;
                    edWaveHz.setText(String.valueOf(roundUp(result, 2)));
                    result = num * 1e+6;
                    edWaveKhz.setText(String.valueOf(roundUp(result, 2)));
                    result = num * 1000;
                    edWaveMhz.setText(String.valueOf(roundUp(result, 2)));
                    result = num * 1;
                    edWaveGhz.setText(String.valueOf(roundUp(result, 2)));
                    result = num * 30;
                    WaveSm.setText(String.valueOf(roundUp(result, 2)));
                    result = num * 0.3;
                    WaveMetr.setText(String.valueOf(roundUp(result, 2)));
                    result = num * 0.0003;
                    WaveKm.setText(String.valueOf(roundUp(result, 2)));
                    break;
                case 4:
                    result = num * 3e+10;
                    edWaveHz.setText(String.valueOf(roundUp(result, 2)));
                    result = num * 3e+7;
                    edWaveKhz.setText(String.valueOf(roundUp(result, 2)));
                    result = num * 30000;
                    edWaveMhz.setText(String.valueOf(roundUp(result, 2)));
                    result = num * 30;
                    edWaveGhz.setText(String.valueOf(roundUp(result, 2)));
                    result = num * 1;
                    WaveSm.setText(String.valueOf(roundUp(result, 2)));
                    result = num * 0.01;
                    WaveMetr.setText(String.valueOf(roundUp(result, 2)));
                    result = num * 0.0001;
                    WaveKm.setText(String.valueOf(roundUp(result, 2)));
                    break;
                case 5:
                    result = num * 3e+8;
                    edWaveHz.setText(String.valueOf(roundUp(result, 2)));
                    result = num * 3e+5;
                    edWaveKhz.setText(String.valueOf(roundUp(result, 2)));
                    result = num * 300;
                    edWaveMhz.setText(String.valueOf(roundUp(result, 2)));
                    result = num * 0.3;
                    edWaveGhz.setText(String.valueOf(roundUp(result, 2)));
                    result = num * 100;
                    WaveSm.setText(String.valueOf(roundUp(result, 2)));
                    result = num * 1;
                    WaveMetr.setText(String.valueOf(roundUp(result, 2)));
                    result = num * 0.001;
                    WaveKm.setText(String.valueOf(roundUp(result, 2)));
                    break;
                case 6:
                    result = num * 3e+5;
                    edWaveHz.setText(String.valueOf(roundUp(result, 2)));
                    result = num * 300;
                    edWaveKhz.setText(String.valueOf(roundUp(result, 2)));
                    result = num * 0.3;
                    edWaveMhz.setText(String.valueOf(roundUp(result, 2)));
                    result = num * 0.0003;
                    edWaveGhz.setText(String.valueOf(roundUp(result, 2)));
                    result = num * 100000;
                    WaveSm.setText(String.valueOf(roundUp(result, 2)));
                    result = num * 1000;
                    WaveMetr.setText(String.valueOf(roundUp(result, 2)));
                    result = num * 1;
                    WaveKm.setText(String.valueOf(roundUp(result, 2)));
                    break;

            }

        }
    }

    @Override
    public void afterTextChanged(Editable s) {

    }
}





