package com.example.lab_3;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class pageTwo extends AppCompatActivity {

    private Button converterButton;
    private TextView result;
    private EditText enterTemp;
    private Spinner typeSpinner;

    double result1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_two);

        // referencing
        converterButton = findViewById(R.id.converterButton);
        result = findViewById(R.id.result);
        enterTemp = findViewById(R.id.enterTemp);
        typeSpinner = findViewById(R.id.typeSpinner);

        // Set up the spinner
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.temperature_types, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        typeSpinner.setAdapter(adapter);

        converterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Type converter: decimal to double
                double temp = Double.parseDouble(enterTemp.getText().toString());
                String selectedType = typeSpinner.getSelectedItem().toString();

                // Convert input based on the selected type
                if (selectedType.equals("Fahrenheit")) {
                    // Convert Celsius to Fahrenheit
                    result1 = (temp * 1.8) + 32;
                } else {
                    // Convert Fahrenheit to Celsius
                    result1 = (temp - 32) / 1.8;
                }

                // Display the result in UI
                result.setText(String.valueOf(result1));
            }
        });
    }
}
