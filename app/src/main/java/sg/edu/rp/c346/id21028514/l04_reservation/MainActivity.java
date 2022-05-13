package sg.edu.rp.c346.id21028514.l04_reservation;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TimePicker;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    DatePicker dp;
    TimePicker tp;
    Button btnSubmit;
    ToggleButton smokeNot;
    EditText resName;
    EditText resNum;
    EditText resPax;
    Button reset;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dp =findViewById(R.id.datePicker);
        tp = findViewById(R.id.timePicker);
        btnSubmit = findViewById(R.id.btnSubmit);
        smokeNot = findViewById(R.id.smokeYesNo);
        resName = findViewById(R.id.editName);
        resNum = findViewById(R.id.editNumber);
        resPax = findViewById(R.id.editPax);
        reset = findViewById(R.id.btnReset);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (resName.getText().toString().length() < 1 && resNum.getText().toString().length() < 1 && resPax.getText().toString().length() < 1) {
                    Toast.makeText(MainActivity.this, "Please enter your details", Toast.LENGTH_LONG).show();
                }else{
                        if (!smokeNot.isChecked()) {
                            int month = dp.getMonth() + 1;
                            Toast.makeText(MainActivity.this, resName.getText() + " made a registration on " + dp.getDayOfMonth() + "/" + month + "/" + dp.getYear() + " at the time of " + tp.getCurrentHour() + ":" + tp.getCurrentMinute() + " on the table with non-smokers with " + resPax.getText() + " people.", Toast.LENGTH_LONG).show();
                        } else if (smokeNot.isChecked()) {
                            int month = dp.getMonth() + 1;
                            Toast.makeText(MainActivity.this, resName.getText() + " made a registration on " + dp.getDayOfMonth() + "/" + month + "/" + dp.getYear() + " at the time of " + tp.getCurrentHour() + ":" + tp.getCurrentMinute() + " on the table with smokers with " + resPax.getText() + " people.", Toast.LENGTH_LONG).show();
                        }
                }
            }

            ;});reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tp.setCurrentHour(7);
                tp.setCurrentMinute(30);
                resNum.setText("");
                resName.setText("");
                resPax.setText("");
                smokeNot.setChecked(false);


                dp.updateDate(2020,5,01);
                ;}});
    }
}