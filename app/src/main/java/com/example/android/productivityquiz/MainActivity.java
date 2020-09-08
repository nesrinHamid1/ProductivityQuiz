package com.example.android.productivityquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * all the graphics used in the app are Pablo by Dmitry Nikulnikov from https://icons8.com
 **/

public class MainActivity extends AppCompatActivity {
    // the var for the quiz score
     private int score;
    // the var for the quiz page numbers
    private int questionsPageNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //this is the function for lets see button where it take you for the first question
    public void letsSee(View view) {
        pageLayout(questionsPageNumber);
    }

    //this is the function to set the page layout by taking the pageNumber
    public void pageLayout(int pageNumber) {
        RelativeLayout mainLayout = findViewById(R.id.main_layout);

        ImageView background = findViewById(R.id.backgroundView);
        ImageView questionImage = findViewById(R.id.question_image);

        TextView titleText = findViewById(R.id.title_text);
        TextView questionText = findViewById(R.id.question_text);

        EditText EditText = findViewById(R.id.editText_text);

        RadioGroup radioGroup1 = findViewById(R.id.should_you_multitask);

        RadioButton yes = findViewById(R.id.yeah);
        RadioButton no = findViewById(R.id.no);

        CheckBox checkBox1 = findViewById(R.id.checkbox1);
        CheckBox checkBox2 = findViewById(R.id.checkbox2);
        CheckBox checkBox3 = findViewById(R.id.checkbox3);
        CheckBox checkBox4 = findViewById(R.id.checkbox4);

        Button letsSeeButton = findViewById(R.id.LetsSeeButton);
        Button nextButton = findViewById(R.id.nextButton);
        Button submitButton = findViewById(R.id.SubmitButton);

        // page number 1 of the quiz layout
        if (pageNumber == 0) {
            letsSeeButton.setVisibility(View.GONE);
            nextButton.setVisibility(View.VISIBLE);
            submitButton.setVisibility(View.VISIBLE);
            submitButton.setText(R.string.submit);
            nextButton.setText(R.string.next);
            mainLayout.setBackgroundColor(Color.parseColor("#F9D9EB"));
            background.setVisibility(View.GONE);
            titleText.setVisibility(View.GONE);
            questionImage.setImageResource(R.drawable.boy5);
            questionText.setText(R.string.question1);
            EditText.setVisibility(View.VISIBLE);
            questionsPageNumber++;
            return;
        }

        // page number 2 of the quiz layout
        if (pageNumber == 1) {
            mainLayout.setBackgroundColor(Color.parseColor("#8BB5A8"));
            questionImage.setImageResource(R.drawable.boy1);
            questionText.setText(R.string.question2);
            EditText.setVisibility(View.GONE);
            radioGroup1.setVisibility(View.VISIBLE);
            questionsPageNumber++;
            return;
        }

        // page number 3 of the quiz layout
        if (pageNumber == 2) {
            mainLayout.setBackgroundColor(Color.parseColor("#C9D9F8"));
            questionImage.setImageResource(R.drawable.girl2);
            questionText.setText(R.string.question3);
            no.setChecked(false);
            yes.setChecked(false);
            radioGroup1.setVisibility(View.VISIBLE);
            yes.setText(R.string.yes);
            no.setText(R.string.no);
            questionsPageNumber++;
            return;
        }

        // page number 4 of the quiz layout
        if (pageNumber == 3) {
            mainLayout.setBackgroundColor(Color.parseColor("#FCF0E3"));
            questionImage.setImageResource(R.drawable.boy6);
            questionText.setText(R.string.question4);
            radioGroup1.setVisibility(View.GONE);
            checkBox1.setVisibility(View.VISIBLE);
            checkBox2.setVisibility(View.VISIBLE);
            checkBox3.setVisibility(View.VISIBLE);
            checkBox4.setVisibility(View.VISIBLE);
            questionsPageNumber++;
            return;
        }

        // page number 5 of the quiz layout
        if (pageNumber == 4) {
            mainLayout.setBackgroundColor(Color.parseColor("#F3C6BD"));
            questionImage.setImageResource(R.drawable.girl1);
            questionText.setText(R.string.question5);
            checkBox1.setVisibility(View.GONE);
            checkBox2.setVisibility(View.GONE);
            checkBox3.setVisibility(View.GONE);
            checkBox4.setVisibility(View.GONE);
            EditText.setVisibility(View.VISIBLE);
            EditText.setText("");
            questionsPageNumber++;
            return;
        }

        // page number 6 of the quiz layout (last page of the quiz)
        if (pageNumber == 5) {
            mainLayout.setBackgroundColor(Color.parseColor("#F58495"));
            questionImage.setImageResource(R.drawable.boy2);
            questionText.setText(R.string.question6);
            EditText.setVisibility(View.GONE);
            checkBox1.setChecked(false);
            checkBox2.setChecked(false);
            checkBox3.setChecked(false);
            checkBox4.setChecked(false);
            checkBox1.setVisibility(View.VISIBLE);
            checkBox2.setVisibility(View.VISIBLE);
            checkBox3.setVisibility(View.VISIBLE);
            checkBox4.setVisibility(View.VISIBLE);
            checkBox1.setText(R.string.question6Answare1);
            checkBox2.setText(R.string.question6Answare2);
            checkBox3.setText(R.string.question6Answare3);
            checkBox4.setText(R.string.question6Answare4);
            questionsPageNumber++;
            return;
        }

        // page number 7 of the quiz layout where the score is shown
        if (pageNumber == 6) {

            if (score >= 3) {
                mainLayout.setBackgroundColor(Color.parseColor("#FCF0E3"));
                questionImage.setImageResource(R.drawable.boy3);
                titleText.setVisibility(View.VISIBLE);
                titleText.setText(R.string.Congratulations);
                questionText.setText(R.string.winnigText);
                checkBox1.setVisibility(View.GONE);
                checkBox2.setVisibility(View.GONE);
                checkBox3.setVisibility(View.GONE);
                checkBox4.setVisibility(View.GONE);
                nextButton.setVisibility(View.GONE);
                submitButton.setVisibility(View.GONE);
            }

            if (score < 3) {
                mainLayout.setBackgroundColor(Color.parseColor("#FCF0E3"));
                questionImage.setImageResource(R.drawable.girl3);
                titleText.setVisibility(View.VISIBLE);
                titleText.setText(R.string.losingText);
                questionText.setText(String.format("%s%s%s%s", getString(R.string.tip), getString(R.string.booksName1), getString(R.string.booksName2), getString(R.string.booksName3)));
                checkBox1.setVisibility(View.GONE);
                checkBox2.setVisibility(View.GONE);
                checkBox3.setVisibility(View.GONE);
                checkBox4.setVisibility(View.GONE);
                nextButton.setVisibility(View.GONE);
                submitButton.setVisibility(View.GONE);
            }
        }
    }

    // this is the function for the quiz score
    public void score(int pageNumber) {

        EditText editText = findViewById(R.id.editText_text);

        RadioButton yes = findViewById(R.id.yeah);

        CheckBox checkBox1 = findViewById(R.id.checkbox1);
        CheckBox checkBox2 = findViewById(R.id.checkbox2);
        CheckBox checkBox3 = findViewById(R.id.checkbox3);
        CheckBox checkBox4 = findViewById(R.id.checkbox4);

        if (pageNumber == 1) {
            String value = editText.getText().toString();
            // the var that contain the answer for question number 1
            String answer = "that 80% of your results come from 20% of your efforts";
            if (value.equalsIgnoreCase(answer))
                score = score + 1;
        }

        if (pageNumber == 2) {
            if (yes.isChecked())
                score = score + 1;
        }

        if (pageNumber == 3) {
            if (yes.isChecked())
                score = score + 1;
        }

        if (pageNumber == 4) {
            if (checkBox1.isChecked() && checkBox3.isChecked() && checkBox4.isChecked() && !checkBox2.isChecked())
                score = score + 1;
        }

        if (pageNumber == 5) {
            String value = editText.getText().toString();
            // the var that contain the answer for question number 5
            String answer2 = "Activities performed in a state of distraction-free concentration that push your cognitive capabilities to their limits";
            if (value.equalsIgnoreCase(answer2))
                score = score + 1;
        }

        if (pageNumber == 6) {

            if (score >= 3) {
                if (checkBox3.isChecked() && checkBox4.isChecked() && !checkBox1.isChecked() && !checkBox2.isChecked())
                    score = score + 1;
            }

            if (score < 3) {
                if (checkBox3.isChecked() && checkBox4.isChecked() && !checkBox1.isChecked() && !checkBox2.isChecked())
                    score = score + 1;
            }
        }
    }

    //this is a function for the next button
    public void nextQuestion(View view) {
        pageLayout(questionsPageNumber);
    }

    //this is a function for the Submit button
    public void Submit(View view) {
        score(questionsPageNumber);
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;
        if (score >= 3){
            CharSequence text = "your score is " + score + "\n You are doing amazing, good job 💪🏻";
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        } else {
            CharSequence text = "your score is " + score+ "\n keep going! you got this ✨";
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
    }
}