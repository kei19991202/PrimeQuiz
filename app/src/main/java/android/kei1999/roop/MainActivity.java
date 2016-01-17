package android.kei1999.roop;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private static final int QUESTION_COUNT = 10;

    TextView textView;
    Random random = new Random();

    int [] questions;
    int point;
    int answerCount;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView)findViewById(R.id.textView);
        questions = new int [QUESTION_COUNT];

        for (int i = 0; i < QUESTION_COUNT; i++) {

            int number = random.nextInt(1000);
            Log.d("Number", "Question" + number);
            questions[i] = number;
        }
//        clear = true;
        point = 0;
        answerCount = 0;

        textView.setText(questions[answerCount] +  "");

    }

    public void maru(View v) {
        boolean answer = true;

        int number = questions[answerCount]; //問題部分の配列をナンバーに代入

        for (int j = 2; j < number; j++) {

            if (number % j ==0) { //numberをiで割り切れたら
                answer = false;
                Log.d("divideNumber",String.valueOf(j));
                break;
            }

        }

        if (answer) {
            Toast.makeText(this, "正解", Toast.LENGTH_SHORT).show();

        }else{
            Toast.makeText(this, "不正解", Toast.LENGTH_SHORT).show();

        }
        if (answer){
            point++;
            Log.d("maru", "正解:" + point);
        }else{
            Log.d("maru", "不正解");
        }

        answerCount++;

        if (answerCount == QUESTION_COUNT) {
            textView.setText(point + "点");

            point = 0;
            answerCount = 0;

            for (int i = 0; i < QUESTION_COUNT; i++) {

                number = random.nextInt(1000);
                Log.d("Number", "Question" + number);
                questions[i] = number;
            }
        }else{
            textView.setText(number + "");
        }

    }

    public void batsu(View v) {
        boolean answer = false;

        int number = questions[answerCount];

        for (int k = 2; k<number; k++) {

            if (number % k ==0) { //numberをiで割り切れたら
                answer = true;
                Log.d("divideNumber",String.valueOf(k));
                break;
            }

        }

        if (answer) {
            Toast.makeText(this, "正解", Toast.LENGTH_SHORT).show();

        }else{
            Toast.makeText(this, "不正解", Toast.LENGTH_SHORT).show();

        }
        if (answer){
            point++;
            Log.d("maru", "正解:" + point);
        }else{
            Log.d("maru", "不正解");
        }

        answerCount++;

        if (answerCount == QUESTION_COUNT) {
            textView.setText(point + "点");

            point = 0;
            answerCount = 0;

            for (int i = 0; i < QUESTION_COUNT; i++) {

                number = random.nextInt(1000);
                Log.d("Number", "Question" + number);
                questions[i] = number;
            }
        }else{
            textView.setText(number + "");
        }


    }
    public void reset(View v) {


    }
}
