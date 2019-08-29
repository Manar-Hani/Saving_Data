package com.example.localdb.Activities;



import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import android.view.MenuItem;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;


import com.example.localdb.Classes.DatabaseHelper;
import com.example.localdb.R;

import java.util.ArrayList;
import java.util.HashMap;

public class SavedDataActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Saved Data");

        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);




        setContentView(R.layout.activity_saved_data);
        DatabaseHelper db = new DatabaseHelper(this);
        ArrayList<HashMap<String, String>> userList = db.GetUsers();
        ListView lv =  findViewById(R.id.user_list);
        ListAdapter adapter = new SimpleAdapter(SavedDataActivity.this, userList, R.layout.list_row,new String[]{"name","age", "job","gender"}, new int[]{R.id.savedName, R.id.savedAge, R.id.savedJob, R.id.savedGender});
        lv.setAdapter(adapter);

    }

    public boolean onOptionsItemSelected(MenuItem item){
        Intent myIntent = new Intent(getApplicationContext(), EnterDataActivity.class);
        startActivityForResult(myIntent, 0);
        SavedDataActivity.this.finish();
        return true;
    }
}