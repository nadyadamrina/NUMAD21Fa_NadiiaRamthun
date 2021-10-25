package edu.neu.madcourse.numad21fa_nadiiaramthun;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ServiceActivity extends AppCompatActivity {

    private static final String TAG = "ServiceActivity";

    private EditText txt_numberOfUsers;
    private Spinner spn_gender;
    private List<CheckBox> checkBoxes;

    private Handler textHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);

        txt_numberOfUsers = findViewById(R.id.txt_number);
        getDropdown();
        getCheckBoxes();
    }

    private void getDropdown() {
        spn_gender = findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> staticAdapter = ArrayAdapter.createFromResource(this,
                R.array.genders, android.R.layout.simple_spinner_item);
        staticAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spn_gender.setAdapter(staticAdapter);
    }

    private void getCheckBoxes() {
        checkBoxes = new LinkedList<>();
        checkBoxes.add(findViewById(R.id.checkBox_AU));
        checkBoxes.add(findViewById(R.id.checkBox_BR));
        checkBoxes.add(findViewById(R.id.checkBox_CA));
        checkBoxes.add(findViewById(R.id.checkBox_CH));
        checkBoxes.add(findViewById(R.id.checkBox_DE));
        checkBoxes.add(findViewById(R.id.checkBox_DK));
        checkBoxes.add(findViewById(R.id.checkBox_ES));
        checkBoxes.add(findViewById(R.id.checkBox_FI));
        checkBoxes.add(findViewById(R.id.checkBox_FR));
        checkBoxes.add(findViewById(R.id.checkBox_GB));
        checkBoxes.add(findViewById(R.id.checkBox_IE));
        checkBoxes.add(findViewById(R.id.checkBox_IR));
        checkBoxes.add(findViewById(R.id.checkBox_NL));
        checkBoxes.add(findViewById(R.id.checkBox_NZ));
        checkBoxes.add(findViewById(R.id.checkBox_TR));
        checkBoxes.add(findViewById(R.id.checkBox_US));
    }

    public void requestInfo(View view) {
        Runnable runnable = new RequestInfo();
        new Thread(runnable).start();
    }

    class RequestInfo implements Runnable {

        @Override
        public void run() {
            String urlBase = "https://randomuser.me/api/";

            try {
                HttpURLConnection con = getHttpURLConnection(urlBase);
                con.connect();
                updateUI(con);
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

        private void updateUI(HttpURLConnection con) {
            try {
                String json = getString(con);
                List<LinkedHashMap<String, String>> userMap = getUserMap(json);

                textHandler.post(() -> {

                });

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private List<LinkedHashMap<String, String>> getUserMap(String json) throws IOException {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

            Map<String, Object> map  = objectMapper.readValue(json, new TypeReference<Map<String, Object>>(){});
            ArrayList<LinkedHashMap<String, String>> usersMap = new ArrayList<>();
            for (Object obj : map.values()) {
                usersMap.addAll((ArrayList<LinkedHashMap<String, String>>) obj);
            }
            return usersMap;
        }

        @NonNull
        private String getString(HttpURLConnection con) throws IOException {
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String responseLine;
            StringBuilder content = new StringBuilder();
            while ((responseLine = in.readLine()) != null) {
                content.append(responseLine);
            }
            in.close();

            String json = content.toString();
            return json;
        }

        @NonNull
        private HttpURLConnection getHttpURLConnection(String urlBase) throws IOException {
            String urlString = getUrlFromUserOptions(urlBase);
            URL url = new URL(urlString);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setDoInput(true);
            return con;
        }

        private String getUrlFromUserOptions(String urlBase) {
            StringBuilder stringBuilder = new StringBuilder(urlBase);

            addNumberOfUsersToURL(stringBuilder);
            addGenderToURL(stringBuilder);
            addNationalitiesToURL(stringBuilder);
            stringBuilder.append("&noinfo");
            return stringBuilder.toString();
        }

        private void addNationalitiesToURL(StringBuilder stringBuilder) {
            stringBuilder.append("&nat=");
            List<String> nationalities = checkBoxes
                    .stream()
                    .filter(CompoundButton::isChecked)
                    .map(checkBox -> checkBox.getText().toString())
                    .collect(Collectors.toList());

            stringBuilder.append(String.join(",", nationalities));
        }

        private void addGenderToURL(StringBuilder stringBuilder) {
            stringBuilder.append("&gender=");
            String genderDesired = spn_gender.getSelectedItem().toString();
            if (!genderDesired.equals("all")) {
                stringBuilder.append(genderDesired);
            }
        }

        private void addNumberOfUsersToURL(StringBuilder stringBuilder) {
            stringBuilder.append("?results=");
            int numberOfUsersDesired = Integer.parseInt(txt_numberOfUsers.getText().toString());
            stringBuilder.append(numberOfUsersDesired);
        }
    }

}