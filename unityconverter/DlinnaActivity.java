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

public class DlinnaActivity extends AppCompatActivity implements TextWatcher {

    // String[] data = {"Нанометр (nm)", "Микрометр (µm)", "Миллиметр (Mm)", "Сантиметр (Sm)", "Метр (M)", "Километр (Km)", "Миля (ml)", "Ярд (yard)", "Фут (ft)", "Дюйм (inch)", "Морская миля (NM)","Астрономическая единица (a.e)","красное смещение (z)","парсек (пк)","световой год","световая минута","световая секунда","\n" +
    //         "световая микросекунда","световая наносекунда","световая пикосекунда"};
    int a;
    Spinner spMassa;
    EditText edNum, edNano, edMicro, edMm, edSm, edM, edKm, edMil, edYard, edFut, edDuim, edSMil, edAE, edRed, edParsek, edAEyear, edAEmin, edAEsec, edAEmicro, edAEnano, edAEpiko;
    TextView tvPosName;
    Toolbar my_toolbar;

    //  CollapsingToolbarLayout bottomToolbar;

    public BigDecimal roundUp(double value, int digits) {
        return new BigDecimal("" + value).setScale(digits, BigDecimal.ROUND_HALF_UP);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        //  setTheme(Constant.theme);
        setContentView(R.layout.dlinna);

        Toolbar my_toolbar = (Toolbar) findViewById(R.id.my_toolbar_app);
        RelativeLayout backColorlayoutAds = (RelativeLayout) findViewById(R.id.reLayoutDlinnaAds);
        CollapsingToolbarLayout bottomColorLayout = (CollapsingToolbarLayout) findViewById(R.id.dlinnaBottomLayout);
        CoordinatorLayout corLoyDlinna = (CoordinatorLayout) findViewById(R.id.corLoyoutDlinna);
        //  bottomToolbar = (CollapsingToolbarLayout) findViewById(R.id.mainBottomLayout);

        setSupportActionBar(my_toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        //   my_toolbar.setBackgroundColor(Constant.color);


        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,// data);
                getResources().getStringArray(R.array.dlinna));
        //  adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        spMassa = (Spinner) findViewById(R.id.spMassa);
        spMassa.setAdapter(adapter);


        edNum = (EditText) findViewById(R.id.edNum);
        tvPosName = (TextView) findViewById(R.id.tvPosName);

        TextView Nm = (TextView) findViewById(R.id.NM);
        TextView Km = (TextView) findViewById(R.id.km);
        TextView Mile = (TextView) findViewById(R.id.Mile);
        TextView m = (TextView) findViewById(R.id.m);
        TextView yard = (TextView)  findViewById(R.id.yard);
        TextView ft = (TextView)  findViewById(R.id.foot);
        TextView In = (TextView)  findViewById(R.id.inch);

        TextView Sm = (TextView)  findViewById(R.id.sm);
        TextView mm = (TextView)  findViewById(R.id.Mm);
        TextView um = (TextView)  findViewById(R.id.Um);
        TextView nm = (TextView)  findViewById(R.id.nm);
        TextView AeL = (TextView)  findViewById(R.id.AeLabel);
        TextView Ae = (TextView)  findViewById(R.id.Ae);
        TextView Ae_red = (TextView)  findViewById(R.id.Ae_red);
        TextView parsek = (TextView)  findViewById(R.id.parsek);

        TextView Aegod = (TextView)  findViewById(R.id.AEgod);
        TextView Aemin = (TextView)  findViewById(R.id.Aemin);
        TextView AEsec = (TextView)  findViewById(R.id.AEsec);
        TextView AEmicrosek = (TextView)  findViewById(R.id.AEmicrosek);
        TextView AEnano = (TextView)  findViewById(R.id.AEnano);
        TextView AEpiko = (TextView)  findViewById(R.id.AEpiko);


        edNano = (EditText) findViewById(R.id.edNano);
        edMicro = (EditText) findViewById(R.id.edMicro);
        edMm = (EditText) findViewById(R.id.edMm);
        edSm = (EditText) findViewById(R.id.edSm);
        edM = (EditText) findViewById(R.id.edM);
        edKm = (EditText) findViewById(R.id.edKm);
        edMil = (EditText) findViewById(R.id.edMil);
        edYard = (EditText) findViewById(R.id.edYard);
        edFut = (EditText) findViewById(R.id.edFut);
        edDuim = (EditText) findViewById(R.id.edDuim);
        edSMil = (EditText) findViewById(R.id.edSMil);

        edAE = (EditText) findViewById(R.id.edAE);
        edRed = (EditText) findViewById(R.id.edRed);
        edParsek = (EditText) findViewById(R.id.edParsek);
        edAEyear = (EditText) findViewById(R.id.edAEyear);
        edAEmin = (EditText) findViewById(R.id.edAEmin);
        edAEsec = (EditText) findViewById(R.id.edAEsec);

        edAEmicro = (EditText) findViewById(R.id.edAEmicro);
        edAEnano = (EditText) findViewById(R.id.edAEnano);
        edAEpiko = (EditText) findViewById(R.id.edAEpiko);

//        if (getColor() != getResources().getColor(R.color.colorPrimary)){
//
//            toolbar.setBackgroundColor(getColor());
//            bottomToolbar.setBackgroundColor(getColor());
//            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//                getWindow().setStatusBarColor(getColor());
//            }

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
            AeL.setTextColor(getTextColor());
            nm.setTextColor(getTextColor());
            Ae.setTextColor(getTextColor());
            Ae_red.setTextColor(getTextColor());
            parsek.setTextColor(getTextColor());
            Aegod.setTextColor(getTextColor());
            Aemin.setTextColor(getTextColor());
            AEsec.setTextColor(getTextColor());
            AEmicrosek.setTextColor(getTextColor());
            AEnano.setTextColor(getTextColor());
            AEpiko.setTextColor(getTextColor());

            edSMil.setBackgroundColor(getEditTextActivityColor());
            edSMil.setTextColor(getEditTextColor());
            edMil.setBackgroundColor(getEditTextActivityColor());
            edMil.setTextColor(getEditTextColor());
            edKm.setBackgroundColor(getEditTextActivityColor());
            edKm.setTextColor(getEditTextColor());
            edM.setBackgroundColor(getEditTextActivityColor());
            edM.setTextColor(getEditTextColor());
            edYard.setBackgroundColor(getEditTextActivityColor());
            edYard.setTextColor(getEditTextColor());
            edFut.setBackgroundColor(getEditTextActivityColor());
            edFut.setTextColor(getEditTextColor());
            edNano.setBackgroundColor(getEditTextActivityColor());
            edNano.setTextColor(getEditTextColor());
            edMicro.setBackgroundColor(getEditTextActivityColor());
            edMicro.setTextColor(getEditTextColor());
            edMm.setBackgroundColor(getEditTextActivityColor());
            edMm.setTextColor(getEditTextColor());
            edSm.setBackgroundColor(getEditTextActivityColor());
            edSm.setTextColor(getEditTextColor());
            edDuim.setBackgroundColor(getEditTextActivityColor());
            edDuim.setTextColor(getEditTextColor());
            edAE.setBackgroundColor(getEditTextActivityColor());
            edAE.setTextColor(getEditTextColor());
            edRed.setBackgroundColor(getEditTextActivityColor());
            edRed.setTextColor(getEditTextColor());
            edParsek.setBackgroundColor(getEditTextActivityColor());
            edParsek.setTextColor(getEditTextColor());
            edAEyear.setBackgroundColor(getEditTextActivityColor());
            edAEyear.setTextColor(getEditTextColor());
            edAEmin.setBackgroundColor(getEditTextActivityColor());
            edAEmin.setTextColor(getEditTextColor());
            edAEsec.setBackgroundColor(getEditTextActivityColor());
            edAEsec.setTextColor(getEditTextColor());
            edAEmicro.setBackgroundColor(getEditTextActivityColor());
            edAEmicro.setTextColor(getEditTextColor());
            edAEnano.setBackgroundColor(getEditTextActivityColor());
            edAEnano.setTextColor(getEditTextColor());
            edAEpiko.setBackgroundColor(getEditTextActivityColor());
            edAEpiko.setTextColor(getEditTextColor());

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
                                || (edNum.getText().toString().equals("."))
                                || (edNum.getText().toString().equals("-"))) {

                            edNano.setText("");
                            edMicro.setText("");
                            edMm.setText("");
                            edSm.setText("");
                            edM.setText("");
                            edKm.setText("");
                            edMil.setText("");
                            edYard.setText("");
                            edFut.setText("");
                            edDuim.setText("");
                            edSMil.setText("");

                            edAE.setText("");
                            edRed.setText("");
                            edParsek.setText("");
                            edAEyear.setText("");
                            edAEmin.setText("");
                            edAEsec.setText("");
                            edAEmicro.setText("");
                            edAEnano.setText("");
                            edAEpiko.setText("");

                            return;
                        }

                        num = Double.parseDouble(edNum.getText().toString());

                        switch (position) {
                            case 0:
                                result = (num + 0);
                                edNano.setText(String.valueOf(roundUp(result, 4)));
                                result = (num / 1000);
                                edMicro.setText(String.valueOf(roundUp(result, 4)));
                                result = (num / 1000000);
                                edMm.setText(String.valueOf(roundUp(result, 4)));
                                result = (num / 10000000);
                                edSm.setText(String.valueOf(roundUp(result, 4)));
                                result = (num / 1000000000);
                                edM.setText(String.valueOf(roundUp(result, 4)));
                                result = (num / 1e+12);
                                edKm.setText(String.valueOf(roundUp(result, 4)));
                                result = (num / 6.2e+13);
                                edMil.setText(String.valueOf(roundUp(result, 4)));
                                result = (num / 1.0936e+9);
                                edYard.setText(String.valueOf(roundUp(result, 4)));
                                result = (num / 3.2808e+9);
                                edFut.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 3.937e-8);
                                edDuim.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 5.3996e-13);
                                edSMil.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 6.685e-21);
                                edAE.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 7.676e-36);
                                edRed.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 3.241e-26);
                                edParsek.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 1.057e-25);
                                edAEyear.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 5.559e-20);
                                edAEmin.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 3.336e-18);
                                edAEsec.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 0.000000000003336);
                                edAEmicro.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 0.000000003336);
                                edAEnano.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 0.000003336);
                                edAEpiko.setText(String.valueOf(roundUp(result, 4)));

                                break;

                            case 1:

                                result = (num * 1000);
                                edNano.setText(String.valueOf(roundUp(result, 4)));
                                result = (num + 0);
                                edMicro.setText(String.valueOf(roundUp(result, 4)));
                                result = (num / 1000);
                                edMm.setText(String.valueOf(roundUp(result, 4)));
                                result = (num / 10000);
                                edSm.setText(String.valueOf(roundUp(result, 4)));
                                result = (num / 1000000);
                                edM.setText(String.valueOf(roundUp(result, 4)));
                                result = (num / 1e+9);
                                edKm.setText(String.valueOf(roundUp(result, 4)));
                                result = (num / 6.2e+10);
                                edMil.setText(String.valueOf(roundUp(result, 4)));
                                result = (num / 1.0936e+6);
                                edYard.setText(String.valueOf(roundUp(result, 4)));
                                result = (num / 3.2808e+6);
                                edFut.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 3.937e-5);
                                edDuim.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 5.3996e-10);
                                edSMil.setText(String.valueOf(roundUp(result, 4)));

                                result = (num * 6.685e-18);
                                edAE.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 7.676e-33);
                                edRed.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 3.241e-23);
                                edParsek.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 1.057e-22);
                                edAEyear.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 5.559e-17);
                                edAEmin.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 3.336e-15);
                                edAEsec.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 0.000000003336);
                                edAEmicro.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 0.000003336);
                                edAEnano.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 0.003336);
                                edAEpiko.setText(String.valueOf(roundUp(result, 4)));
                                break;

                            case 2:

                                result = (num * 1000000);
                                edNano.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 1000);
                                edMicro.setText(String.valueOf(roundUp(result, 4)));
                                result = (num + 0);
                                edMm.setText(String.valueOf(roundUp(result, 4)));
                                result = (num / 10);
                                edSm.setText(String.valueOf(roundUp(result, 4)));
                                result = (num / 1000);
                                edM.setText(String.valueOf(roundUp(result, 4)));
                                result = (num / 1e+6);
                                edKm.setText(String.valueOf(roundUp(result, 4)));
                                result = (num / 6.2e+7);
                                edMil.setText(String.valueOf(roundUp(result, 4)));
                                result = (num / 1093);
                                edYard.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 0.0032808);
                                edFut.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 0.0393);
                                edDuim.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 5.3996e-7);
                                edSMil.setText(String.valueOf(roundUp(result, 4)));

                                result = (num * 0.000000000000006685);
                                edAE.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 7.676e-30);
                                edRed.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 3.241e-20);
                                edParsek.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 1.057e-19);
                                edAEyear.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 5.559e-14);
                                edAEmin.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 3.336e-12);
                                edAEsec.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 0.000003336);
                                edAEmicro.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 0.003336);
                                edAEnano.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 3.336);
                                edAEpiko.setText(String.valueOf(roundUp(result, 4)));
                                break;


                            case 3:

                                result = (num * 10000000);
                                edNano.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 10000);
                                edMicro.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 10);
                                edMm.setText(String.valueOf(roundUp(result, 4)));
                                result = (num + 0);
                                edSm.setText(String.valueOf(roundUp(result, 4)));
                                result = (num / 100);
                                edM.setText(String.valueOf(roundUp(result, 4)));
                                result = (num / 100000);
                                edKm.setText(String.valueOf(roundUp(result, 4)));
                                result = (num / 160934);
                                edMil.setText(String.valueOf(roundUp(result, 4)));
                                result = (num / 10.93);
                                edYard.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 0.032808);
                                edFut.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 0.393);
                                edDuim.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 5.3996e-6);
                                edSMil.setText(String.valueOf(roundUp(result, 4)));

                                result = (num * 0.00000000000006685);
                                edAE.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 7.676e-29);
                                edRed.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 3.241e-19);
                                edParsek.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 1.057e-18);
                                edAEyear.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 5.559e-13);
                                edAEmin.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 3.336e-11);
                                edAEsec.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 0.00003336);
                                edAEmicro.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 0.03336);
                                edAEnano.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 33.36);
                                edAEpiko.setText(String.valueOf(roundUp(result, 4)));
                                break;

                            case 4:
                                result = (num * 1000000000);
                                edNano.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 1000000);
                                edMicro.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 1000);
                                edMm.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 100);
                                edSm.setText(String.valueOf(roundUp(result, 4)));
                                result = (num + 0);
                                edM.setText(String.valueOf(roundUp(result, 4)));
                                result = (num / 1000);
                                edKm.setText(String.valueOf(roundUp(result, 4)));
                                result = (num / 1609.34);
                                edMil.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 1.093);
                                edYard.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 3.2808);
                                edFut.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 39.3);
                                edDuim.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 0.00054);
                                edSMil.setText(String.valueOf(roundUp(result, 4)));

                                result = (num * 0.000000000006685);
                                edAE.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 7.676e-27);
                                edRed.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 3.241e-17);
                                edParsek.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 1.057e-16);
                                edAEyear.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 5.559e-11);
                                edAEmin.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 3.336e-9);
                                edAEsec.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 0.003336);
                                edAEmicro.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 3.336);
                                edAEnano.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 3336);
                                edAEpiko.setText(String.valueOf(roundUp(result, 4)));
                                break;

                            case 5:
                                result = (num * (1e+12));
                                edNano.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 1e+9);
                                edMicro.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 1e+6);
                                edMm.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 100000);
                                edSm.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 1000);
                                edM.setText(String.valueOf(roundUp(result, 4)));
                                result = (num + 0);
                                edKm.setText(String.valueOf(roundUp(result, 4)));
                                result = (num / 1.60934);
                                edMil.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 1093);
                                edYard.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 3280.8);
                                edFut.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 39370.1);
                                edDuim.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 0.54);
                                edSMil.setText(String.valueOf(roundUp(result, 4)));


                                result = (num * 0.000000006685);
                                edAE.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 7.676e-24);
                                edRed.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 0.00000000000003241);
                                edParsek.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 0.0000000000001057);
                                edAEyear.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 0.00000005559);
                                edAEmin.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 0.000003336);
                                edAEsec.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 3.336);
                                edAEmicro.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 3336);
                                edAEnano.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 3336000);
                                edAEpiko.setText(String.valueOf(roundUp(result, 4)));
                                break;

                            case 6:
                                result = (num * 1.609e+12);
                                edNano.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 1.609e+9);
                                edMicro.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 1.609e+6);
                                edMm.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 160934);
                                edSm.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 1609.3);
                                edM.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 1.609);
                                edKm.setText(String.valueOf(roundUp(result, 4)));
                                result = (num + 0);
                                edMil.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 1760);
                                edYard.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 5280);
                                edFut.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 63360);
                                edDuim.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 0.868976);
                                edSMil.setText(String.valueOf(roundUp(result, 4)));

                                result = (num * 0.00000001076);
                                edAE.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 1.235e-23);
                                edRed.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 0.00000000000005216);
                                edParsek.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 0.0000000000001701);
                                edAEyear.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 0.00000008947);
                                edAEmin.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 0.000005368);
                                edAEsec.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 5.368);
                                edAEmicro.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 5368);
                                edAEnano.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 5368000);
                                edAEpiko.setText(String.valueOf(roundUp(result, 4)));
                                break;

                            case 7:
                                result = (num * 9.144e+8);
                                edNano.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 914400);
                                edMicro.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 914.4);
                                edMm.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 91.44);
                                edSm.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 0.9144);
                                edM.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 0.0009144);
                                edKm.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 0.000568182);
                                edMil.setText(String.valueOf(roundUp(result, 4)));
                                result = (num + 0);
                                edYard.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 3);
                                edFut.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 36);
                                edDuim.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 0.00049);
                                edSMil.setText(String.valueOf(roundUp(result, 4)));

                                result = (num * 0.000000000006112);
                                edAE.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 7.019e-27);
                                edRed.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 2.963e-17);
                                edParsek.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 9.665e-17);
                                edAEyear.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 0.00000000005084);
                                edAEmin.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 0.00000000305);
                                edAEsec.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 0.00305);
                                edAEmicro.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 3.05);
                                edAEnano.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 3050);
                                edAEpiko.setText(String.valueOf(roundUp(result, 4)));
                                break;

                            case 8:
                                result = (num * 3.048e+8);
                                edNano.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 304800);
                                edMicro.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 304.8);
                                edMm.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 30.48);
                                edSm.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 0.3048);
                                edM.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 0.0003048);
                                edKm.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 0.000189394);
                                edMil.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 0.33333344);
                                edYard.setText(String.valueOf(roundUp(result, 4)));
                                result = (num + 0);
                                edFut.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 12);
                                edDuim.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 0.000164);
                                edSMil.setText(String.valueOf(roundUp(result, 4)));

                                result = (num * 0.000000000002037);
                                edAE.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 2.34e-27);
                                edRed.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 9.878e-18);
                                edParsek.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 3.222e-17);
                                edAEyear.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 0.00000000001695);
                                edAEmin.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 0.000000001017);
                                edAEsec.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 0.001017);
                                edAEmicro.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 1.017);
                                edAEnano.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 1017);
                                edAEpiko.setText(String.valueOf(roundUp(result, 4)));
                                break;

                            case 9:
                                result = (num * 2.54e+7);
                                edNano.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 25400);
                                edMicro.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 25.4);
                                edMm.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 2.54);
                                edSm.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 0.0254);
                                edM.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 2.54e-5);
                                edKm.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 1.5783e-5);
                                edMil.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 0.028);
                                edYard.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 0.0833333);
                                edFut.setText(String.valueOf(roundUp(result, 4)));
                                result = (num + 0);
                                edDuim.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 1.3715e-5);
                                edSMil.setText(String.valueOf(roundUp(result, 4)));

                                result = (num * 0.0000000000001698);
                                edAE.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 1.95e-28);
                                edRed.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 8.232e-19);
                                edParsek.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 2.685e-18);
                                edAEyear.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 0.000000000001412);
                                edAEmin.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 0.00000000008473);
                                edAEsec.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 0.00008473);
                                edAEmicro.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 0.08473);
                                edAEnano.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 84.73);
                                edAEpiko.setText(String.valueOf(roundUp(result, 4)));
                                break;

                            case 10:
                                result = (num * 1.852e+12);
                                edNano.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 1.852e+9);
                                edMicro.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 1.852e+6);
                                edMm.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 185200);
                                edSm.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 1852);
                                edM.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 1.852);
                                edKm.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 1.15);
                                edMil.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 2025.37);
                                edYard.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 6076.12);
                                edFut.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 72913.4);
                                edDuim.setText(String.valueOf(roundUp(result, 4)));
                                result = (num + 0);
                                edSMil.setText(String.valueOf(roundUp(result, 4)));

                                result = (num * 0.00000001238);
                                edAE.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 1.422e-23);
                                edRed.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 0.00000000000006002);
                                edParsek.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 0.0000000000001958);
                                edAEyear.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 0.000000103);
                                edAEmin.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 0.000006178);
                                edAEsec.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 6.178);
                                edAEmicro.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 6178);
                                edAEnano.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 6178000);
                                edAEpiko.setText(String.valueOf(roundUp(result, 4)));
                                break;
                            case 11:
                                result = (num * 1.496e+20);
                                edNano.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 1.496e+17);
                                edMicro.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 1.496e+14);
                                edMm.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 1.496e+13);
                                edSm.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 1.496e+11);
                                edM.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 149600000);
                                edKm.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 92960000);
                                edMil.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 1.636e+11);
                                edYard.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 4.908e+11);
                                edFut.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 5.89e+12);
                                edDuim.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 80780000);
                                edSMil.setText(String.valueOf(roundUp(result, 4)));

                                result = (num + 0);
                                edAE.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 0.000000000000001148);
                                edRed.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 0.000004848);
                                edParsek.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 0.00001581);
                                edAEyear.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 8.317);
                                edAEmin.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 499);
                                edAEsec.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 499000000);
                                edAEmicro.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 4.99e+11);
                                edAEnano.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 4.99e+14);
                                edAEpiko.setText(String.valueOf(roundUp(result, 4)));
                                break;
                            case 12:
                                result = (num * 1.303e+35);
                                edNano.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 1.303e+32);
                                edMicro.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 1.303e+29);
                                edMm.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 1.303e+28);
                                edSm.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 1.303e+26);
                                edM.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 1.303e+23);
                                edKm.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 8.095e+22);
                                edMil.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 1.425e+26);
                                edYard.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 4.274e+26);
                                edFut.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 5.129e+27);
                                edDuim.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 7.034e+22);
                                edSMil.setText(String.valueOf(roundUp(result, 4)));

                                result = (num * 8.709e+14);
                                edAE.setText(String.valueOf(roundUp(result, 4)));
                                result = (num + 0);
                                edRed.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 4.222e+9);
                                edParsek.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 1.377e+10);
                                edAEyear.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 7.243e+12);
                                edAEmin.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 4.346e+17);
                                edAEsec.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 4.346e+23);
                                edAEmicro.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 4.346e+26);
                                edAEnano.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 4.346e+29);
                                edAEpiko.setText(String.valueOf(roundUp(result, 4)));
                                break;
                            case 13:
                                result = (num * 3.086e+25);
                                edNano.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 3.086e+22);
                                edMicro.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 3.086e+19);
                                edMm.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 3.086e+18);
                                edSm.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 3.086e+16);
                                edM.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 3.086e+13);
                                edKm.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 1.917e+13);
                                edMil.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 3.375e+16);
                                edYard.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 1.012e+17);
                                edFut.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 1.215e+18);
                                edDuim.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 1.666e+13);
                                edSMil.setText(String.valueOf(roundUp(result, 4)));

                                result = (num * 206300);
                                edAE.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 0.0000000002369);
                                edRed.setText(String.valueOf(roundUp(result, 4)));
                                result = (num + 0);
                                edParsek.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 3.262);
                                edAEyear.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 1715000);
                                edAEmin.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 102900000);
                                edAEsec.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 1.029e+14);
                                edAEmicro.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 1.029e+17);
                                edAEnano.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 1.029e+20);
                                edAEpiko.setText(String.valueOf(roundUp(result, 4)));
                                break;

                            case 14:
                                result = (num * 9.461e+24);
                                edNano.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 9.461e+21);
                                edMicro.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 9.461e+18);
                                edMm.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 9.461e+17);
                                edSm.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 9.461e+15);
                                edM.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 9.461e+12);
                                edKm.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 5.879e+12);
                                edMil.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 1.035e+16);
                                edYard.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 3.104e+16);
                                edFut.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 3.725e+17);
                                edDuim.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 5.108e+12);
                                edSMil.setText(String.valueOf(roundUp(result, 4)));

                                result = (num * 63240);
                                edAE.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 0.00000000007262);
                                edRed.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 0.3066);
                                edParsek.setText(String.valueOf(roundUp(result, 4)));
                                result = (num + 0);
                                edAEyear.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 526000);
                                edAEmin.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 31560000);
                                edAEsec.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 3.156e+13);
                                edAEmicro.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 3.156e+16);
                                edAEnano.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 3.156e+19);
                                edAEpiko.setText(String.valueOf(roundUp(result, 4)));
                                break;
                            case 15:
                                result = (num * 1.799e+19);
                                edNano.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 1.799e+16);
                                edMicro.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 1.799e+13);
                                edMm.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 1.799e+12);
                                edSm.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 1.799e+10);
                                edM.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 17990000);
                                edKm.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 11180000);
                                edMil.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 1.967e+10);
                                edYard.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 5.901e+10);
                                edFut.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 7.082e+11);
                                edDuim.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 9712000);
                                edSMil.setText(String.valueOf(roundUp(result, 4)));

                                result = (num * 0.1202);
                                edAE.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 1.381e-16);
                                edRed.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 0.0000005829);
                                edParsek.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 0.000001901);
                                edAEyear.setText(String.valueOf(roundUp(result, 4)));
                                result = (num + 0);
                                edAEmin.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 60);
                                edAEsec.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 60000000);
                                edAEmicro.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 6e+10);
                                edAEnano.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 6e+13);
                                edAEpiko.setText(String.valueOf(roundUp(result, 4)));
                                break;
                            case 16:
                                result = (num * 2.998e+17);
                                edNano.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 2.998e+14);
                                edMicro.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 2.998e+11);
                                edMm.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 2.998e+10);
                                edSm.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 299800000);
                                edM.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 299800);
                                edKm.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 186300);
                                edMil.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 327900000);
                                edYard.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 983600000);
                                edFut.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 1.18e+10);
                                edDuim.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 161900);
                                edSMil.setText(String.valueOf(roundUp(result, 4)));

                                result = (num * 0.002004);
                                edAE.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 2.301e-18);
                                edRed.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 0.000000009716);
                                edParsek.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 0.00000003169);
                                edAEyear.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 0.01667);
                                edAEmin.setText(String.valueOf(roundUp(result, 4)));
                                result = (num + 0);
                                edAEsec.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 1000000);
                                edAEmicro.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 1e+9);
                                edAEnano.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 1e+12);
                                edAEpiko.setText(String.valueOf(roundUp(result, 4)));
                                break;
                            case 17:
                                result = (num * 2.998e+14);
                                edNano.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 2.998e+8);
                                edMicro.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 299800);
                                edMm.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 29980);
                                edSm.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 299.8);
                                edM.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 0.2998);
                                edKm.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 0.1863);
                                edMil.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 327.9);
                                edYard.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 983.6);
                                edFut.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 11800);
                                edDuim.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 0.1619);
                                edSMil.setText(String.valueOf(roundUp(result, 4)));

                                result = (num * 0.000000002004);
                                edAE.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 2.301e-24);
                                edRed.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 0.000000000000009716);
                                edParsek.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 0.00000000000003169);
                                edAEyear.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 0.00000001667);
                                edAEmin.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 0.000001);
                                edAEsec.setText(String.valueOf(roundUp(result, 4)));
                                result = (num + 0);
                                edAEmicro.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 1000);
                                edAEnano.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 1000000);
                                edAEpiko.setText(String.valueOf(roundUp(result, 4)));
                                break;
                            case 18:
                                result = (num * 299800000);
                                edNano.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 299800);
                                edMicro.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 299.8);
                                edMm.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 29.98);
                                edSm.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 0.2998);
                                edM.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 0.0002998);
                                edKm.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 0.0001863);
                                edMil.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 0.3279);
                                edYard.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 0.9836);
                                edFut.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 11.8);
                                edDuim.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 0.0001619);
                                edSMil.setText(String.valueOf(roundUp(result, 4)));

                                result = (num * 0.000000000002004);
                                edAE.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 2.301e-27);
                                edRed.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 9.716e-18);
                                edParsek.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 3.169e-17);
                                edAEyear.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 0.00000000001667);
                                edAEmin.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 0.000000001);
                                edAEsec.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 0.001);
                                edAEmicro.setText(String.valueOf(roundUp(result, 4)));
                                result = (num + 0);
                                edAEnano.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 1000);
                                edAEpiko.setText(String.valueOf(roundUp(result, 4)));
                                break;
                            case 19:
                                result = (num * 299800);
                                edNano.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 299.8);
                                edMicro.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 0.2998);
                                edMm.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 0.02998);
                                edSm.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 0.0002998);
                                edM.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 0.0000002998);
                                edKm.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 0.0000001863);
                                edMil.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 0.0003279);
                                edYard.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 0.0009836);
                                edFut.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 0.0118);
                                edDuim.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 0.0000001619);
                                edSMil.setText(String.valueOf(roundUp(result, 4)));

                                result = (num * 0.000000000000002004);
                                edAE.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 2.301e-30);
                                edRed.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 9.716e-21);
                                edParsek.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 3.169e-20);
                                edAEyear.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 0.00000000000001667);
                                edAEmin.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 0.000000000001);
                                edAEsec.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 0.000001);
                                edAEmicro.setText(String.valueOf(roundUp(result, 4)));
                                result = (num * 0.001);
                                edAEnano.setText(String.valueOf(roundUp(result, 4)));
                                result = (num + 0);
                                edAEpiko.setText(String.valueOf(roundUp(result, 4)));
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
                || (edNum.getText().toString().equals("."))
                || (edNum.getText().toString().equals("-"))) {

            edNano.setText("");
            edMicro.setText("");
            edMm.setText("");
            edSm.setText("");
            edM.setText("");
            edKm.setText("");
            edMil.setText("");
            edYard.setText("");
            edFut.setText("");
            edDuim.setText("");
            edSMil.setText("");

            edAE.setText("");
            edRed.setText("");
            edParsek.setText("");
            edAEyear.setText("");
            edAEmin.setText("");
            edAEsec.setText("");
            edAEmicro.setText("");
            edAEnano.setText("");
            edAEpiko.setText("");
            return;
        }

        num = Double.parseDouble(edNum.getText().toString());

        switch (a) {
            case 0:
                result = (num + 0);
                edNano.setText(String.valueOf(roundUp(result, 4)));
                result = (num / 1000);
                edMicro.setText(String.valueOf(roundUp(result, 4)));
                result = (num / 1000000);
                edMm.setText(String.valueOf(roundUp(result, 4)));
                result = (num / 10000000);
                edSm.setText(String.valueOf(roundUp(result, 4)));
                result = (num / 1000000000);
                edM.setText(String.valueOf(roundUp(result, 4)));
                result = (num / 1e+12);
                edKm.setText(String.valueOf(roundUp(result, 4)));
                result = (num / 6.2e+13);
                edMil.setText(String.valueOf(roundUp(result, 4)));
                result = (num / 1.0936e+9);
                edYard.setText(String.valueOf(roundUp(result, 4)));
                result = (num / 3.2808e+9);
                edFut.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 3.937e-8);
                edDuim.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 5.3996e-13);
                edSMil.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 6.685e-21);
                edAE.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 7.676e-36);
                edRed.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 3.241e-26);
                edParsek.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 1.057e-25);
                edAEyear.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 5.559e-20);
                edAEmin.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 3.336e-18);
                edAEsec.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 0.000000000003336);
                edAEmicro.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 0.000000003336);
                edAEnano.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 0.000003336);
                edAEpiko.setText(String.valueOf(roundUp(result, 4)));
                //   Toast.makeText(getApplicationContext(), " " + strName, Toast.LENGTH_SHORT).show();

                break;

            case 1:

                result = (num * 1000);
                edNano.setText(String.valueOf(roundUp(result, 4)));
                result = (num + 0);
                edMicro.setText(String.valueOf(roundUp(result, 4)));
                result = (num / 1000);
                edMm.setText(String.valueOf(roundUp(result, 4)));
                result = (num / 10000);
                edSm.setText(String.valueOf(roundUp(result, 4)));
                result = (num / 1000000);
                edM.setText(String.valueOf(roundUp(result, 4)));
                result = (num / 1e+9);
                edKm.setText(String.valueOf(roundUp(result, 4)));
                result = (num / 6.2e+10);
                edMil.setText(String.valueOf(roundUp(result, 4)));
                result = (num / 1.0936e+6);
                edYard.setText(String.valueOf(roundUp(result, 4)));
                result = (num / 3.2808e+6);
                edFut.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 3.937e-5);
                edDuim.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 5.3996e-10);
                edSMil.setText(String.valueOf(roundUp(result, 4)));

                result = (num * 6.685e-18);
                edAE.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 7.676e-33);
                edRed.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 3.241e-23);
                edParsek.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 1.057e-22);
                edAEyear.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 5.559e-17);
                edAEmin.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 3.336e-15);
                edAEsec.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 0.000000003336);
                edAEmicro.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 0.000003336);
                edAEnano.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 0.003336);
                edAEpiko.setText(String.valueOf(roundUp(result, 4)));
                //   Toast.makeText(getApplicationContext(), " " + strName, Toast.LENGTH_SHORT).show();
                break;

            case 2:

                result = (num * 1000000);
                edNano.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 1000);
                edMicro.setText(String.valueOf(roundUp(result, 4)));
                result = (num + 0);
                edMm.setText(String.valueOf(roundUp(result, 4)));
                result = (num / 10);
                edSm.setText(String.valueOf(roundUp(result, 4)));
                result = (num / 1000);
                edM.setText(String.valueOf(roundUp(result, 4)));
                result = (num / 1e+6);
                edKm.setText(String.valueOf(roundUp(result, 4)));
                result = (num / 6.2e+7);
                edMil.setText(String.valueOf(roundUp(result, 4)));
                result = (num / 1093);
                edYard.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 0.0032808);
                edFut.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 0.0393);
                edDuim.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 5.3996e-7);
                edSMil.setText(String.valueOf(roundUp(result, 4)));

                result = (num * 0.000000000000006685);
                edAE.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 7.676e-30);
                edRed.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 3.241e-20);
                edParsek.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 1.057e-19);
                edAEyear.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 5.559e-14);
                edAEmin.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 3.336e-12);
                edAEsec.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 0.000003336);
                edAEmicro.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 0.003336);
                edAEnano.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 3.336);
                edAEpiko.setText(String.valueOf(roundUp(result, 4)));
                //   Toast.makeText(getApplicationContext(), " " + strName, Toast.LENGTH_SHORT).show();
                break;


            case 3:

                result = (num * 10000000);
                edNano.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 10000);
                edMicro.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 10);
                edMm.setText(String.valueOf(roundUp(result, 4)));
                result = (num + 0);
                edSm.setText(String.valueOf(roundUp(result, 4)));
                result = (num / 100);
                edM.setText(String.valueOf(roundUp(result, 4)));
                result = (num / 100000);
                edKm.setText(String.valueOf(roundUp(result, 4)));
                result = (num / 160934);
                edMil.setText(String.valueOf(roundUp(result, 4)));
                result = (num / 10.93);
                edYard.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 0.032808);
                edFut.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 0.393);
                edDuim.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 5.3996e-6);
                edSMil.setText(String.valueOf(roundUp(result, 4)));

                result = (num * 0.00000000000006685);
                edAE.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 7.676e-29);
                edRed.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 3.241e-19);
                edParsek.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 1.057e-18);
                edAEyear.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 5.559e-13);
                edAEmin.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 3.336e-11);
                edAEsec.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 0.00003336);
                edAEmicro.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 0.03336);
                edAEnano.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 33.36);
                edAEpiko.setText(String.valueOf(roundUp(result, 4)));
                //    Toast.makeText(getApplicationContext(), " " + strName, Toast.LENGTH_SHORT).show();
                break;

            case 4:
                result = (num * 1000000000);
                edNano.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 1000000);
                edMicro.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 1000);
                edMm.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 100);
                edSm.setText(String.valueOf(roundUp(result, 4)));
                result = (num + 0);
                edM.setText(String.valueOf(roundUp(result, 4)));
                result = (num / 1000);
                edKm.setText(String.valueOf(roundUp(result, 4)));
                result = (num / 1609.34);
                edMil.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 1.093);
                edYard.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 3.2808);
                edFut.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 39.3);
                edDuim.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 0.00054);
                edSMil.setText(String.valueOf(roundUp(result, 4)));

                result = (num * 0.000000000006685);
                edAE.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 7.676e-27);
                edRed.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 3.241e-17);
                edParsek.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 1.057e-16);
                edAEyear.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 5.559e-11);
                edAEmin.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 3.336e-9);
                edAEsec.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 0.003336);
                edAEmicro.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 3.336);
                edAEnano.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 3336);
                edAEpiko.setText(String.valueOf(roundUp(result, 4)));
                break;

            case 5:
                result = (num * (1e+12));
                edNano.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 1e+9);
                edMicro.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 1e+6);
                edMm.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 100000);
                edSm.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 1000);
                edM.setText(String.valueOf(roundUp(result, 4)));
                result = (num + 0);
                edKm.setText(String.valueOf(roundUp(result, 4)));
                result = (num / 1.60934);
                edMil.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 1093);
                edYard.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 3280.8);
                edFut.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 39370.1);
                edDuim.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 0.54);
                edSMil.setText(String.valueOf(roundUp(result, 4)));


                result = (num * 0.000000006685);
                edAE.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 7.676e-24);
                edRed.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 0.00000000000003241);
                edParsek.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 0.0000000000001057);
                edAEyear.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 0.00000005559);
                edAEmin.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 0.000003336);
                edAEsec.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 3.336);
                edAEmicro.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 3336);
                edAEnano.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 3336000);
                edAEpiko.setText(String.valueOf(roundUp(result, 4)));
                //   Toast.makeText(getApplicationContext(), " " + strName, Toast.LENGTH_SHORT).show();
                break;

            case 6:
                result = (num * 1.609e+12);
                edNano.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 1.609e+9);
                edMicro.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 1.609e+6);
                edMm.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 160934);
                edSm.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 1609.3);
                edM.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 1.609);
                edKm.setText(String.valueOf(roundUp(result, 4)));
                result = (num + 0);
                edMil.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 1760);
                edYard.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 5280);
                edFut.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 63360);
                edDuim.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 0.868976);
                edSMil.setText(String.valueOf(roundUp(result, 4)));

                result = (num * 0.00000001076);
                edAE.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 1.235e-23);
                edRed.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 0.00000000000005216);
                edParsek.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 0.0000000000001701);
                edAEyear.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 0.00000008947);
                edAEmin.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 0.000005368);
                edAEsec.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 5.368);
                edAEmicro.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 5368);
                edAEnano.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 5368000);
                edAEpiko.setText(String.valueOf(roundUp(result, 4)));
                //    Toast.makeText(getApplicationContext(), " " + strName, Toast.LENGTH_SHORT).show();
                break;

            case 7:
                result = (num * 9.144e+8);
                edNano.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 914400);
                edMicro.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 914.4);
                edMm.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 91.44);
                edSm.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 0.9144);
                edM.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 0.0009144);
                edKm.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 0.000568182);
                edMil.setText(String.valueOf(roundUp(result, 4)));
                result = (num + 0);
                edYard.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 3);
                edFut.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 36);
                edDuim.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 0.00049);
                edSMil.setText(String.valueOf(roundUp(result, 4)));

                result = (num * 0.000000000006112);
                edAE.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 7.019e-27);
                edRed.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 2.963e-17);
                edParsek.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 9.665e-17);
                edAEyear.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 0.00000000005084);
                edAEmin.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 0.00000000305);
                edAEsec.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 0.00305);
                edAEmicro.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 3.05);
                edAEnano.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 3050);
                edAEpiko.setText(String.valueOf(roundUp(result, 4)));
                //    Toast.makeText(getApplicationContext(), " " + strName, Toast.LENGTH_SHORT).show();
                break;

            case 8:
                result = (num * 3.048e+8);
                edNano.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 304800);
                edMicro.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 304.8);
                edMm.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 30.48);
                edSm.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 0.3048);
                edM.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 0.0003048);
                edKm.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 0.000189394);
                edMil.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 0.33333344);
                edYard.setText(String.valueOf(roundUp(result, 4)));
                result = (num + 0);
                edFut.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 12);
                edDuim.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 0.000164);
                edSMil.setText(String.valueOf(roundUp(result, 4)));

                result = (num * 0.000000000002037);
                edAE.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 2.34e-27);
                edRed.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 9.878e-18);
                edParsek.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 3.222e-17);
                edAEyear.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 0.00000000001695);
                edAEmin.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 0.000000001017);
                edAEsec.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 0.001017);
                edAEmicro.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 1.017);
                edAEnano.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 1017);
                edAEpiko.setText(String.valueOf(roundUp(result, 4)));
                //   Toast.makeText(getApplicationContext(), " " + strName, Toast.LENGTH_SHORT).show();
                break;

            case 9:
                result = (num * 2.54e+7);
                edNano.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 25400);
                edMicro.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 25.4);
                edMm.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 2.54);
                edSm.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 0.0254);
                edM.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 2.54e-5);
                edKm.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 1.5783e-5);
                edMil.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 0.028);
                edYard.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 0.0833333);
                edFut.setText(String.valueOf(roundUp(result, 4)));
                result = (num + 0);
                edDuim.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 1.3715e-5);
                edSMil.setText(String.valueOf(roundUp(result, 4)));

                result = (num * 0.0000000000001698);
                edAE.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 1.95e-28);
                edRed.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 8.232e-19);
                edParsek.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 2.685e-18);
                edAEyear.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 0.000000000001412);
                edAEmin.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 0.00000000008473);
                edAEsec.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 0.00008473);
                edAEmicro.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 0.08473);
                edAEnano.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 84.73);
                edAEpiko.setText(String.valueOf(roundUp(result, 4)));
                //    Toast.makeText(getApplicationContext(), " " + strName, Toast.LENGTH_SHORT).show();
                break;

            case 10:
                result = (num * 1.852e+12);
                edNano.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 1.852e+9);
                edMicro.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 1.852e+6);
                edMm.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 185200);
                edSm.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 1852);
                edM.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 1.852);
                edKm.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 1.15);
                edMil.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 2025.37);
                edYard.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 6076.12);
                edFut.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 72913.4);
                edDuim.setText(String.valueOf(roundUp(result, 4)));
                result = (num + 0);
                edSMil.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 0.00000001238);
                edAE.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 1.422e-23);
                edRed.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 0.00000000000006002);
                edParsek.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 0.0000000000001958);
                edAEyear.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 0.000000103);
                edAEmin.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 0.000006178);
                edAEsec.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 6.178);
                edAEmicro.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 6178);
                edAEnano.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 6178000);
                edAEpiko.setText(String.valueOf(roundUp(result, 4)));
                //  Toast.makeText(getApplicationContext(), " " + strName, Toast.LENGTH_SHORT).show();
                break;
            case 11:
                result = (num * 1.496e+20);
                edNano.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 1.496e+17);
                edMicro.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 1.496e+14);
                edMm.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 1.496e+13);
                edSm.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 1.496e+11);
                edM.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 149600000);
                edKm.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 92960000);
                edMil.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 1.636e+11);
                edYard.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 4.908e+11);
                edFut.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 5.89e+12);
                edDuim.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 80780000);
                edSMil.setText(String.valueOf(roundUp(result, 4)));

                result = (num + 0);
                edAE.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 0.000000000000001148);
                edRed.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 0.000004848);
                edParsek.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 0.00001581);
                edAEyear.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 8.317);
                edAEmin.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 499);
                edAEsec.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 499000000);
                edAEmicro.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 4.99e+11);
                edAEnano.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 4.99e+14);
                edAEpiko.setText(String.valueOf(roundUp(result, 4)));
                //     Toast.makeText(getApplicationContext(), " " + strName, Toast.LENGTH_SHORT).show();
                break;
            case 12:
                result = (num * 1.303e+35);
                edNano.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 1.303e+32);
                edMicro.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 1.303e+29);
                edMm.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 1.303e+28);
                edSm.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 1.303e+26);
                edM.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 1.303e+23);
                edKm.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 8.095e+22);
                edMil.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 1.425e+26);
                edYard.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 4.274e+26);
                edFut.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 5.129e+27);
                edDuim.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 7.034e+22);
                edSMil.setText(String.valueOf(roundUp(result, 4)));

                result = (num * 8.709e+14);
                edAE.setText(String.valueOf(roundUp(result, 4)));
                result = (num + 0);
                edRed.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 4.222e+9);
                edParsek.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 1.377e+10);
                edAEyear.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 7.243e+12);
                edAEmin.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 4.346e+17);
                edAEsec.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 4.346e+23);
                edAEmicro.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 4.346e+26);
                edAEnano.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 4.346e+29);
                edAEpiko.setText(String.valueOf(roundUp(result, 4)));
                //      Toast.makeText(getApplicationContext(), " " + strName, Toast.LENGTH_SHORT).show();
                break;


            case 13:
                result = (num * 3.086e+25);
                edNano.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 3.086e+22);
                edMicro.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 3.086e+19);
                edMm.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 3.086e+18);
                edSm.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 3.086e+16);
                edM.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 3.086e+13);
                edKm.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 1.917e+13);
                edMil.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 3.375e+16);
                edYard.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 1.012e+17);
                edFut.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 1.215e+18);
                edDuim.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 1.666e+13);
                edSMil.setText(String.valueOf(roundUp(result, 4)));

                result = (num * 206300);
                edAE.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 0.0000000002369);
                edRed.setText(String.valueOf(roundUp(result, 4)));
                result = (num + 0);
                edParsek.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 3.262);
                edAEyear.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 1715000);
                edAEmin.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 102900000);
                edAEsec.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 1.029e+14);
                edAEmicro.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 1.029e+17);
                edAEnano.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 1.029e+20);
                edAEpiko.setText(String.valueOf(roundUp(result, 4)));
                //      Toast.makeText(getApplicationContext(), " " + strName, Toast.LENGTH_SHORT).show();
                break;

            case 14:
                result = (num * 9.461e+24);
                edNano.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 9.461e+21);
                edMicro.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 9.461e+18);
                edMm.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 9.461e+17);
                edSm.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 9.461e+15);
                edM.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 9.461e+12);
                edKm.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 5.879e+12);
                edMil.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 1.035e+16);
                edYard.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 3.104e+16);
                edFut.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 3.725e+17);
                edDuim.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 5.108e+12);
                edSMil.setText(String.valueOf(roundUp(result, 4)));

                result = (num * 63240);
                edAE.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 0.00000000007262);
                edRed.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 0.3066);
                edParsek.setText(String.valueOf(roundUp(result, 4)));
                result = (num + 0);
                edAEyear.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 526000);
                edAEmin.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 31560000);
                edAEsec.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 3.156e+13);
                edAEmicro.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 3.156e+16);
                edAEnano.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 3.156e+19);
                edAEpiko.setText(String.valueOf(roundUp(result, 4)));
                //      Toast.makeText(getApplicationContext(), " " + strName, Toast.LENGTH_SHORT).show();
                break;
            case 15:
                result = (num * 1.799e+19);
                edNano.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 1.799e+16);
                edMicro.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 1.799e+13);
                edMm.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 1.799e+12);
                edSm.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 1.799e+10);
                edM.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 17990000);
                edKm.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 11180000);
                edMil.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 1.967e+10);
                edYard.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 5.901e+10);
                edFut.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 7.082e+11);
                edDuim.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 9712000);
                edSMil.setText(String.valueOf(roundUp(result, 4)));

                result = (num * 0.1202);
                edAE.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 1.381e-16);
                edRed.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 0.0000005829);
                edParsek.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 0.000001901);
                edAEyear.setText(String.valueOf(roundUp(result, 4)));
                result = (num + 0);
                edAEmin.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 60);
                edAEsec.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 60000000);
                edAEmicro.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 6e+10);
                edAEnano.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 6e+13);
                edAEpiko.setText(String.valueOf(roundUp(result, 4)));
                //      Toast.makeText(getApplicationContext(), " " + strName, Toast.LENGTH_SHORT).show();
                break;
            case 16:
                result = (num * 2.998e+17);
                edNano.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 2.998e+14);
                edMicro.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 2.998e+11);
                edMm.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 2.998e+10);
                edSm.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 299800000);
                edM.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 299800);
                edKm.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 186300);
                edMil.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 327900000);
                edYard.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 983600000);
                edFut.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 1.18e+10);
                edDuim.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 161900);
                edSMil.setText(String.valueOf(roundUp(result, 4)));

                result = (num * 0.002004);
                edAE.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 2.301e-18);
                edRed.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 0.000000009716);
                edParsek.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 0.00000003169);
                edAEyear.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 0.01667);
                edAEmin.setText(String.valueOf(roundUp(result, 4)));
                result = (num + 0);
                edAEsec.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 1000000);
                edAEmicro.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 1e+9);
                edAEnano.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 1e+12);
                edAEpiko.setText(String.valueOf(roundUp(result, 4)));
                //     Toast.makeText(getApplicationContext(), " " + strName, Toast.LENGTH_SHORT).show();
                break;
            case 17:
                result = (num * 2.998e+14);
                edNano.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 2.998e+8);
                edMicro.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 299800);
                edMm.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 29980);
                edSm.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 299.8);
                edM.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 0.2998);
                edKm.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 0.1863);
                edMil.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 327.9);
                edYard.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 983.6);
                edFut.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 11800);
                edDuim.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 0.1619);
                edSMil.setText(String.valueOf(roundUp(result, 4)));

                result = (num * 0.000000002004);
                edAE.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 2.301e-24);
                edRed.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 0.000000000000009716);
                edParsek.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 0.00000000000003169);
                edAEyear.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 0.00000001667);
                edAEmin.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 0.000001);
                edAEsec.setText(String.valueOf(roundUp(result, 4)));
                result = (num + 0);
                edAEmicro.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 1000);
                edAEnano.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 1000000);
                edAEpiko.setText(String.valueOf(roundUp(result, 4)));
                //    Toast.makeText(getApplicationContext(), " " + strName, Toast.LENGTH_SHORT).show();
                break;
            case 18:
                result = (num * 299800000);
                edNano.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 299800);
                edMicro.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 299.8);
                edMm.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 29.98);
                edSm.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 0.2998);
                edM.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 0.0002998);
                edKm.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 0.0001863);
                edMil.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 0.3279);
                edYard.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 0.9836);
                edFut.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 11.8);
                edDuim.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 0.0001619);
                edSMil.setText(String.valueOf(roundUp(result, 4)));

                result = (num * 0.000000000002004);
                edAE.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 2.301e-27);
                edRed.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 9.716e-18);
                edParsek.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 3.169e-17);
                edAEyear.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 0.00000000001667);
                edAEmin.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 0.000000001);
                edAEsec.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 0.001);
                edAEmicro.setText(String.valueOf(roundUp(result, 4)));
                result = (num + 0);
                edAEnano.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 1000);
                edAEpiko.setText(String.valueOf(roundUp(result, 4)));
                //    Toast.makeText(getApplicationContext(), " " + strName, Toast.LENGTH_SHORT).show();
                break;
            case 19:
                result = (num * 299800);
                edNano.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 299.8);
                edMicro.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 0.2998);
                edMm.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 0.02998);
                edSm.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 0.0002998);
                edM.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 0.0000002998);
                edKm.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 0.0000001863);
                edMil.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 0.0003279);
                edYard.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 0.0009836);
                edFut.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 0.0118);
                edDuim.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 0.0000001619);
                edSMil.setText(String.valueOf(roundUp(result, 4)));

                result = (num * 0.000000000000002004);
                edAE.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 2.301e-30);
                edRed.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 9.716e-21);
                edParsek.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 3.169e-20);
                edAEyear.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 0.00000000000001667);
                edAEmin.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 0.000000000001);
                edAEsec.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 0.000001);
                edAEmicro.setText(String.valueOf(roundUp(result, 4)));
                result = (num * 0.001);
                edAEnano.setText(String.valueOf(roundUp(result, 4)));
                result = (num + 0);
                edAEpiko.setText(String.valueOf(roundUp(result, 4)));
                // Toast.makeText(getApplicationContext(), " " + strName, Toast.LENGTH_SHORT).show();
                break;


        }

    }

    @Override
    public void afterTextChanged(Editable s) {


    }



//    private void themeActive() {
//
//        if (getColor() != getResources().getColor(R.color.colorPrimary)) {
//
//            my_toolbar.setBackgroundColor(getBackgroundColor());
//            backColorlayoutAds.setBackgroundColor(getColor());
//            bottomColorLayout.setBackgroundColor(getColor());
//            corLoyDlinna.setBackgroundColor(getBackgroundColor());
//            Nm.setTextColor(getTextColor());
//            Km.setTextColor(getTextColor());
//            Mile.setTextColor(getTextColor());
//            m.setTextColor(getTextColor());
//            edSMil.setBackgroundColor(getEditTextActivityColor());
//            edSMil.setTextColor(getEditTextColor());
//            edMil.setBackgroundColor(getEditTextActivityColor());
//            edMil.setTextColor(getEditTextColor());
//            edKm.setBackgroundColor(getEditTextActivityColor());
//            edKm.setTextColor(getEditTextColor());
//            edM.setBackgroundColor(getEditTextActivityColor());
//            edM.setTextColor(getEditTextColor());
//            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//                getWindow().setStatusBarColor(getColor());
//            }
//        }




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

