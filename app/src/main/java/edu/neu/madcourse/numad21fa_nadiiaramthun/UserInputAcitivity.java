package edu.neu.madcourse.numad21fa_nadiiaramthun;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.net.MalformedURLException;
import java.net.URL;

public class UserInputAcitivity extends AppCompatActivity {

    private EditText nameTxt;
    private EditText urlTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_input);

        nameTxt = findViewById(R.id.txtEditName);
        urlTxt = findViewById(R.id.txtEditUrl);
    }

    public void onClick(View view) {
        finish();
    }

    @Override
    public void finish() {
        Intent data = new Intent();

        String name = nameTxt.getText().toString();
        String url = urlTxt.getText().toString();

        try {
            new URL(url);
            data.putExtra(Constants.NAME, name);
            data.putExtra(Constants.URL, url);
            setResult(RESULT_OK, data);
        } catch (MalformedURLException error) {
            setResult(RESULT_CANCELED);
        }

        super.finish();
    }
}