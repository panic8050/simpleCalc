package com.example.simplecalc;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.sax.EndTextElementListener;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;
import java.util.List;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private double result = 0.0;
    private double currentNumber = 0.0;
    private double firstOperand = 0.0;
    private double secondOperand= 0.0;
    private Operation operation;


    private TextView enteredNumbers;
    private TextView finalResult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        enteredNumbers = findViewById(R.id.enteredNumbersTextView);
        finalResult = findViewById(R.id.finalResultTextView);
        initViews();
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnZero: {
                enteredNumbers.setText(enteredNumbers.getText() + "0");
                break;
            }
            case R.id.btnOne: {
                enteredNumbers.setText(enteredNumbers.getText() + "1");
                break;
            }
            case R.id.btnTwo: {
                enteredNumbers.setText(enteredNumbers.getText() + "2");
                break;
            }
            case R.id.btnThree: {
                enteredNumbers.setText(enteredNumbers.getText() + "3");
                break;
            }
            case R.id.btnFour: {
                enteredNumbers.setText(enteredNumbers.getText() + "4");
                break;
            }
            case R.id.btnFive: {
                enteredNumbers.setText(enteredNumbers.getText() + "5");
                break;
            }
            case R.id.btnSix: {
                enteredNumbers.setText(enteredNumbers.getText() + "6");
                break;
            }
            case R.id.btnSeven: {
                enteredNumbers.setText(enteredNumbers.getText() + "7");
                break;
            }
            case R.id.btnEight: {
                enteredNumbers.setText(enteredNumbers.getText() + "8");
                break;
            }
            case R.id.btnNine: {
                enteredNumbers.setText(enteredNumbers.getText() + "9");
                break;
            }
            case R.id.btnMultiply: {
                currentNumber = Double.valueOf(enteredNumbers.getText().toString());
                operation = new OperationMultiply();
                enteredNumbers.setText("");
                break;
            }
            case R.id.bntDivision: {
                currentNumber = Double.valueOf(enteredNumbers.getText().toString());
                operation = new OperationDivide();
                enteredNumbers.setText("");
                break;
            }
            case R.id.btnPlus: {
                currentNumber = Double.valueOf(enteredNumbers.getText().toString());
                operation = new OperationPlus();
                enteredNumbers.setText("");
                break;
            }
            case R.id.btnMinus: {
                currentNumber = Double.valueOf(enteredNumbers.getText().toString());
                operation = new OperationMinus();
                enteredNumbers.setText("");
                break;
            }
            case R.id.btnCleanTextView: {
                enteredNumbers.setText("");
                finalResult.setText("");
                result = 0;
                currentNumber = 0;
                break;
            }
            case R.id.btnBackSpace: {

                if (!enteredNumbers.getText().toString().isEmpty()) {
                    String newText = enteredNumbers.getText().toString().substring(0, enteredNumbers.getText().length() - 1);
                    enteredNumbers.setText(newText);

                }
                break;

            }
            case R.id.btnDot: {

                if (!enteredNumbers.getText().toString().contains(".")) {
                    String str = enteredNumbers.getText().toString() + ".";
                    enteredNumbers.setText(str);
                }

                break;

            }
            case R.id.btnEquals: {
                result = operation.execute(result, Double.valueOf(enteredNumbers.getText().toString()));
                finalResult.setText(String.valueOf(result));
                break;
            }


        }

    }

    private void initViews() {
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


}

