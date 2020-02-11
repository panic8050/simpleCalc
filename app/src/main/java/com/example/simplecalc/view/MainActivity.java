package com.example.simplecalc.view;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.example.simplecalc.R;
import com.example.simplecalc.model.Operation;
import com.example.simplecalc.model.OperationDivide;
import com.example.simplecalc.model.OperationMinus;
import com.example.simplecalc.model.OperationMultiply;
import com.example.simplecalc.model.OperationPlus;
import com.example.simplecalc.utils.NumbersUtils;
import java.util.Arrays;
import java.util.List;
import static com.example.simplecalc.utils.StringConstants.EMPTY_STRING;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView enteredNumber;
    private TextView resultText;

    private Double currentNumber;
    private Double result;
    private Operation operation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnZero:
            case R.id.btnOne:
            case R.id.btnTwo:
            case R.id.btnThree:
            case R.id.btnFour:
            case R.id.btnFive:
            case R.id.btnSix:
            case R.id.btnSeven:
            case R.id.btnEight:
            case R.id.btnNine: {
                enteredNumber.setText(enteredNumber.getText() + ((TextView) v).getText().toString());
                break;
            }
            case R.id.btnMultiply: doOperation(new OperationMultiply()); break;
            case R.id.bntDivision: doOperation(new OperationDivide()); break;
            case R.id.btnPlus: doOperation(new OperationPlus()); break;
            case R.id.btnMinus: doOperation(new OperationMinus()); break;

            case R.id.btnCleanTextView: clear(); break;
            case R.id.btnBackSpace: removeLastNumber(); break;
            case R.id.btnDot: addDot(); break;
            case R.id.btnEquals: calculate(); break;
        }

    }

    private void initViews() {
        enteredNumber = findViewById(R.id.enteredNumbersTextView);
        resultText = findViewById(R.id.finalResultTextView);

        List<View> views = Arrays.asList(
                findViewById(R.id.btnZero),
                findViewById(R.id.btnOne),
                findViewById(R.id.btnTwo),
                findViewById(R.id.btnThree),
                findViewById(R.id.btnFour),
                findViewById(R.id.btnFive),
                findViewById(R.id.btnSix),
                findViewById(R.id.btnSeven),
                findViewById(R.id.btnEight),
                findViewById(R.id.btnNine),
                findViewById(R.id.btnZero),
                findViewById(R.id.btnMultiply),
                findViewById(R.id.bntDivision),
                findViewById(R.id.btnPlus),
                findViewById(R.id.btnMinus),
                findViewById(R.id.btnCleanTextView),
                findViewById(R.id.btnBackSpace),
                findViewById(R.id.btnDot),
                findViewById(R.id.btnEquals)
        );
        for (View view : views) view.setOnClickListener(this);
    }

    private void doOperation(Operation operation){
        currentNumber = Double.valueOf(enteredNumber.getText().toString());
        this.operation = operation;
        enteredNumber.setText(EMPTY_STRING);
    }

    private void clear(){
        enteredNumber.setText("");
        resultText.setText("");
        currentNumber = null;
        result = null;
    }

    private void removeLastNumber(){
        if (!enteredNumber.getText().toString().isEmpty()) {
            String newText = enteredNumber.getText().toString().substring(0, enteredNumber.getText().length() - 1);
            enteredNumber.setText(newText);
        }
    }

    private void addDot(){
        if (!enteredNumber.getText().toString().contains(".")) {
            String str = enteredNumber.getText().toString() + ".";
            enteredNumber.setText(str);
        }
    }

    private void calculate(){
        if (result == null) result = currentNumber;
        result = operation.execute(result, Double.valueOf(enteredNumber.getText().toString()));
        resultText.setText(NumbersUtils.formatNumber(result));
    }

}

