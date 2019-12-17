package com.simplecalculator;

import android.content.Context;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import butterknife.BindView;
import butterknife.ButterKnife;
import mathjs.niltonvasques.com.mathjs.MathJS;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.numberOneEditText)
    EditText numberOneEdit;
    @BindView(R.id.numberTwoEditText)
    EditText numberTwoEdit;
    @BindView(R.id.operationSpinner)
    Spinner operationSpinner;
    @BindView(R.id.results)
    TextView results;
    @BindView(R.id.calculateButton)
    Button calculateButton;
    private Context context = MainActivity.this;
    private String numberOne, numberTwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        ArrayAdapter<CharSequence> arrayAdapter = ArrayAdapter.createFromResource(context, R.array.operations_arrays, R.layout.spinner_item);
        arrayAdapter.setDropDownViewResource(R.layout.simple_spinner_dropdown);
        operationSpinner.setAdapter(arrayAdapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /* For submitting results to API*/
    private void submitResults(){
        numberOne = numberOneEdit.getText().toString().trim();
        numberTwo = numberTwoEdit.getText().toString().trim();
        boolean validNumberOne = isNumberOneValid(numberOne);
        boolean validNumberTwo = isNumberTwoValid(numberTwo);
        if (!validNumberOne || !validNumberTwo) return;

        MathJS math = new MathJS();


    }

    /* Validations */
    private boolean isNumberOneValid(String number){
        if (number.equals("")){
            numberOneEdit.setError("Please Type Number");
            return false;
        }
        return true;
    }

    private boolean isNumberTwoValid(String number){
        if (number.equals("")){
            numberTwoEdit.setError("Please Type Number");
            return false;
        }
        return true;
    }
}
