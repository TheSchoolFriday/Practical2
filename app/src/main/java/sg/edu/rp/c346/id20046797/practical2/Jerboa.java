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

public class Jerboa extends AppCompatActivity {

    // Student ID: 20046797
    // Student NAME: Muhammad Fudayl Bin Mohamin

    private int currentFontSize = 16;

    TextView tvScientific, tvDescription, tvDisplay, tvLearnMore;
    Button btnReturnback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jerboa);

        // Text View Find By.
        tvScientific = findViewById(R.id.textViewScientific4);
        tvDescription = findViewById(R.id.textViewDescription4);
        tvDisplay = findViewById(R.id.textViewDisplay4);
        tvLearnMore = findViewById(R.id.textViewLearnMore4);

        // Button Find By.
        btnReturnback = findViewById(R.id.buttonReturn4);

        registerForContextMenu(tvDisplay);

        // On Create Formats.
        tvDisplay.setText(String.format(
            "The jerboa is part of the rodent family Dipodidae, " +
                    "which originates from the Greek words “di,” meaning “two,” and “podos,” " +
                    "meaning “foot.” " +
                    "This is because they have such small arms that it appears as though they only have their two hind feet.\n" +
                    "\n" +
                    "There are thought to be 33 different species of jerboa, including the iconic long-eared jerboa (Euchoreutes naso), " +
                    "thick-tailed pygmy jerboa (Salpingotus crassicauda), Mongolian three-towed jerboa (Stylodipus sungorus), " +
                    "and Greater Egyptian jerboa (Jaculus orientalis)."
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
                        "The jerboa is part of the rodent family Dipodidae, " +
                                "which originates from the Greek words “di,” meaning “two,” and “podos,” " +
                                "meaning “foot.” " +
                                "This is because they have such small arms that it appears as though they only have their two hind feet.\n" +
                                "\n" +
                                "There are thought to be 33 different species of jerboa, including the iconic long-eared jerboa (Euchoreutes naso), " +
                                "thick-tailed pygmy jerboa (Salpingotus crassicauda), Mongolian three-towed jerboa (Stylodipus sungorus), " +
                                "and Greater Egyptian jerboa (Jaculus orientalis)."
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
                        "The jerboa is a small, hopping rodent that lives in the deserts of Northern Africa and Asia. " +
                                "Jerboas are incredibly cute animals and have very \n\n" +
                                "long ears, tails, and hind feet that give them an almost cartoonish appearance. " +
                                "They also have specially adapted legs that allow them to move about by jumping like a kangaroo."
                ));
            }
        });

        // Learn More
        tvLearnMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentURL = new Intent(Intent.ACTION_VIEW, Uri.parse("https://a-z-animals.com/animals/jerboa/"));
                startActivity(intentURL);
            }
        });

        // The return button
        btnReturnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Jerboa.this, MainActivity.class);
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