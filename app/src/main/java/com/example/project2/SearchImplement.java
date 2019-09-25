package com.example.project2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

public class SearchImplement extends AppCompatActivity {

    private ListView listView;
    ArrayAdapter<String> arrayAdapter;
    private EditText editText;
    private String name[] = {"HTML", "CSS", "Bootstrap", "PHP", "Android", "CPP",
            "Perl", "GO", "JavaScript", "jQuery", "SQL", "Java"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_implement);

        editText = (EditText) findViewById(R.id.editTextSearch);
        listView = (ListView) findViewById(R.id.listviewSearch);
        arrayAdapter = new ArrayAdapter<String>(this, R.layout.list_item_layout, R.id.item_name, name);
        listView.setAdapter(arrayAdapter);

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                arrayAdapter.getFilter().filter(s);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }
}
