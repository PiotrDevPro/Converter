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

public class ActivityManLow extends AppCompatActivity {

    String[] data = {"70","70-76","76","76-82","82","82-88","88-94","94","94-100","100","106","106-112"};
    EditText edSizeEu,usaSize,W,H,RSize,WSize;
    Spinner spMassa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_low);

        Toolbar my_toolbar = (Toolbar) findViewById(R.id.my_toolbar_app);
        RelativeLayout backColorlayoutAds = (RelativeLayout) findViewById(R.id.reLayoutClothesLowAds);
        CollapsingToolbarLayout bottomColorLayout = (CollapsingToolbarLayout) findViewById(R.id.ClothesLowBottomLayout);
        CoordinatorLayout corLoyDlinna = (CoordinatorLayout) findViewById(R.id.corLoyoutClothesLow);
        setSupportActionBar(my_toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, data);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        TextView Nm = (TextView) findViewById(R.id.SizeEu);
        TextView Km = (TextView) findViewById(R.id.tRSize);
        TextView Mile = (TextView) findViewById(R.id.tWSize);
        TextView m = (TextView) findViewById(R.id.tW);
        TextView yard = (TextView) findViewById(R.id.tH);
        TextView grow = (TextView) findViewById(R.id.tusaSize);


        edSizeEu = (EditText) findViewById(R.id.edSizeEu);
        usaSize = (EditText) findViewById(R.id.usaSize);
        W = (EditText) findViewById(R.id.W);
        H = (EditText) findViewById(R.id.H);
        RSize = (EditText) findViewById(R.id.RSize);
        WSize = (EditText) findViewById(R.id.WSize);


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
            usaSize.setBackgroundColor(getEditTextActivityColor());
            usaSize.setTextColor(getEditTextColor());
            W.setBackgroundColor(getEditTextActivityColor());
            //  W.setTextColor(getEditTextColor());
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

                String strWaist = spMassa.getSelectedItem().toString();


                switch (position) {

                    case 0:
                        edSizeEu.setText("28");
                        RSize.setText("44");
                        usaSize.setText("2-4");
                        //  W.setText("70-72"+"см");
                        H.setText("92" + "см");
                        W.setText(strWaist + "см");
                        WSize.setText("XXS");
                        break;
                    case 1:
                        edSizeEu.setText("29");
                        RSize.setText("44-46");
                        usaSize.setText("4");
                        //   W.setText("72.5-75"+"см");
                        H.setText("92-96" + "см");
                        W.setText(strWaist + "см");
                        WSize.setText("XXS/XS");
                        break;
                    case 2:
                        edSizeEu.setText("30");
                        RSize.setText("46");
                        usaSize.setText("6");
                        //   W.setText("75-77.5"+"см");
                        H.setText("96" + "см");
                        W.setText(strWaist + "см");
                        WSize.setText("XS");
                        break;
                    case 3:
                        edSizeEu.setText("31");
                        RSize.setText("46-48");
                        usaSize.setText("6-8");
                        // W.setText("77.5-80"+"см");
                        H.setText("96-100" + "см");
                        W.setText(strWaist + "см");
                        WSize.setText("XS/S");
                        break;
                    case 4:
                        edSizeEu.setText("32");
                        RSize.setText("48");
                        usaSize.setText("8");
                        //  W.setText("80-82.5"+"см");
                        H.setText("100" + "см");
                        W.setText(strWaist + "см");
                        WSize.setText("S");
                        break;
                    case 5:
                        edSizeEu.setText("33");
                        RSize.setText("48-50");
                        usaSize.setText("8-10");
                        // W.setText("82.5-85"+"см");
                        H.setText("100-104" + "см");
                        W.setText(strWaist + "см");
                        WSize.setText("S/M");
                        break;
                    case 6:
                        edSizeEu.setText("34");
                        RSize.setText("50");
                        usaSize.setText("10");
                        //  W.setText("85-87.5"+"см");
                        H.setText("104" + "см");
                        W.setText(strWaist + "см");
                        WSize.setText("M");
                        break;
                    case 7:
                        edSizeEu.setText("35");
                        RSize.setText("50-52");
                        usaSize.setText("10-12");
                        // W.setText("87.5-92.5"+"см");
                        H.setText("104-108" + "см");
                        W.setText(strWaist + "см");
                        WSize.setText("M/L");
                        break;
                    case 8:
                        edSizeEu.setText("36");
                        RSize.setText("52");
                        usaSize.setText("12");
                        //  W.setText("95-100"+"см");
                        H.setText("108" + "см");
                        W.setText(strWaist + "см");
                        WSize.setText("L");
                        break;
                    case 9:
                        edSizeEu.setText("38");
                        RSize.setText("52-54");
                        usaSize.setText("12-14");
                        //   W.setText("100-103"+"см");
                        H.setText("108-112" + "см");
                        W.setText(strWaist + "см");
                        WSize.setText("L/XL");
                        break;
                    case 10:
                        edSizeEu.setText("40");
                        RSize.setText("54");
                        usaSize.setText("14");
                        //  W.setText("104-108"+"см");
                        H.setText("112" + "см");
                        W.setText(strWaist + "см");
                        WSize.setText("XL");
                        break;
                    case 11:
                        edSizeEu.setText("41");
                        RSize.setText("56");
                        usaSize.setText("16");
                        //   W.setText("109-113"+"см");
                        H.setText("116" + "см");
                        W.setText(strWaist + "см");
                        WSize.setText("XXL");
                        break;
                    case 12:
                        edSizeEu.setText("42");
                        RSize.setText("56-58");
                        usaSize.setText("16-18");
                        H.setText("116-120" + "см");
                        W.setText(strWaist + "см");
                        WSize.setText("XXL/XXXL");
                        break;

                    case 13:
                        edSizeEu.setText("44");
                        RSize.setText("58");
                        usaSize.setText("18");
                        H.setText("120" + "см");
                        W.setText(strWaist + "см");
                        WSize.setText("XXXL");
                        break;
                    case 14:
                        edSizeEu.setText("46");
                        RSize.setText("60");
                        usaSize.setText("20");
                        H.setText("124" + "см");
                        W.setText(strWaist + "см");
                        WSize.setText("XXXL");
                        break;
                    case 15:
                        edSizeEu.setText("48");
                        RSize.setText("62");
                        usaSize.setText("22");
                        H.setText("128" + "см");
                        W.setText(strWaist + "см");
                        WSize.setText("XXXL");
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

