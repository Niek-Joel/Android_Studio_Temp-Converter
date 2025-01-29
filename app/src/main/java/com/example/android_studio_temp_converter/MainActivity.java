package com.example.android_studio_temp_converter;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import com.example.android_studio_temp_converter.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private double celsiusValue, fahrenheitValue;
    private ActivityMainBinding binding;
    private EditText fahrenheitEdit, celsiusEdit;
    private String fahrenheitText, celsiusText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
    }

    private void setValue() {
        try{
            celsiusEdit = (EditText)findViewById(R.id.celsiusEdit);
            celsiusText = celsiusEdit.getText().toString().trim();
            if (!celsiusText.isEmpty()) {
                celsiusValue = Double.parseDouble(celsiusText);
            }

            fahrenheitEdit = (EditText) findViewById(R.id.fahrenheitEdit);
            fahrenheitText = fahrenheitEdit.getText().toString().trim();
            if (!fahrenheitText.isEmpty()) {
                fahrenheitValue = Double.parseDouble(fahrenheitText);
            }
        }
        catch(Exception error){
            Log.e(TAG, error.toString());
            error.printStackTrace();
        }
    }

    @SuppressLint("DefaultLocale")
    public void onClickConvert(View view) {
        setValue();
        // Neither text entries filled
        if (celsiusText.isEmpty() && fahrenheitText.isEmpty()){
            Toast toast = Toast.makeText(this, "Please enter a value in either fields.",Toast.LENGTH_LONG);
            toast.show();
        }
        // Celsius filled, fahrenheit empty. Convert c to f and display.
        else if (!celsiusText.isEmpty() && fahrenheitText.isEmpty()) {
            fahrenheitValue = celsToFahren(celsiusValue);
            binding.fahrenheitEdit.setText(String.valueOf(String.format("%.5g%n", fahrenheitValue)));
        }
        // Fahrenheit filled, celsius empty. OR both are filled. Convert f to c and display.
        else if ( (!fahrenheitText.isEmpty() && celsiusText.isEmpty()  )  ||
                  (!fahrenheitText.isEmpty() && !celsiusText.isEmpty() ) ) {
            celsiusValue = fahrenToCels(fahrenheitValue);
            binding.celsiusEdit.setText(String.valueOf(String.format("%.5g%n", celsiusValue)));
        }
        // Do nothing
        else {
            Toast toast = Toast.makeText(this, "I'm sorry, I don't understand.",Toast.LENGTH_LONG);
            toast.show();
        }
    }

    private double fahrenToCels(double f){
        return ((f-32.0)*5)/9.0;
    }

    private double celsToFahren(double c){
        return (c * (9.0/5)) + 32.0;
    }
}