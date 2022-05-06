package com.assignment_app;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Chat_Massage extends AppCompatActivity {

    TextView itemName, messageList;
    EditText message;
    Button send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_massage);

        itemName = (TextView) findViewById(R.id.txtItem);
        messageList = (TextView) findViewById(R.id.txtAllMessages);

        message = (EditText) findViewById(R.id.edtMessage);
        send = (Button) findViewById(R.id.btnSend);

        Intent intent = getIntent();

        itemName.setText("Person Name: "+intent.getStringExtra("name"));

        send.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View view) {
                Vibrator v = (Vibrator) view.getContext().getSystemService(Context.VIBRATOR_SERVICE);
                v.vibrate(400);

                if(message.getText().toString().isEmpty()){
                    Toast.makeText(Chat_Massage.this, "Wright Something plz!!", Toast.LENGTH_SHORT).show();
                }
                else{
                    messageList.setText(messageList.getText().toString()+"\n "+message.getText().toString());
                    message.setText(" ");
                }
            }
        });
    }
}