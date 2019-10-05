package com.piotrdevelop.unityconverter;

import android.content.SharedPreferences;
import android.graphics.Typeface;
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
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.math.BigDecimal;

public class SkidkiActivity extends AppCompatActivity implements TextWatcher, View.OnClickListener{

    Button myBtnClear;
    EditText edNum, edPerc, edResult,edResult2;
    TextView tv1,tv2,tv3;

    public BigDecimal roundUp(double value, int digits){
        return new BigDecimal(""+value).setScale(digits, BigDecimal.ROUND_HALF_UP);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.skidki);

        Toolbar my_toolbar = (Toolbar) findViewById(R.id.my_toolbar_app);
        LinearLayout LoyoutMainProc = (LinearLayout) findViewById(R.id.LoyoutMainSkidki);
        CollapsingToolbarLayout bottomColorLayout = (CollapsingToolbarLayout) findViewById(R.id.SkidkiBottomLayout);
        CoordinatorLayout corLoyDlinna = (CoordinatorLayout) findViewById(R.id.corLoyoutSkidki);
        setSupportActionBar(my_toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        Typeface myTypeface3 = Typeface.createFromAsset(getAssets(), "HelveticaNeueCyr-LightItalic.otf");
        Typeface myTypeface4 = Typeface.createFromAsset(getAssets(), "HelveticaNeueCyr-Italic.otf");

        myBtnClear = (Button) findViewById(R.id.myBtnClear);

        edNum = (EditText) findViewById(R.id.edNum);
        edPerc = (EditText) findViewById(R.id.edPerc);
        edResult = (EditText) findViewById(R.id.edResult);
        edResult2 = (EditText) findViewById(R.id.edResult2);

        tv1 = (TextView)findViewById(R.id.tv1);
        tv1.setTypeface(myTypeface3);
        tv2 = (TextView)findViewById(R.id.tv2);
        tv2.setTypeface(myTypeface3);
        tv3 = (TextView)findViewById(R.id.tv3);
        tv3.setTypeface(myTypeface4);

        if (getColor() != getResources().getColor(R.color.colorPrimary)) {

            my_toolbar.setBackgroundColor(getBackgroundColor());
            LoyoutMainProc.setBackgroundColor(getBackgroundColor());
            corLoyDlinna.setBackgroundColor(getBackgroundColor());
            bottomColorLayout.setBackgroundColor(getColor());
            myBtnClear.setBackgroundColor(getColor());


            tv1.setTextColor(getTextColor());
            tv2.setTextColor(getTextColor());
            tv3.setTextColor(getTextColor());


            edNum.setBackgroundColor(getEditTextActivityColor());
            edNum.setTextColor(getEditTextColor());
            edPerc.setBackgroundColor(getEditTextActivityColor());
            edPerc.setTextColor(getEditTextColor());
            edResult.setBackgroundColor(getEditTextActivityColor());
            edResult.setTextColor(getEditTextColor());
            edResult2.setBackgroundColor(getEditTextActivityColor());
         //   edResult2.setTextColor(getEditTextColor());



            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                getWindow().setStatusBarColor(getColor());
            }
        }

        edPerc.addTextChangedListener(this);
        edNum.addTextChangedListener(this);
        myBtnClear.setOnClickListener(this);
        edNum.requestFocus();


    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

        double num1 = 0;
        double num2 = 0;
        double result = 0;
        double result2 = 0;

        if (TextUtils.isEmpty(edNum.getText().toString())

                ||  (edNum.getText().toString().equals("."))
                ||  (edNum.getText().toString().equals("-"))

                || TextUtils.isEmpty(edPerc.getText().toString())

                ||  (edPerc.getText().toString().equals('.'))
                ||  (edPerc.getText().toString().equals("-"))){


            edResult.setText("");
            edResult2.setText("");
            return;
        }

        num1 = Double.parseDouble(edNum.getText().toString());{

            num2 = Double.parseDouble(edPerc.getText().toString());



            if (edNum.isFocused()) {

                result = ((num1 / 100) * num2);
                result2 = (num1 - result);

                edResult.setText(String.valueOf(roundUp(result,2)));
                edResult2.setText(String.valueOf(roundUp(result2,2)));

            }

            if (edPerc.isFocused()) {
                result = ((num1 / 100) * num2);
                result2 = (num1 - result);

                edResult.setText(String.valueOf(roundUp(result,2)));
                edResult2.setText(String.valueOf(roundUp(result2,2)));


            }

        }

    }

    @Override
    public void afterTextChanged(Editable s) {

    }


    @Override
    public void onClick(View v) {

        edNum.setText("");
        edPerc.setText("");
        edNum.requestFocus();




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




