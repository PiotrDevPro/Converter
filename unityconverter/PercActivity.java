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

public class PercActivity extends AppCompatActivity implements TextWatcher {

    String[] data = {"(1')100%", "(1/2) 50%", "(1/3) 33.3%", "(1/4) 25%", "(1/5) 20%", "(1/6) 16.67%", "(1/7) 14.3%", "(1/8) 12.5%", "(1/9) 11.1%", "(1/10) 10%"};
    int a;
    Spinner spMassa;
    EditText edNum, edOne, edOneTwo, edOneTri, edOneChit, edOnePyat, edOneShect, edOneSem, edOneVosem, edOneDevyat, edOneDesyt;
    // TextView tvPosName;

    public BigDecimal roundUp(double value, int digits) {
        return new BigDecimal("" + value).setScale(digits, BigDecimal.ROUND_HALF_UP);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.perc);

        Toolbar my_toolbar = (Toolbar) findViewById(R.id.my_toolbar_app);
        RelativeLayout backColorlayoutAds = (RelativeLayout) findViewById(R.id.reLayoutPercAds);
        CollapsingToolbarLayout bottomColorLayout = (CollapsingToolbarLayout) findViewById(R.id.PercBottomLayout);
        CoordinatorLayout corLoyDlinna = (CoordinatorLayout) findViewById(R.id.corLoyoutPerc);

        setSupportActionBar(my_toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, data);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);

        spMassa = (Spinner) findViewById(R.id.spMassa);
        spMassa.setAdapter(adapter);

        // tvPosName = (TextView) findViewById(R.id.tvPosName);

        TextView Nm = (TextView) findViewById(R.id.odin);
        TextView Km = (TextView) findViewById(R.id.odin2);
        TextView Mile = (TextView) findViewById(R.id.odin3);
        TextView m = (TextView) findViewById(R.id.odin4);
        TextView yard = (TextView) findViewById(R.id.odin5);
        TextView ozff = (TextView) findViewById(R.id.odin6);
        TextView pdll = (TextView) findViewById(R.id.odin7);
        TextView kgff = (TextView) findViewById(R.id.odin8);
        TextView gff = (TextView) findViewById(R.id.odin9);
        TextView dynn = (TextView) findViewById(R.id.odin10);

        edNum = (EditText) findViewById(R.id.edNum);

        edOne = (EditText) findViewById(R.id.edOne);
        edOneTwo = (EditText) findViewById(R.id.edOneTwo);
        edOneTri = (EditText) findViewById(R.id.edOneTri);
        edOneChit = (EditText) findViewById(R.id.edOneChit);
        edOnePyat = (EditText) findViewById(R.id.edOnePyat);
        edOneShect = (EditText) findViewById(R.id.edOneShect);
        edOneSem = (EditText) findViewById(R.id.edOneSem);
        edOneVosem = (EditText) findViewById(R.id.edOneVosem);
        edOneDevyat = (EditText) findViewById(R.id.edOneDevyat);
        edOneDesyt = (EditText) findViewById(R.id.edOneDesyt);

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
            dynn.setTextColor(getTextColor());


            edOne.setBackgroundColor(getEditTextActivityColor());
            edOne.setTextColor(getEditTextColor());
            edOneTwo.setBackgroundColor(getEditTextActivityColor());
            edOneTwo.setTextColor(getEditTextColor());
            edOneTri.setBackgroundColor(getEditTextActivityColor());
            edOneTri.setTextColor(getEditTextColor());
            edOneChit.setBackgroundColor(getEditTextActivityColor());
            edOneChit.setTextColor(getEditTextColor());
            edOnePyat.setBackgroundColor(getEditTextActivityColor());
            edOnePyat.setTextColor(getEditTextColor());

            edOneShect.setBackgroundColor(getEditTextActivityColor());
            edOneShect.setTextColor(getEditTextColor());
            edOneSem.setBackgroundColor(getEditTextActivityColor());
            edOneSem.setTextColor(getEditTextColor());
            edOneVosem.setBackgroundColor(getEditTextActivityColor());
            edOneVosem.setTextColor(getEditTextColor());
            edOneDevyat.setBackgroundColor(getEditTextActivityColor());
            edOneDevyat.setTextColor(getEditTextColor());
            edOneDesyt.setBackgroundColor(getEditTextActivityColor());
            edOneDesyt.setTextColor(getEditTextColor());


            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                getWindow().setStatusBarColor(getColor());
            }
        }


        edNum.addTextChangedListener(this);
        edNum.requestFocus();

        spMassa.setSelection(0);
        spMassa.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()

        {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                String strName = spMassa.getSelectedItem().toString();
                //      tvPosName.setText(strName);
                a = position;

                double result = 0;
                double num = 0;


                if (TextUtils.isEmpty(edNum.getText().toString())
                        || (edNum.getText().toString().equals("."))
                        || (edNum.getText().toString().equals("-"))) {

                    edOne.setText("");
                    edOneTwo.setText("");
                    edOneTri.setText("");
                    edOneChit.setText("");

                    edOnePyat.setText("");
                    edOneShect.setText("");
                    edOneSem.setText("");
                    edOneVosem.setText("");

                    edOneDevyat.setText("");
                    edOneDesyt.setText("");


                    return;
                }

                num = Double.parseDouble(edNum.getText().toString());


                switch (position) {
                    case 0:
                        result = (num + 0);
                        edOne.setText(String.valueOf(roundUp(result, 2)));
                        result = (num * 1 / 2);
                        edOneTwo.setText(String.valueOf(roundUp(result, 2)));
                        result = (num * 1 / 3);
                        edOneTri.setText(String.valueOf(roundUp(result, 2)));
                        result = (num * 1 / 4);
                        edOneChit.setText(String.valueOf(roundUp(result, 2)));
                        result = (num * 1 / 5);
                        edOnePyat.setText(String.valueOf(roundUp(result, 2)));
                        result = (num * 1 / 6);
                        edOneShect.setText(String.valueOf(roundUp(result, 2)));
                        result = (num * 1 / 7);
                        edOneSem.setText(String.valueOf(roundUp(result, 2)));
                        result = (num * 1 / 8);
                        edOneVosem.setText(String.valueOf(roundUp(result, 2)));
                        result = (num * 1 / 9);
                        edOneDevyat.setText(String.valueOf(roundUp(result, 2)));
                        result = (num * 1 / 10);
                        edOneDesyt.setText(String.valueOf(roundUp(result, 2)));
                        break;

                    case 1:

                        result = (num * 2);
                        edOne.setText(String.valueOf(roundUp(result, 2)));
                        result = (num + 0);
                        edOneTwo.setText(String.valueOf(roundUp(result, 2)));
                        result = ((num * 2) * 0.33);
                        edOneTri.setText(String.valueOf(roundUp(result, 2)));
                        result = ((num * 2) * 0.25);
                        edOneChit.setText(String.valueOf(roundUp(result, 2)));
                        result = ((num * 2) * 0.2);
                        edOnePyat.setText(String.valueOf(roundUp(result, 2)));
                        result = ((num * 2) * 0.166);
                        edOneShect.setText(String.valueOf(roundUp(result, 2)));
                        result = ((num * 2) * 0.143);
                        edOneSem.setText(String.valueOf(roundUp(result, 2)));
                        result = ((num * 2) * 0.125);
                        edOneVosem.setText(String.valueOf(roundUp(result, 2)));
                        result = ((num * 2) * 0.111);
                        edOneDevyat.setText(String.valueOf(roundUp(result, 2)));
                        result = ((num * 2) * 0.1);
                        edOneDesyt.setText(String.valueOf(roundUp(result, 2)));
                        break;

                    case 2:
                        result = (num * 3);
                        edOne.setText(String.valueOf(roundUp(result, 2)));
                        result = ((num * 3) * 0.5);
                        edOneTwo.setText(String.valueOf(roundUp(result, 2)));
                        result = (num + 0);
                        edOneTri.setText(String.valueOf(roundUp(result, 2)));
                        result = ((num * 3) * 0.25);
                        edOneChit.setText(String.valueOf(roundUp(result, 2)));
                        result = ((num * 3) * 0.2);
                        edOnePyat.setText(String.valueOf(roundUp(result, 2)));
                        result = ((num * 3) * 0.166);
                        edOneShect.setText(String.valueOf(roundUp(result, 2)));
                        result = ((num * 3) * 0.143);
                        edOneSem.setText(String.valueOf(roundUp(result, 2)));
                        result = ((num * 3) * 0.125);
                        edOneVosem.setText(String.valueOf(roundUp(result, 2)));
                        result = ((num * 3) * 0.111);
                        edOneDevyat.setText(String.valueOf(roundUp(result, 2)));
                        result = ((num * 3) * 0.1);
                        edOneDesyt.setText(String.valueOf(roundUp(result, 2)));
                        break;

                    case 3:
                        result = (num * 4);
                        edOne.setText(String.valueOf(roundUp(result, 2)));
                        result = ((num * 4) * 0.5);
                        edOneTwo.setText(String.valueOf(roundUp(result, 2)));
                        result = ((num * 4) * 0.33);
                        edOneTri.setText(String.valueOf(roundUp(result, 2)));
                        result = (num + 0);
                        edOneChit.setText(String.valueOf(roundUp(result, 2)));
                        result = ((num * 3) * 0.2);
                        edOnePyat.setText(String.valueOf(roundUp(result, 2)));
                        result = ((num * 3) * 0.166);
                        edOneShect.setText(String.valueOf(roundUp(result, 2)));
                        result = ((num * 3) * 0.143);
                        edOneSem.setText(String.valueOf(roundUp(result, 2)));
                        result = ((num * 3) * 0.125);
                        edOneVosem.setText(String.valueOf(roundUp(result, 2)));
                        result = ((num * 3) * 0.111);
                        edOneDevyat.setText(String.valueOf(roundUp(result, 2)));
                        result = ((num * 3) * 0.1);
                        edOneDesyt.setText(String.valueOf(roundUp(result, 2)));
                        break;

                    case 4:
                        result = (num * 5);
                        edOne.setText(String.valueOf(roundUp(result, 2)));
                        result = ((num * 5) * 0.5);
                        edOneTwo.setText(String.valueOf(roundUp(result, 2)));
                        result = ((num * 5) * 0.33);
                        edOneTri.setText(String.valueOf(roundUp(result, 2)));
                        result = ((num * 5) * 0.25);
                        edOneChit.setText(String.valueOf(roundUp(result, 2)));
                        result = (num + 0);
                        edOnePyat.setText(String.valueOf(roundUp(result, 2)));
                        result = ((num * 5) * 0.166);
                        edOneShect.setText(String.valueOf(roundUp(result, 2)));
                        result = ((num * 5) * 0.143);
                        edOneSem.setText(String.valueOf(roundUp(result, 2)));
                        result = ((num * 5) * 0.125);
                        edOneVosem.setText(String.valueOf(roundUp(result, 2)));
                        result = ((num * 5) * 0.111);
                        edOneDevyat.setText(String.valueOf(roundUp(result, 2)));
                        result = ((num * 5) * 0.1);
                        edOneDesyt.setText(String.valueOf(roundUp(result, 2)));
                        break;

                    case 5:
                        result = (num * 6);
                        edOne.setText(String.valueOf(roundUp(result, 2)));
                        result = ((num * 6) * 0.5);
                        edOneTwo.setText(String.valueOf(roundUp(result, 2)));
                        result = ((num * 6) * 0.33);
                        edOneTri.setText(String.valueOf(roundUp(result, 2)));
                        result = ((num * 6) * 0.25);
                        edOneChit.setText(String.valueOf(roundUp(result, 2)));
                        result = ((num * 6) * 0.2);
                        edOnePyat.setText(String.valueOf(roundUp(result, 2)));
                        result = (num + 0);
                        edOneShect.setText(String.valueOf(roundUp(result, 2)));
                        result = ((num * 6) * 0.143);
                        edOneSem.setText(String.valueOf(roundUp(result, 2)));
                        result = ((num * 6) * 0.125);
                        edOneVosem.setText(String.valueOf(roundUp(result, 2)));
                        result = ((num * 6) * 0.111);
                        edOneDevyat.setText(String.valueOf(roundUp(result, 2)));
                        result = ((num * 6) * 0.1);
                        edOneDesyt.setText(String.valueOf(roundUp(result, 2)));
                        break;

                    case 6:

                        result = (num * 7);
                        edOne.setText(String.valueOf(roundUp(result, 2)));
                        result = ((num * 7) * 0.5);
                        edOneTwo.setText(String.valueOf(roundUp(result, 2)));
                        result = ((num * 7) * 0.33);
                        edOneTri.setText(String.valueOf(roundUp(result, 2)));
                        result = ((num * 7) * 0.25);
                        edOneChit.setText(String.valueOf(roundUp(result, 2)));
                        result = ((num * 7) * 0.2);
                        edOnePyat.setText(String.valueOf(roundUp(result, 2)));
                        result = ((num * 7) * 0.166);
                        edOneShect.setText(String.valueOf(roundUp(result, 2)));
                        result = (num + 0);
                        edOneSem.setText(String.valueOf(roundUp(result, 2)));
                        result = ((num * 6) * 0.125);
                        edOneVosem.setText(String.valueOf(roundUp(result, 2)));
                        result = ((num * 6) * 0.111);
                        edOneDevyat.setText(String.valueOf(roundUp(result, 2)));
                        result = ((num * 6) * 0.1);
                        edOneDesyt.setText(String.valueOf(roundUp(result, 2)));
                        break;

                    case 7:
                        result = (num * 8);
                        edOne.setText(String.valueOf(roundUp(result, 2)));
                        result = ((num * 8) * 0.5);
                        edOneTwo.setText(String.valueOf(roundUp(result, 2)));
                        result = ((num * 8) * 0.33);
                        edOneTri.setText(String.valueOf(roundUp(result, 2)));
                        result = ((num * 8) * 0.25);
                        edOneChit.setText(String.valueOf(roundUp(result, 2)));
                        result = ((num * 8) * 0.2);
                        edOnePyat.setText(String.valueOf(roundUp(result, 2)));
                        result = ((num * 8) * 0.166);
                        edOneShect.setText(String.valueOf(roundUp(result, 2)));
                        result = ((num * 8) * 0.143);
                        edOneSem.setText(String.valueOf(roundUp(result, 2)));
                        result = (num + 0);
                        edOneVosem.setText(String.valueOf(roundUp(result, 2)));
                        result = ((num * 8) * 0.111);
                        edOneDevyat.setText(String.valueOf(roundUp(result, 2)));
                        result = ((num * 8) * 0.1);
                        edOneDesyt.setText(String.valueOf(roundUp(result, 2)));
                        break;

                    case 8:
                        result = (num * 9);
                        edOne.setText(String.valueOf(roundUp(result, 2)));
                        result = ((num * 9) * 0.5);
                        edOneTwo.setText(String.valueOf(roundUp(result, 2)));
                        result = ((num * 9) * 0.33);
                        edOneTri.setText(String.valueOf(roundUp(result, 2)));
                        result = ((num * 9) * 0.25);
                        edOneChit.setText(String.valueOf(roundUp(result, 2)));
                        result = ((num * 9) * 0.2);
                        edOnePyat.setText(String.valueOf(roundUp(result, 2)));
                        result = ((num * 9) * 0.166);
                        edOneShect.setText(String.valueOf(roundUp(result, 2)));
                        result = ((num * 9) * 0.143);
                        edOneSem.setText(String.valueOf(roundUp(result, 2)));
                        result = ((num * 9) * 0.125);
                        edOneVosem.setText(String.valueOf(roundUp(result, 2)));
                        result = (num + 0);
                        edOneDevyat.setText(String.valueOf(roundUp(result, 2)));
                        result = ((num * 9) * 0.1);
                        edOneDesyt.setText(String.valueOf(roundUp(result, 2)));
                        break;

                    case 9:
                        result = (num * 10);
                        edOne.setText(String.valueOf(roundUp(result, 2)));
                        result = ((num * 10) * 0.5);
                        edOneTwo.setText(String.valueOf(roundUp(result, 2)));
                        result = ((num * 10) * 0.33);
                        edOneTri.setText(String.valueOf(roundUp(result, 2)));
                        result = ((num * 10) * 0.25);
                        edOneChit.setText(String.valueOf(roundUp(result, 2)));
                        result = ((num * 10) * 0.2);
                        edOnePyat.setText(String.valueOf(roundUp(result, 2)));
                        result = ((num * 10) * 0.166);
                        edOneShect.setText(String.valueOf(roundUp(result, 2)));
                        result = ((num * 10) * 0.143);
                        edOneSem.setText(String.valueOf(roundUp(result, 2)));
                        result = ((num * 10) * 0.125);
                        edOneVosem.setText(String.valueOf(roundUp(result, 2)));
                        result = ((num * 10) * 0.111);
                        edOneDevyat.setText(String.valueOf(roundUp(result, 2)));
                        result = (num + 0);
                        edOneDesyt.setText(String.valueOf(roundUp(result, 2)));
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
        double num1 = 0;

        if (TextUtils.isEmpty(edNum.getText().toString())
                ||  (edNum.getText().toString().equals("."))
                ||  (edNum.getText().toString().equals("-"))){

            edOne.setText("");
            edOneTwo.setText("");
            edOneTri.setText("");
            edOneChit.setText("");

            edOnePyat.setText("");
            edOneShect.setText("");
            edOneSem.setText("");
            edOneVosem.setText("");

            edOneDevyat.setText("");
            edOneDesyt.setText("");


            return;
        }

        num = Double.parseDouble(edNum.getText().toString());

        switch (a){
            case 0:
                result = (num + 0);
                edOne.setText(String.valueOf(roundUp(result,2)));
                result = (num *1/2);
                edOneTwo.setText(String.valueOf(roundUp(result,2)));
                result = (num *1/3);
                edOneTri.setText(String.valueOf(roundUp(result,2)));
                result = (num *1/4);
                edOneChit.setText(String.valueOf(roundUp(result,2)));
                result = (num *1/5);
                edOnePyat.setText(String.valueOf(roundUp(result,2)));
                result = (num *1/6);
                edOneShect.setText(String.valueOf(roundUp(result,2)));
                result = (num *1/7);
                edOneSem.setText(String.valueOf(roundUp(result,2)));
                result = (num *1/8);
                edOneVosem.setText(String.valueOf(roundUp(result,2)));
                result = (num *1/9);
                edOneDevyat.setText(String.valueOf(roundUp(result,2)));
                result = (num *1/10);
                edOneDesyt.setText(String.valueOf(roundUp(result, 2)));

                break;

            case 1:

                result = (num * 2);
                edOne.setText(String.valueOf(roundUp(result,2)));
                result = (num +0);
                edOneTwo.setText(String.valueOf(roundUp(result,2)));
                result = ((num * 2)*0.33);
                edOneTri.setText(String.valueOf(roundUp(result,2)));
                result = ((num *2)*0.25);
                edOneChit.setText(String.valueOf(roundUp(result,2)));
                result = ((num *2)*0.2);
                edOnePyat.setText(String.valueOf(roundUp(result,2)));
                result = ((num *2)*0.166);
                edOneShect.setText(String.valueOf(roundUp(result,2)));
                result = ((num *2)*0.143);
                edOneSem.setText(String.valueOf(roundUp(result,2)));
                result = ((num *2)*0.125);
                edOneVosem.setText(String.valueOf(roundUp(result,2)));
                result = ((num *2)*0.111);
                edOneDevyat.setText(String.valueOf(roundUp(result,2)));
                result = ((num *2)*0.1);
                edOneDesyt.setText(String.valueOf(roundUp(result,2)));
                break;

            case 2:
                result = (num * 3);
                edOne.setText(String.valueOf(roundUp(result,2)));
                result = ((num * 3)*0.5);
                edOneTwo.setText(String.valueOf(roundUp(result,2)));
                result = (num +0);
                edOneTri.setText(String.valueOf(roundUp(result,2)));
                result = ((num *3)*0.25);
                edOneChit.setText(String.valueOf(roundUp(result,2)));
                result = ((num *3)*0.2);
                edOnePyat.setText(String.valueOf(roundUp(result,2)));
                result = ((num *3)*0.166);
                edOneShect.setText(String.valueOf(roundUp(result,2)));
                result = ((num *3)*0.143);
                edOneSem.setText(String.valueOf(roundUp(result,2)));
                result = ((num *3)*0.125);
                edOneVosem.setText(String.valueOf(roundUp(result,2)));
                result = ((num *3)*0.111);
                edOneDevyat.setText(String.valueOf(roundUp(result,2)));
                result = ((num *3)*0.1);
                edOneDesyt.setText(String.valueOf(roundUp(result, 2)));

                break;

            case 3:
                result = (num * 4);
                edOne.setText(String.valueOf(roundUp(result,2)));
                result = ((num * 4)*0.5);
                edOneTwo.setText(String.valueOf(roundUp(result,2)));
                result = ((num * 4)*0.33);
                edOneTri.setText(String.valueOf(roundUp(result,2)));
                result = (num + 0);
                edOneChit.setText(String.valueOf(roundUp(result,2)));
                result = ((num *3)*0.2);
                edOnePyat.setText(String.valueOf(roundUp(result,2)));
                result = ((num *3)*0.166);
                edOneShect.setText(String.valueOf(roundUp(result,2)));
                result = ((num *3)*0.143);
                edOneSem.setText(String.valueOf(roundUp(result,2)));
                result = ((num *3)*0.125);
                edOneVosem.setText(String.valueOf(roundUp(result,2)));
                result = ((num *3)*0.111);
                edOneDevyat.setText(String.valueOf(roundUp(result,2)));
                result = ((num *3)*0.1);
                edOneDesyt.setText(String.valueOf(roundUp(result,2)));

                break;

            case 4:
                result = (num * 5);
                edOne.setText(String.valueOf(roundUp(result,2)));
                result = ((num * 5)*0.5);
                edOneTwo.setText(String.valueOf(roundUp(result,2)));
                result = ((num * 5)*0.33);
                edOneTri.setText(String.valueOf(roundUp(result,2)));
                result = ((num * 5)*0.25);
                edOneChit.setText(String.valueOf(roundUp(result,2)));
                result = (num+0);
                edOnePyat.setText(String.valueOf(roundUp(result,2)));
                result = ((num *5)*0.166);
                edOneShect.setText(String.valueOf(roundUp(result,2)));
                result = ((num *5)*0.143);
                edOneSem.setText(String.valueOf(roundUp(result,2)));
                result = ((num *5)*0.125);
                edOneVosem.setText(String.valueOf(roundUp(result,2)));
                result = ((num *5)*0.111);
                edOneDevyat.setText(String.valueOf(roundUp(result,2)));
                result = ((num *5)*0.1);
                edOneDesyt.setText(String.valueOf(roundUp(result,2)));

                break;

            case 5:
                result = (num * 6);
                edOne.setText(String.valueOf(roundUp(result,2)));
                result = ((num * 6)*0.5);
                edOneTwo.setText(String.valueOf(roundUp(result,2)));
                result = ((num * 6)*0.33);
                edOneTri.setText(String.valueOf(roundUp(result,2)));
                result = ((num * 6)*0.25);
                edOneChit.setText(String.valueOf(roundUp(result,2)));
                result = ((num * 6)*0.2);
                edOnePyat.setText(String.valueOf(roundUp(result,2)));
                result = (num+0);
                edOneShect.setText(String.valueOf(roundUp(result,2)));
                result = ((num *6)*0.143);
                edOneSem.setText(String.valueOf(roundUp(result,2)));
                result = ((num *6)*0.125);
                edOneVosem.setText(String.valueOf(roundUp(result,2)));
                result = ((num *6)*0.111);
                edOneDevyat.setText(String.valueOf(roundUp(result,2)));
                result = ((num *6)*0.1);
                edOneDesyt.setText(String.valueOf(roundUp(result, 2)));

                break;
            case 6:

                result = (num * 7);
                edOne.setText(String.valueOf(roundUp(result,2)));
                result = ((num * 7)*0.5);
                edOneTwo.setText(String.valueOf(roundUp(result,2)));
                result = ((num * 7)*0.33);
                edOneTri.setText(String.valueOf(roundUp(result,2)));
                result = ((num * 7)*0.25);
                edOneChit.setText(String.valueOf(roundUp(result,2)));
                result = ((num * 7)*0.2);
                edOnePyat.setText(String.valueOf(roundUp(result,2)));
                result = ((num * 7)*0.166);
                edOneShect.setText(String.valueOf(roundUp(result,2)));
                result = (num+0);
                edOneSem.setText(String.valueOf(roundUp(result,2)));
                result = ((num *6)*0.125);
                edOneVosem.setText(String.valueOf(roundUp(result,2)));
                result = ((num *6)*0.111);
                edOneDevyat.setText(String.valueOf(roundUp(result,2)));
                result = ((num *6)*0.1);
                edOneDesyt.setText(String.valueOf(roundUp(result, 2)));

                break;

            case 7:
                result = (num * 8);
                edOne.setText(String.valueOf(roundUp(result,2)));
                result = ((num * 8)*0.5);
                edOneTwo.setText(String.valueOf(roundUp(result,2)));
                result = ((num * 8)*0.33);
                edOneTri.setText(String.valueOf(roundUp(result,2)));
                result = ((num * 8)*0.25);
                edOneChit.setText(String.valueOf(roundUp(result,2)));
                result = ((num * 8)*0.2);
                edOnePyat.setText(String.valueOf(roundUp(result,2)));
                result = ((num * 8)*0.166);
                edOneShect.setText(String.valueOf(roundUp(result,2)));
                result = ((num * 8)*0.143);
                edOneSem.setText(String.valueOf(roundUp(result,2)));
                result = (num +0);
                edOneVosem.setText(String.valueOf(roundUp(result,2)));
                result = ((num *8)*0.111);
                edOneDevyat.setText(String.valueOf(roundUp(result,2)));
                result = ((num *8)*0.1);
                edOneDesyt.setText(String.valueOf(roundUp(result,2)));

                break;

            case 8:
                result = (num * 9);
                edOne.setText(String.valueOf(roundUp(result,2)));
                result = ((num * 9)*0.5);
                edOneTwo.setText(String.valueOf(roundUp(result,2)));
                result = ((num * 9)*0.33);
                edOneTri.setText(String.valueOf(roundUp(result,2)));
                result = ((num * 9)*0.25);
                edOneChit.setText(String.valueOf(roundUp(result,2)));
                result = ((num * 9)*0.2);
                edOnePyat.setText(String.valueOf(roundUp(result,2)));
                result = ((num * 9)*0.166);
                edOneShect.setText(String.valueOf(roundUp(result,2)));
                result = ((num * 9)*0.143);
                edOneSem.setText(String.valueOf(roundUp(result,2)));
                result = ((num * 9)*0.125);
                edOneVosem.setText(String.valueOf(roundUp(result,2)));
                result = (num +0);
                edOneDevyat.setText(String.valueOf(roundUp(result,2)));
                result = ((num *9)*0.1);
                edOneDesyt.setText(String.valueOf(roundUp(result, 2)));

                break;

            case 9:
                result = (num * 10);
                edOne.setText(String.valueOf(roundUp(result,2)));
                result = ((num * 10)*0.5);
                edOneTwo.setText(String.valueOf(roundUp(result,2)));
                result = ((num * 10)*0.33);
                edOneTri.setText(String.valueOf(roundUp(result,2)));
                result = ((num * 10)*0.25);
                edOneChit.setText(String.valueOf(roundUp(result,2)));
                result = ((num * 10)*0.2);
                edOnePyat.setText(String.valueOf(roundUp(result,2)));
                result = ((num * 10)*0.166);
                edOneShect.setText(String.valueOf(roundUp(result,2)));
                result = ((num * 10)*0.143);
                edOneSem.setText(String.valueOf(roundUp(result,2)));
                result = ((num * 10)*0.125);
                edOneVosem.setText(String.valueOf(roundUp(result,2)));
                result = ((num * 10)*0.111);
                edOneDevyat.setText(String.valueOf(roundUp(result,2)));
                result = (num +0);
                edOneDesyt.setText(String.valueOf(roundUp(result, 2)));

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

