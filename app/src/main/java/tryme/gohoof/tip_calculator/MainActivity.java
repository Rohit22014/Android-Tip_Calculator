package tryme.gohoof.tip_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText enterAmount;
    private SeekBar seekBar;
    private Button calculateButton;
    private TextView TotalResultTextView;
    private TextView textViewSeekbar;
    private int SeekBarpercentage;
    private float enteredBillfloat;
    private TextView totalBill;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        enterAmount = (EditText) findViewById(R.id.editTextTextPersonName);
        seekBar = (SeekBar) findViewById(R.id.percentageseekBar);
        calculateButton = (Button) findViewById(R.id.CalculateButton);
        TotalResultTextView = (TextView) findViewById(R.id.resultID);
        textViewSeekbar = (TextView) findViewById(R.id.textViewSeekbar);
        totalBill = (TextView) findViewById(R.id.TotalBill);

        calculateButton.setOnClickListener(this);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

                textViewSeekbar.setText(String.valueOf(seekBar.getProgress()) + "%");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

                SeekBarpercentage = seekBar.getProgress();
            }
        });
    }

    @Override
    public void onClick(View v) {
    calculate();

    }
    public void calculate() {
        float result = 0.0f;

        if(!enterAmount.getText().toString().equals("")) {
            enteredBillfloat = Float.parseFloat(enterAmount.getText().toString());
            result = enteredBillfloat*SeekBarpercentage / 100;
            TotalResultTextView.setText("Tip: " + String.valueOf("$" + result));
            totalBill.setText("Total Bill: $" + (result + enteredBillfloat));
        }else {
            Toast.makeText(MainActivity.this, "Please enter a bill amount", Toast.LENGTH_LONG).show();
        }


    }
}