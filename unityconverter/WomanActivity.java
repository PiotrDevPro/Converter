package com.piotrdevelop.unityconverter;

import android.content.SharedPreferences;
import android.os.Build;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class WomanActivity extends AppCompatActivity {

    String[] data = {"42","44","46","48","50","52","54","56","58","60","62","64","66","68","70"};
    EditText edSizeEuW,RSizeW,WTopW,HThigh,Chest,edGrowW;
    Spinner spMassa;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.woman);

        Toolbar my_toolbar = (Toolbar) findViewById(R.id.my_toolbar_app);
        RelativeLayout backColorlayoutAds = (RelativeLayout) findViewById(R.id.reLayoutClothesWomAds);
        CollapsingToolbarLayout bottomColorLayout = (CollapsingToolbarLayout) findViewById(R.id.ClothesWomBottomLayout);
        CoordinatorLayout corLoyDlinna = (CoordinatorLayout) findViewById(R.id.corLoyoutClothesWom);
        setSupportActionBar(my_toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,data);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        TextView Nm = (TextView) findViewById(R.id.SizeEuW);
        TextView Km = (TextView) findViewById(R.id.SizeW);
        TextView Mile = (TextView) findViewById(R.id.tWTopW);
        TextView m = (TextView) findViewById(R.id.tHThigh);
        TextView yard = (TextView) findViewById(R.id.tChest);
        TextView grow = (TextView) findViewById(R.id.GrowW);

        edSizeEuW = (EditText)findViewById(R.id.edSizeEuW);
        RSizeW = (EditText)findViewById(R.id.RSizeW);
        WTopW = (EditText)findViewById(R.id.WTopW);
        HThigh = (EditText)findViewById(R.id.HThigh);
        Chest = (EditText)findViewById(R.id.Chest);
        edGrowW = (EditText)findViewById(R.id.edGrowW);

        spMassa = (Spinner) findViewById(R.id.spMassa);
        spMassa.setAdapter(adapter);

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
            grow.setTextColor(getTextColor());


            edSizeEuW.setBackgroundColor(getEditTextActivityColor());
            edSizeEuW.setTextColor(getEditTextColor());
            RSizeW.setBackgroundColor(getEditTextActivityColor());
           // RSizeW.setTextColor(getEditTextColor());
            WTopW.setBackgroundColor(getEditTextActivityColor());
            WTopW.setTextColor(getEditTextColor());
            HThigh.setBackgroundColor(getEditTextActivityColor());
            HThigh.setTextColor(getEditTextColor());
            Chest.setBackgroundColor(getEditTextActivityColor());
            Chest.setTextColor(getEditTextColor());
            edGrowW.setBackgroundColor(getEditTextActivityColor());
            edGrowW.setTextColor(getEditTextColor());

//
            spMassa.setBackgroundColor(getEditTextActivityColor());
//
//
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                getWindow().setStatusBarColor(getColor());
            }
        }


        spMassa.setSelection(0);
        spMassa.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                String strRsize = spMassa.getSelectedItem().toString();

                switch (position) {
                    case 0:
                        edSizeEuW.setText("S");
                        RSizeW.setText(strRsize);
                        WTopW.setText("66");
                        HThigh.setText("92");
                        Chest.setText("84");
                        edGrowW.setText("<164");
                        break;
                    case 1:
                        edSizeEuW.setText("M");
                        RSizeW.setText(strRsize);
                        WTopW.setText("70");
                        HThigh.setText("96");
                        Chest.setText("88");
                        edGrowW.setText("164-170");
                        break;
                    case 2:
                        edSizeEuW.setText("M");
                        RSizeW.setText(strRsize);
                        WTopW.setText("74");
                        HThigh.setText("100");
                        Chest.setText("92");
                        edGrowW.setText("164-170");
                        break;
                    case 3:
                        edSizeEuW.setText("L");
                        RSizeW.setText(strRsize);
                        WTopW.setText("78");
                        HThigh.setText("104");
                        Chest.setText("96");
                        edGrowW.setText("170-176");
                        break;
                    case 4:
                        edSizeEuW.setText("L");
                        RSizeW.setText(strRsize);
                        WTopW.setText("82");
                        HThigh.setText("108");
                        Chest.setText("100");
                        edGrowW.setText("170-176");
                        break;
                    case 5:
                        edSizeEuW.setText("XL");
                        RSizeW.setText(strRsize);
                        WTopW.setText("86");
                        HThigh.setText("112");
                        Chest.setText("104");
                        edGrowW.setText("170-176");
                        break;
                    case 6:
                        edSizeEuW.setText("XXL");
                        RSizeW.setText(strRsize);
                        WTopW.setText("90");
                        HThigh.setText("116");
                        Chest.setText("108");
                        edGrowW.setText("176-182");
                        break;
                    case 7:
                        edSizeEuW.setText("XXL");
                        RSizeW.setText(strRsize);
                        WTopW.setText("94");
                        HThigh.setText("120");
                        Chest.setText("112");
                        edGrowW.setText("176-182");
                        break;
                    case 8:
                        edSizeEuW.setText("XXXL");
                        RSizeW.setText(strRsize);
                        WTopW.setText("98");
                        HThigh.setText("124");
                        Chest.setText("116");
                        edGrowW.setText(">182");
                        break;
                    case 9:
                        edSizeEuW.setText("4XL");
                        RSizeW.setText(strRsize);
                        WTopW.setText("100");
                        HThigh.setText("128");
                        Chest.setText("120");
                        edGrowW.setText(">182");
                        break;
                    case 10:
                        edSizeEuW.setText("4XL");
                        RSizeW.setText(strRsize);
                        WTopW.setText("104");
                        HThigh.setText("132");
                        Chest.setText("124");
                        edGrowW.setText(">182");
                        break;
                    case 11:
                        edSizeEuW.setText("4XL");
                        RSizeW.setText(strRsize);
                        WTopW.setText("108");
                        HThigh.setText("136");
                        Chest.setText("128");
                        edGrowW.setText(">182");
                        break;
                    case 12:
                        edSizeEuW.setText("5XL");
                        RSizeW.setText(strRsize);
                        WTopW.setText("112");
                        HThigh.setText("140");
                        Chest.setText("132");
                        edGrowW.setText(">190");
                        break;
                    case 13:
                        edSizeEuW.setText("5XL");
                        RSizeW.setText(strRsize);
                        WTopW.setText("116");
                        HThigh.setText("144");
                        Chest.setText("136");
                        edGrowW.setText(">190");
                        break;
                    case 14:
                        edSizeEuW.setText("5XL");
                        RSizeW.setText(strRsize);
                        WTopW.setText("120");
                        HThigh.setText("148");
                        Chest.setText("140");
                        edGrowW.setText(">190");
                        break;
                }


            }


            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



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
