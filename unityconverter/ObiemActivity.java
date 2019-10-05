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

public class ObiemActivity extends AppCompatActivity implements TextWatcher{

 //   String[] data = {"Литр (L)","Миллилитр (ml)","Куб.сантиметр (cm³)","Куб.метр (m³)","Куб.Фут (ft³)","Куб.дюйм (in³)","Американскай галлон (gal)","Американская кварта (qt)","Американская пинта (pt)","Американская чашка (US cup)","Американская унция (US oz)","Американская ст.ложка (tbsp)","Американская чай.ложка (tsp)","Британский галлон (gal)","Британская пинта (pt)","Британская чашка (Imperial cup)","Британская ст.ложка (UK tbsp)","Британская чай.ложка (UK tsp)","Британская унция (oz)","Баррель нефтяной (bbl)"};
    int a;
    Spinner spMassa;
    EditText edNum,edLitr, edmmLi, edKubSm,edKubM,edKubFut,edKubDuim,edAmGal,edAmKvarta,edAmPin,edAmCup,edAmUnci,edAmStLozhka,edAmTeaLozhka,edBrGal,edBrPint,edBrCup,edBrCtolLozhka,edBrTeaLozhka,edBrUnci,edBarrel;
    Toolbar my_toolbar;

    public BigDecimal roundUp(double value, int digits) {
        return new BigDecimal("" + value).setScale(digits, BigDecimal.ROUND_HALF_UP);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.obiem);

        Toolbar my_toolbar = (Toolbar) findViewById(R.id.my_toolbar_app);
        CoordinatorLayout corLoyMassa = (CoordinatorLayout) findViewById(R.id.corLoyoutObiem);
        RelativeLayout backColorlayoutAds = (RelativeLayout) findViewById(R.id.BackMassaAds);
        CollapsingToolbarLayout bottomColorLayout = (CollapsingToolbarLayout) findViewById(R.id.obiemBottomLayout);
        setSupportActionBar(my_toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,
      //  adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            getResources().getStringArray(R.array.obiem));

        spMassa = (Spinner) findViewById(R.id.spMassa);
        spMassa.setAdapter(adapter);


        edNum = (EditText) findViewById(R.id.edNum);


        edLitr = (EditText) findViewById(R.id.edLitr);
        edmmLi = (EditText) findViewById(R.id.edmmLi);
        edKubSm = (EditText) findViewById(R.id.edKubSm);
        edKubM = (EditText) findViewById(R.id.edKubM);
        edKubFut = (EditText) findViewById(R.id.edKubFut);
        edKubDuim = (EditText) findViewById(R.id.edKubDuim);
        edAmGal = (EditText) findViewById(R.id.edAmGal);
        edAmKvarta = (EditText) findViewById(R.id.edAmKvarta);
        edAmPin = (EditText) findViewById(R.id.edAmPin);
        edAmCup = (EditText) findViewById(R.id.edAmCup);
        edAmUnci = (EditText) findViewById(R.id.edAmUnci);
        edAmStLozhka = (EditText) findViewById(R.id.edAmStLozhka);
        edAmTeaLozhka = (EditText) findViewById(R.id.edAmTeaLozhka);
        edBrGal = (EditText) findViewById(R.id.edBrGal);
        edBrPint = (EditText) findViewById(R.id.edBrPint);
        edBrCup = (EditText) findViewById(R.id.edBrCup);
        edBrCtolLozhka = (EditText) findViewById(R.id.edBrCtolLozhka);
        edBrTeaLozhka = (EditText) findViewById(R.id.edBrTeaLozhka);
        edBrUnci = (EditText) findViewById(R.id.edBrUnci);
        edBarrel = (EditText) findViewById(R.id.edBarrel);

        TextView L = (TextView) findViewById(R.id.L);
        TextView mL = (TextView) findViewById(R.id.mL);
        TextView KubSm = (TextView) findViewById(R.id.kubSm);
        TextView KubM = (TextView) findViewById(R.id.KubM);
        TextView KubFut = (TextView)  findViewById(R.id.ft3);
        TextView KubDuim = (TextView)  findViewById(R.id.in3);
        TextView AmGal = (TextView)  findViewById(R.id.galUs);

        TextView AmKvarta = (TextView)  findViewById(R.id.qt);
        TextView AmPin = (TextView)  findViewById(R.id.pt);
        TextView AmCup = (TextView)  findViewById(R.id.UsCupCup);
        TextView AmUnci = (TextView)  findViewById(R.id.UsOz);
        TextView AmStLozhka = (TextView)  findViewById(R.id.tbspUs);
        TextView AmTeaLozhka = (TextView)  findViewById(R.id.tsp);
        TextView BrGal = (TextView)  findViewById(R.id.galUK);
        TextView BrPint = (TextView)  findViewById(R.id.ptUK);

        TextView BrCup = (TextView)  findViewById(R.id.UkCupCup);
        TextView BrCtolLozhka = (TextView)  findViewById(R.id.UKtbsp);
        TextView BrTeaLozhka = (TextView)  findViewById(R.id.UKtsp);
        TextView BrUnci = (TextView)  findViewById(R.id.UkOz);
        TextView Barrel = (TextView)  findViewById(R.id.barrel);
        TextView kulinary = (TextView) findViewById(R.id.Kulinaria);


        if (getColor() != getResources().getColor(R.color.colorPrimary)) {

            my_toolbar.setBackgroundColor(getBackgroundColor());
            backColorlayoutAds.setBackgroundColor(getColor());
            bottomColorLayout.setBackgroundColor(getColor());
            corLoyMassa.setBackgroundColor(getBackgroundColor());

            L.setTextColor(getTextColor());
            mL.setTextColor(getTextColor());
            KubSm.setTextColor(getTextColor());
            KubM.setTextColor(getTextColor());
            KubFut.setTextColor(getTextColor());
            KubDuim.setTextColor(getTextColor());
            AmGal.setTextColor(getTextColor());
            AmKvarta.setTextColor(getTextColor());
            AmPin.setTextColor(getTextColor());
            AmCup.setTextColor(getTextColor());
            AmUnci.setTextColor(getTextColor());
            AmStLozhka.setTextColor(getTextColor());
            AmTeaLozhka.setTextColor(getTextColor());
            BrGal.setTextColor(getTextColor());
            BrPint.setTextColor(getTextColor());
            BrCup.setTextColor(getTextColor());
            BrCtolLozhka.setTextColor(getTextColor());
            BrTeaLozhka.setTextColor(getTextColor());
            BrUnci.setTextColor(getTextColor());
            Barrel.setTextColor(getTextColor());
            kulinary.setTextColor(getTextColor());



            edLitr.setBackgroundColor(getEditTextActivityColor());
            edLitr.setTextColor(getEditTextColor());
            edmmLi.setBackgroundColor(getEditTextActivityColor());
            edmmLi.setTextColor(getEditTextColor());
            edKubSm.setBackgroundColor(getEditTextActivityColor());
            edKubSm.setTextColor(getEditTextColor());
            edKubM.setBackgroundColor(getEditTextActivityColor());
            edKubM.setTextColor(getEditTextColor());
            edKubFut.setBackgroundColor(getEditTextActivityColor());
            edKubFut.setTextColor(getEditTextColor());
            edKubDuim.setBackgroundColor(getEditTextActivityColor());
            edKubDuim.setTextColor(getEditTextColor());
            edAmGal.setBackgroundColor(getEditTextActivityColor());
            edAmGal.setTextColor(getEditTextColor());
            edAmKvarta.setBackgroundColor(getEditTextActivityColor());
            edAmKvarta.setTextColor(getEditTextColor());
            edAmPin.setBackgroundColor(getEditTextActivityColor());
            edAmPin.setTextColor(getEditTextColor());
            edAmCup.setBackgroundColor(getEditTextActivityColor());
            edAmCup.setTextColor(getEditTextColor());
            edAmUnci.setBackgroundColor(getEditTextActivityColor());
            edAmUnci.setTextColor(getEditTextColor());
            edAmStLozhka.setBackgroundColor(getEditTextActivityColor());
            edAmStLozhka.setTextColor(getEditTextColor());

            edAmTeaLozhka.setBackgroundColor(getEditTextActivityColor());
            edAmTeaLozhka.setTextColor(getEditTextColor());
            edBrGal.setBackgroundColor(getEditTextActivityColor());
            edBrGal.setTextColor(getEditTextColor());
            edBrPint.setBackgroundColor(getEditTextActivityColor());
            edBrPint.setTextColor(getEditTextColor());
            edBrCup.setBackgroundColor(getEditTextActivityColor());
            edBrCup.setTextColor(getEditTextColor());
            edBrCtolLozhka.setBackgroundColor(getEditTextActivityColor());
            edBrCtolLozhka.setTextColor(getEditTextColor());
            edBrTeaLozhka.setBackgroundColor(getEditTextActivityColor());
            edBrTeaLozhka.setTextColor(getEditTextColor());
            edBarrel.setBackgroundColor(getEditTextActivityColor());
            edBarrel.setTextColor(getEditTextColor());
            edBrUnci.setBackgroundColor(getEditTextActivityColor());
            edBrUnci.setTextColor(getEditTextColor());



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



                    edLitr.setText("");
                    edmmLi.setText("");
                    edKubSm.setText("");
                    edKubM.setText("");
                    edKubFut.setText("");
                    edKubDuim.setText("");
                    edAmGal.setText("");
                    edAmKvarta.setText("");
                    edAmPin.setText("");
                    edAmCup.setText("");
                    edAmUnci.setText("");
                    edAmStLozhka.setText("");
                    edAmTeaLozhka.setText("");
                    edBrGal.setText("");
                    edBrPint.setText("");
                    edBrCup.setText("");
                    edBrCtolLozhka.setText("");
                    edBrTeaLozhka.setText("");
                    edBrUnci.setText("");
                    edBarrel.setText("");


                    return;

                }

                num = Double.parseDouble(edNum.getText().toString());

                switch (position){
                    case 0:
                        result = (num + 0);
                        edLitr.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 1000);
                        edmmLi.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 1000);
                        edKubSm.setText(String.valueOf(roundUp(result,4)));
                        result = (num / 1000);
                        edKubM.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.0353);
                        edKubFut.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 61.0237);
                        edKubDuim.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.2641);
                        edAmGal.setText(String.valueOf(roundUp(result,4)));
                        result = (num*1.05669);
                        edAmKvarta.setText(String.valueOf(roundUp(result,4)));
                        result = (num*2.113);
                        edAmPin.setText(String.valueOf(roundUp(result,4)));
                        result = (num*4.166);
                        edAmCup.setText(String.valueOf(roundUp(result,4)));
                        result = (num *33.81);
                        edAmUnci.setText(String.valueOf(roundUp(result,4)));
                        result = (num*67.63);
                        edAmStLozhka.setText(String.valueOf(roundUp(result,4)));
                        result = (num *202.9);
                        edAmTeaLozhka.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.22);
                        edBrGal.setText(String.valueOf(roundUp(result,4)));
                        result = (num *1.76);
                        edBrPint.setText(String.valueOf(roundUp(result,4)));
                        result = (num *3.52);
                        edBrCup.setText(String.valueOf(roundUp(result,4)));
                        result = (num *56.32);
                        edBrCtolLozhka.setText(String.valueOf(roundUp(result,4)));
                        result = (num*169);
                        edBrTeaLozhka.setText(String.valueOf(roundUp(result,4)));
                        result = (num*35.2);
                        edBrUnci.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.00629);
                        edBarrel.setText(String.valueOf(roundUp(result,4)));

                        break;

                    case 1:
                        result = (num * 0.001);
                        edLitr.setText(String.valueOf(roundUp(result,4)));
                        result = (num +0);
                        edmmLi.setText(String.valueOf(roundUp(result,4)));
                        result = (num +0);
                        edKubSm.setText(String.valueOf(roundUp(result,4)));
                        result = (num *1e-6);
                        edKubM.setText(String.valueOf(roundUp(result,4)));
                        result = (num*3.54e-5);
                        edKubFut.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.06102);
                        edKubDuim.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.000264);
                        edAmGal.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.001057);
                        edAmKvarta.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.00212);
                        edAmPin.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.004167);
                        edAmCup.setText(String.valueOf(roundUp(result,4)));
                        result = (num *0.03382);
                        edAmUnci.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.06763);
                        edAmStLozhka.setText(String.valueOf(roundUp(result,4)));
                        result = (num *0.2029);
                        edAmTeaLozhka.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.00022);
                        edBrGal.setText(String.valueOf(roundUp(result,4)));
                        result = (num *0.00176);
                        edBrPint.setText(String.valueOf(roundUp(result,4)));
                        result = (num *0.00352);
                        edBrCup.setText(String.valueOf(roundUp(result,4)));
                        result = (num *0.05632);
                        edBrCtolLozhka.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.169);
                        edBrTeaLozhka.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.0352);
                        edBrUnci.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.00000629);
                        edBarrel.setText(String.valueOf(roundUp(result,4)));
                        break;

                    case 2:
                        result = (num * 0.001);
                        edLitr.setText(String.valueOf(roundUp(result,4)));
                        result = (num +0);
                        edmmLi.setText(String.valueOf(roundUp(result,4)));
                        result = (num +0);
                        edKubSm.setText(String.valueOf(roundUp(result,4)));
                        result = (num *1e-6);
                        edKubM.setText(String.valueOf(roundUp(result,4)));
                        result = (num*3.54e-5);
                        edKubFut.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.06102);
                        edKubDuim.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.000264);
                        edAmGal.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.001057);
                        edAmKvarta.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.00212);
                        edAmPin.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.004167);
                        edAmCup.setText(String.valueOf(roundUp(result,4)));
                        result = (num *0.03382);
                        edAmUnci.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.06763);
                        edAmStLozhka.setText(String.valueOf(roundUp(result,4)));
                        result = (num *0.2029);
                        edAmTeaLozhka.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.00022);
                        edBrGal.setText(String.valueOf(roundUp(result,4)));
                        result = (num *0.00176);
                        edBrPint.setText(String.valueOf(roundUp(result,4)));
                        result = (num *0.00352);
                        edBrCup.setText(String.valueOf(roundUp(result,4)));
                        result = (num *0.05632);
                        edBrCtolLozhka.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.169);
                        edBrTeaLozhka.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.0352);
                        edBrUnci.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.00000629);
                        edBarrel.setText(String.valueOf(roundUp(result,4)));
                        break;

                    case 3:
                        result = (num * 1000);
                        edLitr.setText(String.valueOf(roundUp(result,4)));
                        result = (num *1e+6);
                        edmmLi.setText(String.valueOf(roundUp(result,4)));
                        result = (num *1e+6);
                        edKubSm.setText(String.valueOf(roundUp(result,4)));
                        result = (num +0);
                        edKubM.setText(String.valueOf(roundUp(result,4)));
                        result = (num*35.315);
                        edKubFut.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 61023.8);
                        edKubDuim.setText(String.valueOf(roundUp(result,4)));
                        result = (num*264.18);
                        edAmGal.setText(String.valueOf(roundUp(result,4)));
                        result = (num*1056.7);
                        edAmKvarta.setText(String.valueOf(roundUp(result,4)));
                        result = (num*2113.4);
                        edAmPin.setText(String.valueOf(roundUp(result,4)));
                        result = (num*4166.7);
                        edAmCup.setText(String.valueOf(roundUp(result,4)));
                        result = (num *33814.3);
                        edAmUnci.setText(String.valueOf(roundUp(result,4)));
                        result = (num*67628);
                        edAmStLozhka.setText(String.valueOf(roundUp(result,4)));
                        result = (num *202884);
                        edAmTeaLozhka.setText(String.valueOf(roundUp(result,4)));
                        result = (num*219.97);
                        edBrGal.setText(String.valueOf(roundUp(result,4)));
                        result = (num *1759.8);
                        edBrPint.setText(String.valueOf(roundUp(result,4)));
                        result = (num *3519.51);
                        edBrCup.setText(String.valueOf(roundUp(result,4)));
                        result = (num *56312.2);
                        edBrCtolLozhka.setText(String.valueOf(roundUp(result,4)));
                        result = (num*168936);
                        edBrTeaLozhka.setText(String.valueOf(roundUp(result,4)));
                        result = (num*35195.1);
                        edBrUnci.setText(String.valueOf(roundUp(result,4)));
                        result = (num*6.29);
                        edBarrel.setText(String.valueOf(roundUp(result,4)));
                        break;

                    case 4:
                        result = (num * 28.32);
                        edLitr.setText(String.valueOf(roundUp(result,4)));
                        result = (num *28316.8);
                        edmmLi.setText(String.valueOf(roundUp(result,4)));
                        result = (num *28316.8);
                        edKubSm.setText(String.valueOf(roundUp(result,4)));
                        result = (num *0.028317);
                        edKubM.setText(String.valueOf(roundUp(result,4)));
                        result = (num+0);
                        edKubFut.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 1728);
                        edKubDuim.setText(String.valueOf(roundUp(result,4)));
                        result = (num*7.481);
                        edAmGal.setText(String.valueOf(roundUp(result,4)));
                        result = (num*29.9221);
                        edAmKvarta.setText(String.valueOf(roundUp(result,4)));
                        result = (num*59.845);
                        edAmPin.setText(String.valueOf(roundUp(result,4)));
                        result = (num*117.99);
                        edAmCup.setText(String.valueOf(roundUp(result,4)));
                        result = (num *957.51);
                        edAmUnci.setText(String.valueOf(roundUp(result,4)));
                        result = (num*1915.02);
                        edAmStLozhka.setText(String.valueOf(roundUp(result,4)));
                        result = (num *5745.05);
                        edAmTeaLozhka.setText(String.valueOf(roundUp(result,4)));
                        result = (num*6.2289);
                        edBrGal.setText(String.valueOf(roundUp(result,4)));
                        result = (num *49.831);
                        edBrPint.setText(String.valueOf(roundUp(result,4)));
                        result = (num *99.67);
                        edBrCup.setText(String.valueOf(roundUp(result,4)));
                        result = (num *1594.59);
                        edBrCtolLozhka.setText(String.valueOf(roundUp(result,4)));
                        result = (num*4783.75);
                        edBrTeaLozhka.setText(String.valueOf(roundUp(result,4)));
                        result = (num*996.62);
                        edBrUnci.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.1781);
                        edBarrel.setText(String.valueOf(roundUp(result,4)));
                        break;

                    case 5:
                        result = (num * 0.016388);
                        edLitr.setText(String.valueOf(roundUp(result,4)));
                        result = (num *16.3871);
                        edmmLi.setText(String.valueOf(roundUp(result,4)));
                        result = (num *16.3871);
                        edKubSm.setText(String.valueOf(roundUp(result,4)));
                        result = (num *1.6387e-5);
                        edKubM.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.000578705);
                        edKubFut.setText(String.valueOf(roundUp(result,4)));
                        result = (num +0);
                        edKubDuim.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.004329);
                        edAmGal.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.017316);
                        edAmKvarta.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.034632);
                        edAmPin.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.06828);
                        edAmCup.setText(String.valueOf(roundUp(result,4)));
                        result = (num *0.554113);
                        edAmUnci.setText(String.valueOf(roundUp(result,4)));
                        result = (num*1.10823);
                        edAmStLozhka.setText(String.valueOf(roundUp(result,4)));
                        result = (num *3.32468);
                        edAmTeaLozhka.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.00360466);
                        edBrGal.setText(String.valueOf(roundUp(result,4)));
                        result = (num *0.0288372);
                        edBrPint.setText(String.valueOf(roundUp(result,4)));
                        result = (num *0.05768);
                        edBrCup.setText(String.valueOf(roundUp(result,4)));
                        result = (num *0.9228);
                        edBrCtolLozhka.setText(String.valueOf(roundUp(result,4)));
                        result = (num*2.76837);
                        edBrTeaLozhka.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.554113);
                        edBrUnci.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.0001031);
                        edBarrel.setText(String.valueOf(roundUp(result,4)));
                        break;

                    case 6:
                        result = (num * 3.78541);
                        edLitr.setText(String.valueOf(roundUp(result,4)));
                        result = (num *3785.42);
                        edmmLi.setText(String.valueOf(roundUp(result,4)));
                        result = (num *3785.42);
                        edKubSm.setText(String.valueOf(roundUp(result,4)));
                        result = (num *0.00378542);
                        edKubM.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.133681);
                        edKubFut.setText(String.valueOf(roundUp(result,4)));
                        result = (num *231);
                        edKubDuim.setText(String.valueOf(roundUp(result,4)));
                        result = (num+0);
                        edAmGal.setText(String.valueOf(roundUp(result,4)));
                        result = (num*4);
                        edAmKvarta.setText(String.valueOf(roundUp(result,4)));
                        result = (num*8);
                        edAmPin.setText(String.valueOf(roundUp(result,4)));
                        result = (num*15.772);
                        edAmCup.setText(String.valueOf(roundUp(result,4)));
                        result = (num *128);
                        edAmUnci.setText(String.valueOf(roundUp(result,4)));
                        result = (num*256);
                        edAmStLozhka.setText(String.valueOf(roundUp(result,4)));
                        result = (num *768);
                        edAmTeaLozhka.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.84);
                        edBrGal.setText(String.valueOf(roundUp(result,4)));
                        result = (num *6.66139);
                        edBrPint.setText(String.valueOf(roundUp(result,4)));
                        result = (num *13.323);
                        edBrCup.setText(String.valueOf(roundUp(result,4)));
                        result = (num *213.165);
                        edBrCtolLozhka.setText(String.valueOf(roundUp(result,4)));
                        result = (num*639.5);
                        edBrTeaLozhka.setText(String.valueOf(roundUp(result,4)));
                        result = (num*133.23);
                        edBrUnci.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.02381);
                        edBarrel.setText(String.valueOf(roundUp(result,4)));
                        break;

                    case 7:
                        result = (num * 0.9464);
                        edLitr.setText(String.valueOf(roundUp(result,4)));
                        result = (num *946.36);
                        edmmLi.setText(String.valueOf(roundUp(result,4)));
                        result = (num *946.36);
                        edKubSm.setText(String.valueOf(roundUp(result,4)));
                        result = (num *0.00094636);
                        edKubM.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.0334201);
                        edKubFut.setText(String.valueOf(roundUp(result,4)));
                        result = (num *57.75);
                        edKubDuim.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.25);
                        edAmGal.setText(String.valueOf(roundUp(result,4)));
                        result = (num+0);
                        edAmKvarta.setText(String.valueOf(roundUp(result,4)));
                        result = (num*2);
                        edAmPin.setText(String.valueOf(roundUp(result,4)));
                        result = (num*3.9439);
                        edAmCup.setText(String.valueOf(roundUp(result,4)));
                        result = (num *32);
                        edAmUnci.setText(String.valueOf(roundUp(result,4)));
                        result = (num*64);
                        edAmStLozhka.setText(String.valueOf(roundUp(result,4)));
                        result = (num *192);
                        edAmTeaLozhka.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.20817);
                        edBrGal.setText(String.valueOf(roundUp(result,4)));
                        result = (num *1.6654);
                        edBrPint.setText(String.valueOf(roundUp(result,4)));
                        result = (num *3.3307);
                        edBrCup.setText(String.valueOf(roundUp(result,4)));
                        result = (num *53.3);
                        edBrCtolLozhka.setText(String.valueOf(roundUp(result,4)));
                        result = (num*159.873);
                        edBrTeaLozhka.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.005952);
                        edBarrel.setText(String.valueOf(roundUp(result,4)));
                        break;

                    case 8:
                        result = (num * 0.475);
                        edLitr.setText(String.valueOf(roundUp(result,4)));
                        result = (num *473.18);
                        edmmLi.setText(String.valueOf(roundUp(result,4)));
                        result = (num *473.18);
                        edKubSm.setText(String.valueOf(roundUp(result,4)));
                        result = (num *0.000475);
                        edKubM.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.01672);
                        edKubFut.setText(String.valueOf(roundUp(result,4)));
                        result = (num *28.875);
                        edKubDuim.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.125);
                        edAmGal.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.5);
                        edAmKvarta.setText(String.valueOf(roundUp(result,4)));
                        result = (num+0);
                        edAmPin.setText(String.valueOf(roundUp(result,4)));
                        result = (num*1.98);
                        edAmCup.setText(String.valueOf(roundUp(result,4)));
                        result = (num *16);
                        edAmUnci.setText(String.valueOf(roundUp(result,4)));
                        result = (num*32);
                        edAmStLozhka.setText(String.valueOf(roundUp(result,4)));
                        result = (num *96);
                        edAmTeaLozhka.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.1041);
                        edBrGal.setText(String.valueOf(roundUp(result,4)));
                        result = (num *0.8327);
                        edBrPint.setText(String.valueOf(roundUp(result,4)));
                        result = (num *1.667);
                        edBrCup.setText(String.valueOf(roundUp(result,4)));
                        result = (num *26.646);
                        edBrCtolLozhka.setText(String.valueOf(roundUp(result,4)));
                        result = (num*79.94);
                        edBrTeaLozhka.setText(String.valueOf(roundUp(result,4)));
                        result = (num*16.66);
                        edBrUnci.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.002976);
                        edBarrel.setText(String.valueOf(roundUp(result,4)));
                        break;

                    case 9:
                        result = (num * 0.24);
                        edLitr.setText(String.valueOf(roundUp(result,4)));
                        result = (num *240);
                        edmmLi.setText(String.valueOf(roundUp(result,4)));
                        result = (num *240);
                        edKubSm.setText(String.valueOf(roundUp(result,4)));
                        result = (num *0.00024);
                        edKubM.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.008475);
                        edKubFut.setText(String.valueOf(roundUp(result,4)));
                        result = (num *14.646);
                        edKubDuim.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.063402);
                        edAmGal.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.2537);
                        edAmKvarta.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.508);
                        edAmPin.setText(String.valueOf(roundUp(result,4)));
                        result = (num+0);
                        edAmCup.setText(String.valueOf(roundUp(result,4)));
                        result = (num *8.1157);
                        edAmUnci.setText(String.valueOf(roundUp(result,4)));
                        result = (num*16.24);
                        edAmStLozhka.setText(String.valueOf(roundUp(result,4)));
                        result = (num *48.7);
                        edAmTeaLozhka.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.0528);
                        edBrGal.setText(String.valueOf(roundUp(result,4)));
                        result = (num *0.42235);
                        edBrPint.setText(String.valueOf(roundUp(result,4)));
                        result = (num *0.8447);
                        edBrCup.setText(String.valueOf(roundUp(result,4)));
                        result = (num *13.52);
                        edBrCtolLozhka.setText(String.valueOf(roundUp(result,4)));
                        result = (num*40.545);
                        edBrTeaLozhka.setText(String.valueOf(roundUp(result,4)));
                        result = (num*8.447);
                        edBrUnci.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.001488);
                        edBarrel.setText(String.valueOf(roundUp(result,4)));
                        break;

                    case 10:
                        result = (num * 0.0296);
                        edLitr.setText(String.valueOf(roundUp(result,4)));
                        result = (num *29.574);
                        edmmLi.setText(String.valueOf(roundUp(result,4)));
                        result = (num *29.574);
                        edKubSm.setText(String.valueOf(roundUp(result,4)));
                        result = (num *2.9574e-5);
                        edKubM.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.0010444);
                        edKubFut.setText(String.valueOf(roundUp(result,4)));
                        result = (num *1.8047);
                        edKubDuim.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.00782);
                        edAmGal.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.03125);
                        edAmKvarta.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.0625);
                        edAmPin.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.12323);
                        edAmCup.setText(String.valueOf(roundUp(result,4)));
                        result = (num +0);
                        edAmUnci.setText(String.valueOf(roundUp(result,4)));
                        result = (num*2);
                        edAmStLozhka.setText(String.valueOf(roundUp(result,4)));
                        result = (num *6);
                        edAmTeaLozhka.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.0065053);
                        edBrGal.setText(String.valueOf(roundUp(result,4)));
                        result = (num *0.052043);
                        edBrPint.setText(String.valueOf(roundUp(result,4)));
                        result = (num *0.10409);
                        edBrCup.setText(String.valueOf(roundUp(result,4)));
                        result = (num *1.6654);
                        edBrCtolLozhka.setText(String.valueOf(roundUp(result,4)));
                        result = (num*4.9961);
                        edBrTeaLozhka.setText(String.valueOf(roundUp(result,4)));
                        result = (num*1.0409);
                        edBrUnci.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.000186);
                        edBarrel.setText(String.valueOf(roundUp(result,4)));
                        break;

                    case 11:
                        result = (num * 0.01479);
                        edLitr.setText(String.valueOf(roundUp(result,4)));
                        result = (num *14.79);
                        edmmLi.setText(String.valueOf(roundUp(result,4)));
                        result = (num *14.79);
                        edKubSm.setText(String.valueOf(roundUp(result,4)));
                        result = (num *1.4787e-5);
                        edKubM.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.0005222);
                        edKubFut.setText(String.valueOf(roundUp(result,4)));
                        result = (num *0.90235);
                        edKubDuim.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.0039063);
                        edAmGal.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.01563);
                        edAmKvarta.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.03125);
                        edAmPin.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.06162);
                        edAmCup.setText(String.valueOf(roundUp(result,4)));
                        result = (num *0.5);
                        edAmUnci.setText(String.valueOf(roundUp(result,4)));
                        result = (num+0);
                        edAmStLozhka.setText(String.valueOf(roundUp(result,4)));
                        result = (num *3);
                        edAmTeaLozhka.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.0032527);
                        edBrGal.setText(String.valueOf(roundUp(result,4)));
                        result = (num *0.026022);
                        edBrPint.setText(String.valueOf(roundUp(result,4)));
                        result = (num *0.052043);
                        edBrCup.setText(String.valueOf(roundUp(result,4)));
                        result = (num *0.83268);
                        edBrCtolLozhka.setText(String.valueOf(roundUp(result,4)));
                        result = (num*2.5);
                        edBrTeaLozhka.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.52);
                        edBrUnci.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.00009301);
                        edBarrel.setText(String.valueOf(roundUp(result,4)));
                        break;

                    case 12:
                        result = (num * 0.00493);
                        edLitr.setText(String.valueOf(roundUp(result,4)));
                        result = (num *4.93);
                        edmmLi.setText(String.valueOf(roundUp(result,4)));
                        result = (num *4.93);
                        edKubSm.setText(String.valueOf(roundUp(result,4)));
                        result = (num *4.93e-6);
                        edKubM.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.000175);
                        edKubFut.setText(String.valueOf(roundUp(result,4)));
                        result = (num *0.3008);
                        edKubDuim.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.001303);
                        edAmGal.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.005209);
                        edAmKvarta.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.010417);
                        edAmPin.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.02054);
                        edAmCup.setText(String.valueOf(roundUp(result,4)));
                        result = (num *0.167);
                        edAmUnci.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.3336);
                        edAmStLozhka.setText(String.valueOf(roundUp(result,4)));
                        result = (num +0);
                        edAmTeaLozhka.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.001085);
                        edBrGal.setText(String.valueOf(roundUp(result,4)));
                        result = (num *0.008675);
                        edBrPint.setText(String.valueOf(roundUp(result,4)));
                        result = (num *0.01735);
                        edBrCup.setText(String.valueOf(roundUp(result,4)));
                        result = (num *0.2776);
                        edBrCtolLozhka.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.8327);
                        edBrTeaLozhka.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.1735);
                        edBrUnci.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.000031);
                        edBarrel.setText(String.valueOf(roundUp(result,4)));
                        break;

                    case 13:
                        result = (num * 4.546);
                        edLitr.setText(String.valueOf(roundUp(result,4)));
                        result = (num *4546);
                        edmmLi.setText(String.valueOf(roundUp(result,4)));
                        result = (num *4546);
                        edKubSm.setText(String.valueOf(roundUp(result,4)));
                        result = (num *0.004546);
                        edKubM.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.16055);
                        edKubFut.setText(String.valueOf(roundUp(result,4)));
                        result = (num *277.42);
                        edKubDuim.setText(String.valueOf(roundUp(result,4)));
                        result = (num*1.201);
                        edAmGal.setText(String.valueOf(roundUp(result,4)));
                        result = (num*4.804);
                        edAmKvarta.setText(String.valueOf(roundUp(result,4)));
                        result = (num*9.608);
                        edAmPin.setText(String.valueOf(roundUp(result,4)));
                        result = (num*18.95);
                        edAmCup.setText(String.valueOf(roundUp(result,4)));
                        result = (num *153.722);
                        edAmUnci.setText(String.valueOf(roundUp(result,4)));
                        result = (num*307.44);
                        edAmStLozhka.setText(String.valueOf(roundUp(result,4)));
                        result = (num *922.33);
                        edAmTeaLozhka.setText(String.valueOf(roundUp(result,4)));
                        result = (num+0);
                        edBrGal.setText(String.valueOf(roundUp(result,4)));
                        result = (num *8);
                        edBrPint.setText(String.valueOf(roundUp(result,4)));
                        result = (num *16);
                        edBrCup.setText(String.valueOf(roundUp(result,4)));
                        result = (num *256);
                        edBrCtolLozhka.setText(String.valueOf(roundUp(result,4)));
                        result = (num*768);
                        edBrTeaLozhka.setText(String.valueOf(roundUp(result,4)));
                        result = (num*160);
                        edBrUnci.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.02859);
                        edBarrel.setText(String.valueOf(roundUp(result,4)));
                        break;

                    case 14:
                        result = (num * 0.569);
                        edLitr.setText(String.valueOf(roundUp(result,4)));
                        result = (num *569);
                        edmmLi.setText(String.valueOf(roundUp(result,4)));
                        result = (num *569);
                        edKubSm.setText(String.valueOf(roundUp(result,4)));
                        result = (num *0.000569);
                        edKubM.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.02007);
                        edKubFut.setText(String.valueOf(roundUp(result,4)));
                        result = (num *34.68);
                        edKubDuim.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.1502);
                        edAmGal.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.6005);
                        edAmKvarta.setText(String.valueOf(roundUp(result,4)));
                        result = (num*1.201);
                        edAmPin.setText(String.valueOf(roundUp(result,4)));
                        result = (num*2.368);
                        edAmCup.setText(String.valueOf(roundUp(result,4)));
                        result = (num *19.216);
                        edAmUnci.setText(String.valueOf(roundUp(result,4)));
                        result = (num*38.44);
                        edAmStLozhka.setText(String.valueOf(roundUp(result,4)));
                        result = (num *115.3);
                        edAmTeaLozhka.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.125);
                        edBrGal.setText(String.valueOf(roundUp(result,4)));
                        result = (num +0);
                        edBrPint.setText(String.valueOf(roundUp(result,4)));
                        result = (num *2);
                        edBrCup.setText(String.valueOf(roundUp(result,4)));
                        result = (num *32);
                        edBrCtolLozhka.setText(String.valueOf(roundUp(result,4)));
                        result = (num*96);
                        edBrTeaLozhka.setText(String.valueOf(roundUp(result,4)));
                        result = (num*20);
                        edBrUnci.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.003574);
                        edBarrel.setText(String.valueOf(roundUp(result,4)));
                        break;

                    case 15:
                        result = (num * 0.284);
                        edLitr.setText(String.valueOf(roundUp(result,4)));
                        result = (num *284.2);
                        edmmLi.setText(String.valueOf(roundUp(result,4)));
                        result = (num *284.2);
                        edKubSm.setText(String.valueOf(roundUp(result,4)));
                        result = (num *0.0002842);
                        edKubM.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.01004);
                        edKubFut.setText(String.valueOf(roundUp(result,4)));
                        result = (num *17.34);
                        edKubDuim.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.0751);
                        edAmGal.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.3003);
                        edAmKvarta.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.6005);
                        edAmPin.setText(String.valueOf(roundUp(result,4)));
                        result = (num*1.184);
                        edAmCup.setText(String.valueOf(roundUp(result,4)));
                        result = (num *9.6);
                        edAmUnci.setText(String.valueOf(roundUp(result,4)));
                        result = (num*19.22);
                        edAmStLozhka.setText(String.valueOf(roundUp(result,4)));
                        result = (num *57.65);
                        edAmTeaLozhka.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.0625);
                        edBrGal.setText(String.valueOf(roundUp(result,4)));
                        result = (num *0.5);
                        edBrPint.setText(String.valueOf(roundUp(result,4)));
                        result = (num +0);
                        edBrCup.setText(String.valueOf(roundUp(result,4)));
                        result = (num *16);
                        edBrCtolLozhka.setText(String.valueOf(roundUp(result,4)));
                        result = (num*48);
                        edBrTeaLozhka.setText(String.valueOf(roundUp(result,4)));
                        result = (num*10);
                        edBrUnci.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.001787);
                        edBarrel.setText(String.valueOf(roundUp(result,4)));
                        break;

                    case 16:
                        result = (num * 0.01776);
                        edLitr.setText(String.valueOf(roundUp(result,4)));
                        result = (num *17.76);
                        edmmLi.setText(String.valueOf(roundUp(result,4)));
                        result = (num *17.76);
                        edKubSm.setText(String.valueOf(roundUp(result,4)));
                        result = (num *1.7758e-5);
                        edKubM.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.0006272);
                        edKubFut.setText(String.valueOf(roundUp(result,4)));
                        result = (num *1.0837);
                        edKubDuim.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.0047);
                        edAmGal.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.01877);
                        edAmKvarta.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.0376);
                        edAmPin.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.074);
                        edAmCup.setText(String.valueOf(roundUp(result,4)));
                        result = (num *0.6005);
                        edAmUnci.setText(String.valueOf(roundUp(result,4)));
                        result = (num*1.201);
                        edAmStLozhka.setText(String.valueOf(roundUp(result,4)));
                        result = (num *3.603);
                        edAmTeaLozhka.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.00390625);
                        edBrGal.setText(String.valueOf(roundUp(result,4)));
                        result = (num *0.03125);
                        edBrPint.setText(String.valueOf(roundUp(result,4)));
                        result = (num *0.0625);
                        edBrCup.setText(String.valueOf(roundUp(result,4)));
                        result = (num +0);
                        edBrCtolLozhka.setText(String.valueOf(roundUp(result,4)));
                        result = (num*3);
                        edBrTeaLozhka.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.625);
                        edBrUnci.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.0001116);
                        edBarrel.setText(String.valueOf(roundUp(result,4)));
                        break;

                    case 17:
                        result = (num * 0.00592);
                        edLitr.setText(String.valueOf(roundUp(result,4)));
                        result = (num *5.92);
                        edmmLi.setText(String.valueOf(roundUp(result,4)));
                        result = (num *5.92);
                        edKubSm.setText(String.valueOf(roundUp(result,4)));
                        result = (num *5.9194e-6);
                        edKubM.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.00020905);
                        edKubFut.setText(String.valueOf(roundUp(result,4)));
                        result = (num *0.3613);
                        edKubDuim.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.001564);
                        edAmGal.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.006255);
                        edAmKvarta.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.01251);
                        edAmPin.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.02467);
                        edAmCup.setText(String.valueOf(roundUp(result,4)));
                        result = (num *0.2002);
                        edAmUnci.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.4004);
                        edAmStLozhka.setText(String.valueOf(roundUp(result,4)));
                        result = (num *1.201);
                        edAmTeaLozhka.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.001303);
                        edBrGal.setText(String.valueOf(roundUp(result,4)));
                        result = (num *0.01042);
                        edBrPint.setText(String.valueOf(roundUp(result,4)));
                        result = (num *0.02084);
                        edBrCup.setText(String.valueOf(roundUp(result,4)));
                        result = (num *0.33);
                        edBrCtolLozhka.setText(String.valueOf(roundUp(result,4)));
                        result = (num+0);
                        edBrTeaLozhka.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.2084);
                        edBrUnci.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.0000372);
                        edBarrel.setText(String.valueOf(roundUp(result,4)));
                        break;

                    case 18:
                        result = (num * 0.02842);
                        edLitr.setText(String.valueOf(roundUp(result,4)));
                        result = (num *28.42);
                        edmmLi.setText(String.valueOf(roundUp(result,4)));
                        result = (num *28.42);
                        edKubSm.setText(String.valueOf(roundUp(result,4)));
                        result = (num *2.8413e-5);
                        edKubM.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.001004);
                        edKubFut.setText(String.valueOf(roundUp(result,4)));
                        result = (num *1.734);
                        edKubDuim.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.00751);
                        edAmGal.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.03004);
                        edAmKvarta.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.0601);
                        edAmPin.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.1184);
                        edAmCup.setText(String.valueOf(roundUp(result,4)));
                        result = (num *0.961);
                        edAmUnci.setText(String.valueOf(roundUp(result,4)));
                        result = (num*1.922);
                        edAmStLozhka.setText(String.valueOf(roundUp(result,4)));
                        result = (num *5.765);
                        edAmTeaLozhka.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.00625);
                        edBrGal.setText(String.valueOf(roundUp(result,4)));
                        result = (num *0.05);
                        edBrPint.setText(String.valueOf(roundUp(result,4)));
                        result = (num *0.1);
                        edBrCup.setText(String.valueOf(roundUp(result,4)));
                        result = (num *1.6);
                        edBrCtolLozhka.setText(String.valueOf(roundUp(result,4)));
                        result = (num*4.8);
                        edBrTeaLozhka.setText(String.valueOf(roundUp(result,4)));
                        result = (num+0);
                        edBrUnci.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.0001787);
                        edBarrel.setText(String.valueOf(roundUp(result,4)));
                        break;

                    case 19:
                        result = (num * 159);
                        edLitr.setText(String.valueOf(roundUp(result,4)));
                        result = (num *159000);
                        edmmLi.setText(String.valueOf(roundUp(result,4)));
                        result = (num *159000);
                        edKubSm.setText(String.valueOf(roundUp(result,4)));
                        result = (num *159000000);
                        edKubM.setText(String.valueOf(roundUp(result,4)));
                        result = (num*5.615);
                        edKubFut.setText(String.valueOf(roundUp(result,4)));
                        result = (num *9702);
                        edKubDuim.setText(String.valueOf(roundUp(result,4)));
                        result = (num*42);
                        edAmGal.setText(String.valueOf(roundUp(result,4)));
                        result = (num*168);
                        edAmKvarta.setText(String.valueOf(roundUp(result,4)));
                        result = (num*336);
                        edAmPin.setText(String.valueOf(roundUp(result,4)));
                        result = (num*672);
                        edAmCup.setText(String.valueOf(roundUp(result,4)));
                        result = (num *5376);
                        edAmUnci.setText(String.valueOf(roundUp(result,4)));
                        result = (num*10750);
                        edAmStLozhka.setText(String.valueOf(roundUp(result,4)));
                        result = (num *32260);
                        edAmTeaLozhka.setText(String.valueOf(roundUp(result,4)));
                        result = (num*34.97);
                        edBrGal.setText(String.valueOf(roundUp(result,4)));
                        result = (num *279.8);
                        edBrPint.setText(String.valueOf(roundUp(result,4)));
                        result = (num *0.001761);
                        edBrCup.setText(String.valueOf(roundUp(result,4)));
                        result = (num *0.0001113);
                        edBrCtolLozhka.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.00003711);
                        edBrTeaLozhka.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.0001787);
                        edBrUnci.setText(String.valueOf(roundUp(result,4)));
                        result = (num+0);
                        edBarrel.setText(String.valueOf(roundUp(result,4)));
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



            edLitr.setText("");
            edmmLi.setText("");
            edKubSm.setText("");
            edKubM.setText("");
            edKubFut.setText("");
            edKubDuim.setText("");
            edAmGal.setText("");
            edAmKvarta.setText("");
            edAmPin.setText("");
            edAmCup.setText("");
            edAmUnci.setText("");
            edAmStLozhka.setText("");
            edAmTeaLozhka.setText("");
            edBrGal.setText("");
            edBrPint.setText("");
            edBrCup.setText("");
            edBrCtolLozhka.setText("");
            edBrTeaLozhka.setText("");
            edBrUnci.setText("");
            edBarrel.setText("");


            return;

        }

        num = Double.parseDouble(edNum.getText().toString());

        switch (a) {
            case 0:
                result = (num + 0);
                edLitr.setText(String.valueOf(roundUp(result,4)));
                result = (num * 1000);
                edmmLi.setText(String.valueOf(roundUp(result,4)));
                result = (num * 1000);
                edKubSm.setText(String.valueOf(roundUp(result,4)));
                result = (num / 1000);
                edKubM.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.0353);
                edKubFut.setText(String.valueOf(roundUp(result,4)));
                result = (num * 61.0237);
                edKubDuim.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.2641);
                edAmGal.setText(String.valueOf(roundUp(result,4)));
                result = (num*1.05669);
                edAmKvarta.setText(String.valueOf(roundUp(result,4)));
                result = (num*2.113);
                edAmPin.setText(String.valueOf(roundUp(result,4)));
                result = (num*4.166);
                edAmCup.setText(String.valueOf(roundUp(result,4)));
                result = (num *33.81);
                edAmUnci.setText(String.valueOf(roundUp(result,4)));
                result = (num*67.63);
                edAmStLozhka.setText(String.valueOf(roundUp(result,4)));
                result = (num *202.9);
                edAmTeaLozhka.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.22);
                edBrGal.setText(String.valueOf(roundUp(result,4)));
                result = (num *1.76);
                edBrPint.setText(String.valueOf(roundUp(result,4)));
                result = (num *3.52);
                edBrCup.setText(String.valueOf(roundUp(result,4)));
                result = (num *56.32);
                edBrCtolLozhka.setText(String.valueOf(roundUp(result,4)));
                result = (num*169);
                edBrTeaLozhka.setText(String.valueOf(roundUp(result,4)));
                result = (num*35.2);
                edBrUnci.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.00629);
                edBarrel.setText(String.valueOf(roundUp(result,4)));


                break;

            case 1:
                result = (num * 0.001);
                edLitr.setText(String.valueOf(roundUp(result,4)));
                result = (num +0);
                edmmLi.setText(String.valueOf(roundUp(result,4)));
                result = (num +0);
                edKubSm.setText(String.valueOf(roundUp(result,4)));
                result = (num *1e-6);
                edKubM.setText(String.valueOf(roundUp(result,4)));
                result = (num*3.54e-5);
                edKubFut.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.06102);
                edKubDuim.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.000264);
                edAmGal.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.001057);
                edAmKvarta.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.00212);
                edAmPin.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.004167);
                edAmCup.setText(String.valueOf(roundUp(result,4)));
                result = (num *0.03382);
                edAmUnci.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.06763);
                edAmStLozhka.setText(String.valueOf(roundUp(result,4)));
                result = (num *0.2029);
                edAmTeaLozhka.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.00022);
                edBrGal.setText(String.valueOf(roundUp(result,4)));
                result = (num *0.00176);
                edBrPint.setText(String.valueOf(roundUp(result,4)));
                result = (num *0.00352);
                edBrCup.setText(String.valueOf(roundUp(result,4)));
                result = (num *0.05632);
                edBrCtolLozhka.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.169);
                edBrTeaLozhka.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.0352);
                edBrUnci.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.00000629);
                edBarrel.setText(String.valueOf(roundUp(result,4)));

                break;

            case 2:
                result = (num * 0.001);
                edLitr.setText(String.valueOf(roundUp(result,4)));
                result = (num +0);
                edmmLi.setText(String.valueOf(roundUp(result,4)));
                result = (num +0);
                edKubSm.setText(String.valueOf(roundUp(result,4)));
                result = (num *1e-6);
                edKubM.setText(String.valueOf(roundUp(result,4)));
                result = (num*3.54e-5);
                edKubFut.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.06102);
                edKubDuim.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.000264);
                edAmGal.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.001057);
                edAmKvarta.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.00212);
                edAmPin.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.004167);
                edAmCup.setText(String.valueOf(roundUp(result,4)));
                result = (num *0.03382);
                edAmUnci.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.06763);
                edAmStLozhka.setText(String.valueOf(roundUp(result,4)));
                result = (num *0.2029);
                edAmTeaLozhka.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.00022);
                edBrGal.setText(String.valueOf(roundUp(result,4)));
                result = (num *0.00176);
                edBrPint.setText(String.valueOf(roundUp(result,4)));
                result = (num *0.00352);
                edBrCup.setText(String.valueOf(roundUp(result,4)));
                result = (num *0.05632);
                edBrCtolLozhka.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.169);
                edBrTeaLozhka.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.0352);
                edBrUnci.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.00000629);
                edBarrel.setText(String.valueOf(roundUp(result,4)));

                break;

            case 3:
                result = (num * 1000);
                edLitr.setText(String.valueOf(roundUp(result,4)));
                result = (num *1e+6);
                edmmLi.setText(String.valueOf(roundUp(result,4)));
                result = (num *1e+6);
                edKubSm.setText(String.valueOf(roundUp(result,4)));
                result = (num +0);
                edKubM.setText(String.valueOf(roundUp(result,4)));
                result = (num*35.315);
                edKubFut.setText(String.valueOf(roundUp(result,4)));
                result = (num * 61023.8);
                edKubDuim.setText(String.valueOf(roundUp(result,4)));
                result = (num*264.18);
                edAmGal.setText(String.valueOf(roundUp(result,4)));
                result = (num*1056.7);
                edAmKvarta.setText(String.valueOf(roundUp(result,4)));
                result = (num*2113.4);
                edAmPin.setText(String.valueOf(roundUp(result,4)));
                result = (num*4166.7);
                edAmCup.setText(String.valueOf(roundUp(result,4)));
                result = (num *33814.3);
                edAmUnci.setText(String.valueOf(roundUp(result,4)));
                result = (num*67628);
                edAmStLozhka.setText(String.valueOf(roundUp(result,4)));
                result = (num *202884);
                edAmTeaLozhka.setText(String.valueOf(roundUp(result,4)));
                result = (num*219.97);
                edBrGal.setText(String.valueOf(roundUp(result,4)));
                result = (num *1759.8);
                edBrPint.setText(String.valueOf(roundUp(result,4)));
                result = (num *3519.51);
                edBrCup.setText(String.valueOf(roundUp(result,4)));
                result = (num *56312.2);
                edBrCtolLozhka.setText(String.valueOf(roundUp(result,4)));
                result = (num*168936);
                edBrTeaLozhka.setText(String.valueOf(roundUp(result,4)));
                result = (num*35195.1);
                edBrUnci.setText(String.valueOf(roundUp(result,4)));
                result = (num*6.29);
                edBarrel.setText(String.valueOf(roundUp(result,4)));

                break;

            case 4:
                result = (num * 28.32);
                edLitr.setText(String.valueOf(roundUp(result,4)));
                result = (num *28316.8);
                edmmLi.setText(String.valueOf(roundUp(result,4)));
                result = (num *28316.8);
                edKubSm.setText(String.valueOf(roundUp(result,4)));
                result = (num *0.028317);
                edKubM.setText(String.valueOf(roundUp(result,4)));
                result = (num+0);
                edKubFut.setText(String.valueOf(roundUp(result,4)));
                result = (num * 1728);
                edKubDuim.setText(String.valueOf(roundUp(result,4)));
                result = (num*7.481);
                edAmGal.setText(String.valueOf(roundUp(result,4)));
                result = (num*29.9221);
                edAmKvarta.setText(String.valueOf(roundUp(result,4)));
                result = (num*59.845);
                edAmPin.setText(String.valueOf(roundUp(result,4)));
                result = (num*117.99);
                edAmCup.setText(String.valueOf(roundUp(result,4)));
                result = (num *957.51);
                edAmUnci.setText(String.valueOf(roundUp(result,4)));
                result = (num*1915.02);
                edAmStLozhka.setText(String.valueOf(roundUp(result,4)));
                result = (num *5745.05);
                edAmTeaLozhka.setText(String.valueOf(roundUp(result,4)));
                result = (num*6.2289);
                edBrGal.setText(String.valueOf(roundUp(result,4)));
                result = (num *49.831);
                edBrPint.setText(String.valueOf(roundUp(result,4)));
                result = (num *99.67);
                edBrCup.setText(String.valueOf(roundUp(result,4)));
                result = (num *1594.59);
                edBrCtolLozhka.setText(String.valueOf(roundUp(result,4)));
                result = (num*4783.75);
                edBrTeaLozhka.setText(String.valueOf(roundUp(result,4)));
                result = (num*996.62);
                edBrUnci.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.1781);
                edBarrel.setText(String.valueOf(roundUp(result,4)));

                break;

            case 5:
                result = (num * 0.016388);
                edLitr.setText(String.valueOf(roundUp(result,4)));
                result = (num *16.3871);
                edmmLi.setText(String.valueOf(roundUp(result,4)));
                result = (num *16.3871);
                edKubSm.setText(String.valueOf(roundUp(result,4)));
                result = (num *1.6387e-5);
                edKubM.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.000578705);
                edKubFut.setText(String.valueOf(roundUp(result,4)));
                result = (num +0);
                edKubDuim.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.004329);
                edAmGal.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.017316);
                edAmKvarta.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.034632);
                edAmPin.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.06828);
                edAmCup.setText(String.valueOf(roundUp(result,4)));
                result = (num *0.554113);
                edAmUnci.setText(String.valueOf(roundUp(result,4)));
                result = (num*1.10823);
                edAmStLozhka.setText(String.valueOf(roundUp(result,4)));
                result = (num *3.32468);
                edAmTeaLozhka.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.00360466);
                edBrGal.setText(String.valueOf(roundUp(result,4)));
                result = (num *0.0288372);
                edBrPint.setText(String.valueOf(roundUp(result,4)));
                result = (num *0.05768);
                edBrCup.setText(String.valueOf(roundUp(result,4)));
                result = (num *0.9228);
                edBrCtolLozhka.setText(String.valueOf(roundUp(result,4)));
                result = (num*2.76837);
                edBrTeaLozhka.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.554113);
                edBrUnci.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.0001031);
                edBarrel.setText(String.valueOf(roundUp(result,4)));

                break;

            case 6:
                result = (num * 3.78541);
                edLitr.setText(String.valueOf(roundUp(result,4)));
                result = (num *3785.42);
                edmmLi.setText(String.valueOf(roundUp(result,4)));
                result = (num *3785.42);
                edKubSm.setText(String.valueOf(roundUp(result,4)));
                result = (num *0.00378542);
                edKubM.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.133681);
                edKubFut.setText(String.valueOf(roundUp(result,4)));
                result = (num *231);
                edKubDuim.setText(String.valueOf(roundUp(result,4)));
                result = (num+0);
                edAmGal.setText(String.valueOf(roundUp(result,4)));
                result = (num*4);
                edAmKvarta.setText(String.valueOf(roundUp(result,4)));
                result = (num*8);
                edAmPin.setText(String.valueOf(roundUp(result,4)));
                result = (num*15.772);
                edAmCup.setText(String.valueOf(roundUp(result,4)));
                result = (num *128);
                edAmUnci.setText(String.valueOf(roundUp(result,4)));
                result = (num*256);
                edAmStLozhka.setText(String.valueOf(roundUp(result,4)));
                result = (num *768);
                edAmTeaLozhka.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.84);
                edBrGal.setText(String.valueOf(roundUp(result,4)));
                result = (num *6.66139);
                edBrPint.setText(String.valueOf(roundUp(result,4)));
                result = (num *13.323);
                edBrCup.setText(String.valueOf(roundUp(result,4)));
                result = (num *213.165);
                edBrCtolLozhka.setText(String.valueOf(roundUp(result,4)));
                result = (num*639.5);
                edBrTeaLozhka.setText(String.valueOf(roundUp(result,4)));
                result = (num*133.23);
                edBrUnci.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.02381);
                edBarrel.setText(String.valueOf(roundUp(result,4)));

                break;

            case 7:
                result = (num * 0.9464);
                edLitr.setText(String.valueOf(roundUp(result,4)));
                result = (num *946.36);
                edmmLi.setText(String.valueOf(roundUp(result,4)));
                result = (num *946.36);
                edKubSm.setText(String.valueOf(roundUp(result,4)));
                result = (num *0.00094636);
                edKubM.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.0334201);
                edKubFut.setText(String.valueOf(roundUp(result,4)));
                result = (num *57.75);
                edKubDuim.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.25);
                edAmGal.setText(String.valueOf(roundUp(result,4)));
                result = (num+0);
                edAmKvarta.setText(String.valueOf(roundUp(result,4)));
                result = (num*2);
                edAmPin.setText(String.valueOf(roundUp(result,4)));
                result = (num*3.9439);
                edAmCup.setText(String.valueOf(roundUp(result,4)));
                result = (num *32);
                edAmUnci.setText(String.valueOf(roundUp(result,4)));
                result = (num*64);
                edAmStLozhka.setText(String.valueOf(roundUp(result,4)));
                result = (num *192);
                edAmTeaLozhka.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.20817);
                edBrGal.setText(String.valueOf(roundUp(result,4)));
                result = (num *1.6654);
                edBrPint.setText(String.valueOf(roundUp(result,4)));
                result = (num *3.3307);
                edBrCup.setText(String.valueOf(roundUp(result,4)));
                result = (num *53.3);
                edBrCtolLozhka.setText(String.valueOf(roundUp(result,4)));
                result = (num*159.873);
                edBrTeaLozhka.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.005952);
                edBarrel.setText(String.valueOf(roundUp(result,4)));

                break;

            case 8:
                result = (num * 0.475);
                edLitr.setText(String.valueOf(roundUp(result,4)));
                result = (num *473.18);
                edmmLi.setText(String.valueOf(roundUp(result,4)));
                result = (num *473.18);
                edKubSm.setText(String.valueOf(roundUp(result,4)));
                result = (num *0.000475);
                edKubM.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.01672);
                edKubFut.setText(String.valueOf(roundUp(result,4)));
                result = (num *28.875);
                edKubDuim.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.125);
                edAmGal.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.5);
                edAmKvarta.setText(String.valueOf(roundUp(result,4)));
                result = (num+0);
                edAmPin.setText(String.valueOf(roundUp(result,4)));
                result = (num*1.98);
                edAmCup.setText(String.valueOf(roundUp(result,4)));
                result = (num *16);
                edAmUnci.setText(String.valueOf(roundUp(result,4)));
                result = (num*32);
                edAmStLozhka.setText(String.valueOf(roundUp(result,4)));
                result = (num *96);
                edAmTeaLozhka.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.1041);
                edBrGal.setText(String.valueOf(roundUp(result,4)));
                result = (num *0.8327);
                edBrPint.setText(String.valueOf(roundUp(result,4)));
                result = (num *1.667);
                edBrCup.setText(String.valueOf(roundUp(result,4)));
                result = (num *26.646);
                edBrCtolLozhka.setText(String.valueOf(roundUp(result,4)));
                result = (num*79.94);
                edBrTeaLozhka.setText(String.valueOf(roundUp(result,4)));
                result = (num*16.66);
                edBrUnci.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.002976);
                edBarrel.setText(String.valueOf(roundUp(result,4)));

                break;

            case 9:
                result = (num * 0.24);
                edLitr.setText(String.valueOf(roundUp(result,4)));
                result = (num *240);
                edmmLi.setText(String.valueOf(roundUp(result,4)));
                result = (num *240);
                edKubSm.setText(String.valueOf(roundUp(result,4)));
                result = (num *0.00024);
                edKubM.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.008475);
                edKubFut.setText(String.valueOf(roundUp(result,4)));
                result = (num *14.646);
                edKubDuim.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.063402);
                edAmGal.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.2537);
                edAmKvarta.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.508);
                edAmPin.setText(String.valueOf(roundUp(result,4)));
                result = (num+0);
                edAmCup.setText(String.valueOf(roundUp(result,4)));
                result = (num *8.1157);
                edAmUnci.setText(String.valueOf(roundUp(result,4)));
                result = (num*16.24);
                edAmStLozhka.setText(String.valueOf(roundUp(result,4)));
                result = (num *48.7);
                edAmTeaLozhka.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.0528);
                edBrGal.setText(String.valueOf(roundUp(result,4)));
                result = (num *0.42235);
                edBrPint.setText(String.valueOf(roundUp(result,4)));
                result = (num *0.8447);
                edBrCup.setText(String.valueOf(roundUp(result,4)));
                result = (num *13.52);
                edBrCtolLozhka.setText(String.valueOf(roundUp(result,4)));
                result = (num*40.545);
                edBrTeaLozhka.setText(String.valueOf(roundUp(result,4)));
                result = (num*8.447);
                edBrUnci.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.001488);
                edBarrel.setText(String.valueOf(roundUp(result,4)));

                break;

            case 10:
                result = (num * 0.0296);
                edLitr.setText(String.valueOf(roundUp(result,4)));
                result = (num *29.574);
                edmmLi.setText(String.valueOf(roundUp(result,4)));
                result = (num *29.574);
                edKubSm.setText(String.valueOf(roundUp(result,4)));
                result = (num *2.9574e-5);
                edKubM.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.0010444);
                edKubFut.setText(String.valueOf(roundUp(result,4)));
                result = (num *1.8047);
                edKubDuim.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.00782);
                edAmGal.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.03125);
                edAmKvarta.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.0625);
                edAmPin.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.12323);
                edAmCup.setText(String.valueOf(roundUp(result,4)));
                result = (num +0);
                edAmUnci.setText(String.valueOf(roundUp(result,4)));
                result = (num*2);
                edAmStLozhka.setText(String.valueOf(roundUp(result,4)));
                result = (num *6);
                edAmTeaLozhka.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.0065053);
                edBrGal.setText(String.valueOf(roundUp(result,4)));
                result = (num *0.052043);
                edBrPint.setText(String.valueOf(roundUp(result,4)));
                result = (num *0.10409);
                edBrCup.setText(String.valueOf(roundUp(result,4)));
                result = (num *1.6654);
                edBrCtolLozhka.setText(String.valueOf(roundUp(result,4)));
                result = (num*4.9961);
                edBrTeaLozhka.setText(String.valueOf(roundUp(result,4)));
                result = (num*1.0409);
                edBrUnci.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.000186);
                edBarrel.setText(String.valueOf(roundUp(result,4)));

                break;

            case 11:
                result = (num * 0.01479);
                edLitr.setText(String.valueOf(roundUp(result,4)));
                result = (num *14.79);
                edmmLi.setText(String.valueOf(roundUp(result,4)));
                result = (num *14.79);
                edKubSm.setText(String.valueOf(roundUp(result,4)));
                result = (num *1.4787e-5);
                edKubM.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.0005222);
                edKubFut.setText(String.valueOf(roundUp(result,4)));
                result = (num *0.90235);
                edKubDuim.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.0039063);
                edAmGal.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.01563);
                edAmKvarta.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.03125);
                edAmPin.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.06162);
                edAmCup.setText(String.valueOf(roundUp(result,4)));
                result = (num *0.5);
                edAmUnci.setText(String.valueOf(roundUp(result,4)));
                result = (num+0);
                edAmStLozhka.setText(String.valueOf(roundUp(result,4)));
                result = (num *3);
                edAmTeaLozhka.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.0032527);
                edBrGal.setText(String.valueOf(roundUp(result,4)));
                result = (num *0.026022);
                edBrPint.setText(String.valueOf(roundUp(result,4)));
                result = (num *0.052043);
                edBrCup.setText(String.valueOf(roundUp(result,4)));
                result = (num *0.83268);
                edBrCtolLozhka.setText(String.valueOf(roundUp(result,4)));
                result = (num*2.5);
                edBrTeaLozhka.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.52);
                edBrUnci.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.00009301);
                edBarrel.setText(String.valueOf(roundUp(result,4)));

                break;

            case 12:
                result = (num * 0.00493);
                edLitr.setText(String.valueOf(roundUp(result,4)));
                result = (num *4.93);
                edmmLi.setText(String.valueOf(roundUp(result,4)));
                result = (num *4.93);
                edKubSm.setText(String.valueOf(roundUp(result,4)));
                result = (num *4.93e-6);
                edKubM.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.000175);
                edKubFut.setText(String.valueOf(roundUp(result,4)));
                result = (num *0.3008);
                edKubDuim.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.001303);
                edAmGal.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.005209);
                edAmKvarta.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.010417);
                edAmPin.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.02054);
                edAmCup.setText(String.valueOf(roundUp(result,4)));
                result = (num *0.167);
                edAmUnci.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.3336);
                edAmStLozhka.setText(String.valueOf(roundUp(result,4)));
                result = (num +0);
                edAmTeaLozhka.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.001085);
                edBrGal.setText(String.valueOf(roundUp(result,4)));
                result = (num *0.008675);
                edBrPint.setText(String.valueOf(roundUp(result,4)));
                result = (num *0.01735);
                edBrCup.setText(String.valueOf(roundUp(result,4)));
                result = (num *0.2776);
                edBrCtolLozhka.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.8327);
                edBrTeaLozhka.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.1735);
                edBrUnci.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.000031);
                edBarrel.setText(String.valueOf(roundUp(result,4)));

                break;

            case 13:
                result = (num * 4.546);
                edLitr.setText(String.valueOf(roundUp(result,4)));
                result = (num *4546);
                edmmLi.setText(String.valueOf(roundUp(result,4)));
                result = (num *4546);
                edKubSm.setText(String.valueOf(roundUp(result,4)));
                result = (num *0.004546);
                edKubM.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.16055);
                edKubFut.setText(String.valueOf(roundUp(result,4)));
                result = (num *277.42);
                edKubDuim.setText(String.valueOf(roundUp(result,4)));
                result = (num*1.201);
                edAmGal.setText(String.valueOf(roundUp(result,4)));
                result = (num*4.804);
                edAmKvarta.setText(String.valueOf(roundUp(result,4)));
                result = (num*9.608);
                edAmPin.setText(String.valueOf(roundUp(result,4)));
                result = (num*18.95);
                edAmCup.setText(String.valueOf(roundUp(result,4)));
                result = (num *153.722);
                edAmUnci.setText(String.valueOf(roundUp(result,4)));
                result = (num*307.44);
                edAmStLozhka.setText(String.valueOf(roundUp(result,4)));
                result = (num *922.33);
                edAmTeaLozhka.setText(String.valueOf(roundUp(result,4)));
                result = (num+0);
                edBrGal.setText(String.valueOf(roundUp(result,4)));
                result = (num *8);
                edBrPint.setText(String.valueOf(roundUp(result,4)));
                result = (num *16);
                edBrCup.setText(String.valueOf(roundUp(result,4)));
                result = (num *256);
                edBrCtolLozhka.setText(String.valueOf(roundUp(result,4)));
                result = (num*768);
                edBrTeaLozhka.setText(String.valueOf(roundUp(result,4)));
                result = (num*160);
                edBrUnci.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.02859);
                edBarrel.setText(String.valueOf(roundUp(result,4)));

                break;

            case 14:
                result = (num * 0.569);
                edLitr.setText(String.valueOf(roundUp(result,4)));
                result = (num *569);
                edmmLi.setText(String.valueOf(roundUp(result,4)));
                result = (num *569);
                edKubSm.setText(String.valueOf(roundUp(result,4)));
                result = (num *0.000569);
                edKubM.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.02007);
                edKubFut.setText(String.valueOf(roundUp(result,4)));
                result = (num *34.68);
                edKubDuim.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.1502);
                edAmGal.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.6005);
                edAmKvarta.setText(String.valueOf(roundUp(result,4)));
                result = (num*1.201);
                edAmPin.setText(String.valueOf(roundUp(result,4)));
                result = (num*2.368);
                edAmCup.setText(String.valueOf(roundUp(result,4)));
                result = (num *19.216);
                edAmUnci.setText(String.valueOf(roundUp(result,4)));
                result = (num*38.44);
                edAmStLozhka.setText(String.valueOf(roundUp(result,4)));
                result = (num *115.3);
                edAmTeaLozhka.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.125);
                edBrGal.setText(String.valueOf(roundUp(result,4)));
                result = (num +0);
                edBrPint.setText(String.valueOf(roundUp(result,4)));
                result = (num *2);
                edBrCup.setText(String.valueOf(roundUp(result,4)));
                result = (num *32);
                edBrCtolLozhka.setText(String.valueOf(roundUp(result,4)));
                result = (num*96);
                edBrTeaLozhka.setText(String.valueOf(roundUp(result,4)));
                result = (num*20);
                edBrUnci.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.003574);
                edBarrel.setText(String.valueOf(roundUp(result,4)));

                break;

            case 15:
                result = (num * 0.284);
                edLitr.setText(String.valueOf(roundUp(result,4)));
                result = (num *284.2);
                edmmLi.setText(String.valueOf(roundUp(result,4)));
                result = (num *284.2);
                edKubSm.setText(String.valueOf(roundUp(result,4)));
                result = (num *0.0002842);
                edKubM.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.01004);
                edKubFut.setText(String.valueOf(roundUp(result,4)));
                result = (num *17.34);
                edKubDuim.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.0751);
                edAmGal.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.3003);
                edAmKvarta.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.6005);
                edAmPin.setText(String.valueOf(roundUp(result,4)));
                result = (num*1.184);
                edAmCup.setText(String.valueOf(roundUp(result,4)));
                result = (num *9.6);
                edAmUnci.setText(String.valueOf(roundUp(result,4)));
                result = (num*19.22);
                edAmStLozhka.setText(String.valueOf(roundUp(result,4)));
                result = (num *57.65);
                edAmTeaLozhka.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.0625);
                edBrGal.setText(String.valueOf(roundUp(result,4)));
                result = (num *0.5);
                edBrPint.setText(String.valueOf(roundUp(result,4)));
                result = (num +0);
                edBrCup.setText(String.valueOf(roundUp(result,4)));
                result = (num *16);
                edBrCtolLozhka.setText(String.valueOf(roundUp(result,4)));
                result = (num*48);
                edBrTeaLozhka.setText(String.valueOf(roundUp(result,4)));
                result = (num*10);
                edBrUnci.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.001787);
                edBarrel.setText(String.valueOf(roundUp(result,4)));

                break;

            case 16:
                result = (num * 0.01776);
                edLitr.setText(String.valueOf(roundUp(result,4)));
                result = (num *17.76);
                edmmLi.setText(String.valueOf(roundUp(result,4)));
                result = (num *17.76);
                edKubSm.setText(String.valueOf(roundUp(result,4)));
                result = (num *1.7758e-5);
                edKubM.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.0006272);
                edKubFut.setText(String.valueOf(roundUp(result,4)));
                result = (num *1.0837);
                edKubDuim.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.0047);
                edAmGal.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.01877);
                edAmKvarta.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.0376);
                edAmPin.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.074);
                edAmCup.setText(String.valueOf(roundUp(result,4)));
                result = (num *0.6005);
                edAmUnci.setText(String.valueOf(roundUp(result,4)));
                result = (num*1.201);
                edAmStLozhka.setText(String.valueOf(roundUp(result,4)));
                result = (num *3.603);
                edAmTeaLozhka.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.00390625);
                edBrGal.setText(String.valueOf(roundUp(result,4)));
                result = (num *0.03125);
                edBrPint.setText(String.valueOf(roundUp(result,4)));
                result = (num *0.0625);
                edBrCup.setText(String.valueOf(roundUp(result,4)));
                result = (num +0);
                edBrCtolLozhka.setText(String.valueOf(roundUp(result,4)));
                result = (num*3);
                edBrTeaLozhka.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.625);
                edBrUnci.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.0001116);
                edBarrel.setText(String.valueOf(roundUp(result,4)));

                break;

            case 17:
                result = (num * 0.00592);
                edLitr.setText(String.valueOf(roundUp(result,4)));
                result = (num *5.92);
                edmmLi.setText(String.valueOf(roundUp(result,4)));
                result = (num *5.92);
                edKubSm.setText(String.valueOf(roundUp(result,4)));
                result = (num *5.9194e-6);
                edKubM.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.00020905);
                edKubFut.setText(String.valueOf(roundUp(result,4)));
                result = (num *0.3613);
                edKubDuim.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.001564);
                edAmGal.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.006255);
                edAmKvarta.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.01251);
                edAmPin.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.02467);
                edAmCup.setText(String.valueOf(roundUp(result,4)));
                result = (num *0.2002);
                edAmUnci.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.4004);
                edAmStLozhka.setText(String.valueOf(roundUp(result,4)));
                result = (num *1.201);
                edAmTeaLozhka.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.001303);
                edBrGal.setText(String.valueOf(roundUp(result,4)));
                result = (num *0.01042);
                edBrPint.setText(String.valueOf(roundUp(result,4)));
                result = (num *0.02084);
                edBrCup.setText(String.valueOf(roundUp(result,4)));
                result = (num *0.33);
                edBrCtolLozhka.setText(String.valueOf(roundUp(result,4)));
                result = (num+0);
                edBrTeaLozhka.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.2084);
                edBrUnci.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.0000372);
                edBarrel.setText(String.valueOf(roundUp(result,4)));

                break;

            case 18:
                result = (num * 0.02842);
                edLitr.setText(String.valueOf(roundUp(result,4)));
                result = (num *28.42);
                edmmLi.setText(String.valueOf(roundUp(result,4)));
                result = (num *28.42);
                edKubSm.setText(String.valueOf(roundUp(result,4)));
                result = (num *2.8413e-5);
                edKubM.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.001004);
                edKubFut.setText(String.valueOf(roundUp(result,4)));
                result = (num *1.734);
                edKubDuim.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.00751);
                edAmGal.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.03004);
                edAmKvarta.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.0601);
                edAmPin.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.1184);
                edAmCup.setText(String.valueOf(roundUp(result,4)));
                result = (num *0.961);
                edAmUnci.setText(String.valueOf(roundUp(result,4)));
                result = (num*1.922);
                edAmStLozhka.setText(String.valueOf(roundUp(result,4)));
                result = (num *5.765);
                edAmTeaLozhka.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.00625);
                edBrGal.setText(String.valueOf(roundUp(result,4)));
                result = (num *0.05);
                edBrPint.setText(String.valueOf(roundUp(result,4)));
                result = (num *0.1);
                edBrCup.setText(String.valueOf(roundUp(result,4)));
                result = (num *1.6);
                edBrCtolLozhka.setText(String.valueOf(roundUp(result,4)));
                result = (num*4.8);
                edBrTeaLozhka.setText(String.valueOf(roundUp(result,4)));
                result = (num+0);
                edBrUnci.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.0001787);
                edBarrel.setText(String.valueOf(roundUp(result,4)));
                break;

            case 19:
                result = (num * 159);
                edLitr.setText(String.valueOf(roundUp(result,4)));
                result = (num *159000);
                edmmLi.setText(String.valueOf(roundUp(result,4)));
                result = (num *159000);
                edKubSm.setText(String.valueOf(roundUp(result,4)));
                result = (num *159000000);
                edKubM.setText(String.valueOf(roundUp(result,4)));
                result = (num*5.615);
                edKubFut.setText(String.valueOf(roundUp(result,4)));
                result = (num *9702);
                edKubDuim.setText(String.valueOf(roundUp(result,4)));
                result = (num*42);
                edAmGal.setText(String.valueOf(roundUp(result,4)));
                result = (num*168);
                edAmKvarta.setText(String.valueOf(roundUp(result,4)));
                result = (num*336);
                edAmPin.setText(String.valueOf(roundUp(result,4)));
                result = (num*672);
                edAmCup.setText(String.valueOf(roundUp(result,4)));
                result = (num *5376);
                edAmUnci.setText(String.valueOf(roundUp(result,4)));
                result = (num*10750);
                edAmStLozhka.setText(String.valueOf(roundUp(result,4)));
                result = (num *32260);
                edAmTeaLozhka.setText(String.valueOf(roundUp(result,4)));
                result = (num*34.97);
                edBrGal.setText(String.valueOf(roundUp(result,4)));
                result = (num *279.8);
                edBrPint.setText(String.valueOf(roundUp(result,4)));
                result = (num *0.001761);
                edBrCup.setText(String.valueOf(roundUp(result,4)));
                result = (num *0.0001113);
                edBrCtolLozhka.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.00003711);
                edBrTeaLozhka.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.0001787);
                edBrUnci.setText(String.valueOf(roundUp(result,4)));
                result = (num+0);
                edBarrel.setText(String.valueOf(roundUp(result,4)));
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

