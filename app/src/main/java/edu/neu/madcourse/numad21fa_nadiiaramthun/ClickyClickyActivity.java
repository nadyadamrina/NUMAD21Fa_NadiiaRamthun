package edu.neu.madcourse.numad21fa_nadiiaramthun;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ClickyClickyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clicky_clicky);

        Button buttonA = (Button) findViewById(R.id.btn_A);
        Button buttonB = (Button) findViewById(R.id.btn_B);
        Button buttonC = (Button) findViewById(R.id.btn_C);
        Button buttonD = (Button) findViewById(R.id.btn_D);
        Button buttonE = (Button) findViewById(R.id.btn_E);
        Button buttonF = (Button) findViewById(R.id.btn_F);

        View.OnTouchListener onTouchListener = new MyTouchListener();
        buttonA.setOnTouchListener(onTouchListener);
        buttonB.setOnTouchListener(onTouchListener);
        buttonC.setOnTouchListener(onTouchListener);
        buttonD.setOnTouchListener(onTouchListener);
        buttonE.setOnTouchListener(onTouchListener);
        buttonF.setOnTouchListener(onTouchListener);
    }

    protected class MyTouchListener implements View.OnTouchListener {

        public boolean onTouch(View view, MotionEvent event) {
            switch(view.getId()){
                case R.id.btn_A: {
                    handleButtonTouched(R.string.pressedA, event);
                    break;
                }
                case R.id.btn_B: {
                    handleButtonTouched(R.string.pressedB, event);
                    break;
                }
                case R.id.btn_C: {
                    handleButtonTouched(R.string.pressedC, event);
                    break;
                }
                case R.id.btn_D: {
                    handleButtonTouched(R.string.pressedD, event);
                    break;
                }
                case R.id.btn_E: {
                    handleButtonTouched(R.string.pressedE, event);
                    break;
                }
                case R.id.btn_F: {
                    handleButtonTouched(R.string.pressedF, event);
                    break;
                }
            }
            return false;
        }

        private void handleButtonTouched(int pressedLetter, MotionEvent event) {
            TextView textView = (TextView) findViewById(R.id.txt_info_pressed);
            switch(event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    textView.setText(pressedLetter);
                    break;
                case MotionEvent.ACTION_UP:
                case MotionEvent.ACTION_CANCEL:
                    textView.setText(R.string.pressed);
                    break;
            }
        }
    }

}