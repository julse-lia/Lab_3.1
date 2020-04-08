package com.example.fermatsfactorizationmethod;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {


    private EditText input;
    private EditText iterCount;
    private EditText endResult;
    private Button button;
    private int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onButtonClick(View v) {
        iterCount = findViewById(R.id.iterCount);
        endResult = findViewById(R.id.endResult);
        input = findViewById(R.id.number);
        button = findViewById(R.id.button);

        String result = factorize();
        String iterations = calculateIterations();
        endResult.setText(result);
        iterCount.setText(iterations);

    }
    public String factorize() {
        String result = "";
        String text = input.getText().toString();

        if (text.isEmpty()){
            text = "0";
        }
        int n = Integer.parseInt(text);

        if (n <= 0) {
            result += n + " ";
            return result;
        }

        int square_root = (int) Math.ceil(Math.sqrt(n));

        if (square_root * square_root == n) {
            result += " " + square_root + ", " + square_root;
            return result;
        }

        int b;

        while (true) {
            int b1 = square_root * square_root - n;
            b = (int) (Math.sqrt(b1));

            if (b * b == b1)
                break;
            else
                square_root += 1;
            count ++;
        }
        result += " " + (square_root - b) + "," + (square_root + b) + " ";
        return result;

    }
    public String calculateIterations(){
        String iterations = "";
        iterations = "" + count;
        return iterations;
    }

}

