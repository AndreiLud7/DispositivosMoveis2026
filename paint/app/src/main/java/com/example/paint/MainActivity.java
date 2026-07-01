package com.example.paint;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;
import com.skydoves.colorpickerview.ColorEnvelope;
import com.skydoves.colorpickerview.ColorPickerDialog;
import com.skydoves.colorpickerview.listeners.ColorEnvelopeListener;

public class MainActivity extends AppCompatActivity {
    ImageButton ibColor, ibFingerShape, ibSquareShape, ibCircleShape;
    SimplePaint simplePaint;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        simplePaint= findViewById(R.id.paintView);
        ibColor = findViewById(R.id.ibColor);
        ibFingerShape = findViewById(R.id.ibFingerShape);
        ibSquareShape = findViewById(R.id.ibSquareShape);
        ibCircleShape = findViewById(R.id.ibCircleShape);


        ibColor.setOnClickListener(v -> {
            new ColorPickerDialog.Builder(this)
                    .setTitle("ColorPicker Dialog")
                    .setPreferenceName("MyColorPickerDialog")
                    .setPositiveButton("Selecionar",
                            new ColorEnvelopeListener() {
                                @Override
                                public void onColorSelected(ColorEnvelope envelope, boolean fromUser) {
                                    setColor(envelope);
                                }
                            })
                    .setNegativeButton("Cancelar",
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    dialogInterface.dismiss();
                                }
                            })
                    .attachAlphaSlideBar(true)
                    .attachBrightnessSlideBar(true)
                    .setBottomSpace(12)
                    .show();
        });
        ibCircleShape.setOnClickListener(v -> {
            simplePaint.shape = SimplePaint.Shape.CIRCLE;
        });
        ibSquareShape.setOnClickListener(v -> {
            simplePaint.shape = SimplePaint.Shape.SQUARE;
        });
        ibFingerShape.setOnClickListener(v -> {
            simplePaint.shape = SimplePaint.Shape.FINGER;
        });


    }
    public  void setColor (ColorEnvelope envelope){
        int color = envelope.getColor();
        simplePaint.setColor(color);
        ibColor.setBackgroundColor(color);

    }
}