package com.example.projectimages;

import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ViewListContents extends AppCompatActivity {

    DatabaseHandler myDB;

    @Override
        protected void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_view_content_layout);

            ListView listView = findViewById(R.id.listView);
            myDB = new DatabaseHandler(this);

            //populate an ArrayList<String> from the database and then view it
            ArrayList<String> theList = new ArrayList<>();
            Cursor data = myDB.getListContents();
            if(data.getCount() <= 0){
                Toast.makeText(this, "There are no contents in this list!",Toast.LENGTH_LONG).show();
            }else{
                while(data.moveToNext()){
                    theList.add(data.getString(0));
                    ListAdapter listAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,theList);
                    listView.setAdapter(listAdapter);
                }
        }
    }
}