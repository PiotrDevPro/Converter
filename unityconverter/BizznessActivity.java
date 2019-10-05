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
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.math.BigDecimal;

public class BizznessActivity extends AppCompatActivity implements TextWatcher,View.OnClickListener {

    Button myBtnClear;
    EditText edCenaPost, edKol, edCenaNac, edPribil, edNalog, edPribilCh, edCenaObs, edNac;
    TextView tv1, tv2, tv3, tv4, tv5, tv6, tv8, tv9, tv10,tv11;

    public BigDecimal roundUp(double value, int digits) {
        return new BigDecimal("" + value).setScale(digits, BigDecimal.ROUND_HALF_UP);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bizzness);

        Toolbar my_toolbar = (Toolbar) findViewById(R.id.my_toolbar_app);
        LinearLayout LoyoutMainProc = (LinearLayout) findViewById(R.id.LoyoutMainBiz);
        CollapsingToolbarLayout bottomColorLayout = (CollapsingToolbarLayout) findViewById(R.id.BizBottomLayout);
        CoordinatorLayout corLoyDlinna = (CoordinatorLayout) findViewById(R.id.corLoyoutBiz);
        setSupportActionBar(my_toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        Typeface myTypeface3 = Typeface.createFromAsset(getAssets(), "HelveticaNeueCyr-LightItalic.otf");
        Typeface myTypeface4 = Typeface.createFromAsset(getAssets(), "HelveticaNeueCyr-Italic.otf");

        myBtnClear = (Button) findViewById(R.id.myBtnClear);

        edCenaPost = (EditText) findViewById(R.id.edCenaPost);
        edKol = (EditText) findViewById(R.id.edKol);
        edCenaNac = (EditText) findViewById(R.id.edCenaNac);
        edNac = (EditText) findViewById(R.id.edNac);
        edPribil = (EditText) findViewById(R.id.edPribil);
        edNalog = (EditText) findViewById(R.id.edNalog);
        edPribilCh = (EditText) findViewById(R.id.edPribilCh);
        edCenaObs = (EditText) findViewById(R.id.edCenaObs);

        tv11 = (TextView) findViewById(R.id.tv11);

        tv1 = (TextView) findViewById(R.id.tv1);
        tv1.setTypeface(myTypeface3);
        tv2 = (TextView) findViewById(R.id.tv2);
        tv2.setTypeface(myTypeface3);
        tv3 = (TextView) findViewById(R.id.tv3);
        tv3.setTypeface(myTypeface3);
        tv4 = (TextView) findViewById(R.id.tv4);
        tv4.setTypeface(myTypeface4);
        tv5 = (TextView) findViewById(R.id.tv5);
        tv5.setTypeface(myTypeface3);
        tv6 = (TextView) findViewById(R.id.tv6);
        tv6.setTypeface(myTypeface3);
        tv8 = (TextView) findViewById(R.id.tv8);
        tv8.setTypeface(myTypeface3);
        tv9 = (TextView) findViewById(R.id.tv9);
        tv9.setTypeface(myTypeface4);
        tv10 = (TextView) findViewById(R.id.tv10);
        tv10.setTypeface(myTypeface4);
        tv11 = (TextView) findViewById(R.id.tv11);
        tv11.setTypeface(myTypeface3);

        if (getColor() != getResources().getColor(R.color.colorPrimary)) {

            my_toolbar.setBackgroundColor(getBackgroundColor());
            LoyoutMainProc.setBackgroundColor(getBackgroundColor());
            corLoyDlinna.setBackgroundColor(getBackgroundColor());
            bottomColorLayout.setBackgroundColor(getColor());
            myBtnClear.setBackgroundColor(getColor());
            myBtnClear.setTextColor(getTextColor());

            tv1.setTextColor(getTextColor());
            tv2.setTextColor(getTextColor());
            tv3.setTextColor(getTextColor());
            tv4.setTextColor(getTextColor());
            tv5.setTextColor(getTextColor());
            tv6.setTextColor(getTextColor());
            tv8.setTextColor(getTextColor());
            tv9.setTextColor(getTextColor());
            tv10.setTextColor(getTextColor());
            tv11.setTextColor(getTextColor());




            edCenaPost.setBackgroundColor(getEditTextActivityColor());
            edCenaPost.setTextColor(getEditTextColor());
            edKol.setBackgroundColor(getEditTextActivityColor());
            edKol.setTextColor(getEditTextColor());
            edCenaNac.setBackgroundColor(getEditTextActivityColor());
           // edCenaNac.setTextColor(getEditTextColor());
            edNac.setBackgroundColor(getEditTextActivityColor());
            edNac.setTextColor(getEditTextColor());

            edPribil.setBackgroundColor(getEditTextActivityColor());
           // edPribil.setTextColor(getEditTextColor());
            edNalog.setBackgroundColor(getEditTextActivityColor());
            edNalog.setTextColor(getEditTextColor());
            edPribilCh.setBackgroundColor(getEditTextActivityColor());
          //  edPribilCh.setTextColor(getEditTextColor());
            edCenaObs.setBackgroundColor(getEditTextActivityColor());
         //   edCenaObs.setTextColor(getEditTextColor());



            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                getWindow().setStatusBarColor(getColor());
            }
        }



        edCenaPost.addTextChangedListener(this);
        edKol.addTextChangedListener(this);
        edNac.addTextChangedListener(this);
        edNalog.addTextChangedListener(this);
        myBtnClear.setOnClickListener(this);
        edCenaPost.requestFocus();

    }


    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

        double num1 = 0;
        double num2 = 0;
        double num3 = 0;
        double num4 = 0;
        double result = 0;
        double result2 = 0;
        double result3 = 0;
        double result4 = 0;
        double result5 = 0;

        if (TextUtils.isEmpty(edCenaPost.getText().toString())

                || (edCenaPost.getText().toString().equals('.'))

                || (edCenaPost.getText().toString().equals('-'))

                || TextUtils.isEmpty(edKol.getText().toString())

                || (edKol.getText().toString().equals('.'))

                || (edKol.getText().toString().equals('-')))

        {


            edCenaObs.setText("N/A");
            return;

        }

        num1 = Double.parseDouble(edCenaPost.getText().toString());

        {


            num2 = Double.parseDouble(edKol.getText().toString());


            if (edCenaPost.isFocused()) {


                result = (num1 * num2);

                edCenaObs.setText(String.valueOf(roundUp(result, 2)));


            }

            if (edKol.isFocused()) {

                result = (num1 * num2);


                edCenaObs.setText(String.valueOf(roundUp(result, 2)));

            }

            if (TextUtils.isEmpty(edNac.getText().toString())
                    ||
                    (edNac.getText().toString().equals('.'))
                    ||
                    (edNac.getText().toString().equals('-')))

            {

                edCenaNac.setText("N/A");
                edPribil.setText("N/A");


                return;

            }

            num3 = Double.parseDouble(edNac.getText().toString());

        }

        if (edNac.isFocused()) {

            result = num1 * num2;
            result2 = (((num1) / 100) * num3) + num1;
            result3 = (result2 * num2);

            //  edPribil.setText("N/A");
            edCenaPost.setEnabled(false);
            edKol.setEnabled(false);
            edCenaNac.setText(String.valueOf(roundUp(result2, 2)));
            edPribil.setText(String.valueOf(roundUp(result3, 2)));

        }

        if (TextUtils.isEmpty(edNalog.getText().toString())

                || (edNalog.getText().toString().equals('.'))
                    ||
                        (edNac.getText().toString().equals('-')))

        {
            edPribilCh.setText("N/A");
            tv11.setText("");

            return;

        }

        num4 = Double.parseDouble(edNalog.getText().toString());
        {
            num3 = Double.parseDouble(edNac.getText().toString());
        }

        if (edNalog.isFocused()) {

            result = num1 * num2;
            result2 = (((num1) / 100) * num3) + num1;
            result3 = result2 * num2;
            result4 = (result3  - result)-num4;
            result5 = ((result4/result3)*100);


            edPribilCh.setText(String.valueOf(roundUp(result4, 2)));
            tv11.setText(String.valueOf(roundUp( +result5,2)+"%"));
            Toast.makeText(getApplicationContext(), " rentability =" + (roundUp(result5, 2)) + "%", Toast.LENGTH_SHORT).show();
        }

        if (edNac.isFocused()) {
            result = num1 * num2;
            result2 = (((num1) / 100) * num3) + num1;
            result3 = result2 * num2;
            result4 = (result3  - result)-num4;
            //result4 = (result3  - num4);
            result5 = ((result4/result3)*100);

            edCenaNac.setText(String.valueOf(roundUp(result2, 2)));
            edPribilCh.setText(String.valueOf(roundUp(result4, 2)));
            tv11.setText(String.valueOf(roundUp(result5,2)+"%"));
            Toast.makeText(getApplicationContext(), " rentability = " + (roundUp(result5, 2)) + "%", Toast.LENGTH_SHORT).show();
        }


    }


    @Override
    public void afterTextChanged(Editable s) {

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.myBtnClear:

                edCenaPost.setText("");
                edKol.setText("");
                edCenaPost.setEnabled(true);
                edKol.setEnabled(true);
                edCenaObs.setText("N/A");
                edCenaNac.setText("");
                edNac.setText("");
                edPribil.setText("N/A");
                edNalog.setText("");
                edPribilCh.setText("N/A");
                edCenaPost.requestFocus();
                tv11.setText("");

                break;

           /* case R.id.myBtnRent:

                if (TextUtils.isEmpty(edPribil.getText().toString())
                        || (edPribil.getText().toString().equals('.'))
                        || (TextUtils.isEmpty(edPribilCh.getText().toString())
                        || (edPribilCh.getText().toString().equals('.')))) {

                    return;

                }
                        num1 = Double.parseDouble(edPribil.getText().toString());

                        num2 = Double.parseDouble(edPribilCh.getText().toString());{

                    }

                        result = (num2 / num1) * 100;

                        Toast.makeText(getApplicationContext(), " Рентабельность = " + (roundUp(result, 2)) + "%", Toast.LENGTH_LONG).show();


                        break;
                    }*/

        }
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

