package com.example.android_studio_temp_converter;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import com.example.android_studio_temp_converter.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private double celsiusValue, fahrenheitValue;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
    }

    public void onClickConvert(View view) {

        // Neither text entries filled
//        if () {
//
//        }
//
//        // Celsius value filled
//        else if (binding.fahrenheitEdit.equals("")) {
//
//        }
//        // Fahrenheit value filled
//        else if () {
//
//        }
        // Both filled

    }

    private double fahrenToCels(double f){
        double c;
        c = (f - 32) * ((double) 5/9);
        return c;
    }

    private double celsToFahren(double c){
        double f;
        f = c * ((double) 9 /5) + 32;
        return f;
    }
}