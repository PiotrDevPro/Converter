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

public class KidsActivity extends AppCompatActivity {

   // String[] data = {"0-1 мес(month)", "1-2 мес(month)", "3-6 мес(month)", "7-9 мес(month)", "1 год(year)", "1,5", "2", "3", "4", "5", "5-6", "6-7", "8", "9-10", "12","14","16"};
    EditText edSizeAgeKids, edChestKids, edRuSizeKids, edSizeWKids, edSizeEuKids, edSizeUsKids;
    Spinner spMassa;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kids);

        Toolbar my_toolbar = (Toolbar) findViewById(R.id.my_toolbar_app);
        RelativeLayout backColorlayoutAds = (RelativeLayout) findViewById(R.id.reLayoutClothesKidsAds);
        CollapsingToolbarLayout bottomColorLayout = (CollapsingToolbarLayout) findViewById(R.id.ClothesKidsBottomLayout);
        CoordinatorLayout corLoyDlinna = (CoordinatorLayout) findViewById(R.id.corLoyoutClothesKids);
        setSupportActionBar(my_toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,// data);
       // adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        getResources().getStringArray(R.array.clothesKids));

        TextView Nm = (TextView) findViewById(R.id.SizeAgeKids);
        TextView Km = (TextView) findViewById(R.id.ChestKids);
        TextView Mile = (TextView) findViewById(R.id.RuSizeKids);
        TextView m = (TextView) findViewById(R.id.SizeWKids);
        TextView yard = (TextView) findViewById(R.id.SizeEuKids);
        TextView grow = (TextView) findViewById(R.id.SizeUsKids);

        edSizeAgeKids = (EditText) findViewById(R.id.edSizeAgeKids);
        edChestKids = (EditText) findViewById(R.id.edChestKids);
        edRuSizeKids = (EditText) findViewById(R.id.edRuSizeKids);
        edSizeWKids = (EditText) findViewById(R.id.edSizeWKids);
        edSizeEuKids = (EditText) findViewById(R.id.edSizeEuKids);
        edSizeUsKids = (EditText) findViewById(R.id.edSizeUsKids);

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


            edSizeAgeKids.setBackgroundColor(getEditTextActivityColor());
            edSizeAgeKids.setTextColor(getEditTextColor());
            edChestKids.setBackgroundColor(getEditTextActivityColor());
            edChestKids.setTextColor(getEditTextColor());
            edRuSizeKids.setBackgroundColor(getEditTextActivityColor());
            edRuSizeKids.setTextColor(getEditTextColor());
            edSizeWKids.setBackgroundColor(getEditTextActivityColor());
            edSizeWKids.setTextColor(getEditTextColor());

            edSizeEuKids.setBackgroundColor(getEditTextActivityColor());
            edSizeEuKids.setTextColor(getEditTextColor());

            edSizeUsKids.setBackgroundColor(getEditTextActivityColor());
            edSizeUsKids.setTextColor(getEditTextColor());

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
                        edSizeAgeKids.setText("50-56,60-62");
                        edRuSizeKids.setText("18");
                        edChestKids.setText("36");

                        edSizeEuKids.setText("-");
                        edSizeWKids.setText("-");
                        edSizeUsKids.setText("-");
                        break;

                    case 1:
                        edSizeAgeKids.setText("62-68");
                        edRuSizeKids.setText("18");
                        edChestKids.setText("38");

                        edSizeEuKids.setText("-");
                        edSizeWKids.setText("-");
                        edSizeUsKids.setText("-");
                        break;
                    case 2:
                        edSizeAgeKids.setText("68-74");
                        edRuSizeKids.setText("20");
                        edChestKids.setText("40");

                        edSizeEuKids.setText("-");
                        edSizeWKids.setText("-");
                        edSizeUsKids.setText("-");
                        break;
                    case 3:
                        edSizeAgeKids.setText("74-80");
                        edRuSizeKids.setText("20");
                        edChestKids.setText("42");

                        edSizeEuKids.setText("-");
                        edSizeWKids.setText("-");
                        edSizeUsKids.setText("-");
                        break;
                    case 4:
                        edSizeAgeKids.setText("80-86");
                        edRuSizeKids.setText("22");
                        edChestKids.setText("44");

                        edSizeEuKids.setText("-");
                        edSizeWKids.setText("-");
                        edSizeUsKids.setText("-");
                        break;
                    case 5:
                        edSizeAgeKids.setText("86-92");
                        edRuSizeKids.setText("24");
                        edChestKids.setText("48");

                        edSizeEuKids.setText("-");
                        edSizeWKids.setText("-");
                        edSizeUsKids.setText("-");
                        break;
                    case 6:
                        edSizeAgeKids.setText("92-98");
                        edRuSizeKids.setText("26");
                        edChestKids.setText("52");

                        edSizeEuKids.setText("-");
                        edSizeWKids.setText("-");
                        edSizeUsKids.setText("-");
                        break;
                    case 7:
                        edSizeAgeKids.setText("98-104");
                        edRuSizeKids.setText("28");
                        edChestKids.setText("56");

                        edSizeEuKids.setText("-");
                        edSizeWKids.setText("-");
                        edSizeUsKids.setText("-");
                        break;
                    case 8:
                        edSizeAgeKids.setText("104-110");
                        edRuSizeKids.setText("28-30");
                        edChestKids.setText("58");

                        edSizeEuKids.setText("-");
                        edSizeWKids.setText("-");
                        edSizeUsKids.setText("-");
                        break;
                    case 9:
                        edSizeAgeKids.setText("110-116");
                        edRuSizeKids.setText("30-32");
                        edChestKids.setText("62");

                        edSizeEuKids.setText("2");
                        edSizeWKids.setText("2XS");
                        edSizeUsKids.setText("4");
                        break;
                    case 10:
                        edSizeAgeKids.setText("116-122");
                        edRuSizeKids.setText("32");
                        edChestKids.setText("64");

                        edSizeEuKids.setText("5");
                        edSizeWKids.setText("XS");
                        edSizeUsKids.setText("6");
                        break;
                    case 11:
                        edSizeAgeKids.setText("122-128");
                        edRuSizeKids.setText("34");
                        edChestKids.setText("68");

                        edSizeWKids.setText("XS");
                        edSizeEuKids.setText("5");
                        edSizeUsKids.setText("6");
                        break;
                    case 12:
                        edSizeAgeKids.setText("128-134");
                        edRuSizeKids.setText("34-36");
                        edChestKids.setText("70");

                        edSizeWKids.setText("S");
                        edSizeEuKids.setText("7");
                        edSizeUsKids.setText("8");
                        break;
                    case 13:
                        edSizeAgeKids.setText("134-150");
                        edRuSizeKids.setText("36");
                        edChestKids.setText("72");

                        edSizeWKids.setText("S");
                        edSizeEuKids.setText("7");
                        edSizeUsKids.setText("8");
                        break;
                    case 14:
                        edSizeAgeKids.setText("150-162");
                        edRuSizeKids.setText("38");
                        edChestKids.setText("76");

                        edSizeWKids.setText("M");
                        edSizeEuKids.setText("9");
                        edSizeUsKids.setText("10");
                        break;
                    case 15:
                        edSizeAgeKids.setText("162-177");
                        edRuSizeKids.setText("40-42");
                        edChestKids.setText("82");

                        edSizeWKids.setText("L");
                        edSizeEuKids.setText("11");
                        edSizeUsKids.setText("12");
                        break;
                    case 16:
                        edSizeAgeKids.setText("177");
                        edRuSizeKids.setText("42-44");
                        edChestKids.setText("86");

                        edSizeWKids.setText("XL");
                        edSizeEuKids.setText("11");
                        edSizeUsKids.setText("12");
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