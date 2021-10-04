package edu.neu.madcourse.numad21fa_nadiiaramthun;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.android.material.snackbar.Snackbar;

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
        Intent data = new Intent();

        String name = nameTxt.getText().toString();
        String url = urlTxt.getText().toString();

        try {
            new URL(url);
            data.putExtra(Constants.NAME, name);
            data.putExtra(Constants.URL, url);
            setResult(RESULT_OK, data);
            finish();
        } catch (MalformedURLException error) {
            Snackbar.make(view, "Please enter valid URL (ex. http://example.com)", Snackbar.LENGTH_LONG).show();
        }
    }
}