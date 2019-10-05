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

public class TempActivity extends AppCompatActivity implements TextWatcher {

   // String[] data = {"Градус Цельсия (ºC)", "Градус Фаренгейт (ºF)", "Кельвин (ºK)","Градус Реомюра (°Re)","Градус Ньютона (°N)","Градус Делиля (°Д)"};
    int a;
    Spinner spMassa;
    EditText edNum,edCels, edFar,edCalv,edRe,edN,edD;

//    TextView tvPosName;

    public BigDecimal roundUp(double value, int digits) {
        return new BigDecimal("" + value).setScale(digits, BigDecimal.ROUND_HALF_UP);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.temp);

        Toolbar my_toolbar = (Toolbar) findViewById(R.id.my_toolbar_app);
        RelativeLayout backColorlayoutAds = (RelativeLayout) findViewById(R.id.reLayoutTempAds);
        CollapsingToolbarLayout bottomColorLayout = (CollapsingToolbarLayout) findViewById(R.id.bottomColAds);
        CoordinatorLayout corLoyDlinna = (CoordinatorLayout) findViewById(R.id.corLoyoutTemp);
        setSupportActionBar(my_toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,// data);
     //   adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            getResources().getStringArray(R.array.temp));

        spMassa = (Spinner) findViewById(R.id.spMassa);
        spMassa.setAdapter(adapter);

        edNum = (EditText) findViewById(R.id.edNum);
//        tvPosName = (TextView) findViewById(R.id.tvPosName);

        TextView C = (TextView) findViewById(R.id.C);
        TextView F = (TextView) findViewById(R.id.F);
        TextView K = (TextView) findViewById(R.id.K);
        TextView Re = (TextView) findViewById(R.id.Re);
        TextView N = (TextView)  findViewById(R.id.N);
        TextView D = (TextView)  findViewById(R.id.D);


        edCels = (EditText) findViewById(R.id.edCels);
        edFar = (EditText) findViewById(R.id.edFar);
        edCalv = (EditText) findViewById(R.id.edCalv);
        edRe = (EditText) findViewById(R.id.edRe);
        edN = (EditText) findViewById(R.id.edN);
        edD = (EditText) findViewById(R.id.edD);

        if (getColor() != getResources().getColor(R.color.colorPrimary)) {

            my_toolbar.setBackgroundColor(getBackgroundColor());
            backColorlayoutAds.setBackgroundColor(getColor());
            bottomColorLayout.setBackgroundColor(getColor());
            corLoyDlinna.setBackgroundColor(getBackgroundColor());

            C.setTextColor(getTextColor());
            F.setTextColor(getTextColor());
            K.setTextColor(getTextColor());
            Re.setTextColor(getTextColor());
            N.setTextColor(getTextColor());
            D.setTextColor(getTextColor());

            edCels.setBackgroundColor(getEditTextActivityColor());
            edCels.setTextColor(getEditTextColor());
            edFar.setBackgroundColor(getEditTextActivityColor());
            edFar.setTextColor(getEditTextColor());
            edCalv.setBackgroundColor(getEditTextActivityColor());
            edCalv.setTextColor(getEditTextColor());
            edRe.setBackgroundColor(getEditTextActivityColor());
            edRe.setTextColor(getEditTextColor());
            edN.setBackgroundColor(getEditTextActivityColor());
            edN.setTextColor(getEditTextColor());
            edD.setBackgroundColor(getEditTextActivityColor());
            edD.setTextColor(getEditTextColor());


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
//                tvPosName.setText(strName);
                a = position;

                double result = 0;
                double num = 0;

                if (TextUtils.isEmpty(edNum.getText().toString())
                        ||  (edNum.getText().toString().equals("."))
                        ||  (edNum.getText().toString().equals("-"))){

                    edCels.setText("");
                    edFar.setText("");
                    edCalv.setText("");
                    edRe.setText("");
                    edN.setText("");
                    edD.setText("");

                    return;
                }

                num = Float.parseFloat(edNum.getText().toString());

                switch (position){
                    case 0:

                        result = (num + 0);
                        edCels.setText(String.valueOf(roundUp(result,4)));
                        result = ((1.8*num)+32);
                        edFar.setText(String.valueOf(roundUp(result,4)));
                        result = ((1*num)+273.15);
                        edCalv.setText(String.valueOf(roundUp(result,4)));
                        result = (0.8*num);
                        edRe.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.33);
                        edN.setText(String.valueOf(roundUp(result,4)));
                        result = (((-1.5)*num)+150);
                        edD.setText(String.valueOf(roundUp(result,4)));
                        break;
                    case 1:
                        result = ((num * 0.5555)-17.7777);
                        edCels.setText(String.valueOf(roundUp(result,4)));
                        result = (num +0);
                        edFar.setText(String.valueOf(roundUp(result,4)));
                        result = ((0.56*num)+255.372);
                        edCalv.setText(String.valueOf(roundUp(result,4)));
                        result = ((0.44*num)-14.22);
                        edRe.setText(String.valueOf(roundUp(result,4)));
                        result = ((num * 0.184)-5.867);
                        edN.setText(String.valueOf(roundUp(result,4)));
                        result = (((-0.8)*num)+176.7);
                        edD.setText(String.valueOf(roundUp(result,4)));
                        break;

                    case 2:
                        result = ((1*num)-273.15);
                        edCels.setText(String.valueOf(roundUp(result,4)));
                        result = ((1.8*num)-459.67);
                        edFar.setText(String.valueOf(roundUp(result,4)));
                        result = (num+0);
                        edCalv.setText(String.valueOf(roundUp(result,4)));
                        result = ((0.8*num)-218.5);
                        edRe.setText(String.valueOf(roundUp(result,4)));
                        result = ((num * 0.304)-90.114);
                        edN.setText(String.valueOf(roundUp(result,4)));
                        result = (((-1.5)*num)+559.7);
                        edD.setText(String.valueOf(roundUp(result,4)));
                        break;

                    case 3:
                        result = (1.25*num);
                        edCels.setText(String.valueOf(roundUp(result,4)));
                        result = ((2.25*num)+32);
                        edFar.setText(String.valueOf(roundUp(result,4)));
                        result = ((1.2*num)+273.2);
                        edCalv.setText(String.valueOf(roundUp(result,4)));
                        result = (num+0);
                        edRe.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.4125);
                        edN.setText(String.valueOf(roundUp(result,4)));
                        result = (((-1.9)*num)+150);
                        edD.setText(String.valueOf(roundUp(result,4)));
                        break;

                    case 4:
                        result = (3.03*num);
                        edCels.setText(String.valueOf(roundUp(result,4)));
                        result = ((5.45*num)+32);
                        edFar.setText(String.valueOf(roundUp(result,4)));
                        result = ((3.033*num)+273.1);
                        edCalv.setText(String.valueOf(roundUp(result,4)));
                        result = (num*2.424);
                        edRe.setText(String.valueOf(roundUp(result,4)));
                        result = (((-1.9)*num)+150);
                        edN.setText(String.valueOf(roundUp(result,4)));
                        result = (((-4.5)*num)+150);
                        edD.setText(String.valueOf(roundUp(result,4)));
                        break;

                    case 5:
                        result = (((-0.6666)*num)+100);
                        edCels.setText(String.valueOf(roundUp(result,4)));
                        result = (((-1.2)*num)+212);
                        edFar.setText(String.valueOf(roundUp(result,4)));
                        result = (((-0.67888)*num)+373.1);
                        edCalv.setText(String.valueOf(roundUp(result,4)));
                        result = (((-0.53)*num)+80);
                        edRe.setText(String.valueOf(roundUp(result,4)));
                        result = (((-0.22)*num)+33);
                        edN.setText(String.valueOf(roundUp(result,4)));
                        result = (num+0);
                        edD.setText(String.valueOf(roundUp(result,4)));
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

            edCels.setText("");
            edFar.setText("");
            edCalv.setText("");
            edRe.setText("");
            edN.setText("");
            edD.setText("");

            return;

        }
        num = Float.parseFloat(edNum.getText().toString());{

            switch (a){
                case 0:
                    result = (num + 0);
                    edCels.setText(String.valueOf(roundUp(result,4)));
                    result = ((1.8*num)+32);
                    edFar.setText(String.valueOf(roundUp(result,4)));
                    result = ((1*num)+273.15);
                    edCalv.setText(String.valueOf(roundUp(result,4)));
                    result = (0.8*num);
                    edRe.setText(String.valueOf(roundUp(result,4)));
                    result = (num * 0.33);
                    edN.setText(String.valueOf(roundUp(result,4)));
                    result = (((-1.5)*num)+150);
                    edD.setText(String.valueOf(roundUp(result,4)));
                    break;

                case 1:
                    result = ((num * 0.5555)-17.7777);
                    edCels.setText(String.valueOf(roundUp(result,4)));
                    result = (num +0);
                    edFar.setText(String.valueOf(roundUp(result,4)));
                    result = ((0.56*num)+255.372);
                    edCalv.setText(String.valueOf(roundUp(result,4)));
                    result = ((0.44*num)-14.22);
                    edRe.setText(String.valueOf(roundUp(result,4)));
                    result = ((num * 0.184)-5.867);
                    edN.setText(String.valueOf(roundUp(result,4)));
                    result = (((-0.8)*num)+176.7);
                    edD.setText(String.valueOf(roundUp(result,4)));



                    break;

                case 2:
                    result = ((1*num)-273.15);
                    edCels.setText(String.valueOf(roundUp(result,4)));
                    result = ((1.8*num)-459.67);
                    edFar.setText(String.valueOf(roundUp(result,4)));
                    result = (num+0);
                    edCalv.setText(String.valueOf(roundUp(result,4)));
                    result = ((0.8*num)-218.5);
                    edRe.setText(String.valueOf(roundUp(result,4)));
                    result = ((num * 0.304)-90.114);
                    edN.setText(String.valueOf(roundUp(result,4)));
                    result = (((-1.5)*num)+559.7);
                    edD.setText(String.valueOf(roundUp(result,4)));
                    break;

                case 3:
                    result = (1.25*num);
                    edCels.setText(String.valueOf(roundUp(result,4)));
                    result = ((2.25*num)+32);
                    edFar.setText(String.valueOf(roundUp(result,4)));
                    result = ((1.2*num)+273.2);
                    edCalv.setText(String.valueOf(roundUp(result,4)));
                    result = (num+0);
                    edRe.setText(String.valueOf(roundUp(result,4)));
                    result = (num * 0.4125);
                    edN.setText(String.valueOf(roundUp(result,4)));
                    result = (((-1.9)*num)+150);
                    edD.setText(String.valueOf(roundUp(result,4)));
                    break;

                case 4:
                    result = (3.03*num);
                    edCels.setText(String.valueOf(roundUp(result,4)));
                    result = ((5.45*num)+32);
                    edFar.setText(String.valueOf(roundUp(result,4)));
                    result = ((3.033*num)+273.1);
                    edCalv.setText(String.valueOf(roundUp(result,4)));
                    result = (num*2.424);
                    edRe.setText(String.valueOf(roundUp(result,4)));
                    result = (num+0);
                    edN.setText(String.valueOf(roundUp(result, 3)));
                    result = (((-4.5)*num)+150);
                    edD.setText(String.valueOf(roundUp(result,4)));
                    break;

                case 5:
                    result = (((-0.6666)*num)+100);
                    edCels.setText(String.valueOf(roundUp(result,4)));
                    result = (((-1.2)*num)+212);
                    edFar.setText(String.valueOf(roundUp(result,4)));
                    result = (((-0.67888)*num)+373.1);
                    edCalv.setText(String.valueOf(roundUp(result,4)));
                    result = (((-0.53)*num)+80);
                    edRe.setText(String.valueOf(roundUp(result,4)));
                    result = (((-0.22)*num)+33);
                    edN.setText(String.valueOf(roundUp(result,4)));
                    result = (num+0);
                    edD.setText(String.valueOf(roundUp(result,4)));
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

