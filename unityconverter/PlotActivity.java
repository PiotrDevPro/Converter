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

public class PlotActivity extends AppCompatActivity implements TextWatcher{

   // String[] data = {"Тонна на куб.м (t/m³)","Кг. на куб.м (kg/m³)","Кг. на литр (kg/l)","Грамм на литр (g/l)","Грамм на куб.м (g/m³)","Кг на куб. см (kg/сm³)","Грамм на куб. см (g/сm³)","Фунт на куб. ярд (lb/yd³)","Фунт на куб. фут (lb/ft³)","Фунт на куб. дюйм (lb/in³)","Фунт на галлон США (lb/gal)","Фунт на Брит. галлон (lb/UK gal)","Унции на куб. ярд (oz/yd³)","Унции на куб. фунт (oz/ft³)","Унции на куб. дюйм (oz/in³)","Унции на галлон США (oz/gal)","Унции на Брит.галлон (oz/ UK gal)","Слаг на куб. ярд (slug/yd³)","Слаг на куб. фут (slug/ft³)","Слаг на куб. дюйм (slug/in³)"};
    int a;
    Spinner spMassa;
    EditText edNum,Tm, kgM,Gm, kgl,Gl,Kgcm,Gcm,Lbyd,Lbft,Lbin,lbgal,Lbukgal,Ozyd,Ozft,Ozin,Ozgal,Ozukgal,Slugyd,Slugft,Slugin;
   // TextView tvPosName;

    public BigDecimal roundUp(double value, int digits) {
        return new BigDecimal("" + value).setScale(digits, BigDecimal.ROUND_HALF_UP);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.plot);

        Toolbar my_toolbar = (Toolbar) findViewById(R.id.my_toolbar_app);
        RelativeLayout backColorlayoutAds = (RelativeLayout) findViewById(R.id.reLayoutPlotAds);
        CollapsingToolbarLayout bottomColorLayout = (CollapsingToolbarLayout) findViewById(R.id.PloTottomLayout);
        CoordinatorLayout corLoyDlinna = (CoordinatorLayout) findViewById(R.id.corLoyoutPlot);
        setSupportActionBar(my_toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,// data);
     //   adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        getResources().getStringArray(R.array.plotnost));

        spMassa = (Spinner) findViewById(R.id.spMassa);
        spMassa.setAdapter(adapter);

        edNum = (EditText) findViewById(R.id.edNum);
     //   tvPosName = (TextView) findViewById(R.id.tvPosName);


        TextView Nm = (TextView) findViewById(R.id.tm3);
        TextView Km = (TextView) findViewById(R.id.kgm3);
        TextView Mile = (TextView) findViewById(R.id.gm3);
        TextView m = (TextView) findViewById(R.id.kgll);
        TextView yard = (TextView)  findViewById(R.id.kgcm3);
        TextView ft = (TextView)  findViewById(R.id.gcm3);
        TextView In = (TextView)  findViewById(R.id.UkUsLabel);
        TextView Sm = (TextView)  findViewById(R.id.lbyd3);
        TextView mm = (TextView)  findViewById(R.id.lbft3);
        TextView um = (TextView)  findViewById(R.id.lbin3);
        TextView nm = (TextView)  findViewById(R.id.lbgal);
        TextView gl = (TextView)  findViewById(R.id.gl);
        TextView MetrSystem = (TextView)  findViewById(R.id.MetrSystem);

        TextView lbUggal = (TextView)  findViewById(R.id.lbUggal);
        TextView ozyd3 = (TextView)  findViewById(R.id.ozyd3);
        TextView ozft3 = (TextView)  findViewById(R.id.ozft3);
        TextView ozin3 = (TextView)  findViewById(R.id.ozin3);
        TextView ozgal = (TextView)  findViewById(R.id.ozgal);
        TextView ozUkgal = (TextView)  findViewById(R.id.ozUkgal);
        TextView UkEng = (TextView)  findViewById(R.id.UkEngineer);

        TextView slugyd = (TextView)  findViewById(R.id.slugyd3);
        TextView slugft = (TextView)  findViewById(R.id.slugft3);
        TextView slugon = (TextView)  findViewById(R.id.slugin3);


        Tm = (EditText) findViewById(R.id.Tm);
        kgM = (EditText) findViewById(R.id.kgM);
        Gm = (EditText) findViewById(R.id.Gm);
        kgl = (EditText) findViewById(R.id.kgl);
        Gl = (EditText) findViewById(R.id.Gl);
        Kgcm = (EditText) findViewById(R.id.Kgcm);
        Gcm = (EditText) findViewById(R.id.Gcm);
        Lbyd = (EditText) findViewById(R.id.Lbyd);
        Lbft = (EditText) findViewById(R.id.Lbft);
        Lbin = (EditText) findViewById(R.id.Lbin);
        lbgal = (EditText) findViewById(R.id.lbgall);
        Lbukgal = (EditText) findViewById(R.id.Lbukgal);
        Ozyd = (EditText) findViewById(R.id.Ozyd);
        Ozft = (EditText) findViewById(R.id.Ozft);
        Ozin = (EditText) findViewById(R.id.Ozin);
        Ozgal = (EditText) findViewById(R.id.Ozgal);
        Ozukgal = (EditText) findViewById(R.id.Ozukgal);
        Slugyd = (EditText) findViewById(R.id.Slugyd);
        Slugft = (EditText) findViewById(R.id.Slugft);
        Slugin = (EditText) findViewById(R.id.Slugin);

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
            Sm.setTextColor(getTextColor());
            mm.setTextColor(getTextColor());
            um.setTextColor(getTextColor());
            nm.setTextColor(getTextColor());

            lbUggal.setTextColor(getTextColor());
            ozyd3.setTextColor(getTextColor());
            ozft3.setTextColor(getTextColor());
            ozin3.setTextColor(getTextColor());
            ozgal.setTextColor(getTextColor());
            ozUkgal.setTextColor(getTextColor());
            slugyd.setTextColor(getTextColor());
            slugft.setTextColor(getTextColor());
            slugon.setTextColor(getTextColor());
            gl.setTextColor(getTextColor());
            MetrSystem.setTextColor(getTextColor());
            UkEng.setTextColor(getTextColor());


            Tm.setBackgroundColor(getEditTextActivityColor());
            Tm.setTextColor(getEditTextColor());
            kgM.setBackgroundColor(getEditTextActivityColor());
            kgM.setTextColor(getEditTextColor());
            Gm.setBackgroundColor(getEditTextActivityColor());
            Gm.setTextColor(getEditTextColor());
            kgl.setBackgroundColor(getEditTextActivityColor());
            kgl.setTextColor(getEditTextColor());
            Gl.setBackgroundColor(getEditTextActivityColor());
            Gl.setTextColor(getEditTextColor());
            Kgcm.setBackgroundColor(getEditTextActivityColor());
            Kgcm.setTextColor(getEditTextColor());
            Gcm.setBackgroundColor(getEditTextActivityColor());
            Gcm.setTextColor(getEditTextColor());
            Lbyd.setBackgroundColor(getEditTextActivityColor());
            Lbyd.setTextColor(getEditTextColor());
            Lbft.setBackgroundColor(getEditTextActivityColor());
            Lbft.setTextColor(getEditTextColor());
            Lbin.setBackgroundColor(getEditTextActivityColor());
            Lbin.setTextColor(getEditTextColor());
            lbgal.setBackgroundColor(getEditTextActivityColor());
            lbgal.setTextColor(getEditTextColor());
            Lbukgal.setBackgroundColor(getEditTextActivityColor());
            Lbukgal.setTextColor(getEditTextColor());
            Ozyd.setBackgroundColor(getEditTextActivityColor());
            Ozyd.setTextColor(getEditTextColor());
            Ozft.setBackgroundColor(getEditTextActivityColor());
            Ozft.setTextColor(getEditTextColor());
            Ozin.setBackgroundColor(getEditTextActivityColor());
            Ozin.setTextColor(getEditTextColor());
            Ozgal.setBackgroundColor(getEditTextActivityColor());
            Ozgal.setTextColor(getEditTextColor());
            Ozukgal.setBackgroundColor(getEditTextActivityColor());
            Ozukgal.setTextColor(getEditTextColor());
            Slugyd.setBackgroundColor(getEditTextActivityColor());
            Slugyd.setTextColor(getEditTextColor());
            Slugft.setBackgroundColor(getEditTextActivityColor());
            Slugft.setTextColor(getEditTextColor());
            Slugin.setBackgroundColor(getEditTextActivityColor());
            Slugin.setTextColor(getEditTextColor());


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
              //  tvPosName.setText(strName);
                a = position;

                double result = 0;
                double num = 0;

                if (TextUtils.isEmpty(edNum.getText().toString())
                        ||  (edNum.getText().toString().equals("."))
                        ||  (edNum.getText().toString().equals("-"))){



                    Tm.setText("");
                    kgM.setText("");
                    Gm.setText("");
                    kgl.setText("");
                    Gl.setText("");
                    Kgcm.setText("");
                    Gcm.setText("");
                    Lbyd.setText("");
                    Lbft.setText("");
                    Lbin.setText("");
                    lbgal.setText("");
                    Lbukgal.setText("");
                    Ozyd.setText("");
                    Ozft.setText("");
                    Ozin.setText("");
                    Ozgal.setText("");
                    Ozukgal.setText("");
                    Slugyd.setText("");
                    Slugft.setText("");
                    Slugin.setText("");


                    return;

                }

                num = Float.parseFloat(edNum.getText().toString());

                switch (position){
                    case 0:
                        result = (num + 0);
                        Tm.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 1000);
                        kgM.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 1);
                        kgl.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 1000);
                        Gl.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 1000000);
                        Gm.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.001);
                        Kgcm.setText(String.valueOf(roundUp(result,4)));
                        result = (num* 1);
                        Gcm.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 1686);
                        Lbyd.setText(String.valueOf(roundUp(result,4)));
                        result = (num*62.43);
                        Lbft.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.03613);
                        Lbin.setText(String.valueOf(roundUp(result,4)));
                        result = (num*8.345);
                        lbgal.setText(String.valueOf(roundUp(result,4)));
                        result = (num*10.02);
                        Lbukgal.setText(String.valueOf(roundUp(result,4)));
                        result = (num *26970);
                        Ozyd.setText(String.valueOf(roundUp(result,4)));
                        result = (num*998.8);
                        Ozft.setText(String.valueOf(roundUp(result,4)));
                        result = (num *202.9);
                        Ozin.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.578);
                        Ozgal.setText(String.valueOf(roundUp(result,4)));
                        result = (num *133.5);
                        Ozukgal.setText(String.valueOf(roundUp(result,4)));
                        result = (num *52.39);
                        Slugyd.setText(String.valueOf(roundUp(result,4)));
                        result = (num *1.94);
                        Slugft.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.001123);
                        Slugin.setText(String.valueOf(roundUp(result,4)));
                        break;

                    case 1:
                        result = (num * 0.001);
                        Tm.setText(String.valueOf(roundUp(result,4)));
                        result = (num + 0);
                        kgM.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.001);
                        kgl.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 1);
                        Gl.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 1000);
                        Gm.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.000001);
                        Kgcm.setText(String.valueOf(roundUp(result,4)));
                        result = (num* 0.001);
                        Gcm.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 1.686);
                        Lbyd.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.06243);
                        Lbft.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.00003613);
                        Lbin.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.008345);
                        lbgal.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.01002);
                        Lbukgal.setText(String.valueOf(roundUp(result,4)));
                        result = (num *26.97);
                        Ozyd.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.9988);
                        Ozft.setText(String.valueOf(roundUp(result,4)));
                        result = (num *0.000578);
                        Ozin.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.1335);
                        Ozgal.setText(String.valueOf(roundUp(result,4)));
                        result = (num *0.1604);
                        Ozukgal.setText(String.valueOf(roundUp(result,4)));
                        result = (num *0.05239);
                        Slugyd.setText(String.valueOf(roundUp(result,4)));
                        result = (num *0.00194);
                        Slugft.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.000001123);
                        Slugin.setText(String.valueOf(roundUp(result,4)));
                        break;

                    case 2:
                        result = (num * 1);
                        Tm.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 1000);
                        kgM.setText(String.valueOf(roundUp(result,4)));
                        result = (num + 0);
                        kgl.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 1000);
                        Gl.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 1000000);
                        Gm.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.001);
                        Kgcm.setText(String.valueOf(roundUp(result,4)));
                        result = (num* 1);
                        Gcm.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 1686);
                        Lbyd.setText(String.valueOf(roundUp(result,4)));
                        result = (num*62.43);
                        Lbft.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.03613);
                        Lbin.setText(String.valueOf(roundUp(result,4)));
                        result = (num*8.345);
                        lbgal.setText(String.valueOf(roundUp(result,4)));
                        result = (num*10.02);
                        Lbukgal.setText(String.valueOf(roundUp(result,4)));
                        result = (num *26970);
                        Ozyd.setText(String.valueOf(roundUp(result,4)));
                        result = (num*998.8);
                        Ozft.setText(String.valueOf(roundUp(result,4)));
                        result = (num *202.9);
                        Ozin.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.578);
                        Ozgal.setText(String.valueOf(roundUp(result,4)));
                        result = (num *133.5);
                        Ozukgal.setText(String.valueOf(roundUp(result,4)));
                        result = (num *52.39);
                        Slugyd.setText(String.valueOf(roundUp(result,4)));
                        result = (num *1.94);
                        Slugft.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.001123);
                        Slugin.setText(String.valueOf(roundUp(result,4)));
                        break;

                    case 3:
                        result = (num * 0.001);
                        Tm.setText(String.valueOf(roundUp(result,4)));
                        result = (num + 1);
                        kgM.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.001);
                        kgl.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 1);
                        Gl.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 1000);
                        Gm.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.000001);
                        Kgcm.setText(String.valueOf(roundUp(result,4)));
                        result = (num* 0.001);
                        Gcm.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 1.686);
                        Lbyd.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.06243);
                        Lbft.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.00003613);
                        Lbin.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.008345);
                        lbgal.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.01002);
                        Lbukgal.setText(String.valueOf(roundUp(result,4)));
                        result = (num *26.97);
                        Ozyd.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.9988);
                        Ozft.setText(String.valueOf(roundUp(result,4)));
                        result = (num *0.000578);
                        Ozin.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.1335);
                        Ozgal.setText(String.valueOf(roundUp(result,4)));
                        result = (num *0.1604);
                        Ozukgal.setText(String.valueOf(roundUp(result,4)));
                        result = (num *0.05239);
                        Slugyd.setText(String.valueOf(roundUp(result,4)));
                        result = (num *0.00194);
                        Slugft.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.000001123);
                        Slugin.setText(String.valueOf(roundUp(result,4)));
                        break;

                    case 4:

                        result = (num * 0.000001);
                        Tm.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.001);
                        kgM.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.000001);
                        kgl.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.001);
                        Gl.setText(String.valueOf(roundUp(result,4)));
                        result = (num + 0);
                        Gm.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.000000001);
                        Kgcm.setText(String.valueOf(roundUp(result,4)));
                        result = (num* 0.000001);
                        Gcm.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.001686);
                        Lbyd.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.00006243);
                        Lbft.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.00000003613);
                        Lbin.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.000008345);
                        lbgal.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.00001002);
                        Lbukgal.setText(String.valueOf(roundUp(result,4)));
                        result = (num *0.02697);
                        Ozyd.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.0009988);
                        Ozft.setText(String.valueOf(roundUp(result,4)));
                        result = (num *0.000000578);
                        Ozin.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.0001335);
                        Ozgal.setText(String.valueOf(roundUp(result,4)));
                        result = (num *0.0001604);
                        Ozukgal.setText(String.valueOf(roundUp(result,4)));
                        result = (num *0.00005239);
                        Slugyd.setText(String.valueOf(roundUp(result,4)));
                        result = (num *0.00000194);
                        Slugft.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.000000001123);
                        Slugin.setText(String.valueOf(roundUp(result,4)));
                        break;

                    case 5:

                        result = (num * 1000);
                        Tm.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 1000000);
                        kgM.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 1000);
                        kgl.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 1000000);
                        Gl.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 1e+9);
                        Gm.setText(String.valueOf(roundUp(result,4)));
                        result = (num + 0);
                        Kgcm.setText(String.valueOf(roundUp(result,4)));
                        result = (num* 1000);
                        Gcm.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 1686000);
                        Lbyd.setText(String.valueOf(roundUp(result,4)));
                        result = (num*62430);
                        Lbft.setText(String.valueOf(roundUp(result,4)));
                        result = (num*36.13);
                        Lbin.setText(String.valueOf(roundUp(result,4)));
                        result = (num*8345);
                        lbgal.setText(String.valueOf(roundUp(result,4)));
                        result = (num*10020);
                        Lbukgal.setText(String.valueOf(roundUp(result,4)));
                        result = (num *26970000);
                        Ozyd.setText(String.valueOf(roundUp(result,4)));
                        result = (num*998800);
                        Ozft.setText(String.valueOf(roundUp(result,4)));
                        result = (num *578);
                        Ozin.setText(String.valueOf(roundUp(result,4)));
                        result = (num*133500);
                        Ozgal.setText(String.valueOf(roundUp(result,4)));
                        result = (num *160400);
                        Ozukgal.setText(String.valueOf(roundUp(result,4)));
                        result = (num *52390);
                        Slugyd.setText(String.valueOf(roundUp(result,4)));
                        result = (num *1940);
                        Slugft.setText(String.valueOf(roundUp(result,4)));
                        result = (num*1.123);
                        Slugin.setText(String.valueOf(roundUp(result,4)));
                        break;
                    case 6:
                        result = (num * 1);
                        Tm.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 1000);
                        kgM.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 1);
                        kgl.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 1000);
                        Gl.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 1000000);
                        Gm.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.001);
                        Kgcm.setText(String.valueOf(roundUp(result,4)));
                        result = (num+ 0);
                        Gcm.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 1686);
                        Lbyd.setText(String.valueOf(roundUp(result,4)));
                        result = (num*62.43);
                        Lbft.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.03613);
                        Lbin.setText(String.valueOf(roundUp(result,4)));
                        result = (num*8.345);
                        lbgal.setText(String.valueOf(roundUp(result,4)));
                        result = (num*10.02);
                        Lbukgal.setText(String.valueOf(roundUp(result,4)));
                        result = (num *26970);
                        Ozyd.setText(String.valueOf(roundUp(result,4)));
                        result = (num*998.8);
                        Ozft.setText(String.valueOf(roundUp(result,4)));
                        result = (num *202.9);
                        Ozin.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.578);
                        Ozgal.setText(String.valueOf(roundUp(result,4)));
                        result = (num *133.5);
                        Ozukgal.setText(String.valueOf(roundUp(result,4)));
                        result = (num *52.39);
                        Slugyd.setText(String.valueOf(roundUp(result,4)));
                        result = (num *1.94);
                        Slugft.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.001123);
                        Slugin.setText(String.valueOf(roundUp(result,4)));

                        break;

                    case 7:
                        result = (num * 0.0005933);
                        Tm.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.5933);
                        kgM.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.0005933);
                        kgl.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.5933);
                        Gl.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 593.3);
                        Gm.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.0000005933);
                        Kgcm.setText(String.valueOf(roundUp(result,4)));
                        result = (num* 0.0005933);
                        Gcm.setText(String.valueOf(roundUp(result,4)));
                        result = (num + 0);
                        Lbyd.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.03704);
                        Lbft.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.00002143);
                        Lbin.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.004951);
                        lbgal.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.005946);
                        Lbukgal.setText(String.valueOf(roundUp(result,4)));
                        result = (num *16);
                        Ozyd.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.5926);
                        Ozft.setText(String.valueOf(roundUp(result,4)));
                        result = (num *0.0003429);
                        Ozin.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.07922);
                        Ozgal.setText(String.valueOf(roundUp(result,4)));
                        result = (num *0.09514);
                        Ozukgal.setText(String.valueOf(roundUp(result,4)));
                        result = (num *0.03108);
                        Slugyd.setText(String.valueOf(roundUp(result,4)));
                        result = (num *0.001151);
                        Slugft.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.0000006662);
                        Slugin.setText(String.valueOf(roundUp(result,4)));
                        break;
                    case 8:
                        result = (num * 0.01602);
                        Tm.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 16.02);
                        kgM.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.01602);
                        kgl.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 16.02);
                        Gl.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 16020);
                        Gm.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.00001602);
                        Kgcm.setText(String.valueOf(roundUp(result,4)));
                        result = (num* 0.01602);
                        Gcm.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 27);
                        Lbyd.setText(String.valueOf(roundUp(result,4)));
                        result = (num+0);
                        Lbft.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.0005787);
                        Lbin.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.1337);
                        lbgal.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.1605);
                        Lbukgal.setText(String.valueOf(roundUp(result,4)));
                        result = (num *432);
                        Ozyd.setText(String.valueOf(roundUp(result,4)));
                        result = (num*16);
                        Ozft.setText(String.valueOf(roundUp(result,4)));
                        result = (num *0.009259);
                        Ozin.setText(String.valueOf(roundUp(result,4)));
                        result = (num*2.139);
                        Ozgal.setText(String.valueOf(roundUp(result,4)));
                        result = (num *2.569);
                        Ozukgal.setText(String.valueOf(roundUp(result,4)));
                        result = (num *0.8392);
                        Slugyd.setText(String.valueOf(roundUp(result,4)));
                        result = (num *0.03108);
                        Slugft.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.00001799);
                        Slugin.setText(String.valueOf(roundUp(result,4)));
                        break;

                    case 9:
                        result = (num * 27.68);
                        Tm.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 27680);
                        kgM.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 27.68);
                        kgl.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 27680);
                        Gl.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 27680000);
                        Gm.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.02768);
                        Kgcm.setText(String.valueOf(roundUp(result,4)));
                        result = (num* 27.68);
                        Gcm.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 46660);
                        Lbyd.setText(String.valueOf(roundUp(result,4)));
                        result = (num*1728);
                        Lbft.setText(String.valueOf(roundUp(result,4)));
                        result = (num+0);
                        Lbin.setText(String.valueOf(roundUp(result,4)));
                        result = (num*231);
                        lbgal.setText(String.valueOf(roundUp(result,4)));
                        result = (num*277.4);
                        Lbukgal.setText(String.valueOf(roundUp(result,4)));
                        result = (num *746500);
                        Ozyd.setText(String.valueOf(roundUp(result,4)));
                        result = (num*27650);
                        Ozft.setText(String.valueOf(roundUp(result,4)));
                        result = (num *16);
                        Ozin.setText(String.valueOf(roundUp(result,4)));
                        result = (num*3696);
                        Ozgal.setText(String.valueOf(roundUp(result,4)));
                        result = (num *4439);
                        Ozukgal.setText(String.valueOf(roundUp(result,4)));
                        result = (num *1450);
                        Slugyd.setText(String.valueOf(roundUp(result,4)));
                        result = (num *53.71);
                        Slugft.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.03108);
                        Slugin.setText(String.valueOf(roundUp(result,4)));
                        break;

                    case 10:
                        result = (num * 0.1198);
                        Tm.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 119.8);
                        kgM.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.1198);
                        kgl.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 119.8);
                        Gl.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 119800);
                        Gm.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.0001198);
                        Kgcm.setText(String.valueOf(roundUp(result,4)));
                        result = (num* 0.1198);
                        Gcm.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 202);
                        Lbyd.setText(String.valueOf(roundUp(result,4)));
                        result = (num*7.481);
                        Lbft.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.004329);
                        Lbin.setText(String.valueOf(roundUp(result,4)));
                        result = (num+0);
                        lbgal.setText(String.valueOf(roundUp(result,4)));
                        result = (num*1.201);
                        Lbukgal.setText(String.valueOf(roundUp(result,4)));
                        result = (num *3232);
                        Ozyd.setText(String.valueOf(roundUp(result,4)));
                        result = (num*119.7);
                        Ozft.setText(String.valueOf(roundUp(result,4)));
                        result = (num *0.06926);
                        Ozin.setText(String.valueOf(roundUp(result,4)));
                        result = (num*16);
                        Ozgal.setText(String.valueOf(roundUp(result,4)));
                        result = (num *19.22);
                        Ozukgal.setText(String.valueOf(roundUp(result,4)));
                        result = (num *6.278);
                        Slugyd.setText(String.valueOf(roundUp(result,4)));
                        result = (num *0.2325);
                        Slugft.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.0001345);
                        Slugin.setText(String.valueOf(roundUp(result,4)));
                        break;
                    case 11:

                        result = (num * 0.09978);
                        Tm.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 99.78);
                        kgM.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.09978);
                        kgl.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 99.78);
                        Gl.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 99780);
                        Gm.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.00009978);
                        Kgcm.setText(String.valueOf(roundUp(result,4)));
                        result = (num* 0.09978);
                        Gcm.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 168.2);
                        Lbyd.setText(String.valueOf(roundUp(result,4)));
                        result = (num*6.229);
                        Lbft.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.003605);
                        Lbin.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.8327);
                        lbgal.setText(String.valueOf(roundUp(result,4)));
                        result = (num+0);
                        Lbukgal.setText(String.valueOf(roundUp(result,4)));
                        result = (num *2691);
                        Ozyd.setText(String.valueOf(roundUp(result,4)));
                        result = (num*99.66);
                        Ozft.setText(String.valueOf(roundUp(result,4)));
                        result = (num *0.05767);
                        Ozin.setText(String.valueOf(roundUp(result,4)));
                        result = (num*13.32);
                        Ozgal.setText(String.valueOf(roundUp(result,4)));
                        result = (num *16);
                        Ozukgal.setText(String.valueOf(roundUp(result,4)));
                        result = (num *5.227);
                        Slugyd.setText(String.valueOf(roundUp(result,4)));
                        result = (num *0.1936);
                        Slugft.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.000112);
                        Slugin.setText(String.valueOf(roundUp(result,4)));

                        break;
                    case 12:
                        result = (num * 0.00003708);
                        Tm.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.03708);
                        kgM.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.00003708);
                        kgl.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.03708);
                        Gl.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 37.08);
                        Gm.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.00000003708);
                        Kgcm.setText(String.valueOf(roundUp(result,4)));
                        result = (num* 0.00003708);
                        Gcm.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.0625);
                        Lbyd.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.002315);
                        Lbft.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.00000134);
                        Lbin.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.0003094);
                        lbgal.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.0003716);
                        Lbukgal.setText(String.valueOf(roundUp(result,4)));
                        result = (num+ 0);
                        Ozyd.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.03704);
                        Ozft.setText(String.valueOf(roundUp(result,4)));
                        result = (num *0.00002143);
                        Ozin.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.004951);
                        Ozgal.setText(String.valueOf(roundUp(result,4)));
                        result = (num *0.005946);
                        Ozukgal.setText(String.valueOf(roundUp(result,4)));
                        result = (num *0.001943);
                        Slugyd.setText(String.valueOf(roundUp(result,4)));
                        result = (num *0.00007195);
                        Slugft.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.00000004164);
                        Slugin.setText(String.valueOf(roundUp(result,4)));
                        break;

                    case 13:
                        result = (num * 0.001001);
                        Tm.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 1.001);
                        kgM.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.001001);
                        kgl.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 1.001);
                        Gl.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 1001);
                        Gm.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.000001001);
                        Kgcm.setText(String.valueOf(roundUp(result,4)));
                        result = (num* 0.001001);
                        Gcm.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 1.688);
                        Lbyd.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.0625);
                        Lbft.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.00003617);
                        Lbin.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.008355);
                        lbgal.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.01003);
                        Lbukgal.setText(String.valueOf(roundUp(result,4)));
                        result = (num* 27);
                        Ozyd.setText(String.valueOf(roundUp(result,4)));
                        result = (num+0);
                        Ozft.setText(String.valueOf(roundUp(result,4)));
                        result = (num *0.0005787);
                        Ozin.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.1337);
                        Ozgal.setText(String.valueOf(roundUp(result,4)));
                        result = (num *0.1605);
                        Ozukgal.setText(String.valueOf(roundUp(result,4)));
                        result = (num *0.05245);
                        Slugyd.setText(String.valueOf(roundUp(result,4)));
                        result = (num *0.001943);
                        Slugft.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.000001124);
                        Slugin.setText(String.valueOf(roundUp(result,4)));
                        break;

                    case 14:
                        result = (num * 1.73);
                        Tm.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 1730);
                        kgM.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 1.73);
                        kgl.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 1730);
                        Gl.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 1730000);
                        Gm.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.00173);
                        Kgcm.setText(String.valueOf(roundUp(result,4)));
                        result = (num* 1.73);
                        Gcm.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 2916);
                        Lbyd.setText(String.valueOf(roundUp(result,4)));
                        result = (num*108);
                        Lbft.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.0625);
                        Lbin.setText(String.valueOf(roundUp(result,4)));
                        result = (num*14.44);
                        lbgal.setText(String.valueOf(roundUp(result,4)));
                        result = (num*17.34);
                        Lbukgal.setText(String.valueOf(roundUp(result,4)));
                        result = (num* 46660);
                        Ozyd.setText(String.valueOf(roundUp(result,4)));
                        result = (num*1728);
                        Ozft.setText(String.valueOf(roundUp(result,4)));
                        result = (num+0);
                        Ozin.setText(String.valueOf(roundUp(result,4)));
                        result = (num*231);
                        Ozgal.setText(String.valueOf(roundUp(result,4)));
                        result = (num *277.4);
                        Ozukgal.setText(String.valueOf(roundUp(result,4)));
                        result = (num *90.63);
                        Slugyd.setText(String.valueOf(roundUp(result,4)));
                        result = (num *3.357);
                        Slugft.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.001943);
                        Slugin.setText(String.valueOf(roundUp(result,4)));
                        break;

                    case 15:
                        result = (num * 0.007489);
                        Tm.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 7.489);
                        kgM.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.007489);
                        kgl.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 7.489);
                        Gl.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 7489);
                        Gm.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.000007489);
                        Kgcm.setText(String.valueOf(roundUp(result,4)));
                        result = (num* 0.007489);
                        Gcm.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 12.62);
                        Lbyd.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.4675);
                        Lbft.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.0002706);
                        Lbin.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.0625);
                        lbgal.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.07506);
                        Lbukgal.setText(String.valueOf(roundUp(result,4)));
                        result = (num* 202);
                        Ozyd.setText(String.valueOf(roundUp(result,4)));
                        result = (num*7.481);
                        Ozft.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.004329);
                        Ozin.setText(String.valueOf(roundUp(result,4)));
                        result = (num+0);
                        Ozgal.setText(String.valueOf(roundUp(result,4)));
                        result = (num *1.201);
                        Ozukgal.setText(String.valueOf(roundUp(result,4)));
                        result = (num *0.3923);
                        Slugyd.setText(String.valueOf(roundUp(result,4)));
                        result = (num *0.01453);
                        Slugft.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.000008409);
                        Slugin.setText(String.valueOf(roundUp(result,4)));
                        break;

                    case 16:

                        result = (num * 0.006236);
                        Tm.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 6.236);
                        kgM.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.006236);
                        kgl.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 6.236);
                        Gl.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 6236);
                        Gm.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.000006236);
                        Kgcm.setText(String.valueOf(roundUp(result,4)));
                        result = (num* 0.006236);
                        Gcm.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 10.51);
                        Lbyd.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.3893);
                        Lbft.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.0002253);
                        Lbin.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.05204);
                        lbgal.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.0625);
                        Lbukgal.setText(String.valueOf(roundUp(result,4)));
                        result = (num* 168.2);
                        Ozyd.setText(String.valueOf(roundUp(result,4)));
                        result = (num*6.229);
                        Ozft.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.003605);
                        Ozin.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.8327);
                        Ozgal.setText(String.valueOf(roundUp(result,4)));
                        result = (num +0);
                        Ozukgal.setText(String.valueOf(roundUp(result,4)));
                        result = (num *0.3267);
                        Slugyd.setText(String.valueOf(roundUp(result,4)));
                        result = (num *0.0121);
                        Slugft.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.000007002);
                        Slugin.setText(String.valueOf(roundUp(result,4)));
                        break;

                    case 17:

                        result = (num * 0.01909);
                        Tm.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 19.09);
                        kgM.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.01909);
                        kgl.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 19.09);
                        Gl.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 19090);
                        Gm.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.00001909);
                        Kgcm.setText(String.valueOf(roundUp(result,4)));
                        result = (num* 0.01909);
                        Gcm.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 32.17);
                        Lbyd.setText(String.valueOf(roundUp(result,4)));
                        result = (num*1.192);
                        Lbft.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.0006896);
                        Lbin.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.1593);
                        lbgal.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.1913);
                        Lbukgal.setText(String.valueOf(roundUp(result,4)));
                        result = (num* 514.8);
                        Ozyd.setText(String.valueOf(roundUp(result,4)));
                        result = (num*19.07);
                        Ozft.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.01103);
                        Ozin.setText(String.valueOf(roundUp(result,4)));
                        result = (num*2.549);
                        Ozgal.setText(String.valueOf(roundUp(result,4)));
                        result = (num*3.061);
                        Ozukgal.setText(String.valueOf(roundUp(result,4)));
                        result = (num +0);
                        Slugyd.setText(String.valueOf(roundUp(result,4)));
                        result = (num *0.03704);
                        Slugft.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.00002143);
                        Slugin.setText(String.valueOf(roundUp(result,4)));
                        break;

                    case 18:
                        result = (num * 0.5154);
                        Tm.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 515.4);
                        kgM.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.5154);
                        kgl.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 515.4);
                        Gl.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 515400);
                        Gm.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.0005154);
                        Kgcm.setText(String.valueOf(roundUp(result,4)));
                        result = (num* 0.5154);
                        Gcm.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 868.7);
                        Lbyd.setText(String.valueOf(roundUp(result,4)));
                        result = (num*32.17);
                        Lbft.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.01862);
                        Lbin.setText(String.valueOf(roundUp(result,4)));
                        result = (num*4.301);
                        lbgal.setText(String.valueOf(roundUp(result,4)));
                        result = (num*5.165);
                        Lbukgal.setText(String.valueOf(roundUp(result,4)));
                        result = (num* 13900);
                        Ozyd.setText(String.valueOf(roundUp(result,4)));
                        result = (num*514.8);
                        Ozft.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.2979);
                        Ozin.setText(String.valueOf(roundUp(result,4)));
                        result = (num*68.82);
                        Ozgal.setText(String.valueOf(roundUp(result,4)));
                        result = (num*82.65);
                        Ozukgal.setText(String.valueOf(roundUp(result,4)));
                        result = (num *27);
                        Slugyd.setText(String.valueOf(roundUp(result,4)));
                        result = (num +0);
                        Slugft.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.0005787);
                        Slugin.setText(String.valueOf(roundUp(result,4)));
                        break;

                    case 19:
                        result = (num *890.6);
                        Tm.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 890600);
                        kgM.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 890.6);
                        kgl.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 890600);
                        Gl.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 890600000);
                        Gm.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.8906);
                        Kgcm.setText(String.valueOf(roundUp(result,4)));
                        result = (num* 890.6);
                        Gcm.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 1501000);
                        Lbyd.setText(String.valueOf(roundUp(result,4)));
                        result = (num*55600);
                        Lbft.setText(String.valueOf(roundUp(result,4)));
                        result = (num*32.17);
                        Lbin.setText(String.valueOf(roundUp(result,4)));
                        result = (num*7432);
                        lbgal.setText(String.valueOf(roundUp(result,4)));
                        result = (num*8926);
                        Lbukgal.setText(String.valueOf(roundUp(result,4)));
                        result = (num* 24020000);
                        Ozyd.setText(String.valueOf(roundUp(result,4)));
                        result = (num*889500);
                        Ozft.setText(String.valueOf(roundUp(result,4)));
                        result = (num*514.8);
                        Ozin.setText(String.valueOf(roundUp(result,4)));
                        result = (num*118900);
                        Ozgal.setText(String.valueOf(roundUp(result,4)));
                        result = (num*142800);
                        Ozukgal.setText(String.valueOf(roundUp(result,4)));
                        result = (num *46660);
                        Slugyd.setText(String.valueOf(roundUp(result,4)));
                        result = (num *1728);
                        Slugft.setText(String.valueOf(roundUp(result,4)));
                        result = (num+0);
                        Slugin.setText(String.valueOf(roundUp(result,4)));
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



            Tm.setText("");
            kgM.setText("");
            Gm.setText("");
            kgl.setText("");
            Gl.setText("");
            Kgcm.setText("");
            Gcm.setText("");
            Lbyd.setText("");
            Lbft.setText("");
            Lbin.setText("");
            lbgal.setText("");
            Lbukgal.setText("");
            Ozyd.setText("");
            Ozft.setText("");
            Ozin.setText("");
            Ozgal.setText("");
            Ozukgal.setText("");
            Slugyd.setText("");
            Slugft.setText("");
            Slugin.setText("");


            return;

        }

        num = Float.parseFloat(edNum.getText().toString());


        switch (a){
            case 0:
                result = (num + 0);
                Tm.setText(String.valueOf(roundUp(result,4)));
                result = (num * 1000);
                kgM.setText(String.valueOf(roundUp(result,4)));
                result = (num * 1);
                kgl.setText(String.valueOf(roundUp(result,4)));
                result = (num * 1000);
                Gl.setText(String.valueOf(roundUp(result,4)));
                result = (num * 1000000);
                Gm.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.001);
                Kgcm.setText(String.valueOf(roundUp(result,4)));
                result = (num* 1);
                Gcm.setText(String.valueOf(roundUp(result,4)));
                result = (num * 1686);
                Lbyd.setText(String.valueOf(roundUp(result,4)));
                result = (num*62.43);
                Lbft.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.03613);
                Lbin.setText(String.valueOf(roundUp(result,4)));
                result = (num*8.345);
                lbgal.setText(String.valueOf(roundUp(result,4)));
                result = (num*10.02);
                Lbukgal.setText(String.valueOf(roundUp(result,4)));
                result = (num *26970);
                Ozyd.setText(String.valueOf(roundUp(result,4)));
                result = (num*998.8);
                Ozft.setText(String.valueOf(roundUp(result,4)));
                result = (num *0.578);
                Ozin.setText(String.valueOf(roundUp(result,4)));
                result = (num*133.5);
                Ozgal.setText(String.valueOf(roundUp(result,4)));
                result = (num *160.4);
                Ozukgal.setText(String.valueOf(roundUp(result,4)));
                result = (num *52.39);
                Slugyd.setText(String.valueOf(roundUp(result,4)));
                result = (num *1.94);
                Slugft.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.001123);
                Slugin.setText(String.valueOf(roundUp(result,4)));
                break;

            case 1:
                result = (num * 0.001);
                Tm.setText(String.valueOf(roundUp(result,4)));
                result = (num + 0);
                kgM.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.001);
                kgl.setText(String.valueOf(roundUp(result,4)));
                result = (num * 1);
                Gl.setText(String.valueOf(roundUp(result,4)));
                result = (num * 1000);
                Gm.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.000001);
                Kgcm.setText(String.valueOf(roundUp(result,4)));
                result = (num* 0.001);
                Gcm.setText(String.valueOf(roundUp(result,4)));
                result = (num * 1.686);
                Lbyd.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.06243);
                Lbft.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.00003613);
                Lbin.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.008345);
                lbgal.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.01002);
                Lbukgal.setText(String.valueOf(roundUp(result,4)));
                result = (num *26.97);
                Ozyd.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.9988);
                Ozft.setText(String.valueOf(roundUp(result,4)));
                result = (num *0.000578);
                Ozin.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.1335);
                Ozgal.setText(String.valueOf(roundUp(result,4)));
                result = (num *0.1604);
                Ozukgal.setText(String.valueOf(roundUp(result,4)));
                result = (num *0.05239);
                Slugyd.setText(String.valueOf(roundUp(result,4)));
                result = (num *0.00194);
                Slugft.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.000001123);
                Slugin.setText(String.valueOf(roundUp(result,4)));
                break;

            case 2:
                result = (num * 1);
                Tm.setText(String.valueOf(roundUp(result,4)));
                result = (num * 1000);
                kgM.setText(String.valueOf(roundUp(result,4)));
                result = (num + 0);
                kgl.setText(String.valueOf(roundUp(result,4)));
                result = (num * 1000);
                Gl.setText(String.valueOf(roundUp(result,4)));
                result = (num * 1000000);
                Gm.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.001);
                Kgcm.setText(String.valueOf(roundUp(result,4)));
                result = (num* 1);
                Gcm.setText(String.valueOf(roundUp(result,4)));
                result = (num * 1686);
                Lbyd.setText(String.valueOf(roundUp(result,4)));
                result = (num*62.43);
                Lbft.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.03613);
                Lbin.setText(String.valueOf(roundUp(result,4)));
                result = (num*8.345);
                lbgal.setText(String.valueOf(roundUp(result,4)));
                result = (num*10.02);
                Lbukgal.setText(String.valueOf(roundUp(result,4)));
                result = (num *26970);
                Ozyd.setText(String.valueOf(roundUp(result,4)));
                result = (num*998.8);
                Ozft.setText(String.valueOf(roundUp(result,4)));
                result = (num *202.9);
                Ozin.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.578);
                Ozgal.setText(String.valueOf(roundUp(result,4)));
                result = (num *133.5);
                Ozukgal.setText(String.valueOf(roundUp(result,4)));
                result = (num *52.39);
                Slugyd.setText(String.valueOf(roundUp(result,4)));
                result = (num *1.94);
                Slugft.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.001123);
                Slugin.setText(String.valueOf(roundUp(result,4)));
                break;

            case 3:
                result = (num * 0.001);
                Tm.setText(String.valueOf(roundUp(result,4)));
                result = (num + 1);
                kgM.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.001);
                kgl.setText(String.valueOf(roundUp(result,4)));
                result = (num * 1);
                Gl.setText(String.valueOf(roundUp(result,4)));
                result = (num * 1000);
                Gm.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.000001);
                Kgcm.setText(String.valueOf(roundUp(result,4)));
                result = (num* 0.001);
                Gcm.setText(String.valueOf(roundUp(result,4)));
                result = (num * 1.686);
                Lbyd.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.06243);
                Lbft.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.00003613);
                Lbin.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.008345);
                lbgal.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.01002);
                Lbukgal.setText(String.valueOf(roundUp(result,4)));
                result = (num *26.97);
                Ozyd.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.9988);
                Ozft.setText(String.valueOf(roundUp(result,4)));
                result = (num *0.000578);
                Ozin.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.1335);
                Ozgal.setText(String.valueOf(roundUp(result,4)));
                result = (num *0.1604);
                Ozukgal.setText(String.valueOf(roundUp(result,4)));
                result = (num *0.05239);
                Slugyd.setText(String.valueOf(roundUp(result,4)));
                result = (num *0.00194);
                Slugft.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.000001123);
                Slugin.setText(String.valueOf(roundUp(result,4)));
                break;

            case 4:
                result = (num * 0.000001);
                Tm.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.001);
                kgM.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.000001);
                kgl.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.001);
                Gl.setText(String.valueOf(roundUp(result,4)));
                result = (num + 0);
                Gm.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.000000001);
                Kgcm.setText(String.valueOf(roundUp(result,4)));
                result = (num* 0.000001);
                Gcm.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.001686);
                Lbyd.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.00006243);
                Lbft.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.00000003613);
                Lbin.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.000008345);
                lbgal.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.00001002);
                Lbukgal.setText(String.valueOf(roundUp(result,4)));
                result = (num *0.02697);
                Ozyd.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.0009988);
                Ozft.setText(String.valueOf(roundUp(result,4)));
                result = (num *0.000000578);
                Ozin.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.0001335);
                Ozgal.setText(String.valueOf(roundUp(result,4)));
                result = (num *0.0001604);
                Ozukgal.setText(String.valueOf(roundUp(result,4)));
                result = (num *0.00005239);
                Slugyd.setText(String.valueOf(roundUp(result,4)));
                result = (num *0.00000194);
                Slugft.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.000000001123);
                Slugin.setText(String.valueOf(roundUp(result,4)));
                break;

            case 5:

                result = (num * 1000);
                Tm.setText(String.valueOf(roundUp(result,4)));
                result = (num * 1000000);
                kgM.setText(String.valueOf(roundUp(result,4)));
                result = (num * 1000);
                kgl.setText(String.valueOf(roundUp(result,4)));
                result = (num * 1000000);
                Gl.setText(String.valueOf(roundUp(result,4)));
                result = (num * 1e+9);
                Gm.setText(String.valueOf(roundUp(result,4)));
                result = (num + 0);
                Kgcm.setText(String.valueOf(roundUp(result,4)));
                result = (num* 1000);
                Gcm.setText(String.valueOf(roundUp(result,4)));
                result = (num * 1686000);
                Lbyd.setText(String.valueOf(roundUp(result,4)));
                result = (num*62430);
                Lbft.setText(String.valueOf(roundUp(result,4)));
                result = (num*36.13);
                Lbin.setText(String.valueOf(roundUp(result,4)));
                result = (num*8345);
                lbgal.setText(String.valueOf(roundUp(result,4)));
                result = (num*10020);
                Lbukgal.setText(String.valueOf(roundUp(result,4)));
                result = (num *26970000);
                Ozyd.setText(String.valueOf(roundUp(result,4)));
                result = (num*998800);
                Ozft.setText(String.valueOf(roundUp(result,4)));
                result = (num *578);
                Ozin.setText(String.valueOf(roundUp(result,4)));
                result = (num*133500);
                Ozgal.setText(String.valueOf(roundUp(result,4)));
                result = (num *160400);
                Ozukgal.setText(String.valueOf(roundUp(result,4)));
                result = (num *52390);
                Slugyd.setText(String.valueOf(roundUp(result,4)));
                result = (num *1940);
                Slugft.setText(String.valueOf(roundUp(result,4)));
                result = (num*1.123);
                Slugin.setText(String.valueOf(roundUp(result,4)));
                break;

            case 6:
                result = (num * 1);
                Tm.setText(String.valueOf(roundUp(result,4)));
                result = (num * 1000);
                kgM.setText(String.valueOf(roundUp(result,4)));
                result = (num * 1);
                kgl.setText(String.valueOf(roundUp(result,4)));
                result = (num * 1000);
                Gl.setText(String.valueOf(roundUp(result,4)));
                result = (num * 1000000);
                Gm.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.001);
                Kgcm.setText(String.valueOf(roundUp(result,4)));
                result = (num+ 0);
                Gcm.setText(String.valueOf(roundUp(result,4)));
                result = (num * 1686);
                Lbyd.setText(String.valueOf(roundUp(result,4)));
                result = (num*62.43);
                Lbft.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.03613);
                Lbin.setText(String.valueOf(roundUp(result,4)));
                result = (num*8.345);
                lbgal.setText(String.valueOf(roundUp(result,4)));
                result = (num*10.02);
                Lbukgal.setText(String.valueOf(roundUp(result,4)));
                result = (num *26970);
                Ozyd.setText(String.valueOf(roundUp(result,4)));
                result = (num*998.8);
                Ozft.setText(String.valueOf(roundUp(result,4)));
                result = (num *202.9);
                Ozin.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.578);
                Ozgal.setText(String.valueOf(roundUp(result,4)));
                result = (num *133.5);
                Ozukgal.setText(String.valueOf(roundUp(result,4)));
                result = (num *52.39);
                Slugyd.setText(String.valueOf(roundUp(result,4)));
                result = (num *1.94);
                Slugft.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.001123);
                Slugin.setText(String.valueOf(roundUp(result,4)));
                break;

            case 7:
                result = (num * 0.0005933);
                Tm.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.5933);
                kgM.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.0005933);
                kgl.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.5933);
                Gl.setText(String.valueOf(roundUp(result,4)));
                result = (num * 593.3);
                Gm.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.0000005933);
                Kgcm.setText(String.valueOf(roundUp(result,4)));
                result = (num* 0.0005933);
                Gcm.setText(String.valueOf(roundUp(result,4)));
                result = (num + 0);
                Lbyd.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.03704);
                Lbft.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.00002143);
                Lbin.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.004951);
                lbgal.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.005946);
                Lbukgal.setText(String.valueOf(roundUp(result,4)));
                result = (num *16);
                Ozyd.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.5926);
                Ozft.setText(String.valueOf(roundUp(result,4)));
                result = (num *0.0003429);
                Ozin.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.07922);
                Ozgal.setText(String.valueOf(roundUp(result,4)));
                result = (num *0.09514);
                Ozukgal.setText(String.valueOf(roundUp(result,4)));
                result = (num *0.03108);
                Slugyd.setText(String.valueOf(roundUp(result,4)));
                result = (num *0.001151);
                Slugft.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.0000006662);
                Slugin.setText(String.valueOf(roundUp(result,4)));
                break;
            case 8:
                result = (num * 0.01602);
                Tm.setText(String.valueOf(roundUp(result,4)));
                result = (num * 16.02);
                kgM.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.01602);
                kgl.setText(String.valueOf(roundUp(result,4)));
                result = (num * 16.02);
                Gl.setText(String.valueOf(roundUp(result,4)));
                result = (num * 16020);
                Gm.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.00001602);
                Kgcm.setText(String.valueOf(roundUp(result,4)));
                result = (num* 0.01602);
                Gcm.setText(String.valueOf(roundUp(result,4)));
                result = (num * 27);
                Lbyd.setText(String.valueOf(roundUp(result,4)));
                result = (num+0);
                Lbft.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.0005787);
                Lbin.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.1337);
                lbgal.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.1605);
                Lbukgal.setText(String.valueOf(roundUp(result,4)));
                result = (num *432);
                Ozyd.setText(String.valueOf(roundUp(result,4)));
                result = (num*16);
                Ozft.setText(String.valueOf(roundUp(result,4)));
                result = (num *0.009259);
                Ozin.setText(String.valueOf(roundUp(result,4)));
                result = (num*2.139);
                Ozgal.setText(String.valueOf(roundUp(result,4)));
                result = (num *2.569);
                Ozukgal.setText(String.valueOf(roundUp(result,4)));
                result = (num *0.8392);
                Slugyd.setText(String.valueOf(roundUp(result,4)));
                result = (num *0.03108);
                Slugft.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.00001799);
                Slugin.setText(String.valueOf(roundUp(result,4)));
                break;

            case 9:
                result = (num * 27.68);
                Tm.setText(String.valueOf(roundUp(result,4)));
                result = (num * 27680);
                kgM.setText(String.valueOf(roundUp(result,4)));
                result = (num * 27.68);
                kgl.setText(String.valueOf(roundUp(result,4)));
                result = (num * 27680);
                Gl.setText(String.valueOf(roundUp(result,4)));
                result = (num * 27680000);
                Gm.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.02768);
                Kgcm.setText(String.valueOf(roundUp(result,4)));
                result = (num* 27.68);
                Gcm.setText(String.valueOf(roundUp(result,4)));
                result = (num * 46660);
                Lbyd.setText(String.valueOf(roundUp(result,4)));
                result = (num*1728);
                Lbft.setText(String.valueOf(roundUp(result,4)));
                result = (num+0);
                Lbin.setText(String.valueOf(roundUp(result,4)));
                result = (num*231);
                lbgal.setText(String.valueOf(roundUp(result,4)));
                result = (num*277.4);
                Lbukgal.setText(String.valueOf(roundUp(result,4)));
                result = (num *746500);
                Ozyd.setText(String.valueOf(roundUp(result,4)));
                result = (num*27650);
                Ozft.setText(String.valueOf(roundUp(result,4)));
                result = (num *16);
                Ozin.setText(String.valueOf(roundUp(result,4)));
                result = (num*3696);
                Ozgal.setText(String.valueOf(roundUp(result,4)));
                result = (num *4439);
                Ozukgal.setText(String.valueOf(roundUp(result,4)));
                result = (num *1450);
                Slugyd.setText(String.valueOf(roundUp(result,4)));
                result = (num *53.71);
                Slugft.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.03108);
                Slugin.setText(String.valueOf(roundUp(result,4)));
                break;
            case 10:
                result = (num * 0.1198);
                Tm.setText(String.valueOf(roundUp(result,4)));
                result = (num * 119.8);
                kgM.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.1198);
                kgl.setText(String.valueOf(roundUp(result,4)));
                result = (num * 119.8);
                Gl.setText(String.valueOf(roundUp(result,4)));
                result = (num * 119800);
                Gm.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.0001198);
                Kgcm.setText(String.valueOf(roundUp(result,4)));
                result = (num* 0.1198);
                Gcm.setText(String.valueOf(roundUp(result,4)));
                result = (num * 202);
                Lbyd.setText(String.valueOf(roundUp(result,4)));
                result = (num*7.481);
                Lbft.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.004329);
                Lbin.setText(String.valueOf(roundUp(result,4)));
                result = (num+0);
                lbgal.setText(String.valueOf(roundUp(result,4)));
                result = (num*1.201);
                Lbukgal.setText(String.valueOf(roundUp(result,4)));
                result = (num *3232);
                Ozyd.setText(String.valueOf(roundUp(result,4)));
                result = (num*119.7);
                Ozft.setText(String.valueOf(roundUp(result,4)));
                result = (num *0.06926);
                Ozin.setText(String.valueOf(roundUp(result,4)));
                result = (num*16);
                Ozgal.setText(String.valueOf(roundUp(result,4)));
                result = (num *19.22);
                Ozukgal.setText(String.valueOf(roundUp(result,4)));
                result = (num *6.278);
                Slugyd.setText(String.valueOf(roundUp(result,4)));
                result = (num *0.2325);
                Slugft.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.0001345);
                Slugin.setText(String.valueOf(roundUp(result,4)));
                break;

            case 11:
                result = (num * 0.09978);
                Tm.setText(String.valueOf(roundUp(result,4)));
                result = (num * 99.78);
                kgM.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.09978);
                kgl.setText(String.valueOf(roundUp(result,4)));
                result = (num * 99.78);
                Gl.setText(String.valueOf(roundUp(result,4)));
                result = (num * 99780);
                Gm.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.00009978);
                Kgcm.setText(String.valueOf(roundUp(result,4)));
                result = (num* 0.09978);
                Gcm.setText(String.valueOf(roundUp(result,4)));
                result = (num * 168.2);
                Lbyd.setText(String.valueOf(roundUp(result,4)));
                result = (num*6.229);
                Lbft.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.003605);
                Lbin.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.8327);
                lbgal.setText(String.valueOf(roundUp(result,4)));
                result = (num+0);
                Lbukgal.setText(String.valueOf(roundUp(result,4)));
                result = (num *2691);
                Ozyd.setText(String.valueOf(roundUp(result,4)));
                result = (num*99.66);
                Ozft.setText(String.valueOf(roundUp(result,4)));
                result = (num *0.05767);
                Ozin.setText(String.valueOf(roundUp(result,4)));
                result = (num*13.32);
                Ozgal.setText(String.valueOf(roundUp(result,4)));
                result = (num *16);
                Ozukgal.setText(String.valueOf(roundUp(result,4)));
                result = (num *5.227);
                Slugyd.setText(String.valueOf(roundUp(result,4)));
                result = (num *0.1936);
                Slugft.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.000112);
                Slugin.setText(String.valueOf(roundUp(result,4)));
                break;
            case 12:
                result = (num * 0.00003708);
                Tm.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.03708);
                kgM.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.00003708);
                kgl.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.03708);
                Gl.setText(String.valueOf(roundUp(result,4)));
                result = (num * 37.08);
                Gm.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.00000003708);
                Kgcm.setText(String.valueOf(roundUp(result,4)));
                result = (num* 0.00003708);
                Gcm.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.0625);
                Lbyd.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.002315);
                Lbft.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.00000134);
                Lbin.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.0003094);
                lbgal.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.0003716);
                Lbukgal.setText(String.valueOf(roundUp(result,4)));
                result = (num+ 0);
                Ozyd.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.03704);
                Ozft.setText(String.valueOf(roundUp(result,4)));
                result = (num *0.00002143);
                Ozin.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.004951);
                Ozgal.setText(String.valueOf(roundUp(result,4)));
                result = (num *0.005946);
                Ozukgal.setText(String.valueOf(roundUp(result,4)));
                result = (num *0.001943);
                Slugyd.setText(String.valueOf(roundUp(result,4)));
                result = (num *0.00007195);
                Slugft.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.00000004164);
                Slugin.setText(String.valueOf(roundUp(result,4)));
                break;

            case 13:
                result = (num * 0.001001);
                Tm.setText(String.valueOf(roundUp(result,4)));
                result = (num * 1.001);
                kgM.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.001001);
                kgl.setText(String.valueOf(roundUp(result,4)));
                result = (num * 1.001);
                Gl.setText(String.valueOf(roundUp(result,4)));
                result = (num * 1001);
                Gm.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.000001001);
                Kgcm.setText(String.valueOf(roundUp(result,4)));
                result = (num* 0.001001);
                Gcm.setText(String.valueOf(roundUp(result,4)));
                result = (num * 1.688);
                Lbyd.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.0625);
                Lbft.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.00003617);
                Lbin.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.008355);
                lbgal.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.01003);
                Lbukgal.setText(String.valueOf(roundUp(result,4)));
                result = (num* 27);
                Ozyd.setText(String.valueOf(roundUp(result,4)));
                result = (num+0);
                Ozft.setText(String.valueOf(roundUp(result,4)));
                result = (num *0.0005787);
                Ozin.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.1337);
                Ozgal.setText(String.valueOf(roundUp(result,4)));
                result = (num *0.1605);
                Ozukgal.setText(String.valueOf(roundUp(result,4)));
                result = (num *0.05245);
                Slugyd.setText(String.valueOf(roundUp(result,4)));
                result = (num *0.001943);
                Slugft.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.000001124);
                Slugin.setText(String.valueOf(roundUp(result,4)));
                break;

            case 14:
                result = (num * 1.73);
                Tm.setText(String.valueOf(roundUp(result,4)));
                result = (num * 1730);
                kgM.setText(String.valueOf(roundUp(result,4)));
                result = (num * 1.73);
                kgl.setText(String.valueOf(roundUp(result,4)));
                result = (num * 1730);
                Gl.setText(String.valueOf(roundUp(result,4)));
                result = (num * 1730000);
                Gm.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.00173);
                Kgcm.setText(String.valueOf(roundUp(result,4)));
                result = (num* 1.73);
                Gcm.setText(String.valueOf(roundUp(result,4)));
                result = (num * 2916);
                Lbyd.setText(String.valueOf(roundUp(result,4)));
                result = (num*108);
                Lbft.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.0625);
                Lbin.setText(String.valueOf(roundUp(result,4)));
                result = (num*14.44);
                lbgal.setText(String.valueOf(roundUp(result,4)));
                result = (num*17.34);
                Lbukgal.setText(String.valueOf(roundUp(result,4)));
                result = (num* 46660);
                Ozyd.setText(String.valueOf(roundUp(result,4)));
                result = (num*1728);
                Ozft.setText(String.valueOf(roundUp(result,4)));
                result = (num+0);
                Ozin.setText(String.valueOf(roundUp(result,4)));
                result = (num*231);
                Ozgal.setText(String.valueOf(roundUp(result,4)));
                result = (num *277.4);
                Ozukgal.setText(String.valueOf(roundUp(result,4)));
                result = (num *90.63);
                Slugyd.setText(String.valueOf(roundUp(result,4)));
                result = (num *3.357);
                Slugft.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.001943);
                Slugin.setText(String.valueOf(roundUp(result,4)));
                break;
            case 15:
                result = (num * 0.007489);
                Tm.setText(String.valueOf(roundUp(result,4)));
                result = (num * 7.489);
                kgM.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.007489);
                kgl.setText(String.valueOf(roundUp(result,4)));
                result = (num * 7.489);
                Gl.setText(String.valueOf(roundUp(result,4)));
                result = (num * 7489);
                Gm.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.000007489);
                Kgcm.setText(String.valueOf(roundUp(result,4)));
                result = (num* 0.007489);
                Gcm.setText(String.valueOf(roundUp(result,4)));
                result = (num * 12.62);
                Lbyd.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.4675);
                Lbft.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.0002706);
                Lbin.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.0625);
                lbgal.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.07506);
                Lbukgal.setText(String.valueOf(roundUp(result,4)));
                result = (num* 202);
                Ozyd.setText(String.valueOf(roundUp(result,4)));
                result = (num*7.481);
                Ozft.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.004329);
                Ozin.setText(String.valueOf(roundUp(result,4)));
                result = (num+0);
                Ozgal.setText(String.valueOf(roundUp(result,4)));
                result = (num *1.201);
                Ozukgal.setText(String.valueOf(roundUp(result,4)));
                result = (num *0.3923);
                Slugyd.setText(String.valueOf(roundUp(result,4)));
                result = (num *0.01453);
                Slugft.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.000008409);
                Slugin.setText(String.valueOf(roundUp(result,4)));
                break;
            case 16:
                result = (num * 0.006236);
                Tm.setText(String.valueOf(roundUp(result,4)));
                result = (num * 6.236);
                kgM.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.006236);
                kgl.setText(String.valueOf(roundUp(result,4)));
                result = (num * 6.236);
                Gl.setText(String.valueOf(roundUp(result,4)));
                result = (num * 6236);
                Gm.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.000006236);
                Kgcm.setText(String.valueOf(roundUp(result,4)));
                result = (num* 0.006236);
                Gcm.setText(String.valueOf(roundUp(result,4)));
                result = (num * 10.51);
                Lbyd.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.3893);
                Lbft.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.0002253);
                Lbin.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.05204);
                lbgal.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.0625);
                Lbukgal.setText(String.valueOf(roundUp(result,4)));
                result = (num* 168.2);
                Ozyd.setText(String.valueOf(roundUp(result,4)));
                result = (num*6.229);
                Ozft.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.003605);
                Ozin.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.8327);
                Ozgal.setText(String.valueOf(roundUp(result,4)));
                result = (num +0);
                Ozukgal.setText(String.valueOf(roundUp(result,4)));
                result = (num *0.3267);
                Slugyd.setText(String.valueOf(roundUp(result,4)));
                result = (num *0.0121);
                Slugft.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.000007002);
                Slugin.setText(String.valueOf(roundUp(result,4)));
                break;

            case 17:
                result = (num * 0.01909);
                Tm.setText(String.valueOf(roundUp(result,4)));
                result = (num * 19.09);
                kgM.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.01909);
                kgl.setText(String.valueOf(roundUp(result,4)));
                result = (num * 19.09);
                Gl.setText(String.valueOf(roundUp(result,4)));
                result = (num * 19090);
                Gm.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.00001909);
                Kgcm.setText(String.valueOf(roundUp(result,4)));
                result = (num* 0.01909);
                Gcm.setText(String.valueOf(roundUp(result,4)));
                result = (num * 32.17);
                Lbyd.setText(String.valueOf(roundUp(result,4)));
                result = (num*1.192);
                Lbft.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.0006896);
                Lbin.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.1593);
                lbgal.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.1913);
                Lbukgal.setText(String.valueOf(roundUp(result,4)));
                result = (num* 514.8);
                Ozyd.setText(String.valueOf(roundUp(result,4)));
                result = (num*19.07);
                Ozft.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.01103);
                Ozin.setText(String.valueOf(roundUp(result,4)));
                result = (num*2.549);
                Ozgal.setText(String.valueOf(roundUp(result,4)));
                result = (num*3.061);
                Ozukgal.setText(String.valueOf(roundUp(result,4)));
                result = (num +0);
                Slugyd.setText(String.valueOf(roundUp(result,4)));
                result = (num *0.03704);
                Slugft.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.00002143);
                Slugin.setText(String.valueOf(roundUp(result,4)));
                break;

            case 18:

                result = (num * 0.5154);
                Tm.setText(String.valueOf(roundUp(result,4)));
                result = (num * 515.4);
                kgM.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.5154);
                kgl.setText(String.valueOf(roundUp(result,4)));
                result = (num * 515.4);
                Gl.setText(String.valueOf(roundUp(result,4)));
                result = (num * 515400);
                Gm.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.0005154);
                Kgcm.setText(String.valueOf(roundUp(result,4)));
                result = (num* 0.5154);
                Gcm.setText(String.valueOf(roundUp(result,4)));
                result = (num * 868.7);
                Lbyd.setText(String.valueOf(roundUp(result,4)));
                result = (num*32.17);
                Lbft.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.01862);
                Lbin.setText(String.valueOf(roundUp(result,4)));
                result = (num*4.301);
                lbgal.setText(String.valueOf(roundUp(result,4)));
                result = (num*5.165);
                Lbukgal.setText(String.valueOf(roundUp(result,4)));
                result = (num* 13900);
                Ozyd.setText(String.valueOf(roundUp(result,4)));
                result = (num*514.8);
                Ozft.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.2979);
                Ozin.setText(String.valueOf(roundUp(result,4)));
                result = (num*68.82);
                Ozgal.setText(String.valueOf(roundUp(result,4)));
                result = (num*82.65);
                Ozukgal.setText(String.valueOf(roundUp(result,4)));
                result = (num *27);
                Slugyd.setText(String.valueOf(roundUp(result,4)));
                result = (num +0);
                Slugft.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.0005787);
                Slugin.setText(String.valueOf(roundUp(result, 3)));

                break;
            case 19:
                result = (num *890.6);
                Tm.setText(String.valueOf(roundUp(result,4)));
                result = (num * 890600);
                kgM.setText(String.valueOf(roundUp(result,4)));
                result = (num * 890.6);
                kgl.setText(String.valueOf(roundUp(result,4)));
                result = (num * 890600);
                Gl.setText(String.valueOf(roundUp(result,4)));
                result = (num * 890600000);
                Gm.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.8906);
                Kgcm.setText(String.valueOf(roundUp(result,4)));
                result = (num* 890.6);
                Gcm.setText(String.valueOf(roundUp(result,4)));
                result = (num * 1501000);
                Lbyd.setText(String.valueOf(roundUp(result,4)));
                result = (num*55600);
                Lbft.setText(String.valueOf(roundUp(result,4)));
                result = (num*32.17);
                Lbin.setText(String.valueOf(roundUp(result,4)));
                result = (num*7432);
                lbgal.setText(String.valueOf(roundUp(result,4)));
                result = (num*8926);
                Lbukgal.setText(String.valueOf(roundUp(result,4)));
                result = (num* 24020000);
                Ozyd.setText(String.valueOf(roundUp(result,4)));
                result = (num*889500);
                Ozft.setText(String.valueOf(roundUp(result,4)));
                result = (num*514.8);
                Ozin.setText(String.valueOf(roundUp(result,4)));
                result = (num*118900);
                Ozgal.setText(String.valueOf(roundUp(result,4)));
                result = (num*142800);
                Ozukgal.setText(String.valueOf(roundUp(result,4)));
                result = (num *46660);
                Slugyd.setText(String.valueOf(roundUp(result,4)));
                result = (num *1728);
                Slugft.setText(String.valueOf(roundUp(result,4)));
                result = (num+0);
                Slugin.setText(String.valueOf(roundUp(result,4)));
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

