package edu.neu.madcourse.numad21fa_nadiiaramthun;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class ServiceActivity extends AppCompatActivity {

    private static final String TAG = "ServiceActivity";
    protected TextView textView;
    private Handler textHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);

        textView = findViewById(R.id.textView2);
    }

    public void requestInfo(View view) {
        Runnable runnable = new RequestInfo();
        new Thread(runnable).start();
    }

    class RequestInfo implements Runnable {

        @Override
        public void run() {
            String urlString = "https://randomuser.me/api/";

            try {
                URL url = new URL(urlString);
                HttpURLConnection con = (HttpURLConnection) url.openConnection();
                con.setRequestMethod("GET");
                con.setDoInput(true);

                con.connect();

                int status = con.getResponseCode();

                textHandler.post(() -> {
                    textView.setText(String.valueOf(status));
                });

                con.disconnect();
            } catch (MalformedURLException e) {
                Log.e(TAG, "MalformedURLException");
                e.printStackTrace();
            } catch (ProtocolException e) {
                e.printStackTrace();
            } catch (IOException e) {
                Log.e(TAG, "IOException sending request");
                e.printStackTrace();
            }

        }
    }
}