package com.piotrdevelop.unityconverter.Unused;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import android.view.Menu;

import com.piotrdevelop.unityconverter.R;


public class SearchResultActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_result);



/*        Toolbar resToolbar = (Toolbar)findViewById(R.id.resToolbar);
        setSupportActionBar(resToolbar);
        getSupportActionBar().setTitle(R.string.my_rs_title);
        getSupportActionBar().setSubtitle(R.string.my_rs_sb_title);*/


        }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

       /* getMenuInflater().inflate(R.menu.menu_result, menu);

        SearchView searchView = (SearchView) menu.findItem(R.id.menu_search).getActionView();


        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);

        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));*/

        return super.onCreateOptionsMenu(menu);
    }
}

