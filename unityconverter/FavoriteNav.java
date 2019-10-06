package com.piotrdevelop.unityconverter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import com.piotrdevelop.unityconverter.Class.ExampleAdapter;
import com.piotrdevelop.unityconverter.Class.ExampleItem;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class FavoriteNav extends AppCompatActivity {

    ArrayList<ExampleItem> mmExampleList;
    private RecyclerView mmRecyclerView;
    private ExampleAdapter mAdapter;
    private RecyclerView.LayoutManager mmLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2_test);

        loadData();
        buildRecyclerView();
        setInsertButton();
        setInsertIntent();


    }

    public void saveData() {
        SharedPreferences sharedPreferences = getSharedPreferences("shared preferences", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(mmExampleList);
        editor.putString("task list", json);
        editor.apply();
    }

    public void loadData() {
        SharedPreferences sharedPreferences = getSharedPreferences("shared preferences", MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("task list", null);
        Type type = new TypeToken<ArrayList<ExampleItem>>() {}.getType();
        mmExampleList = gson.fromJson(json, type);

        if (mmExampleList == null) {
            mmExampleList = new ArrayList<>();
        }
    }

    private void buildRecyclerView() {
        mmRecyclerView = findViewById(R.id.rv1);
        mmRecyclerView.setHasFixedSize(true);
        mmLayoutManager = new LinearLayoutManager(this);
        mAdapter = new ExampleAdapter(mmExampleList);

        mmRecyclerView.setLayoutManager(mmLayoutManager);
        mmRecyclerView.setAdapter(mAdapter);

        mAdapter.setOnItemClickListener(new ExampleAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                //changeItem(position, "Clicked");
                changeIntent(position);
            }

            @Override
            public void onDeleteClick(int position) {
                removeItem(position);
                saveData();
            }
        });
    }

    private void setInsertButton() {
        Button buttonInsert = findViewById(R.id.btn_in);
        buttonInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText line1 = findViewById(R.id.edittext_line1);
                EditText line2 = findViewById(R.id.edittext_line2);
               // TextView line3 = findViewById(R.id.labelApp);
               // insertItem(line1.getText().toString(), line2.getText().toString());
                insertItem(line1.getText().toString(), line2.getText().toString());// line3.getText().toString());
            }
        });
    }

    private  void  setInsertIntent(){
        Button buttonAdd = findViewById(R.id.btn_add);
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              //  Intent intent = new Intent(FavoriteNav.this, DavlActivity.class);
              //  TextView line1 = findViewById()
              // insertItem(intent.getDataString().toString(),intent.getDataString().toString());
            }
        });
    }

    private void insertItem(String line1, String line2){// String line3) {
        mmExampleList.add(new ExampleItem(line1, line2)); //line3));
        mAdapter.notifyItemInserted(mmExampleList.size());
        saveData();
    }

    private void removeItem(int position){

        mmExampleList.remove(position);
        mAdapter.notifyItemRemoved(position);
    }


    private  void changeItem(int position, String text){
        mmExampleList.get(position).changeText1(text);
        mAdapter.notifyItemChanged(position);
    }

    private void changeIntent(int position){
        mmExampleList.get(position);
        Intent intent = new Intent(this,DavlActivity.class);
        startActivity(intent);
    }

  //  private void insertItem(int position){
      //  mmExampleList.add(new );

   // }

}

