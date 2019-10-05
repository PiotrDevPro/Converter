package com.piotrdevelop.unityconverter;


import android.content.SharedPreferences;
import android.os.Build;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import java.math.BigDecimal;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class MassaActivity extends AppCompatActivity implements TextWatcher {

  //  String[] data = {"Микрограмм (µg)", "Миллиграмм (mg)", "Грам (g)", "Унция (oz)", "Килограмм (kg)","Фунт (lb)", "Стоун (st)", "Английская тонна (ton)", "Тонна (t)", "Американская тонна (short ton)","Карат (ct)","Гран (granum)"};
    int a;
    Spinner spMassa;
    EditText edNum, edTonna, edAmTonna, edEnTonna, edKg, edStoun, edFunt, edUnci, edGr, edMmGr, edMicroGr,edCt,edGranum;
    TextView tvPosName;

    public BigDecimal roundUp(double value, int digits) {
        return new BigDecimal("" + value).setScale(digits, BigDecimal.ROUND_HALF_UP);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.massa);

        Toolbar my_toolbar = (Toolbar) findViewById(R.id.my_toolbar_app);
        CoordinatorLayout corLoyMassa = (CoordinatorLayout) findViewById(R.id.corLoyMassa);
        RelativeLayout backColorlayoutAds = (RelativeLayout) findViewById(R.id.BackMassaAds);
        CollapsingToolbarLayout bottomColorLayout = (CollapsingToolbarLayout) findViewById(R.id.MassaBottomLayout);
        setSupportActionBar(my_toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,
      //  adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            getResources().getStringArray(R.array.massa));

        spMassa = (Spinner) findViewById(R.id.spMassa);
        spMassa.setAdapter(adapter);


        edNum = (EditText) findViewById(R.id.edNum);
        tvPosName = (TextView) findViewById(R.id.tvPosName);


        edTonna = (EditText) findViewById(R.id.edTonna);
        edAmTonna = (EditText) findViewById(R.id.edAmTonna);
        edEnTonna = (EditText) findViewById(R.id.edEnTonna);
        edKg = (EditText) findViewById(R.id.edKg);
        edStoun = (EditText) findViewById(R.id.edStoun);
        edFunt = (EditText) findViewById(R.id.edFunt);
        edUnci = (EditText) findViewById(R.id.edUnci);
        edGr = (EditText) findViewById(R.id.edGr);
        edMmGr = (EditText) findViewById(R.id.edMmGr);
        edMicroGr = (EditText) findViewById(R.id.edMicroGr);
        edCt = (EditText) findViewById(R.id.edCt);
        edGranum = (EditText) findViewById(R.id.edGranum);

        TextView UsTon = (TextView) findViewById(R.id.UsTon);
        TextView UkTon = (TextView) findViewById(R.id.UkTon);
        TextView Tonne = (TextView) findViewById(R.id.Tonne);
        TextView st = (TextView) findViewById(R.id.st);
        TextView kg = (TextView) findViewById(R.id.kg);
        TextView ct = (TextView)  findViewById(R.id.ct);
        TextView lb = (TextView)  findViewById(R.id.lb);
        TextView oz = (TextView)  findViewById(R.id.oz);
        TextView g = (TextView)  findViewById(R.id.g);
        TextView mg = (TextView)  findViewById(R.id.mg);
        TextView um = (TextView)  findViewById(R.id.ug);
        TextView nm = (TextView)  findViewById(R.id.gran);


        if (getColor() != getResources().getColor(R.color.colorPrimary)) {

            my_toolbar.setBackgroundColor(getBackgroundColor());
            backColorlayoutAds.setBackgroundColor(getColor());
            bottomColorLayout.setBackgroundColor(getColor());
            corLoyMassa.setBackgroundColor(getBackgroundColor());

            UsTon.setTextColor(getTextColor());
            UkTon.setTextColor(getTextColor());
            Tonne.setTextColor(getTextColor());
            st.setTextColor(getTextColor());
            kg.setTextColor(getTextColor());
            ct.setTextColor(getTextColor());
            lb.setTextColor(getTextColor());
            oz.setTextColor(getTextColor());
            um.setTextColor(getTextColor());
            g.setTextColor(getTextColor());
            nm.setTextColor(getTextColor());
            mg.setTextColor(getTextColor());


            edTonna.setBackgroundColor(getEditTextActivityColor());
            edTonna.setTextColor(getEditTextColor());
            edAmTonna.setBackgroundColor(getEditTextActivityColor());
            edAmTonna.setTextColor(getEditTextColor());
            edEnTonna.setBackgroundColor(getEditTextActivityColor());
            edEnTonna.setTextColor(getEditTextColor());
            edKg.setBackgroundColor(getEditTextActivityColor());
            edKg.setTextColor(getEditTextColor());
            edStoun.setBackgroundColor(getEditTextActivityColor());
            edStoun.setTextColor(getEditTextColor());
            edFunt.setBackgroundColor(getEditTextActivityColor());
            edFunt.setTextColor(getEditTextColor());
            edUnci.setBackgroundColor(getEditTextActivityColor());
            edUnci.setTextColor(getEditTextColor());
            edGr.setBackgroundColor(getEditTextActivityColor());
            edGr.setTextColor(getEditTextColor());
            edMmGr.setBackgroundColor(getEditTextActivityColor());
            edMmGr.setTextColor(getEditTextColor());
            edMicroGr.setBackgroundColor(getEditTextActivityColor());
            edMicroGr.setTextColor(getEditTextColor());
            edCt.setBackgroundColor(getEditTextActivityColor());
            edCt.setTextColor(getEditTextColor());
            edGranum.setBackgroundColor(getEditTextActivityColor());
            edGranum.setTextColor(getEditTextColor());

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                getWindow().setStatusBarColor(getColor());
            }
        }

        edNum.addTextChangedListener(this);
        edNum.requestFocus();

        spMassa.setSelection(0);


        spMassa.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                String strName = spMassa.getSelectedItem().toString();
             //   tvPosName.setText(strName);
                a = position;

                double result = 0;
                double num = 0;

                if (TextUtils.isEmpty(edNum.getText().toString())
                        ||  (edNum.getText().toString().equals("."))
                        ||  (edNum.getText().toString().equals("-"))){



                    edAmTonna.setText("");
                    edTonna.setText("");
                    edEnTonna.setText("");
                    edKg.setText("");
                    edStoun.setText("");
                    edFunt.setText("");
                    edUnci.setText("");
                    edGr.setText("");
                    edMmGr.setText("");
                    edMicroGr.setText("");
                    edCt.setText("");
                    edGranum.setText("");


                    return;

                }

                num = Double.parseDouble((edNum.getText().toString()));


                switch (position) {
                    case 0:

                        result = (num + 0);
                        edMicroGr.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.001);
                        edMmGr.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 1e-6);
                        edGr.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 3.5274e-8);
                        edUnci.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 1e-9);
                        edKg.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 2.204e-9);
                        edFunt.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 1.57e-10);
                        edStoun.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 9.8421e-13);
                        edEnTonna.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 1e-12);
                        edTonna.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 1.11e-12);
                        edAmTonna.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.000005);
                        edCt.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.00001543);
                        edGranum.setText(String.valueOf(roundUp(result,5)));
                        break;

                    case 1:
                        result = (num * 1000);
                        edMicroGr.setText(String.valueOf(roundUp(result,4)));
                        result = (num + 0);
                        edMmGr.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.001);
                        edGr.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 3.5274e-5);
                        edUnci.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 1e-6);
                        edKg.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 2.2046e-6);
                        edFunt.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 1.5757e-7);
                        edStoun.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 9.8421e-10);
                        edEnTonna.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 1e-9);
                        edTonna.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 1.1023e-9);
                        edAmTonna.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.005);
                        edCt.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.01543);
                        edGranum.setText(String.valueOf(roundUp(result,5)));
                        break;

                    case 2:
                        result = (num * 1e+6);
                        edMicroGr.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 1000);
                        edMmGr.setText(String.valueOf(roundUp(result,4)));
                        result = (num + 0);
                        edGr.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.035274);
                        edUnci.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.001);
                        edKg.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.0022);
                        edFunt.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.000157);
                        edStoun.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 9.8421e-7);
                        edEnTonna.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 1e-6);
                        edTonna.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 1.1023e-6);
                        edAmTonna.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 5);
                        edCt.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 15.43);
                        edGranum.setText(String.valueOf(roundUp(result,5)));
                        break;

                    case 3:
                        result = (num * 2.835e+7);
                        edMicroGr.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 28349.5);
                        edMmGr.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 28.34);
                        edGr.setText(String.valueOf(roundUp(result,4)));
                        result = (num + 0);
                        edUnci.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.0283);
                        edKg.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.0625);
                        edFunt.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.004465);
                        edStoun.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 2.7902e-5);
                        edEnTonna.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 2.835e-5);
                        edTonna.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 3.125e-5);
                        edAmTonna.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 141.7);
                        edCt.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 437.5);
                        edGranum.setText(String.valueOf(roundUp(result,5)));
                        break;

                    case 4:
                        result = (num * 1e+9);
                        edMicroGr.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 1e+6);
                        edMmGr.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 1000);
                        edGr.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 35.274);
                        edUnci.setText(String.valueOf(roundUp(result,4)));
                        result = (num + 0);
                        edKg.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 2.20462);
                        edFunt.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.157473);
                        edStoun.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.00098);
                        edEnTonna.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.001);
                        edTonna.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.0011);
                        edAmTonna.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 5000);
                        edCt.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 15430);
                        edGranum.setText(String.valueOf(roundUp(result,5)));
                        break;

                    case 5:
                        result = (num * 4.536e+8);
                        edMicroGr.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 453592);
                        edMmGr.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 453.592);
                        edGr.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 16);
                        edUnci.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.4535);
                        edKg.setText(String.valueOf(roundUp(result,4)));
                        result = (num + 0);
                        edFunt.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.0714);
                        edStoun.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.000446429);
                        edEnTonna.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.0004535);
                        edTonna.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.0005);
                        edAmTonna.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 2268);
                        edCt.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 7000);
                        edGranum.setText(String.valueOf(roundUp(result,5)));
                        break;

                    case 6:
                        result = (num * 6.35e+9);
                        edMicroGr.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 6.35e+6);
                        edMmGr.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 6350.29);
                        edGr.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 224);
                        edUnci.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 6.35);
                        edKg.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 14);
                        edFunt.setText(String.valueOf(roundUp(result,4)));
                        result = (num + 0);
                        edStoun.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.00625);
                        edEnTonna.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.00635);
                        edTonna.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.007);
                        edAmTonna.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 31750);
                        edCt.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 98000);
                        edGranum.setText(String.valueOf(roundUp(result,5)));
                        break;

                    case 7:
                        result = (num * 1.016e+12);
                        edMicroGr.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 1.016e+9);
                        edMmGr.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 1.016e+6);
                        edGr.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 35840);
                        edUnci.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 1016.05);
                        edKg.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 2240);
                        edFunt.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 160);
                        edStoun.setText(String.valueOf(roundUp(result,4)));
                        result = (num + 0);
                        edEnTonna.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 1.01605);
                        edTonna.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 1.12);
                        edAmTonna.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 5080000);
                        edCt.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 15680000);
                        edGranum.setText(String.valueOf(roundUp(result,5)));
                        break;

                    case 8:
                        result = (num * 1e+12);
                        edMicroGr.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 1e+9);
                        edMmGr.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 1e+6);
                        edGr.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 35274);
                        edUnci.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 1000);
                        edKg.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 2204.62);
                        edFunt.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 160);
                        edStoun.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.984207);
                        edEnTonna.setText(String.valueOf(roundUp(result,4)));
                        result = (num + 0);
                        edTonna.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 1.10231);
                        edAmTonna.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 5000000);
                        edCt.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 15430000);
                        edGranum.setText(String.valueOf(roundUp(result,5)));
                        break;

                    case 9:
                        result = (num * 9.072e+11);
                        edMicroGr.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 9.072e+8);
                        edMmGr.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 907185);
                        edGr.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 32000);
                        edUnci.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 907.185);
                        edKg.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 2000);
                        edFunt.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 142.857);
                        edStoun.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.892857);
                        edEnTonna.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.907185);
                        edTonna.setText(String.valueOf(roundUp(result,4)));
                        result = (num + 0);
                        edAmTonna.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 4536000);
                        edCt.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 14000000);
                        edGranum.setText(String.valueOf(roundUp(result,5)));
                        break;

                    case 10:
                        result = (num * 200000);
                        edMicroGr.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 200);
                        edMmGr.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.2);
                        edGr.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.007055);
                        edUnci.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.0002);
                        edKg.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.000536);
                        edFunt.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.0000315);
                        edStoun.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.000000197);
                        edEnTonna.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.0000002);
                        edTonna.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.0000002205);
                        edAmTonna.setText(String.valueOf(roundUp(result,4)));
                        result = (num + 0);
                        edCt.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 3.086);
                        edGranum.setText(String.valueOf(roundUp(result,5)));
                        break;
                    case 11:
                        result = (num * 64800);
                        edMicroGr.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 64.8);
                        edMmGr.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.0648);
                        edGr.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.002286);
                        edUnci.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.0000648);
                        edKg.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.0001429);
                        edFunt.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.0000102);
                        edStoun.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.00000006378);
                        edEnTonna.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.0000000648);
                        edTonna.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.00000007143);
                        edAmTonna.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.324);
                        edCt.setText(String.valueOf(roundUp(result,4)));
                        result = (num + 0);
                        edGranum.setText(String.valueOf(roundUp(result,5)));
                        break;
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }

    public void beforeTextChanged(CharSequence s, int start, int count, int after) {





    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

        double result = 0;
        double num = 0;

        if (TextUtils.isEmpty(edNum.getText().toString())
                ||  (edNum.getText().toString().equals("."))
                ||  (edNum.getText().toString().equals("-"))){


            edTonna.setText("");
            edAmTonna.setText("");
            edEnTonna.setText("");
            edKg.setText("");
            edStoun.setText("");
            edFunt.setText("");
            edUnci.setText("");
            edGr.setText("");
            edMmGr.setText("");
            edMicroGr.setText("");
            edCt.setText("");
            edGranum.setText("");
            return;
        }

        num = Double.parseDouble(edNum.getText().toString());

        switch (a) {
            case 0:

                result = (num + 0);
                edMicroGr.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.001);
                edMmGr.setText(String.valueOf(roundUp(result,4)));
                result = (num * 1e-6);
                edGr.setText(String.valueOf(roundUp(result,4)));
                result = (num * 3.5274e-8);
                edUnci.setText(String.valueOf(roundUp(result,4)));
                result = (num * 1e-9);
                edKg.setText(String.valueOf(roundUp(result,4)));
                result = (num * 2.204e-9);
                edFunt.setText(String.valueOf(roundUp(result,4)));
                result = (num * 1.57e-10);
                edStoun.setText(String.valueOf(roundUp(result,4)));
                result = (num * 9.8421e-13);
                edEnTonna.setText(String.valueOf(roundUp(result,4)));
                result = (num * 1e-12);
                edTonna.setText(String.valueOf(roundUp(result,4)));
                result = (num * 1.11e-12);
                edAmTonna.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.000005);
                edCt.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.00001543);
                edGranum.setText(String.valueOf(roundUp(result,5)));

                break;

            case 1:
                result = (num * 1000);
                edMicroGr.setText(String.valueOf(roundUp(result,4)));
                result = (num + 0);
                edMmGr.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.001);
                edGr.setText(String.valueOf(roundUp(result,4)));
                result = (num * 3.5274e-5);
                edUnci.setText(String.valueOf(roundUp(result,4)));
                result = (num * 1e-6);
                edKg.setText(String.valueOf(roundUp(result,4)));
                result = (num * 2.2046e-6);
                edFunt.setText(String.valueOf(roundUp(result,4)));
                result = (num * 1.5757e-7);
                edStoun.setText(String.valueOf(roundUp(result,4)));
                result = (num * 9.8421e-10);
                edEnTonna.setText(String.valueOf(roundUp(result,4)));
                result = (num * 1e-9);
                edTonna.setText(String.valueOf(roundUp(result,4)));
                result = (num * 1.1023e-9);
                edAmTonna.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.005);
                edCt.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.01543);
                edGranum.setText(String.valueOf(roundUp(result,5)));

                break;

            case 2:
                result = (num * 1e+6);
                edMicroGr.setText(String.valueOf(roundUp(result,4)));
                result = (num * 1000);
                edMmGr.setText(String.valueOf(roundUp(result,4)));
                result = (num + 0);
                edGr.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.035274);
                edUnci.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.001);
                edKg.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.0022);
                edFunt.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.000157);
                edStoun.setText(String.valueOf(roundUp(result,4)));
                result = (num * 9.8421e-7);
                edEnTonna.setText(String.valueOf(roundUp(result,4)));
                result = (num * 1e-6);
                edTonna.setText(String.valueOf(roundUp(result,4)));
                result = (num * 1.1023e-6);
                edAmTonna.setText(String.valueOf(roundUp(result,4)));
                result = (num * 5);
                edCt.setText(String.valueOf(roundUp(result,4)));
                result = (num * 15.43);
                edGranum.setText(String.valueOf(roundUp(result,5)));

                break;

            case 3:
                result = (num * 2.835e+7);
                edMicroGr.setText(String.valueOf(roundUp(result,4)));
                result = (num * 28349.5);
                edMmGr.setText(String.valueOf(roundUp(result,4)));
                result = (num * 28.34);
                edGr.setText(String.valueOf(roundUp(result,4)));
                result = (num + 0);
                edUnci.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.0283);
                edKg.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.0625);
                edFunt.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.004465);
                edStoun.setText(String.valueOf(roundUp(result,4)));
                result = (num * 2.7902e-5);
                edEnTonna.setText(String.valueOf(roundUp(result,4)));
                result = (num * 2.835e-5);
                edTonna.setText(String.valueOf(roundUp(result,4)));
                result = (num * 3.125e-5);
                edAmTonna.setText(String.valueOf(roundUp(result,4)));
                result = (num * 141.7);
                edCt.setText(String.valueOf(roundUp(result,4)));
                result = (num * 437.5);
                edGranum.setText(String.valueOf(roundUp(result,5)));

                break;

            case 4:
                result = (num * 1e+9);
                edMicroGr.setText(String.valueOf(roundUp(result,4)));
                result = (num * 1e+6);
                edMmGr.setText(String.valueOf(roundUp(result,4)));
                result = (num * 1000);
                edGr.setText(String.valueOf(roundUp(result,4)));
                result = (num * 35.274);
                edUnci.setText(String.valueOf(roundUp(result,4)));
                result = (num + 0);
                edKg.setText(String.valueOf(roundUp(result,4)));
                result = (num * 2.20462);
                edFunt.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.157473);
                edStoun.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.00098);
                edEnTonna.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.001);
                edTonna.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.0011);
                edAmTonna.setText(String.valueOf(roundUp(result,4)));
                result = (num * 5000);
                edCt.setText(String.valueOf(roundUp(result,4)));
                result = (num * 15430);
                edGranum.setText(String.valueOf(roundUp(result,5)));

                break;

            case 5:
                result = (num * 4.536e+8);
                edMicroGr.setText(String.valueOf(roundUp(result,4)));
                result = (num * 453592);
                edMmGr.setText(String.valueOf(roundUp(result,4)));
                result = (num * 453.592);
                edGr.setText(String.valueOf(roundUp(result,4)));
                result = (num * 16);
                edUnci.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.4535);
                edKg.setText(String.valueOf(roundUp(result,4)));
                result = (num + 0);
                edFunt.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.0714);
                edStoun.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.000446429);
                edEnTonna.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.0004535);
                edTonna.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.0005);
                edAmTonna.setText(String.valueOf(roundUp(result,4)));
                result = (num * 2268);
                edCt.setText(String.valueOf(roundUp(result,4)));
                result = (num * 7000);
                edGranum.setText(String.valueOf(roundUp(result,5)));

                break;

            case 6:
                result = (num * 6.35e+9);
                edMicroGr.setText(String.valueOf(roundUp(result,4)));
                result = (num * 6.35e+6);
                edMmGr.setText(String.valueOf(roundUp(result,4)));
                result = (num * 6350.29);
                edGr.setText(String.valueOf(roundUp(result,4)));
                result = (num * 224);
                edUnci.setText(String.valueOf(roundUp(result,4)));
                result = (num * 6.35);
                edKg.setText(String.valueOf(roundUp(result,4)));
                result = (num * 14);
                edFunt.setText(String.valueOf(roundUp(result,4)));
                result = (num + 0);
                edStoun.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.00625);
                edEnTonna.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.00635);
                edTonna.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.007);
                edAmTonna.setText(String.valueOf(roundUp(result,4)));
                result = (num * 31750);
                edCt.setText(String.valueOf(roundUp(result,4)));
                result = (num * 98000);
                edGranum.setText(String.valueOf(roundUp(result,5)));

                break;

            case 7:
                result = (num * 1.016e+12);
                edMicroGr.setText(String.valueOf(roundUp(result,4)));
                result = (num * 1.016e+9);
                edMmGr.setText(String.valueOf(roundUp(result,4)));
                result = (num * 1.016e+6);
                edGr.setText(String.valueOf(roundUp(result,4)));
                result = (num * 35840);
                edUnci.setText(String.valueOf(roundUp(result,4)));
                result = (num * 1016.05);
                edKg.setText(String.valueOf(roundUp(result,4)));
                result = (num * 2240);
                edFunt.setText(String.valueOf(roundUp(result,4)));
                result = (num * 160);
                edStoun.setText(String.valueOf(roundUp(result,4)));
                result = (num + 0);
                edEnTonna.setText(String.valueOf(roundUp(result,4)));
                result = (num * 1.01605);
                edTonna.setText(String.valueOf(roundUp(result,4)));
                result = (num * 1.12);
                edAmTonna.setText(String.valueOf(roundUp(result,4)));
                result = (num * 5080000);
                edCt.setText(String.valueOf(roundUp(result,4)));
                result = (num * 15680000);
                edGranum.setText(String.valueOf(roundUp(result,5)));

                break;

            case 8:
                result = (num * 1e+12);
                edMicroGr.setText(String.valueOf(roundUp(result,4)));
                result = (num * 1e+9);
                edMmGr.setText(String.valueOf(roundUp(result,4)));
                result = (num * 1e+6);
                edGr.setText(String.valueOf(roundUp(result,4)));
                result = (num * 35274);
                edUnci.setText(String.valueOf(roundUp(result,4)));
                result = (num * 1000);
                edKg.setText(String.valueOf(roundUp(result,4)));
                result = (num * 2204.62);
                edFunt.setText(String.valueOf(roundUp(result,4)));
                result = (num * 160);
                edStoun.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.984207);
                edEnTonna.setText(String.valueOf(roundUp(result,4)));
                result = (num + 0);
                edTonna.setText(String.valueOf(roundUp(result,4)));
                result = (num * 1.10231);
                edAmTonna.setText(String.valueOf(roundUp(result,4)));
                result = (num * 5000000);
                edCt.setText(String.valueOf(roundUp(result,4)));
                result = (num * 15430000);
                edGranum.setText(String.valueOf(roundUp(result,5)));

                break;

            case 9:
                result = (num * 9.072e+11);
                edMicroGr.setText(String.valueOf(roundUp(result,4)));
                result = (num * 9.072e+8);
                edMmGr.setText(String.valueOf(roundUp(result,4)));
                result = (num * 907185);
                edGr.setText(String.valueOf(roundUp(result,4)));
                result = (num * 32000);
                edUnci.setText(String.valueOf(roundUp(result,4)));
                result = (num * 907.185);
                edKg.setText(String.valueOf(roundUp(result,4)));
                result = (num * 2000);
                edFunt.setText(String.valueOf(roundUp(result,4)));
                result = (num * 142.857);
                edStoun.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.892857);
                edEnTonna.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.907185);
                edTonna.setText(String.valueOf(roundUp(result,4)));
                result = (num + 0);
                edAmTonna.setText(String.valueOf(roundUp(result,4)));
                result = (num * 4536000);
                edCt.setText(String.valueOf(roundUp(result,4)));
                result = (num * 14000000);
                edGranum.setText(String.valueOf(roundUp(result,5)));

                break;

            case 10:
                result = (num * 200000);
                edMicroGr.setText(String.valueOf(roundUp(result,4)));
                result = (num * 200);
                edMmGr.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.2);
                edGr.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.007055);
                edUnci.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.0002);
                edKg.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.000536);
                edFunt.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.0000315);
                edStoun.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.000000197);
                edEnTonna.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.0000002);
                edTonna.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.0000002205);
                edAmTonna.setText(String.valueOf(roundUp(result,4)));
                result = (num + 0);
                edCt.setText(String.valueOf(roundUp(result,4)));
                result = (num * 3.086);
                edGranum.setText(String.valueOf(roundUp(result,5)));

                break;
            case 11:
                result = (num * 64800);
                edMicroGr.setText(String.valueOf(roundUp(result,4)));
                result = (num * 64.8);
                edMmGr.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.0648);
                edGr.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.002286);
                edUnci.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.0000648);
                edKg.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.0001429);
                edFunt.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.0000102);
                edStoun.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.00000006378);
                edEnTonna.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.0000000648);
                edTonna.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.00000007143);
                edAmTonna.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.324);
                edCt.setText(String.valueOf(roundUp(result,4)));
                result = (num + 0);
                edGranum.setText(String.valueOf(roundUp(result,5)));

                break;


        }

    }

    @Override
    public void afterTextChanged(Editable s) {



    }

    public int getColor() {
        SharedPreferences mSharedPref = getSharedPreferences("ThemeColor", MODE_PRIVATE);
        int selectedColor = mSharedPref.getInt("color", getResources().getColor(R.color.brown_colorPrimary));
        return selectedColor;
    }

    private int getBackgroundColor() {
        SharedPreferences mSharedPref = getSharedPreferences("ThemeColor", MODE_PRIVATE);
        int selectedBackColor = mSharedPref.getInt("backcolor", getResources().getColor(R.color.dark_backgroundColorActivity));
        return selectedBackColor;
    }

    private int getTextColor() {

        SharedPreferences mSharedPref = getSharedPreferences("ThemeColor", MODE_PRIVATE);
        int textColor = mSharedPref.getInt("textColorMain", getResources().getColor(R.color.dark_textColorActivity));
        return textColor;


    }

    private int getEditTextColor() {

        SharedPreferences mSharedPref = getSharedPreferences("ThemeColor", MODE_PRIVATE);
        int textColor = mSharedPref.getInt("textEditColor", getResources().getColor(R.color.dark_editTextActivity));
        return textColor;


    }

    private int getEditTextActivityColor() {

        SharedPreferences mSharedPref = getSharedPreferences("ThemeColor", MODE_PRIVATE);
        int textColor = mSharedPref.getInt("textEditColorActivity", getResources().getColor(R.color.dark_editTextColorActivity));
        return textColor;

    }

}



