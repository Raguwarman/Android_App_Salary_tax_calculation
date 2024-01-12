package com.testing.seekbar_11_11_2023;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText editText1;
    private SeekBar seekBar1;
    private TextView textView1, textView2;
    private Button button1;

    private int seekbarNumber = 0;
    private int seekbar_start = 0;

    @SuppressLint({"MissingInflatedId", "WrongViewCast"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText1 = (EditText) findViewById(R.id.salary_ID);
        seekBar1  = (SeekBar) findViewById(R.id.seekBar_ID);
        textView1 = (TextView) findViewById(R.id.percentage_ID);
        textView2 = (TextView) findViewById(R.id.output_ID);
        button1   = (Button) findViewById(R.id.button_ID);

        //--functioning the seekbar---
        seekBar1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                seekbar_start = seekBar1.getProgress();
                String seekbar_start_data = String.valueOf(seekbar_start);
                textView1.setText(String.valueOf(seekbar_start_data)+"%");
                textView1.setVisibility(View.VISIBLE);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                seekbarNumber = seekBar1.getProgress();

            }

        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float finalsalary = 0.0f;
                float tex = 0.0f;
                String salary = editText1.getText().toString();

                if (!salary.equals("")){
                    tex = Float.parseFloat(salary)*seekbarNumber/100;
                    finalsalary = Float.parseFloat(salary) - tex;

                    String final_salary = String.valueOf(finalsalary);
                    textView2.setText(final_salary);

                    textView2.setVisibility(View.VISIBLE);
                }
                else {
                    Toast.makeText(MainActivity.this, "Enter Value", Toast.LENGTH_SHORT).show();
                }

            }
        });


    }
}