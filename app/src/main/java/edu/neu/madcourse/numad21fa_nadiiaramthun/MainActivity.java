package edu.neu.madcourse.numad21fa_nadiiaramthun;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_about: {
                View parentLayout = findViewById(android.R.id.content);
                Snackbar.make(parentLayout, "Nadiia Ramthun\nramthun.n@northeastern.edu", Snackbar.LENGTH_LONG).show();
                break;
            }
            case R.id.btn_clicky_clicky: {
                openClickyClickyActivity();
                break;
            }
            case R.id.btn_link_collector: {
                openLinkCollectorActivity();
                break;
            }
        }
    }

    public void openLinkCollectorActivity() {
        Intent intent = new Intent(this, LinkCollectorActivity.class);
        startActivity(intent);
    }

    public void openClickyClickyActivity() {
        Intent intent = new Intent(this, ClickyClickyActivity.class);
        startActivity(intent);
    }
}