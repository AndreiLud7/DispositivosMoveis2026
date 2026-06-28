package com.example.contaclick;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int i = 0;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.bla);
    }
    @Override
    protected void onStart() {
        super.onStart();
        textView.setText("Aperte em mim, ou espaco para interagir! ");
    }
    public void contar(View v){

        i++;
        TextView tv = (TextView) v;
        tv.setText("Aperte em mim, ou espaco para interagir!" + i);

    }
}