package com.example.ekombi;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener {
    Button bArtir, bAzalt, bKapat;
    TextView tv1, tv2;

    Kontrol k = new Kontrol();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        bArtir = findViewById(R.id.buttonArtir);
        bAzalt = findViewById(R.id.buttonAzalt);
        bKapat = findViewById(R.id.buttonKapat);

        tv1 = findViewById(R.id.textView);
        tv2 = findViewById(R.id.textView2);

        bArtir.setOnClickListener(this);
        bAzalt.setOnClickListener(this);
        bKapat.setOnClickListener(this);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    public void onClick(View v) {

            if(v.getId()==bArtir.getId()) {
                if (k.hedefSicaklik < 30)
                {
                    k.sicaklikArtir();
                    tv2.setText("Hedef Sıcaklık:" + k.hedefSicaklik );
                    tv1.setText("KOMBİ ÇALIŞIYOR" );
                }
               else {
                    tv1.setText("SICAKLIK DAHA FAZLA YÜKSELTİLEMEZ" );
                }
            }
            if(v.getId()==bAzalt.getId()) {
                if (k.hedefSicaklik > 5)
                {
                    k.sicaklikAzalt();
                    tv2.setText("Hedef Sıcaklık:" + k.hedefSicaklik );
                    tv1.setText("KOMBİ ÇALIŞIYOR" );
                }

                else {
                    tv1.setText("SICAKLIK DAHA FAZLA DÜŞÜRÜLEMEZ!" );
                }

            }
            if(v.getId()==bKapat.getId()) {
                k.kombiyiKapat();
                tv2.setText("Hedef Sıcaklık:" + k.hedefSicaklik );
                tv1.setText("KOMBİ DURDURULDU" );
            }
            }
}