package com.hugo.geekwars;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;


public class GameActivity extends AppCompatActivity {

    private QuestionLibrary mQuestionLibrary = new QuestionLibrary();

    private TextView mScoreView;
    private TextView mQuestionView;
    private Button mButtonChoice1;
    private Button mButtonChoice2;
    private Button mButtonChoice3;
    private Button mButtonExit;

    private String mAnswer;
    private int mScore = 0;
    private int mQuestionNumber = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        mScoreView = (TextView)findViewById(R.id.score);
        mQuestionView = (TextView)findViewById(R.id.question);
        mButtonChoice1 = (Button)findViewById(R.id.choice1);
        mButtonChoice2 = (Button)findViewById(R.id.choice2);
        mButtonChoice3 = (Button)findViewById(R.id.choice3);
        mButtonExit = (Button)findViewById(R.id.quit);

        updateQuestion();
        //Start of Button Listener for Button1
        mButtonChoice1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                //My logic for Button goes in here

                if (mButtonChoice1.getText() == mAnswer){
                    mScore = mScore + 1;
                    updateScore(mScore);
                    updateQuestion();
                    //This line of code is optiona
                    Toast.makeText(GameActivity.this, "correcto", Toast.LENGTH_SHORT).show();

                }else {
                    Toast.makeText(GameActivity.this, "incorrecto", Toast.LENGTH_SHORT).show();
                    //updateQuestion();
                    validateQuestions();
                }
            }
        });

        //End of Button Listener for Button1

        //Start of Button Listener for Button2
        mButtonChoice2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                //My logic for Button goes in here

                if (mButtonChoice2.getText() == mAnswer){
                    mScore = mScore + 1;
                    updateScore(mScore);
                    updateQuestion();
                    //This line of code is optiona
                    Toast.makeText(GameActivity.this, "correcto", Toast.LENGTH_SHORT).show();

                }else {
                    Toast.makeText(GameActivity.this, "incorrecto", Toast.LENGTH_SHORT).show();
                    //updateQuestion();
                    validateQuestions();
                }
            }
        });

        //End of Button Listener for Button2


        //Start of Button Listener for Button3
        mButtonChoice3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                //My logic for Button goes in here

                if (mButtonChoice3.getText() == mAnswer){
                    mScore = mScore + 1;
                    updateScore(mScore);
                    validateQuestions();
                    //updateQuestion();
                    //This line of code is optiona
                    Toast.makeText(GameActivity.this, "correcto", Toast.LENGTH_SHORT).show();

                }else {
                    Toast.makeText(GameActivity.this, "incorrecto", Toast.LENGTH_SHORT).show();
                    //updateQuestion();
                    validateQuestions();
                }
            }
        });

        //End of Button Listener for Button3


        mButtonExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(GameActivity.this, Main2Activity.class));
            }
        });

    }


    private void updateQuestion(){
        mQuestionView.setText(mQuestionLibrary.getQuestion(mQuestionNumber));
        mButtonChoice1.setText(mQuestionLibrary.getChoice1(mQuestionNumber));
        mButtonChoice2.setText(mQuestionLibrary.getChoice2(mQuestionNumber));
        mButtonChoice3.setText(mQuestionLibrary.getChoice3(mQuestionNumber));

        mAnswer = mQuestionLibrary.getCorrectAnswer(mQuestionNumber);
        mQuestionNumber++;
    }


    private void updateScore(int point) {
        mScoreView.setText("" + mScore);
    }



    private void validateQuestions() {
        //perform check before you update the question
        if (mQuestionNumber == QuestionLibrary.numQuestions) {
            Intent i = new Intent(GameActivity.this, ResultActivity.class);
            Bundle bundle = new Bundle();
            bundle.putInt("finalScore", mScore);
            i.putExtras(bundle);
            GameActivity.this.finish();
            startActivity(i);
            //startActivity(new Intent(GameActivity.this, ResultActivity.class));
        } else {
            updateQuestion();
        }
    }

}
