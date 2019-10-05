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


public class SpeedActivity extends AppCompatActivity implements TextWatcher{

 //   String[] data = {"Миля в час (mph)", "Фут в сек (ft/s)", "Метр в сек (m/s)", "Километр в час (km/h)", "Узел (knots)","Скорость света (light speed)","Километр в сек.(km/sec)","Миля в сек.(mp/sec)"};
    int a;
    Spinner spMassa;
    EditText edNum,edMilHour, edFutSek, edMetrSek, edKmHour, edUzel,edlspeed,kmsec,mpsec,edlspeedsnd;
//    TextView tvPosName;

    public BigDecimal roundUp(double value, int digits){
        return new BigDecimal(""+value).setScale(digits, BigDecimal.ROUND_HALF_UP);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.speed);

        Toolbar my_toolbar = (Toolbar) findViewById(R.id.my_toolbar_app);
        RelativeLayout backColorlayoutAds = (RelativeLayout) findViewById(R.id.reLayoutSpeedAds);
        CollapsingToolbarLayout bottomColorLayout = (CollapsingToolbarLayout) findViewById(R.id.bottomColAds);
        CoordinatorLayout corLoyDlinna = (CoordinatorLayout) findViewById(R.id.corLoyoutSpeed);
        setSupportActionBar(my_toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, //data);
       // adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                getResources().getStringArray(R.array.speed));

        spMassa = (Spinner) findViewById(R.id.spMassa);
        spMassa.setAdapter(adapter);

        edNum = (EditText) findViewById(R.id.edNum);
//        tvPosName = (TextView) findViewById(R.id.tvPosName);

        TextView mph = (TextView) findViewById(R.id.mph);
        TextView mpsecc = (TextView) findViewById(R.id.mpsec);
        TextView fts = (TextView) findViewById(R.id.fts);
        TextView ms = (TextView) findViewById(R.id.ms);
        TextView kmh = (TextView)  findViewById(R.id.kmh);
        TextView kmsecc = (TextView)  findViewById(R.id.kmsecc);
        TextView knots = (TextView) findViewById(R.id.knots);
        TextView lightspeed = (TextView)  findViewById(R.id.lightspeed);


        edMilHour = (EditText) findViewById(R.id.edMilHour);
        edFutSek = (EditText) findViewById(R.id.edFutSek);
        edMetrSek = (EditText) findViewById(R.id.edMetrSek);
        edKmHour = (EditText) findViewById(R.id.edKmHour);
        edUzel = (EditText) findViewById(R.id.edUzel);
        edlspeed = (EditText) findViewById(R.id.edlspeed);

        kmsec = (EditText) findViewById(R.id.kmsec);
        mpsec = (EditText) findViewById(R.id.mpsecc);
        edlspeedsnd = (EditText) findViewById(R.id.edlspeedsnd);

        if (getColor() != getResources().getColor(R.color.colorPrimary)) {

            my_toolbar.setBackgroundColor(getBackgroundColor());
            backColorlayoutAds.setBackgroundColor(getColor());
            bottomColorLayout.setBackgroundColor(getColor());
            corLoyDlinna.setBackgroundColor(getBackgroundColor());

            mph.setTextColor(getTextColor());
            mpsecc.setTextColor(getTextColor());
            fts.setTextColor(getTextColor());
            ms.setTextColor(getTextColor());
            kmh.setTextColor(getTextColor());
            kmsecc.setTextColor(getTextColor());
            knots.setTextColor(getTextColor());
            lightspeed.setTextColor(getTextColor());

            edMilHour.setBackgroundColor(getEditTextActivityColor());
            edMilHour.setTextColor(getEditTextColor());
            edFutSek.setBackgroundColor(getEditTextActivityColor());
            edFutSek.setTextColor(getEditTextColor());
            edMetrSek.setBackgroundColor(getEditTextActivityColor());
            edMetrSek.setTextColor(getEditTextColor());
            edKmHour.setBackgroundColor(getEditTextActivityColor());
            edKmHour.setTextColor(getEditTextColor());
            edUzel.setBackgroundColor(getEditTextActivityColor());
            edUzel.setTextColor(getEditTextColor());
            edlspeed.setBackgroundColor(getEditTextActivityColor());
            edlspeed.setTextColor(getEditTextColor());

            kmsec.setBackgroundColor(getEditTextActivityColor());
            kmsec.setTextColor(getEditTextColor());
            mpsec.setBackgroundColor(getEditTextActivityColor());
            mpsec.setTextColor(getEditTextColor());
            edlspeedsnd.setBackgroundColor(getEditTextActivityColor());
            edlspeedsnd.setTextColor(getEditTextColor());




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


                    edMilHour.setText("");
                    edFutSek.setText("");
                    edMetrSek.setText("");
                    edKmHour.setText("");
                    edUzel.setText("");
                    edlspeed.setText("");
                    kmsec.setText("");
                    mpsec.setText("");
                    edlspeedsnd.setText("");



                    return;
                }

                num = Float.parseFloat(edNum.getText().toString());

                switch (position){
                    case 0:
                        result = (num + 0);
                        edMilHour.setText(String.valueOf(roundUp(result,4)));
                        result = (1.466*num);
                        edFutSek.setText(String.valueOf(roundUp(result, 3)));
                        result = (0.447*num);
                        edMetrSek.setText(String.valueOf(roundUp(result,0)));
                        result = (1.609*num);
                        edKmHour.setText(String.valueOf(roundUp(result,4)));
                        result = (0.868*num);
                        edUzel.setText(String.valueOf(roundUp(result,4)));
                        result = (num/670620000);
                        edlspeed.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.000447);
                        kmsec.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.0002778);
                        mpsec.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.001315);
                        edlspeedsnd.setText(String.valueOf(roundUp(result,4)));

                        break;
                    case 1:
                        result = (0.682*num);
                        edMilHour.setText(String.valueOf(roundUp(result,4)));
                        result = (num + 0);
                        edFutSek.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.305);
                        edMetrSek.setText(String.valueOf(roundUp(result,0)));
                        result = (1.1*num);
                        edKmHour.setText(String.valueOf(roundUp(result,4)));
                        result = (0.6*num);
                        edUzel.setText(String.valueOf(roundUp(result,4)));
                        result = (num/983570000);
                        edlspeed.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.0003048);
                        kmsec.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.0001894);
                        mpsec.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.0008965);
                        edlspeedsnd.setText(String.valueOf(roundUp(result,4)));
                        break;
                    case 2:
                        result = (num *2.237);
                        edMilHour.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 3.28);
                        edFutSek.setText(String.valueOf(roundUp(result,4)));
                        result = (num + 0);
                        edMetrSek.setText(String.valueOf(roundUp(result,0)));
                        result = (num*3.6);
                        edKmHour.setText(String.valueOf(roundUp(result,4)));
                        result = (num*1.95);
                        edUzel.setText(String.valueOf(roundUp(result,4)));
                        result = (num/299790000);
                        edlspeed.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.001);
                        kmsec.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.0006214);
                        mpsec.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.002941);
                        edlspeedsnd.setText(String.valueOf(roundUp(result,4)));
                        break;
                    case 3:
                        result = (num * 0.621);
                        edMilHour.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.911);
                        edFutSek.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.277);
                        edMetrSek.setText(String.valueOf(roundUp(result,0)));
                        result = (num+0);
                        edKmHour.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.54);
                        edUzel.setText(String.valueOf(roundUp(result,4)));
                        result = (num/1079300000);
                        edlspeed.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.0002778);
                        kmsec.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.0001726);
                        mpsec.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.000817);
                        edlspeedsnd.setText(String.valueOf(roundUp(result,4)));
                        break;
                    case 4:
                        result = (num * 1.15);
                        edMilHour.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 1.687);
                        edFutSek.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.514);
                        edMetrSek.setText(String.valueOf(roundUp(result,0)));
                        result = (num*1.852);
                        edKmHour.setText(String.valueOf(roundUp(result,4)));
                        result = (num+0);
                        edUzel.setText(String.valueOf(roundUp(result,4)));
                        result = (num/582750000);
                        edlspeed.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.0005144);
                        kmsec.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.0003197);
                        mpsec.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.001513);
                        edlspeedsnd.setText(String.valueOf(roundUp(result,4)));
                        break;

                    case 5:
                        result = (num * 670620000);
                        edMilHour.setText(String.valueOf(roundUp(result,4)));;
                        result = (num * 983570000);
                        edFutSek.setText(String.valueOf(roundUp(result,4)));;
                        result = (num * 299790000);
                        edMetrSek.setText(String.valueOf(roundUp(result,0)));;
                        result = (num*1079300000);
                        edKmHour.setText(String.valueOf(roundUp(result,4)));;
                        result = (num*582750000);
                        edUzel.setText(String.valueOf(roundUp(result,4)));;
                        result = (num+0);
                        edlspeed.setText(String.valueOf(roundUp(result,4)));;
                        result = (num*299829.54);
                        kmsec.setText(String.valueOf(roundUp(result,4)));
                        result = (num*186298.23);
                        mpsec.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 881.743);
                        edlspeedsnd.setText(String.valueOf(roundUp(result,4)));
                        break;
                    case 6:
                        result = (num * 2237);
                        edMilHour.setText(String.valueOf(roundUp(result,4)));;
                        result = (num * 3281);
                        edFutSek.setText(String.valueOf(roundUp(result,4)));;
                        result = (num * 1000);
                        edMetrSek.setText(String.valueOf(roundUp(result,0)));;
                        result = (num*3600);
                        edKmHour.setText(String.valueOf(roundUp(result,4)));;
                        result = (num*1944);
                        edUzel.setText(String.valueOf(roundUp(result,4)));;
                        result = (num/299805);
                        edlspeed.setText(String.valueOf(roundUp(result,4)));;
                        result = (num+0);
                        kmsec.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.6214);
                        mpsec.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 2.941);
                        edlspeedsnd.setText(String.valueOf(roundUp(result,4)));
                        break;
                    case 7:
                        result = (num * 3600);
                        edMilHour.setText(String.valueOf(roundUp(result,4)));;
                        result = (num * 5280);
                        edFutSek.setText(String.valueOf(roundUp(result,4)));;
                        result = (num * 1609);
                        edMetrSek.setText(String.valueOf(roundUp(result,0)));;
                        result = (num*5794);
                        edKmHour.setText(String.valueOf(roundUp(result,4)));;
                        result = (num*3128);
                        edUzel.setText(String.valueOf(roundUp(result,4)));;
                        result = (num/186298.23);
                        edlspeed.setText(String.valueOf(roundUp(result,4)));;
                        result = (num*1.609);
                        kmsec.setText(String.valueOf(roundUp(result,4)));
                        result = (num+0);
                        mpsec.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 4.733);
                        edlspeedsnd.setText(String.valueOf(roundUp(result,4)));
                        break;
                    case 8:
                        result = (num * 760.6);
                        edMilHour.setText(String.valueOf(roundUp(result,4)));;
                        result = (num * 1115);
                        edFutSek.setText(String.valueOf(roundUp(result,4)));;
                        result = (num * 340);
                        edMetrSek.setText(String.valueOf(roundUp(result,0)));;
                        result = (num*1224);
                        edKmHour.setText(String.valueOf(roundUp(result,4)));;
                        result = (num*660.9);
                        edUzel.setText(String.valueOf(roundUp(result,4)));;
                        result = (num*0.000001134);
                        edlspeed.setText(String.valueOf(roundUp(result,4)));;
                        result = (num*0.34);
                        kmsec.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.2113);
                        mpsec.setText(String.valueOf(roundUp(result,4)));
                        result = (num);
                        edlspeedsnd.setText(String.valueOf(roundUp(result,4)));
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


        double num = 0;
        double result = 0;

        if (TextUtils.isEmpty(edNum.getText().toString())
                ||  (edNum.getText().toString().equals("."))
                ||  (edNum.getText().toString().equals("-"))){

            edMilHour.setText("");
            edFutSek.setText("");
            edMetrSek.setText("");
            edKmHour.setText("");
            edUzel.setText("");
            edlspeed.setText("");
            kmsec.setText("");
            mpsec.setText("");
            edlspeedsnd.setText("");

            return;

        }

        num = Float.parseFloat(edNum.getText().toString());

        switch (a) {
            case 0:
                result = (num + 0);
                edMilHour.setText(String.valueOf(roundUp(result,4)));
                result = (1.466*num);
                edFutSek.setText(String.valueOf(roundUp(result, 3)));
                result = (0.447*num);
                edMetrSek.setText(String.valueOf(roundUp(result,0)));
                result = (1.609*num);
                edKmHour.setText(String.valueOf(roundUp(result,4)));
                result = (0.868*num);
                edUzel.setText(String.valueOf(roundUp(result,4)));
                result = (num/670620000);
                edlspeed.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.000447);
                kmsec.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.0002778);
                mpsec.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.001315);
                edlspeedsnd.setText(String.valueOf(roundUp(result,4)));

                break;
            case 1:
                result = (0.682*num);
                edMilHour.setText(String.valueOf(roundUp(result,4)));
                result = (num + 0);
                edFutSek.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.305);
                edMetrSek.setText(String.valueOf(roundUp(result,0)));
                result = (1.1*num);
                edKmHour.setText(String.valueOf(roundUp(result,4)));
                result = (0.6*num);
                edUzel.setText(String.valueOf(roundUp(result,4)));
                result = (num/983570000);
                edlspeed.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.0003048);
                kmsec.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.0001894);
                mpsec.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.0008965);
                edlspeedsnd.setText(String.valueOf(roundUp(result,4)));
                break;
            case 2:
                result = (num *2.237);
                edMilHour.setText(String.valueOf(roundUp(result,4)));
                result = (num * 3.28);
                edFutSek.setText(String.valueOf(roundUp(result,4)));
                result = (num + 0);
                edMetrSek.setText(String.valueOf(roundUp(result,0)));
                result = (num*3.6);
                edKmHour.setText(String.valueOf(roundUp(result,4)));
                result = (num*1.95);
                edUzel.setText(String.valueOf(roundUp(result,4)));
                result = (num/299790000);
                edlspeed.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.001);
                kmsec.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.0006214);
                mpsec.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.002941);
                edlspeedsnd.setText(String.valueOf(roundUp(result,4)));
                break;
            case 3:
                result = (num * 0.621);
                edMilHour.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.911);
                edFutSek.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.277);
                edMetrSek.setText(String.valueOf(roundUp(result,0)));
                result = (num+0);
                edKmHour.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.54);
                edUzel.setText(String.valueOf(roundUp(result,4)));
                result = (num/1079300000);
                edlspeed.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.0002778);
                kmsec.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.0001726);
                mpsec.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.000817);
                edlspeedsnd.setText(String.valueOf(roundUp(result,4)));
                break;
            case 4:
                result = (num * 1.15);
                edMilHour.setText(String.valueOf(roundUp(result,4)));
                result = (num * 1.687);
                edFutSek.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.514);
                edMetrSek.setText(String.valueOf(roundUp(result,0)));
                result = (num*1.852);
                edKmHour.setText(String.valueOf(roundUp(result,4)));
                result = (num+0);
                edUzel.setText(String.valueOf(roundUp(result,4)));
                result = (num/582750000);
                edlspeed.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.0005144);
                kmsec.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.0003197);
                mpsec.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.001513);
                edlspeedsnd.setText(String.valueOf(roundUp(result,4)));
                break;

            case 5:
                result = (num * 670620000);
                edMilHour.setText(String.valueOf(roundUp(result,4)));;
                result = (num * 983570000);
                edFutSek.setText(String.valueOf(roundUp(result,4)));;
                result = (num * 299790000);
                edMetrSek.setText(String.valueOf(roundUp(result,0)));;
                result = (num*1079300000);
                edKmHour.setText(String.valueOf(roundUp(result,4)));;
                result = (num*582750000);
                edUzel.setText(String.valueOf(roundUp(result,4)));;
                result = (num+0);
                edlspeed.setText(String.valueOf(roundUp(result,4)));;
                result = (num*299829.54);
                kmsec.setText(String.valueOf(roundUp(result,4)));
                result = (num*186298.23);
                mpsec.setText(String.valueOf(roundUp(result,4)));
                result = (num * 881.743);
                edlspeedsnd.setText(String.valueOf(roundUp(result,4)));
                break;
            case 6:
                result = (num * 2237);
                edMilHour.setText(String.valueOf(roundUp(result,4)));;
                result = (num * 3281);
                edFutSek.setText(String.valueOf(roundUp(result,4)));;
                result = (num * 1000);
                edMetrSek.setText(String.valueOf(roundUp(result,0)));;
                result = (num*3600);
                edKmHour.setText(String.valueOf(roundUp(result,4)));;
                result = (num*1944);
                edUzel.setText(String.valueOf(roundUp(result,4)));;
                result = (num/299805);
                edlspeed.setText(String.valueOf(roundUp(result,4)));;
                result = (num+0);
                kmsec.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.6214);
                mpsec.setText(String.valueOf(roundUp(result,4)));
                result = (num * 2.941);
                edlspeedsnd.setText(String.valueOf(roundUp(result,4)));
                break;
            case 7:
                result = (num * 3600);
                edMilHour.setText(String.valueOf(roundUp(result,4)));;
                result = (num * 5280);
                edFutSek.setText(String.valueOf(roundUp(result,4)));;
                result = (num * 1609);
                edMetrSek.setText(String.valueOf(roundUp(result,0)));;
                result = (num*5794);
                edKmHour.setText(String.valueOf(roundUp(result,4)));;
                result = (num*3128);
                edUzel.setText(String.valueOf(roundUp(result,4)));;
                result = (num/186298.23);
                edlspeed.setText(String.valueOf(roundUp(result,4)));;
                result = (num*1.609);
                kmsec.setText(String.valueOf(roundUp(result,4)));
                result = (num+0);
                mpsec.setText(String.valueOf(roundUp(result,4)));
                result = (num * 4.733);
                edlspeedsnd.setText(String.valueOf(roundUp(result,4)));
                break;
            case 8:
                result = (num * 760.6);
                edMilHour.setText(String.valueOf(roundUp(result,4)));;
                result = (num * 1115);
                edFutSek.setText(String.valueOf(roundUp(result,4)));;
                result = (num * 340);
                edMetrSek.setText(String.valueOf(roundUp(result,0)));;
                result = (num*1224);
                edKmHour.setText(String.valueOf(roundUp(result,4)));;
                result = (num*660.9);
                edUzel.setText(String.valueOf(roundUp(result,4)));;
                result = (num*0.000001134);
                edlspeed.setText(String.valueOf(roundUp(result,4)));;
                result = (num*0.34);
                kmsec.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.2113);
                mpsec.setText(String.valueOf(roundUp(result,4)));
                result = (num);
                edlspeedsnd.setText(String.valueOf(roundUp(result,4)));
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

