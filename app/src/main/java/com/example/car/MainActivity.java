package com.example.car;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import static android.widget.Toast.LENGTH_SHORT;

public class MainActivity extends AppCompatActivity {
    private TextView totalPay;
    private TextView carCost;
    private TextView downPayment;
    private TextView apr;
    private TextView lengthNum;
    private SeekBar lengthBar;
    private RadioButton loan;
    private RadioButton lease;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        totalPay = findViewById(R.id.totalPay);
        carCost = findViewById(R.id.carCost);
        downPayment = findViewById(R.id.downPayment);
        apr = findViewById(R.id.apr);
        lengthNum = findViewById(R.id.lengthNum);
        lengthBar = findViewById(R.id.lengthBar);
        loan = findViewById(R.id.loan);
        lease = findViewById(R.id.lease);

        lengthBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                lengthNum.setText(progress + "");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public void calculate(View v) {
        if (loan.isChecked()) {
            String input = carCost.getText().toString();
            if (input.length() > 0) {
                String inputTwo = downPayment.getText().toString();
                if (inputTwo.length() > 0) {
                    String inputThree = apr.getText().toString();
                    if (inputThree.length() > 0) {
                        double carCostNum = Double.parseDouble(input);
                        double downPaymentNum = Double.parseDouble(inputTwo);
                        double aprNum = Double.parseDouble(inputThree);
                        double totalNum = ((aprNum / 100) / 12 * (carCostNum - downPaymentNum)) / (1 - Math.pow(1 + aprNum / 100 / 12, -lengthBar.getProgress()));
                        totalPay.setText(String.format("%.2f", totalNum));
                    }else{
                        Toast.makeText(this, "Value Missing", LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(this, "Value Missing", LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(this, "Value Missing", LENGTH_SHORT).show();
            }

        }
        else if (lease.isChecked()) {
            String input = carCost.getText().toString();
            if (input.length() > 0) {
                String inputTwo = downPayment.getText().toString();
                if (inputTwo.length() > 0) {
                    String inputThree = apr.getText().toString();
                    if (inputThree.length() > 0) {
                        double carCostNum = Double.parseDouble(input);
                        double downPaymentNum = Double.parseDouble(inputTwo);
                        double aprNum = Double.parseDouble(inputThree);
                        double totalNum = ((aprNum / 100) / 12 * (carCostNum/3 - downPaymentNum)) / (1 - Math.pow(1 + aprNum / 100 / 12, -36));
                        totalPay.setText(String.format("%.2f", totalNum));
                    }else {
                        Toast.makeText(this, "Value Missing", LENGTH_SHORT).show();
                    }
                }else {
                    Toast.makeText(this, "Value Missing", LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(this, "Value Missing", LENGTH_SHORT).show();
            }

        }

    }


}
