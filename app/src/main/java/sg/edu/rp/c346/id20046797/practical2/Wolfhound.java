package sg.edu.rp.c346.id20046797.practical2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Wolfhound extends AppCompatActivity {

    // Student ID: 20046797
    // Student NAME: Muhammad Fudayl Bin Mohamin

    private int currentFontSize = 16;

    TextView tvScientific, tvDescription, tvDisplay, tvLearnMore;
    Button btnReturnback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wolfhound);

        // Text View Find By.
        tvScientific = findViewById(R.id.textViewScientific6);
        tvDescription = findViewById(R.id.textViewDescription6);
        tvDisplay = findViewById(R.id.textViewDisplay6);
        tvLearnMore = findViewById(R.id.textViewLearnMore6);

        // Button Find By.
        btnReturnback = findViewById(R.id.buttonReturn6);

        registerForContextMenu(tvDisplay);

        // On Create Formats.
        tvDisplay.setText(String.format(
                "Irish wolfhounds are large dogs and are thought to be the tallest breed of dog. " +
                        "Males are at least 32 inches tall, but normally closer to 36 inches, and females are at least 30 inches tall, " +
                        "but typically closer to 33 inches. A fully grown male weighs around 160 pounds and a fully grown female weighs around 130 pounds. " +
                        "A 2-month-old puppy typically weighs around 24 pounds. \n\n" +
                        "By 6 months, male puppies are nearly 100 pounds and female puppies are around 90 pounds. " +
                        "They are fully grown by the time they are three years old."
        ));

        tvScientific.setText(R.string.scientific_classification);

        tvDescription.setTextColor(Color.GRAY);

        // When they Click on Scientific
        tvScientific.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvScientific.setText(R.string.scientific_classification);
                tvScientific.setTextColor(Color.BLACK);

                tvDescription.setText(R.string.description);
                tvDescription.setTextColor(Color.GRAY);

                tvDisplay.setText(String.format(
                        "Irish wolfhounds are large dogs and are thought to be the tallest breed of dog. " +
                                "Males are at least 32 inches tall, but normally closer to 36 inches, and females are at least 30 inches tall, " +
                                "but typically closer to 33 inches. A fully grown male weighs around 160 pounds and a fully grown female weighs around 130 pounds. " +
                                "A 2-month-old puppy typically weighs around 24 pounds. \n\n" +
                                "By 6 months, male puppies are nearly 100 pounds and female puppies are around 90 pounds. " +
                                "They are fully grown by the time they are three years old."
                ));
            }
        });

        // When they Click on Description
        tvDescription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvDescription.setText(R.string.description);
                tvDescription.setTextColor(Color.BLACK);

                tvScientific.setText(R.string.scientific_classification);
                tvScientific.setTextColor(Color.GRAY);

                tvDisplay.setText(String.format(
                        "Irish wolfhounds have a long and storied history. Depending upon who you ask, the breed traces back to as early as 700 BC.\n\n" +
                                "The first examples of this breed were created by crossbreeding large British dogs with coursing hounds from the Middle East. " +
                                "These dogs were legendary for their large size and hunting abilities."
                ));
            }
        });

        // Learn More
        tvLearnMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentURL = new Intent(Intent.ACTION_VIEW, Uri.parse("https://a-z-animals.com/animals/irish-wolfhound/"));
                startActivity(intentURL);
            }
        });

        // The return button
        btnReturnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Wolfhound.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    // When the Text is being held.
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.add(0, 0, 0, "Increase Font Size (" + currentFontSize + "sp)");
        menu.add(0, 1, 1, "Decrease Font Size (" + currentFontSize + "sp)");
    }

    // Which Item is Selected and the Function.
    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

        // Performs the Check and Changes font size if necessary.
        if (currentFontSize > 24 && item.getItemId() == 0) {
            Toast.makeText(this, "Font Size too Large.", Toast.LENGTH_SHORT).show();
        } else if (currentFontSize < 10 && item.getItemId() == 1){
            Toast.makeText(this, "Font Size too Small.", Toast.LENGTH_SHORT).show();
        } else {
            switch(item.getItemId()) {
                case 0:
                    currentFontSize+=2;
                    break;
                case 1:
                    currentFontSize-=2;
                    break;
            }
        }

        // Change the Font SIZE.
        tvDisplay.setTextSize(TypedValue.COMPLEX_UNIT_SP, currentFontSize);
        return super.onContextItemSelected(item);
    }
}