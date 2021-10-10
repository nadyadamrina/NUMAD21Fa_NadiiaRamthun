package edu.neu.madcourse.numad21fa_nadiiaramthun;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

import java.text.MessageFormat;

public class LocationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);
        TextView latitudeTxt = findViewById(R.id.txtLatitude);
        TextView longitudeTxt = findViewById(R.id.txtLongitude);

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED
                || shouldShowRequestPermissionRationale(Manifest.permission.ACCESS_FINE_LOCATION)) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
        }

        LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        Location location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        if (location != null) {
            setLocation(latitudeTxt, longitudeTxt, location);
        }
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 10000, 1000, getLocationListener(latitudeTxt, longitudeTxt));
    }

    @NonNull
    private LocationListener getLocationListener(TextView latitudeTxt, TextView longitudeTxt) {
        return location -> {
            setLocation(latitudeTxt, longitudeTxt, location);
        };
    }

    private void setLocation(TextView latitudeTxt, TextView longitudeTxt, Location location) {
        double latitude = location.getLatitude();
        double longitude = location.getLongitude();

        latitudeTxt.setText(MessageFormat.format("Latitude: {0}", latitude));
        longitudeTxt.setText(MessageFormat.format("Longitude: {0}", longitude));
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == 1) {
            String msg;
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                msg = "Permission granted";
            } else {
                msg = "Permission denied";
            }

            Snackbar.make(findViewById(android.R.id.content), msg, Snackbar.LENGTH_LONG).show();
        }
    }
}