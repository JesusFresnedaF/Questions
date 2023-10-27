package com.example.questions2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView question, solution;
    Button buttonT, buttonF;
    ImageButton buttonNext, buttonPrev;

    private boolean userAns[];
    private boolean correctAns[];
    public static final int numQuestions = 2;
    private String questions[];
    private int actualQuestion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        userAns = new boolean[numQuestions];
        correctAns = new boolean[numQuestions];
        questions = new String[numQuestions];
        actualQuestion = 0;
        initQuestions();

        setContentView(R.layout.activity_main);

        question = findViewById(R.id.question);
        question.setText(actualQuestion+ ". "+questions[actualQuestion]);

        buttonT = findViewById(R.id.buttonTrue);
        buttonT.setOnClickListener(trueClicked);

        buttonF = findViewById(R.id.buttonFalse);
        buttonF.setOnClickListener(falseClicked);

        buttonNext = findViewById(R.id.buttonNext);
        buttonNext.setOnClickListener(nextClicked);

        buttonPrev = findViewById(R.id.buttonPrev);
        buttonPrev.setOnClickListener(prevClicked);

        solution = findViewById(R.id.solution);

    }

    public void initQuestions(){
        questions[0] = "Hoy es lunes?";
        questions[1] = "Ayer fue jueves?";
        correctAns[0] = false;
        correctAns[1] = true;
    }

    public View.OnClickListener trueClicked = new View.OnClickListener(){
        public void onClick(View v){
            userAns[actualQuestion] = true;
            if(userAns[actualQuestion] == correctAns[actualQuestion]){
                solution.setText("CORRECTO!");
            }
            else {
                solution.setText("INCORRECTO!");
            }
        }
    };
    public View.OnClickListener falseClicked = new View.OnClickListener(){
        public void onClick(View v){
            userAns[actualQuestion] = false;
            if(userAns[actualQuestion] == correctAns[actualQuestion]){
                solution.setText("CORRECTO!");
            }
            else {
                solution.setText("INCORRECTO!");
            }
        }
    };
    public View.OnClickListener nextClicked = new View.OnClickListener(){
        public void onClick(View v){
            actualQuestion = (actualQuestion + 1) % numQuestions;
            question.setText(actualQuestion+ ". "+questions[actualQuestion]);
            solution.setText("");
        }
    };

    public View.OnClickListener prevClicked = new View.OnClickListener(){
        public void onClick(View v){
            actualQuestion = (actualQuestion - 1) % numQuestions;
            if(actualQuestion < 0){
                actualQuestion = numQuestions - 1;
            }
            question.setText(actualQuestion+ ". "+questions[actualQuestion]);
            solution.setText("");
        }
    };


}