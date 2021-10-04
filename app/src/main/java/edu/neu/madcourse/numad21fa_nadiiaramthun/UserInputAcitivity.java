package edu.neu.madcourse.numad21fa_nadiiaramthun;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

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

        data.putExtra(Constants.NAME, nameTxt.getText().toString());
        data.putExtra(Constants.URL, urlTxt.getText().toString());
        setResult(RESULT_OK, data);
        super.finish();
    }
}