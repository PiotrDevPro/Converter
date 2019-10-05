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

public class YgolActivity extends AppCompatActivity implements TextWatcher {

   // String[] data = {"Окружность (circle)", "Секстант (60°)", "Радиан (rad)", "Градус (deg)", "Град (grad)", "Минута (')", "Секунда ('')"};
    int a;
    Spinner spMassa;
    EditText edNum, edCircle, edSecs, edRad, edDeg, edGrad, edMin, edSec;
  //  TextView tvPosName;

    public BigDecimal roundUp(double value, int digits) {
        return new BigDecimal("" + value).setScale(digits, BigDecimal.ROUND_HALF_UP);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ygol);

        Toolbar my_toolbar = (Toolbar) findViewById(R.id.my_toolbar_app);
        RelativeLayout backColorlayoutAds = (RelativeLayout) findViewById(R.id.reLayoutYgolAds);
        CollapsingToolbarLayout bottomColorLayout = (CollapsingToolbarLayout) findViewById(R.id.YgollottomLayout);
        CoordinatorLayout corLoyDlinna = (CoordinatorLayout) findViewById(R.id.corLoyoutYgol);
        setSupportActionBar(my_toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, //data);
        //adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            getResources().getStringArray(R.array.ygol));

        spMassa = (Spinner) findViewById(R.id.spMassa);
        spMassa.setAdapter(adapter);

        TextView Nm = (TextView) findViewById(R.id.circle);
        TextView Km = (TextView) findViewById(R.id.ygol60);
        TextView Mile = (TextView) findViewById(R.id.rad);
        TextView m = (TextView) findViewById(R.id.deg);
        TextView yard = (TextView)  findViewById(R.id.grad);
        TextView ft = (TextView)  findViewById(R.id.min);
        TextView In = (TextView)  findViewById(R.id.sec);


        edNum = (EditText) findViewById(R.id.edNum);
      //  tvPosName = (TextView) findViewById(R.id.tvPosName);




        edCircle = (EditText) findViewById(R.id.edCircle);
        edSecs = (EditText) findViewById(R.id.edSecs);
        edRad = (EditText) findViewById(R.id.edRad);
        edDeg = (EditText) findViewById(R.id.edDeg);
        edGrad = (EditText) findViewById(R.id.edGrad);
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
            ft.setTextColor(getTextColor());
            In.setTextColor(getTextColor());



            edCircle.setBackgroundColor(getEditTextActivityColor());
            edCircle.setTextColor(getEditTextColor());
            edSecs.setBackgroundColor(getEditTextActivityColor());
            edSecs.setTextColor(getEditTextColor());
            edRad.setBackgroundColor(getEditTextActivityColor());
            edRad.setTextColor(getEditTextColor());
            edDeg.setBackgroundColor(getEditTextActivityColor());
            edDeg.setTextColor(getEditTextColor());
            edGrad.setBackgroundColor(getEditTextActivityColor());
            edGrad.setTextColor(getEditTextColor());
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

        spMassa.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                String strName = spMassa.getSelectedItem().toString();
               // tvPosName.setText(strName);
                a = position;

                double result = 0;
                double num = 0;

                if (TextUtils.isEmpty(edNum.getText().toString())
                        ||  (edNum.getText().toString().equals("."))
                        ||  (edNum.getText().toString().equals("-"))){


                    edCircle.setText("");
                    edSecs.setText("");
                    edRad.setText("");
                    edDeg.setText("");
                    edGrad.setText("");
                    edMin.setText("");
                    edSec.setText("");

                    return;

                }

                num = Float.parseFloat(edNum.getText().toString());

                switch (position) {
                    case 0:
                        result = (num + 0);
                        edCircle.setText(String.valueOf(roundUp(result,4)));;
                        result = (num * 6);
                        edSecs.setText(String.valueOf(roundUp(result,4)));;
                        result = (num * 6.283);
                        edRad.setText(String.valueOf(roundUp(result,4)));;
                        result = (num * 360);
                        edDeg.setText(String.valueOf(roundUp(result,4)));;
                        result = (num * 400);
                        edGrad.setText(String.valueOf(roundUp(result,4)));;
                        result = (num * 21600);
                        edMin.setText(String.valueOf(roundUp(result,4)));;
                        result = (num * 1296000);
                        edSec.setText(String.valueOf(roundUp(result,4)));;
                        break;

                    case 1:
                        result = (num * 0.1667);
                        edCircle.setText(String.valueOf(roundUp(result,4)));;
                        result = (num + 0);
                        edSecs.setText(String.valueOf(roundUp(result,4)));;
                        result = (num * 1.047);
                        edRad.setText(String.valueOf(roundUp(result,4)));;
                        result = (num * 60);
                        edDeg.setText(String.valueOf(roundUp(result,4)));;
                        result = (num * 66.67);
                        edGrad.setText(String.valueOf(roundUp(result,4)));;
                        result = (num * 3600);
                        edMin.setText(String.valueOf(roundUp(result,4)));;
                        result = (num * 216000);
                        edSec.setText(String.valueOf(roundUp(result,4)));;
                        break;

                    case 2:
                        result = (num * 0.1592);
                        edCircle.setText(String.valueOf(roundUp(result,4)));;
                        result = (num * 0.9549);
                        edSecs.setText(String.valueOf(roundUp(result,4)));;
                        result = (num + 0);
                        edRad.setText(String.valueOf(roundUp(result,4)));;
                        result = (num * 57.3);
                        edDeg.setText(String.valueOf(roundUp(result,4)));;
                        result = (num * 63.66);
                        edGrad.setText(String.valueOf(roundUp(result,4)));;
                        result = (num * 3438);
                        edMin.setText(String.valueOf(roundUp(result,4)));;
                        result = (num * 206300);
                        edSec.setText(String.valueOf(roundUp(result,4)));;
                        break;

                    case 3:
                        result = (num * 0.00278);
                        edCircle.setText(String.valueOf(roundUp(result,4)));;
                        result = (num * 0.0167);
                        edSecs.setText(String.valueOf(roundUp(result,4)));;
                        result = (num * 0.01745);
                        edRad.setText(String.valueOf(roundUp(result,4)));;
                        result = (num + 0);
                        edDeg.setText(String.valueOf(roundUp(result,4)));;
                        result = (num * 1.11);
                        edGrad.setText(String.valueOf(roundUp(result,4)));;
                        result = (num * 60);
                        edMin.setText(String.valueOf(roundUp(result,4)));;
                        result = (num * 3600);
                        edSec.setText(String.valueOf(roundUp(result,4)));;
                        break;

                    case 4:
                        result = (num * 0.0025);
                        edCircle.setText(String.valueOf(roundUp(result,4)));;
                        result = (num * 0.015);
                        edSecs.setText(String.valueOf(roundUp(result,4)));;
                        result = (num * 0.0157);
                        edRad.setText(String.valueOf(roundUp(result,4)));;
                        result = (num * 0.9);
                        edDeg.setText(String.valueOf(roundUp(result,4)));;
                        result = (num + 0);
                        edGrad.setText(String.valueOf(roundUp(result,4)));;
                        result = (num * 54);
                        edMin.setText(String.valueOf(roundUp(result,4)));;
                        result = (num * 3240);
                        edSec.setText(String.valueOf(roundUp(result,4)));;
                        break;

                    case 5:
                        result = (num * 0.000046);
                        edCircle.setText(String.valueOf(roundUp(result,4)));;
                        result = (num * 0.000278);
                        edSecs.setText(String.valueOf(roundUp(result,4)));;
                        result = (num * 0.000291);
                        edRad.setText(String.valueOf(roundUp(result,4)));;
                        result = (num * 0.0167);
                        edDeg.setText(String.valueOf(roundUp(result,4)));;
                        result = (num * 0.0185);
                        edGrad.setText(String.valueOf(roundUp(result,4)));;
                        result = (num + 0);
                        edMin.setText(String.valueOf(roundUp(result,4)));;
                        result = (num * 60);
                        edSec.setText(String.valueOf(roundUp(result,4)));;
                        break;

                    case 6:

                        result = (num * 0.00000077);
                        edCircle.setText(String.valueOf(roundUp(result,4)));;
                        result = (num * 0.0000046);
                        edSecs.setText(String.valueOf(roundUp(result,4)));;
                        result = (num * 0.00000485);
                        edRad.setText(String.valueOf(roundUp(result,4)));;
                        result = (num * 0.000278);
                        edDeg.setText(String.valueOf(roundUp(result,4)));;
                        result = (num * 0.00031);
                        edGrad.setText(String.valueOf(roundUp(result,4)));;
                        result = (num * 0.0167);
                        edMin.setText(String.valueOf(roundUp(result,4)));;
                        result = (num + 0);
                        edSec.setText(String.valueOf(roundUp(result,4)));;
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


            edCircle.setText("");
            edSecs.setText("");
            edRad.setText("");
            edDeg.setText("");
            edGrad.setText("");
            edMin.setText("");
            edSec.setText("");

            return;
        }
        num = Float.parseFloat(edNum.getText().toString());
        {
            switch (a) {

                case 0:
                    result = (num + 0);
                    edCircle.setText(String.valueOf(roundUp(result,4)));;
                    result = (num * 6);
                    edSecs.setText(String.valueOf(roundUp(result,4)));;
                    result = (num * 6.283);
                    edRad.setText(String.valueOf(roundUp(result,4)));;
                    result = (num * 360);
                    edDeg.setText(String.valueOf(roundUp(result,4)));;
                    result = (num * 400);
                    edGrad.setText(String.valueOf(roundUp(result,4)));;
                    result = (num * 21600);
                    edMin.setText(String.valueOf(roundUp(result,4)));;
                    result = (num * 1296000);
                    edSec.setText(String.valueOf(roundUp(result,4)));;

                    break;

                case 1:
                    result = (num * 0.1667);
                    edCircle.setText(String.valueOf(roundUp(result,4)));;
                    result = (num + 0);
                    edSecs.setText(String.valueOf(roundUp(result,4)));;
                    result = (num * 1.047);
                    edRad.setText(String.valueOf(roundUp(result,4)));;
                    result = (num * 60);
                    edDeg.setText(String.valueOf(roundUp(result,4)));;
                    result = (num * 66.67);
                    edGrad.setText(String.valueOf(roundUp(result,4)));;
                    result = (num * 3600);
                    edMin.setText(String.valueOf(roundUp(result,4)));;
                    result = (num * 216000);
                    edSec.setText(String.valueOf(roundUp(result,4)));;

                    break;

                case 2:
                    result = (num * 0.1592);
                    edCircle.setText(String.valueOf(roundUp(result,4)));;
                    result = (num * 0.9549);
                    edSecs.setText(String.valueOf(roundUp(result,4)));;
                    result = (num + 0);
                    edRad.setText(String.valueOf(roundUp(result,4)));;
                    result = (num * 57.3);
                    edDeg.setText(String.valueOf(roundUp(result,4)));;
                    result = (num * 63.66);
                    edGrad.setText(String.valueOf(roundUp(result,4)));;
                    result = (num * 3438);
                    edMin.setText(String.valueOf(roundUp(result,4)));;
                    result = (num * 206300);
                    edSec.setText(String.valueOf(roundUp(result,4)));;

                    break;

                case 3:
                    result = (num * 0.00278);
                    edCircle.setText(String.valueOf(roundUp(result,4)));;
                    result = (num * 0.0167);
                    edSecs.setText(String.valueOf(roundUp(result,4)));;
                    result = (num * 0.01745);
                    edRad.setText(String.valueOf(roundUp(result,4)));;
                    result = (num + 0);
                    edDeg.setText(String.valueOf(roundUp(result,4)));;
                    result = (num * 1.11);
                    edGrad.setText(String.valueOf(roundUp(result,4)));;
                    result = (num * 60);
                    edMin.setText(String.valueOf(roundUp(result,4)));;
                    result = (num * 3600);
                    edSec.setText(String.valueOf(roundUp(result,4)));;

                    break;

                case 4:
                    result = (num * 0.0025);
                    edCircle.setText(String.valueOf(roundUp(result,4)));;
                    result = (num * 0.015);
                    edSecs.setText(String.valueOf(roundUp(result,4)));;
                    result = (num * 0.0157);
                    edRad.setText(String.valueOf(roundUp(result,4)));;
                    result = (num * 0.9);
                    edDeg.setText(String.valueOf(roundUp(result,4)));;
                    result = (num + 0);
                    edGrad.setText(String.valueOf(roundUp(result,4)));;
                    result = (num * 54);
                    edMin.setText(String.valueOf(roundUp(result,4)));;
                    result = (num * 3240);
                    edSec.setText(String.valueOf(roundUp(result,4)));;

                    break;

                case 5:
                    result = (num * 0.000046);
                    edCircle.setText(String.valueOf(roundUp(result,4)));;
                    result = (num * 0.000278);
                    edSecs.setText(String.valueOf(roundUp(result,4)));;
                    result = (num * 0.000291);
                    edRad.setText(String.valueOf(roundUp(result,4)));;
                    result = (num * 0.0167);
                    edDeg.setText(String.valueOf(roundUp(result,4)));;
                    result = (num * 0.0185);
                    edGrad.setText(String.valueOf(roundUp(result,4)));;
                    result = (num + 0);
                    edMin.setText(String.valueOf(roundUp(result,4)));;
                    result = (num * 60);
                    edSec.setText(String.valueOf(roundUp(result,4)));;

                    break;

                case 6:

                    result = (num * 0.00000077);
                    edCircle.setText(String.valueOf(roundUp(result,4)));;
                    result = (num * 0.0000046);
                    edSecs.setText(String.valueOf(roundUp(result,4)));;
                    result = (num * 0.00000485);
                    edRad.setText(String.valueOf(roundUp(result,4)));;
                    result = (num * 0.000278);
                    edDeg.setText(String.valueOf(roundUp(result,4)));;
                    result = (num * 0.00031);
                    edGrad.setText(String.valueOf(roundUp(result,4)));;
                    result = (num * 0.0167);
                    edMin.setText(String.valueOf(roundUp(result,4)));;
                    result = (num + 0);
                    edSec.setText(String.valueOf(roundUp(result,4)));;

                    break;

            }

        }
    }

    @Override
    public void afterTextChanged (Editable s){

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


