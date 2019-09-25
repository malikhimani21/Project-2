package com.example.project2;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MenuActivity extends ListActivity {

    String[] classes = {"LoginActivity", "Page_Two", "Page_Three"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setListAdapter(new ArrayAdapter<String>(MenuActivity.this,R.layout.menu_activity_layout,classes));
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        String data = classes[position];
        try{
            Class classObj = Class.forName("com.example.project2."+data);
            Intent intent = new Intent(MenuActivity.this, classObj);
            startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
