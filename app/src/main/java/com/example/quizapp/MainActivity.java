package com.example.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //variable to keep count of right answers
    int count=0;

    public void submitQuiz(View view){
        //made count equal to zero so on resubmitting the answer the score start from zero
        count=0;
        //if statements to check the correct answers
        //and increment the count variable on right answer
        if(checkfirst()){
            count++;
        }
        if(checkSecond())
        {
            count++;
        }
        if(checkThird())
        {
            count++;
        }
        if(checkFourth()){
            count++;
        }
        if(checkFifth()){
            count++;
        }

        if(checkSixth()){
            count++;
        }
        String message="Your score is "+count+"/6";

        Toast toast = Toast.makeText(getApplicationContext(),message,Toast.LENGTH_SHORT);
        toast.show();

    }

    // Method to check the first answer
    boolean checkfirst(){
       RadioButton ans1=(RadioButton) findViewById(R.id.q1a1);
       boolean ans = ans1.isChecked();

       return ans;

    }

    boolean checkSecond(){
        CheckBox c1 = (CheckBox) findViewById(R.id.Mjolnir);
        CheckBox c2 = (CheckBox) findViewById(R.id.StormBreaker);
        CheckBox c3 = (CheckBox) findViewById(R.id.Bifrost);
        CheckBox c4 = (CheckBox) findViewById(R.id.Claw);
        boolean ans1=c1.isChecked();
        boolean ans2=c2.isChecked();
        boolean ans3=c3.isChecked();
        boolean ans4=c4.isChecked();
        if(ans1&&ans2&&!ans3&&!ans4){
            return true;
        }
        else {
            return false;
        }
    }

    boolean checkThird(){
        //stored the original answer in string and then compare it with the users input
        String correctAnswer="timestone";
        EditText editText = (EditText) findViewById(R.id.Dr_Strange_Answer);
        String ans = editText.getText().toString();

        //converted the users input to lower case to check the answer
        ans=ans.toLowerCase();
        //removed all the space in users input so that a space would not generate an error in answer
        ans=ans.replaceAll("\\s","");

        if(ans.compareTo(correctAnswer)==0){
            return true;
        }
        else
        {
            return false;
        }
    }

    boolean checkFourth(){
        RadioButton leader = (RadioButton) findViewById(R.id.Captain);
        if(leader.isChecked()){
            return true;
        }
        else {
            return  false;
        }
    }

    boolean checkFifth(){
        RadioButton shieldDirector = (RadioButton) findViewById(R.id.Fury);
        if(shieldDirector.isChecked()){
            return true;
        }
        else {
            return  false;
        }
    }

    boolean checkSixth(){
        EditText stonesNumber =(EditText) findViewById(R.id.stonesNumber);
        String Stones=stonesNumber.getText().toString();
        String correctAnswer="6";
        if(Stones.compareTo(correctAnswer)==0){
            return true;
        }
        else {
            return false;
        }
    }

}
