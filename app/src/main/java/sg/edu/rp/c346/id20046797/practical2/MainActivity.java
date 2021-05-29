package sg.edu.rp.c346.id20046797.practical2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnJackabee, btnJackal, btnJavanese, btnJerboa, btnJellyfish, btnWolfhound, btnTerrier, btnIguana, btnElephant, btnTortoise;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        btnJackabee
        btnJackal = findViewById(R.id.buttonJackal);
//        btnJavanese
//        btnJerboa
//        btnJellyfish
//        btnWolfhound
//        btnTerrier
//        btnIguana
//        btnElephant
//        btnTortoise

        // Reserved for Jackabee Demonstration

        // Reserved for Jackal.
        btnJackal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(MainActivity.this, Jackal.class);
                startActivity(intent2);
            }
        });

//        btnJavanese
//        btnJerboa
//        btnJellyfish
//        btnWolfhound
//        btnTerrier
//        btnIguana
//        btnElephant
//        btnTortoise
    }
}