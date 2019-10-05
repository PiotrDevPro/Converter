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

public class HerzActivity extends AppCompatActivity implements TextWatcher{

   // String[] data = {"Герц (Hz)", "Килогерц (KHz)", "Мегагерц (MHz)","Гигагерц (Ghz)","Радиан/час (rad/h)", "Радиан/мин (rad/min)", "Радиан/сек (rad/sec)","Оборот/мин (RPM)"};
    int a;
    Spinner spMassa;
    EditText edNum, edHz,edKhz,edMhz,edGhz,radh,radmin,radsec,RPM;
   // TextView tvPosName;

    public BigDecimal roundUp(double value, int digits) {
        return new BigDecimal("" + value).setScale(digits, BigDecimal.ROUND_HALF_UP);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.herz);

        Toolbar my_toolbar = (Toolbar) findViewById(R.id.my_toolbar_app);
        RelativeLayout backColorlayoutAds = (RelativeLayout) findViewById(R.id.reLayoutHzAds);
        CollapsingToolbarLayout bottomColorLayout = (CollapsingToolbarLayout) findViewById(R.id.HzottomLayout);
        CoordinatorLayout corLoyDlinna = (CoordinatorLayout) findViewById(R.id.corLoyoutHz);
        setSupportActionBar(my_toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,// data);
      //  adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                getResources().getStringArray(R.array.Herz));


        spMassa = (Spinner) findViewById(R.id.spMassa);
        spMassa.setAdapter(adapter);

      //  tvPosName = (TextView) findViewById(R.id.tvPosName);

        TextView Nm = (TextView) findViewById(R.id.Hz);
        TextView Km = (TextView) findViewById(R.id.KHz);
        TextView Mile = (TextView) findViewById(R.id.MHz);
        TextView m = (TextView) findViewById(R.id.GHz);
        TextView yard = (TextView)  findViewById(R.id.radhh);
        TextView ft = (TextView)  findViewById(R.id.radminn);
        TextView In = (TextView)  findViewById(R.id.radsecc);
        TextView Sm = (TextView)  findViewById(R.id.RPMM);



        edNum = (EditText) findViewById(R.id.edNum);

        edHz = (EditText) findViewById(R.id.edHz);
        edKhz = (EditText) findViewById(R.id.edKhz);
        edMhz = (EditText) findViewById(R.id.edMhz);
        edGhz = (EditText) findViewById(R.id.edGhz);

        radh = (EditText) findViewById(R.id.radh);
        radmin = (EditText) findViewById(R.id.radmin);
        radsec = (EditText) findViewById(R.id.radsec);
        RPM = (EditText) findViewById(R.id.RPM);

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




            edHz.setBackgroundColor(getEditTextActivityColor());
            edHz.setTextColor(getEditTextColor());
            edKhz.setBackgroundColor(getEditTextActivityColor());
            edKhz.setTextColor(getEditTextColor());
            edMhz.setBackgroundColor(getEditTextActivityColor());
            edMhz.setTextColor(getEditTextColor());
            edGhz.setBackgroundColor(getEditTextActivityColor());
            edGhz.setTextColor(getEditTextColor());
            radh.setBackgroundColor(getEditTextActivityColor());
            radh.setTextColor(getEditTextColor());
            radmin.setBackgroundColor(getEditTextActivityColor());
            radmin.setTextColor(getEditTextColor());
            radsec.setBackgroundColor(getEditTextActivityColor());
            radsec.setTextColor(getEditTextColor());
            RPM.setBackgroundColor(getEditTextActivityColor());
            RPM.setTextColor(getEditTextColor());



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
              //  tvPosName.setText(strName);
                a = position;

                double result = 0;
                double num = 0;

                if (TextUtils.isEmpty(edNum.getText().toString())
                        ||  (edNum.getText().toString().equals("."))
                        ||  (edNum.getText().toString().equals("-"))){

                    edHz.setText("");
                    edKhz.setText("");
                    edMhz.setText("");
                    edGhz.setText("");

                    radh.setText("");
                    radmin.setText("");
                    radsec.setText("");
                    RPM.setText("");


                    return;
                }

                num = Double.parseDouble(edNum.getText().toString());

                switch (position) {
                    case 0:
                        result =  num * 1;
                        edHz.setText(String.valueOf(roundUp(result,4)));
                        result =  num * 0.001;
                        edKhz.setText(String.valueOf(roundUp(result,4)));
                        result =  num * 1e-6;
                        edMhz.setText(String.valueOf(roundUp(result,4)));
                        result =  num * 1e-9;
                        edGhz.setText(String.valueOf(roundUp(result,4)));
                        result =  num * 22619.467;
                        radh.setText(String.valueOf(roundUp(result,4)));
                        result =  num * 376.991;
                        radmin.setText(String.valueOf(roundUp(result,4)));
                        result =  num * 6.283;
                        radsec.setText(String.valueOf(roundUp(result,4)));
                        result =  num * 60;
                        RPM.setText(String.valueOf(roundUp(result,4)));
                        break;
                    case 1:

                        result =  num * 1000;
                        edHz.setText(String.valueOf(roundUp(result,4)));
                        result =  num * 1;
                        edKhz.setText(String.valueOf(roundUp(result,4)));
                        result =  num * 0.001;
                        edMhz.setText(String.valueOf(roundUp(result,4)));
                        result =  num * 1e-6;
                        edGhz.setText(String.valueOf(roundUp(result,4)));
                        result =  num * 22619467;
                        radh.setText(String.valueOf(roundUp(result,4)));
                        result =  num * 376991.12;
                        radmin.setText(String.valueOf(roundUp(result,4)));
                        result =  num * 6283.185;
                        radsec.setText(String.valueOf(roundUp(result,4)));
                        result =  num * 60000;
                        RPM.setText(String.valueOf(roundUp(result,4)));
                        break;

                    case 2:

                        result =  num * 1e+6;
                        edHz.setText(String.valueOf(roundUp(result,4)));
                        result =  num * 1000;
                        edKhz.setText(String.valueOf(roundUp(result,4)));
                        result =  num + 0;
                        edMhz.setText(String.valueOf(roundUp(result,4)));
                        result =  num * 0.001;
                        edGhz.setText(String.valueOf(roundUp(result,4)));
                        result =  num * 2.2619e+10;
                        radh.setText(String.valueOf(roundUp(result,4)));
                        result =  num * 376991120;
                        radmin.setText(String.valueOf(roundUp(result,4)));
                        result =  num * 6283185.3;
                        radsec.setText(String.valueOf(roundUp(result,4)));
                        result =  num * 60000000;
                        RPM.setText(String.valueOf(roundUp(result,4)));
                        break;

                    case 3:
                        result =  num * 1e+9;
                        edHz.setText(String.valueOf(roundUp(result,4)));
                        result =  num * 1e+6;
                        edKhz.setText(String.valueOf(roundUp(result,4)));
                        result =  num * 1000;
                        edMhz.setText(String.valueOf(roundUp(result,4)));
                        result =  num + 0;
                        edGhz.setText(String.valueOf(roundUp(result,4)));

                        result =  num * 2.2619e+13;
                        radh.setText(String.valueOf(roundUp(result,4)));
                        result =  num * 3.77e+11;
                        radmin.setText(String.valueOf(roundUp(result,4)));
                        result =  num * 6.2832e+9;
                        radsec.setText(String.valueOf(roundUp(result,4)));
                        result =  num * 6e+10;
                        RPM.setText(String.valueOf(roundUp(result,4)));
                        break;

                    case 4:

                        result =  num / 22619.467;
                        edHz.setText(String.valueOf(roundUp(result,4)));
                        result =  num / 22619467;
                        edKhz.setText(String.valueOf(roundUp(result,4)));
                        result =  num / 2.2619e+10;
                        edMhz.setText(String.valueOf(roundUp(result,4)));
                        result =  num / 2.2619e+13;
                        edGhz.setText(String.valueOf(roundUp(result,4)));

                        result =  num + 0;
                        radh.setText(String.valueOf(roundUp(result,4)));
                        result =  num * 0.01667;
                        radmin.setText(String.valueOf(roundUp(result,4)));
                        result =  num * 0.0002778;
                        radsec.setText(String.valueOf(roundUp(result,4)));
                        result =  num * 0.002653;
                        RPM.setText(String.valueOf(roundUp(result,4)));
                        break;

                    case 5:

                        result =  (num / 22619467)*60;
                        edHz.setText(String.valueOf(roundUp(result,4)));
                        result =  (num / 2.2619e+10)*60;
                        edKhz.setText(String.valueOf(roundUp(result,4)));
                        result =  (num / 2.2619e+13)*60;
                        edMhz.setText(String.valueOf(roundUp(result,4)));
                        result =  (num / 2.2619e+16)*60;
                        edGhz.setText(String.valueOf(roundUp(result,4)));

                        result =  num * 60;
                        radh.setText(String.valueOf(roundUp(result,4)));
                        result =  num + 0;
                        radmin.setText(String.valueOf(roundUp(result,4)));
                        result =  num * 0.0017;
                        radsec.setText(String.valueOf(roundUp(result,4)));
                        result =  num * 0.159;
                        RPM.setText(String.valueOf(roundUp(result,4)));
                        break;

                    case 6:
                        result =  (num / 22619.467)*3600;
                        edHz.setText(String.valueOf(roundUp(result,4)));
                        result =  (num / 22619467)*3600;
                        edKhz.setText(String.valueOf(roundUp(result,4)));
                        result =  (num / 2.2619e+10)*3600;
                        edMhz.setText(String.valueOf(roundUp(result,4)));
                        result =  (num / 2.2619e+13)*3600;
                        edGhz.setText(String.valueOf(roundUp(result,4)));

                        result =  num * 3600;
                        radh.setText(String.valueOf(roundUp(result,4)));
                        result =  num * 60;
                        radmin.setText(String.valueOf(roundUp(result,4)));
                        result =  num + 0;
                        radsec.setText(String.valueOf(roundUp(result,4)));
                        result =  num *9.549;
                        RPM.setText(String.valueOf(roundUp(result,4)));
                        break;

                    case 7:
                        result =  num *0.01667;
                        edHz.setText(String.valueOf(roundUp(result,4)));
                        result =  num* 0.00001667;
                        edKhz.setText(String.valueOf(roundUp(result,4)));
                        result =  num* 0.00000001667;
                        edMhz.setText(String.valueOf(roundUp(result,4)));
                        result =  num* 0.00000000001667;
                        edGhz.setText(String.valueOf(roundUp(result,4)));

                        result =  num * 377;
                        radh.setText(String.valueOf(roundUp(result,4)));
                        result =  num * 6.283;
                        radmin.setText(String.valueOf(roundUp(result,4)));
                        result =  num * 0.1047;
                        radsec.setText(String.valueOf(roundUp(result,4)));
                        result =  num +0;
                        RPM.setText(String.valueOf(roundUp(result,4)));
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
        double num  = 0;

        if (TextUtils.isEmpty(edNum.getText().toString())
                ||  (edNum.getText().toString().equals("."))
                ||  (edNum.getText().toString().equals("-"))){

            edHz.setText("");
            edKhz.setText("");
            edMhz.setText("");
            edGhz.setText("");

            radh.setText("");
            radmin.setText("");
            radsec.setText("");
            RPM.setText("");

            return;
        }
        num = Double.parseDouble(edNum.getText().toString());{
            switch (a){
                case 0:
                    result =  num + 0;
                    edHz.setText(String.valueOf(roundUp(result,4)));
                    result =  num * 0.001;
                    edKhz.setText(String.valueOf(roundUp(result,4)));
                    result =  num * 1e-6;
                    edMhz.setText(String.valueOf(roundUp(result,4)));
                    result =  num * 1e-9;
                    edGhz.setText(String.valueOf(roundUp(result,4)));
                    result =  num * 22619.467;
                    radh.setText(String.valueOf(roundUp(result,4)));
                    result =  num * 376.991;
                    radmin.setText(String.valueOf(roundUp(result,4)));
                    result =  num * 6.283;
                    radsec.setText(String.valueOf(roundUp(result,4)));
                    result =  num * 60;
                    RPM.setText(String.valueOf(roundUp(result,4)));
                    break;
                case 1:

                    result =  num * 1000;
                    edHz.setText(String.valueOf(roundUp(result,4)));
                    result =  num * 1;
                    edKhz.setText(String.valueOf(roundUp(result,4)));
                    result =  num * 0.001;
                    edMhz.setText(String.valueOf(roundUp(result,4)));
                    result =  num * 1e-6;
                    edGhz.setText(String.valueOf(roundUp(result,4)));
                    result =  num * 22619467;
                    radh.setText(String.valueOf(roundUp(result,4)));
                    result =  num * 376991.12;
                    radmin.setText(String.valueOf(roundUp(result,4)));
                    result =  num * 6283.185;
                    radsec.setText(String.valueOf(roundUp(result,4)));
                    result =  num * 60000;
                    RPM.setText(String.valueOf(roundUp(result, 3)));

                    break;

                case 2:

                    result =  num * 1e+6;
                    edHz.setText(String.valueOf(roundUp(result,4)));
                    result =  num * 1000;
                    edKhz.setText(String.valueOf(roundUp(result,4)));
                    result =  num + 0;
                    edMhz.setText(String.valueOf(roundUp(result,4)));
                    result =  num * 0.001;
                    edGhz.setText(String.valueOf(roundUp(result,4)));
                    result =  num * 2.2619e+10;
                    radh.setText(String.valueOf(roundUp(result,4)));
                    result =  num * 376991120;
                    radmin.setText(String.valueOf(roundUp(result,4)));
                    result =  num * 6283185.3;
                    radsec.setText(String.valueOf(roundUp(result,4)));
                    result =  num * 60000000;
                    RPM.setText(String.valueOf(roundUp(result,4)));

                    break;

                case 3:
                    result =  num * 1e+9;
                    edHz.setText(String.valueOf(roundUp(result,4)));
                    result =  num * 1e+6;
                    edKhz.setText(String.valueOf(roundUp(result,4)));
                    result =  num * 1000;
                    edMhz.setText(String.valueOf(roundUp(result,4)));
                    result =  num + 0;
                    edGhz.setText(String.valueOf(roundUp(result,4)));

                    result =  num * 2.2619e+13;
                    radh.setText(String.valueOf(roundUp(result,4)));
                    result =  num * 3.77e+11;
                    radmin.setText(String.valueOf(roundUp(result,4)));
                    result =  num * 6.2832e+9;
                    radsec.setText(String.valueOf(roundUp(result,4)));
                    result =  num * 6e+10;
                    RPM.setText(String.valueOf(roundUp(result, 3)));

                    break;

                case 4:

                    result =  num / 22619.467;
                    edHz.setText(String.valueOf(roundUp(result,4)));
                    result =  num / 22619467;
                    edKhz.setText(String.valueOf(roundUp(result,4)));
                    result =  num / 2.2619e+10;
                    edMhz.setText(String.valueOf(roundUp(result,4)));
                    result =  num / 2.2619e+13;
                    edGhz.setText(String.valueOf(roundUp(result,4)));

                    result =  num + 0;
                    radh.setText(String.valueOf(roundUp(result,4)));
                    result =  num * 0.01667;
                    radmin.setText(String.valueOf(roundUp(result,4)));
                    result =  num * 0.0002778;
                    radsec.setText(String.valueOf(roundUp(result,4)));
                    result = num * 0.002653;
                    RPM.setText(String.valueOf(roundUp(result,4)));

                    break;

                case 5:
                    result =  (num / 22619467)*60;
                    edHz.setText(String.valueOf(roundUp(result,4)));
                    result =  (num / 2.2619e+10)*60;
                    edKhz.setText(String.valueOf(roundUp(result,4)));
                    result =  (num / 2.2619e+13)*60;
                    edMhz.setText(String.valueOf(roundUp(result,4)));
                    result =  (num / 2.2619e+16)*60;
                    edGhz.setText(String.valueOf(roundUp(result,4)));

                    result =  num * 60;
                    radh.setText(String.valueOf(roundUp(result,4)));
                    result =  num + 0;
                    radmin.setText(String.valueOf(roundUp(result,4)));
                    result =  num * 0.0017;
                    radsec.setText(String.valueOf(roundUp(result,4)));
                    result =  num * 0.159;
                    RPM.setText(String.valueOf(roundUp(result,4)));
                    break;

                case 6:
                    result =  (num / 22619.467)*3600;
                    edHz.setText(String.valueOf(roundUp(result,4)));
                    result =  (num / 22619467)*3600;
                    edKhz.setText(String.valueOf(roundUp(result,4)));
                    result =  (num / 2.2619e+10)*3600;
                    edMhz.setText(String.valueOf(roundUp(result,4)));
                    result =  (num / 2.2619e+13)*3600;
                    edGhz.setText(String.valueOf(roundUp(result,4)));

                    result =  num * 3600;
                    radh.setText(String.valueOf(roundUp(result,4)));
                    result =  num * 60;
                    radmin.setText(String.valueOf(roundUp(result,4)));
                    result =  num + 0;
                    radsec.setText(String.valueOf(roundUp(result,4)));
                    result =  num *9.549;
                    RPM.setText(String.valueOf(roundUp(result, 3)));

                    break;

                case 7:
                    result =  num *0.01667;
                    edHz.setText(String.valueOf(roundUp(result,4)));
                    result =  num* 0.00001667;
                    edKhz.setText(String.valueOf(roundUp(result,4)));
                    result =  num* 0.00000001667;
                    edMhz.setText(String.valueOf(roundUp(result,4)));
                    result =  num* 0.00000000001667;
                    edGhz.setText(String.valueOf(roundUp(result,4)));

                    result =  num * 377;
                    radh.setText(String.valueOf(roundUp(result,4)));
                    result =  num * 6.283;
                    radmin.setText(String.valueOf(roundUp(result,4)));
                    result =  num * 0.1047;
                    radsec.setText(String.valueOf(roundUp(result,4)));
                    result =  num +0;
                    RPM.setText(String.valueOf(roundUp(result,4)));

                    break;

            }
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


