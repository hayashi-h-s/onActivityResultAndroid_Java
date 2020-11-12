package com.e.startactivityforresutandroidjava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ThardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thard);

        Button buttonThard = findViewById(R.id.buttonThard);
        buttonThard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent3 = new Intent(ThardActivity.this,MainActivity.class);
//                startActivity(intent);

//                Intent intent3 = new Intent();
//                setResult(RESULT_OK, intent3);
//                finish();


                Intent intentSub = new Intent();
//                if (editText.getText() != null) {
//                    String str = message + editText.getText().toString();
//                    intentSub.putExtra(MainActivity.EXTRA_MESSAGE, str);
//                }

//                editText.setText("");
                setResult(RESULT_OK, intentSub);
                finish();
            }
        });

    }
}