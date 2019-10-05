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

public class PloshadActivity extends AppCompatActivity implements TextWatcher {

   // String[] data = {"Кв.километр (Km²)", "Кв.метр (M²)", "Кв.миля (mi²)", "Кв.ярд (yd²)", "Кв.фут (ft²)", "Кв.дюйм (inch²)", "Гектар (ha)", "Акр (acre)"};
    int a;
    Spinner spMassa;
    EditText edNum,edKvKm, edKvM, edKvMil, edKvYard, edKvFut, edKvDuim, edGektar, edAkr;
   // TextView tvPosName;

    public BigDecimal roundUp(double value, int digits) {
        return new BigDecimal("" + value).setScale(digits, BigDecimal.ROUND_HALF_UP);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ploshad);

        Toolbar my_toolbar = (Toolbar) findViewById(R.id.my_toolbar_app);
        CoordinatorLayout corLoyPloshad = (CoordinatorLayout) findViewById(R.id.corLoyPloshad);
        RelativeLayout backColorlayoutAds = (RelativeLayout) findViewById(R.id.BackPloshadAds);
        CollapsingToolbarLayout bottomColorLayout = (CollapsingToolbarLayout) findViewById(R.id.PloshadBottomLayout);
        setSupportActionBar(my_toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,// data);
     //   adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            getResources().getStringArray(R.array.ploshad));

        spMassa = (Spinner) findViewById(R.id.spMassa);
        spMassa.setAdapter(adapter);


        edNum = (EditText) findViewById(R.id.edNum);
      //  tvPosName = (TextView) findViewById(R.id.tvPosName);

        edKvKm = (EditText) findViewById(R.id.edKvKm);
        edKvM = (EditText) findViewById(R.id.edKvM);
        edKvMil = (EditText) findViewById(R.id.edKvMil);
        edKvYard = (EditText) findViewById(R.id.edKvYard);
        edKvFut = (EditText) findViewById(R.id.edKvFut);
        edKvDuim = (EditText) findViewById(R.id.edKvDuim);
        edGektar = (EditText) findViewById(R.id.edGektar);
        edAkr = (EditText) findViewById(R.id.edAkr);

        TextView km2 = (TextView) findViewById(R.id.Km2);
        TextView M2 = (TextView) findViewById(R.id.M2);
        TextView mi2 = (TextView) findViewById(R.id.ml2);
        TextView yd2 = (TextView) findViewById(R.id.yd2);
        TextView ft2 = (TextView) findViewById(R.id.ft2);
        TextView in2 = (TextView)  findViewById(R.id.in2);
        TextView ha = (TextView)  findViewById(R.id.ha);
        TextView acre = (TextView)  findViewById(R.id.acre);



        ;

        if (getColor() != getResources().getColor(R.color.colorPrimary)) {

            my_toolbar.setBackgroundColor(getBackgroundColor());
            backColorlayoutAds.setBackgroundColor(getColor());
            bottomColorLayout.setBackgroundColor(getColor());
            corLoyPloshad.setBackgroundColor(getBackgroundColor());

            km2.setTextColor(getTextColor());
            M2.setTextColor(getTextColor());
            mi2.setTextColor(getTextColor());
            yd2.setTextColor(getTextColor());
            ft2.setTextColor(getTextColor());
            in2.setTextColor(getTextColor());
            ha.setTextColor(getTextColor());
            acre.setTextColor(getTextColor());


            edKvKm.setBackgroundColor(getEditTextActivityColor());
            edKvKm.setTextColor(getEditTextColor());
            edKvM.setBackgroundColor(getEditTextActivityColor());
            edKvM.setTextColor(getEditTextColor());
            edKvMil.setBackgroundColor(getEditTextActivityColor());
            edKvMil.setTextColor(getEditTextColor());
            edKvYard.setBackgroundColor(getEditTextActivityColor());
            edKvYard.setTextColor(getEditTextColor());
            edKvFut.setBackgroundColor(getEditTextActivityColor());
            edKvFut.setTextColor(getEditTextColor());
            edKvDuim.setBackgroundColor(getEditTextActivityColor());
            edKvDuim.setTextColor(getEditTextColor());
            edGektar.setBackgroundColor(getEditTextActivityColor());
            edGektar.setTextColor(getEditTextColor());
            edAkr.setBackgroundColor(getEditTextActivityColor());
            edAkr.setTextColor(getEditTextColor());


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
               // tvPosName.setText(strName);
                a = position;


                double result = 0;
                double num = 0;

                if (TextUtils.isEmpty(edNum.getText().toString())
                        ||  (edNum.getText().toString().equals("."))
                        ||  (edNum.getText().toString().equals("-"))){


                    edKvKm.setText("");
                    edKvM.setText("");
                    edKvMil.setText("");
                    edKvYard.setText("");
                    edKvFut.setText("");
                    edKvDuim.setText("");
                    edGektar.setText("");
                    edAkr.setText("");

                    return;
                }

                num = Float.parseFloat(edNum.getText().toString());

                switch (position){
                    case 0:
                        result = (num + 0);
                        edKvKm.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 1e+6);
                        edKvM.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.3862);
                        edKvMil.setText(String.valueOf(roundUp(result,4)));
                        result = (num  *1.196e+6);
                        edKvYard.setText(String.valueOf(roundUp(result,4)));
                        result = (num*1.076e+7);
                        edKvFut.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 1.55e+9);
                        edKvDuim.setText(String.valueOf(roundUp(result,4)));
                        result = (num*100);
                        edGektar.setText(String.valueOf(roundUp(result,4)));
                        result = (num*247.2);
                        edAkr.setText(String.valueOf(roundUp(result,4)));
                        break;

                    case 1:
                        result = (num * 1e-6);
                        edKvKm.setText(String.valueOf(roundUp(result,4)));
                        result = (num + 0);
                        edKvM.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 3.861e-7);
                        edKvMil.setText(String.valueOf(roundUp(result,4)));
                        result = (num  *1.196);
                        edKvYard.setText(String.valueOf(roundUp(result,4)));
                        result = (num*10.764);
                        edKvFut.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 1550);
                        edKvDuim.setText(String.valueOf(roundUp(result,4)));
                        result = (num*1e-4);
                        edGektar.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.0002472);
                        edAkr.setText(String.valueOf(roundUp(result,4)));
                        break;

                    case 2:
                        result = (num * 2.59);
                        edKvKm.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 2.59e+6);
                        edKvM.setText(String.valueOf(roundUp(result,4)));
                        result = (num +0);
                        edKvMil.setText(String.valueOf(roundUp(result,4)));
                        result = (num  *3.1e+6);
                        edKvYard.setText(String.valueOf(roundUp(result,4)));
                        result = (num*2.79e+7);
                        edKvFut.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 4.015e+9);
                        edKvDuim.setText(String.valueOf(roundUp(result,4)));
                        result = (num*259);
                        edGektar.setText(String.valueOf(roundUp(result,4)));
                        result = (num*640);
                        edAkr.setText(String.valueOf(roundUp(result,4)));
                        break;

                    case 3:
                        result = (num * 8.3613e-7);
                        edKvKm.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.8362);
                        edKvM.setText(String.valueOf(roundUp(result,4)));
                        result = (num *3.2283e-7);
                        edKvMil.setText(String.valueOf(roundUp(result,4)));
                        result = (num +0);
                        edKvYard.setText(String.valueOf(roundUp(result,4)));
                        result = (num*9);
                        edKvFut.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 1296);
                        edKvDuim.setText(String.valueOf(roundUp(result,4)));
                        result = (num*8.3613e-5);
                        edGektar.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.0002067);
                        edAkr.setText(String.valueOf(roundUp(result,4)));
                        break;

                    case 4:
                        result = (num * 9.29e-8);
                        edKvKm.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.0929);
                        edKvM.setText(String.valueOf(roundUp(result,4)));
                        result = (num *3.587e-8);
                        edKvMil.setText(String.valueOf(roundUp(result,4)));
                        result = (num *0.11);
                        edKvYard.setText(String.valueOf(roundUp(result,4)));
                        result = (num+0);
                        edKvFut.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 144);
                        edKvDuim.setText(String.valueOf(roundUp(result,4)));
                        result = (num*9.2903e-6);
                        edGektar.setText(String.valueOf(roundUp(result,4)));
                        result = (num*2.296e-5);
                        edAkr.setText(String.valueOf(roundUp(result,4)));
                        break;

                    case 5:
                        result = (num * 6.4516e-10);
                        edKvKm.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.00064516);
                        edKvM.setText(String.valueOf(roundUp(result,4)));
                        result = (num *2.491e-10);
                        edKvMil.setText(String.valueOf(roundUp(result,4)));
                        result = (num *0.000772);
                        edKvYard.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.00695);
                        edKvFut.setText(String.valueOf(roundUp(result,4)));
                        result = (num +0);
                        edKvDuim.setText(String.valueOf(roundUp(result,4)));
                        result = (num*6.4516e-8);
                        edGektar.setText(String.valueOf(roundUp(result,4)));
                        result = (num*1.5943e-7);
                        edAkr.setText(String.valueOf(roundUp(result,4)));
                        break;

                    case 6:
                        result = (num * 0.01);
                        edKvKm.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 10000);
                        edKvM.setText(String.valueOf(roundUp(result,4)));
                        result = (num *0.003862);
                        edKvMil.setText(String.valueOf(roundUp(result,4)));
                        result = (num *11960);
                        edKvYard.setText(String.valueOf(roundUp(result,4)));
                        result = (num*107644);
                        edKvFut.setText(String.valueOf(roundUp(result,4)));
                        result = (num *1.55e+7);
                        edKvDuim.setText(String.valueOf(roundUp(result,4)));
                        result = (num+0);
                        edGektar.setText(String.valueOf(roundUp(result,4)));
                        result = (num*2.472);
                        edAkr.setText(String.valueOf(roundUp(result,4)));
                        break;

                    case 7:
                        result = (num * 0.004047);
                        edKvKm.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 4047);
                        edKvM.setText(String.valueOf(roundUp(result,4)));
                        result = (num *0.001563);
                        edKvMil.setText(String.valueOf(roundUp(result,4)));
                        result = (num *4840);
                        edKvYard.setText(String.valueOf(roundUp(result,4)));
                        result = (num*43560);
                        edKvFut.setText(String.valueOf(roundUp(result,4)));
                        result = (num *6.273e+6);
                        edKvDuim.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.4047);
                        edGektar.setText(String.valueOf(roundUp(result,4)));
                        result = (num+0);
                        edAkr.setText(String.valueOf(roundUp(result,4)));
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

        if (TextUtils.isEmpty(edNum.getText().toString())
                ||  (edNum.getText().toString().equals("."))
                ||  (edNum.getText().toString().equals("-"))){


            edKvKm.setText("");
            edKvM.setText("");
            edKvMil.setText("");
            edKvYard.setText("");
            edKvFut.setText("");
            edKvDuim.setText("");
            edGektar.setText("");
            edAkr.setText("");
            return;

        }

        num = Float.parseFloat(edNum.getText().toString());

        switch (a) {
            case 0:
                result = (num + 0);
                edKvKm.setText(String.valueOf(roundUp(result,4)));
                result = (num * 1e+6);
                edKvM.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.3862);
                edKvMil.setText(String.valueOf(roundUp(result,4)));
                result = (num  *1.196e+6);
                edKvYard.setText(String.valueOf(roundUp(result,4)));
                result = (num*1.076e+7);
                edKvFut.setText(String.valueOf(roundUp(result,4)));
                result = (num * 1.55e+9);
                edKvDuim.setText(String.valueOf(roundUp(result,4)));
                result = (num*100);
                edGektar.setText(String.valueOf(roundUp(result,4)));
                result = (num*247.2);
                edAkr.setText(String.valueOf(roundUp(result,4)));
                break;

            case 1:
                result = (num * 1e-6);
                edKvKm.setText(String.valueOf(roundUp(result,4)));
                result = (num + 0);
                edKvM.setText(String.valueOf(roundUp(result,4)));
                result = (num * 3.861e-7);
                edKvMil.setText(String.valueOf(roundUp(result,4)));
                result = (num  *1.196);
                edKvYard.setText(String.valueOf(roundUp(result,4)));
                result = (num*10.764);
                edKvFut.setText(String.valueOf(roundUp(result,4)));
                result = (num * 1550);
                edKvDuim.setText(String.valueOf(roundUp(result,4)));
                result = (num*1e-4);
                edGektar.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.0002472);
                edAkr.setText(String.valueOf(roundUp(result,4)));
                break;

            case 2:
                result = (num * 2.59);
                edKvKm.setText(String.valueOf(roundUp(result,4)));
                result = (num * 2.59e+6);
                edKvM.setText(String.valueOf(roundUp(result,4)));
                result = (num +0);
                edKvMil.setText(String.valueOf(roundUp(result,4)));
                result = (num  *3.1e+6);
                edKvYard.setText(String.valueOf(roundUp(result,4)));
                result = (num*2.79e+7);
                edKvFut.setText(String.valueOf(roundUp(result,4)));
                result = (num * 4.015e+9);
                edKvDuim.setText(String.valueOf(roundUp(result,4)));
                result = (num*259);
                edGektar.setText(String.valueOf(roundUp(result,4)));
                result = (num*640);
                edAkr.setText(String.valueOf(roundUp(result,4)));
                break;

            case 3:
                result = (num * 8.3613e-7);
                edKvKm.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.8362);
                edKvM.setText(String.valueOf(roundUp(result,4)));
                result = (num *3.2283e-7);
                edKvMil.setText(String.valueOf(roundUp(result,4)));
                result = (num +0);
                edKvYard.setText(String.valueOf(roundUp(result,4)));
                result = (num+9);
                edKvFut.setText(String.valueOf(roundUp(result,4)));
                result = (num * 1296);
                edKvDuim.setText(String.valueOf(roundUp(result,4)));
                result = (num*8.3613e-5);
                edGektar.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.0002067);
                edAkr.setText(String.valueOf(roundUp(result,4)));
                break;

            case 4:
                result = (num * 9.29e-8);
                edKvKm.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.0929);
                edKvM.setText(String.valueOf(roundUp(result,4)));
                result = (num *3.587e-8);
                edKvMil.setText(String.valueOf(roundUp(result,4)));
                result = (num *0.11);
                edKvYard.setText(String.valueOf(roundUp(result,4)));
                result = (num+0);
                edKvFut.setText(String.valueOf(roundUp(result,4)));
                result = (num * 144);
                edKvDuim.setText(String.valueOf(roundUp(result,4)));
                result = (num*9.2903e-6);
                edGektar.setText(String.valueOf(roundUp(result,4)));
                result = (num*2.296e-5);
                edAkr.setText(String.valueOf(roundUp(result,4)));
                break;

            case 5:
                result = (num * 6.4516e-10);
                edKvKm.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.00064516);
                edKvM.setText(String.valueOf(roundUp(result,4)));
                result = (num *2.491e-10);
                edKvMil.setText(String.valueOf(roundUp(result,4)));
                result = (num *0.000772);
                edKvYard.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.00695);
                edKvFut.setText(String.valueOf(roundUp(result,4)));
                result = (num +0);
                edKvDuim.setText(String.valueOf(roundUp(result,4)));
                result = (num*6.4516e-8);
                edGektar.setText(String.valueOf(roundUp(result,4)));
                result = (num*1.5943e-7);
                edAkr.setText(String.valueOf(roundUp(result,4)));
                break;

            case 6:
                result = (num * 0.01);
                edKvKm.setText(String.valueOf(roundUp(result,4)));
                result = (num * 10000);
                edKvM.setText(String.valueOf(roundUp(result,4)));
                result = (num *0.003862);
                edKvMil.setText(String.valueOf(roundUp(result,4)));
                result = (num *11960);
                edKvYard.setText(String.valueOf(roundUp(result, 3)));
                result = (num*107644);
                edKvFut.setText(String.valueOf(roundUp(result,4)));
                result = (num *1.55e+7);
                edKvDuim.setText(String.valueOf(roundUp(result,4)));
                result = (num+0);
                edGektar.setText(String.valueOf(roundUp(result,4)));
                result = (num*2.472);
                edAkr.setText(String.valueOf(roundUp(result,4)));
                break;

            case 7:
                result = (num * 0.004047);
                edKvKm.setText(String.valueOf(roundUp(result,4)));
                result = (num * 4047);
                edKvM.setText(String.valueOf(roundUp(result,4)));
                result = (num *0.001563);
                edKvMil.setText(String.valueOf(roundUp(result,4)));
                result = (num *4840);
                edKvYard.setText(String.valueOf(roundUp(result,4)));
                result = (num*43560);
                edKvFut.setText(String.valueOf(roundUp(result,4)));
                result = (num *6.273e+6);
                edKvDuim.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.4047);
                edGektar.setText(String.valueOf(roundUp(result,4)));
                result = (num+0);
                edAkr.setText(String.valueOf(roundUp(result,4)));
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

