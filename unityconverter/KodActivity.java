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
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;


import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class KodActivity extends AppCompatActivity {

   // String data[] = {"000-139 США","200-299 Внутренняя нумерация"," 300-379 Франция","380 Болгария","383 Словения","385 Хорватия","387 Босния-Герцеговина","400-440 Германия","450-459, 490-499 Япония","460-469 Россия","470 Кыргызстан","471 Тайвань","474 Эстония","475 Латвия","476 Азербайджан","477 Литва","478 Узбекистан","479 Шри-Ланка","480 Филиппины","481 Беларусь","482 Украина","484 Молдова","485 Армения","486 Грузия","487 Казахстан","489 Гонконг","500-509 Великобритания","520 Греция","528  Ливан","529  Кипр","530  Албания","531  Македония","535  Мальта","539  Ирландия","540-549  Бельгия, Люксембург","560  Португалия","569  Исландия","570-579  Дания","590  Польша","594  Румыния","599  Венгрия","600-601  Южная Африка","603  Гана","608  Бахрейн","609  Маврикий","611  Марокко","613  Алжир","616  Кения","518  Берег Слоновой Кости","619  Тунис","621  Сирия","622  Египет","624  Ливия","625  Иордания","626  Иран","627  Кувейт","628  Саудовская Аравия","629  О.А.Э","640-649  Финляндия","690-695  Китай","700-709  Норвегия","730-739  Швеция","740  Гватемала","741  Сальвадор","742  Гондурас","743  Никарагуа","744  Коста-Рика","745  Панама","746  Доминиканская республика","750  Мексика","754 - 755  Канада","759  Венесуэла","760-769  Швейцария","770  Колумбия","773  Уругвай","777  Боливия","779  Аргентина","780  Чили","784  Парагвай","786  Эквадор","789-790  Бразилия","800-839  Италия","840-849  Испания","850  Куба","858  Словакия","859  Чехия","860  Сербия и Черногория","865  Moнголия","867  Северная Корея","869  Турция","870-879  Нидерланды","880  Южная Корея","884  Камбоджа","885  Таиланд","888  Сингапур","890  Индия","893  Вьетнам","899  Индонезия","900-919  Австрия","930-939  Австралия","940-949  Новая Зеландия","950  Главный офис","955  Малайзия","958  Макао","978-979 Книги (ISBN)","980 Возвратные квитанции","981-982 Валютные купоны","990-999 Купоны"};
    Spinner spMassa;
    TextView edHeel;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kod);

        Toolbar my_toolbar = (Toolbar) findViewById(R.id.my_toolbar_app);
        RelativeLayout backColorlayoutAds = (RelativeLayout) findViewById(R.id.reLayoutKodlAds);
        CollapsingToolbarLayout bottomColorLayout = (CollapsingToolbarLayout) findViewById(R.id.KodBottomLayout);
        CoordinatorLayout corLoyDlinna = (CoordinatorLayout) findViewById(R.id.corLoyoutKod);
        setSupportActionBar(my_toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, //data);
                // adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                getResources().getStringArray(R.array.Code));

        spMassa = (Spinner) findViewById(R.id.spMassa);
        spMassa.setAdapter(adapter);

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        TextView Nm = (TextView) findViewById(R.id.barcode);
        TextView Km = (TextView) findViewById(R.id.kod_notice);


        edHeel = (TextView) findViewById(R.id.edHeel);

        if (getColor() != getResources().getColor(R.color.colorPrimary)) {

            my_toolbar.setBackgroundColor(getBackgroundColor());
            backColorlayoutAds.setBackgroundColor(getColor());
            bottomColorLayout.setBackgroundColor(getColor());
            corLoyDlinna.setBackgroundColor(getBackgroundColor());

            Nm.setTextColor(getTextColor());
            Km.setTextColor(getTextColor());


            edHeel.setBackgroundColor(getEditTextActivityColor());
            edHeel.setTextColor(getEditTextColor());
            spMassa.setBackgroundColor(getEditTextActivityColor());


            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                getWindow().setStatusBarColor(getColor());
            }
        }

        spMassa.setSelection(0);
        spMassa.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                String strPos = spMassa.getSelectedItem().toString();
                edHeel.setText(strPos);

                switch (position) {
                    case 0:
                        edHeel.setText(strPos);
                        break;
                    case 1:
                        edHeel.setText(strPos);
                        break;
                    case 2:
                        edHeel.setText(strPos);
                        break;
                    case 3:
                        edHeel.setText(strPos);
                        break;
                    case 4:
                        edHeel.setText(strPos);
                        break;
                    case 5:
                        edHeel.setText(strPos);
                        break;
                    case 6:
                        edHeel.setText(strPos);
                        break;
                    case 7:
                        edHeel.setText(strPos);
                        break;
                    case 8:
                        edHeel.setText(strPos);
                        break;
                    case 9:
                        edHeel.setText(strPos);
                        break;
                    case 10:
                        edHeel.setText(strPos);
                        break;
                    case 11:
                        edHeel.setText(strPos);
                        break;
                    case 12:
                        edHeel.setText(strPos);
                        break;
                    case 13:
                        edHeel.setText(strPos);
                        break;
                    case 14:
                        edHeel.setText(strPos);
                        break;
                    case 15:
                        edHeel.setText(strPos);
                        break;
                    case 16:
                        edHeel.setText(strPos);
                        break;
                    case 17:
                        edHeel.setText(strPos);
                        break;
                    case 18:
                        edHeel.setText(strPos);
                        break;
                    case 19:
                        edHeel.setText(strPos);
                        break;
                    case 20:
                        edHeel.setText(strPos);
                        break;
                    case 21:
                        edHeel.setText(strPos);
                        break;
                    case 22:
                        edHeel.setText(strPos);
                        break;
                    case 23:
                        edHeel.setText(strPos);
                        break;
                    case 24:
                        edHeel.setText(strPos);
                        break;
                    case 25:
                        edHeel.setText(strPos);
                        break;
                    case 26:
                        edHeel.setText(strPos);
                        break;
                    case 27:
                        edHeel.setText(strPos);
                        break;
                    case 28:
                        edHeel.setText(strPos);
                        break;
                    case 29:
                        edHeel.setText(strPos);
                        break;
                    case 30:
                        edHeel.setText(strPos);
                        break;
                    case 31:
                        edHeel.setText(strPos);
                        break;
                    case 32:
                        edHeel.setText(strPos);
                        break;
                    case 33:
                        edHeel.setText(strPos);
                        break;
                    case 34:
                        edHeel.setText(strPos);
                        break;
                    case 35:
                        edHeel.setText(strPos);
                        break;
                    case 36:
                        edHeel.setText(strPos);
                        break;
                    case 37:
                        edHeel.setText(strPos);
                        break;
                    case 38:
                        edHeel.setText(strPos);
                        break;
                    case 39:
                        edHeel.setText(strPos);
                        break;
                    case 40:
                        edHeel.setText(strPos);
                        break;
                    case 41:
                        edHeel.setText(strPos);
                        break;
                    case 42:
                        edHeel.setText(strPos);
                        break;
                    case 43:
                        edHeel.setText(strPos);
                        break;
                    case 44:
                        edHeel.setText(strPos);
                        break;
                    case 45:
                        edHeel.setText(strPos);
                        break;
                    case 46:
                        edHeel.setText(strPos);
                        break;
                    case 47:
                        edHeel.setText(strPos);
                        break;
                    case 48:
                        edHeel.setText(strPos);
                        break;
                    case 49:
                        edHeel.setText(strPos);
                        break;
                    case 50:
                        edHeel.setText(strPos);
                        break;
                    case 51:
                        edHeel.setText(strPos);
                        break;
                    case 52:
                        edHeel.setText(strPos);
                        break;
                    case 53:
                        edHeel.setText(strPos);
                        break;
                    case 54:
                        edHeel.setText(strPos);
                        break;
                    case 55:
                        edHeel.setText(strPos);
                        break;
                    case 56:
                        edHeel.setText(strPos);
                        break;
                    case 57:
                        edHeel.setText(strPos);
                        break;
                    case 58:
                        edHeel.setText(strPos);
                        break;
                    case 59:
                        edHeel.setText(strPos);
                        break;
                    case 60:
                        edHeel.setText(strPos);
                        break;
                    case 61:
                        edHeel.setText(strPos);
                        break;
                    case 62:
                        edHeel.setText(strPos);
                        break;
                    case 63:
                        edHeel.setText(strPos);
                        break;
                    case 64:
                        edHeel.setText(strPos);
                        break;
                    case 65:
                        edHeel.setText(strPos);
                        break;
                    case 66:
                        edHeel.setText(strPos);
                        break;
                    case 67:
                        edHeel.setText(strPos);
                        break;
                    case 68:
                        edHeel.setText(strPos);
                        break;
                    case 69:
                        edHeel.setText(strPos);
                        break;
                    case 70:
                        edHeel.setText(strPos);
                        break;
                    case 71:
                        edHeel.setText(strPos);
                        break;
                    case 72:
                        edHeel.setText(strPos);
                        break;
                    case 73:
                        edHeel.setText(strPos);
                        break;
                    case 74:
                        edHeel.setText(strPos);
                        break;
                    case 75:
                        edHeel.setText(strPos);
                        break;
                    case 76:
                        edHeel.setText(strPos);
                        break;
                    case 77:
                        edHeel.setText(strPos);
                        break;
                    case 78:
                        edHeel.setText(strPos);
                        break;
                    case 79:
                        edHeel.setText(strPos);
                        break;
                    case 80:
                        edHeel.setText(strPos);
                        break;
                    case 81:
                        edHeel.setText(strPos);
                        break;
                    case 82:
                        edHeel.setText(strPos);
                        break;
                    case 83:
                        edHeel.setText(strPos);
                        break;
                    case 84:
                        edHeel.setText(strPos);
                        break;
                    case 85:
                        edHeel.setText(strPos);
                        break;
                    case 86:
                        edHeel.setText(strPos);
                        break;
                    case 87:
                        edHeel.setText(strPos);
                        break;
                    case 88:
                        edHeel.setText(strPos);
                        break;
                    case 89:
                        edHeel.setText(strPos);
                        break;
                    case 90:
                        edHeel.setText(strPos);
                        break;
                    case 91:
                        edHeel.setText(strPos);
                        break;
                    case 92:
                        edHeel.setText(strPos);
                        break;
                    case 93:
                        edHeel.setText(strPos);
                        break;
                    case 94:
                        edHeel.setText(strPos);
                        break;
                    case 95:
                        edHeel.setText(strPos);
                        break;
                    case 96:
                        edHeel.setText(strPos);
                        break;
                    case 97:
                        edHeel.setText(strPos);
                        break;
                    case 98:
                        edHeel.setText(strPos);
                        break;
                    case 99:
                        edHeel.setText(strPos);
                        break;
                    case 100:
                        edHeel.setText(strPos);
                        break;
                    case 101:
                        edHeel.setText(strPos);
                        break;
                    case 102:
                        edHeel.setText(strPos);
                        break;
                    case 103:
                        edHeel.setText(strPos);
                        break;
                    case 104:
                        edHeel.setText(strPos);
                        break;
                    case 105:
                        edHeel.setText(strPos);
                        break;
                    case 106:
                        edHeel.setText(strPos);
                        break;
                    case 107:
                        edHeel.setText(strPos);
                        break;
                    case 108:
                        edHeel.setText(strPos);
                        break;
                    case 109:
                        edHeel.setText(strPos);
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


