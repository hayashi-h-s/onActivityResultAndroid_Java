package com.e.startactivityforresutandroidjava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {



    // the key constant
    public static final String EXTRA_MESSAGE
//            = "com.example.testactivitytrasdata.MESSAGE";
            = "YourPackageName.MESSAGE";

    private TextView textView;
    static final int RESULT_SUBACTIVITY = 1000;
    static final int RESULT_3ACTIVITY = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("TAG", "onCreate");

        textView = findViewById(R.id.text_view);

        final EditText editText= findViewById(R.id.edit_text);

        Button button = findViewById(R.id.button);
        Button button3 = findViewById(R.id.button3);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplication(), SubActivity.class);
                if (editText.getText() != null) {
                    String str = editText.getText().toString();
                    intent.putExtra(EXTRA_MESSAGE, str);
                }
                startActivityForResult(intent, RESULT_SUBACTIVITY);

                // in order to clear the edittext
                editText.setText("");
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplication(), ThardActivity.class);

                // ここで、画面遷移の時の値を渡している
                startActivityForResult(intent, RESULT_3ACTIVITY);
//                startActivity(intent);
//                if (editText.getText() != null) {
//                    String str = editText.getText().toString();
//                    intent.putExtra(EXTRA_MESSAGE, str);
//                }
//                startActivityForResult(intent, RESULT_SUBACTIVITY);

                // in order to clear the edittext
            }
        });
//        button3.setOnClickListener( v -> {
//            Intent intent = new Intent(getApplication(), SubActivity.class);
//            if(editText.getText() != null){
//                String str = editText.getText().toString();
//                intent.putExtra(EXTRA_MESSAGE, str);
//            }
//            startActivityForResult( intent, RESULT_SUBACTIVITY );
//
//            // in order to clear the edittext
//            editText.setText("");
//        });
    }

    // SubActivity からの返しの結果を受け取る
    protected void onActivityResult( int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);

        Log.d("TAG", "onActivityResult");

        if(resultCode == RESULT_OK && requestCode == RESULT_SUBACTIVITY && null != intent) {

            Log.d("TAG", "サブから");

            String res = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
            textView.setText(res);

            // ここで
        } else if (resultCode == RESULT_OK && requestCode == RESULT_3ACTIVITY && null != intent){
            Log.d("TAG", "3");
        }
    }
}
