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

public class Jackal extends AppCompatActivity {

    private int currentFontSize = 16;

    TextView tvScientific, tvDescription, tvDisplay, tvLearnMore;
    Button btnReturnback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jackal);

        // Text View Find By.
        tvScientific = findViewById(R.id.textViewScientific2);
        tvDescription = findViewById(R.id.textViewDescription2);
        tvDisplay = findViewById(R.id.textViewDisplay2);
        tvLearnMore = findViewById(R.id.textViewLearnMore2);

        // Button Find By.
        btnReturnback = findViewById(R.id.buttonReturn2);

        registerForContextMenu(tvDisplay);

        // On Create Formats.
        tvDisplay.setText(String.format(
                "The scientific name of a common jackal is Canis aureus. " +
                "The word Canis is Latin for dog and aureus means golden. " +
                "So, it makes sense that another name for the common jackal is the golden jackal. Its family is Canidae and its class is Mammalia.\n\n" +
                "Along with the common jackal, there are two other species including the side-striped jackal and the black-backed jackal. " +
                "The only difference between these three species is the color of their coat and the specific habitat they prefer to live in."
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
                        "The scientific name of a common jackal is Canis aureus. " +
                        "The word Canis is Latin for dog and aureus means golden. " +
                        "So, it makes sense that another name for the common jackal is the golden jackal. Its family is Canidae and its class is Mammalia.\n\n" +
                        "Along with the common jackal, there are two other species including the side-striped jackal and the black-backed jackal. " +
                        "The only difference between these three species is the color of their coat and the specific habitat they prefer to live in."
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
                        "Jackals are animals that make their home in different parts of Africa as well as in European countries " +
                        "such as Greece, Romania, Italy, and Bulgaria along with others. " +
                        "They are omnivores eating both plants and meat. " +
                        "A male and female jackal are monogamous meaning they stay together throughout their lives and the pair raises their pups together. " +
                        "These canines can live up to 12 years in the wild."
                ));
            }
        });

        // Learn More
        tvLearnMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentURL = new Intent(Intent.ACTION_VIEW, Uri.parse("https://a-z-animals.com/animals/jackal/"));
                startActivity(intentURL);
            }
        });

        // The return button
        btnReturnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Jackal.this, MainActivity.class);
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