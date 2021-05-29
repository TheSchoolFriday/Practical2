package sg.edu.rp.c346.id20046797.practical2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnJackabee, btnJackal, btnJavanese, btnJerboa, btnJellyfish, btnWolfhound, btnTerrier, btnIguana, btnElephant, btnTortoise;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        btnJackabee
        btnJackal = findViewById(R.id.buttonJackal);
        btnJavanese = findViewById(R.id.buttonJavanese);
        btnJerboa = findViewById(R.id.buttonJerboa);
        btnJellyfish = findViewById(R.id.buttonJellyfish);
        btnWolfhound = findViewById(R.id.buttonWolfhound);
        btnTerrier = findViewById(R.id.buttonTerrier);
        btnIguana = findViewById(R.id.buttonIguana);
        btnElephant = findViewById(R.id.buttonElephant);
        btnTortoise = findViewById(R.id.buttonTortoise);

        // Reserved for Jackabee Demonstration



        btnJackal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Jackal.class);
                startActivity(intent);
            }
        });

        btnJavanese.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Yep I work.", Toast.LENGTH_SHORT).show();
//                Intent intent = new Intent(MainActivity.this, Jackal.class);
//                startActivity(intent);
            }
        });

        btnJerboa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this, Jackal.class);
//                startActivity(intent);
            }
        });

        btnJellyfish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this, Jackal.class);
//                startActivity(intent);
            }
        });

        btnWolfhound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this, Jackal.class);
//                startActivity(intent);
            }
        });

        btnTerrier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this, Jackal.class);
//                startActivity(intent);
            }
        });

        btnIguana.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this, Jackal.class);
//                startActivity(intent);
            }
        });

        btnElephant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this, Jackal.class);
//                startActivity(intent);
            }
        });

        btnTortoise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this, Jackal.class);
//                startActivity(intent);
            }
        });

    }
}