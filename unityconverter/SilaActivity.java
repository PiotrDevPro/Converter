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

public class SilaActivity extends AppCompatActivity implements TextWatcher{

   // String[] data = {"Ньютон (N)","Килоньютон (кN)","Кип-сила (kipf)","Тонна-сила (tnf)","Фунт-сила (lbf)","Унция-сила (ozf)","Фунтал (pdl)","Килограмм-сила (кgf)","Грамм-сила (gf)","Дина (dyn)"};
    int a;
    Spinner spMassa;
    EditText edNum,N, kN, kipf,tnf,lbf,ozf,pdl,kgf,gf,dyn;
   // TextView tvPosName;

    public BigDecimal roundUp(double value, int digits) {
        return new BigDecimal("" + value).setScale(digits, BigDecimal.ROUND_HALF_UP);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sila);

        Toolbar my_toolbar = (Toolbar) findViewById(R.id.my_toolbar_app);
        RelativeLayout backColorlayoutAds = (RelativeLayout) findViewById(R.id.reLayoutSilaAds);
        CollapsingToolbarLayout bottomColorLayout = (CollapsingToolbarLayout) findViewById(R.id.SilaBottomLayout);
        CoordinatorLayout corLoyDlinna = (CoordinatorLayout) findViewById(R.id.corLoyoutSila);
        setSupportActionBar(my_toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, //data);
     //   adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        getResources().getStringArray(R.array.Sila));


        spMassa = (Spinner) findViewById(R.id.spMassa);
        spMassa.setAdapter(adapter);


        edNum = (EditText) findViewById(R.id.edNum);
       // tvPosName = (TextView) findViewById(R.id.tvPosName);

        TextView Nm = (TextView) findViewById(R.id.NN);
        TextView Km = (TextView) findViewById(R.id.kNN);
        TextView Mile = (TextView) findViewById(R.id.kipff);
        TextView m = (TextView) findViewById(R.id.tnff);
        TextView yard = (TextView)  findViewById(R.id.lbff);
        TextView ozff = (TextView) findViewById(R.id.ozff);
        TextView pdll = (TextView) findViewById(R.id.pdll);
        TextView kgff = (TextView) findViewById(R.id.kgff);
        TextView gff = (TextView) findViewById(R.id.gff);
        TextView dynn = (TextView)  findViewById(R.id.dynn);

        N = (EditText) findViewById(R.id.N);
        kN = (EditText) findViewById(R.id.kN);
        kipf = (EditText) findViewById(R.id.kipf);
        tnf = (EditText) findViewById(R.id.tnf);
        lbf = (EditText) findViewById(R.id.lbf);
        ozf = (EditText) findViewById(R.id.ozf);
        pdl = (EditText) findViewById(R.id.pdl);
        kgf = (EditText) findViewById(R.id.kgf);
        gf = (EditText) findViewById(R.id.gf);
        dyn = (EditText) findViewById(R.id.dyn);

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




            N.setBackgroundColor(getEditTextActivityColor());
            N.setTextColor(getEditTextColor());
            kN.setBackgroundColor(getEditTextActivityColor());
            kN.setTextColor(getEditTextColor());
            kipf.setBackgroundColor(getEditTextActivityColor());
            kipf.setTextColor(getEditTextColor());
            tnf.setBackgroundColor(getEditTextActivityColor());
            tnf.setTextColor(getEditTextColor());
            lbf.setBackgroundColor(getEditTextActivityColor());
            lbf.setTextColor(getEditTextColor());

            ozf.setBackgroundColor(getEditTextActivityColor());
            ozf.setTextColor(getEditTextColor());
            pdl.setBackgroundColor(getEditTextActivityColor());
            pdl.setTextColor(getEditTextColor());
            kgf.setBackgroundColor(getEditTextActivityColor());
            kgf.setTextColor(getEditTextColor());
            gf.setBackgroundColor(getEditTextActivityColor());
            gf.setTextColor(getEditTextColor());
            dyn.setBackgroundColor(getEditTextActivityColor());
            dyn.setTextColor(getEditTextColor());



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
             //   tvPosName.setText(strName);
                a = position;

                double result = 0;
                double num = 0;

                if (TextUtils.isEmpty(edNum.getText().toString())
                        ||  (edNum.getText().toString().equals("."))
                        ||  (edNum.getText().toString().equals("-"))){



                    N.setText("");
                    kN.setText("");
                    kipf.setText("");
                    tnf.setText("");
                    lbf.setText("");
                    ozf.setText("");
                    pdl.setText("");
                    kgf.setText("");
                    gf.setText("");
                    dyn.setText("");

                    return;

                }

                num = Double.parseDouble(edNum.getText().toString());

                switch (position){

                    case 0:
                        result = (num + 0);
                        N.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.001);
                        kN.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.0002248);
                        kipf.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.0001124);
                        tnf.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.2248);
                        lbf.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 3.597);
                        ozf.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 7.233);
                        pdl.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.102);
                        kgf.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 102);
                        gf.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 100000);
                        dyn.setText(String.valueOf(roundUp(result,4)));
                        break;
                    case 1:
                        result = (num * 1000);
                        N.setText(String.valueOf(roundUp(result,4)));
                        result = (num + 0);
                        kN.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.2248);
                        kipf.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.1124);
                        tnf.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 224.8);
                        lbf.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 597);
                        ozf.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 7233);
                        pdl.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 102);
                        kgf.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 102000);
                        gf.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 100000000);
                        dyn.setText(String.valueOf(roundUp(result,4)));
                        break;
                    case 2:
                        result = (num * 4448);
                        N.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 4.448);
                        kN.setText(String.valueOf(roundUp(result,4)));
                        result = (num + 0);
                        kipf.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.5);
                        tnf.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 1000);
                        lbf.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 16000);
                        ozf.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 32170);
                        pdl.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 453.6);
                        kgf.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 453600);
                        gf.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 444800000);
                        dyn.setText(String.valueOf(roundUp(result,4)));
                        break;

                    case 3:
                        result = (num * 8896);
                        N.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 8.896);
                        kN.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 2);
                        kipf.setText(String.valueOf(roundUp(result,4)));
                        result = (num + 0);
                        tnf.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 2000);
                        lbf.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 32000);
                        ozf.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 64350);
                        pdl.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 907.2);
                        kgf.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 907200);
                        gf.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 889600000);
                        dyn.setText(String.valueOf(roundUp(result,4)));
                        break;

                    case 4:
                        result = (num * 4.448);
                        N.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.004448);
                        kN.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.001);
                        kipf.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.0005);
                        tnf.setText(String.valueOf(roundUp(result,4)));
                        result = (num + 0);
                        lbf.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 16);
                        ozf.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 32.17);
                        pdl.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.4536);
                        kgf.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 453.6);
                        gf.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 444800);
                        dyn.setText(String.valueOf(roundUp(result,4)));
                        break;

                    case 5:

                        result = (num * 0.278);
                        N.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.000278);
                        kN.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.0000625);
                        kipf.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.00003125);
                        tnf.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.0625);
                        lbf.setText(String.valueOf(roundUp(result,4)));
                        result = (num + 0);
                        ozf.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 2.011);
                        pdl.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.02835);
                        kgf.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 28.35);
                        gf.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 27800);
                        dyn.setText(String.valueOf(roundUp(result,4)));
                        break;

                    case 6:
                        result = (num * 0.1383);
                        N.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.0001383);
                        kN.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.00003108);
                        kipf.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.00001554);
                        tnf.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.03108);
                        lbf.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.4973);
                        ozf.setText(String.valueOf(roundUp(result,4)));
                        result = (num +0);
                        pdl.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.0141);
                        kgf.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 14.1);
                        gf.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 13830);
                        dyn.setText(String.valueOf(roundUp(result,4)));
                        break;

                    case 7:
                        result = (num * 9.807);
                        N.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.009807);
                        kN.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.002205);
                        kipf.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.001102);
                        tnf.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 2.205);
                        lbf.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 35.27);
                        ozf.setText(String.valueOf(roundUp(result,4)));
                        result = (num *70.93);
                        pdl.setText(String.valueOf(roundUp(result,4)));
                        result = (num + 0);
                        kgf.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 1000);
                        gf.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 980700);
                        dyn.setText(String.valueOf(roundUp(result,4)));
                        break;

                    case 8:
                        result = (num * 0.009807);
                        N.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.000009807);
                        kN.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.000002205);
                        kipf.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.000001102);
                        tnf.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.002205);
                        lbf.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.03527);
                        ozf.setText(String.valueOf(roundUp(result,4)));
                        result = (num *0.07093);
                        pdl.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.001);
                        kgf.setText(String.valueOf(roundUp(result,4)));
                        result = (num + 0);
                        gf.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 980.7);
                        dyn.setText(String.valueOf(roundUp(result,4)));
                        break;

                    case 9:
                        result = (num * 0.00001);
                        N.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.00000001);
                        kN.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.000000002248);
                        kipf.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.000000001124);
                        tnf.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.000002248);
                        lbf.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.00003597);
                        ozf.setText(String.valueOf(roundUp(result,4)));
                        result = (num *0.00007233);
                        pdl.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.00000102);
                        kgf.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.00102);
                        gf.setText(String.valueOf(roundUp(result,4)));
                        result = (num + 0);
                        dyn.setText(String.valueOf(roundUp(result,4)));
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


            N.setText("");
            kN.setText("");
            kipf.setText("");
            tnf.setText("");
            lbf.setText("");
            ozf.setText("");
            pdl.setText("");
            kgf.setText("");
            gf.setText("");
            dyn.setText("");

            return;
        }

        num = Double.parseDouble(edNum.getText().toString());

        switch (a) {

            case 0:
                result = (num + 0);
                N.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.001);
                kN.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.0002248);
                kipf.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.0001124);
                tnf.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.2248);
                lbf.setText(String.valueOf(roundUp(result,4)));
                result = (num * 3.597);
                ozf.setText(String.valueOf(roundUp(result,4)));
                result = (num * 7.233);
                pdl.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.102);
                kgf.setText(String.valueOf(roundUp(result,4)));
                result = (num * 102);
                gf.setText(String.valueOf(roundUp(result,4)));
                result = (num * 100000);
                dyn.setText(String.valueOf(roundUp(result,4)));
                break;

            case 1:
                result = (num * 1000);
                N.setText(String.valueOf(roundUp(result,4)));
                result = (num + 0);
                kN.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.2248);
                kipf.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.1124);
                tnf.setText(String.valueOf(roundUp(result,4)));
                result = (num * 224.8);
                lbf.setText(String.valueOf(roundUp(result,4)));
                result = (num * 597);
                ozf.setText(String.valueOf(roundUp(result,4)));
                result = (num * 7233);
                pdl.setText(String.valueOf(roundUp(result,4)));
                result = (num * 102);
                kgf.setText(String.valueOf(roundUp(result,4)));
                result = (num * 102000);
                gf.setText(String.valueOf(roundUp(result,4)));
                result = (num * 100000000);
                dyn.setText(String.valueOf(roundUp(result,4)));
                break;

            case 2:
                result = (num * 4448);
                N.setText(String.valueOf(roundUp(result,4)));
                result = (num * 4.448);
                kN.setText(String.valueOf(roundUp(result,4)));
                result = (num + 0);
                kipf.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.5);
                tnf.setText(String.valueOf(roundUp(result,4)));
                result = (num * 1000);
                lbf.setText(String.valueOf(roundUp(result,4)));
                result = (num * 16000);
                ozf.setText(String.valueOf(roundUp(result,4)));
                result = (num * 32170);
                pdl.setText(String.valueOf(roundUp(result,4)));
                result = (num * 453.6);
                kgf.setText(String.valueOf(roundUp(result,4)));
                result = (num * 453600);
                gf.setText(String.valueOf(roundUp(result,4)));
                result = (num * 444800000);
                dyn.setText(String.valueOf(roundUp(result,4)));
                break;

            case 3:
                result = (num * 8896);
                N.setText(String.valueOf(roundUp(result,4)));
                result = (num * 8.896);
                kN.setText(String.valueOf(roundUp(result,4)));
                result = (num * 2);
                kipf.setText(String.valueOf(roundUp(result,4)));
                result = (num + 0);
                tnf.setText(String.valueOf(roundUp(result,4)));
                result = (num * 2000);
                lbf.setText(String.valueOf(roundUp(result,4)));
                result = (num * 32000);
                ozf.setText(String.valueOf(roundUp(result,4)));
                result = (num * 64350);
                pdl.setText(String.valueOf(roundUp(result,4)));
                result = (num * 907.2);
                kgf.setText(String.valueOf(roundUp(result,4)));
                result = (num * 907200);
                gf.setText(String.valueOf(roundUp(result,4)));
                result = (num * 889600000);
                dyn.setText(String.valueOf(roundUp(result,4)));
                break;
            case 4:
                result = (num * 4.448);
                N.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.004448);
                kN.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.001);
                kipf.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.0005);
                tnf.setText(String.valueOf(roundUp(result,4)));
                result = (num + 0);
                lbf.setText(String.valueOf(roundUp(result,4)));
                result = (num * 16);
                ozf.setText(String.valueOf(roundUp(result,4)));
                result = (num * 32.17);
                pdl.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.4536);
                kgf.setText(String.valueOf(roundUp(result,4)));
                result = (num * 453.6);
                gf.setText(String.valueOf(roundUp(result,4)));
                result = (num * 444800);
                dyn.setText(String.valueOf(roundUp(result, 3)));
                break;

            case 5:

                result = (num * 0.278);
                N.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.000278);
                kN.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.0000625);
                kipf.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.00003125);
                tnf.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.0625);
                lbf.setText(String.valueOf(roundUp(result,4)));
                result = (num + 0);
                ozf.setText(String.valueOf(roundUp(result,4)));
                result = (num * 2.011);
                pdl.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.02835);
                kgf.setText(String.valueOf(roundUp(result,4)));
                result = (num * 28.35);
                gf.setText(String.valueOf(roundUp(result,4)));
                result = (num * 27800);
                dyn.setText(String.valueOf(roundUp(result, 3)));
                break;

            case 6:
                result = (num * 0.1383);
                N.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.0001383);
                kN.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.00003108);
                kipf.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.00001554);
                tnf.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.03108);
                lbf.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.4973);
                ozf.setText(String.valueOf(roundUp(result,4)));
                result = (num +0);
                pdl.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.0141);
                kgf.setText(String.valueOf(roundUp(result,4)));
                result = (num * 14.1);
                gf.setText(String.valueOf(roundUp(result,4)));
                result = (num * 13830);
                dyn.setText(String.valueOf(roundUp(result,4)));

                break;

            case 7:
                result = (num * 9.807);
                N.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.009807);
                kN.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.002205);
                kipf.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.001102);
                tnf.setText(String.valueOf(roundUp(result,4)));
                result = (num * 2.205);
                lbf.setText(String.valueOf(roundUp(result,4)));
                result = (num * 35.27);
                ozf.setText(String.valueOf(roundUp(result,4)));
                result = (num *70.93);
                pdl.setText(String.valueOf(roundUp(result,4)));
                result = (num + 0);
                kgf.setText(String.valueOf(roundUp(result,4)));
                result = (num * 1000);
                gf.setText(String.valueOf(roundUp(result,4)));
                result = (num * 980700);
                dyn.setText(String.valueOf(roundUp(result,4)));

                break;

            case 8:
                result = (num * 0.009807);
                N.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.000009807);
                kN.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.000002205);
                kipf.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.000001102);
                tnf.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.002205);
                lbf.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.03527);
                ozf.setText(String.valueOf(roundUp(result,4)));
                result = (num *0.07093);
                pdl.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.001);
                kgf.setText(String.valueOf(roundUp(result,4)));
                result = (num + 0);
                gf.setText(String.valueOf(roundUp(result,4)));
                result = (num * 980.7);
                dyn.setText(String.valueOf(roundUp(result,4)));

                break;

            case 9:
                result = (num * 0.00001);
                N.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.00000001);
                kN.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.000000002248);
                kipf.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.000000001124);
                tnf.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.000002248);
                lbf.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.00003597);
                ozf.setText(String.valueOf(roundUp(result,4)));
                result = (num *0.00007233);
                pdl.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.00000102);
                kgf.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.00102);
                gf.setText(String.valueOf(roundUp(result,4)));
                result = (num + 0);
                dyn.setText(String.valueOf(roundUp(result,4)));

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

