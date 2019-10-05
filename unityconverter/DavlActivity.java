package com.piotrdevelop.unityconverter;



import android.content.Intent;
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
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.math.BigDecimal;

public class DavlActivity extends AppCompatActivity implements TextWatcher {

    //  String[] data = {"Атмосфера (atm)", "Бар (b)", "Паскаль (Pa)","Мм ртутного столба (mmHg)","Кг на кв.метр (kgf/m²)","Фунтов на кв.фут (psf)","Фунтов на кв.дюйм (psi)","Мм водяного столба (mmH2O)","Мегапаскаль (MPa)","Кг силы на кв.см (kgf/cm²)","Килопаскаль (KPa)"};
    int a;
    Spinner spMassa;
    EditText edNum, edAtm, edBar, edPa, edMmhg, edKgM, edKvFut, edKvDuim, edMmH2O, edMPa, edKgfcm, edKPa, etText;
    ToggleButton tb;
    DatabaseHelper myDB;
    // JSONObject saved = new JSONObject();
    SharedPreferences shared;
    SharedPreferences.Editor ed;
    Button sv_button, btn_view;

    public BigDecimal roundUp(double value, int digits) {
        return new BigDecimal("" + value).setScale(digits, BigDecimal.ROUND_HALF_UP);
    }

    public static final String Checked = "Checked";
    private boolean switchOnOff;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.davlenie);

        Toolbar my_toolbar = (Toolbar) findViewById(R.id.my_toolbar_app);
        RelativeLayout backColorlayoutAds = (RelativeLayout) findViewById(R.id.reLayoutDavlAds);
        CollapsingToolbarLayout bottomColorLayout = (CollapsingToolbarLayout) findViewById(R.id.davlottomLayout);
        CoordinatorLayout corLoyDlinna = (CoordinatorLayout) findViewById(R.id.corLoyoutDavl);
        setSupportActionBar(my_toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,// data);
                // adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                getResources().getStringArray(R.array.davlenie));

        spMassa = (Spinner) findViewById(R.id.spMassa);
        spMassa.setAdapter(adapter);

        //   tvPosName = (TextView) findViewById(R.id.tvPosName);

        TextView Nm = (TextView) findViewById(R.id.atm);
        TextView Km = (TextView) findViewById(R.id.b);
        TextView Mile = (TextView) findViewById(R.id.Pa);
        TextView m = (TextView) findViewById(R.id.MPa);
        TextView yard = (TextView) findViewById(R.id.KPa);
        TextView ft = (TextView) findViewById(R.id.mmHg);
        TextView In = (TextView) findViewById(R.id.mmH2O);
        TextView Sm = (TextView) findViewById(R.id.kgf);
        TextView mm = (TextView) findViewById(R.id.kgfcm);
        TextView um = (TextView) findViewById(R.id.psf);
        TextView nm = (TextView) findViewById(R.id.psi);


        edNum = (EditText) findViewById(R.id.edNum);
        edAtm = (EditText) findViewById(R.id.edAtm);
        edBar = (EditText) findViewById(R.id.edBar);
        edPa = (EditText) findViewById(R.id.edPa);
        edMmH2O = (EditText) findViewById(R.id.edMmH2O);
        edMPa = (EditText) findViewById(R.id.edMPa);
        edKPa = (EditText) findViewById(R.id.edKPa);
        edMmhg = (EditText) findViewById(R.id.edMmhg);
        edKgM = (EditText) findViewById(R.id.edKgM);
        edKvFut = (EditText) findViewById(R.id.edKvFut);
        edKvDuim = (EditText) findViewById(R.id.edKvDuim);
        edKgfcm = (EditText) findViewById(R.id.edKgfcm);


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


            edAtm.setBackgroundColor(getEditTextActivityColor());
            edAtm.setTextColor(getEditTextColor());
            edBar.setBackgroundColor(getEditTextActivityColor());
            edBar.setTextColor(getEditTextColor());
            edPa.setBackgroundColor(getEditTextActivityColor());
            edPa.setTextColor(getEditTextColor());
            edMmH2O.setBackgroundColor(getEditTextActivityColor());
            edMmH2O.setTextColor(getEditTextColor());
            edMPa.setBackgroundColor(getEditTextActivityColor());
            edMPa.setTextColor(getEditTextColor());
            edKPa.setBackgroundColor(getEditTextActivityColor());
            edKPa.setTextColor(getEditTextColor());
            edMmhg.setBackgroundColor(getEditTextActivityColor());
            edMmhg.setTextColor(getEditTextColor());
            edKgM.setBackgroundColor(getEditTextActivityColor());
            edKgM.setTextColor(getEditTextColor());
            edKvFut.setBackgroundColor(getEditTextActivityColor());
            edKvFut.setTextColor(getEditTextColor());
            edKvDuim.setBackgroundColor(getEditTextActivityColor());
            edKvDuim.setTextColor(getEditTextColor());
            edKgfcm.setBackgroundColor(getEditTextActivityColor());
            edKgfcm.setTextColor(getEditTextColor());

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
                        || (edNum.getText().toString().equals("."))
                        || (edNum.getText().toString().equals("-"))) {

                    edAtm.setText("");
                    edBar.setText("");
                    edPa.setText("");
                    edMmhg.setText("");
                    edMmH2O.setText("");
                    edKgM.setText("");
                    edKvFut.setText("");
                    edKvDuim.setText("");
                    edMPa.setText("");
                    edKgfcm.setText("");
                    edKPa.setText("");

                    return;
                }
                num = Float.parseFloat(edNum.getText().toString());


                switch (position) {
                    case 0:
                        result = num + 0;
                        edAtm.setText(String.valueOf(roundUp(result, 4)));
                        result = num * 1.014;
                        edBar.setText(String.valueOf(roundUp(result, 4)));
                        result = num * 101325;
                        edPa.setText(String.valueOf(roundUp(result, 4)));
                        result = num * 760;
                        edMmhg.setText(String.valueOf(roundUp(result, 4)));
                        result = num * 10332.275;
                        edKgM.setText(String.valueOf(roundUp(result, 4)));
                        result = num * 2116.219;
                        edKvFut.setText(String.valueOf(roundUp(result, 4)));
                        result = num * 14.696;
                        edKvDuim.setText(String.valueOf(roundUp(result, 4)));
                        result = num * 10330;
                        edMmH2O.setText(String.valueOf(roundUp(result, 4)));
                        result = num * 0.1013;
                        edMPa.setText(String.valueOf(roundUp(result, 4)));
                        result = num * 1.033;
                        edKgfcm.setText(String.valueOf(roundUp(result, 4)));
                        result = num * 101.3;
                        edKPa.setText(String.valueOf(roundUp(result, 2)));
                        break;
                    case 1:
                        result = num * 0.987;
                        edAtm.setText(String.valueOf(roundUp(result, 4)));
                        result = num + 0;
                        edBar.setText(String.valueOf(roundUp(result, 4)));
                        result = num * 100000;
                        edPa.setText(String.valueOf(roundUp(result, 4)));
                        result = num * 750.062;
                        edMmhg.setText(String.valueOf(roundUp(result, 4)));
                        result = num * 10197.162;
                        edKgM.setText(String.valueOf(roundUp(result, 4)));
                        result = num * 2088.546;
                        edKvFut.setText(String.valueOf(roundUp(result, 4)));
                        result = num * 14.504;
                        edKvDuim.setText(String.valueOf(roundUp(result, 4)));
                        result = num * 10200;
                        edMmH2O.setText(String.valueOf(roundUp(result, 4)));
                        result = num * 0.1;
                        edMPa.setText(String.valueOf(roundUp(result, 4)));
                        result = num * 1.02;
                        edKgfcm.setText(String.valueOf(roundUp(result, 4)));
                        result = num * 100;
                        edKPa.setText(String.valueOf(roundUp(result, 2)));
                        break;
                    case 2:
                        result = num * 9.9e-6;
                        edAtm.setText(String.valueOf(roundUp(result, 4)));
                        result = num * 1e-5;
                        edBar.setText(String.valueOf(roundUp(result, 4)));
                        result = num + 0;
                        edPa.setText(String.valueOf(roundUp(result, 4)));
                        result = num * 0.008;
                        edMmhg.setText(String.valueOf(roundUp(result, 4)));
                        result = num * 0.102;
                        edKgM.setText(String.valueOf(roundUp(result, 4)));
                        result = num * 0.021;
                        edKvFut.setText(String.valueOf(roundUp(result, 4)));
                        result = num * 0.00015;
                        edKvDuim.setText(String.valueOf(roundUp(result, 4)));
                        result = num * 0.102;
                        edMmH2O.setText(String.valueOf(roundUp(result, 4)));
                        result = num * 0.000001;
                        edMPa.setText(String.valueOf(roundUp(result, 4)));
                        result = num * 0.0000102;
                        edKgfcm.setText(String.valueOf(roundUp(result, 4)));
                        result = num * 0.001;
                        edKPa.setText(String.valueOf(roundUp(result, 2)));
                        break;
                    case 3:
                        result = num * 0.00133;
                        edAtm.setText(String.valueOf(roundUp(result, 4)));
                        result = num * 0.0014;
                        edBar.setText(String.valueOf(roundUp(result, 4)));
                        result = num * 133.322;
                        edPa.setText(String.valueOf(roundUp(result, 4)));
                        result = num + 0;
                        edMmhg.setText(String.valueOf(roundUp(result, 4)));
                        result = num * 13.595;
                        edKgM.setText(String.valueOf(roundUp(result, 4)));
                        result = num * 2.784;
                        edKvFut.setText(String.valueOf(roundUp(result, 4)));
                        result = num * 0.02;
                        edKvDuim.setText(String.valueOf(roundUp(result, 4)));
                        result = num * 13.6;
                        edMmH2O.setText(String.valueOf(roundUp(result, 4)));
                        result = num * 0.0001333;
                        edMPa.setText(String.valueOf(roundUp(result, 4)));
                        result = num * 0.0000102;
                        edKgfcm.setText(String.valueOf(roundUp(result, 4)));
                        result = num * 0.1333;
                        edKPa.setText(String.valueOf(roundUp(result, 2)));
                        break;
                    case 4:
                        result = num * 0.0001;
                        edAtm.setText(String.valueOf(roundUp(result, 4)));
                        result = num * 0.0001;
                        edBar.setText(String.valueOf(roundUp(result, 4)));
                        result = num * 9.807;
                        edPa.setText(String.valueOf(roundUp(result, 4)));
                        result = num * 0.0735;
                        edMmhg.setText(String.valueOf(roundUp(result, 4)));
                        result = num + 0;
                        edKgM.setText(String.valueOf(roundUp(result, 4)));
                        result = num * 0.205;
                        edKvFut.setText(String.valueOf(roundUp(result, 4)));
                        result = num * 0.001;
                        edKvDuim.setText(String.valueOf(roundUp(result, 4)));
                        result = num * 1;
                        edMmH2O.setText(String.valueOf(roundUp(result, 4)));
                        result = num * 0.000009807;
                        edMPa.setText(String.valueOf(roundUp(result, 4)));
                        result = num * 0.0001;
                        edKgfcm.setText(String.valueOf(roundUp(result, 4)));
                        result = num * 0.1333;
                        edKPa.setText(String.valueOf(roundUp(result, 2)));
                        break;
                    case 5:
                        result = num * 0.00047;
                        edAtm.setText(String.valueOf(roundUp(result, 4)));
                        result = num * 0.000478;
                        edBar.setText(String.valueOf(roundUp(result, 4)));
                        result = num * 47.88;
                        edPa.setText(String.valueOf(roundUp(result, 4)));
                        result = num * 0.3591;
                        edMmhg.setText(String.valueOf(roundUp(result, 4)));
                        result = num * 4.882;
                        edKgM.setText(String.valueOf(roundUp(result, 4)));
                        result = num + 0;
                        edKvFut.setText(String.valueOf(roundUp(result, 4)));
                        result = num * 0.0069;
                        edKvDuim.setText(String.valueOf(roundUp(result, 4)));
                        result = num * 4.882;
                        edMmH2O.setText(String.valueOf(roundUp(result, 4)));
                        result = num * 0.00004788;
                        edMPa.setText(String.valueOf(roundUp(result, 4)));
                        result = num * 0.0004882;
                        edKgfcm.setText(String.valueOf(roundUp(result, 4)));
                        result = num * 0.04788;
                        edKPa.setText(String.valueOf(roundUp(result, 2)));
                        break;
                    case 6:
                        result = num * 0.068;
                        edAtm.setText(String.valueOf(roundUp(result, 4)));
                        result = num * 0.069;
                        edBar.setText(String.valueOf(roundUp(result, 4)));
                        result = num * 6895.750;
                        edPa.setText(String.valueOf(roundUp(result, 4)));
                        result = num * 51.71;
                        edMmhg.setText(String.valueOf(roundUp(result, 4)));
                        result = num * 703.1;
                        edKgM.setText(String.valueOf(roundUp(result, 4)));
                        result = num * 144;
                        edKvFut.setText(String.valueOf(roundUp(result, 4)));
                        result = num + 0;
                        edKvDuim.setText(String.valueOf(roundUp(result, 4)));
                        result = num * 703.1;
                        edMmH2O.setText(String.valueOf(roundUp(result, 4)));
                        result = num * 0.006895;
                        edMPa.setText(String.valueOf(roundUp(result, 4)));
                        result = num * 0.07031;
                        edKgfcm.setText(String.valueOf(roundUp(result, 4)));
                        result = num * 13790;
                        edKPa.setText(String.valueOf(roundUp(result, 2)));
                        break;
                    case 7:
                        result = num * 0.000096;
                        edAtm.setText(String.valueOf(roundUp(result, 4)));
                        result = num * 0.000098;
                        edBar.setText(String.valueOf(roundUp(result, 4)));
                        result = num * 9.807;
                        edPa.setText(String.valueOf(roundUp(result, 4)));
                        result = num * 0.073;
                        edMmhg.setText(String.valueOf(roundUp(result, 4)));
                        result = num * 1;
                        edKgM.setText(String.valueOf(roundUp(result, 4)));
                        result = num * 0.2048;
                        edKvFut.setText(String.valueOf(roundUp(result, 4)));
                        result = num * 0.0014;
                        edKvDuim.setText(String.valueOf(roundUp(result, 4)));
                        result = num + 0;
                        edMmH2O.setText(String.valueOf(roundUp(result, 4)));
                        result = num * 0.000009807;
                        edMPa.setText(String.valueOf(roundUp(result, 4)));
                        result = num * 0.0001;
                        edKgfcm.setText(String.valueOf(roundUp(result, 4)));
                        result = num * 0.009807;
                        edKPa.setText(String.valueOf(roundUp(result, 2)));
                        break;
                    case 8:
                        result = num * 9.869;
                        edAtm.setText(String.valueOf(roundUp(result, 4)));
                        result = num * 10;
                        edBar.setText(String.valueOf(roundUp(result, 4)));
                        result = num * 1000000;
                        edPa.setText(String.valueOf(roundUp(result, 4)));
                        result = num * 7501;
                        edMmhg.setText(String.valueOf(roundUp(result, 4)));
                        result = num * 102000;
                        edKgM.setText(String.valueOf(roundUp(result, 4)));
                        result = num * 20890;
                        edKvFut.setText(String.valueOf(roundUp(result, 4)));
                        result = num * 145;
                        edKvDuim.setText(String.valueOf(roundUp(result, 4)));
                        result = num * 102000;
                        edMmH2O.setText(String.valueOf(roundUp(result, 4)));
                        result = num + 0;
                        edMPa.setText(String.valueOf(roundUp(result, 4)));
                        result = num * 10.2;
                        edKgfcm.setText(String.valueOf(roundUp(result, 4)));
                        result = num * 1000;
                        edKPa.setText(String.valueOf(roundUp(result, 2)));
                        break;
                    case 9:
                        result = num * 0.9678;
                        edAtm.setText(String.valueOf(roundUp(result, 4)));
                        result = num * 0.9807;
                        edBar.setText(String.valueOf(roundUp(result, 4)));
                        result = num * 98070;
                        edPa.setText(String.valueOf(roundUp(result, 4)));
                        result = num * 735.6;
                        edMmhg.setText(String.valueOf(roundUp(result, 4)));
                        result = num * 10000;
                        edKgM.setText(String.valueOf(roundUp(result, 4)));
                        result = num * 2048;
                        edKvFut.setText(String.valueOf(roundUp(result, 4)));
                        result = num * 14.22;
                        edKvDuim.setText(String.valueOf(roundUp(result, 4)));
                        result = num * 10000;
                        edMmH2O.setText(String.valueOf(roundUp(result, 4)));
                        result = num * 0.09807;
                        edMPa.setText(String.valueOf(roundUp(result, 4)));
                        result = num + 0;
                        edKgfcm.setText(String.valueOf(roundUp(result, 4)));
                        result = num * 98.07;
                        edKPa.setText(String.valueOf(roundUp(result, 2)));
                        break;

                    case 10:
                        result = num * 0.0098;
                        edAtm.setText(String.valueOf(roundUp(result, 4)));
                        result = num * 0.01;
                        edBar.setText(String.valueOf(roundUp(result, 4)));
                        result = num * 1000;
                        edPa.setText(String.valueOf(roundUp(result, 4)));
                        result = num * 7.501;
                        edMmhg.setText(String.valueOf(roundUp(result, 4)));
                        result = num * 102;
                        edKgM.setText(String.valueOf(roundUp(result, 4)));
                        result = num * 20.89;
                        edKvFut.setText(String.valueOf(roundUp(result, 4)));
                        result = num * 0.145;
                        edKvDuim.setText(String.valueOf(roundUp(result, 4)));
                        result = num * 102;
                        edMmH2O.setText(String.valueOf(roundUp(result, 4)));
                        result = num * 0.001;
                        edMPa.setText(String.valueOf(roundUp(result, 4)));
                        result = num * 0.0102;
                        edKgfcm.setText(String.valueOf(roundUp(result, 4)));
                        result = num + 0;
                        edKPa.setText(String.valueOf(roundUp(result, 2)));
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

            edAtm.setText("");
            edBar.setText("");
            edPa.setText("");
            edMPa.setText("");
            edKPa.setText("");
            edKgfcm.setText("");
            edMmhg.setText("");
            edMmH2O.setText("");
            edKgM.setText("");
            edKvFut.setText("");
            edKvDuim.setText("");

            return;
        }
        num = Float.parseFloat(edNum.getText().toString());
        {

        }

        switch (a) {

            case 0:
                result = num + 0;
                edAtm.setText(String.valueOf(roundUp(result, 4)));
                result = num * 1.014;
                edBar.setText(String.valueOf(roundUp(result, 4)));
                result = num * 101325;
                edPa.setText(String.valueOf(roundUp(result, 4)));
                result = num * 760;
                edMmhg.setText(String.valueOf(roundUp(result, 4)));
                result = num * 10332.275;
                edKgM.setText(String.valueOf(roundUp(result, 4)));
                result = num * 2116.219;
                edKvFut.setText(String.valueOf(roundUp(result, 4)));
                result = num * 14.696;
                edKvDuim.setText(String.valueOf(roundUp(result, 4)));
                result = num * 10330;
                edMmH2O.setText(String.valueOf(roundUp(result, 4)));
                result = num * 0.1013;
                edMPa.setText(String.valueOf(roundUp(result, 4)));
                result = num * 1.033;
                edKgfcm.setText(String.valueOf(roundUp(result, 4)));
                result = num * 101.3;
                edKPa.setText(String.valueOf(roundUp(result, 2)));
                break;
            case 1:
                result = num * 0.987;
                edAtm.setText(String.valueOf(roundUp(result, 4)));
                result = num + 0;
                edBar.setText(String.valueOf(roundUp(result, 4)));
                result = num * 100000;
                edPa.setText(String.valueOf(roundUp(result, 4)));
                result = num * 750.062;
                edMmhg.setText(String.valueOf(roundUp(result, 4)));
                result = num * 10197.162;
                edKgM.setText(String.valueOf(roundUp(result, 4)));
                result = num * 2088.546;
                edKvFut.setText(String.valueOf(roundUp(result, 4)));
                result = num * 14.504;
                edKvDuim.setText(String.valueOf(roundUp(result, 4)));
                result = num * 10200;
                edMmH2O.setText(String.valueOf(roundUp(result, 4)));
                result = num * 0.1;
                edMPa.setText(String.valueOf(roundUp(result, 4)));
                result = num * 1.02;
                edKgfcm.setText(String.valueOf(roundUp(result, 4)));
                result = num * 100;
                edKPa.setText(String.valueOf(roundUp(result, 2)));
                break;
            case 2:
                result = num * 9.9e-6;
                edAtm.setText(String.valueOf(roundUp(result, 4)));
                result = num * 1e-5;
                edBar.setText(String.valueOf(roundUp(result, 4)));
                result = num + 0;
                edPa.setText(String.valueOf(roundUp(result, 4)));
                result = num * 0.008;
                edMmhg.setText(String.valueOf(roundUp(result, 4)));
                result = num * 0.102;
                edKgM.setText(String.valueOf(roundUp(result, 4)));
                result = num * 0.021;
                edKvFut.setText(String.valueOf(roundUp(result, 4)));
                result = num * 0.00015;
                edKvDuim.setText(String.valueOf(roundUp(result, 4)));
                result = num * 0.102;
                edMmH2O.setText(String.valueOf(roundUp(result, 4)));
                result = num * 0.000001;
                edMPa.setText(String.valueOf(roundUp(result, 4)));
                result = num * 0.0000102;
                edKgfcm.setText(String.valueOf(roundUp(result, 4)));
                result = num * 0.001;
                edKPa.setText(String.valueOf(roundUp(result, 2)));
                break;
            case 3:
                result = num * 0.00133;
                edAtm.setText(String.valueOf(roundUp(result, 4)));
                result = num * 0.0014;
                edBar.setText(String.valueOf(roundUp(result, 4)));
                result = num * 133.322;
                edPa.setText(String.valueOf(roundUp(result, 4)));
                result = num + 0;
                edMmhg.setText(String.valueOf(roundUp(result, 4)));
                result = num * 13.595;
                edKgM.setText(String.valueOf(roundUp(result, 4)));
                result = num * 2.784;
                edKvFut.setText(String.valueOf(roundUp(result, 4)));
                result = num * 0.02;
                edKvDuim.setText(String.valueOf(roundUp(result, 4)));
                result = num * 13.6;
                edMmH2O.setText(String.valueOf(roundUp(result, 4)));
                result = num * 0.0001333;
                edMPa.setText(String.valueOf(roundUp(result, 4)));
                result = num * 0.0000102;
                edKgfcm.setText(String.valueOf(roundUp(result, 4)));
                result = num * 0.1333;
                edKPa.setText(String.valueOf(roundUp(result, 2)));
                break;
            case 4:
                result = num * 0.0001;
                edAtm.setText(String.valueOf(roundUp(result, 4)));
                result = num * 0.0001;
                edBar.setText(String.valueOf(roundUp(result, 4)));
                result = num * 9.807;
                edPa.setText(String.valueOf(roundUp(result, 4)));
                result = num * 0.0735;
                edMmhg.setText(String.valueOf(roundUp(result, 4)));
                result = num + 0;
                edKgM.setText(String.valueOf(roundUp(result, 4)));
                result = num * 0.205;
                edKvFut.setText(String.valueOf(roundUp(result, 4)));
                result = num * 0.001;
                edKvDuim.setText(String.valueOf(roundUp(result, 4)));
                result = num * 1;
                edMmH2O.setText(String.valueOf(roundUp(result, 4)));
                result = num * 0.000009807;
                edMPa.setText(String.valueOf(roundUp(result, 4)));
                result = num * 0.0001;
                edKgfcm.setText(String.valueOf(roundUp(result, 4)));
                result = num * 0.1333;
                edKPa.setText(String.valueOf(roundUp(result, 2)));
                break;
            case 5:
                result = num * 0.00047;
                edAtm.setText(String.valueOf(roundUp(result, 4)));
                result = num * 0.000478;
                edBar.setText(String.valueOf(roundUp(result, 4)));
                result = num * 47.88;
                edPa.setText(String.valueOf(roundUp(result, 4)));
                result = num * 0.3591;
                edMmhg.setText(String.valueOf(roundUp(result, 4)));
                result = num * 4.882;
                edKgM.setText(String.valueOf(roundUp(result, 4)));
                result = num + 0;
                edKvFut.setText(String.valueOf(roundUp(result, 4)));
                result = num * 0.0069;
                edKvDuim.setText(String.valueOf(roundUp(result, 4)));
                result = num * 4.882;
                edMmH2O.setText(String.valueOf(roundUp(result, 4)));
                result = num * 0.00004788;
                edMPa.setText(String.valueOf(roundUp(result, 4)));
                result = num * 0.0004882;
                edKgfcm.setText(String.valueOf(roundUp(result, 4)));
                result = num * 0.04788;
                edKPa.setText(String.valueOf(roundUp(result, 2)));
                break;
            case 6:
                result = num * 0.068;
                edAtm.setText(String.valueOf(roundUp(result, 4)));
                result = num * 0.069;
                edBar.setText(String.valueOf(roundUp(result, 4)));
                result = num * 6895.750;
                edPa.setText(String.valueOf(roundUp(result, 4)));
                result = num * 51.71;
                edMmhg.setText(String.valueOf(roundUp(result, 4)));
                result = num * 703.1;
                edKgM.setText(String.valueOf(roundUp(result, 4)));
                result = num * 144;
                edKvFut.setText(String.valueOf(roundUp(result, 4)));
                result = num + 0;
                edKvDuim.setText(String.valueOf(roundUp(result, 4)));
                result = num * 703.1;
                edMmH2O.setText(String.valueOf(roundUp(result, 4)));
                result = num * 0.006895;
                edMPa.setText(String.valueOf(roundUp(result, 4)));
                result = num * 0.07031;
                edKgfcm.setText(String.valueOf(roundUp(result, 4)));
                result = num * 13790;
                edKPa.setText(String.valueOf(roundUp(result, 2)));
                break;
            case 7:
                result = num * 0.000096;
                edAtm.setText(String.valueOf(roundUp(result, 4)));
                result = num * 0.000098;
                edBar.setText(String.valueOf(roundUp(result, 4)));
                result = num * 9.807;
                edPa.setText(String.valueOf(roundUp(result, 4)));
                result = num * 0.073;
                edMmhg.setText(String.valueOf(roundUp(result, 4)));
                result = num * 1;
                edKgM.setText(String.valueOf(roundUp(result, 4)));
                result = num * 0.2048;
                edKvFut.setText(String.valueOf(roundUp(result, 4)));
                result = num * 0.0014;
                edKvDuim.setText(String.valueOf(roundUp(result, 4)));
                result = num + 0;
                edMmH2O.setText(String.valueOf(roundUp(result, 4)));
                result = num * 0.000009807;
                edMPa.setText(String.valueOf(roundUp(result, 4)));
                result = num * 0.0001;
                edKgfcm.setText(String.valueOf(roundUp(result, 4)));
                result = num * 0.009807;
                edKPa.setText(String.valueOf(roundUp(result, 2)));
                break;
            case 8:
                result = num * 9.869;
                edAtm.setText(String.valueOf(roundUp(result, 4)));
                result = num * 10;
                edBar.setText(String.valueOf(roundUp(result, 4)));
                result = num * 1000000;
                edPa.setText(String.valueOf(roundUp(result, 4)));
                result = num * 7501;
                edMmhg.setText(String.valueOf(roundUp(result, 4)));
                result = num * 102000;
                edKgM.setText(String.valueOf(roundUp(result, 4)));
                result = num * 20890;
                edKvFut.setText(String.valueOf(roundUp(result, 4)));
                result = num * 145;
                edKvDuim.setText(String.valueOf(roundUp(result, 4)));
                result = num * 102000;
                edMmH2O.setText(String.valueOf(roundUp(result, 4)));
                result = num + 0;
                edMPa.setText(String.valueOf(roundUp(result, 4)));
                result = num * 10.2;
                edKgfcm.setText(String.valueOf(roundUp(result, 4)));
                result = num * 1000;
                edKPa.setText(String.valueOf(roundUp(result, 2)));
                break;
            case 9:
                result = num * 0.9678;
                edAtm.setText(String.valueOf(roundUp(result, 4)));
                result = num * 0.9807;
                edBar.setText(String.valueOf(roundUp(result, 4)));
                result = num * 98070;
                edPa.setText(String.valueOf(roundUp(result, 4)));
                result = num * 735.6;
                edMmhg.setText(String.valueOf(roundUp(result, 4)));
                result = num * 10000;
                edKgM.setText(String.valueOf(roundUp(result, 4)));
                result = num * 2048;
                edKvFut.setText(String.valueOf(roundUp(result, 4)));
                result = num * 14.22;
                edKvDuim.setText(String.valueOf(roundUp(result, 4)));
                result = num * 10000;
                edMmH2O.setText(String.valueOf(roundUp(result, 4)));
                result = num * 0.09807;
                edMPa.setText(String.valueOf(roundUp(result, 4)));
                result = num + 0;
                edKgfcm.setText(String.valueOf(roundUp(result, 4)));
                result = num * 98.07;
                edKPa.setText(String.valueOf(roundUp(result, 2)));
                break;

            case 10:
                result = num * 0.0098;
                edAtm.setText(String.valueOf(roundUp(result, 4)));
                result = num * 0.01;
                edBar.setText(String.valueOf(roundUp(result, 4)));
                result = num * 1000;
                edPa.setText(String.valueOf(roundUp(result, 4)));
                result = num * 7.501;
                edMmhg.setText(String.valueOf(roundUp(result, 4)));
                result = num * 102;
                edKgM.setText(String.valueOf(roundUp(result, 4)));
                result = num * 20.89;
                edKvFut.setText(String.valueOf(roundUp(result, 4)));
                result = num * 0.145;
                edKvDuim.setText(String.valueOf(roundUp(result, 4)));
                result = num * 102;
                edMmH2O.setText(String.valueOf(roundUp(result, 4)));
                result = num * 0.001;
                edMPa.setText(String.valueOf(roundUp(result, 4)));
                result = num * 0.0102;
                edKgfcm.setText(String.valueOf(roundUp(result, 4)));
                result = num + 0;
                edKPa.setText(String.valueOf(roundUp(result, 2)));
                break;
        }

    }

    @Override
    public void afterTextChanged(Editable s) {

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.item, menu);


        MenuItem itemSwitch = menu.findItem(R.id.favorite);
        itemSwitch.setActionView(R.layout.toggle_button_favorite);
        tb = (ToggleButton) menu.findItem(R.id.favorite).getActionView().findViewById(R.id.favorite_switch);
        tb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked) {

                    getSaveCheckedFavorite();


                }
                if (!isChecked) {

                    getSaveCheckedFavorite();
                    //   Snackbar.make(buttonView,"Remove from Added",Snackbar.LENGTH_LONG).show();
                }
            }
        });


        getLoadCheckedFavorite();
        updateView();
        return true;


    }

    public void AddData(String newEntry){

        boolean insertData = myDB.addData(newEntry);

        if(insertData == true){
            Toast.makeText(DavlActivity.this, "SuccessFully Entered Data", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(DavlActivity.this, "Something went wrong", Toast.LENGTH_SHORT).show();

        }
    }




        @Override
        public boolean onOptionsItemSelected (MenuItem item){


            int id = item.getItemId();
            {

            }
//
            return super.onOptionsItemSelected(item);
        }


        public int getColor () {
            SharedPreferences mSharedPref = getSharedPreferences("ThemeColor", MODE_PRIVATE);
            int selectedColor = mSharedPref.getInt("color", getResources().getColor(R.color.brown_colorPrimary));
            return selectedColor;
        }

        private int getBackgroundColor () {
            SharedPreferences mSharedPref = getSharedPreferences("ThemeColor", MODE_PRIVATE);
            int selectedBackColor = mSharedPref.getInt("backcolor", getResources().getColor(R.color.dark_backgroundColorActivity));
            return selectedBackColor;
        }

        private int getTextColor () {

            SharedPreferences mSharedPref = getSharedPreferences("ThemeColor", MODE_PRIVATE);
            int textColor = mSharedPref.getInt("textColorMain", getResources().getColor(R.color.dark_textColorActivity));
            return textColor;


        }

        private int getEditTextColor () {

            SharedPreferences mSharedPref = getSharedPreferences("ThemeColor", MODE_PRIVATE);
            int textColor = mSharedPref.getInt("textEditColor", getResources().getColor(R.color.dark_editTextActivity));
            return textColor;


        }

        private int getEditTextActivityColor () {

            SharedPreferences mSharedPref = getSharedPreferences("ThemeColor", MODE_PRIVATE);
            int textColor = mSharedPref.getInt("textEditColorActivity", getResources().getColor(R.color.dark_editTextColorActivity));
            return textColor;

        }

        public void getSaveCheckedFavorite () {
            shared = getSharedPreferences("Shared_Pref", MODE_PRIVATE);
            ed = shared.edit();
            ed.putBoolean(Checked, tb.isChecked());
            //  ed.putString("Value", tb.getBackground().toString());
            ed.apply();
        }

        public void getLoadCheckedFavorite () {
            shared = getSharedPreferences("Shared_Pref", MODE_PRIVATE);
            switchOnOff = shared.getBoolean(Checked, false);

        }

        public void updateView () {
            tb.setChecked(switchOnOff);
        }

//        private void init () {
//
//            shared = getSharedPreferences("text", Context.MODE_PRIVATE);
//            ed = shared.edit();
//            etText = findViewById(R.id.etText);
//            sv_button = findViewById(R.id.sv_button);
//            clr_button = findViewById(R.id.btn_clear);
//            // edNum
//            //  ed.putBoolean(Checked,tb.isChecked());
//            // ed.apply();
//        }

}




