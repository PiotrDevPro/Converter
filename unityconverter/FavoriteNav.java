package com.piotrdevelop.unityconverter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


import com.piotrdevelop.unityconverter.Class.FavoriteAdapter;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.lang.reflect.Type;

public class FavoriteNav extends AppCompatActivity {

    //   ArrayList<FavoriteItem> mFavoriteList;
  // private RecyclerView rv_favorite;
   private FavoriteAdapter favoriteAdapter;
    SharedPreferences shared;

    //   public FavoriteAdapter mAdapter;
    //  public RecyclerView.LayoutManager mLayoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.favorite);


     //   rv_favorite = findViewById(R.id.recyclerView);


       // LinearLayoutManager layoutManager = new LinearLayoutManager(this);
      //  rv_favorite.setLayoutManager(layoutManager);

      //  rv_favorite.setHasFixedSize(true);

      //  favoriteAdapter = new FavoriteAdapter(100,this);
     //   rv_favorite.setAdapter(favoriteAdapter);

        // SharedPreferences result = getSharedPreferences("Shared_Pref", Context.MODE_PRIVATE);

        //  String value = result.getString("Value","Data not found");
        //  tv.setText(value);
        Toolbar my_toolbar = (Toolbar) findViewById(R.id.my_toolbar_app);
        setSupportActionBar(my_toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        if (getColor() != getResources().getColor(R.color.colorPrimary)) {

            my_toolbar.setBackgroundColor(getBackgroundColor());

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                getWindow().setStatusBarColor(getColor());

            }


        }

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
