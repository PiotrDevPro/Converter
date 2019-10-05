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

public class KrutActivity extends AppCompatActivity implements TextWatcher{

  //  String[] data = {"Ньютон-метр (Nm)", "Килограмм-метр (kgf.m)", "Фунт-фут силы (lbsf.ft))", "Фут фунт (ft-pdl)","Фунт силы-дюйм (lbsf.in)"};
    int a;
    Spinner spMassa;
    EditText edNum,edNm, edKgfM, edLbsfFt, edFtpdl,edLbsfin;
  //  TextView tvPosName;

    public BigDecimal roundUp(double value, int digits) {
        return new BigDecimal("" + value).setScale(digits, BigDecimal.ROUND_HALF_UP);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.krut);

        Toolbar my_toolbar = (Toolbar) findViewById(R.id.my_toolbar_app);
        RelativeLayout backColorlayoutAds = (RelativeLayout) findViewById(R.id.reLayoutKrutAds);
        CollapsingToolbarLayout bottomColorLayout = (CollapsingToolbarLayout) findViewById(R.id.KrutBottomLayout);
        CoordinatorLayout corLoyDlinna = (CoordinatorLayout) findViewById(R.id.corLoyoutKrut);
        setSupportActionBar(my_toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,// data);
    //    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        getResources().getStringArray(R.array.RPM));

        spMassa = (Spinner) findViewById(R.id.spMassa);
        spMassa.setAdapter(adapter);

        TextView Nm = (TextView) findViewById(R.id.Nm);
        TextView Km = (TextView) findViewById(R.id.kgfm);
        TextView Mile = (TextView) findViewById(R.id.lbsft);
        TextView m = (TextView) findViewById(R.id.ftpdl);
        TextView yard = (TextView)  findViewById(R.id.lbsfin);



        edNum = (EditText) findViewById(R.id.edNum);
       // tvPosName = (TextView) findViewById(R.id.tvPosName);

        edNm = (EditText) findViewById(R.id.edNm);
        edKgfM = (EditText) findViewById(R.id.edKgfM);
        edLbsfFt = (EditText) findViewById(R.id.edLbsfFt);
        edFtpdl = (EditText) findViewById(R.id.edFtpdl);
        edLbsfin = (EditText) findViewById(R.id.edLbsfin);

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




            edNm.setBackgroundColor(getEditTextActivityColor());
            edNm.setTextColor(getEditTextColor());
            edKgfM.setBackgroundColor(getEditTextActivityColor());
            edKgfM.setTextColor(getEditTextColor());
            edLbsfFt.setBackgroundColor(getEditTextActivityColor());
            edLbsfFt.setTextColor(getEditTextColor());
            edFtpdl.setBackgroundColor(getEditTextActivityColor());
            edFtpdl.setTextColor(getEditTextColor());
            edLbsfin.setBackgroundColor(getEditTextActivityColor());
            edLbsfin.setTextColor(getEditTextColor());



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


                    edNm.setText("");
                    edKgfM.setText("");
                    edLbsfFt.setText("");
                    edFtpdl.setText("");
                    edLbsfin.setText("");


                    return;
                }

                num = Double.parseDouble(edNum.getText().toString());

                switch (position){
                    case 0:
                        result = (num + 0);
                        edNm.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.102);
                        edKgfM.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.738);
                        edLbsfFt.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 23.73);
                        edFtpdl.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 8.851);
                        edLbsfin.setText(String.valueOf(roundUp(result,4)));
                        break;

                    case 1:
                        result = (num * 9.807);
                        edNm.setText(String.valueOf(roundUp(result,4)));
                        result = (num + 0);
                        edKgfM.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 7.233);
                        edLbsfFt.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 232.715);
                        edFtpdl.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 86.8);
                        edLbsfin.setText(String.valueOf(roundUp(result,4)));
                        break;
                    case 2:
                        result = (num * 1.356);
                        edNm.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.138);
                        edKgfM.setText(String.valueOf(roundUp(result,4)));
                        result = (num + 0);
                        edLbsfFt.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 32.174);
                        edFtpdl.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 12);
                        edLbsfin.setText(String.valueOf(roundUp(result,4)));
                        break;

                    case 3:
                        result = (num * 0.042);
                        edNm.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.004);
                        edKgfM.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.031);
                        edLbsfFt.setText(String.valueOf(roundUp(result,4)));
                        result = (num + 0);
                        edFtpdl.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.373);
                        edLbsfin.setText(String.valueOf(roundUp(result,4)));
                        break;

                    case 4:
                        result = (num * 0.113);
                        edNm.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.012);
                        edKgfM.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.031);
                        edLbsfFt.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.083);
                        edFtpdl.setText(String.valueOf(roundUp(result,4)));
                        result = (num + 0);
                        edLbsfin.setText(String.valueOf(roundUp(result,4)));
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

            edNm.setText("");
            edKgfM.setText("");
            edLbsfFt.setText("");
            edFtpdl.setText("");
            edLbsfin.setText("");

            return;

        }

        num = Double.parseDouble(edNum.getText().toString());

        switch (a){

            case 0:
                result = (num + 0);
                edNm.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.102);
                edKgfM.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.738);
                edLbsfFt.setText(String.valueOf(roundUp(result,4)));
                result = (num * 23.73);
                edFtpdl.setText(String.valueOf(roundUp(result,4)));
                result = (num * 8.851);
                edLbsfin.setText(String.valueOf(roundUp(result,4)));

                break;

            case 1:
                result = (num * 9.807);
                edNm.setText(String.valueOf(roundUp(result,4)));
                result = (num + 0);
                edKgfM.setText(String.valueOf(roundUp(result,4)));
                result = (num * 7.233);
                edLbsfFt.setText(String.valueOf(roundUp(result,4)));
                result = (num * 232.715);
                edFtpdl.setText(String.valueOf(roundUp(result,4)));
                result = (num * 86.8);
                edLbsfin.setText(String.valueOf(roundUp(result,4)));

                break;

            case 2:
                result = (num * 1.356);
                edNm.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.138);
                edKgfM.setText(String.valueOf(roundUp(result,4)));
                result = (num + 0);
                edLbsfFt.setText(String.valueOf(roundUp(result,4)));
                result = (num * 32.174);
                edFtpdl.setText(String.valueOf(roundUp(result,4)));
                result = (num * 12);
                edLbsfin.setText(String.valueOf(roundUp(result,4)));

                break;

            case 3:
                result = (num * 0.042);
                edNm.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.004);
                edKgfM.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.031);
                edLbsfFt.setText(String.valueOf(roundUp(result,4)));
                result = (num + 0);
                edFtpdl.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.373);
                edLbsfin.setText(String.valueOf(roundUp(result,4)));

                break;

            case 4:
                result = (num * 0.113);
                edNm.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.012);
                edKgfM.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.031);
                edLbsfFt.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.083);
                edFtpdl.setText(String.valueOf(roundUp(result,4)));
                result = (num + 0);
                edLbsfin.setText(String.valueOf(roundUp(result,4)));

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

