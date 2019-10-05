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

public class TimeActivity extends AppCompatActivity implements TextWatcher{

   // String[] data = {"Век (age)", "Год григорианский (Gr Year)", "Год юлианский (JD)", "Календарный месяц (month)", "Неделя (week)", "Сутки (day)", "Час (h)", "Минута (min)", "Cекунда (sec)"};
    int a;
    Spinner spMassa;
    EditText edNum, edAge, edGy,edJD,edMonth,edWeek,edDay,edHour,edMin,edSec;
  //  TextView tvPosName;

    public BigDecimal roundUp(double value, int digits) {
        return new BigDecimal("" + value).setScale(digits, BigDecimal.ROUND_HALF_UP);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.time);

        Toolbar my_toolbar = (Toolbar) findViewById(R.id.my_toolbar_app);
        RelativeLayout backColorlayoutAds = (RelativeLayout) findViewById(R.id.reLayoutTimeAds);
        CollapsingToolbarLayout bottomColorLayout = (CollapsingToolbarLayout) findViewById(R.id.TimeBottomLayout);
        CoordinatorLayout corLoyDlinna = (CoordinatorLayout) findViewById(R.id.corLoyoutTime);
        setSupportActionBar(my_toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, //data);
       // adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            getResources().getStringArray(R.array.Time));


        spMassa = (Spinner) findViewById(R.id.spMassa);
        spMassa.setAdapter(adapter);


        edNum = (EditText) findViewById(R.id.edNum);
    //    tvPosName = (TextView) findViewById(R.id.tvPosName);

        TextView Nm = (TextView) findViewById(R.id.Age);
        TextView Km = (TextView) findViewById(R.id.Gy);
        TextView Mile = (TextView) findViewById(R.id.JD);
        TextView m = (TextView) findViewById(R.id.Month);
        TextView yard = (TextView) findViewById(R.id.Week);
        TextView ozff = (TextView) findViewById(R.id.Day);
        TextView pdll = (TextView) findViewById(R.id.Hour);
        TextView kgff = (TextView) findViewById(R.id.Min);
        TextView gff = (TextView) findViewById(R.id.Sec);



        edAge = (EditText) findViewById(R.id.edAge);
        edGy = (EditText) findViewById(R.id.edGy);
        edJD = (EditText) findViewById(R.id.edJD);
        edMonth = (EditText) findViewById(R.id.edMonth);
        edWeek = (EditText) findViewById(R.id.edWeek);
        edDay = (EditText) findViewById(R.id.edDay);
        edHour = (EditText) findViewById(R.id.edHour);
        edMin = (EditText) findViewById(R.id.edMin);
        edSec = (EditText) findViewById(R.id.edSec);

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
            gff.setTextColor(getTextColor());


            edAge.setBackgroundColor(getEditTextActivityColor());
            edAge.setTextColor(getEditTextColor());
            edGy.setBackgroundColor(getEditTextActivityColor());
            edGy.setTextColor(getEditTextColor());
            edJD.setBackgroundColor(getEditTextActivityColor());
            edJD.setTextColor(getEditTextColor());
            edMonth.setBackgroundColor(getEditTextActivityColor());
            edMonth.setTextColor(getEditTextColor());
            edWeek.setBackgroundColor(getEditTextActivityColor());
            edWeek.setTextColor(getEditTextColor());

            edDay.setBackgroundColor(getEditTextActivityColor());
            edDay.setTextColor(getEditTextColor());
            edHour.setBackgroundColor(getEditTextActivityColor());
            edHour.setTextColor(getEditTextColor());
            edMin.setBackgroundColor(getEditTextActivityColor());
            edMin.setTextColor(getEditTextColor());
            edSec.setBackgroundColor(getEditTextActivityColor());
            edSec.setTextColor(getEditTextColor());


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
            //    tvPosName.setText(strName);
                a = position;

                double result = 0;
                double num = 0;

                if (TextUtils.isEmpty(edNum.getText().toString())
                        ||  (edNum.getText().toString().equals("."))
                        ||  (edNum.getText().toString().equals("-"))){

                    edAge.setText("");
                    edGy.setText("");
                    edJD.setText("");
                    edMonth.setText("");
                    edWeek.setText("");
                    edDay.setText("");
                    edHour.setText("");
                    edMin.setText("");
                    edSec.setText("");


                    return;
                }

                num = Double.parseDouble(edNum.getText().toString());

                switch (position){
                    case 0:
                        result = (num + 0);
                        edAge.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 100);
                        edGy.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 100);
                        edJD.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 1200);
                        edMonth.setText(String.valueOf(roundUp(result,4)));
                        result = (num* 5218);
                        edWeek.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 36520);
                        edDay.setText(String.valueOf(roundUp(result,4)));
                        result = (num* 876600);
                        edHour.setText(String.valueOf(roundUp(result,4)));
                        result = (num* 52590000);
                        edMin.setText(String.valueOf(roundUp(result,4)));
                        result = (num*3.156e+9);
                        edSec.setText(String.valueOf(roundUp(result,4)));
                        break;
                    case 1:
                        result = (num *0.01);
                        edAge.setText(String.valueOf(roundUp(result,4)));
                        result = (num + 0);
                        edGy.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 1);
                        edJD.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 12);
                        edMonth.setText(String.valueOf(roundUp(result,4)));
                        result = (num* 52.18);
                        edWeek.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 365.2);
                        edDay.setText(String.valueOf(roundUp(result,4)));
                        result = (num* 8766);
                        edHour.setText(String.valueOf(roundUp(result,4)));
                        result = (num* 525900);
                        edMin.setText(String.valueOf(roundUp(result,4)));
                        result = (num*31554000);
                        edSec.setText(String.valueOf(roundUp(result,4)));
                        break;
                    case 2:
                        result = (num *0.01);
                        edAge.setText(String.valueOf(roundUp(result,4)));
                        result = (num + 0);
                        edGy.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 1);
                        edJD.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 12);
                        edMonth.setText(String.valueOf(roundUp(result,4)));
                        result = (num* 52.18);
                        edWeek.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 365.3);
                        edDay.setText(String.valueOf(roundUp(result,4)));
                        result = (num* 8766);
                        edHour.setText(String.valueOf(roundUp(result,4)));
                        result = (num* 526000);
                        edMin.setText(String.valueOf(roundUp(result,4)));
                        result = (num*31560000);
                        edSec.setText(String.valueOf(roundUp(result,4)));
                        break;

                    case 3:
                        result = (num *0.0008333);
                        edAge.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.08333);
                        edGy.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.08333);
                        edJD.setText(String.valueOf(roundUp(result,4)));
                        result = (num + 0);
                        edMonth.setText(String.valueOf(roundUp(result,4)));
                        result = (num* 4.348);
                        edWeek.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 30.44);
                        edDay.setText(String.valueOf(roundUp(result,4)));
                        result = (num* 730.5);
                        edHour.setText(String.valueOf(roundUp(result,4)));
                        result = (num* 43830);
                        edMin.setText(String.valueOf(roundUp(result,4)));
                        result = (num*2630000);
                        edSec.setText(String.valueOf(roundUp(result,4)));
                        break;
                    case 4:
                        result = (num*0.0001917);
                        edAge.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.01917);
                        edGy.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.01916);
                        edJD.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.23);
                        edMonth.setText(String.valueOf(roundUp(result,4)));
                        result = (num+0);
                        edWeek.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 7);
                        edDay.setText(String.valueOf(roundUp(result,4)));
                        result = (num* 168);
                        edHour.setText(String.valueOf(roundUp(result,4)));
                        result = (num* 10080);
                        edMin.setText(String.valueOf(roundUp(result,4)));
                        result = (num*604800);
                        edSec.setText(String.valueOf(roundUp(result,4)));
                        break;

                    case 5:
                        result = (num*0.00002738);
                        edAge.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.002738);
                        edGy.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.002738);
                        edJD.setText(String.valueOf(roundUp(result,4)));
                        result = (num *0.03285);
                        edMonth.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.1429);
                        edWeek.setText(String.valueOf(roundUp(result,4)));
                        result = (num + 0);
                        edDay.setText(String.valueOf(roundUp(result,4)));
                        result = (num* 24);
                        edHour.setText(String.valueOf(roundUp(result,4)));
                        result = (num* 1440);
                        edMin.setText(String.valueOf(roundUp(result,4)));
                        result = (num*86400);
                        edSec.setText(String.valueOf(roundUp(result,4)));
                        break;
                    case 6:
                        result = (num*0.000001141);
                        edAge.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.0001141);
                        edGy.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.0001141);
                        edJD.setText(String.valueOf(roundUp(result,4)));
                        result = (num *0.001369);
                        edMonth.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.005952);
                        edWeek.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.04167);
                        edDay.setText(String.valueOf(roundUp(result,4)));
                        result = (num+0);
                        edHour.setText(String.valueOf(roundUp(result,4)));
                        result = (num* 60);
                        edMin.setText(String.valueOf(roundUp(result,4)));
                        result = (num*3600);
                        edSec.setText(String.valueOf(roundUp(result,4)));
                        break;
                    case 7:

                        result = (num*0.00000001901);
                        edAge.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.000001901);
                        edGy.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.000001901);
                        edJD.setText(String.valueOf(roundUp(result,4)));
                        result = (num *0.00002282);
                        edMonth.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.00009921);
                        edWeek.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.0006944);
                        edDay.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.01667);
                        edHour.setText(String.valueOf(roundUp(result,4)));
                        result = (num+0);
                        edMin.setText(String.valueOf(roundUp(result,4)));
                        result = (num*60);
                        edSec.setText(String.valueOf(roundUp(result,4)));
                        break;

                    case 8:
                        result = (num*0.0000000003169);
                        edAge.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.00000003169);
                        edGy.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.00000003169);
                        edJD.setText(String.valueOf(roundUp(result,4)));
                        result = (num *0.0000003803);
                        edMonth.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.000001653);
                        edWeek.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.00001157);
                        edDay.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.0002778);
                        edHour.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.01667);
                        edMin.setText(String.valueOf(roundUp(result,4)));
                        result = (num+0);
                        edSec.setText(String.valueOf(roundUp(result,4)));
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

            edAge.setText("");
            edGy.setText("");
            edJD.setText("");
            edMonth.setText("");
            edWeek.setText("");
            edDay.setText("");
            edHour.setText("");
            edMin.setText("");
            edSec.setText("");


            return;
        }

        num = Double.parseDouble(edNum.getText().toString());

        switch (a){
            case 0:
                result = (num + 0);
                edAge.setText(String.valueOf(roundUp(result,4)));
                result = (num * 100);
                edGy.setText(String.valueOf(roundUp(result,4)));
                result = (num * 100);
                edJD.setText(String.valueOf(roundUp(result,4)));
                result = (num * 1200);
                edMonth.setText(String.valueOf(roundUp(result,4)));
                result = (num* 5218);
                edWeek.setText(String.valueOf(roundUp(result,4)));
                result = (num * 36520);
                edDay.setText(String.valueOf(roundUp(result,4)));
                result = (num* 876600);
                edHour.setText(String.valueOf(roundUp(result,4)));
                result = (num* 52590000);
                edMin.setText(String.valueOf(roundUp(result,4)));
                result = (num*3.156e+9);
                edSec.setText(String.valueOf(roundUp(result,4)));
                break;

            case 1:
                result = (num *0.01);
                edAge.setText(String.valueOf(roundUp(result,4)));
                result = (num + 0);
                edGy.setText(String.valueOf(roundUp(result,4)));
                result = (num * 1);
                edJD.setText(String.valueOf(roundUp(result,4)));
                result = (num * 12);
                edMonth.setText(String.valueOf(roundUp(result,4)));
                result = (num* 52.18);
                edWeek.setText(String.valueOf(roundUp(result,4)));
                result = (num * 365.2);
                edDay.setText(String.valueOf(roundUp(result,4)));
                result = (num* 8766);
                edHour.setText(String.valueOf(roundUp(result,4)));
                result = (num* 525900);
                edMin.setText(String.valueOf(roundUp(result,4)));
                result = (num*31554000);
                edSec.setText(String.valueOf(roundUp(result,4)));
                break;
            case 2:
                result = (num *0.01);
                edAge.setText(String.valueOf(roundUp(result,4)));
                result = (num + 0);
                edGy.setText(String.valueOf(roundUp(result,4)));
                result = (num * 1);
                edJD.setText(String.valueOf(roundUp(result,4)));
                result = (num * 12);
                edMonth.setText(String.valueOf(roundUp(result,4)));
                result = (num* 52.18);
                edWeek.setText(String.valueOf(roundUp(result,4)));
                result = (num * 365.2);
                edDay.setText(String.valueOf(roundUp(result,4)));
                result = (num* 8766);
                edHour.setText(String.valueOf(roundUp(result,4)));
                result = (num* 525900);
                edMin.setText(String.valueOf(roundUp(result,4)));
                result = (num*31560000);
                edSec.setText(String.valueOf(roundUp(result,4)));
                break;

            case 3:
                result = (num *0.0008333);
                edAge.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.08333);
                edGy.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.08333);
                edJD.setText(String.valueOf(roundUp(result,4)));
                result = (num + 0);
                edMonth.setText(String.valueOf(roundUp(result,4)));
                result = (num* 4.348);
                edWeek.setText(String.valueOf(roundUp(result,4)));
                result = (num * 30.44);
                edDay.setText(String.valueOf(roundUp(result,4)));
                result = (num* 730.5);
                edHour.setText(String.valueOf(roundUp(result,4)));
                result = (num* 43830);
                edMin.setText(String.valueOf(roundUp(result,4)));
                result = (num*2630000);
                edSec.setText(String.valueOf(roundUp(result,4)));

                break;
            case 4:
                result = (num*0.0001917);
                edAge.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.01917);
                edGy.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.01916);
                edJD.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.23);
                edMonth.setText(String.valueOf(roundUp(result,4)));
                result = (num+0);
                edWeek.setText(String.valueOf(roundUp(result,4)));
                result = (num * 7);
                edDay.setText(String.valueOf(roundUp(result,4)));
                result = (num* 168);
                edHour.setText(String.valueOf(roundUp(result,4)));
                result = (num* 10080);
                edMin.setText(String.valueOf(roundUp(result,4)));
                result = (num*604800);
                edSec.setText(String.valueOf(roundUp(result,4)));
                break;

            case 5:
                result = (num*0.00002738);
                edAge.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.002738);
                edGy.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.002738);
                edJD.setText(String.valueOf(roundUp(result,4)));
                result = (num *0.03285);
                edMonth.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.1429);
                edWeek.setText(String.valueOf(roundUp(result,4)));
                result = (num + 0);
                edDay.setText(String.valueOf(roundUp(result,4)));
                result = (num* 24);
                edHour.setText(String.valueOf(roundUp(result,4)));
                result = (num* 1440);
                edMin.setText(String.valueOf(roundUp(result,4)));
                result = (num*86400);
                edSec.setText(String.valueOf(roundUp(result,4)));

                break;

            case 6:

                result = (num*0.000001141);
                edAge.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.0001141);
                edGy.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.0001141);
                edJD.setText(String.valueOf(roundUp(result,4)));
                result = (num *0.001369);
                edMonth.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.005952);
                edWeek.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.04167);
                edDay.setText(String.valueOf(roundUp(result,4)));
                result = (num+0);
                edHour.setText(String.valueOf(roundUp(result,4)));
                result = (num* 60);
                edMin.setText(String.valueOf(roundUp(result,4)));
                result = (num*3600);
                edSec.setText(String.valueOf(roundUp(result,4)));
                break;
            case 7:

                result = (num*0.00000001901);
                edAge.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.000001901);
                edGy.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.000001901);
                edJD.setText(String.valueOf(roundUp(result,4)));
                result = (num *0.00002282);
                edMonth.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.00009921);
                edWeek.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.0006944);
                edDay.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.01667);
                edHour.setText(String.valueOf(roundUp(result,4)));
                result = (num+0);
                edMin.setText(String.valueOf(roundUp(result,4)));
                result = (num*60);
                edSec.setText(String.valueOf(roundUp(result,4)));
                break;
            case 8:
                result = (num*0.0000000003169);
                edAge.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.00000003169);
                edGy.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.00000003169);
                edJD.setText(String.valueOf(roundUp(result,4)));
                result = (num *0.0000003803);
                edMonth.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.000001653);
                edWeek.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.00001157);
                edDay.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.0002778);
                edHour.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.01667);
                edMin.setText(String.valueOf(roundUp(result,4)));
                result = (num+0);
                edSec.setText(String.valueOf(roundUp(result,4)));
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


