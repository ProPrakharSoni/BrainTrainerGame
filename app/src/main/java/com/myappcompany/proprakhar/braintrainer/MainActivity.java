package com.myappcompany.proprakhar.braintrainer;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    int correctOption,count=0,marks=0;
    CountDownTimer countDownTimer;
    Button button1,button2,button3,button4,playAgain,button;
    TextView time,progress,question,result ;
    Random rand= new Random();
    MediaPlayer sound;
    // GridLayout gridLayo
    public void goe (View view){
        generateNumber();
    //    gridLayout.setVisibility(View.VISIBLE);
        question.setVisibility(View.VISIBLE);
        button1.setVisibility(View.VISIBLE);
        button2.setVisibility(View.VISIBLE);
        button3.setVisibility(View.VISIBLE);
        button4.setVisibility(View.VISIBLE);
        progress.setVisibility(View.VISIBLE);
        result.setVisibility(View.VISIBLE);
        button.setVisibility(View.INVISIBLE);
        button.setEnabled(false);
        timer();
        sound.start();
        }
    public void playAgain (View view){
        result.setVisibility(View.INVISIBLE);
        generateNumber();
        count=0;
        marks=0;
        button1.setEnabled(true);
        button2.setEnabled(true);
        button3.setEnabled(true);
        button4.setEnabled(true);
        timer();
        sound.start();
        progress.setText(Integer.toString(marks)+"/"+Integer.toString(count));
        playAgain.setVisibility(View.INVISIBLE);//when view is invisible then it is not worked by onclick
    }
     public void choose(View view){
         result.setVisibility(View.VISIBLE);
        count=count+1;
         //Log.i("aman",tag);
         if(String.valueOf(correctOption).equals(view.getTag().toString()))
         {
          result.setText("Correct :)");
         marks=marks+1;
         }
         else
          result.setText("Wrong :(");
         progress.setText(Integer.toString(marks)+"/"+Integer.toString(count));
         generateNumber();
     }
    public void timer(){
        time.setVisibility(View.VISIBLE);
        countDownTimer =new CountDownTimer(10050,1000) {
            @Override
            public void onTick(long l) {
                time.setText(String.valueOf(l/1000)+"s");
            }
            @Override
            public void onFinish() {
                time.setText("0s");
                button1.setEnabled(false);
                button2.setEnabled(false);
                button3.setEnabled(false);
                button4.setEnabled(false);
                result.setText("Done!");
                playAgain.setVisibility(View.VISIBLE);
            }
        }.start();
    }
    public void generateNumber (){
        ArrayList<Integer> answer=new ArrayList<Integer>();
        int a =rand.nextInt(21);//it will produce any number between 0&20 (inclusive);
        int b=rand.nextInt(21);
        question.setText(Integer.toString(a)+"+"+Integer.toString(b));
        int temp;
        correctOption =rand.nextInt(4);
        for(int j=0;j<4;j++)
        {
            if(j==correctOption)
                answer.add(a+b);
            else
            {
                temp=rand.nextInt(41);
                while(temp==a+b){
                    temp=rand.nextInt(41);
                };
                answer.add(temp);
            }
        }
        button1.setText(Integer.toString(answer.get(0)));
        button2.setText(Integer.toString(answer.get(1)));
        button3.setText(Integer.toString(answer.get(2)));
        button4.setText(Integer.toString(answer.get(3)));
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    time=findViewById(R.id.textView2);
   // gridLayout =findViewById(R.id.gridLayout);
    question =findViewById(R.id.textView);
    button1=findViewById(R.id.button1);
        button=findViewById(R.id.button);
        button2=findViewById(R.id.button2);
        button3=findViewById(R.id.button3);
        button4=findViewById(R.id.button4);
        progress=findViewById(R.id.rank);
     result=findViewById(R.id.answer);
        //generateNumber();
        playAgain=findViewById(R.id.playAgain);
        sound=MediaPlayer.create(this,R.raw.sound10second);
    }
}
