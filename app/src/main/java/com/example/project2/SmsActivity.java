package com.example.project2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SmsActivity extends AppCompatActivity {

    EditText editTextMobile, editTextMessage;
    Button sendsms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);


        editTextMobile = (EditText) findViewById(R.id.editTextNumberSMS);
        editTextMessage = (EditText) findViewById(R.id.editTextMessageSMS);
        sendsms = (Button) findViewById(R.id.buttonSendSMS);

        sendsms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String NUMBER = editTextMobile.getText().toString();
                String MESSAGE = editTextMessage.getText().toString();

                Intent intent = new Intent(getApplicationContext(), SmsActivity.class);
                PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(), 0, intent, 0);
                SmsManager smsManager = SmsManager.getDefault();
                smsManager.sendTextMessage(NUMBER, null, MESSAGE, pendingIntent, null);
                Toast.makeText(getApplicationContext(), "SMS Sent !!!", Toast.LENGTH_SHORT).show();

            }
        });
    }
}
