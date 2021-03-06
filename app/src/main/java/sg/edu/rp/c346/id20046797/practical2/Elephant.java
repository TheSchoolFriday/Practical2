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

public class Elephant extends AppCompatActivity {

    private int currentFontSize = 16;

    TextView tvScientific, tvDescription, tvDisplay, tvLearnMore;
    Button btnReturnback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_elephant);

        // Text View Find By.
        tvScientific = findViewById(R.id.textViewScientific9);
        tvDescription = findViewById(R.id.textViewDescription9);
        tvDisplay = findViewById(R.id.textViewDisplay9);
        tvLearnMore = findViewById(R.id.textViewLearnMore9);

        // Button Find By.
        btnReturnback = findViewById(R.id.buttonReturn9);

        registerForContextMenu(tvDisplay);

        // On Create Formats.
        tvDisplay.setText(String.format(
                "The Indian elephant goes by the scientific name Elephas maximus indicus. " +
                        "They belong to the kingdom Animalia and class Mammalia. " +
                        "These elephants come from a family called Elephantidae and have a subspecies called E. m. indicus. " +
                        "They belong to the order called Proboscideans.\n" +
                        "\n" +
                        "The word elephas is the Latin influence for elephant, " +
                        "but it comes from the Greek word ἐλέφαντος, which could’ve been influenced by the Egyptian word for ivory or elephant. " +
                        "Interestingly, ivory’s etymology comes directly from Latin and Greek interpretations of the word elephant, " +
                        "making them interconnected forever."
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
                        "The Indian elephant goes by the scientific name Elephas maximus indicus. " +
                                "They belong to the kingdom Animalia and class Mammalia. " +
                                "These elephants come from a family called Elephantidae and have a subspecies called E. m. indicus. " +
                                "They belong to the order called Proboscideans.\n" +
                                "\n" +
                                "The word elephas is the Latin influence for elephant, " +
                                "but it comes from the Greek word ἐλέφαντος, which could’ve been influenced by the Egyptian word for ivory or elephant. " +
                                "Interestingly, ivory’s etymology comes directly from Latin and Greek interpretations of the word elephant, " +
                                "making them interconnected forever."
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
                        "Indian elephants are greyish-black animals that are a subspecies of the Asian elephant. " +
                                "They are about 6.6 to 11.5 feet in height and weigh about 4000 to 1000 pounds.\n" +
                                "\n" +
                                "These elephants go by the scientific name Elephas maximus indicus and have long trunks that are completely boneless. " +
                                "The trunks are known to be made up of about 40,000 muscles."
                ));
            }
        });

        // Learn More
        tvLearnMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentURL = new Intent(Intent.ACTION_VIEW, Uri.parse("https://a-z-animals.com/animals/indian-elephant/"));
                startActivity(intentURL);
            }
        });

        // The return button
        btnReturnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Elephant.this, MainActivity.class);
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