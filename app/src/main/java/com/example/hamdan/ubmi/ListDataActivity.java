package com.example.hamdan.ubmi;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ListDataActivity extends AppCompatActivity {
    private static final String TAG = "ListDataActivity";
    databaseHelper databaseHelper;

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e("ListDataActivity", "Entered!!!!!!!!!!!!!!!!");
        setContentView(R.layout.activity_list_data);
        Log.e("ListDataActivity", "Entered!!!!!!!!!!!!!!!!");
        listView = findViewById(R.id.listView2);
        databaseHelper = new databaseHelper(this);

        populateListView();
    }

    private void populateListView() {

        Log.d(TAG,"populateListView: Displaying Data on the Listview...");

        Cursor data = databaseHelper.getData();
        ArrayList<String> listData = new ArrayList<>();
        while(data.moveToNext())
        {
            listData.add(data.getString(1));
        }

        ListAdapter adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,listData);
        listView.setAdapter(adapter);
    }
}
