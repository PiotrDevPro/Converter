package com.piotrdevelop.unityconverter;


import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Build;

import com.google.android.material.appbar.CollapsingToolbarLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.navigation.NavigationView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;


public class MainActivity extends AppCompatActivity implements View.OnClickListener,NavigationView.OnNavigationItemSelectedListener

{


    Button btnDlinna, btnMassa, btnObiem, btnPloshad, btnRasxod, btnSpeed, btnTemp, btnHz, btnDavl, btnInfo, btnYgol, btnEnergy, btnKrut, btnPerc, btnObuv, btnSvet, btnTime, btnRad, btnKod, btnPlot, btnSila, btnProc, btnSkidki, btnBiz, btnStream, btnPower;
    TextView tvbase, tvEng, tveng2;
    Toolbar toolbar;
    CollapsingToolbarLayout bottomToolbar;
    CoordinatorLayout mLayout;
    Button btnClose;
    DrawerLayout drawer;
    NavigationView navView;
    Intent shareIntent;



    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);


        bottomToolbar = (CollapsingToolbarLayout) findViewById(R.id.mainBottomLayout);
        mLayout = (CoordinatorLayout) findViewById(R.id.mainMenuLayout);
        toolbar = (Toolbar) findViewById(R.id.my_toolbar_app);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.mainDrawable);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
               this, drawer, toolbar, R.string.navigation_drawer_opem, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();


        navView = (NavigationView) findViewById(R.id.new_view);
        navView.setNavigationItemSelectedListener(this);

        Typeface myTypeface = Typeface.createFromAsset(getAssets(), "HelveticaNeueCyr-Light.otf");
        Typeface myTypeface2 = Typeface.createFromAsset(getAssets(), "HelveticaNeueCyr-LightItalic.otf");


        btnDlinna = (Button) findViewById(R.id.btnDlinna);
        btnDlinna.setTypeface(myTypeface);
        btnMassa = (Button) findViewById(R.id.btnMassa);
        btnMassa.setTypeface(myTypeface);
        btnObiem = (Button) findViewById(R.id.btnObiem);
        btnObiem.setTypeface(myTypeface);
        btnRasxod = (Button) findViewById(R.id.btnRasxod);
        btnRasxod.setTypeface(myTypeface);
        btnPloshad = (Button) findViewById(R.id.btnPloshad);
        btnPloshad.setTypeface(myTypeface);
        btnSpeed = (Button) findViewById(R.id.btnSpeed);
        btnSpeed.setTypeface(myTypeface);
        btnTemp = (Button) findViewById(R.id.btnTemp);
        btnTemp.setTypeface(myTypeface);
        btnHz = (Button) findViewById(R.id.btnHz);
        btnHz.setTypeface(myTypeface);
        btnTemp = (Button) findViewById(R.id.btnTemp);
        btnTemp.setTypeface(myTypeface);
        btnDavl = (Button) findViewById(R.id.btnDavl);
        btnDavl.setTypeface(myTypeface);
        btnInfo = (Button) findViewById(R.id.btnInfo);
        btnInfo.setTypeface(myTypeface);
        btnYgol = (Button) findViewById(R.id.btnYgol);
        btnYgol.setTypeface(myTypeface);
        btnEnergy = (Button) findViewById(R.id.btnEnegry);
        btnEnergy.setTypeface(myTypeface);
        btnKrut = (Button) findViewById(R.id.btnKrut);
        btnKrut.setTypeface(myTypeface);
        btnPerc = (Button) findViewById(R.id.btnPerc);
        btnPerc.setTypeface(myTypeface);
        btnObuv = (Button) findViewById(R.id.btnObyv);
        btnObuv.setTypeface(myTypeface);
        btnSvet = (Button) findViewById(R.id.btnSvet);
        btnSvet.setTypeface(myTypeface);
        btnTime = (Button) findViewById(R.id.btnTime);
        btnTime.setTypeface(myTypeface);
        btnRad = (Button) findViewById(R.id.btnRad);
        btnRad.setTypeface(myTypeface);
        btnKod = (Button) findViewById(R.id.btnKod);
        btnKod.setTypeface(myTypeface);
        btnPlot = (Button) findViewById(R.id.btnPlot);
        btnPlot.setTypeface(myTypeface);
        btnSila = (Button) findViewById(R.id.btnSila);
        btnSila.setTypeface(myTypeface);
        btnProc = (Button) findViewById(R.id.btnProc);
        btnProc.setTypeface(myTypeface);
        btnSkidki = (Button) findViewById(R.id.btnSkidki);
        btnSkidki.setTypeface(myTypeface);
        btnClose = (Button) findViewById(R.id.btnClose);
        btnClose.setTypeface(myTypeface);
        btnBiz = (Button) findViewById(R.id.btnBiz);
        btnBiz.setTypeface(myTypeface);
        btnStream = (Button) findViewById(R.id.btnStream);
        btnStream.setTypeface(myTypeface);
        btnPower = (Button) findViewById(R.id.btnPower);
        btnPower.setTypeface(myTypeface);

        tvbase = (TextView) findViewById(R.id.tvbase);
        tvbase.setTypeface(myTypeface2);
        tvEng = (TextView) findViewById(R.id.tvEng);
        tvEng.setTypeface(myTypeface2);
        tveng2 = (TextView) findViewById(R.id.tveng2);
        tveng2.setTypeface(myTypeface2);


        btnDlinna.setOnClickListener(this);
        btnMassa.setOnClickListener(this);
        btnObiem.setOnClickListener(this);
        btnPloshad.setOnClickListener(this);
        btnRasxod.setOnClickListener(this);
        btnSpeed.setOnClickListener(this);
        btnTemp.setOnClickListener(this);
        btnHz.setOnClickListener(this);
        btnDavl.setOnClickListener(this);
        btnInfo.setOnClickListener(this);
        btnYgol.setOnClickListener(this);
        btnEnergy.setOnClickListener(this);
        btnKrut.setOnClickListener(this);
        btnPerc.setOnClickListener(this);
        btnObuv.setOnClickListener(this);
        btnSvet.setOnClickListener(this);
        btnTime.setOnClickListener(this);
        btnRad.setOnClickListener(this);
        btnKod.setOnClickListener(this);
        btnPlot.setOnClickListener(this);
        btnSila.setOnClickListener(this);
        btnProc.setOnClickListener(this);
        btnSkidki.setOnClickListener(this);
        btnClose.setOnClickListener(this);
        btnBiz.setOnClickListener(this);
        btnStream.setOnClickListener(this);
        btnPower.setOnClickListener(this);
        if (getColor() != getResources().getColor(R.color.colorPrimary)) {

            toolbar.setBackgroundColor(getColor());
            bottomToolbar.setBackgroundColor(getColor());
            mLayout.setBackgroundColor(getColor());

            mLayout.setBackgroundColor(getBackgroundColor());
            btnDlinna.setTextColor(getTextColor());
            btnDlinna.setBackgroundColor(getStrokeButtonColor());
            btnMassa.setTextColor(getTextColor());
            btnMassa.setBackgroundColor(getStrokeButtonColor());
            btnObiem.setTextColor(getTextColor());
            btnObiem.setBackgroundColor(getStrokeButtonColor());
            btnPloshad.setTextColor(getTextColor());
            btnPloshad.setBackgroundColor(getStrokeButtonColor());
            btnTemp.setTextColor(getTextColor());
            btnTemp.setBackgroundColor(getStrokeButtonColor());
            btnSpeed.setTextColor(getTextColor());
            btnSpeed.setBackgroundColor(getStrokeButtonColor());
            btnDavl.setTextColor(getTextColor());
            btnDavl.setBackgroundColor(getStrokeButtonColor());
            btnInfo.setTextColor(getTextColor());
            btnInfo.setBackgroundColor(getStrokeButtonColor());
            btnYgol.setTextColor(getTextColor());
            btnYgol.setBackgroundColor(getStrokeButtonColor());
            btnEnergy.setTextColor(getTextColor());
            btnEnergy.setBackgroundColor(getStrokeButtonColor());
            btnPlot.setTextColor(getTextColor());
            btnPlot.setBackgroundColor(getStrokeButtonColor());
            btnHz.setTextColor(getTextColor());
            btnHz.setBackgroundColor(getStrokeButtonColor());
            btnKrut.setTextColor(getTextColor());
            btnKrut.setBackgroundColor(getStrokeButtonColor());
            btnSila.setTextColor(getTextColor());
            btnSila.setBackgroundColor(getStrokeButtonColor());
            btnProc.setTextColor(getTextColor());
            btnProc.setBackgroundColor(getStrokeButtonColor());
            btnSvet.setTextColor(getTextColor());
            btnSvet.setBackgroundColor(getStrokeButtonColor());
            btnRad.setTextColor(getTextColor());
            btnRad.setBackgroundColor(getStrokeButtonColor());
            btnTime.setTextColor(getTextColor());
            btnTime.setBackgroundColor(getStrokeButtonColor());
            btnStream.setTextColor(getTextColor());
            btnStream.setBackgroundColor(getStrokeButtonColor());
            btnPower.setTextColor(getTextColor());
            btnPower.setBackgroundColor(getStrokeButtonColor());
            btnRasxod.setTextColor(getTextColor());
            btnRasxod.setBackgroundColor(getStrokeButtonColor());
            btnObuv.setTextColor(getTextColor());
            btnObuv.setBackgroundColor(getStrokeButtonColor());
            btnKod.setTextColor(getTextColor());
            btnKod.setBackgroundColor(getStrokeButtonColor());
            btnPerc.setTextColor(getTextColor());
            btnPerc.setBackgroundColor(getStrokeButtonColor());
            btnClose.setTextColor(getTextColor());
            btnClose.setBackgroundColor(getStrokeButtonColor());
            btnSkidki.setTextColor(getTextColor());
            btnSkidki.setBackgroundColor(getStrokeButtonColor());
            btnBiz.setTextColor(getTextColor());
            btnBiz.setBackgroundColor(getStrokeButtonColor());
            tvbase.setTextColor(getTextColor());
            tvEng.setTextColor(getTextColor());
            tveng2.setTextColor(getTextColor());

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                getWindow().setStatusBarColor(getColor());
            }

        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main_menu, menu);


        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        int id = item.getItemId();


        switch (item.getItemId()) {
            case R.id.menu1:
                openDialogTheme();
                break;
        }
        return super.onOptionsItemSelected(item);
    }



    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
   //  Handle navigation view item clicks here.
        int id = item.getItemId();

        switch (id){

        }

        if (id == R.id.nav_youtube) {

            Intent YI = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=ibqc0FFqnms&feature=youtu.be"));
            startActivity(YI);
//
//      } else if (id == R.id.nav_pro) {
//      } else if (id == R.id.nav_favorite) {
//      } else if (id == R.id.nav_manage) {

       } else if (id == R.id.nav_share) {


            shareIntent = new Intent(Intent.ACTION_SEND);
            shareIntent.setType("text/plain");
            shareIntent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.share_app_name));
            shareIntent.putExtra(Intent.EXTRA_TEXT, getString(R.string.share_text));
            startActivity(Intent.createChooser(shareIntent,"Share Via"));

        } else if (id == R.id.nav_send) {
            Intent intent=new Intent(Intent.ACTION_SEND);
            intent.setData(Uri.parse("mailto:"));
            String[] to={"proplaya7880281@gmail.com"};
            intent.putExtra(Intent.EXTRA_EMAIL, to);
            intent.putExtra(Intent.EXTRA_SUBJECT,getString(R.string.app_name));
            intent.putExtra(Intent.EXTRA_TEXT,"");
            intent.setType("text/plain");
            intent.setType("message/rfc822");
            Intent chooser = intent.createChooser(intent,"Send Email");
           startActivity(chooser);

        }
           DrawerLayout drawer = (DrawerLayout) findViewById(R.id.mainDrawable);
        drawer.closeDrawer(GravityCompat.START);
        return true;   }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btnDlinna:
                Intent intent = new Intent(this, DlinnaActivity.class);
                startActivity(intent);
                break;
            case R.id.btnMassa:
                Intent MI = new Intent(this, MassaActivity.class);
                startActivity(MI);
                break;
            case R.id.btnObiem:
                Intent OI = new Intent(this, ObiemActivity.class);
                startActivity(OI);
                break;
            case R.id.btnPloshad:
                Intent PI = new Intent(this, PloshadActivity.class);
                startActivity(PI);
                break;
            case R.id.btnRasxod:
                Intent RI = new Intent(this, RasxodActivity.class);
                startActivity(RI);
                break;
            case R.id.btnSpeed:
                Intent SI = new Intent(this, SpeedActivity.class);
                startActivity(SI);
                break;
            case R.id.btnTemp:
                Intent TI = new Intent(this, TempActivity.class);
                startActivity(TI);
                break;
            case R.id.btnHz:
                Intent HI = new Intent(this, HerzActivity.class);
                startActivity(HI);
                break;
            case R.id.btnDavl:
                Intent DI = new Intent(this, DavlActivity.class);
                startActivity(DI);
                break;
            case R.id.btnInfo:
                Intent II = new Intent(this, InfoActivity.class);
                startActivity(II);
                break;
            case R.id.btnYgol:
                Intent YI = new Intent(this, YgolActivity.class);
                startActivity(YI);
                break;
            case R.id.btnEnegry:
                Intent EI = new Intent(this, EnergyActivity.class);
                startActivity(EI);
                break;
            case R.id.btnKrut:
                Intent KI = new Intent(this, KrutActivity.class);
                startActivity(KI);
                break;
            case R.id.btnPerc:
                Intent PEI = new Intent(this, PercActivity.class);
                startActivity(PEI);
                break;
            case R.id.btnObyv:
                showOnClickCloseObuv();
                break;
            case R.id.btnSvet:
                Intent IS = new Intent(this, SvetActivity.class);
                startActivity(IS);
                break;
            case R.id.btnTime:
                Intent IT = new Intent(this, TimeActivity.class);
                startActivity(IT);
                break;
            case R.id.btnRad:
                Intent IR = new Intent(this, RadiationActivity.class);
                startActivity(IR);
                break;
            case R.id.btnKod:
                Intent IK = new Intent(this, KodActivity.class);
                startActivity(IK);
                break;
            case R.id.btnPlot:
                Intent IP = new Intent(this, PlotActivity.class);
                startActivity(IP);
                break;
            case R.id.btnSila:
                Intent ISI = new Intent(this, SilaActivity.class);
                startActivity(ISI);
                break;
            case R.id.btnProc:
                Intent IPR = new Intent(this, ProcentActivity.class);
                startActivity(IPR);
                break;
            case R.id.btnSkidki:
                Intent ISK = new Intent(this, SkidkiActivity.class);
                startActivity(ISK);
                break;

            case R.id.btnClose:

                showOnClickCloseDialog();

                break;
            case R.id.btnBiz:

                Intent IBIZ = new Intent(this, BizznessActivity.class);
                startActivity(IBIZ);

                break;

            case R.id.btnStream:

                Intent ISTR = new Intent(this, DataActivity.class);
                startActivity(ISTR);

                break;

            case R.id.btnPower:

                Intent IPOW = new Intent(this, PowerActivity.class);
                startActivity(IPOW);
                break;

        }

    }

    private void showOnClickCloseDialog() {


        final AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);


        dialogBuilder.setTitle(R.string.clothes_dialog);
        dialogBuilder.setIcon(R.drawable.man);
        AlertDialog.Builder setItems = dialogBuilder.setItems(getResources().getStringArray(R.array.clothes), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {


                switch (which) {

                    case 0:

                        Intent IMAN = new Intent(MainActivity.this, ManActivity.class);
                        startActivity(IMAN);

                        break;

                    case 1:

                        Intent IML = new Intent(MainActivity.this, ActivityManLow.class);
                        startActivity(IML);

                        break;


                    case 2:

                        Intent IW = new Intent(MainActivity.this, WomanActivity.class);
                        startActivity(IW);

                        break;

                    case 3:

                        Intent IWL = new Intent(MainActivity.this, ActivityWomanLow.class);
                        startActivity(IWL);

                        break;
                    case 4:
                        Intent IKS = new Intent(MainActivity.this, KidsActivity.class);
                        startActivity(IKS);
                        break;

                }

            }


        });


        dialogBuilder.setPositiveButton("OK", null);
        AlertDialog alertDialog = dialogBuilder.create();
        alertDialog.show();

    }


    private void showOnClickCloseObuv() {


        final AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);


        dialogBuilder.setTitle(R.string.obuv_dialog);
        dialogBuilder.setIcon(R.drawable.shoes1);
        AlertDialog.Builder setItems = dialogBuilder.setItems(getResources().getStringArray(R.array.shoes), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {


                switch (which) {

                    case 0:

                        Intent IO = new Intent(MainActivity.this, ObuvActivity.class);
                        startActivity(IO);

                        break;

                    case 1:

                        Intent IKS = new Intent(MainActivity.this, ObyvKidsSize.class);
                        startActivity(IKS);

                        break;


                }

            }


        });


        dialogBuilder.setPositiveButton("OK", null);
        AlertDialog alertDialog = dialogBuilder.create();
        alertDialog.show();

    }

    private void openDialogTheme() {

        final AlertDialog.Builder Dialog = new AlertDialog.Builder(this);
        Dialog.setTitle(R.string.Color_select);
        if (getColor() != getResources().getColor(R.color.colorPrimary)) {
            Dialog.setIcon(R.drawable.dark);

        } else{
            Dialog.setIcon(R.drawable.brown);
        }

        AlertDialog.Builder translateItem = Dialog.setItems(getResources().getStringArray(R.array.themeColorDialog), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                switch (which) {
                    case 0:

                        toolbar.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                            getWindow().setStatusBarColor(getResources().getColor(R.color.colorPrimary));
                        }
                        storeColor(getResources().getColor(R.color.colorPrimary));
                        restartapp();


                        break;
                    case 1:
                       // Dialog.setIcon(R.drawable.dark);
                        toolbar.setBackgroundColor(getResources().getColor(R.color.dark_colorPrimary));
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                            getWindow().setStatusBarColor(getResources().getColor(R.color.dark_colorPrimary));
                        }
                        storeColor(getResources().getColor(R.color.dark_colorPrimary));
                      //  Dialog.setIcon(R.drawable.dark);
                        restartapp();

                        break;
                }
            }
        });

        Dialog.setPositiveButton("OK", null);
        AlertDialog alertDialog = Dialog.create();
        alertDialog.show();
    }

    private void restartapp() {
        Intent i = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(i);
        finish();
    }

    private void storeColor(int color) {
        SharedPreferences mSharedPref = getSharedPreferences("ThemeColor", MODE_PRIVATE);
        SharedPreferences.Editor mEditor = mSharedPref.edit();
        mEditor.putInt("color", color);

        mEditor.apply();
    }

    private int getColor() {
        SharedPreferences mSharedPref = getSharedPreferences("ThemeColor", MODE_PRIVATE);
        int selectedColor = mSharedPref.getInt("color", getResources().getColor(R.color.colorPrimary));
        return selectedColor;
    }

    private int getBackgroundColor() {
        SharedPreferences mSharedPref = getSharedPreferences("ThemeColor", MODE_PRIVATE);
        int selectedBackColor = mSharedPref.getInt("backcolor", getResources().getColor(R.color.dark_backgroundColorFrmame));
        return selectedBackColor;
    }

    private int getTextColor() {

        SharedPreferences mSharedPref = getSharedPreferences("ThemeColor", MODE_PRIVATE);
        int textColor = mSharedPref.getInt("textColorMain", getResources().getColor(R.color.dark_textColorMainmenu));
        return  textColor;
    }

    private int getStrokeButtonColor(){

        SharedPreferences mSharedPref = getSharedPreferences("ThemeColor", MODE_PRIVATE);
        int buttonStrokeColor = mSharedPref.getInt("buttonColor", getResources().getColor(R.color.dark_buttonstroke));
        return  buttonStrokeColor;
    }


}



