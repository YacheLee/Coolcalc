package com.dentaltw.coolcalc;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class CalcActivity extends Activity {
    TextView resultsText;

    public enum Operation{
        ADD, SUBTRACT, DIVIDE, MULTIPLY, EQUAL
    }
    String runningNumber = "";
    String leftValueStr = "";
    String rightValueStr = "";
    Operation currentOperation;
    int result = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);

        Button oneButton = (Button) findViewById(R.id.oneBtn);
        Button twoButton = (Button) findViewById(R.id.twoBtn);
        Button threeButton = (Button) findViewById(R.id.threeBtn);
        Button fourButton = (Button) findViewById(R.id.fourBtn);
        Button fiveButton = (Button) findViewById(R.id.fiveBtn);
        Button sixButton = (Button) findViewById(R.id.sixBtn);
        Button sevenButton = (Button) findViewById(R.id.sevenBtn);
        Button eightButton = (Button) findViewById(R.id.eightBtn);
        Button nineButton = (Button) findViewById(R.id.nineBtn);
        Button zeroBtn = (Button) findViewById(R.id.zeroBtn);

        ImageButton calcBtn = (ImageButton) findViewById(R.id.calcBtn);
        ImageButton divideBtn = (ImageButton) findViewById(R.id.divideBtn);
        ImageButton multiplyBtn = (ImageButton) findViewById(R.id.multiplyBtn);
        ImageButton subtractBtn = (ImageButton) findViewById(R.id.subtractBtn);
        ImageButton addBtn = (ImageButton) findViewById(R.id.addBtn);

        Button clearBtn = (Button) findViewById(R.id.clearBtn);
        resultsText = (TextView) findViewById(R.id.resultsText);
        resultsText.setText("");

        oneButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                numberPressed(1);
            }
        });

        twoButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                numberPressed(2);
            }
        });

        threeButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                numberPressed(3);
            }
        });

        fourButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                numberPressed(4);
            }
        });

        fiveButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                numberPressed(5);
            }
        });

        sixButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                numberPressed(6);
            }
        });

        sevenButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                numberPressed(7);
            }
        });

        eightButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                numberPressed(8);
            }
        });

        nineButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                numberPressed(9);
            }
        });

        zeroBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                numberPressed(0);
            }
        });

        calcBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                processOperation(Operation.EQUAL);
            }
        });

        divideBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                processOperation(Operation.DIVIDE);
            }
        });

        multiplyBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                processOperation(Operation.MULTIPLY);
            }
        });

        subtractBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                processOperation(Operation.SUBTRACT);
            }
        });

        addBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                processOperation(Operation.ADD);
            }
        });

        clearBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                leftValueStr = "";
                rightValueStr = "";
                result = 0;
                runningNumber = "";
                currentOperation = null;
                resultsText.setText("0");
            }
        });
    }

    void processOperation(Operation operation){
        if(currentOperation!=null){
            if(runningNumber!=""){
                rightValueStr = runningNumber;
                runningNumber = "";

                switch (currentOperation){
                    case ADD:
                        result = Integer.parseInt(leftValueStr) + Integer.parseInt(rightValueStr);
                        break;
                    case SUBTRACT:
                        result = Integer.parseInt(leftValueStr) - Integer.parseInt(rightValueStr);
                        break;
                    case MULTIPLY:
                        result = Integer.parseInt(leftValueStr) * Integer.parseInt(rightValueStr);
                        break;
                    case DIVIDE:
                        result = Integer.parseInt(leftValueStr) / Integer.parseInt(rightValueStr);
                        break;
                }

                leftValueStr = String.valueOf(result);
                resultsText.setText(leftValueStr);
            }
        }
        else{
            leftValueStr = runningNumber;
            runningNumber = "";
        }
        currentOperation = operation;
    }

    void numberPressed(int number){
        runningNumber += String.valueOf(number);
        resultsText.setText(runningNumber);
    }
}