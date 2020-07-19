package com.dcodersg.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //Button initializing
    private Button num0Btn;
    private Button num1Btn;
    private Button num2Btn;
    private Button num3Btn;
    private Button num4Btn;
    private Button num5Btn;
    private Button num6Btn;
    private Button num7Btn;
    private Button num8Btn;
    private Button num9Btn;
    private Button clearBtn;
    private Button backspaceBtn;
    private Button divBtn;
    private Button multiBtn;
    private Button subBtn;
    private Button addBtn;
    private Button equalBtn;
    private Button deciBtn;

    //Views initializing
    private TextView calView;
    private TextView historyView;

    //Data Storing Variables

    private Double tempNum;
    private Double answer;
    private char tempOperator;

    //Displays related methods

    private String getDisplayVal(){
        return calView.getText().toString();
    }
    private String getHistoryVal(){
        return historyView.getText().toString();
    }

    private void appendCalView(String val) {
        if (getDisplayVal().equals("0")) {
            calView.setText(val);
        }
        else {
            calView.setText(getDisplayVal()+val);
        }

    }
    private void appendHistoryView(double num,char operator){
        if (getHistoryVal().equals("0")) {
            historyView.setText(Double.toString(tempNum)+"\n"+operator);
        }
        else {
            historyView.setText(historyView.getText()+Double.toString(tempNum)+"\n"+operator);
        }
    }

    private void calculateAnswer(Double num){
        switch(tempOperator){
            case '+':
                answer=answer+num;
                break;
            case  '-':
                answer=answer-num;
                break;
            case 'x':
                answer=answer*num;
                break;
            case '/':
                answer=answer/num;
                break;

        }
    }

    private void update(char operator){
        tempNum= Double.valueOf(getDisplayVal());
        appendHistoryView(tempNum,operator);
        calculateAnswer(Double.valueOf(getDisplayVal()));
        tempOperator=operator;
        calView.setText("0");
    }

    private void resetAll(){
        tempNum=0.0;
        tempOperator='+';
        answer=0.0;
        historyView.setText(R.string.historyViewTxt);
    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Button Declaration
        num0Btn=findViewById(R.id.num0Btn);
        num1Btn=findViewById(R.id.num1Btn);
        num2Btn=findViewById(R.id.num2Btn);
        num3Btn=findViewById(R.id.num3Btn);
        num4Btn=findViewById(R.id.num4Btn);
        num5Btn=findViewById(R.id.num5Btn);
        num6Btn=findViewById(R.id.num6Btn);
        num7Btn=findViewById(R.id.num7Btn);
        num8Btn=findViewById(R.id.num8Btn);
        num9Btn=findViewById(R.id.num9Btn);
        clearBtn=findViewById(R.id.btnClear);
        backspaceBtn=findViewById(R.id.btnBackspace);
        divBtn=findViewById(R.id.btnDiv);
        multiBtn=findViewById(R.id.btnMulti);
        subBtn=findViewById(R.id.btnSub);
        addBtn=findViewById(R.id.btnAdd);
        equalBtn=findViewById(R.id.btnEqual);
        deciBtn=findViewById(R.id.btnDeci);

        //View Declarations
        calView=findViewById(R.id.calView);
        historyView=findViewById(R.id.historyView);


        resetAll();

        //Button Events

        //Num Buttons

        num0Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendCalView("0");
            }
        });

        num1Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendCalView("1");
            }
        });
        num2Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendCalView("2");
            }
        });
        num3Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendCalView("3");
            }
        });
        num4Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendCalView("4");
            }
        });
        num5Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendCalView("5");
            }
        });
        num6Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendCalView("6");
            }
        });
        num7Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendCalView("7");
            }
        });
        num8Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendCalView("8");
            }
        });
        num9Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendCalView("9");
            }
        });

        deciBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendCalView(".");
            }
        });

        // Functional Buttons

        clearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calView.setText("0");
                resetAll();
            }
        });

        backspaceBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (calView.getText().length()==1){
                    calView.setText("0");
                }
                else{
                    calView.setText(calView.getText().subSequence(0,calView.getText().length()-1));
                }

            }

        });

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                update('+');
            }
        });

        subBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                update('-');
            }
        });

        multiBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                update('x');
            }
        });

        divBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                update('/');
            }
        });

        equalBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                update('=');
                calculateAnswer(Double.parseDouble((String) calView.getText()));
                historyView.setText(historyView.getText()+Double.toString(answer)+"\n\n");
                calView.setText(Double.toString(answer));
                resetAll();
            }
        });






    }
}
