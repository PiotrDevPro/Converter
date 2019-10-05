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


public class InfoActivity extends AppCompatActivity implements TextWatcher{

  //  String[] data = {"Бит (bit)", "Байт (byte)", "Килобайт (KB)","Мегабайт (MB)","Гигабайт (GB)","Терабайт (TB)"};
    int a;
    Spinner spMassa;
    EditText edNum, edBit,edByte,edKB,edMB,edGB,edTB;
   // TextView tvPosName;

    public BigDecimal roundUp(double value, int digits) {
        return new BigDecimal("" + value).setScale(digits, BigDecimal.ROUND_HALF_UP);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.information);

        Toolbar my_toolbar = (Toolbar) findViewById(R.id.my_toolbar_app);
        RelativeLayout backColorlayoutAds = (RelativeLayout) findViewById(R.id.reLayoutInfoAds);
        CollapsingToolbarLayout bottomColorLayout = (CollapsingToolbarLayout) findViewById(R.id.InfolottomLayout);
        CoordinatorLayout corLoyDlinna = (CoordinatorLayout) findViewById(R.id.corLoyoutInfo);

        setSupportActionBar(my_toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,// data);
       // adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                getResources().getStringArray(R.array.info));

        spMassa = (Spinner) findViewById(R.id.spMassa);
        spMassa.setAdapter(adapter);

        TextView Nm = (TextView) findViewById(R.id.TB);
        TextView Km = (TextView) findViewById(R.id.GB);
        TextView Mile = (TextView) findViewById(R.id.MB);
        TextView m = (TextView) findViewById(R.id.KB);
        TextView yard = (TextView)  findViewById(R.id.bytee);
        TextView ft = (TextView)  findViewById(R.id.bit);


      //  tvPosName = (TextView) findViewById(R.id.tvPosName);

        edNum = (EditText) findViewById(R.id.edNum);

        edBit = (EditText) findViewById(R.id.edBit);
        edByte = (EditText) findViewById(R.id.edByte);
        edKB = (EditText) findViewById(R.id.edKB);

        edMB = (EditText) findViewById(R.id.edMB);
        edGB = (EditText) findViewById(R.id.edGB);
        edTB = (EditText) findViewById(R.id.edTB);

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

            edBit.setBackgroundColor(getEditTextActivityColor());
            edBit.setTextColor(getEditTextColor());
            edByte.setBackgroundColor(getEditTextActivityColor());
            edByte.setTextColor(getEditTextColor());
            edKB.setBackgroundColor(getEditTextActivityColor());
            edKB.setTextColor(getEditTextColor());
            edMB.setBackgroundColor(getEditTextActivityColor());
            edMB.setTextColor(getEditTextColor());
            edGB.setBackgroundColor(getEditTextActivityColor());
            edGB.setTextColor(getEditTextColor());
            edTB.setBackgroundColor(getEditTextActivityColor());
            edTB.setTextColor(getEditTextColor());


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

                    edBit.setText("");
                    edByte.setText("");
                    edKB.setText("");
                    edMB.setText("");
                    edGB.setText("");
                    edTB.setText("");

                    return;
                }
                num = Float.parseFloat(edNum.getText().toString());

                switch (position){
                    case 0:
                        result =  num;
                        edBit.setText(String.valueOf(roundUp(result,2)));
                        result =  num * 0.125;
                        edByte.setText(String.valueOf(roundUp(result,2)));
                        result =  num * 0.0001221;
                        edKB.setText(String.valueOf(roundUp(result,3)));
                        result =  num * 1.19e-7;
                        edMB.setText(String.valueOf(roundUp(result,4)));
                        result =  num * 1.16e-10;
                        edGB.setText(String.valueOf(roundUp(result,5)));
                        result =  num * 1.13e-13;
                        edTB.setText(String.valueOf(roundUp(result,6)));
                        break;

                    case 1:
                        result =  num * 8;
                        edBit.setText(String.valueOf(roundUp(result,2)));
                        result =  num;
                        edByte.setText(String.valueOf(roundUp(result,2)));
                        result =  num * 0.0009766;
                        edKB.setText(String.valueOf(roundUp(result,3)));
                        result =  num * 0.0000009537;
                        edMB.setText(String.valueOf(roundUp(result,4)));
                        result =  num * 0.0000000009313;
                        edGB.setText(String.valueOf(roundUp(result,5)));
                        result =  num * 0.0000000000009095;
                        edTB.setText(String.valueOf(roundUp(result,6)));
                        break;

                    case 2:
                        result =  num * 8192;
                        edBit.setText(String.valueOf(roundUp(result,2)));
                        result =  num * 1024;
                        edByte.setText(String.valueOf(roundUp(result,2)));
                        result =  num ;
                        edKB.setText(String.valueOf(roundUp(result,2)));
                        result = num  / 1024 ;
                        edMB.setText(String.valueOf(roundUp(result,2)));
                        result =  num / 1048576;
                        edGB.setText(String.valueOf(roundUp(result,3)));
                        result =  num / 1073741800;
                        edTB.setText(String.valueOf(roundUp(result,4)));
                        break;

                    case 3:
                        result =  num * 8388608;
                        edBit.setText(String.valueOf(roundUp(result,2)));
                        result =  num * 1048576;
                        edByte.setText(String.valueOf(roundUp(result,2)));
                        result =  num * 1024;
                        edKB.setText(String.valueOf(roundUp(result,2)));
                        result =  num;
                        edMB.setText(String.valueOf(roundUp(result,2)));
                        result = num / 1024;
                        edGB.setText(String.valueOf(roundUp(result,3)));
                        result =  num * 0.0000009537;
                        edTB.setText(String.valueOf(roundUp(result,4)));
                        break;

                    case 4:
                        result = num * 8.58e+9;
                        edBit.setText(String.valueOf(roundUp(result,4)));
                        result = num * 1073741800;
                        edByte.setText(String.valueOf(roundUp(result,3)));
                        result = num * 1048576;
                        edKB.setText(String.valueOf(roundUp(result,2)));
                        result = num * 1024;
                        edMB.setText(String.valueOf(roundUp(result,2)));
                        result = num;
                        edGB.setText(String.valueOf(roundUp(result,2)));
                        result = num / 1024;
                        edTB.setText(String.valueOf(roundUp(result,1)));
                        break;

                    case 5:
                        result =  num * 8.6092845927e+12;
                        edBit.setText(String.valueOf(roundUp(result,4)));
                        result =  num * 1.0995116e+12;;
                        edByte.setText(String.valueOf(roundUp(result,3)));
                        result =  num * 1.073e+9;
                        edKB.setText(String.valueOf(roundUp(result,2)));
                        result =  num * 1048576;
                        edMB.setText(String.valueOf(roundUp(result,2)));
                        result =  num * 1024;
                        edGB.setText(String.valueOf(roundUp(result,2)));
                        result =  num;
                        edTB.setText(String.valueOf(roundUp(result,1)));
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

            edBit.setText("");
            edByte.setText("");
            edKB.setText("");

            edMB.setText("");
            edGB.setText("");
            edTB.setText("");

            return;
        }
        num = Float.parseFloat(edNum.getText().toString());

        switch (a) {
            case 0:
                result =  num;
                edBit.setText(String.valueOf(roundUp(result,2)));
                result =  num * 0.125;
                edByte.setText(String.valueOf(roundUp(result,2)));
                result =  num * 0.0001221;
                edKB.setText(String.valueOf(roundUp(result,3)));
                result =  num * 1.19e-7;
                edMB.setText(String.valueOf(roundUp(result,4)));
                result =  num * 1.16e-10;
                edGB.setText(String.valueOf(roundUp(result,5)));
                result =  num * 1.13e-13;
                edTB.setText(String.valueOf(roundUp(result,6)));

            break;

            case 1:
                result =  num * 8;
                edBit.setText(String.valueOf(roundUp(result,2)));
                result =  num;
                edByte.setText(String.valueOf(roundUp(result,2)));
                result =  num * 0.0009766;
                edKB.setText(String.valueOf(roundUp(result,3)));
                result =  num * 0.0000009537;
                edMB.setText(String.valueOf(roundUp(result,4)));
                result =  num * 0.0000000009313;
                edGB.setText(String.valueOf(roundUp(result,5)));
                result =  num * 0.0000000000009095;
                edTB.setText(String.valueOf(roundUp(result,6)));

                break;

            case 2:
                result =  num * 8192;
                edBit.setText(String.valueOf(roundUp(result,2)));
                result =  num * 1024;
                edByte.setText(String.valueOf(roundUp(result,2)));
                result =  num;
                edKB.setText(String.valueOf(roundUp(result,2)));
                result = num / 1024 ;
                edMB.setText(String.valueOf(roundUp(result,2)));
                result =  num / 1048576;
                edGB.setText(String.valueOf(roundUp(result,3)));
                result =  num / 1073741800;
                edTB.setText(String.valueOf(roundUp(result,4)));

                break;

            case 3:
                result =  num * 8388608;
                edBit.setText(String.valueOf(roundUp(result,2)));
                result =  num * 1048576;
                edByte.setText(String.valueOf(roundUp(result,2)));
                result =  num * 1024;
                edKB.setText(String.valueOf(roundUp(result,2)));
                result =  num;
                edMB.setText(String.valueOf(roundUp(result,2)));
                result = num / 1024;
                edGB.setText(String.valueOf(roundUp(result,3)));
                result =  num * 0.0000009537;
                edTB.setText(String.valueOf(roundUp(result,4)));

                break;

            case 4:
                result = num * 8.58e+9;
                edBit.setText(String.valueOf(roundUp(result,4)));
                result = num * 1073741800;
                edByte.setText(String.valueOf(roundUp(result,3)));
                result = num * 1048576;
                edKB.setText(String.valueOf(roundUp(result,2)));
                result = num * 1024;
                edMB.setText(String.valueOf(roundUp(result,2)));
                result = num;
                edGB.setText(String.valueOf(roundUp(result,2)));
                result = num / 1024;
                edTB.setText(String.valueOf(roundUp(result,1)));

                break;
            case 5:
                result =  num * 8.6092845927e+12;
                edBit.setText(String.valueOf(roundUp(result,4)));
                result =  num * 1.0995116e+12;
                edByte.setText(String.valueOf(roundUp(result,3)));
                result =  num * 1073741800;
                edKB.setText(String.valueOf(roundUp(result,2)));
                result =  num * 1048576;
                edMB.setText(String.valueOf(roundUp(result,2)));
                result =  num * 1024;
                edGB.setText(String.valueOf(roundUp(result,2)));
                result =  num;
                edTB.setText(String.valueOf(roundUp(result,1)));

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


