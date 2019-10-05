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

public class PowerActivity extends AppCompatActivity implements TextWatcher{

    int a;
    Spinner spMassa;
    EditText edNum,edMBT,edKBT,edWT,edWA,edKotHP,edElHP,edMekHP,edMetrHP;
   // TextView tvPosName;

    public BigDecimal roundUp(double value, int digits) {
        return new BigDecimal("" + value).setScale(digits, BigDecimal.ROUND_HALF_UP);

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.power);

        Toolbar my_toolbar = (Toolbar) findViewById(R.id.my_toolbar_app);
        RelativeLayout backColorlayoutAds = (RelativeLayout) findViewById(R.id.reLayoutPowerAds);
        CollapsingToolbarLayout bottomColorLayout = (CollapsingToolbarLayout) findViewById(R.id.PowerBottomLayout);
        CoordinatorLayout corLoyDlinna = (CoordinatorLayout) findViewById(R.id.corLoyoutPower);
        setSupportActionBar(my_toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,
                getResources().getStringArray(R.array.Power));

        spMassa = (Spinner) findViewById(R.id.spMassa);
        spMassa.setAdapter(adapter);

    //    tvPosName = (TextView) findViewById(R.id.tvPosName);

        TextView Nm = (TextView) findViewById(R.id.MBT);
        TextView Km = (TextView) findViewById(R.id.KBT);
        TextView Mile = (TextView) findViewById(R.id.WT);
        TextView m = (TextView) findViewById(R.id.WA);
        TextView yard = (TextView) findViewById(R.id.KotHP);
        TextView ozff = (TextView) findViewById(R.id.ElHP);
        TextView pdll = (TextView) findViewById(R.id.MekHP);
        TextView kgff = (TextView) findViewById(R.id.MetrHP);


        edNum = (EditText) findViewById(R.id.edNum);

        edMBT = (EditText) findViewById(R.id.edMBT);
        edKBT = (EditText) findViewById(R.id.edKBT);
        edWT = (EditText) findViewById(R.id.edWT);
        edWA = (EditText) findViewById(R.id.edWA);
        edKotHP = (EditText) findViewById(R.id.edKotHP);
        edElHP = (EditText) findViewById(R.id.edElHP);

        edMekHP = (EditText) findViewById(R.id.edMekHP);
        edMetrHP = (EditText) findViewById(R.id.edMetrHP);

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
            ozff.setTextColor(getTextColor());
            pdll.setTextColor(getTextColor());
            kgff.setTextColor(getTextColor());


            edMBT.setBackgroundColor(getEditTextActivityColor());
            edMBT.setTextColor(getEditTextColor());
            edKBT.setBackgroundColor(getEditTextActivityColor());
            edKBT.setTextColor(getEditTextColor());
            edWT.setBackgroundColor(getEditTextActivityColor());
            edWT.setTextColor(getEditTextColor());
            edWA.setBackgroundColor(getEditTextActivityColor());
            edWA.setTextColor(getEditTextColor());
            edKotHP.setBackgroundColor(getEditTextActivityColor());
            edKotHP.setTextColor(getEditTextColor());

            edElHP.setBackgroundColor(getEditTextActivityColor());
            edElHP.setTextColor(getEditTextColor());
            edMekHP.setBackgroundColor(getEditTextActivityColor());
            edMekHP.setTextColor(getEditTextColor());
            edMetrHP.setBackgroundColor(getEditTextActivityColor());
            edMetrHP.setTextColor(getEditTextColor());



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
                        || (edNum.getText().toString().equals("."))
                        || (edNum.getText().toString().equals("-"))) {

                    edMBT.setText("");
                    edKBT.setText("");

                    edWT.setText("");
                    edWA.setText("");
                    edKotHP.setText("");
                    edElHP.setText("");
                    edMekHP.setText("");
                    edMetrHP.setText("");

                    return;
                }
                num = Float.parseFloat(edNum.getText().toString());


                switch (position) {
                   case 0:
                        result = num * 1;
                        edMBT.setText(String.valueOf(roundUp(result,4)));
                        result = num * 1000;
                        edKBT.setText(String.valueOf(roundUp(result,4)));
                        result = num * 1e+6;
                        edWT.setText(String.valueOf(roundUp(result,4)));
                        result = num * 1e+6;
                        edWA.setText(String.valueOf(roundUp(result,4)));
                        result = num * 102;
                        edKotHP.setText(String.valueOf(roundUp(result,4)));
                        result = num * 1340;
                        edElHP.setText(String.valueOf(roundUp(result,4)));
                        result = num * 1341;
                        edMekHP.setText(String.valueOf(roundUp(result,4)));
                        result = num * 1360;
                        edMetrHP.setText(String.valueOf(roundUp(result,4)));
                        break;
                    case 1:
                        result = num * 0.001;
                        edMBT.setText(String.valueOf(roundUp(result,4)));
                        result = num * 1;
                        edKBT.setText(String.valueOf(roundUp(result,4)));
                        result = num * 1000;
                        edWT.setText(String.valueOf(roundUp(result,4)));
                        result = num * 1000;
                        edWA.setText(String.valueOf(roundUp(result,4)));
                        result = num * 0.102;
                        edKotHP.setText(String.valueOf(roundUp(result,4)));
                        result = num * 1.34;
                        edElHP.setText(String.valueOf(roundUp(result,4)));
                        result = num * 1.341;
                        edMekHP.setText(String.valueOf(roundUp(result,4)));
                        result = num * 1.36;
                        edMetrHP.setText(String.valueOf(roundUp(result,4)));
                        break;
                    case 2:
                        result = num * 0.000001;
                        edMBT.setText(String.valueOf(roundUp(result,4)));
                        result = num * 0.001;
                        edKBT.setText(String.valueOf(roundUp(result,4)));
                        result = num * 1;
                        edWT.setText(String.valueOf(roundUp(result,4)));
                        result = num * 1;
                        edWA.setText(String.valueOf(roundUp(result,4)));
                        result = num * 0.000102;
                        edKotHP.setText(String.valueOf(roundUp(result,4)));
                        result = num * 0.00134;
                        edElHP.setText(String.valueOf(roundUp(result,4)));
                        result = num * 0.001341;
                        edMekHP.setText(String.valueOf(roundUp(result,4)));
                        result = num * 0.00136;
                        edMetrHP.setText(String.valueOf(roundUp(result,4)));
                        break;
                    case 3:
                        result = num * 0.000001;
                        edMBT.setText(String.valueOf(roundUp(result,4)));
                        result = num * 0.001;
                        edKBT.setText(String.valueOf(roundUp(result,4)));
                        result = num * 1;
                        edWT.setText(String.valueOf(roundUp(result,4)));
                        result = num * 1;
                        edWA.setText(String.valueOf(roundUp(result,4)));
                        result = num * 0.000102;
                        edKotHP.setText(String.valueOf(roundUp(result,4)));
                        result = num * 0.00134;
                        edElHP.setText(String.valueOf(roundUp(result,4)));
                        result = num * 0.001341;
                        edMekHP.setText(String.valueOf(roundUp(result,4)));
                        result = num * 0.00136;
                        edMetrHP.setText(String.valueOf(roundUp(result,4)));
                        break;
                    case 4:
                        result = num * 0.009808;
                        edMBT.setText(String.valueOf(roundUp(result,4)));
                        result = num * 9.808;
                        edKBT.setText(String.valueOf(roundUp(result,4)));
                        result = num * 9808;
                        edWT.setText(String.valueOf(roundUp(result,4)));
                        result = num * 9808;
                        edWA.setText(String.valueOf(roundUp(result,4)));
                        result = num * 1;
                        edKotHP.setText(String.valueOf(roundUp(result,4)));
                        result = num * 13.15;
                        edElHP.setText(String.valueOf(roundUp(result,4)));
                        result = num * 13.15;
                        edMekHP.setText(String.valueOf(roundUp(result,4)));
                        result = num * 13.33;
                        edMetrHP.setText(String.valueOf(roundUp(result,4)));
                        break;
                    case 5:
                        result = num * 0.000746;
                        edMBT.setText(String.valueOf(roundUp(result,4)));
                        result = num * 0.746;
                        edKBT.setText(String.valueOf(roundUp(result,4)));
                        result = num * 746;
                        edWT.setText(String.valueOf(roundUp(result,4)));
                        result = num * 746;
                        edWA.setText(String.valueOf(roundUp(result,4)));
                        result = num * 0.07606;
                        edKotHP.setText(String.valueOf(roundUp(result,4)));
                        result = num * 1;
                        edElHP.setText(String.valueOf(roundUp(result,4)));
                        result = num * 1;
                        edMekHP.setText(String.valueOf(roundUp(result,4)));
                        result = num * 1.014;
                        edMetrHP.setText(String.valueOf(roundUp(result,4)));
                        break;
                    case 6:
                        result = num * 0.0007457;
                        edMBT.setText(String.valueOf(roundUp(result,4)));
                        result = num * 0.7457;
                        edKBT.setText(String.valueOf(roundUp(result,4)));
                        result = num * 745.7;
                        edWT.setText(String.valueOf(roundUp(result,4)));
                        result = num * 745.7;
                        edWA.setText(String.valueOf(roundUp(result,4)));
                        result = num * 0.07603;
                        edKotHP.setText(String.valueOf(roundUp(result,4)));
                        result = num * 0.9996;
                        edElHP.setText(String.valueOf(roundUp(result,4)));
                        result = num * 1;
                        edMekHP.setText(String.valueOf(roundUp(result,4)));
                        result = num * 1.014;
                        edMetrHP.setText(String.valueOf(roundUp(result,4)));
                        break;
                    case 7:
                        result = num * 0.0007355;
                        edMBT.setText(String.valueOf(roundUp(result,4)));
                        result = num * 0.7355;
                        edKBT.setText(String.valueOf(roundUp(result,4)));
                        result = num * 735.5;
                        edWT.setText(String.valueOf(roundUp(result,4)));
                        result = num * 735.5;
                        edWA.setText(String.valueOf(roundUp(result,4)));
                        result = num * 0.07499;
                        edKotHP.setText(String.valueOf(roundUp(result,4)));
                        result = num * 0.9859;
                        edElHP.setText(String.valueOf(roundUp(result,4)));
                        result = num * 0.9863;
                        edMekHP.setText(String.valueOf(roundUp(result,4)));
                        result = num * 1;
                        edMetrHP.setText(String.valueOf(roundUp(result,4)));
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
                || (edNum.getText().toString().equals("."))
                || (edNum.getText().toString().equals("-"))) {

            edMBT.setText("");
            edKBT.setText("");

           edWT.setText("");
            edWA.setText("");
            edKotHP.setText("");
            edElHP.setText("");
            edMekHP.setText("");
            edMetrHP.setText("");

            return;
        }
        num = Float.parseFloat(edNum.getText().toString());
        {

        }


       switch (a) {
           case 0:
               result = num * 1;
               edMBT.setText(String.valueOf(roundUp(result,4)));
               result = num * 1000;
               edKBT.setText(String.valueOf(roundUp(result,4)));
               result = num * 1e+6;
               edWT.setText(String.valueOf(roundUp(result,4)));
               result = num * 1e+6;
               edWA.setText(String.valueOf(roundUp(result,4)));
               result = num * 102;
               edKotHP.setText(String.valueOf(roundUp(result,4)));
               result = num * 1340;
               edElHP.setText(String.valueOf(roundUp(result,4)));
               result = num * 1341;
               edMekHP.setText(String.valueOf(roundUp(result,4)));
               result = num * 1360;
               edMetrHP.setText(String.valueOf(roundUp(result,4)));

               break;
           case 1:
               result = num * 0.001;
               edMBT.setText(String.valueOf(roundUp(result,4)));
               result = num * 1;
               edKBT.setText(String.valueOf(roundUp(result,4)));
               result = num * 1000;
               edWT.setText(String.valueOf(roundUp(result,4)));
               result = num * 1000;
               edWA.setText(String.valueOf(roundUp(result,4)));
               result = num * 0.102;
               edKotHP.setText(String.valueOf(roundUp(result,4)));
               result = num * 1.34;
               edElHP.setText(String.valueOf(roundUp(result,4)));
               result = num * 1.341;
               edMekHP.setText(String.valueOf(roundUp(result,4)));
               result = num * 1.36;
               edMetrHP.setText(String.valueOf(roundUp(result,4)));
               break;
           case 2:
               result = num * 0.000001;
               edMBT.setText(String.valueOf(roundUp(result,4)));
               result = num * 0.001;
               edKBT.setText(String.valueOf(roundUp(result,4)));
               result = num * 1;
               edWT.setText(String.valueOf(roundUp(result,4)));
               result = num * 1;
               edWA.setText(String.valueOf(roundUp(result,4)));
               result = num * 0.000102;
               edKotHP.setText(String.valueOf(roundUp(result,4)));
               result = num * 0.00134;
               edElHP.setText(String.valueOf(roundUp(result,4)));
               result = num * 0.001341;
               edMekHP.setText(String.valueOf(roundUp(result,4)));
               result = num * 0.00136;
               edMetrHP.setText(String.valueOf(roundUp(result,4)));
               break;
           case 3:
               result = num * 0.000001;
               edMBT.setText(String.valueOf(roundUp(result,4)));
               result = num * 0.001;
               edKBT.setText(String.valueOf(roundUp(result,4)));
               result = num * 1;
               edWT.setText(String.valueOf(roundUp(result,4)));
               result = num * 1;
               edWA.setText(String.valueOf(roundUp(result,4)));
               result = num * 0.000102;
               edKotHP.setText(String.valueOf(roundUp(result,4)));
               result = num * 0.00134;
               edElHP.setText(String.valueOf(roundUp(result,4)));
               result = num * 0.001341;
               edMekHP.setText(String.valueOf(roundUp(result,4)));
               result = num * 0.00136;
               edMetrHP.setText(String.valueOf(roundUp(result,4)));
               break;
           case 4:
               result = num * 0.009808;
               edMBT.setText(String.valueOf(roundUp(result,4)));
               result = num * 9.808;
               edKBT.setText(String.valueOf(roundUp(result,4)));
               result = num * 9808;
               edWT.setText(String.valueOf(roundUp(result,4)));
               result = num * 9808;
               edWA.setText(String.valueOf(roundUp(result,4)));
               result = num * 1;
               edKotHP.setText(String.valueOf(roundUp(result,4)));
               result = num * 13.15;
               edElHP.setText(String.valueOf(roundUp(result,4)));
               result = num * 13.15;
               edMekHP.setText(String.valueOf(roundUp(result,4)));
               result = num * 13.33;
               edMetrHP.setText(String.valueOf(roundUp(result,4)));
               break;
           case 5:
               result = num * 0.000746;
               edMBT.setText(String.valueOf(roundUp(result,4)));
               result = num * 0.746;
               edKBT.setText(String.valueOf(roundUp(result,4)));
               result = num * 746;
               edWT.setText(String.valueOf(roundUp(result,4)));
               result = num * 746;
               edWA.setText(String.valueOf(roundUp(result,4)));
               result = num * 0.07606;
               edKotHP.setText(String.valueOf(roundUp(result,4)));
               result = num * 1;
               edElHP.setText(String.valueOf(roundUp(result,4)));
               result = num * 1;
               edMekHP.setText(String.valueOf(roundUp(result,4)));
               result = num * 1.014;
               edMetrHP.setText(String.valueOf(roundUp(result,4)));
               break;
           case 6:
               result = num * 0.0007457;
               edMBT.setText(String.valueOf(roundUp(result,4)));
               result = num * 0.7457;
               edKBT.setText(String.valueOf(roundUp(result,4)));
               result = num * 745.7;
               edWT.setText(String.valueOf(roundUp(result,4)));
               result = num * 745.7;
               edWA.setText(String.valueOf(roundUp(result,4)));
               result = num * 0.07603;
               edKotHP.setText(String.valueOf(roundUp(result,4)));
               result = num * 0.9996;
               edElHP.setText(String.valueOf(roundUp(result,4)));
               result = num * 1;
               edMekHP.setText(String.valueOf(roundUp(result,4)));
               result = num * 1.014;
               edMetrHP.setText(String.valueOf(roundUp(result,4)));
               break;
           case 7:
               result = num * 0.0007355;
               edMBT.setText(String.valueOf(roundUp(result,4)));
               result = num * 0.7355;
               edKBT.setText(String.valueOf(roundUp(result,4)));
               result = num * 735.5;
               edWT.setText(String.valueOf(roundUp(result,4)));
               result = num * 735.5;
               edWA.setText(String.valueOf(roundUp(result,4)));
               result = num * 0.07499;
               edKotHP.setText(String.valueOf(roundUp(result,4)));
               result = num * 0.9859;
               edElHP.setText(String.valueOf(roundUp(result,4)));
               result = num * 0.9863;
               edMekHP.setText(String.valueOf(roundUp(result,4)));
               result = num * 1;
               edMetrHP.setText(String.valueOf(roundUp(result,4)));
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

