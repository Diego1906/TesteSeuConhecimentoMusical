package com.example.android.testeseuconhecimentomusical;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    final String ANSWER_QUESTION_ONE = "RAUL SEIXAS";

    boolean resultQuestionOne;
    boolean resultQuestionTwo;
    boolean resultQuestionThree;
    boolean resultQuestionFour;
    boolean resultQuestionFive;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void reset(View view) {
        EditText editTextQuestionOne = findViewById(R.id.edit_text_question_one);
        editTextQuestionOne.setText("");

        RadioGroup radioGroupQuestionTwo = findViewById(R.id.radio_group_question_two);
        radioGroupQuestionTwo.clearCheck();

        CheckBox checkBoxSentimento = findViewById(R.id.check_box_feeling_question_three);
        checkBoxSentimento.setChecked(false);

        CheckBox checkBoxAndeiSo = findViewById(R.id.check_box_i_walked_alone_question_three);
        checkBoxAndeiSo.setChecked(false);

        CheckBox checkBoxHomemAmarelo = findViewById(R.id.check_box_yellow_man_question_three);
        checkBoxHomemAmarelo.setChecked(false);

        RadioGroup radioGroupQuestionFour = findViewById(R.id.radio_group_question_four);
        radioGroupQuestionFour.clearCheck();

        RadioGroup radioGroupQuestionFive = findViewById(R.id.radio_group_question_five);
        radioGroupQuestionFive.clearCheck();
    }

    public void validateTest(View view) {
        int countPoints = 0;

        EditText editTextQuestionOne = findViewById(R.id.edit_text_question_one);
        String textQuestionOne = editTextQuestionOne.getText().toString().trim();
        resultQuestionOne = textQuestionOne.equalsIgnoreCase(ANSWER_QUESTION_ONE);
        if (resultQuestionOne) {
            countPoints++;
        }

        RadioButton radioButtonDona = findViewById(R.id.radio_button_owner_question_two);
        resultQuestionTwo = radioButtonDona.isChecked();
        if (resultQuestionTwo) {
            countPoints++;
        }

        CheckBox checkBoxSentimento = findViewById(R.id.check_box_feeling_question_three);
        CheckBox checkBoxAndeiSo = findViewById(R.id.check_box_i_walked_alone_question_three);
        CheckBox checkBoxHomemAmarelo = findViewById(R.id.check_box_yellow_man_question_three);
        resultQuestionThree = (checkBoxSentimento.isChecked() && !checkBoxAndeiSo.isChecked() && checkBoxHomemAmarelo.isChecked());
        if (resultQuestionThree) {
            countPoints++;
        }

        RadioButton radioButtonQuestionFour = findViewById(R.id.radio_button_yes_question_four);
        resultQuestionFour = radioButtonQuestionFour.isChecked();
        if (resultQuestionFour) {
            countPoints++;
        }

        RadioButton radioButtonQuestionFive = findViewById(R.id.radio_button_no_question_five);
        resultQuestionFive = radioButtonQuestionFive.isChecked();
        if (resultQuestionFive) {
            countPoints++;
        }

        showResultScreen(countPoints);
    }

    private void showResultScreen(int countPoints) {
        String message = "";
        message += "\n1º " + createMessage(resultQuestionOne);
        message += "\n2º " + createMessage(resultQuestionTwo);
        message += "\n3º " + createMessage(resultQuestionThree);
        message += "\n4º " + createMessage(resultQuestionFour);
        message += "\n5º " + createMessage(resultQuestionFive);

        Toast.makeText(this, String.format("Você acertou %d pergunta(s). Veja o resultado: %s", countPoints, message), Toast.LENGTH_LONG).show();
    }

    private String createMessage(boolean resultQuestion) {
        return resultQuestion ? "Correta" : "Errada";
    }
}
