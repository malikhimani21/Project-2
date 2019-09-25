package com.example.project2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewStub;
import android.widget.Button;

public class ShowHideLayout extends AppCompatActivity {

    private ViewStub viewStub;
    private Button show, hide;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_hide_layout);

        show = (Button) findViewById(R.id.showButton);
        hide = (Button) findViewById(R.id.hideButton);

        viewStub = (ViewStub) findViewById(R.id.viewStub);
        viewStub.inflate();

        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewStub.setVisibility(View.VISIBLE);
            }
        });

        hide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewStub.setVisibility(View.INVISIBLE);
            }
        });

    }
}
