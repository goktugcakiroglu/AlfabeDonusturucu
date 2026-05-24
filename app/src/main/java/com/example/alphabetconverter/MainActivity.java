package com.example.alphabetconverter;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Ekran kenarlarındaki boşlukları ayarlama (Varsayılan Android Studio kodu)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Arayüz elemanlarını koda bağlıyoruz
        EditText inputEditText = findViewById(R.id.inputEditText);
        Spinner sourceSpinner = findViewById(R.id.sourceSpinner);
        Spinner targetSpinner = findViewById(R.id.targetSpinner);
        Button convertButton = findViewById(R.id.convertButton);
        TextView outputTextView = findViewById(R.id.outputTextView);

        convertButton.setOnClickListener(v -> {
            String kullaniciGirdisi = inputEditText.getText().toString();

            if (!kullaniciGirdisi.isEmpty()) {
                // Menülerden seçili alfabeleri al (Örn: "Kiril" ve "Osmanlı")
                String kaynakAlfabe = sourceSpinner.getSelectedItem().toString();
                String hedefAlfabe = targetSpinner.getSelectedItem().toString();

                try {
                    // Fabrika sınıfımız aradaki Latin köprüsünü otomatik halledecek
                    String sonuc = TranslatorFactory.translateText(kullaniciGirdisi, kaynakAlfabe, hedefAlfabe);
                    outputTextView.setText(sonuc);
                } catch (Exception e) {
                    outputTextView.setText("Çeviri Hatası!");
                }
            }
        });
    }
}