package api;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class api {

    public static void main(String[] args) {
        try {

            String apiUrl = "https://my.api.mockaroo.com/mock_api.json";
            URL url = new URL(apiUrl);

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("GET");
            connection.setRequestProperty("X-API-Key", "bc923270");

            int responseCode = connection.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                System.out.println("Response: " + response.toString());

                JSONArray jsonArray = new JSONArray(response.toString());

                String filePath = "C:\\Users\\muhammed.irfan\\OneDrive - ClaySys.CO\\Desktop\\Automation\\Login_\\doctextfile\\emp_emails.txt";

                BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));

                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    String email = jsonObject.getString("email");

                    writer.write(email);
                    writer.newLine();
                }

                writer.close();

                System.out.println("Email has been saved");
            } else {
                System.out.println("GET request failed. Response code: " + responseCode);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}



