package com.piotrdevelop.unityconverter;

import android.content.SharedPreferences;
import android.os.Build;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class ObyvKidsSize extends AppCompatActivity {

    String[] data = {"10,5cm", "11cm", "11,5cm","12cm","12,5cm", "13cm", "13,5cm","14cm","14,5cm", "15cm", "15.5cm","16cm","16,5cm", "17cm", "17,5cm","18cm","18,5cm","19cm","19,5cm","20cm","20,5cm","21cm","21.5cm","22cm","22,5cm","23cm","23,5cm","24cm"};
    int a;
    Spinner spMassa;
    EditText edKidsGroup,edKidsShoesSize;
   // TextView ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.obyv_kids_size);

        Toolbar my_toolbar = (Toolbar) findViewById(R.id.my_toolbar_app);
        LinearLayout LoyoutMainProc = (LinearLayout) findViewById(R.id.LoyoutMainObuvKids);
        RelativeLayout backColorlayoutAds = (RelativeLayout) findViewById(R.id.reLayoutShoesKidsAds);
        CollapsingToolbarLayout bottomColorLayout = (CollapsingToolbarLayout) findViewById(R.id.ShoesKidsBottomLayout);
        CoordinatorLayout corLoyDlinna = (CoordinatorLayout) findViewById(R.id.corLoyoutShoesKids);
        setSupportActionBar(my_toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, data);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spMassa = (Spinner) findViewById(R.id.spMassa);
        spMassa.setAdapter(adapter);

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        TextView Nm = (TextView) findViewById(R.id.KidsGroup);
        TextView Km = (TextView) findViewById(R.id.KidsShoesSize);


        edKidsGroup = (EditText) findViewById(R.id.edKidsGroup);
        edKidsShoesSize = (EditText) findViewById(R.id.edKidsShoesSize);

        if (getColor() != getResources().getColor(R.color.colorPrimary)) {

            my_toolbar.setBackgroundColor(getBackgroundColor());
            backColorlayoutAds.setBackgroundColor(getColor());
            bottomColorLayout.setBackgroundColor(getColor());
            corLoyDlinna.setBackgroundColor(getBackgroundColor());
            LoyoutMainProc.setBackgroundColor(getHalfBackgroundColor());

            Nm.setTextColor(getTextColor());
            Km.setTextColor(getTextColor());



            edKidsGroup.setBackgroundColor(getEditTextActivityColor());
            edKidsGroup.setTextColor(getEditTextColor());
            edKidsShoesSize.setBackgroundColor(getEditTextActivityColor());
            edKidsShoesSize.setTextColor(getEditTextColor());
            spMassa.setBackgroundColor(getEditTextActivityColor());



            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                getWindow().setStatusBarColor(getColor());
            }
        }

        spMassa.setSelection(0);
        spMassa.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {


            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


                switch (position) {
                    case 0:
                        edKidsShoesSize.setText("17");
                        edKidsGroup.setText(R.string.pinetki);
                        break;
                    case 1:
                        edKidsShoesSize.setText("18");
                        edKidsGroup.setText(R.string.pinetki);
                        break;
                    case 2:
                        edKidsShoesSize.setText("19");
                        edKidsGroup.setText(R.string.pinetki);
                        break;
                    case 3:
                        edKidsShoesSize.setText("19.5");
                        edKidsGroup.setText(R.string.pinetki);
                        break;
                    case 4:
                        edKidsShoesSize.setText("20");
                        edKidsGroup.setText(R.string.pinetki);
                        break;
                    case 5:
                        edKidsShoesSize.setText("20.5");
                        edKidsGroup.setText(R.string.pinetki);
                        break;
                    case 6:
                        edKidsShoesSize.setText("21");
                        edKidsGroup.setText(R.string.yasli);
                        break;
                    case 7:
                        edKidsShoesSize.setText("22");
                        edKidsGroup.setText(R.string.yasli);
                        break;
                    case 8:
                        edKidsShoesSize.setText("22.5");
                        edKidsGroup.setText(R.string.yasli);
                        break;
                    case 9:
                        edKidsShoesSize.setText("23");
                        edKidsGroup.setText(R.string.malodetski);
                        break;
                    case 10:
                        edKidsShoesSize.setText("24");
                        edKidsGroup.setText(R.string.malodetski);
                        break;
                    case 11:
                        edKidsShoesSize.setText("25");
                        edKidsGroup.setText(R.string.malodetski);
                        break;
                    case 12:
                        edKidsShoesSize.setText("25.5");
                        edKidsGroup.setText(R.string.malodetski);
                        break;
                    case 13:
                        edKidsShoesSize.setText("26");
                        edKidsGroup.setText(R.string.malodetski);
                        break;
                    case 14:
                        edKidsShoesSize.setText("27");
                        edKidsGroup.setText(R.string.doskool);
                        break;
                    case 15:
                        edKidsShoesSize.setText("28");
                        edKidsGroup.setText(R.string.doskool);
                        break;
                    case 16:
                        edKidsShoesSize.setText("28.5");
                        edKidsGroup.setText(R.string.doskool);
                        break;
                    case 17:
                        edKidsShoesSize.setText("29");
                        edKidsGroup.setText(R.string.doskool);
                        break;
                    case 18:
                        edKidsShoesSize.setText("30");
                        edKidsGroup.setText(R.string.doskool);
                        break;
                    case 19:
                        edKidsShoesSize.setText("31");
                        edKidsGroup.setText(R.string.doskool);
                        break;
                    case 20:
                        edKidsShoesSize.setText("31.5");
                        edKidsGroup.setText(R.string.doskool);
                        break;
                    case 21:
                        edKidsShoesSize.setText("32");
                        edKidsGroup.setText(R.string.skool);
                        break;
                    case 22:
                        edKidsShoesSize.setText("33");
                        edKidsGroup.setText(R.string.skool);
                        break;
                    case 23:
                        edKidsShoesSize.setText("34");
                        edKidsGroup.setText(R.string.skool);
                        break;
                    case 24:
                        edKidsShoesSize.setText("34.5");
                        edKidsGroup.setText(R.string.skool);
                        break;
                    case 25:
                        edKidsShoesSize.setText("35");
                        edKidsGroup.setText(R.string.skool);
                        break;
                    case 26:
                        edKidsShoesSize.setText("36");
                        edKidsGroup.setText(R.string.skool);
                        break;
                    case 27:
                        edKidsShoesSize.setText("37");
                        edKidsGroup.setText(R.string.skool);
                        break;
                    case 28:
                        edKidsShoesSize.setText("37.5");
                        edKidsGroup.setText(R.string.skool);
                        break;


                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

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

    private int getHalfBackgroundColor(){
        SharedPreferences mSharedPref = getSharedPreferences("ThemeColor", MODE_PRIVATE);
        int selectedBackColor = mSharedPref.getInt("backcolor", getResources().getColor(R.color.dark_backgroundHalfColor));
        return selectedBackColor;
    }
}
