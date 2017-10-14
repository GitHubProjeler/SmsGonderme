package com.trkaynak.smsgonderme;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getControlView();
        setClickForView();
    }

    private void getControlView() {
        btn = (Button) findViewById(R.id.button);
    }
    private void setClickForView(){
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendSmsMessage("Merhaba","05443187773");

            }
        });
    }
    public void sendSmsMessage(String message, String tel){
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("smsto:"+tel));
        intent.putExtra("sms_body",message);
        if(intent.resolveActivity(getPackageManager()) != null){
            startActivity(intent);
        }
    }
}
