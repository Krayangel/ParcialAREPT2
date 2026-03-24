package co.edu.escuelaing.proxy;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@RestController
@RequestMapping("/proxy")
public class ProxyController {

    private static final String[] BASE_URLS = {
        "http://ec2-3-83-14-104.compute-1.amazonaws.com:8080/",
        "http://ec2-44-203-150-96.compute-1.amazonaws.com:8080/"
    };

    private static final String USER_AGENT = "Mozilla/5.0";

    private String get(String path) throws Exception {
        Exception lastException = null;

        for (String baseUrl : BASE_URLS) {
            try {
                URL url = new URL(baseUrl + path);
                HttpURLConnection con = (HttpURLConnection) url.openConnection();
                con.setRequestMethod("GET");
                con.setRequestProperty("User-Agent", USER_AGENT);

                int responseCode = con.getResponseCode();
                System.out.println("GET Response Code :: " + responseCode);

                if (responseCode == HttpURLConnection.HTTP_OK) {
                    try (BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()))) {
                        StringBuilder response = new StringBuilder();
                        String inputLine;
                        while ((inputLine = reader.readLine()) != null) {
                            response.append(inputLine);
                        }
                        return response.toString();
                    }
                } else {
                    throw new Exception("HTTP " + responseCode + " desde " + baseUrl + path);
                }
            } catch (Exception e) {
                lastException = e;
            }
        }

        throw new Exception("No se pudo conectar a ninguna BASE_URL", lastException);
    }

    @GetMapping("/collatz")
    public String collatz(@RequestParam int value) throws Exception {
        return get("math/collatz?value=" + value);
    }
}