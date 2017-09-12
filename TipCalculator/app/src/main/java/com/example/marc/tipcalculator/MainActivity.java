package com.example.marc.tipcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText et;
    Spinner spin;
    Button btn_tip;
    Button btn_price;
    TextView tv;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et = (EditText) findViewById(R.id.et_bill);
        spin = (Spinner) findViewById(R.id.spinner_rating);
        btn_tip = (Button) findViewById(R.id.btn_tip);
        btn_price = (Button) findViewById(R.id.btn_total);
        tv = (TextView) findViewById(R.id.tv_price);
        textView = (TextView) findViewById(R.id.tv_tip);
    }

    public void calculateTip (View view)
    {
        String tip = et.getText().toString();

        if(!tip.isEmpty()) {
            btn_tip.setClickable(true);

            double finalTip = Double.parseDouble(tip);

            String oneTipFormat = String.format("%.2f", finalTip * 0.10);
            String fourTipFormat = String.format("%.2f", finalTip * 0.13);
            String sixTipFormat = String.format("%.2f", finalTip * 0.15);
            String eightTipFormat = String.format("%.2f", finalTip * 0.20);
            String tenTipFormat = String.format("%.2f", finalTip * 0.25);

            textView.setVisibility(View.VISIBLE);
            String rate = String.valueOf(spin.getSelectedItem());

            if (rate.equals("1 star") || rate.equals("2 stars") || rate.equals("3 stars")) {
                String text = "Your rating of: " + rate + " means your tip should be: $" + oneTipFormat;
                textView.setText(text);
            }

            if (rate.equals("4 stars") || rate.equals("5 stars")) {
                String text = "Your rating: " + rate + " means your tip should be: $" + fourTipFormat;
                textView.setText(text);
            }

            if (rate.equals("6 stars") || rate.equals("7 stars")) {
                String text = "Your rating: " + rate + " means your tip should be: $" + sixTipFormat;
                textView.setText(text);
            }

            if (rate.equals("8 stars") || rate.equals("9 stars")) {
                String text = "Your rating: " + rate + " means your tip should be: $" + eightTipFormat;
                textView.setText(text);
            }

            if (rate.equals("10 stars")) {
                String text = "Your rating: " + rate + " means your tip should be: $" + tenTipFormat;
                textView.setText(text);
            }
        }
    }

    public void calculateTotal(View v)
    {
        String value = et.getText().toString();

        if(!value.isEmpty()) {
            btn_price.setClickable(true);

            double finalValue = Double.parseDouble(value);

            String onePriceFormat = String.format("%.2f", finalValue + (finalValue * 0.10));
            String fourPriceFormat = String.format("%.2f", finalValue + (finalValue * 0.13));
            String sixPriceFormat = String.format("%.2f", finalValue + (finalValue * 0.15));
            String eightPriceFormat = String.format("%.2f", finalValue + (finalValue * 0.20));
            String tenPriceFormat = String.format("%.2f", finalValue + (finalValue * 0.25));

            tv.setVisibility(View.VISIBLE);
            String rating = String.valueOf(spin.getSelectedItem());

            if (rating.equals("1 star") || rating.equals("2 stars") || rating.equals("3 stars")) {
                String text = "Based on your service rating of '" + rating + "', your total with tip should be: $" + onePriceFormat;
                tv.setText(text);
            }

            if (rating.equals("4 stars") || rating.equals("5 stars")) {
                String text = "Based on your service rating of '" + rating + "', your total with tip should be: $" + fourPriceFormat;
                tv.setText(text);
            }

            if (rating.equals("6 stars") || rating.equals("7 stars")) {
                String text = "Based on your service rating of '" + rating + "', your total with tip should be: $" + sixPriceFormat;
                tv.setText(text);
            }

            if (rating.equals("8 stars") || rating.equals("9 stars")) {
                String text = "Based on your service rating of '" + rating + "', your total with tip should be: $" + eightPriceFormat;
                tv.setText(text);
            }

            if (rating.equals("10 stars")) {
                String text = "Based on your service rating of '" + rating + "', your total with tip should be: $" + tenPriceFormat;
                tv.setText(text);
            }
        }
    }

    public void clear (View v)
    {
        et.setText("");
        tv.setText("");
        textView.setText("");
    }
}
