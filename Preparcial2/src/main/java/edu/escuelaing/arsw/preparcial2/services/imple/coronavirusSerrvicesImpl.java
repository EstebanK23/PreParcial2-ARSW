/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.escuelaing.arsw.preparcial2.services.imple;

import edu.escuelaing.arsw.preparcial2.services.coronavirusServices;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.springframework.stereotype.Service;

/**
 *
 * @author esteb
 */
@Service("coronavirusServiceImpl")
public class coronavirusSerrvicesImpl implements coronavirusServices {

    @Override
    public String getAllCases() throws IOException {
        String USER_AGENT = "Mozilla/5.0";
        String GET_URL = "https://covid-19-coronavirus-statistics.p.rapidapi.com/v1/stats";
        URL obj = new URL(GET_URL);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("x-rapidapi-host", "covid-19-coronavirus-statistics.p.rapidapi.com");
        con.setRequestProperty("x-rapidapi-key", "78147f0124msh155ba38a8e090c5p127994jsn528f1350cf38");

        //The following invocation perform the connection implicitly before getting the code
        int responseCode = con.getResponseCode();
        System.out.println("GET Response Code :: " + responseCode);

        if (responseCode == HttpURLConnection.HTTP_OK) { // success
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {

                response.append(inputLine);
            }
            in.close();

            return response.toString();
        } else {
            return "GET request not worked";
        }

    }
}
