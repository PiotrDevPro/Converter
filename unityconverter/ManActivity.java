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
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class ManActivity extends AppCompatActivity {

    String[] data = {"162-166","164-168","166-170","168-173","171-176","174-179","180-184","179-180","182-186","184-188","185-189","187-191","189-193","191-194","192-196","194-198","196-200","198-202","200-203","201-204","203-206","204-207"};
    EditText edSizeEuTop,RSizeTop,Chest,Waist,Length,Grow,TopUkSize,TopUsSize,TopItSize;
    Spinner spMassa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.man);

        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        Toolbar my_toolbar = (Toolbar) findViewById(R.id.my_toolbar_app);
        RelativeLayout backColorlayoutAds = (RelativeLayout) findViewById(R.id.reLayoutClothesAds);
        CollapsingToolbarLayout bottomColorLayout = (CollapsingToolbarLayout) findViewById(R.id.ClothesBottomLayout);
        CoordinatorLayout corLoyDlinna = (CoordinatorLayout) findViewById(R.id.corLoyoutClothes);
        setSupportActionBar(my_toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, data);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spMassa = (Spinner)findViewById(R.id.spMassa);
        spMassa.setAdapter(adapter);

        TextView Nm = (TextView) findViewById(R.id.SizeEuTop);
        TextView Km = (TextView) findViewById(R.id.SizeTop);
        TextView Mile = (TextView) findViewById(R.id.tChest);
        TextView m = (TextView) findViewById(R.id.tWaist);
        TextView yard = (TextView)  findViewById(R.id.tLength);

        
        TextView grow = (TextView) findViewById(R.id.tGrow);
        TextView uksize = (TextView) findViewById(R.id.tTopUkSize);
        TextView ussize = (TextView) findViewById(R.id.tTopUsSize);
        TextView itsize = (TextView)  findViewById(R.id.tTopItSize);

        edSizeEuTop = (EditText) findViewById(R.id.edSizeEuTop);
        RSizeTop = (EditText) findViewById(R.id.RSizeTop);
        Chest = (EditText) findViewById(R.id.Chest);
        Waist = (EditText) findViewById(R.id.Waist);
        Length = (EditText) findViewById(R.id.Length);
        Grow = (EditText) findViewById(R.id.Grow);
        TopUkSize = (EditText) findViewById(R.id.TopUkSize);
        TopUsSize = (EditText) findViewById(R.id.TopUsSize);
        TopItSize = (EditText) findViewById(R.id.TopItSize);

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
            grow.setTextColor(getTextColor());
            uksize.setTextColor(getTextColor());
            ussize.setTextColor(getTextColor());
            itsize.setTextColor(getTextColor());



            edSizeEuTop.setBackgroundColor(getEditTextActivityColor());
            edSizeEuTop.setTextColor(getEditTextColor());
            RSizeTop.setBackgroundColor(getEditTextActivityColor());
            RSizeTop.setTextColor(getEditTextColor());
            Chest.setBackgroundColor(getEditTextActivityColor());
            Chest.setTextColor(getEditTextColor());
            Waist.setBackgroundColor(getEditTextActivityColor());
            Waist.setTextColor(getEditTextColor());
            Length.setBackgroundColor(getEditTextActivityColor());
            Length.setTextColor(getEditTextColor());
            Grow.setBackgroundColor(getEditTextActivityColor());
          //  Grow.setTextColor(getEditTextColor());
            TopUkSize.setBackgroundColor(getEditTextActivityColor());
            TopUkSize.setTextColor(getEditTextColor());
            TopUsSize.setBackgroundColor(getEditTextActivityColor());
            TopUsSize.setTextColor(getEditTextColor());
            TopItSize.setBackgroundColor(getEditTextActivityColor());
            TopItSize.setTextColor(getEditTextColor());


            spMassa.setBackgroundColor(getEditTextActivityColor());



            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                getWindow().setStatusBarColor(getColor());
            }
        }

        spMassa.setSelection(0);
        spMassa.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                String strMRost = spMassa.getSelectedItem().toString();

                switch (position){
                    case 0:
                        edSizeEuTop.setText("XXS");
                        RSizeTop.setText("42");
                        Chest.setText("84-85"+"см");
                        Waist.setText("70-73"+"см");
                        Length.setText("98-100"+"cм");
                        Grow.setText(strMRost+"см");
                        TopUkSize.setText("30");
                        TopUsSize.setText("32");
                        TopItSize.setText("40");
                        break;
                    case 1:
                        edSizeEuTop.setText("XXS");
                        RSizeTop.setText("43");
                        Chest.setText("84-87"+"см");
                        Waist.setText("72-75"+"см");
                        Length.setText("99-101"+"cм");
                        Grow.setText(strMRost+"см");
                        TopUkSize.setText("31");
                        TopUsSize.setText("33");
                        TopItSize.setText("41");
                        break;
                    case 2:
                        edSizeEuTop.setText("XXS");
                        RSizeTop.setText("44");
                        Chest.setText("86-89"+"см");
                        Waist.setText("74-77"+"см");
                        Length.setText("100-103"+"cм");
                        Grow.setText(strMRost+"см");
                        TopUkSize.setText("32");
                        TopUsSize.setText("34");
                        TopItSize.setText("42");
                        break;
                    case 3:
                        edSizeEuTop.setText("XS");
                        RSizeTop.setText("46");
                        Chest.setText("90-93"+"см");
                        Waist.setText("78-81"+"см");
                        Length.setText("102-104"+"cм");
                        Grow.setText(strMRost+"см");
                        TopUkSize.setText("34");
                        TopUsSize.setText("36");
                        TopItSize.setText("44");
                        break;
                    case 4:
                        edSizeEuTop.setText("S");
                        RSizeTop.setText("48");
                        Chest.setText("94-97"+"см");
                        Waist.setText("82-85"+"см");
                        Length.setText("103-106"+"cм");
                        Grow.setText(strMRost+"см");
                        TopUkSize.setText("36");
                        TopUsSize.setText("38");
                        TopItSize.setText("46");
                        break;
                    case 5:
                        edSizeEuTop.setText("M");
                        RSizeTop.setText("50");
                        Chest.setText("98-101"+"см");
                        Waist.setText("86-89"+"см");
                        Length.setText("105-108"+"cм");
                        Grow.setText(strMRost+"см");
                        TopUkSize.setText("38");
                        TopUsSize.setText("40");
                        TopItSize.setText("48");
                        break;
                    case 6:
                        edSizeEuTop.setText("L");
                        RSizeTop.setText("52");
                        Chest.setText("102-105"+"см");
                        Waist.setText("90-94"+"см");
                        Length.setText("107-109"+"cм");
                        Grow.setText(strMRost+"см");
                        TopUkSize.setText("40");
                        TopUsSize.setText("42");
                        TopItSize.setText("50");
                        break;
                    case 7:
                        edSizeEuTop.setText("XL");
                        RSizeTop.setText("54");
                        Chest.setText("106-109"+"см");
                        Waist.setText("95-99"+"см");
                        Length.setText("108-110"+"cм");
                        Grow.setText(strMRost+"см");
                        TopUkSize.setText("42");
                        TopUsSize.setText("44");
                        TopItSize.setText("52");
                        break;
                    case 8:
                        edSizeEuTop.setText("XXL");
                        RSizeTop.setText("56");
                        Chest.setText("110-113"+"см");
                        Waist.setText("100-104"+"см");
                        Length.setText("109-112"+"cм");
                        Grow.setText(strMRost+"см");
                        TopUkSize.setText("44");
                        TopUsSize.setText("46");
                        TopItSize.setText("54");
                        break;
                    case 9:
                        edSizeEuTop.setText("XXXL");
                        RSizeTop.setText("58");
                        Chest.setText("114-117"+"см");
                        Waist.setText("105-109"+"см");
                        Length.setText("111-114"+"cм");
                        Grow.setText(strMRost+"см");
                        TopUkSize.setText("46");
                        TopUsSize.setText("48");
                        TopItSize.setText("56");
                        break;
                    case 10:
                        edSizeEuTop.setText("XXXL");
                        RSizeTop.setText("60");
                        Chest.setText("118-121"+"см");
                        Waist.setText("110-114"+"см");
                        Length.setText("112-115"+"cм");
                        Grow.setText(strMRost+"см");
                        TopUkSize.setText("48");
                        TopUsSize.setText("50");
                        TopItSize.setText("58");
                        break;
                    case 11:
                        edSizeEuTop.setText("XXXL");
                        RSizeTop.setText("62");
                        Chest.setText("122-125"+"см");
                        Waist.setText("115-119"+"см");
                        Length.setText("114-116"+"cм");
                        Grow.setText(strMRost+"см");
                        TopUkSize.setText("50");
                        TopUsSize.setText("52");
                        TopItSize.setText("60");
                        break;
                    case 12:
                        edSizeEuTop.setText("4XL");
                        RSizeTop.setText("64");
                        Chest.setText("126-129"+"см");
                        Waist.setText("120-124"+"см");
                        Length.setText("115-117"+"cм");
                        Grow.setText(strMRost+"см");
                        TopUkSize.setText("52");
                        TopUsSize.setText("54");
                        TopItSize.setText("62");
                        break;
                    case 13:
                        edSizeEuTop.setText("4XL");
                        RSizeTop.setText("66");
                        Chest.setText("130-133"+"см");
                        Waist.setText("125-129"+"см");
                        Length.setText("116-118"+"cм");
                        Grow.setText(strMRost+"см");
                        TopUkSize.setText("54");
                        TopUsSize.setText("60");
                        TopItSize.setText("64");
                        break;
                    case 14:
                        edSizeEuTop.setText("5XL");
                        RSizeTop.setText("68");
                        Chest.setText("134-137"+"см");
                        Waist.setText("130-134"+"см");
                        Length.setText("117-119"+"cм");
                        Grow.setText(strMRost+"см");
                        TopUkSize.setText("60");
                        TopUsSize.setText("62");
                        TopItSize.setText("66");
                        break;
                    case 15:
                        edSizeEuTop.setText("5XL");
                        RSizeTop.setText("70");
                        Chest.setText("138-141"+"см");
                        Waist.setText("135-139"+"см");
                        Length.setText("118-120"+"cм");
                        Grow.setText(strMRost+"см");
                        TopUkSize.setText("62");
                        TopUsSize.setText("64");
                        TopItSize.setText("68");
                        break;
                    case 16:
                        edSizeEuTop.setText("-");
                        RSizeTop.setText("72");
                        Chest.setText("142-145"+"см");
                        Waist.setText("140-144"+"см");
                        Length.setText("119-121"+"cм");
                        Grow.setText(strMRost+"см");
                        TopUkSize.setText("64");
                        TopUsSize.setText("66");
                        TopItSize.setText("70");
                        break;
                    case 17:
                        edSizeEuTop.setText("-");
                        RSizeTop.setText("74");
                        Chest.setText("146-149"+"см");
                        Waist.setText("145-149"+"см");
                        Length.setText("120-122"+"cм");
                        Grow.setText(strMRost+"см");
                        TopUkSize.setText("66");
                        TopUsSize.setText("68");
                        TopItSize.setText("72");
                        break;
                    case 18:
                        edSizeEuTop.setText("-");
                        RSizeTop.setText("76");
                        Chest.setText("150-153"+"см");
                        Waist.setText("150-154"+"см");
                        Length.setText("121-123"+"cм");
                        Grow.setText(strMRost+"см");
                        TopUkSize.setText("68");
                        TopUsSize.setText("70");
                        TopItSize.setText("74");
                        break;
                    case 19:
                        edSizeEuTop.setText("-");
                        RSizeTop.setText("78");
                        Chest.setText("154-157"+"см");
                        Waist.setText("155-159"+"см");
                        Length.setText("121-124"+"cм");
                        Grow.setText(strMRost+"см");
                        TopUkSize.setText("70");
                        TopUsSize.setText("72");
                        TopItSize.setText("76");
                        break;
                    case 20:
                        edSizeEuTop.setText("-");
                        RSizeTop.setText("80");
                        Chest.setText("158-161"+"см");
                        Waist.setText("160-164"+"см");
                        Length.setText("122-125"+"cм");
                        Grow.setText(strMRost+"см");
                        TopUkSize.setText("72");
                        TopUsSize.setText("74");
                        TopItSize.setText("78");
                        break;
                    case 21:
                        edSizeEuTop.setText("-");
                        RSizeTop.setText("82");
                        Chest.setText("162-165"+"см");
                        Waist.setText("165-169"+"см");
                        Length.setText("123-126"+"cм");
                        Grow.setText(strMRost+"см");
                        TopUkSize.setText("74");
                        TopUsSize.setText("76");
                        TopItSize.setText("80");
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

}
