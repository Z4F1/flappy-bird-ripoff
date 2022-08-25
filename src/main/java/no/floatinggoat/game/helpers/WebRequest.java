package no.floatinggoat.game.helpers;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 * @author Pelle Pastoor
 * @version 1.0.0
 */
public class WebRequest {
    /**
     * Used for making post requests with JSON data and then returns the response.
     * 
     * @param url       The url to make the post request to.
     * @param jsonData  The json data in string format.
     * @return          The response of the request.
     * @throws IOException
     * @throws InterruptedException
     */
    public static String post(String url, String jsonData) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest req = HttpRequest.newBuilder()
            .uri(URI.create(url))
            .header("Content-Type", "application/json")
            .POST(HttpRequest.BodyPublishers.ofString(jsonData))
            .build();

        HttpResponse<String> res = client.send(req, HttpResponse.BodyHandlers.ofString());

        return res.body();
    }

    /**
     * Used for making get request.
     * 
     * @param url   The url to make the get request to.
     * @return      The response of the request.
     * @throws IOException
     * @throws InterruptedException
     */
    public static String get(String url) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest req = HttpRequest.newBuilder()
            .uri(URI.create(url))
            .header("Content-Type", "application/json")
            .build();

        HttpResponse<String> res = client.send(req, HttpResponse.BodyHandlers.ofString());

        return res.body();
    }
}
