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

public class ActivityWomanLow extends AppCompatActivity {

    String[] data = {"140-145","145-150","150-155","155-160","160-165","165-170","170-175","175-180","180-185","185-190"};
    EditText edSizeEu,rost,W,H,RSize,WSize;
    Spinner spMassa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_woman_low);

        Toolbar my_toolbar = (Toolbar) findViewById(R.id.my_toolbar_app);
        RelativeLayout backColorlayoutAds = (RelativeLayout) findViewById(R.id.reLayoutClothesWomLowAds);
        CollapsingToolbarLayout bottomColorLayout = (CollapsingToolbarLayout) findViewById(R.id.ClothesWomLowBottomLayout);
        CoordinatorLayout corLoyDlinna = (CoordinatorLayout) findViewById(R.id.corLoyoutClothesWomLow);
        setSupportActionBar(my_toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, data);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        TextView Nm = (TextView) findViewById(R.id.wrost);
        TextView Km = (TextView) findViewById(R.id.wH);
        TextView Mile = (TextView) findViewById(R.id.wW);
        TextView m = (TextView) findViewById(R.id.wWSize);
        TextView yard = (TextView) findViewById(R.id.wRSize);
        TextView grow = (TextView) findViewById(R.id.SizeEu);


        edSizeEu = (EditText) findViewById(R.id.edSizeEu);
        rost = (EditText) findViewById(R.id.rost);
        W = (EditText) findViewById(R.id.W);
        H = (EditText) findViewById(R.id.H);
        RSize = (EditText)findViewById(R.id.RSize);
        WSize = (EditText)findViewById(R.id.WSize);

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


            edSizeEu.setBackgroundColor(getEditTextActivityColor());
            edSizeEu.setTextColor(getEditTextColor());
            rost.setBackgroundColor(getEditTextActivityColor());
          //  rost.setTextColor(getEditTextColor());
            W.setBackgroundColor(getEditTextActivityColor());
            W.setTextColor(getEditTextColor());
            H.setBackgroundColor(getEditTextActivityColor());
            H.setTextColor(getEditTextColor());
            RSize.setBackgroundColor(getEditTextActivityColor());
            RSize.setTextColor(getEditTextColor());
            WSize.setBackgroundColor(getEditTextActivityColor());
            WSize.setTextColor(getEditTextColor());

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

                String strRost = spMassa.getSelectedItem().toString();


                switch (position){
                    case 0:
                        edSizeEu.setText("27");
                        RSize.setText("42-44");
                        W.setText("65.5-68"+"см");
                        H.setText("96.5-99"+"см");
                        rost.setText(strRost+"см");
                        WSize.setText("S");
                        break;
                    case 1:
                        edSizeEu.setText("28");
                        RSize.setText("44");
                        W.setText("68-70.5"+"см");
                        H.setText("99-101.5"+"см");
                        rost.setText(strRost+"см");
                        WSize.setText("S");
                        break;
                    case 2:
                        edSizeEu.setText("29");
                        RSize.setText("44-46");
                        W.setText("70.5-73"+"см");
                        H.setText("101.5-104"+"см");
                        rost.setText(strRost+"см");
                        WSize.setText("M");

                        break;
                    case 3:
                        edSizeEu.setText("30");
                        RSize.setText("46");
                        W.setText("73-75.5"+"см");
                        H.setText("104-106.5"+"см");
                        rost.setText(strRost+"см");
                        WSize.setText("M");
                        break;
                    case 4:
                        edSizeEu.setText("31");
                        RSize.setText("46-48");
                        W.setText("75.5-79"+"см");
                        H.setText("106.5-110"+"см");
                        rost.setText(strRost+"см");
                        WSize.setText("M");
                        break;
                    case 5:
                        edSizeEu.setText("32");
                        RSize.setText("48");
                        W.setText("79.5-82.5"+"см");
                        H.setText("110.5-113"+"см");
                        rost.setText(strRost+"см");
                        WSize.setText("L");
                        break;
                    case 6:
                        edSizeEu.setText("33");
                        RSize.setText("48-50");
                        W.setText("82.5-87"+"см");
                        H.setText("113.5-118"+"см");
                        rost.setText(strRost+"см");
                        WSize.setText("L");
                        break;
                    case 7:
                        edSizeEu.setText("34");
                        RSize.setText("50");
                        W.setText("87-92"+"см");
                        H.setText("118-123"+"см");
                        rost.setText(strRost+"см");
                        WSize.setText("XL");
                        break;
                    case 8:
                        edSizeEu.setText("35");
                        RSize.setText("50-52");
                        W.setText("92-97"+"см");
                        H.setText("123-128"+"см");
                        rost.setText(strRost+"см");
                        WSize.setText("XL");
                        break;
                    case 9:
                        edSizeEu.setText("36");
                        RSize.setText("52");
                        W.setText("97-102"+"см");
                        H.setText("128-132"+"см");
                        rost.setText(strRost+"см");
                        WSize.setText("XL");
                        break;
                    case 10:
                        edSizeEu.setText("38");
                        RSize.setText("52-54");
                        W.setText("102-106.5"+"см");
                        H.setText("132-136"+"см");
                        rost.setText(strRost+"см");
                        WSize.setText("XXL");
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

