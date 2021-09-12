package edu.neu.madcourse.numad21fa_nadiiaramthun;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onAboutBtnClick(View view) {
        Toast.makeText(view.getContext(),
                "Nadiia Ramthun\nramthun.n@northeastern.edu",
                Toast.LENGTH_LONG)
                .show();
    }
}