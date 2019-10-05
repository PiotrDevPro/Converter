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

public class RadiationActivity extends AppCompatActivity implements TextWatcher{

   // String[] data = {"Микрогрей (µGy)", "Миллигрей (mGy)", "Рад (rad)", "Грей (Gy)", "Микрозиверт (µSv)", "Миллибэр (mrem)", "Миллизиверт (mSv)", "Бэр (rem)", "Зиверт (Sv)", "Микрорентген (µР)", "Рентген (Р)", "Кулон на кг. (Кl/кg)", "Cред. фон радиация (за час)", "Рентгеновский снимок зуба", "Рентген грудной клетки","Смертельный исход на чел"};
    int a;
    Spinner spMassa;
    EditText edNum, edMgrey, edMilGrey,edRadi,edGyR,edUSv,edMbear,edMiliSv,edBear,edSv,edMicroPe,edPe,edKlKg,edRadMid,edPZub,edSnimok,edDe;
  //  TextView tvPosName;

    public BigDecimal roundUp(double value, int digits) {
        return new BigDecimal("" + value).setScale(digits, BigDecimal.ROUND_HALF_UP);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.radiation);

        Toolbar my_toolbar = (Toolbar) findViewById(R.id.my_toolbar_app);
        RelativeLayout backColorlayoutAds = (RelativeLayout) findViewById(R.id.reLayoutRadiationAds);
        CollapsingToolbarLayout bottomColorLayout = (CollapsingToolbarLayout) findViewById(R.id.RadiationBottomLayout);
        CoordinatorLayout corLoyDlinna = (CoordinatorLayout) findViewById(R.id.corLoyoutRadiation);
        setSupportActionBar(my_toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, //data);
       // adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        getResources().getStringArray(R.array.radiation));


        spMassa = (Spinner) findViewById(R.id.spMassa);
        spMassa.setAdapter(adapter);

        TextView Nm = (TextView) findViewById(R.id.Mgrey);
        TextView Km = (TextView) findViewById(R.id.MilGrey);
        TextView Mile = (TextView) findViewById(R.id.Radi);
        TextView m = (TextView) findViewById(R.id.GyR);
        TextView yard = (TextView) findViewById(R.id.Mbear);
        TextView ozff = (TextView) findViewById(R.id.MiliSv);
        TextView pdll = (TextView) findViewById(R.id.Bear);
        TextView kgff = (TextView) findViewById(R.id.Sv);
        TextView gff = (TextView) findViewById(R.id.MicroPe);
        TextView dynn = (TextView) findViewById(R.id.Pe);
        TextView uSv = (TextView) findViewById(R.id.USv);

        TextView KlKg = (TextView) findViewById(R.id.KlKg);
        TextView RadMid = (TextView) findViewById(R.id.RadMid);
        TextView PZub = (TextView) findViewById(R.id.PZub);
        TextView Snimok = (TextView) findViewById(R.id.Snimok);
        TextView De = (TextView) findViewById(R.id.De);




        edNum = (EditText) findViewById(R.id.edNum);
       // tvPosName = (TextView) findViewById(R.id.tvPosName);


        edMgrey = (EditText) findViewById(R.id.edMgrey);
        edMilGrey = (EditText) findViewById(R.id.edMilGrey);
        edRadi = (EditText) findViewById(R.id.edRadi);
        edGyR = (EditText) findViewById(R.id.edGyR);
        edUSv = (EditText) findViewById(R.id.edUSv);
        edMbear = (EditText) findViewById(R.id.edMbear);
        edMiliSv = (EditText) findViewById(R.id.edMiliSv);
        edBear = (EditText) findViewById(R.id.edBear);
        edSv = (EditText) findViewById(R.id.edSv);
        edMicroPe = (EditText) findViewById(R.id.edMicroPe);
        edPe = (EditText) findViewById(R.id.edPe);

        edKlKg = (EditText) findViewById(R.id.edKlKg);
        edRadMid = (EditText) findViewById(R.id.edRadMid);
        edPZub = (EditText) findViewById(R.id.edPZub);
        edSnimok = (EditText) findViewById(R.id.edSnimok);
        edDe = (EditText) findViewById(R.id.edDe);

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
            uSv.setTextColor(getTextColor());
            KlKg.setTextColor(getTextColor());
            RadMid.setTextColor(getTextColor());
            PZub.setTextColor(getTextColor());
            Snimok.setTextColor(getTextColor());
            De.setTextColor(getTextColor());


            edMgrey.setBackgroundColor(getEditTextActivityColor());
            edMgrey.setTextColor(getEditTextColor());
            edMilGrey.setBackgroundColor(getEditTextActivityColor());
            edMilGrey.setTextColor(getEditTextColor());
            edRadi.setBackgroundColor(getEditTextActivityColor());
            edRadi.setTextColor(getEditTextColor());
            edGyR.setBackgroundColor(getEditTextActivityColor());
            edGyR.setTextColor(getEditTextColor());
            edUSv.setBackgroundColor(getEditTextActivityColor());
            edUSv.setTextColor(getEditTextColor());

            edMbear.setBackgroundColor(getEditTextActivityColor());
            edMbear.setTextColor(getEditTextColor());
            edMiliSv.setBackgroundColor(getEditTextActivityColor());
            edMiliSv.setTextColor(getEditTextColor());
            edBear.setBackgroundColor(getEditTextActivityColor());
            edBear.setTextColor(getEditTextColor());
            edSv.setBackgroundColor(getEditTextActivityColor());
            edSv.setTextColor(getEditTextColor());
            edMicroPe.setBackgroundColor(getEditTextActivityColor());
            edMicroPe.setTextColor(getEditTextColor());

            edPe.setBackgroundColor(getEditTextActivityColor());
            edPe.setTextColor(getEditTextColor());
            edKlKg.setBackgroundColor(getEditTextActivityColor());
            edKlKg.setTextColor(getEditTextColor());
            edRadMid.setBackgroundColor(getEditTextActivityColor());
            edRadMid.setTextColor(getEditTextColor());
            edPZub.setBackgroundColor(getEditTextActivityColor());
            edPZub.setTextColor(getEditTextColor());
            edSnimok.setBackgroundColor(getEditTextActivityColor());
            edSnimok.setTextColor(getEditTextColor());

            edDe.setBackgroundColor(getEditTextActivityColor());
            edDe.setTextColor(getEditTextColor());


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

                    edMgrey.setText("");
                    edMilGrey.setText("");
                    edRadi.setText("");
                    edGyR.setText("");
                    edUSv.setText("");
                    edMbear.setText("");
                    edMiliSv.setText("");
                    edBear.setText("");
                    edSv.setText("");
                    edMicroPe.setText("");
                    edPe.setText("");
                    edKlKg.setText("");
                    edRadMid.setText("");
                    edPZub.setText("");
                    edSnimok.setText("");
                    edDe.setText("");

                    return;
                }

                num = Double.parseDouble(edNum.getText().toString());

                switch (position){
                    case 0:
                        result = (num + 0);
                        edMgrey.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.001);
                        edMilGrey.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.0001);
                        edRadi.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.000001);
                        edGyR.setText(String.valueOf(roundUp(result,4)));
                        result = (num* 1);
                        edUSv.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.1);
                        edMbear.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.001);
                        edMiliSv.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.0001);
                        edBear.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.000001);
                        edSv.setText(String.valueOf(roundUp(result,4)));
                        result = (num*115);
                        edMicroPe.setText(String.valueOf(roundUp(result,4)));
                        result = (num *0.000114);
                        edPe.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.00000002942);
                        edKlKg.setText(String.valueOf(roundUp(result,4)));
                        result = (num*4.348);
                        edRadMid.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.2);
                        edPZub.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.00007143);
                        edSnimok.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.000000125);
                        edDe.setText(String.valueOf(roundUp(result,4)));
                        break;

                    case 1:
                        result = (num * 1000);
                        edMgrey.setText(String.valueOf(roundUp(result,4)));
                        result = (num + 0);
                        edMilGrey.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.1);
                        edRadi.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.001);
                        edGyR.setText(String.valueOf(roundUp(result,4)));
                        result = (num* 1000);
                        edUSv.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 100);
                        edMbear.setText(String.valueOf(roundUp(result,4)));
                        result = (num*1);
                        edMiliSv.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.1);
                        edBear.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.001);
                        edSv.setText(String.valueOf(roundUp(result,4)));
                        result = (num*115000);
                        edMicroPe.setText(String.valueOf(roundUp(result,4)));
                        result = (num *0.114);
                        edPe.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.00002942);
                        edKlKg.setText(String.valueOf(roundUp(result,4)));
                        result = (num*4348);
                        edRadMid.setText(String.valueOf(roundUp(result,4)));
                        result = (num*200);
                        edPZub.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.07143);
                        edSnimok.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.000125);
                        edDe.setText(String.valueOf(roundUp(result,4)));
                        break;
                    case 2:
                        result = (num * 10000);
                        edMgrey.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 10);
                        edMilGrey.setText(String.valueOf(roundUp(result,4)));
                        result = (num + 0);
                        edRadi.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.01);
                        edGyR.setText(String.valueOf(roundUp(result,4)));
                        result = (num* 10000);
                        edUSv.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 1000);
                        edMbear.setText(String.valueOf(roundUp(result,4)));
                        result = (num*10);
                        edMiliSv.setText(String.valueOf(roundUp(result,4)));
                        result = (num*1);
                        edBear.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.01);
                        edSv.setText(String.valueOf(roundUp(result,4)));
                        result = (num*1150000);
                        edMicroPe.setText(String.valueOf(roundUp(result,4)));
                        result = (num *1.14);
                        edPe.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.0002942);
                        edKlKg.setText(String.valueOf(roundUp(result,4)));
                        result = (num*43480);
                        edRadMid.setText(String.valueOf(roundUp(result,4)));
                        result = (num*2000);
                        edPZub.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.7143);
                        edSnimok.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.00125);
                        edDe.setText(String.valueOf(roundUp(result,4)));
                        break;
                    case 3:

                        result = (num * 1000000);
                        edMgrey.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 1000);
                        edMilGrey.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 100);
                        edRadi.setText(String.valueOf(roundUp(result,4)));
                        result = (num + 0);
                        edGyR.setText(String.valueOf(roundUp(result,4)));
                        result = (num* 1000000);
                        edUSv.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 100000);
                        edMbear.setText(String.valueOf(roundUp(result,4)));
                        result = (num*1000);
                        edMiliSv.setText(String.valueOf(roundUp(result,4)));
                        result = (num*100);
                        edBear.setText(String.valueOf(roundUp(result,4)));
                        result = (num*1);
                        edSv.setText(String.valueOf(roundUp(result,4)));
                        result = (num*115000000);
                        edMicroPe.setText(String.valueOf(roundUp(result,4)));
                        result = (num *114);
                        edPe.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.02942);
                        edKlKg.setText(String.valueOf(roundUp(result,4)));
                        result = (num*4348000);
                        edRadMid.setText(String.valueOf(roundUp(result,4)));
                        result = (num*200000);
                        edPZub.setText(String.valueOf(roundUp(result,4)));
                        result = (num*71.43);
                        edSnimok.setText(String.valueOf(roundUp(result,4)));
                        result = (num*800);
                        edDe.setText(String.valueOf(roundUp(result,4)));

                        result = (num*0.125);
                        edDe.setText(String.valueOf(roundUp(result,4)));
                        break;

                    case 4:
                        result = (num * 1);
                        edMgrey.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.001);
                        edMilGrey.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.0001);
                        edRadi.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.000001);
                        edGyR.setText(String.valueOf(roundUp(result,4)));
                        result = (num+0);
                        edUSv.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.1);
                        edMbear.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.001);
                        edMiliSv.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.0001);
                        edBear.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.000001);
                        edSv.setText(String.valueOf(roundUp(result,4)));
                        result = (num*115);
                        edMicroPe.setText(String.valueOf(roundUp(result,4)));
                        result = (num *0.000114);
                        edPe.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.00000002942);
                        edKlKg.setText(String.valueOf(roundUp(result,4)));
                        result = (num*4.348);
                        edRadMid.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.2);
                        edPZub.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.00007143);
                        edSnimok.setText(String.valueOf(roundUp(result,4)));

                        result = (num*0.000000125);
                        edDe.setText(String.valueOf(roundUp(result,4)));
                        break;
                    case 5:

                        result = (num * 10);
                        edMgrey.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.01);
                        edMilGrey.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.001);
                        edRadi.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.00001);
                        edGyR.setText(String.valueOf(roundUp(result,4)));
                        result = (num*10);
                        edUSv.setText(String.valueOf(roundUp(result,4)));
                        result = (num +0);
                        edMbear.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.01);
                        edMiliSv.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.001);
                        edBear.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.00001);
                        edSv.setText(String.valueOf(roundUp(result,4)));
                        result = (num*1150);
                        edMicroPe.setText(String.valueOf(roundUp(result,4)));
                        result = (num *0.00114);
                        edPe.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.0000002942);
                        edKlKg.setText(String.valueOf(roundUp(result,4)));
                        result = (num*43.48);
                        edRadMid.setText(String.valueOf(roundUp(result,4)));
                        result = (num*2);
                        edPZub.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.0007143);
                        edSnimok.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.00000125);
                        edDe.setText(String.valueOf(roundUp(result,4)));
                        break;

                    case 6:
                        result = (num * 1000);
                        edMgrey.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 1);
                        edMilGrey.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.1);
                        edRadi.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.001);
                        edGyR.setText(String.valueOf(roundUp(result,4)));
                        result = (num*1000);
                        edUSv.setText(String.valueOf(roundUp(result,4)));
                        result = (num *100);
                        edMbear.setText(String.valueOf(roundUp(result,4)));
                        result = (num+0);
                        edMiliSv.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.1);
                        edBear.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.001);
                        edSv.setText(String.valueOf(roundUp(result,4)));
                        result = (num*115000);
                        edMicroPe.setText(String.valueOf(roundUp(result,4)));
                        result = (num *0.114);
                        edPe.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.00002942);
                        edKlKg.setText(String.valueOf(roundUp(result,4)));
                        result = (num*4348);
                        edRadMid.setText(String.valueOf(roundUp(result,4)));
                        result = (num*200);
                        edPZub.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.07143);
                        edSnimok.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.000125);
                        edDe.setText(String.valueOf(roundUp(result,4)));
                        break;

                    case 7:
                        result = (num * 10000);
                        edMgrey.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 10);
                        edMilGrey.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 1);
                        edRadi.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.01);
                        edGyR.setText(String.valueOf(roundUp(result,4)));
                        result = (num*10000);
                        edUSv.setText(String.valueOf(roundUp(result,4)));
                        result = (num *1000);
                        edMbear.setText(String.valueOf(roundUp(result,4)));
                        result = (num*10);
                        edMiliSv.setText(String.valueOf(roundUp(result,4)));
                        result = (num+0);
                        edBear.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.001);
                        edSv.setText(String.valueOf(roundUp(result,4)));
                        result = (num*1150000);
                        edMicroPe.setText(String.valueOf(roundUp(result,4)));
                        result = (num *1.14);
                        edPe.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.0002942);
                        edKlKg.setText(String.valueOf(roundUp(result,4)));
                        result = (num*43480);
                        edRadMid.setText(String.valueOf(roundUp(result,4)));
                        result = (num*2000);
                        edPZub.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.7143);
                        edSnimok.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.00125);
                        edDe.setText(String.valueOf(roundUp(result,4)));
                        break;
                    case 8:
                        result = (num * 1000000);
                        edMgrey.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 1000);
                        edMilGrey.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 100);
                        edRadi.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 1);
                        edGyR.setText(String.valueOf(roundUp(result,4)));
                        result = (num*1000000);
                        edUSv.setText(String.valueOf(roundUp(result,4)));
                        result = (num *100000);
                        edMbear.setText(String.valueOf(roundUp(result,4)));
                        result = (num*1000);
                        edMiliSv.setText(String.valueOf(roundUp(result,4)));
                        result = (num*100);
                        edBear.setText(String.valueOf(roundUp(result,4)));
                        result = (num+0);
                        edSv.setText(String.valueOf(roundUp(result,4)));
                        result = (num*115000000);
                        edMicroPe.setText(String.valueOf(roundUp(result,4)));
                        result = (num *114);
                        edPe.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.02942);
                        edKlKg.setText(String.valueOf(roundUp(result,4)));
                        result = (num*4348000);
                        edRadMid.setText(String.valueOf(roundUp(result,4)));
                        result = (num*200000);
                        edPZub.setText(String.valueOf(roundUp(result,4)));
                        result = (num*71.43);
                        edSnimok.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.125);
                        edDe.setText(String.valueOf(roundUp(result,4)));
                        break;

                    case 9:
                        result = (num * 0.008696);
                        edMgrey.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.000008696);
                        edMilGrey.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.0000008696);
                        edRadi.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.000000008696);
                        edGyR.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.008696);
                        edUSv.setText(String.valueOf(roundUp(result,4)));
                        result = (num *0.0008696);
                        edMbear.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.000008696);
                        edMiliSv.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.0000008696);
                        edBear.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.000000008696);
                        edSv.setText(String.valueOf(roundUp(result,4)));
                        result = (num+0);
                        edMicroPe.setText(String.valueOf(roundUp(result,4)));
                        result = (num *0.000001);
                        edPe.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.000000000258);
                        edKlKg.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.03781);
                        edRadMid.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.001739);
                        edPZub.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.0000006211);
                        edSnimok.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.000000001087);
                        edDe.setText(String.valueOf(roundUp(result,4)));
                        break;
                    case 10:

                        result = (num * 8770);
                        edMgrey.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 8.77);
                        edMilGrey.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.877);
                        edRadi.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.00877);
                        edGyR.setText(String.valueOf(roundUp(result,4)));
                        result = (num*8770);
                        edUSv.setText(String.valueOf(roundUp(result,4)));
                        result = (num *877);
                        edMbear.setText(String.valueOf(roundUp(result,4)));
                        result = (num*8.77);
                        edMiliSv.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.877);
                        edBear.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.00877);
                        edSv.setText(String.valueOf(roundUp(result,4)));
                        result = (num*1000000);
                        edMicroPe.setText(String.valueOf(roundUp(result,4)));
                        result = (num+0);
                        edPe.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.000258);
                        edKlKg.setText(String.valueOf(roundUp(result,4)));
                        result = (num*38130);
                        edRadMid.setText(String.valueOf(roundUp(result,4)));
                        result = (num*1754);
                        edPZub.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.6264);
                        edSnimok.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.001096);
                        edDe.setText(String.valueOf(roundUp(result,4)));
                        break;

                    case 11:

                        result = (num * 34000000);
                        edMgrey.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 34000);
                        edMilGrey.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 3400);
                        edRadi.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 34);
                        edGyR.setText(String.valueOf(roundUp(result,4)));
                        result = (num*34000000);
                        edUSv.setText(String.valueOf(roundUp(result,4)));
                        result = (num *340000);
                        edMbear.setText(String.valueOf(roundUp(result,4)));
                        result = (num*34000);
                        edMiliSv.setText(String.valueOf(roundUp(result,4)));
                        result = (num*3400);
                        edBear.setText(String.valueOf(roundUp(result,4)));
                        result = (num*34);
                        edSv.setText(String.valueOf(roundUp(result,4)));
                        result = (num*3.876e+9);
                        edMicroPe.setText(String.valueOf(roundUp(result,4)));
                        result = (num*3876);
                        edPe.setText(String.valueOf(roundUp(result,4)));
                        result = (num+0);
                        edKlKg.setText(String.valueOf(roundUp(result,4)));
                        result = (num*147800000);
                        edRadMid.setText(String.valueOf(roundUp(result,4)));
                        result = (num*6799000);
                        edPZub.setText(String.valueOf(roundUp(result,4)));
                        result = (num*2428);
                        edSnimok.setText(String.valueOf(roundUp(result,4)));
                        result = (num*4.249);
                        edDe.setText(String.valueOf(roundUp(result,4)));
                        break;

                    case 12:

                        result = (num * 0.23);
                        edMgrey.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.00023);
                        edMilGrey.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.000023);
                        edRadi.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.00000023);
                        edGyR.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.23);
                        edUSv.setText(String.valueOf(roundUp(result,4)));
                        result = (num *0.023);
                        edMbear.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.00023);
                        edMiliSv.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.000023);
                        edBear.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.00000023);
                        edSv.setText(String.valueOf(roundUp(result,4)));
                        result = (num*26.45);
                        edMicroPe.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.00002623);
                        edPe.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.000000006766);
                        edKlKg.setText(String.valueOf(roundUp(result,4)));
                        result = (num+0);
                        edRadMid.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.046);
                        edPZub.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.00001643);
                        edSnimok.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.00000002875);
                        edDe.setText(String.valueOf(roundUp(result,4)));
                        break;

                    case 13:

                        result = (num * 5);
                        edMgrey.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.005);
                        edMilGrey.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.0005);
                        edRadi.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.000005);
                        edGyR.setText(String.valueOf(roundUp(result,4)));
                        result = (num*5);
                        edUSv.setText(String.valueOf(roundUp(result,4)));
                        result = (num *0.5);
                        edMbear.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.005);
                        edMiliSv.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.0005);
                        edBear.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.000005);
                        edSv.setText(String.valueOf(roundUp(result,4)));
                        result = (num*575);
                        edMicroPe.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.0005701);
                        edPe.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.0000001471);
                        edKlKg.setText(String.valueOf(roundUp(result,4)));
                        result = (num*21.74);
                        edRadMid.setText(String.valueOf(roundUp(result,4)));
                        result = (num+0);
                        edPZub.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.0003571);
                        edSnimok.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.000000625);
                        edDe.setText(String.valueOf(roundUp(result,4)));
                        break;

                    case 14:

                        result = (num * 14000);
                        edMgrey.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 14);
                        edMilGrey.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 1.4);
                        edRadi.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.014);
                        edGyR.setText(String.valueOf(roundUp(result,4)));
                        result = (num*14000);
                        edUSv.setText(String.valueOf(roundUp(result,4)));
                        result = (num *1400);
                        edMbear.setText(String.valueOf(roundUp(result,4)));
                        result = (num*14);
                        edMiliSv.setText(String.valueOf(roundUp(result,4)));
                        result = (num*1.4);
                        edBear.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.014);
                        edSv.setText(String.valueOf(roundUp(result,4)));
                        result = (num*1610000);
                        edMicroPe.setText(String.valueOf(roundUp(result,4)));
                        result = (num*1.596);
                        edPe.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.0004118);
                        edKlKg.setText(String.valueOf(roundUp(result,4)));
                        result = (num*60870);
                        edRadMid.setText(String.valueOf(roundUp(result,4)));
                        result = (num*2800);
                        edPZub.setText(String.valueOf(roundUp(result,4)));
                        result = (num+0);
                        edSnimok.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.00175);
                        edDe.setText(String.valueOf(roundUp(result,4)));
                        break;

                    case 15:

                        result = (num * 8000000);
                        edMgrey.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 8000);
                        edMilGrey.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 800);
                        edRadi.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 8);
                        edGyR.setText(String.valueOf(roundUp(result,4)));
                        result = (num*8000000);
                        edUSv.setText(String.valueOf(roundUp(result,4)));
                        result = (num *800000);
                        edMbear.setText(String.valueOf(roundUp(result,4)));
                        result = (num*8000);
                        edMiliSv.setText(String.valueOf(roundUp(result,4)));
                        result = (num*800);
                        edBear.setText(String.valueOf(roundUp(result,4)));
                        result = (num*8);
                        edSv.setText(String.valueOf(roundUp(result,4)));
                        result = (num*920000000);
                        edMicroPe.setText(String.valueOf(roundUp(result,4)));
                        result = (num*912.2);
                        edPe.setText(String.valueOf(roundUp(result,4)));
                        result = (num*0.2353);
                        edKlKg.setText(String.valueOf(roundUp(result,4)));
                        result = (num*34780000);
                        edRadMid.setText(String.valueOf(roundUp(result,4)));
                        result = (num*1600000);
                        edPZub.setText(String.valueOf(roundUp(result,4)));
                        result = (num*571.4);
                        edSnimok.setText(String.valueOf(roundUp(result,4)));
                        result = (num+0);
                        edDe.setText(String.valueOf(roundUp(result,4)));
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

            edMgrey.setText("");
            edMilGrey.setText("");
            edRadi.setText("");
            edGyR.setText("");
            edUSv.setText("");
            edMbear.setText("");
            edMiliSv.setText("");
            edBear.setText("");
            edSv.setText("");
            edMicroPe.setText("");
            edPe.setText("");
            edKlKg.setText("");
            edRadMid.setText("");
            edPZub.setText("");
            edSnimok.setText("");
            edDe.setText("");

            return;
        }

        num = Double.parseDouble(edNum.getText().toString());

        switch (a){

            case 0:
                result = (num + 0);
                edMgrey.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.001);
                edMilGrey.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.0001);
                edRadi.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.000001);
                edGyR.setText(String.valueOf(roundUp(result,4)));
                result = (num* 1);
                edUSv.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.1);
                edMbear.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.001);
                edMiliSv.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.0001);
                edBear.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.000001);
                edSv.setText(String.valueOf(roundUp(result,4)));
                result = (num*115);
                edMicroPe.setText(String.valueOf(roundUp(result,4)));
                result = (num *0.000114);
                edPe.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.00000002942);
                edKlKg.setText(String.valueOf(roundUp(result,4)));
                result = (num*4.348);
                edRadMid.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.2);
                edPZub.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.00007143);
                edSnimok.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.000000125);
                edDe.setText(String.valueOf(roundUp(result,4)));

                break;

            case 1:
                result = (num * 1000);
                edMgrey.setText(String.valueOf(roundUp(result,4)));
                result = (num + 0);
                edMilGrey.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.1);
                edRadi.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.001);
                edGyR.setText(String.valueOf(roundUp(result,4)));
                result = (num* 1000);
                edUSv.setText(String.valueOf(roundUp(result,4)));
                result = (num * 100);
                edMbear.setText(String.valueOf(roundUp(result,4)));
                result = (num*1);
                edMiliSv.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.1);
                edBear.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.001);
                edSv.setText(String.valueOf(roundUp(result,4)));
                result = (num*115000);
                edMicroPe.setText(String.valueOf(roundUp(result,4)));
                result = (num *0.114);
                edPe.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.00002942);
                edKlKg.setText(String.valueOf(roundUp(result,4)));
                result = (num*4348);
                edRadMid.setText(String.valueOf(roundUp(result,4)));
                result = (num*200);
                edPZub.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.07143);
                edSnimok.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.000125);
                edDe.setText(String.valueOf(roundUp(result,4)));

                break;
            case 2:
                result = (num * 10000);
                edMgrey.setText(String.valueOf(roundUp(result,4)));
                result = (num * 10);
                edMilGrey.setText(String.valueOf(roundUp(result,4)));
                result = (num + 0);
                edRadi.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.01);
                edGyR.setText(String.valueOf(roundUp(result,4)));
                result = (num* 10000);
                edUSv.setText(String.valueOf(roundUp(result,4)));
                result = (num * 1000);
                edMbear.setText(String.valueOf(roundUp(result,4)));
                result = (num*10);
                edMiliSv.setText(String.valueOf(roundUp(result,4)));
                result = (num*1);
                edBear.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.01);
                edSv.setText(String.valueOf(roundUp(result,4)));
                result = (num*1150000);
                edMicroPe.setText(String.valueOf(roundUp(result,4)));
                result = (num *1.14);
                edPe.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.0002942);
                edKlKg.setText(String.valueOf(roundUp(result,4)));
                result = (num*43480);
                edRadMid.setText(String.valueOf(roundUp(result,4)));
                result = (num*2000);
                edPZub.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.7143);
                edSnimok.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.00125);
                edDe.setText(String.valueOf(roundUp(result,4)));

                break;
            case 3:

                result = (num * 1000000);
                edMgrey.setText(String.valueOf(roundUp(result,4)));
                result = (num * 1000);
                edMilGrey.setText(String.valueOf(roundUp(result,4)));
                result = (num * 100);
                edRadi.setText(String.valueOf(roundUp(result,4)));
                result = (num + 0);
                edGyR.setText(String.valueOf(roundUp(result,4)));
                result = (num* 1000000);
                edUSv.setText(String.valueOf(roundUp(result,4)));
                result = (num * 100000);
                edMbear.setText(String.valueOf(roundUp(result,4)));
                result = (num*1000);
                edMiliSv.setText(String.valueOf(roundUp(result,4)));
                result = (num*100);
                edBear.setText(String.valueOf(roundUp(result,4)));
                result = (num*1);
                edSv.setText(String.valueOf(roundUp(result,4)));
                result = (num*115000000);
                edMicroPe.setText(String.valueOf(roundUp(result,4)));
                result = (num *114);
                edPe.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.02942);
                edKlKg.setText(String.valueOf(roundUp(result,4)));
                result = (num*4348000);
                edRadMid.setText(String.valueOf(roundUp(result,4)));
                result = (num*200000);
                edPZub.setText(String.valueOf(roundUp(result,4)));
                result = (num*71.43);
                edSnimok.setText(String.valueOf(roundUp(result,4)));
                result = (num*800);
                edDe.setText(String.valueOf(roundUp(result,4)));

                result = (num*0.125);
                edDe.setText(String.valueOf(roundUp(result,4)));

                break;

            case 4:
                result = (num * 1);
                edMgrey.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.001);
                edMilGrey.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.0001);
                edRadi.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.000001);
                edGyR.setText(String.valueOf(roundUp(result,4)));
                result = (num+0);
                edUSv.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.1);
                edMbear.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.001);
                edMiliSv.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.0001);
                edBear.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.000001);
                edSv.setText(String.valueOf(roundUp(result,4)));
                result = (num*115);
                edMicroPe.setText(String.valueOf(roundUp(result,4)));
                result = (num *0.000114);
                edPe.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.00000002942);
                edKlKg.setText(String.valueOf(roundUp(result,4)));
                result = (num*4.348);
                edRadMid.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.2);
                edPZub.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.00007143);
                edSnimok.setText(String.valueOf(roundUp(result,4)));

                result = (num*0.000000125);
                edDe.setText(String.valueOf(roundUp(result,4)));

                break;
            case 5:

                result = (num * 10);
                edMgrey.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.01);
                edMilGrey.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.001);
                edRadi.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.00001);
                edGyR.setText(String.valueOf(roundUp(result,4)));
                result = (num*10);
                edUSv.setText(String.valueOf(roundUp(result,4)));
                result = (num +0);
                edMbear.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.01);
                edMiliSv.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.001);
                edBear.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.00001);
                edSv.setText(String.valueOf(roundUp(result,4)));
                result = (num*1150);
                edMicroPe.setText(String.valueOf(roundUp(result,4)));
                result = (num *0.00114);
                edPe.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.0000002942);
                edKlKg.setText(String.valueOf(roundUp(result,4)));
                result = (num*43.48);
                edRadMid.setText(String.valueOf(roundUp(result,4)));
                result = (num*2);
                edPZub.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.0007143);
                edSnimok.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.00000125);
                edDe.setText(String.valueOf(roundUp(result,4)));

                break;

            case 6:
                result = (num * 1000);
                edMgrey.setText(String.valueOf(roundUp(result,4)));
                result = (num * 1);
                edMilGrey.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.1);
                edRadi.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.001);
                edGyR.setText(String.valueOf(roundUp(result,4)));
                result = (num*1000);
                edUSv.setText(String.valueOf(roundUp(result,4)));
                result = (num *100);
                edMbear.setText(String.valueOf(roundUp(result,4)));
                result = (num+0);
                edMiliSv.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.1);
                edBear.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.001);
                edSv.setText(String.valueOf(roundUp(result,4)));
                result = (num*115000);
                edMicroPe.setText(String.valueOf(roundUp(result,4)));
                result = (num *0.114);
                edPe.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.00002942);
                edKlKg.setText(String.valueOf(roundUp(result,4)));
                result = (num*4348);
                edRadMid.setText(String.valueOf(roundUp(result,4)));
                result = (num*200);
                edPZub.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.07143);
                edSnimok.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.000125);
                edDe.setText(String.valueOf(roundUp(result,4)));

                break;

            case 7:
                result = (num * 10000);
                edMgrey.setText(String.valueOf(roundUp(result,4)));
                result = (num * 10);
                edMilGrey.setText(String.valueOf(roundUp(result,4)));
                result = (num * 1);
                edRadi.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.01);
                edGyR.setText(String.valueOf(roundUp(result,4)));
                result = (num*10000);
                edUSv.setText(String.valueOf(roundUp(result,4)));
                result = (num *1000);
                edMbear.setText(String.valueOf(roundUp(result,4)));
                result = (num*10);
                edMiliSv.setText(String.valueOf(roundUp(result,4)));
                result = (num+0);
                edBear.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.001);
                edSv.setText(String.valueOf(roundUp(result,4)));
                result = (num*1150000);
                edMicroPe.setText(String.valueOf(roundUp(result,4)));
                result = (num *1.14);
                edPe.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.0002942);
                edKlKg.setText(String.valueOf(roundUp(result,4)));
                result = (num*43480);
                edRadMid.setText(String.valueOf(roundUp(result,4)));
                result = (num*2000);
                edPZub.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.7143);
                edSnimok.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.00125);
                edDe.setText(String.valueOf(roundUp(result,4)));

                break;
            case 8:
                result = (num * 1000000);
                edMgrey.setText(String.valueOf(roundUp(result,4)));
                result = (num * 1000);
                edMilGrey.setText(String.valueOf(roundUp(result,4)));
                result = (num * 100);
                edRadi.setText(String.valueOf(roundUp(result,4)));
                result = (num * 1);
                edGyR.setText(String.valueOf(roundUp(result,4)));
                result = (num*1000000);
                edUSv.setText(String.valueOf(roundUp(result,4)));
                result = (num *100000);
                edMbear.setText(String.valueOf(roundUp(result,4)));
                result = (num*1000);
                edMiliSv.setText(String.valueOf(roundUp(result,4)));
                result = (num*100);
                edBear.setText(String.valueOf(roundUp(result,4)));
                result = (num+0);
                edSv.setText(String.valueOf(roundUp(result,4)));
                result = (num*115000000);
                edMicroPe.setText(String.valueOf(roundUp(result,4)));
                result = (num *114);
                edPe.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.02942);
                edKlKg.setText(String.valueOf(roundUp(result,4)));
                result = (num*4348000);
                edRadMid.setText(String.valueOf(roundUp(result,4)));
                result = (num*200000);
                edPZub.setText(String.valueOf(roundUp(result,4)));
                result = (num*71.43);
                edSnimok.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.125);
                edDe.setText(String.valueOf(roundUp(result,4)));

                break;

            case 9:
                result = (num * 0.008696);
                edMgrey.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.000008696);
                edMilGrey.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.0000008696);
                edRadi.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.000000008696);
                edGyR.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.008696);
                edUSv.setText(String.valueOf(roundUp(result,4)));
                result = (num *0.0008696);
                edMbear.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.000008696);
                edMiliSv.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.0000008696);
                edBear.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.000000008696);
                edSv.setText(String.valueOf(roundUp(result,4)));
                result = (num+0);
                edMicroPe.setText(String.valueOf(roundUp(result,4)));
                result = (num *0.000001);
                edPe.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.000000000258);
                edKlKg.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.03781);
                edRadMid.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.001739);
                edPZub.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.0000006211);
                edSnimok.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.000000001087);
                edDe.setText(String.valueOf(roundUp(result,4)));

                break;
            case 10:

                result = (num * 8770);
                edMgrey.setText(String.valueOf(roundUp(result,4)));
                result = (num * 8.77);
                edMilGrey.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.877);
                edRadi.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.00877);
                edGyR.setText(String.valueOf(roundUp(result,4)));
                result = (num*8770);
                edUSv.setText(String.valueOf(roundUp(result,4)));
                result = (num *877);
                edMbear.setText(String.valueOf(roundUp(result,4)));
                result = (num*8.77);
                edMiliSv.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.877);
                edBear.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.00877);
                edSv.setText(String.valueOf(roundUp(result,4)));
                result = (num*1000000);
                edMicroPe.setText(String.valueOf(roundUp(result,4)));
                result = (num+0);
                edPe.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.000258);
                edKlKg.setText(String.valueOf(roundUp(result,4)));
                result = (num*38130);
                edRadMid.setText(String.valueOf(roundUp(result,4)));
                result = (num*1754);
                edPZub.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.6264);
                edSnimok.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.001096);
                edDe.setText(String.valueOf(roundUp(result,4)));

                break;

            case 11:

                result = (num * 34000000);
                edMgrey.setText(String.valueOf(roundUp(result,4)));
                result = (num * 34000);
                edMilGrey.setText(String.valueOf(roundUp(result,4)));
                result = (num * 3400);
                edRadi.setText(String.valueOf(roundUp(result,4)));
                result = (num * 34);
                edGyR.setText(String.valueOf(roundUp(result,4)));
                result = (num*34000000);
                edUSv.setText(String.valueOf(roundUp(result,4)));
                result = (num *340000);
                edMbear.setText(String.valueOf(roundUp(result,4)));
                result = (num*34000);
                edMiliSv.setText(String.valueOf(roundUp(result,4)));
                result = (num*3400);
                edBear.setText(String.valueOf(roundUp(result,4)));
                result = (num*34);
                edSv.setText(String.valueOf(roundUp(result,4)));
                result = (num*3.876e+9);
                edMicroPe.setText(String.valueOf(roundUp(result,4)));
                result = (num*3876);
                edPe.setText(String.valueOf(roundUp(result,4)));
                result = (num+0);
                edKlKg.setText(String.valueOf(roundUp(result,4)));
                result = (num*147800000);
                edRadMid.setText(String.valueOf(roundUp(result,4)));
                result = (num*6799000);
                edPZub.setText(String.valueOf(roundUp(result,4)));
                result = (num*2428);
                edSnimok.setText(String.valueOf(roundUp(result,4)));
                result = (num*4.249);
                edDe.setText(String.valueOf(roundUp(result,4)));

                break;

            case 12:

                result = (num * 0.23);
                edMgrey.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.00023);
                edMilGrey.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.000023);
                edRadi.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.00000023);
                edGyR.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.23);
                edUSv.setText(String.valueOf(roundUp(result,4)));
                result = (num *0.023);
                edMbear.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.00023);
                edMiliSv.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.000023);
                edBear.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.00000023);
                edSv.setText(String.valueOf(roundUp(result,4)));
                result = (num*26.45);
                edMicroPe.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.00002623);
                edPe.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.000000006766);
                edKlKg.setText(String.valueOf(roundUp(result,4)));
                result = (num+0);
                edRadMid.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.046);
                edPZub.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.00001643);
                edSnimok.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.00000002875);
                edDe.setText(String.valueOf(roundUp(result,4)));

                break;

            case 13:

                result = (num * 5);
                edMgrey.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.005);
                edMilGrey.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.0005);
                edRadi.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.000005);
                edGyR.setText(String.valueOf(roundUp(result,4)));
                result = (num*5);
                edUSv.setText(String.valueOf(roundUp(result,4)));
                result = (num *0.5);
                edMbear.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.005);
                edMiliSv.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.0005);
                edBear.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.000005);
                edSv.setText(String.valueOf(roundUp(result,4)));
                result = (num*575);
                edMicroPe.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.0005701);
                edPe.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.0000001471);
                edKlKg.setText(String.valueOf(roundUp(result,4)));
                result = (num*21.74);
                edRadMid.setText(String.valueOf(roundUp(result,4)));
                result = (num+0);
                edPZub.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.0003571);
                edSnimok.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.000000625);
                edDe.setText(String.valueOf(roundUp(result,4)));

                break;

            case 14:

                result = (num * 14000);
                edMgrey.setText(String.valueOf(roundUp(result,4)));
                result = (num * 14);
                edMilGrey.setText(String.valueOf(roundUp(result,4)));
                result = (num * 1.4);
                edRadi.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.014);
                edGyR.setText(String.valueOf(roundUp(result,4)));
                result = (num*14000);
                edUSv.setText(String.valueOf(roundUp(result,4)));
                result = (num *1400);
                edMbear.setText(String.valueOf(roundUp(result,4)));
                result = (num*14);
                edMiliSv.setText(String.valueOf(roundUp(result,4)));
                result = (num*1.4);
                edBear.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.014);
                edSv.setText(String.valueOf(roundUp(result,4)));
                result = (num*1610000);
                edMicroPe.setText(String.valueOf(roundUp(result,4)));
                result = (num*1.596);
                edPe.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.0004118);
                edKlKg.setText(String.valueOf(roundUp(result,4)));
                result = (num*60870);
                edRadMid.setText(String.valueOf(roundUp(result,4)));
                result = (num*2800);
                edPZub.setText(String.valueOf(roundUp(result,4)));
                result = (num+0);
                edSnimok.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.00175);
                edDe.setText(String.valueOf(roundUp(result,4)));
                break;
            case 15:
                result = (num * 8000000);
                edMgrey.setText(String.valueOf(roundUp(result,4)));
                result = (num * 8000);
                edMilGrey.setText(String.valueOf(roundUp(result,4)));
                result = (num * 800);
                edRadi.setText(String.valueOf(roundUp(result,4)));
                result = (num * 8);
                edGyR.setText(String.valueOf(roundUp(result,4)));
                result = (num*8000000);
                edUSv.setText(String.valueOf(roundUp(result,4)));
                result = (num *800000);
                edMbear.setText(String.valueOf(roundUp(result,4)));
                result = (num*8000);
                edMiliSv.setText(String.valueOf(roundUp(result,4)));
                result = (num*800);
                edBear.setText(String.valueOf(roundUp(result,4)));
                result = (num*8);
                edSv.setText(String.valueOf(roundUp(result,4)));
                result = (num*920000000);
                edMicroPe.setText(String.valueOf(roundUp(result,4)));
                result = (num*912.2);
                edPe.setText(String.valueOf(roundUp(result,4)));
                result = (num*0.2353);
                edKlKg.setText(String.valueOf(roundUp(result,4)));
                result = (num*34780000);
                edRadMid.setText(String.valueOf(roundUp(result,4)));
                result = (num*1600000);
                edPZub.setText(String.valueOf(roundUp(result,4)));
                result = (num*571.4);
                edSnimok.setText(String.valueOf(roundUp(result,4)));
                result = (num+0);
                edDe.setText(String.valueOf(roundUp(result,4)));
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

