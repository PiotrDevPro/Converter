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

public class SvetActivity extends AppCompatActivity  implements TextWatcher{

   // String[] data = {"Люкс(люмен на кв.м) (lx)", "Люмен на кв.см (lm/cm²) ", "Люмен на кв.фут (lm/ft²)", "Люмен на кв.дюйм (lm/in²)", "Фут-кандела (fc)", "Фот (ph)", "Миллифот "};
    int a;
    Spinner spMassa;
    EditText edNum, edLx, edLmCm,edLmFt,edLmIn,edFc,edPh,edMiph;
   // TextView tvPosName;

    public BigDecimal roundUp(double value, int digits) {
        return new BigDecimal("" + value).setScale(digits, BigDecimal.ROUND_HALF_UP);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.svet);

        Toolbar my_toolbar = (Toolbar) findViewById(R.id.my_toolbar_app);
        RelativeLayout backColorlayoutAds = (RelativeLayout) findViewById(R.id.reLayoutSvet);
        CollapsingToolbarLayout bottomColorLayout = (CollapsingToolbarLayout) findViewById(R.id.SvetBottomLayout);
        CoordinatorLayout corLoyDlinna = (CoordinatorLayout) findViewById(R.id.reLayoutSvetCor);

        setSupportActionBar(my_toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, //data);
     //  adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                getResources().getStringArray(R.array.yarkost));


        spMassa = (Spinner) findViewById(R.id.spMassa);
        spMassa.setAdapter(adapter);

        TextView Nm = (TextView) findViewById(R.id.lx);
        TextView Km = (TextView) findViewById(R.id.lmcm2);
        TextView Mile = (TextView) findViewById(R.id.lmft2);
        TextView m = (TextView) findViewById(R.id.lmin2);
        TextView yard = (TextView) findViewById(R.id.fc);
        TextView ozff = (TextView) findViewById(R.id.ph);
        TextView pdll = (TextView) findViewById(R.id.mph);


        edNum = (EditText) findViewById(R.id.edNum);
      //  tvPosName = (TextView) findViewById(R.id.tvPosName);


        edLx = (EditText) findViewById(R.id.edLx);
        edLmCm = (EditText) findViewById(R.id.edLmCm);
        edLmFt = (EditText) findViewById(R.id.edLmFt);
        edLmIn = (EditText) findViewById(R.id.edLmIn);
        edFc = (EditText) findViewById(R.id.edFc);
        edPh = (EditText) findViewById(R.id.edPh);
        edMiph = (EditText) findViewById(R.id.edMiph);

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



            edLx.setBackgroundColor(getEditTextActivityColor());
            edLx.setTextColor(getEditTextColor());
            edLmCm.setBackgroundColor(getEditTextActivityColor());
            edLmCm.setTextColor(getEditTextColor());
            edLmFt.setBackgroundColor(getEditTextActivityColor());
            edLmFt.setTextColor(getEditTextColor());
            edLmIn.setBackgroundColor(getEditTextActivityColor());
            edLmIn.setTextColor(getEditTextColor());
            edFc.setBackgroundColor(getEditTextActivityColor());
            edFc.setTextColor(getEditTextColor());

            edPh.setBackgroundColor(getEditTextActivityColor());
            edPh.setTextColor(getEditTextColor());
            edMiph.setBackgroundColor(getEditTextActivityColor());
            edMiph.setTextColor(getEditTextColor());



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

                    edLx.setText("");
                    edLmCm.setText("");
                    edLmFt.setText("");
                    edLmIn.setText("");
                    edFc.setText("");
                    edPh.setText("");
                    edMiph.setText("");
                    return;
                }

                num = Double.parseDouble(edNum.getText().toString());

                switch (position) {
                    case 0:
                        result = (num + 0);
                        edLx.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.0001);
                        edLmCm.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.0929);
                        edLmFt.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.0006451);
                        edLmIn.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.0929);
                        edFc.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.0001);
                        edPh.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.1);
                        edMiph.setText(String.valueOf(roundUp(result,4)));

                        break;
                    case 1:

                        result = (num *10000);
                        edLx.setText(String.valueOf(roundUp(result,4)));
                        result = (num + 0);
                        edLmCm.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 929);
                        edLmFt.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 6.452);
                        edLmIn.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 929);
                        edFc.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 1);
                        edPh.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 1000);
                        edMiph.setText(String.valueOf(roundUp(result,4)));
                        break;

                    case 2:

                        result = (num *10.76);
                        edLx.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.001076);
                        edLmCm.setText(String.valueOf(roundUp(result,4)));
                        result = (num + 0);
                        edLmFt.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.006944);
                        edLmIn.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 1);
                        edFc.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.001076);
                        edPh.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 1.076);
                        edMiph.setText(String.valueOf(roundUp(result,4)));
                        break;
                    case 3:

                        result = (num *1550);
                        edLx.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.155);
                        edLmCm.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 144);
                        edLmFt.setText(String.valueOf(roundUp(result,4)));
                        result = (num + 0);
                        edLmIn.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 144);
                        edFc.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.155);
                        edPh.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 155);
                        edMiph.setText(String.valueOf(roundUp(result,4)));
                        break;
                    case 4:
                        result = (num *10.76);
                        edLx.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.001076);
                        edLmCm.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 1);
                        edLmFt.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.006944);
                        edLmIn.setText(String.valueOf(roundUp(result,4)));
                        result = (num + 0);
                        edFc.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.001076);
                        edPh.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 1.076);
                        edMiph.setText(String.valueOf(roundUp(result,4)));
                        break;

                    case 5:
                        result = (num *10000);
                        edLx.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 1);
                        edLmCm.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 929);
                        edLmFt.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 6.452);
                        edLmIn.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 929);
                        edFc.setText(String.valueOf(roundUp(result,4)));
                        result = (num + 0);
                        edPh.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 1000);
                        edMiph.setText(String.valueOf(roundUp(result,4)));
                        break;
                    case 6:
                        result = (num *10);
                        edLx.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.001);
                        edLmCm.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.929);
                        edLmFt.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.006452);
                        edLmIn.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.929);
                        edFc.setText(String.valueOf(roundUp(result,4)));
                        result = (num * 0.001);
                        edPh.setText(String.valueOf(roundUp(result,4)));
                        result = (num + 0);
                        edMiph.setText(String.valueOf(roundUp(result,4)));
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

            edLx.setText("");
            edLmCm.setText("");
            edLmFt.setText("");
            edLmIn.setText("");
            edFc.setText("");
            edPh.setText("");
            edMiph.setText("");
            return;
        }

        num = Double.parseDouble(edNum.getText().toString());

        switch (a){
            case 0:
                result = (num + 0);
                edLx.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.0001);
                edLmCm.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.0929);
                edLmFt.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.0006451);
                edLmIn.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.0929);
                edFc.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.0001);
                edPh.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.1);
                edMiph.setText(String.valueOf(roundUp(result,4)));

                break;
            case 1:
                result = (num *10000);
                edLx.setText(String.valueOf(roundUp(result,4)));
                result = (num + 0);
                edLmCm.setText(String.valueOf(roundUp(result,4)));
                result = (num * 929);
                edLmFt.setText(String.valueOf(roundUp(result,4)));
                result = (num * 6.452);
                edLmIn.setText(String.valueOf(roundUp(result,4)));
                result = (num * 929);
                edFc.setText(String.valueOf(roundUp(result,4)));
                result = (num * 1);
                edPh.setText(String.valueOf(roundUp(result,4)));
                result = (num * 1000);
                edMiph.setText(String.valueOf(roundUp(result,4)));
                break;

            case 2:
                result = (num *10.76);
                edLx.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.001076);
                edLmCm.setText(String.valueOf(roundUp(result,4)));
                result = (num + 0);
                edLmFt.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.006944);
                edLmIn.setText(String.valueOf(roundUp(result,4)));
                result = (num * 1);
                edFc.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.001076);
                edPh.setText(String.valueOf(roundUp(result,4)));
                result = (num * 1.076);
                edMiph.setText(String.valueOf(roundUp(result,4)));
                break;
            case 3:
                result = (num *1550);
                edLx.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.155);
                edLmCm.setText(String.valueOf(roundUp(result,4)));
                result = (num * 144);
                edLmFt.setText(String.valueOf(roundUp(result,4)));
                result = (num + 0);
                edLmIn.setText(String.valueOf(roundUp(result,4)));
                result = (num * 144);
                edFc.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.155);
                edPh.setText(String.valueOf(roundUp(result,4)));
                result = (num * 155);
                edMiph.setText(String.valueOf(roundUp(result,4)));
                break;
            case 4:

                result = (num *10.76);
                edLx.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.001076);
                edLmCm.setText(String.valueOf(roundUp(result,4)));
                result = (num * 1);
                edLmFt.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.006944);
                edLmIn.setText(String.valueOf(roundUp(result,4)));
                result = (num + 0);
                edFc.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.001076);
                edPh.setText(String.valueOf(roundUp(result,4)));
                result = (num * 1.076);
                edMiph.setText(String.valueOf(roundUp(result,4)));
                break;
            case 5:
                result = (num *10000);
                edLx.setText(String.valueOf(roundUp(result,4)));
                result = (num * 1);
                edLmCm.setText(String.valueOf(roundUp(result,4)));
                result = (num * 929);
                edLmFt.setText(String.valueOf(roundUp(result,4)));
                result = (num * 6.452);
                edLmIn.setText(String.valueOf(roundUp(result,4)));
                result = (num * 929);
                edFc.setText(String.valueOf(roundUp(result,4)));
                result = (num + 0);
                edPh.setText(String.valueOf(roundUp(result,4)));
                result = (num * 1000);
                edMiph.setText(String.valueOf(roundUp(result,4)));
                break;
            case 6:
                result = (num *10);
                edLx.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.001);
                edLmCm.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.929);
                edLmFt.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.006452);
                edLmIn.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.929);
                edFc.setText(String.valueOf(roundUp(result,4)));
                result = (num * 0.001);
                edPh.setText(String.valueOf(roundUp(result,4)));
                result = (num + 0);
                edMiph.setText(String.valueOf(roundUp(result,4)));
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

