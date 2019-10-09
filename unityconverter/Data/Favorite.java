package com.piotrdevelop.unityconverter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Favorite extends AppCompatActivity {
    private SQLiteDatabase mDatabase;
    private FavoriteAdapter mAdapter;
    private EditText mEditTextName;
    private TextView mTextViewAmount;
    private int mAmount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.favorite_layout);

        FavoriteDBHelper dbHelper = new FavoriteDBHelper(this);
        mDatabase = dbHelper.getWritableDatabase();

        RecyclerView recyclerView = findViewById(R.id.recyclerView_fav);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new FavoriteAdapter(this, getAllItems());
        recyclerView.setAdapter(mAdapter);

        mEditTextName = findViewById(R.id.ed1_fav);
        mTextViewAmount = findViewById(R.id.tx_fav);

       // Button buttonGo = findViewById(R.id.go_activity);
        Button buttonIncrease = findViewById(R.id.btn_plus);
        Button buttonDecrease = findViewById(R.id.btn_minus);
        Button buttonAdd = findViewById(R.id.btn_add);

        buttonIncrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                increase();
            }
        });

        buttonDecrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                decrease();
            }
        });

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addItem();
            }
        });
    //    buttonGo.setOnClickListener(new View.OnClickListener() {
        //    @Override
       //     public void onClick(View v) {
        //        Intent go = new Intent(MainActivity.this,Favorite.class);
         //       startActivity(go);
     //       }
    //    });

    }

    private void increase() {
        mAmount++;
        mTextViewAmount.setText(String.valueOf(mAmount));
    }

    private void decrease() {
        if (mAmount > 0) {
            mAmount--;
            mTextViewAmount.setText(String.valueOf(mAmount));
        }
    }

    private void addItem() {

        if (mEditTextName.getText().toString().trim().length() == 0 || mAmount == 0) {
            return;
        }
      //  mEditTextName.setText(getResources().getString(R.string.app_name));
      // String name = getResources().getString(R.string.app_name);
        String name = mEditTextName.getText().toString();
        ContentValues cv = new ContentValues();
        cv.put(Contract.FavoriteEntry.COLUMN_NAME, name);
        cv.put(Contract.FavoriteEntry.COLUMN_AMOUNT, mAmount);

        mDatabase.insert(Contract.FavoriteEntry.TABLE_NAME, null, cv);
        mAdapter.swapCursor(getAllItems());

        mEditTextName.getText().clear();
    }

    private Cursor getAllItems() {
        return mDatabase.query(
                Contract.FavoriteEntry.TABLE_NAME,
                null,
                null,
                null,
                null,
                null,
                Contract.FavoriteEntry.COLUMN_TIMESTAMP + " DESC"
        );
    }

}

