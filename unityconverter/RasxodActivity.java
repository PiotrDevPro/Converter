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

public class RasxodActivity extends AppCompatActivity implements TextWatcher {

   // String[] data = {"Миля на галлон (MPG U.S)", "Миля на галлон (MPG UK)", "Километр на литр (km/liter)", "Литр на 100 км (liter/100km)"};
    int a;
    Spinner spMassa;
    EditText edNum,edMilGalUs, edMilGalEn, edKmLitr, edLitr100;
   // TextView tvPosName;

    public BigDecimal roundUp(double value, int digits) {
        return new BigDecimal("" + value).setScale(digits, BigDecimal.ROUND_HALF_UP);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rasxod);

        Toolbar my_toolbar = (Toolbar) findViewById(R.id.my_toolbar_app);
        RelativeLayout backColorlayoutAds = (RelativeLayout) findViewById(R.id.reLayoutFuelAds);
        CollapsingToolbarLayout bottomColorLayout = (CollapsingToolbarLayout) findViewById(R.id.FuelBottomLayout);
        CoordinatorLayout corLoyDlinna = (CoordinatorLayout) findViewById(R.id.corLoyoutFuel);
        setSupportActionBar(my_toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,// data);
        //adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            getResources().getStringArray(R.array.rasxod));

        spMassa = (Spinner) findViewById(R.id.spMassa);
        spMassa.setAdapter(adapter);


        edNum = (EditText) findViewById(R.id.edNum);
      //  tvPosName = (TextView) findViewById(R.id.tvPosName);

        TextView Nm = (TextView) findViewById(R.id.MilGalUs);
        TextView Km = (TextView) findViewById(R.id.MilGalEn);
        TextView Mile = (TextView) findViewById(R.id.KmLitr);
        TextView m = (TextView) findViewById(R.id.Litr100);


        edMilGalUs = (EditText) findViewById(R.id.edMilGalUs);
        edMilGalEn = (EditText) findViewById(R.id.edMilGalEn);
        edKmLitr = (EditText) findViewById(R.id.edKmLitr);
        edLitr100 = (EditText) findViewById(R.id.edLitr100);

        if (getColor() != getResources().getColor(R.color.colorPrimary)) {

            my_toolbar.setBackgroundColor(getBackgroundColor());
            backColorlayoutAds.setBackgroundColor(getColor());
            bottomColorLayout.setBackgroundColor(getColor());
            corLoyDlinna.setBackgroundColor(getBackgroundColor());

            Nm.setTextColor(getTextColor());
            Km.setTextColor(getTextColor());
            Mile.setTextColor(getTextColor());
            m.setTextColor(getTextColor());




            edMilGalUs.setBackgroundColor(getEditTextActivityColor());
            edMilGalUs.setTextColor(getEditTextColor());
            edMilGalEn.setBackgroundColor(getEditTextActivityColor());
            edMilGalEn.setTextColor(getEditTextColor());
            edKmLitr.setBackgroundColor(getEditTextActivityColor());
            edKmLitr.setTextColor(getEditTextColor());
            edLitr100.setBackgroundColor(getEditTextActivityColor());
            edLitr100.setTextColor(getEditTextColor());


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


                    edMilGalUs.setText("");
                    edMilGalEn.setText("");
                    edKmLitr.setText("");
                    edLitr100.setText("");


                    return;
                }

                num = Float.parseFloat(edNum.getText().toString());

                switch (position) {

                    case 0:
                        result = (num + 0);
                        edMilGalUs.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 1.201);
                        edMilGalEn.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.4252);
                        edKmLitr.setText(String.valueOf(roundUp(result,4)));
                        result = (235.2/num);
                        edLitr100.setText(String.valueOf(roundUp(result,4)));
                        break;

                    case 1:
                        result = (num * 0.8327);
                        edMilGalUs.setText(String.valueOf(roundUp(result,4)));
                        result = (num + 0);
                        edMilGalEn.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.3541);
                        edKmLitr.setText(String.valueOf(roundUp(result,4)));
                        result = (282.3/num );
                        edLitr100.setText(String.valueOf(roundUp(result,4)));

                        break;

                    case 2:
                        result = (num * 2.353);
                        edMilGalUs.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 2.8249);
                        edMilGalEn.setText(String.valueOf(roundUp(result,4)));
                        result = (num + 0);
                        edKmLitr.setText(String.valueOf(roundUp(result,4)));
                        result = (100/num);
                        edLitr100.setText(String.valueOf(roundUp(result,4)));

                        break;

                    case 3:
                        result = (235.2/num);
                        edMilGalUs.setText(String.valueOf(roundUp(result,4)));
                        result = (282.4/num);
                        edMilGalEn.setText(String.valueOf(roundUp(result,4)));
                        result = (100/num);
                        edKmLitr.setText(String.valueOf(roundUp(result,4)));
                        result = (num +0);
                        edLitr100.setText(String.valueOf(roundUp(result,4)));

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


            edMilGalUs.setText("");
            edMilGalEn.setText("");
            edKmLitr.setText("");
            edLitr100.setText("");


            return;
        }

        num = Float.parseFloat(edNum.getText().toString());

        switch (a) {
            case 0:
                result = (num + 0);
                edMilGalUs.setText(String.valueOf(roundUp(result,4)));
                result = (num * 1.201);
                edMilGalEn.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.4252);
                edKmLitr.setText(String.valueOf(roundUp(result,4)));
                result = (235.2/num);
                edLitr100.setText(String.valueOf(roundUp(result,4)));
                break;

            case 1:
                result = (num * 0.8327);
                edMilGalUs.setText(String.valueOf(roundUp(result,4)));
                result = (num + 0);
                edMilGalEn.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.3541);
                edKmLitr.setText(String.valueOf(roundUp(result,4)));
                result = (282.3/num );
                edLitr100.setText(String.valueOf(roundUp(result,4)));
                break;

            case 2:
                result = (num * 2.353);
                edMilGalUs.setText(String.valueOf(roundUp(result,4)));
                result = (num * 2.8249);
                edMilGalEn.setText(String.valueOf(roundUp(result,4)));
                result = (num + 0);
                edKmLitr.setText(String.valueOf(roundUp(result,4)));
                result = (100/num);
                edLitr100.setText(String.valueOf(roundUp(result,4)));
                break;

            case 3:
                result = (235.2/num);
                edMilGalUs.setText(String.valueOf(roundUp(result,4)));
                result = (282.4/num);
                edMilGalEn.setText(String.valueOf(roundUp(result,4)));
                result = (100/num);
                edKmLitr.setText(String.valueOf(roundUp(result,4)));
                result = (num +0);
                edLitr100.setText(String.valueOf(roundUp(result,4)));
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

