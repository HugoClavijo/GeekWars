package com.geekdom.geekwars;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.geekdom.geekwars.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button fbutton = findViewById(R.id.button1);
        fbutton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                goToFacebookPage("257028575158979");
            }
        });
    }

    public void goToFacebookPage(String id){
        try {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("fb://page/" + id));
            startActivity(intent);

        } catch (ActivityNotFoundException e){

            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/" + id));
            startActivity(intent);

        }
    }
}
