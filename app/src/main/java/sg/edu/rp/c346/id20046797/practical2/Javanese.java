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

public class Javanese extends AppCompatActivity {

    private int currentFontSize = 16;

    TextView tvScientific, tvDescription, tvDisplay, tvLearnMore;
    Button btnReturnback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_javanese);

        // Text View Find By.
        tvScientific = findViewById(R.id.textViewScientific3);
        tvDescription = findViewById(R.id.textViewDescription3);
        tvDisplay = findViewById(R.id.textViewDisplay3);
        tvLearnMore = findViewById(R.id.textViewLearnMore3);

        // Button Find By.
        btnReturnback = findViewById(R.id.buttonReturn3);

        registerForContextMenu(tvDisplay);

        // On Create Formats.
        tvDisplay.setText(String.format(
                "Due to the fact that the Javanese cat is directly related to the Siamese cat and the Balinese cat, " +
                        "it has picked defects as well as assets from its ancestors or though today, " +
                        "cats have been bred so extensively that native defects are often bred out of the breed."
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
                        "Due to the fact that the Javanese cat is directly related to the Siamese cat and the Balinese cat, " +
                                "it has picked defects as well as assets from its ancestors or though today, " +
                                "cats have been bred so extensively that native defects are often bred out of the breed."
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
                        "The Javanese breed of cat is generally used to refer to Balinese cats that don’t have the typical modern Balinese markings or colourings " +
                                "(so cats that are not brown, silver or blue)." +
                                "\n" +
                                "\n" +
                                "The Javanese cat has soft, shiny fur and can often be found with features closely resembling the Siamese cat. " +
                                "The Javanese cat is a popular household cat around the world and adores human attention."
                ));
            }
        });

        // Learn More
        tvLearnMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentURL = new Intent(Intent.ACTION_VIEW, Uri.parse("https://a-z-animals.com/animals/javanese/"));
                startActivity(intentURL);
            }
        });

        // The return button
        btnReturnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Javanese.this, MainActivity.class);
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