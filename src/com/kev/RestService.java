package com.kev;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class RestService {

    public static String fetchDataFrom(String restURL) {

        try {

//            URL url = new URL("https://universalis.app/market/5568");
//            URL url = new URL("https://universalis.app/api/extra/stats/least-recently-updated?world=moogle");

            URL url = new URL(restURL);

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            conn.setRequestProperty("Content-Type", "application/json");

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }


            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));

            String output;
            String response = new String();
            System.out.println("Output from Server .... \n");
            while ((output = br.readLine()) != null) {
                response += output;
            }

            conn.disconnect();

            return response;

        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
