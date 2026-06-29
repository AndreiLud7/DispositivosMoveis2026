package com.example.imc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View;



public class Resultado extends AppCompatActivity {
    TextView tvaltura, tvpeso, tvimc, tvresult;
    ImageView imageViewR;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        tvaltura = findViewById(R.id.ResultadoAltura);
        tvpeso = findViewById(R.id.Resultadopeso);
        tvimc = findViewById(R.id.ResultadoIMC);
        imageViewR = findViewById(R.id.imageView);
        tvresult = findViewById(R.id.IndicadorR);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        Float peso, altura, imc;
        peso = bundle.getFloat("peso");
        altura = bundle.getFloat("altura");
        imc = bundle.getFloat("imc");
        imc = peso / (altura * altura);

        tvaltura.setText(altura.toString());
        tvpeso.setText(peso.toString());
        tvimc.setText(imc.toString());

        if (imc < 18.5) {
            imageViewR.setImageResource(R.drawable.abaixopeso);
            tvresult.setText("Abaixo do peso");
        }
        else if (imc>18.5 && imc<24.9){
            imageViewR.setImageResource(R.drawable.normal);
            tvresult.setText("Peso normal");
        }else if (imc>24.9 && imc<29.9){
            imageViewR.setImageResource(R.drawable.sobrepeso);
            tvresult.setText("Sobrepeso");
        }else if (imc>30 && imc<34.9){
            imageViewR.setImageResource(R.drawable.obesidade1);
            tvresult.setText("Obesidade grau 1");
        } else if (imc>35 && imc<39.9){
            imageViewR.setImageResource(R.drawable.obesidade2);
            tvresult.setText("Obesidade grau 2");
        }else if (imc>40){
            imageViewR.setImageResource(R.drawable.obesidade3);
            tvresult.setText("Obesidade grau 3");
        }

    }
    public void Refazer(View view){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}