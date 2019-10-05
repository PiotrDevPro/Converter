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

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.math.BigDecimal;

public class EnergyActivity extends AppCompatActivity implements TextWatcher {

  //  String[] data = {"Джоуль (J)", "Килоджоуль (kJ)", "Грамм-колория (gkal)", "Килокалория (kcal)", "Ватт час (W*h)", "Киловатт час (kW*h)", "Британская терм.единица (BTU)", "Американский терм (US therm)", "Фут-фунт (ft*lbs)"};
    int a;
    Spinner spMassa;
    EditText edNum, edJ, edKj, edGkal, edKcal, edWh, edKwh, edBTU, edUSterm, edFtLbs;
   // TextView tvPosName;

    public BigDecimal roundUp(double value, int digits) {
        return new BigDecimal("" + value).setScale(digits, BigDecimal.ROUND_HALF_UP);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.energy);

        Toolbar my_toolbar = (Toolbar) findViewById(R.id.my_toolbar_app);
        RelativeLayout backColorlayoutAds = (RelativeLayout) findViewById(R.id.reLayoutEnergyAds);
        CollapsingToolbarLayout bottomColorLayout = (CollapsingToolbarLayout) findViewById(R.id.EnergyottomLayout);
        CoordinatorLayout corLoyDlinna = (CoordinatorLayout) findViewById(R.id.corLoyoutEnergy);

        setSupportActionBar(my_toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,// data);
      //  adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        getResources().getStringArray(R.array.energy));

        spMassa = (Spinner) findViewById(R.id.spMassa);
        spMassa.setAdapter(adapter);

        edNum = (EditText) findViewById(R.id.edNum);
       // tvPosName = (TextView) findViewById(R.id.tvPosName);

        TextView Nm = (TextView) findViewById(R.id.J);
        TextView Km = (TextView) findViewById(R.id.kJ);
        TextView Mile = (TextView) findViewById(R.id.gkal);
        TextView m = (TextView) findViewById(R.id.Kcal);
        TextView yard = (TextView)  findViewById(R.id.Wh);
        TextView ft = (TextView)  findViewById(R.id.kWh);
        TextView In = (TextView)  findViewById(R.id.BTU);
        TextView Sm = (TextView)  findViewById(R.id.Usterm);
        TextView mm = (TextView)  findViewById(R.id.foot);


        edJ = (EditText) findViewById(R.id.edJ);
        edKj = (EditText) findViewById(R.id.edKj);
        edGkal = (EditText) findViewById(R.id.edGkal);
        edKcal = (EditText) findViewById(R.id.edKcal);

        edWh = (EditText) findViewById(R.id.edWh);
        edKwh = (EditText) findViewById(R.id.edKwh);
        edBTU = (EditText) findViewById(R.id.edBTU);
        edUSterm = (EditText) findViewById(R.id.edUSterm);

        edFtLbs = (EditText) findViewById(R.id.edFtLbs);

        if (getColor() != getResources().getColor(R.color.colorPrimary)) {

            my_toolbar.setBackgroundColor(getBackgroundColor());
            backColorlayoutAds.setBackgroundColor(getColor());
            bottomColorLayout.setBackgroundColor(getColor());
            corLoyDlinna.setBackgroundColor(getBackgroundColor());

            Nm.setTextColor(getTextColor());
            Km.setTextColor(getTextColor());
            Mile.setTextColor(getTextColor());
            m.setTextColor(getTextColor());
            yard.setTextColor(getTextColor());
            ft.setTextColor(getTextColor());
            In.setTextColor(getTextColor());
            Sm.setTextColor(getTextColor());
            mm.setTextColor(getTextColor());



            edJ.setBackgroundColor(getEditTextActivityColor());
            edJ.setTextColor(getEditTextColor());
            edKj.setBackgroundColor(getEditTextActivityColor());
            edKj.setTextColor(getEditTextColor());
            edGkal.setBackgroundColor(getEditTextActivityColor());
            edGkal.setTextColor(getEditTextColor());
            edKcal.setBackgroundColor(getEditTextActivityColor());
            edKcal.setTextColor(getEditTextColor());
            edWh.setBackgroundColor(getEditTextActivityColor());
            edWh.setTextColor(getEditTextColor());
            edKwh.setBackgroundColor(getEditTextActivityColor());
            edKwh.setTextColor(getEditTextColor());
            edBTU.setBackgroundColor(getEditTextActivityColor());
            edBTU.setTextColor(getEditTextColor());
            edUSterm.setBackgroundColor(getEditTextActivityColor());
            edUSterm.setTextColor(getEditTextColor());
            edFtLbs.setBackgroundColor(getEditTextActivityColor());
            edFtLbs.setTextColor(getEditTextColor());


            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                getWindow().setStatusBarColor(getColor());
            }
        }

        edNum.addTextChangedListener(this);
        edNum.requestFocus();
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

                    edJ.setText("");
                    edKj.setText("");
                    edGkal.setText("");
                    edKcal.setText("");
                    edWh.setText("");
                    edKwh.setText("");
                    edBTU.setText("");
                    edUSterm.setText("");
                    edFtLbs.setText("");


                    return;

                }


                num = Double.parseDouble(edNum.getText().toString()); {
                    switch (position) {
                        case 0:

                            result = (num + 0);
                            edJ.setText(String.valueOf(roundUp(result,4)));
                            result = (num * 0.001);
                            edKj.setText(String.valueOf(roundUp(result,4)));
                            result = (num * 0.239);
                            edGkal.setText(String.valueOf(roundUp(result,4)));
                            result = (num*0.0002388);
                            edKcal.setText(String.valueOf(roundUp(result,4)));
                            result = (num * 0.0002778);
                            edWh.setText(String.valueOf(roundUp(result,4)));
                            result = (num*2.78e-7);
                            edKwh.setText(String.valueOf(roundUp(result,4)));
                            result = (num * 0.0009478);
                            edBTU.setText(String.valueOf(roundUp(result,4)));
                            result = (num*9.4804e-9);
                            edUSterm.setText(String.valueOf(roundUp(result,4)));
                            result = (num*0.7376);
                            edFtLbs.setText(String.valueOf(roundUp(result,4)));

                            break;

                        case 1:
                            result = (num * 1000);
                            edJ.setText(String.valueOf(roundUp(result,4)));
                            result = (num + 0);
                            edKj.setText(String.valueOf(roundUp(result,4)));
                            result = (num * 239.1);
                            edGkal.setText(String.valueOf(roundUp(result,4)));
                            result = (num*0.2388);
                            edKcal.setText(String.valueOf(roundUp(result,4)));
                            result = (num * 0.2778);
                            edWh.setText(String.valueOf(roundUp(result,4)));
                            result = (num*0.0002778);
                            edKwh.setText(String.valueOf(roundUp(result,4)));
                            result = (num * 0.9478);
                            edBTU.setText(String.valueOf(roundUp(result,4)));
                            result = (num*9.4804e-6);
                            edUSterm.setText(String.valueOf(roundUp(result,4)));
                            result = (num*737.6);
                            edFtLbs.setText(String.valueOf(roundUp(result,4)));
                            break;

                        case 2:
                            result = (num * 4.184);
                            edJ.setText(String.valueOf(roundUp(result,4)));
                            result = (num * 0.004184);
                            edKj.setText(String.valueOf(roundUp(result,4)));
                            result = (num + 0);
                            edGkal.setText(String.valueOf(roundUp(result,4)));
                            result = (num*0.001);
                            edKcal.setText(String.valueOf(roundUp(result,4)));
                            result = (num * 0.00116222);
                            edWh.setText(String.valueOf(roundUp(result,4)));
                            result = (num*1.1622e-6);
                            edKwh.setText(String.valueOf(roundUp(result,4)));
                            result = (num * 0.00396567);
                            edBTU.setText(String.valueOf(roundUp(result,4)));
                            result = (num*3.9666e-8);
                            edUSterm.setText(String.valueOf(roundUp(result,4)));
                            result = (num*3.08596);
                            edFtLbs.setText(String.valueOf(roundUp(result,4)));
                            break;

                        case 3:
                            result = (num * 4184);
                            edJ.setText(String.valueOf(roundUp(result,4)));
                            result = (num * 4.184);
                            edKj.setText(String.valueOf(roundUp(result,4)));
                            result = (num * 1000);
                            edGkal.setText(String.valueOf(roundUp(result,4)));
                            result = (num+0);
                            edKcal.setText(String.valueOf(roundUp(result,4)));
                            result = (num * 1.16222);
                            edWh.setText(String.valueOf(roundUp(result,4)));
                            result = (num*0.00116222);
                            edKwh.setText(String.valueOf(roundUp(result,4)));
                            result = (num * 3.96567);
                            edBTU.setText(String.valueOf(roundUp(result,4)));
                            result = (num*3.9666e-5);
                            edUSterm.setText(String.valueOf(roundUp(result,4)));
                            result = (num*3085.96);
                            edFtLbs.setText(String.valueOf(roundUp(result,4)));
                            break;

                        case 4:

                            result = (num * 3600);
                            edJ.setText(String.valueOf(roundUp(result,4)));
                            result = (num * 3.6);
                            edKj.setText(String.valueOf(roundUp(result,4)));
                            result = (num * 860.421);
                            edGkal.setText(String.valueOf(roundUp(result,4)));
                            result = (num*0.860421);
                            edKcal.setText(String.valueOf(roundUp(result,4)));
                            result = (num + 0);
                            edWh.setText(String.valueOf(roundUp(result,4)));
                            result = (num*0.001);
                            edKwh.setText(String.valueOf(roundUp(result,4)));
                            result = (num * 3.41214);
                            edBTU.setText(String.valueOf(roundUp(result,4)));
                            result = (num*3.413e-5);
                            edUSterm.setText(String.valueOf(roundUp(result,4)));
                            result = (num*2655.22);
                            edFtLbs.setText(String.valueOf(roundUp(result,4)));
                            break;

                        case 5:
                            result = (num * 3.6e+6);
                            edJ.setText(String.valueOf(roundUp(result,4)));
                            result = (num * 3600);
                            edKj.setText(String.valueOf(roundUp(result,4)));
                            result = (num * 860421);
                            edGkal.setText(String.valueOf(roundUp(result,4)));
                            result = (num*860.421);
                            edKcal.setText(String.valueOf(roundUp(result,4)));
                            result = (num *1000);
                            edWh.setText(String.valueOf(roundUp(result,4)));
                            result = (num+0);
                            edKwh.setText(String.valueOf(roundUp(result,4)));
                            result = (num * 3412.2);
                            edBTU.setText(String.valueOf(roundUp(result,4)));
                            result = (num*0.0341296);
                            edUSterm.setText(String.valueOf(roundUp(result,4)));
                            result = (num*2.655e+6);
                            edFtLbs.setText(String.valueOf(roundUp(result,4)));
                            break;

                        case 6:
                            result = (num * 1055.06);
                            edJ.setText(String.valueOf(roundUp(result,4)));
                            result = (num * 1.05506);
                            edKj.setText(String.valueOf(roundUp(result,4)));
                            result = (num * 252.164);
                            edGkal.setText(String.valueOf(roundUp(result,4)));
                            result = (num*0.252164);
                            edKcal.setText(String.valueOf(roundUp(result,4)));
                            result = (num *0.293071);
                            edWh.setText(String.valueOf(roundUp(result,4)));
                            result = (num*0.000293071);
                            edKwh.setText(String.valueOf(roundUp(result,4)));
                            result = (num +0);
                            edBTU.setText(String.valueOf(roundUp(result,4)));
                            result = (num*1.0002e-5);
                            edUSterm.setText(String.valueOf(roundUp(result,4)));
                            result = (num*778.169);
                            edFtLbs.setText(String.valueOf(roundUp(result,4)));
                            break;

                        case 7:
                            result = (num * 1.055e+8);
                            edJ.setText(String.valueOf(roundUp(result,4)));
                            result = (num * 105480);
                            edKj.setText(String.valueOf(roundUp(result,4)));
                            result = (num * 2.521e+7);
                            edGkal.setText(String.valueOf(roundUp(result,4)));
                            result = (num*25210.4);
                            edKcal.setText(String.valueOf(roundUp(result,4)));
                            result = (num *29300.1);
                            edWh.setText(String.valueOf(roundUp(result,4)));
                            result = (num*29.3001);
                            edKwh.setText(String.valueOf(roundUp(result,4)));
                            result = (num *99976.1);
                            edBTU.setText(String.valueOf(roundUp(result,4)));
                            result = (num+0);
                            edUSterm.setText(String.valueOf(roundUp(result,4)));
                            result = (num*7.78e+7);
                            edFtLbs.setText(String.valueOf(roundUp(result,4)));
                            break;

                        case 8:
                            result = (num * 1.35582);
                            edJ.setText(String.valueOf(roundUp(result,4)));
                            result = (num * 0.00135582);
                            edKj.setText(String.valueOf(roundUp(result,4)));
                            result = (num * 0.324048);
                            edGkal.setText(String.valueOf(roundUp(result,4)));
                            result = (num*0.000324048);
                            edKcal.setText(String.valueOf(roundUp(result,4)));
                            result = (num *0.000376616);
                            edWh.setText(String.valueOf(roundUp(result,4)));
                            result = (num*3.7662e-7);
                            edKwh.setText(String.valueOf(roundUp(result,4)));
                            result = (num *0.00128507);
                            edBTU.setText(String.valueOf(roundUp(result,4)));
                            result = (num*1.2854e-8);
                            edUSterm.setText(String.valueOf(roundUp(result,4)));
                            result = (num+0);
                            edFtLbs.setText(String.valueOf(roundUp(result,4)));
                            break;



                    }
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

        if (TextUtils.isEmpty(edNum.getText().toString())
                ||  (edNum.getText().toString().equals("."))
                ||  (edNum.getText().toString().equals("-"))){

            edJ.setText("");
            edKj.setText("");
            edGkal.setText("");
            edKcal.setText("");
            edWh.setText("");
            edKwh.setText("");
            edBTU.setText("");
            edUSterm.setText("");
            edFtLbs.setText("");


            return;
        }
        num = Double.parseDouble(edNum.getText().toString());

        switch (a)
        {
            case 0:
                result = (num + 0);
                edJ.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.001);
                edKj.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.239);
                edGkal.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.0002388);
                edKcal.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.0002778);
                edWh.setText(String.valueOf(roundUp(result,4)));
                result = (num*2.78e-7);
                edKwh.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.0009478);
                edBTU.setText(String.valueOf(roundUp(result,4)));
                result = (num*9.4804e-9);
                edUSterm.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.7376);
                edFtLbs.setText(String.valueOf(roundUp(result,4)));

                break;
            case 1:
                result = (num * 1000);
                edJ.setText(String.valueOf(roundUp(result,4)));
                result = (num + 0);
                edKj.setText(String.valueOf(roundUp(result,4)));
                result = (num * 239.1);
                edGkal.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.2388);
                edKcal.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.2778);
                edWh.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.0002778);
                edKwh.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.9478);
                edBTU.setText(String.valueOf(roundUp(result,4)));
                result = (num*9.4804e-6);
                edUSterm.setText(String.valueOf(roundUp(result,4)));
                result = (num*737.6);
                edFtLbs.setText(String.valueOf(roundUp(result,4)));

                break;
            case 2:
                result = (num * 4.184);
                edJ.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.004184);
                edKj.setText(String.valueOf(roundUp(result,4)));
                result = (num + 0);
                edGkal.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.001);
                edKcal.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.00116222);
                edWh.setText(String.valueOf(roundUp(result,4)));
                result = (num*1.1622e-6);
                edKwh.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.00396567);
                edBTU.setText(String.valueOf(roundUp(result,4)));
                result = (num*3.9666e-8);
                edUSterm.setText(String.valueOf(roundUp(result,4)));
                result = (num*3.08596);
                edFtLbs.setText(String.valueOf(roundUp(result,4)));
                break;
            case 3:
                result = (num * 4184);
                edJ.setText(String.valueOf(roundUp(result,4)));
                result = (num * 4.184);
                edKj.setText(String.valueOf(roundUp(result,4)));
                result = (num * 1000);
                edGkal.setText(String.valueOf(roundUp(result,4)));
                result = (num+0);
                edKcal.setText(String.valueOf(roundUp(result,4)));
                result = (num * 1.16222);
                edWh.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.00116222);
                edKwh.setText(String.valueOf(roundUp(result,4)));
                result = (num * 3.96567);
                edBTU.setText(String.valueOf(roundUp(result,4)));
                result = (num*3.9666e-5);
                edUSterm.setText(String.valueOf(roundUp(result,4)));
                result = (num*3085.96);
                edFtLbs.setText(String.valueOf(roundUp(result,4)));

                break;

            case 4:

                result = (num * 3600);
                edJ.setText(String.valueOf(roundUp(result,4)));
                result = (num * 3.6);
                edKj.setText(String.valueOf(roundUp(result,4)));
                result = (num * 860.421);
                edGkal.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.860421);
                edKcal.setText(String.valueOf(roundUp(result,4)));
                result = (num + 0);
                edWh.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.001);
                edKwh.setText(String.valueOf(roundUp(result,4)));
                result = (num * 3.41214);
                edBTU.setText(String.valueOf(roundUp(result,4)));
                result = (num*3.413e-5);
                edUSterm.setText(String.valueOf(roundUp(result,4)));
                result = (num*2655.22);
                edFtLbs.setText(String.valueOf(roundUp(result,4)));

                break;

            case 5:
                result = (num * 3.6e+6);
                edJ.setText(String.valueOf(roundUp(result,4)));
                result = (num * 3600);
                edKj.setText(String.valueOf(roundUp(result,4)));
                result = (num * 860421);
                edGkal.setText(String.valueOf(roundUp(result,4)));
                result = (num*860.421);
                edKcal.setText(String.valueOf(roundUp(result,4)));
                result = (num *1000);
                edWh.setText(String.valueOf(roundUp(result,4)));
                result = (num+0);
                edKwh.setText(String.valueOf(roundUp(result,4)));
                result = (num * 3412.2);
                edBTU.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.0341296);
                edUSterm.setText(String.valueOf(roundUp(result,4)));
                result = (num*2.655e+6);
                edFtLbs.setText(String.valueOf(roundUp(result,4)));

                break;

            case 6:
                result = (num * 1055.06);
                edJ.setText(String.valueOf(roundUp(result,4)));
                result = (num * 1.05506);
                edKj.setText(String.valueOf(roundUp(result,4)));
                result = (num * 252.164);
                edGkal.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.252164);
                edKcal.setText(String.valueOf(roundUp(result,4)));
                result = (num *0.293071);
                edWh.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.000293071);
                edKwh.setText(String.valueOf(roundUp(result,4)));
                result = (num +0);
                edBTU.setText(String.valueOf(roundUp(result,4)));
                result = (num*1.0002e-5);
                edUSterm.setText(String.valueOf(roundUp(result,4)));
                result = (num*778.169);
                edFtLbs.setText(String.valueOf(roundUp(result,4)));

                break;
            case 7:
                result = (num * 1.055e+8);
                edJ.setText(String.valueOf(roundUp(result,4)));
                result = (num * 105480);
                edKj.setText(String.valueOf(roundUp(result,4)));
                result = (num * 2.521e+7);
                edGkal.setText(String.valueOf(roundUp(result,4)));
                result = (num*25210.4);
                edKcal.setText(String.valueOf(roundUp(result,4)));
                result = (num *29300.1);
                edWh.setText(String.valueOf(roundUp(result,4)));
                result = (num*29.3001);
                edKwh.setText(String.valueOf(roundUp(result,4)));
                result = (num *99976.1);
                edBTU.setText(String.valueOf(roundUp(result,4)));
                result = (num+0);
                edUSterm.setText(String.valueOf(roundUp(result,4)));
                result = (num*7.78e+7);
                edFtLbs.setText(String.valueOf(roundUp(result,4)));
                break;

            case 8:
                result = (num * 1.35582);
                edJ.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.00135582);
                edKj.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.324048);
                edGkal.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.000324048);
                edKcal.setText(String.valueOf(roundUp(result,4)));
                result = (num *0.000376616);
                edWh.setText(String.valueOf(roundUp(result,4)));
                result = (num*3.7662e-7);
                edKwh.setText(String.valueOf(roundUp(result,4)));
                result = (num *0.00128507);
                edBTU.setText(String.valueOf(roundUp(result,4)));
                result = (num*1.2854e-8);
                edUSterm.setText(String.valueOf(roundUp(result,4)));
                result = (num+0);
                edFtLbs.setText(String.valueOf(roundUp(result,4)));
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


