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
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class ObuvActivity extends AppCompatActivity {

   // String[] data = {"22cm (35 EU)", "22.5см (35.5 EU)", "23см (36 EU)","23.5см (37 EU)","24cm (37.5 EU)", "24.5см (38 EU)", "25см (39 EU)","25.5см (39.5 EU)","25.75cm (40 EU)", "26см (41 EU)", "26.5см (41.5 EU)","27см (42 EU)","27.5cm (42.5 EU)", "28см (43 EU)", "28.5см (44 EU)","28.75см (44.5 EU)","29см (45 EU)","29.5см (46 EU)","30см (46.5 EU)","30.5см (47 EU)","31см (47.5 EU)","31.5см (48 EU)","31.75см (49 EU)","32см (49.5 EU)"};
    int a;
    Spinner spMassa;
    EditText edHeel,edEuSize,edUkSize,edUsSize,edRuSize;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.obuv);

        Toolbar my_toolbar = (Toolbar) findViewById(R.id.my_toolbar_app);
        LinearLayout LoyoutMainProc = (LinearLayout) findViewById(R.id.LoyoutMainObuv);
        RelativeLayout backColorlayoutAds = (RelativeLayout) findViewById(R.id.reLayoutShoesAds);
        CollapsingToolbarLayout bottomColorLayout = (CollapsingToolbarLayout) findViewById(R.id.ShoesBottomLayout);
        CoordinatorLayout corLoyDlinna = (CoordinatorLayout) findViewById(R.id.corLoyoutShoes);

        setSupportActionBar(my_toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,// data);
        //adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                getResources().getStringArray(R.array.foot));

        spMassa = (Spinner) findViewById(R.id.spMassa);
        spMassa.setAdapter(adapter);

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        TextView Nm = (TextView) findViewById(R.id.Heel);
        TextView Km = (TextView) findViewById(R.id.EuSize);
        TextView Mile = (TextView) findViewById(R.id.UkSize);
        TextView m = (TextView) findViewById(R.id.UsSize);
        TextView yard = (TextView)  findViewById(R.id.RuSize);




        edHeel = (EditText) findViewById(R.id.edHeel);
        edEuSize = (EditText) findViewById(R.id.edEuSize);
        edUkSize = (EditText) findViewById(R.id.edUkSize);
        edUsSize = (EditText) findViewById(R.id.edUsSize);
        edRuSize = (EditText) findViewById(R.id.edRuSize);

        if (getColor() != getResources().getColor(R.color.colorPrimary)) {

            my_toolbar.setBackgroundColor(getBackgroundColor());
            backColorlayoutAds.setBackgroundColor(getColor());
            bottomColorLayout.setBackgroundColor(getColor());
            corLoyDlinna.setBackgroundColor(getBackgroundColor());
            LoyoutMainProc.setBackgroundColor(getHalfBackgroundColor());

            Nm.setTextColor(getTextColor());
            Km.setTextColor(getTextColor());
            Mile.setTextColor(getTextColor());
            m.setTextColor(getTextColor());
            yard.setTextColor(getTextColor());


            edHeel.setBackgroundColor(getEditTextActivityColor());
            edHeel.setTextColor(getEditTextColor());
            edEuSize.setBackgroundColor(getEditTextActivityColor());
            edEuSize.setTextColor(getEditTextColor());
            edUkSize.setBackgroundColor(getEditTextActivityColor());
            edUkSize.setTextColor(getEditTextColor());
            edUsSize.setBackgroundColor(getEditTextActivityColor());
            edUsSize.setTextColor(getEditTextColor());
            edRuSize.setBackgroundColor(getEditTextActivityColor());
            edRuSize.setTextColor(getEditTextColor());
            spMassa.setBackgroundColor(getEditTextActivityColor());



            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                getWindow().setStatusBarColor(getColor());
            }
        }


        spMassa.setSelection(0);
        spMassa.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {



                switch (position){
                    case 0:
                        edHeel.setText("22cm");
                        edEuSize.setText("35");
                        edUkSize.setText("2.5");
                        edUsSize.setText("3");
                        edRuSize.setText("34");
                        break;
                    case 1:
                        edHeel.setText("22.5cm");
                        edEuSize.setText("35.5");
                        edUkSize.setText("3");
                        edUsSize.setText("3.5");
                        edRuSize.setText("34.5");
                        break;
                    case 2:
                        edHeel.setText("23cm");
                        edEuSize.setText("36");
                        edUkSize.setText("3,5");
                        edUsSize.setText("4");
                        edRuSize.setText("35");
                        break;
                    case 3:
                        edHeel.setText("23,5cm");
                        edEuSize.setText("37");
                        edUkSize.setText("4");
                        edUsSize.setText("4,5");
                        edRuSize.setText("36");
                        break;
                    case 4:
                        edHeel.setText("24cm");
                        edEuSize.setText("37,5");
                        edUkSize.setText("4,5");
                        edUsSize.setText("5");
                        edRuSize.setText("36,5");
                        break;
                    case 5:
                        edHeel.setText("24.5cm");
                        edEuSize.setText("38");
                        edUkSize.setText("5");
                        edUsSize.setText("5,5");
                        edRuSize.setText("37");
                        break;
                    case 6:
                        edHeel.setText("25cm");
                        edRuSize.setText("37,5");
                        edUkSize.setText("5,5");
                        edUsSize.setText("6");
                        edEuSize.setText("39");

                        break;
                    case 7:
                        edHeel.setText("25.5cm");
                        edRuSize.setText(" 38,5");
                        edUkSize.setText("6");
                        edUsSize.setText("6,5");
                        edEuSize.setText("39,5");

                        break;
                    case 8:
                        edHeel.setText("25.75cm");
                        edRuSize.setText("39");
                        edUkSize.setText("6,5");
                        edUsSize.setText("7");
                        edEuSize.setText("40");
                        break;
                    case 9:
                        edHeel.setText("26cm");
                        edRuSize.setText("40");
                        edUkSize.setText("7");
                        edUsSize.setText("7,5");
                        edEuSize.setText("41");
                        break;
                    case 10:
                        edHeel.setText("26.5cm");
                        edRuSize.setText("40,5");
                        edUkSize.setText("7,5");
                        edUsSize.setText("8");
                        edEuSize.setText("41,5");
                        break;
                    case 11:
                        edHeel.setText("27cm");
                        edRuSize.setText("41");
                        edUkSize.setText("8");
                        edUsSize.setText("8,5");
                        edEuSize.setText("42");
                        break;
                    case 12:
                        edHeel.setText("27.5cm");
                        edRuSize.setText("41,5");
                        edUkSize.setText("8,5");
                        edUsSize.setText("9");
                        edEuSize.setText("42,5");
                        break;
                    case 13:
                        edHeel.setText("28cm");
                        edRuSize.setText("42");
                        edUkSize.setText("9");
                        edUsSize.setText("9,5");
                        edEuSize.setText("43");
                        break;
                    case 14:
                        edHeel.setText("28.5cm");
                        edRuSize.setText("43");
                        edUkSize.setText("9,5");
                        edUsSize.setText("10");
                        edEuSize.setText("44");
                        break;
                    case 15:
                        edHeel.setText("28.75cm");
                        edRuSize.setText("43,5");
                        edUkSize.setText("10");
                        edUsSize.setText("10,5");
                        edEuSize.setText("44,5");
                        break;
                    case 16:
                        edHeel.setText("29cm");
                        edRuSize.setText("44,5");
                        edUkSize.setText("10,5");
                        edUsSize.setText("11");
                        edEuSize.setText("45");
                        break;
                    case 17:
                        edHeel.setText("29.5cm");
                        edRuSize.setText("45");
                        edUkSize.setText("11");
                        edUsSize.setText("11,5");
                        edEuSize.setText("46");
                        break;
                    case 18:
                        edHeel.setText("30cm");
                        edRuSize.setText("45,5");
                        edUkSize.setText("11,5");
                        edUsSize.setText("12");
                        edEuSize.setText("46,5");
                        break;
                    case 19:
                        edHeel.setText("30.5cm");
                        edRuSize.setText("46");
                        edUkSize.setText("12");
                        edUsSize.setText("12,5");
                        edEuSize.setText("47");
                        break;

                    case 20:
                        edHeel.setText("31cm");
                        edRuSize.setText("46,5");
                        edUkSize.setText("12,5");
                        edUsSize.setText("13");
                        edEuSize.setText("47,5");
                        break;
                    case 21:
                        edHeel.setText("31.5cm");
                        edRuSize.setText("47");
                        edUkSize.setText("13");
                        edUsSize.setText("13,5");
                        edEuSize.setText("48");
                        break;
                    case 22:
                        edHeel.setText("31.75cm");
                        edRuSize.setText("48");
                        edUkSize.setText("13,5");
                        edUsSize.setText("14");
                        edEuSize.setText("49");
                        break;
                    case 23:
                        edHeel.setText("32cm");
                        edRuSize.setText("48,5");
                        edUkSize.setText("14");
                        edUsSize.setText("14,5");
                        edEuSize.setText("49,5");
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

    private int getHalfBackgroundColor(){
        SharedPreferences mSharedPref = getSharedPreferences("ThemeColor", MODE_PRIVATE);
        int selectedBackColor = mSharedPref.getInt("backcolor", getResources().getColor(R.color.dark_backgroundHalfColor));
        return selectedBackColor;
    }
}

