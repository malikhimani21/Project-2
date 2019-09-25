package com.example.project2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ViewFlipper viewFlipper;
    TextView textViewData;
    ListView listView;
    String[] classes = {"WallpaperActivity", "BrowserAppActivity", "BackpressActivity", "SmsActivity", "SearchImplement", "ShowHideLayout", "IncludeLayouts"};
    ArrayAdapter arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewData = (TextView) findViewById(R.id.textViewData);
        Intent intent = getIntent();
        String string = intent.getStringExtra("key1");
        textViewData.setText("Welcome " + string);

        viewFlipper = (ViewFlipper) findViewById(R.id.viewFlipper);
        viewFlipper.setOnClickListener(this);
        viewFlipper.setFlipInterval(2000);
        viewFlipper.startFlipping();


        listView = (ListView) findViewById(R.id.listViewMainActivity);
        arrayAdapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1, classes);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String data = classes[position];
                try {
                    Class classObj = Class.forName("com.example.project2." + data);
                    Intent intent = new Intent(MainActivity.this, classObj);
                    startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });


    }

    @Override
    public void onClick(View v) {
        viewFlipper.showNext();
    }

    @Override
    public void onBackPressed() {

        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Alert for Confirmation");
        builder.setMessage("Do you want to close the App ?");
        builder.setCancelable(true);

        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });

        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), "You're in App ! Have a good day...", Toast.LENGTH_SHORT).show();
            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();

    }


}
